package easy.bank.easybankapi.controller;

import easy.bank.easybankapi.model.Customer;
import easy.bank.easybankapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
  @Autowired private CustomerRepository customerRepository;
  @Autowired private PasswordEncoder bcrypePasswordEncoder;

  @PostMapping("register")
  public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
    Customer savedCustomer = null;
    ResponseEntity response = null;

    try {
      String hashPassword = bcrypePasswordEncoder.encode(customer.getPassword());
      customer.setPassword(hashPassword);
      savedCustomer = customerRepository.save(customer);

      if (savedCustomer.getId() > 0) {
        response =
            ResponseEntity.status(HttpStatus.CREATED).body("Given user has been registered!");
      }
    } catch (Exception e) {
      response =
          ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("Couldn't register user. " + e.getMessage());
    }

    return response;
  }
}
