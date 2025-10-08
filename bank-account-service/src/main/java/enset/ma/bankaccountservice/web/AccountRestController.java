package enset.ma.bankaccountservice.web;


import enset.ma.bankaccountservice.dto.BankAccountRequestDTO;
import enset.ma.bankaccountservice.dto.BankAccountResponseDTO;
import enset.ma.bankaccountservice.entities.BankAccount;
import enset.ma.bankaccountservice.repositories.BankAccountRepository;
import enset.ma.bankaccountservice.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountRestController {
    private  final BankAccountRepository bankAccountRepository;
    private  final  AccountService accountService;
    //  pour faire l'injection de dépendance
    public AccountRestController(BankAccountRepository bankAccountRepository,
                                 AccountService accountService) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
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
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO bankAccountRequestDTO){
        return accountService.addAccount(bankAccountRequestDTO);
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
