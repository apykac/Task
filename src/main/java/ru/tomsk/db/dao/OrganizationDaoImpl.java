package ru.tomsk.db.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.tomsk.db.connection.ConnectionManager;
import ru.tomsk.pojo.Organization;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrganizationDaoImpl implements OrganizationDao {
    private static final Logger logger = Logger.getLogger(OrganizationDaoImpl.class);
    private String sqlexception = "SQLException: ";
    private ConnectionManager connectionManager;

    @Autowired
    public OrganizationDaoImpl(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public Organization getById(long id) {
        if (id < 1) return null;
        Organization org = null;
        logger.info("start to find Org by id");
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM task.organizations WHERE id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                org = new Organization();
                OrganizationHelper.setter(org, resultSet);
            }
        } catch (SQLException e) {
            logger.error(sqlexception + e.getMessage());
        }
        logger.info("getting Org successfully: " + org);
        return org;
    }

    @Override
    public boolean add(Organization org) {
        if (org == null) return false;
        logger.info("start to add Org: " + org);
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO task.organizations (inn, ogrn, name, address)" +
                            " VALUES (?, ?, ?, ?)");
            preparedStatement.setInt(1, org.getInn());
            preparedStatement.setInt(2, org.getOgrn());
            preparedStatement.setString(3, org.getName());
            preparedStatement.setString(4, org.getAddress());
            preparedStatement.execute();
        } catch (SQLException e) {
            logger.error(sqlexception + e.getMessage());
            return false;
        }
        logger.info("adding Org is successfully");
        return true;
    }

    @Override
    public List<Organization> getByInn(int inn) {
        List<Organization> result = new ArrayList<>();
        if (inn == 0) return result;
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM organizations WHERE inn = ?");
            preparedStatement.setInt(1, inn);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Organization organization = new Organization();
                OrganizationHelper.setter(organization, resultSet);
                result.add(organization);
            }
        } catch (SQLException e) {
            logger.error(sqlexception + e.getMessage());
            return new ArrayList<>();
        }
        return result;
    }

    @Override
    public List<Organization> getByOgrn(int ogrn) {
        List<Organization> result = new ArrayList<>();
        if (ogrn == 0) return result;
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM organizations WHERE ogrn = ?");
            preparedStatement.setInt(1, ogrn);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Organization organization = new Organization();
                OrganizationHelper.setter(organization, resultSet);
                result.add(organization);
            }
        } catch (SQLException e) {
            logger.error(sqlexception + e.getMessage());
            return new ArrayList<>();
        }
        return result;
    }

    @Override
    public List<Organization> getByName(String name) {
        List<Organization> result = new ArrayList<>();
        if ((name == null) || name.isEmpty()) return result;
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM organizations WHERE name LIKE ?");
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Organization organization = new Organization();
                OrganizationHelper.setter(organization, resultSet);
                result.add(organization);
            }
        } catch (SQLException e) {
            logger.error(sqlexception + e.getMessage());
            return new ArrayList<>();
        }
        return result;
    }

    @Override
    public List<Organization> getByAddress(String address) {
        List<Organization> result = new ArrayList<>();
        if ((address == null) || address.isEmpty()) return result;
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM organizations WHERE address LIKE ?");
            preparedStatement.setString(1, "%" + address + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Organization organization = new Organization();
                OrganizationHelper.setter(organization, resultSet);
                result.add(organization);
            }
        } catch (SQLException e) {
            logger.error(sqlexception + e.getMessage());
            return new ArrayList<>();
        }
        return result;
    }

    @Override
    public List<Organization> getAll() {
        List<Organization> result = new ArrayList<>();
        try (Connection connection = connectionManager.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM organizations");
            while (resultSet.next()) {
                Organization organization = new Organization();
                OrganizationHelper.setter(organization, resultSet);
                result.add(organization);
            }
        } catch (SQLException e) {
            logger.error(sqlexception + e.getMessage());
            return new ArrayList<>();
        }
        return result;
    }

}
