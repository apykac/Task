package ru.tomsk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import ru.tomsk.db.dao.OrganizationDao;
import ru.tomsk.pojo.Organization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {
    private OrganizationDao organizationDao;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao organizationDao) {
        this.organizationDao = organizationDao;
    }

    @Override
    public List<String> checkParam(MultiValueMap<String, String> incParam) {
        List<String> errorList = new ArrayList<>();
        if (incParam.get("inn") != null)
            if (incParam.get("inn").get(0).isEmpty() || !isOnlyNumber(incParam.get("inn").get(0)))
                errorList.add("Incorrect INN");

        if (incParam.get("ogrn") != null)
            if (incParam.get("ogrn").get(0).isEmpty() || !isOnlyNumber(incParam.get("ogrn").get(0)))
                errorList.add("Incorrect OGRN");

        if ((incParam.get("name") != null) && incParam.get("name").get(0).isEmpty())
            errorList.add("Name of organization is Empty");

        if ((incParam.get("name") != null) && incParam.get("name").get(0).isEmpty())
            errorList.add("Address of organization is Empty");

        return errorList;
    }

    private boolean isOnlyNumber(String s) {
        return s.matches("\\d+");
    }

    @Override
    public boolean add(MultiValueMap<String, String> incParam) {
        if ((incParam == null) || incParam.isEmpty()) return false;
        return organizationDao.add(new Organization(
                Integer.parseInt(incParam.get("inn").get(0)),
                Integer.parseInt(incParam.get("ogrn").get(0)),
                incParam.get("name").get(0),
                incParam.get("name").get(0)
        ));
    }

    @Override
    public List<Organization> getById(long id) {
        if (id < 1) return new ArrayList<>();
        Organization organization = organizationDao.getById(id);
        return new ArrayList<>(Collections.singletonList(organization));
    }

    @Override
    public List<Organization> getByInn(int inn) {
        if (inn == 0) return new ArrayList<>();
        return organizationDao.getByInn(inn);
    }

    @Override
    public List<Organization> getByOgrn(int ogrn) {
        if (ogrn == 0) return new ArrayList<>();
        return organizationDao.getByOgrn(ogrn);
    }

    @Override
    public List<Organization> getByName(String name) {
        if ((name == null) || name.isEmpty()) return new ArrayList<>();
        return organizationDao.getByName(name);
    }

    @Override
    public List<Organization> getByAddress(String address) {
        if ((address == null) || address.isEmpty()) return new ArrayList<>();
        return organizationDao.getByAddress(address);
    }
}
