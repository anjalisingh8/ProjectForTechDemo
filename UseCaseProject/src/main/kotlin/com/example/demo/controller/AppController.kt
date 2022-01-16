package com.example.demo.controller

import com.example.demo.entity.Beneficiary
import com.example.demo.entity.Customer
import com.example.demo.entity.CustomerTransaction
import com.example.demo.entity.Transactions
import org.kie.api.runtime.KieSession
import org.kie.api.runtime.rule.AgendaFilter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/usecase")
class AppController {


    @Autowired
    private val kieSession : KieSession ?= null

    @GetMapping("/home")
    private fun home() :String?{
        return "This is home Page";
    }

//    @PostMapping("/transactions/customer")
    private fun validCustomer(@RequestBody customer: Customer) : Customer {
        kieSession?.insert(customer)
        kieSession?.fireAllRules(AgendaFilter { match->
            var ruleName = match.rule.name
            ruleName =="Valid Customer"

        })
        return customer;
    }

    @PostMapping("transactions/beneficiary")
    private fun addBeneficiary(@RequestBody beneficiary : Beneficiary):Beneficiary?{
        kieSession?.insert(beneficiary)
        kieSession?.fireAllRules(AgendaFilter { match ->
            var ruleName = match.rule.name
            ruleName == "Valid Beneficiary"
        })
        return beneficiary;
    }

    @PostMapping("/transactions")
    private fun validTransaction(@RequestBody customerTransaction: CustomerTransaction):  CustomerTransaction?{

        println("Inside Transactions")
        var customer :Customer = validCustomer(customerTransaction.customer)
        println("")
        kieSession?.insert(customer)
        println("After customer inserted")
        kieSession?.insert(customerTransaction.transactions)
        kieSession?.insert(customerTransaction)
        println("After transactions inserted")
        kieSession?.fireAllRules(AgendaFilter { match ->
            var ruleName = match.rule.name
            ruleName == "Valid Transaction"
        })
        println(customerTransaction.transactions.transactionStatus)
        return customerTransaction;
    }


}