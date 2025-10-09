package enset.ma.bankaccountservice.web;

import enset.ma.bankaccountservice.dto.BankAccountRequestDTO;
import enset.ma.bankaccountservice.dto.BankAccountResponseDTO;
import enset.ma.bankaccountservice.entities.BankAccount;
import enset.ma.bankaccountservice.repositories.BankAccountRepository;
import enset.ma.bankaccountservice.service.AccountService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller

public class BankAccountGraphQLController {


    private final BankAccountRepository bankAccountRepository;
    private  final AccountService accountService;

    public BankAccountGraphQLController(BankAccountRepository bankAccountRepository,AccountService accountService) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
    }


    @QueryMapping(name = "accounts")
    public List<BankAccount> accountsList() {
        return bankAccountRepository.findAll();
    }

@QueryMapping
    public BankAccount bankAccountById(@Argument String id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account %s not found", id)));
    }


    // ajouter un compte

    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccountRequestDTO) {

        return accountService.addAccount(bankAccountRequestDTO);
    }

    // pour faire une mise  à jour d un compte

    @MutationMapping
    public  BankAccountResponseDTO updateAccount( @Argument String id,@Argument BankAccountRequestDTO bankAccountRequestDTO){

        return  accountService.updateAccount(id,bankAccountRequestDTO);
    }
    @MutationMapping
    public  Boolean  deleteAccount( @Argument String id){

         bankAccountRepository.deleteById(id);
         return true ;
    }

}
