package com.mycompany.carbonspringmvcapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.mycompany.carbonspringmvcapp.dao.CarbonDao;
import com.mycompany.carbonspringmvcapp.model.Carbon;

@Controller
public class CarbonController {

    CarbonDao dao = new CarbonDao();

    // Home Page
    @RequestMapping("/")
    public String home() {
        return "index";
    }

    // Save Record
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("carbon") Carbon c) {

        dao.save(c);

        return "redirect:/view";
    }

    // View All Records
    @RequestMapping("/view")
    public String view(Model m) {

        List<Carbon> list = dao.getAllRecords();

        m.addAttribute("list", list);

        return "view";
    }

    // Edit Page Open
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model m) {

        Carbon c = dao.getById(id);

        m.addAttribute("command", c);

        return "edit";
    }

    // Update Record
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("carbon") Carbon c) {

        dao.update(c);

        return "redirect:/view";
    }

    // Delete Record
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id) {

        dao.delete(id);

        return "redirect:/view";
    }
}