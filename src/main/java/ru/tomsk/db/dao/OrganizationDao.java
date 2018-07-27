package ru.tomsk.db.dao;

import ru.tomsk.pojo.Organization;

import java.util.List;

public interface OrganizationDao {
    Organization getById(long id);

    boolean add(Organization org);

    List<Organization> getByInn(int inn);

    List<Organization> getByOgrn(int ogrn);

    List<Organization> getByName(String name);

    List<Organization> getByAddress(String address);

    List<Organization> getAll();
}
