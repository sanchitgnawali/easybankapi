package easy.bank.easybankapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {

    @GetMapping("myLoans")
    public String getAccountDetails() {
        return "You don't have a loan. I'd suggest you do.";
    }

}
