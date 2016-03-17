package com.example.callcenter.controller;

import com.example.callcenter.form.Orders.All;
import com.example.callcenter.form.UserForm;
import com.example.callcenter.model.CityModel;
import com.example.callcenter.model.StreetModel;
import com.example.callcenter.model.UserModel;
import com.example.callcenter.service.CityService;
import com.example.callcenter.service.StreetService;
import com.example.callcenter.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Slf4j
@Controller
@RequestMapping("")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CityService cityService;

    @Autowired
    private StreetService streetService;

    @RequestMapping("")
    public String list(
            @PageableDefault(size = 100, sort = {"name", "surname", "fatherName"})
            Pageable pageable,
            Model model
    ) {
        model.addAttribute("data", userService.findAll(pageable));
        return "user/list";
    }

    @RequestMapping(value = "create", method = GET)
    public String create(Model model) {

        model.addAttribute("title", "Create");
        model.addAttribute("id", null);
        model.addAttribute("form", new UserForm());

        return "user/form";
    }

    @RequestMapping(value = "create", method = POST)
    public String create(
            @ModelAttribute("form")
            @Validated(All.class)
            UserForm form,
            BindingResult bindingResult,
            Model model
    ) {
        if (!bindingResult.hasErrors()) {
            UserModel userModel = new UserModel();

            fillModel(userModel, form);

            userService.save(userModel);

            return "redirect:/#" + userModel.getId();
        }

        model.addAttribute("title", "Create");
        model.addAttribute("id", null);

        return "user/form";
    }

    @RequestMapping(value = "update", method = GET)
    public String update(
            @ModelAttribute("id")
            Long id,
            Model model
    ) {
        UserModel userModel = userService.findOne(id);
        if (model == null) {
            return "redirect:/";
        }

        model.addAttribute("form", fillForm(userModel));

        model.addAttribute("title", "Update");

        return "user/form";
    }

    @RequestMapping(value = "update", method = POST)
    public String update(
            @ModelAttribute("id")
            Long id,
            @ModelAttribute("form")
            @Validated(All.class)
            UserForm form,
            BindingResult bindingResult,
            Model model
    ) {
        UserModel userModel = userService.findOne(id);
        if (userModel == null) {
            return "redirect:/";
        }

        if (!bindingResult.hasErrors()) {
            fillModel(userModel, form);

            userService.save(userModel);

            return "redirect:/#" + userModel.getId();
        }

        model.addAttribute("title", "Update");

        return "user/form";
    }

    @RequestMapping("delete")
    public String delete(Long id) {
        if (id != null) {
            UserModel userModel = userService.findOne(id);
            if (userModel != null) {
                userService.delete(userModel);
            }
        }

        return "redirect:/";
    }

    private void fillModel(UserModel model, UserForm form) {
        model.setName(form.getName());
        model.setSurname(form.getSurname());
        model.setFatherName(form.getFatherName());
        model.setBirthDate(form.getBirthDate());
        model.setPhone(form.getPhone());

        CityModel cityModel = cityService.findByTitle(form.getCity());
        if (cityModel == null) {
            cityModel = new CityModel();
            cityModel.setTitle(form.getCity());
            cityService.save(cityModel);
        }

        StreetModel streetModel = streetService.findByCityIdAndTitle(cityModel.getId(), form.getStreet());
        if (streetModel == null) {
            streetModel = new StreetModel();
            streetModel.setCity(cityModel);
            streetModel.setTitle(form.getStreet());
            streetService.save(streetModel);
        }

        model.setStreet(streetModel);
    }

    private UserForm fillForm(UserModel model) {
        UserForm form = new UserForm();

        form.setName(model.getName());
        form.setSurname(model.getSurname());
        form.setFatherName(model.getFatherName());
        form.setBirthDate(model.getBirthDate());
        form.setPhone(model.getPhone());
        form.setCity(model.getStreet().getCity().getTitle());
        form.setStreet(model.getStreet().getTitle());

        return form;
    }
}
