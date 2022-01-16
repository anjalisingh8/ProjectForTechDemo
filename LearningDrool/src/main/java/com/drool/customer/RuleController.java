package com.drool.customer;


import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class RuleController {

    @Autowired
    private KieSession session;

    @GetMapping("/home")
    public String home(){
        return "Welcome to the home page";
    }

    @PostMapping("/loanEligibility")
    public User eligibleForLoan(@RequestBody User user){
        session.insert(user);
        session.fireAllRules();
        return user;
    }


}
