package com.github.mnghklio.web.controller;

import com.github.mnghklio.web.config.auth.LoginUser;
import com.github.mnghklio.web.config.auth.dto.SessionUser;
import com.github.mnghklio.web.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/stock")
public class StockController {

    private final StockService stockService;

    @GetMapping("/{company}/{classification}")
    public String stockRead (@PathVariable("company") String company, @PathVariable("classification") String classification, Model model, @LoginUser SessionUser user) {
        switch (classification) {
            case "switch":
                classification = "스위치";
                break;
            case "wirelessAP":
                classification = "무선 AP";
                break;
        }

        if(user != null) {
            model.addAttribute("userName", user.getName());
        }

        model.addAttribute("company", company);
        model.addAttribute("stockList", this.stockService.getList(company, classification));

        return "stock";
    }

    @GetMapping("/add")
    public String addStock (@LoginUser SessionUser user, Model model) {
        if(user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "addStock";
    }

    @GetMapping("/read/{id}")
    public String readStock (@PathVariable("id") Long id, Model model, @LoginUser SessionUser user) {
        if(user != null) {
            model.addAttribute("userName", user.getName());
        }

        model.addAttribute(this.stockService.read(id));

        return "readStock";
    }
}
