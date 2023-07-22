package org.mvc1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Neil Alishev
 */
@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name",required = false) String name,
                            @RequestParam(value = "surname",required = false) String surname,
                            Model model) {
        model.addAttribute("message","Hello "+ name +" "+ surname);
        //System.out.println(name + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String programCalculator(@RequestParam(value = "a",required = false) int a,
                                    @RequestParam(value = "b",required = false) int b,
                                    @RequestParam(value = "action",required = false) String action,
                                    Model model) {
        double res = 0;
        if(action != null) {
            if (action.equals("division")) {
                res = (a / (double)b);
            } else if (action.equals("multiplication")) {
                res = (a * b);
            } else if (action.equals("additional")) {
                res = (a + b);
            } else if (action.equals("subtraction")) {
                res = (a - b);
            }
        }

        model.addAttribute("res","Rez = "+res);
        return "/first/calculator";
    }


}
