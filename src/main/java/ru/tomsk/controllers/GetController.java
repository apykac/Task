package ru.tomsk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.tomsk.pojo.Organization;
import ru.tomsk.services.OrganizationService;

import java.util.List;

@Controller
@RequestMapping("/method/get_organization")
public class GetController {
    private List<String> errorList;
    private List<Organization> result;
    private OrganizationService organizationService;

    @Autowired
    public GetController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @RequestMapping(value = "/by_id", method = RequestMethod.GET)
    public String getByIdGet(Model model) {
        model.addAttribute("type", "id");
        return "getList";
    }

    @RequestMapping(value = "/by_inn", method = RequestMethod.GET)
    public String getByInnGet(Model model) {
        model.addAttribute("type", "inn");
        return "getList";
    }

    @RequestMapping(value = "/by_ogrn", method = RequestMethod.GET)
    public String getByOgrnGet(Model model) {
        model.addAttribute("type", "ogrn");
        return "getList";
    }

    @RequestMapping(value = "/by_name", method = RequestMethod.GET)
    public String getByNameGet(Model model) {
        model.addAttribute("type", "name");
        return "getList";
    }

    @RequestMapping(value = "/by_address", method = RequestMethod.GET)
    public String getByAddressGet(Model model) {
        model.addAttribute("type", "address");
        return "getList";
    }

    @RequestMapping(value = "/by_id/list", method = RequestMethod.POST)
    public String getByIdPost(@RequestBody MultiValueMap<String, String> incParam, Model model) {
        if (isError(incParam, model, "id")) return getByIdGet(model);
        result = organizationService.getById(Integer.parseInt(incParam.get("id").get(0)));
        return finalSetter(model, "/by_id");
    }

    @RequestMapping(value = "/by_inn/list", method = RequestMethod.POST)
    public String getByInnPost(@RequestBody MultiValueMap<String, String> incParam, Model model) {
        if (isError(incParam, model, "inn")) return getByInnGet(model);
        result = organizationService.getByInn(Integer.parseInt(incParam.get("inn").get(0)));
        return finalSetter(model, "/by_inn");
    }

    @RequestMapping(value = "/by_ogrn/list", method = RequestMethod.POST)
    public String getByOgrnPost(@RequestBody MultiValueMap<String, String> incParam, Model model) {
        if (isError(incParam, model, "ogrn")) return getByOgrnGet(model);
        result = organizationService.getByOgrn(Integer.parseInt(incParam.get("ogrn").get(0)));
        return finalSetter(model, "/by_ogrn");
    }

    @RequestMapping(value = "/by_name/list", method = RequestMethod.POST)
    public String getByNamePost(@RequestBody MultiValueMap<String, String> incParam, Model model) {
        if (isError(incParam, model, "name")) return getByNameGet(model);
        result = organizationService.getByName(incParam.get("name").get(0));
        return finalSetter(model, "/by_name");
    }

    @RequestMapping(value = "/by_address/list", method = RequestMethod.POST)
    public String getByAddressPost(@RequestBody MultiValueMap<String, String> incParam, Model model) {
        if (isError(incParam, model, "address")) return getByAddressGet(model);
        result = organizationService.getByAddress(incParam.get("address").get(0));
        return finalSetter(model, "/by_address");
    }

    private boolean isError(MultiValueMap<String, String> incParam, Model model, String param) {
        errorList = organizationService.checkParam(incParam);
        if (incParam.get(param).get(0).isEmpty()) errorList.add("Value is emty");
        if (!errorList.isEmpty()) {
            model.addAttribute("errorList", errorList);
            return true;
        }
        return false;
    }

    private String finalSetter(Model model, String backPage) {
        model.addAttribute("list", result);
        model.addAttribute("backPage", backPage);
        return "showList";
    }
}
