package easy.bank.easybankapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {

    @GetMapping("notices")
    public String getAccountDetails() {
        return "Here are the list of notices.";
    }
}
