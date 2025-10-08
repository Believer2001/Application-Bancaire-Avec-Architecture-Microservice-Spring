package enset.ma.bankaccountservice.service;

import enset.ma.bankaccountservice.dto.BankAccountRequestDTO;
import enset.ma.bankaccountservice.dto.BankAccountResponseDTO;
import enset.ma.bankaccountservice.entities.BankAccount;
import enset.ma.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;


@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    BankAccountRepository bankAccountRepository;
    public AccountServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }
    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTODTO) {
        BankAccount bankAccount =BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdDate(new Date())
                .type(bankAccountRequestDTODTO.getType())
                .currency(bankAccountRequestDTODTO.getCurrency())
                .build();

        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO =BankAccountResponseDTO.builder()
                .id(savedBankAccount.getId())
                .balance(savedBankAccount.getBalance())
                .createdDate(savedBankAccount.getCreatedDate())
                .currency(savedBankAccount.getCurrency())
                .type(savedBankAccount.getType())
                .build();
        return bankAccountResponseDTO;
    }
}
