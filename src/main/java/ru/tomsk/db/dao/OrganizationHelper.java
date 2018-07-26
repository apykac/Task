package ru.tomsk.db.dao;

import ru.tomsk.pojo.Organization;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrganizationHelper {
    private OrganizationHelper() {
    }

    public static void setter(Organization organization, ResultSet resultSet) throws SQLException {
        organization.setId(resultSet.getLong("id"));
        organization.setInn(resultSet.getInt("inn"));
        organization.setOgrn(resultSet.getInt("ogrn"));
        organization.setName(resultSet.getString("name"));
        organization.setAddress(resultSet.getString("address"));
    }
}
