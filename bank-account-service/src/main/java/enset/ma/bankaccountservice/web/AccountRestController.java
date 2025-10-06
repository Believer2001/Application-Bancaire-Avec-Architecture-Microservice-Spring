package enset.ma.bankaccountservice.web;


import enset.ma.bankaccountservice.entities.BankAccount;
import enset.ma.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/bankAccounts")
    public  BankAccount save(@RequestBody BankAccount bankAccount){
        if(bankAccount.getId() == null) bankAccount.setId(java.util.UUID.randomUUID().toString());
        return  bankAccountRepository.save(bankAccount);
    }

    @PutMapping("/bankAccounts/{id}")
    public  BankAccount update(@PathVariable String id, @RequestBody BankAccount bankAccount){
        BankAccount bankAccount1 = bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));

        if (bankAccount.getBalance() !=null) bankAccount1.setBalance(bankAccount.getBalance());
        if (bankAccount.getCurrency() != null) bankAccount1.setCurrency(bankAccount.getCurrency());
        if (bankAccount.getType() != null) bankAccount1.setType(bankAccount.getType());
        if (bankAccount.getCreatedDate() != null) bankAccount1.setCreatedDate(bankAccount.getCreatedDate());
        bankAccount1.setId(id);
        return  bankAccountRepository.save(bankAccount1);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public  void delete(@PathVariable String id) {
        bankAccountRepository.deleteById(id);
    }
}
