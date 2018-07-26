package ru.tomsk.services;

import org.springframework.util.MultiValueMap;
import ru.tomsk.pojo.Organization;

import java.util.List;

public interface OrganizationService {
    List<String> checkParam(MultiValueMap<String, String> incParam);

    boolean add(MultiValueMap<String, String> incParam);

    List<Organization> getById(long id);

    List<Organization> getByInn(int inn);

    List<Organization> getByOgrn(int ogrn);

    List<Organization> getByName(String name);

    List<Organization> getByAddress(String address);
}
