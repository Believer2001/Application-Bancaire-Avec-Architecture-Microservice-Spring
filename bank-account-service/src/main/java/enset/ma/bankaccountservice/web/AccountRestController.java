package enset.ma.bankaccountservice.web;


import enset.ma.bankaccountservice.entities.BankAccount;
import enset.ma.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {
    private  final BankAccountRepository bankAccountRepository;
    //  pour faire l'injection de dépendance
    public AccountRestController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }


    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts() {
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount BankAccount( @PathVariable String id) {
        return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }

}
