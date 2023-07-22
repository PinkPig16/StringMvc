package org.mvc1.controllers;

import org.mvc1.PeopleDAO.PersonDAO;
import org.mvc1.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String show(Model model) {

        model.addAttribute("people",personDAO.show());

        return "/people/show";
    }

    @GetMapping("/{id}")
    public String showIndex(@PathVariable("id") int id, Model model) {


        model.addAttribute("person",personDAO.showIndex(id));

        return "/people/index";
    }
//    @GetMapping("/new")
//    public String newPerson(Model model) {
//
//        model.addAttribute("person",new Person());
//
//        return "/people/new";
//    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person")Person person) {
        return "/people/new";
    }
    @PostMapping
    public String create(@ModelAttribute("person") Person person) {

        personDAO.save(person);

        return "redirect:/people";
    }

}
