package ru.tomsk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.tomsk.services.OrganizationService;

import java.util.List;

@Controller
@RequestMapping("/method")
public class AddController {
    private OrganizationService organizationService;

    @Autowired
    public AddController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @RequestMapping(value = "/add_organization", method = RequestMethod.GET)
    public String addOrganizationGet(Model model) {
        return "addOrganization";
    }

    @RequestMapping(value = "/add_organization", method = RequestMethod.POST)
    public String addOrganizationPost(@RequestBody MultiValueMap<String, String> incParam, Model model) {
        List<String> errorList = organizationService.checkParam(incParam);
        if (!errorList.isEmpty()) {
            model.addAttribute("errorList", errorList);
            model.addAttribute("isSuccess", false);
        } else {
            tryToAddOrg(incParam, model, errorList);
        }
        return addOrganizationGet(model);
    }

    private void tryToAddOrg(MultiValueMap<String, String> incParam, Model model, List<String> errorList) {
        boolean isAddSuccess = organizationService.add(incParam);
        if (!isAddSuccess) {
            errorList.add("Error by DAO");
            model.addAttribute("isSuccess", false);
        } else model.addAttribute("isSuccess", true);
        model.addAttribute(errorList);
    }
}
