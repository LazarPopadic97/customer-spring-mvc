/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.application.customerspringmvc.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import rs.fon.silab.application.customerspringmvc.domain.City;
import rs.fon.silab.application.customerspringmvc.dto.CityDto;
import rs.fon.silab.application.customerspringmvc.service.CityService;

/**
 *
 * @author korisnik
 */
@Controller
@RequestMapping(path = "/city")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public String getAll(HttpServletRequest request) throws Exception {
        System.out.println("rs.fon.silab.application.customerspringmvc.controller.CityController.getAll()");
        List<CityDto> cities = cityService.getAll();
        request.setAttribute("cities", cities);
        return "city-list";
    }

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String add() {
        System.out.println("rs.fon.silab.application.customerspringmvc.controller.CityController.add()");
        return "city-add";
    }

    @RequestMapping(path = "/add-model", method = RequestMethod.GET)
    public String addModel(HttpServletRequest request) {
        request.setAttribute("cityDto", new CityDto(0L, "N/A"));
        return "city-add-model";
    }

    /*
    @RequestMapping(method = RequestMethod.POST)
    public String save(HttpServletRequest request) {
        System.out.println("==============save=================");
        try {
            Long cityCode = Long.parseLong(request.getParameter("code"));
            String cityName = request.getParameter("name");
            System.out.println(cityCode + " " + cityName);
            request.setAttribute("successMessage", "Grad uspesno sacuvan");
            return "city-list";
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            request.setAttribute("errorMessage", "Grad nije sacuvan, proverite unete podatke");
            return "city-add";
        }

    }*/
    @RequestMapping(method = RequestMethod.POST)
    public String save(HttpServletRequest request,
            @RequestParam(name = "code") String code,
            @RequestParam(name = "name") String name) {
        System.out.println("==============save=================");
        try {
            Long cityCode = Long.parseLong(code);
            System.out.println(cityCode + " " + name);
            request.setAttribute("successMessage", "Grad uspesno sacuvan");

            return "city-list";
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            request.setAttribute("errorMessage", "Grad nije sacuvan, proverite unete podatke");
            return "city-add";
        }

    }

    @RequestMapping(path = "/save-object", method = RequestMethod.POST)
    public String saveObject(HttpServletRequest request,
            CityDto cityDto) {
        System.out.println("==============save=================");
        try {
            System.out.println(cityDto);
            //sacuvaj grad
            cityService.save(cityDto);

            request.setAttribute("successMessage", "Grad uspesno sacuvan");
            
            return "city-add";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Grad nije sacuvan, proverite unete podatke");
            return "city-add";
        }
    }

    @RequestMapping(path = "/showFormForUpdate", method = RequestMethod.GET)
    public String showFormForUpdate(@RequestParam("cityCode") Long cityCode,
            HttpServletRequest request) {

        System.out.println(cityCode);
        CityDto city = cityService.getByCode(cityCode);

        request.setAttribute("cityDto", city);

        return "city-add-model";
    }

    @RequestMapping(path = "/delete", method = RequestMethod.GET)
    public String deleteCity(@RequestParam("cityCode") Long cityCode, HttpServletRequest request) throws Exception {

        cityService.deleteCity(cityCode);
        List<CityDto> cities = cityService.getAll();
        request.setAttribute("cities", cities);
        return "city-list";
    }
}
