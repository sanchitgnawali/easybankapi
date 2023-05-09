package easy.bank.easybankapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {

    @GetMapping("myCards")
    public String getAccountDetails() {
        return "You don't have any card registered. Click here to register.";
    }
}
