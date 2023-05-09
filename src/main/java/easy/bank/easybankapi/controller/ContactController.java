package easy.bank.easybankapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    @GetMapping("contact")
    public String getAccountDetails() {
        return "Contact us here.";
    }
}
