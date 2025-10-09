package enset.ma.bankaccountservice.service;

import enset.ma.bankaccountservice.dto.BankAccountRequestDTO;
import enset.ma.bankaccountservice.dto.BankAccountResponseDTO;
import enset.ma.bankaccountservice.entities.BankAccount;
import enset.ma.bankaccountservice.mappers.AccountMapper;
import enset.ma.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    BankAccountRepository bankAccountRepository;
    AccountMapper accountMapper;
    public AccountServiceImpl(BankAccountRepository bankAccountRepository,
                              AccountMapper accountMapper)
    {
        this.accountMapper = accountMapper;
        this.bankAccountRepository = bankAccountRepository;
    }
    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount =accountMapper.fromBankAccountRequestDTOToBankAccount(bankAccountRequestDTO);

        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccountBankAccountResponseDTO(savedBankAccount);

        return bankAccountResponseDTO;
    }

    @Override
    public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountRequestDTO) {
        if(!bankAccountRepository.existsById(id))
            throw new RuntimeException(String.format("Account %s not found",id));
        BankAccount bankAccount =accountMapper.fromBankAccountRequestDTOToBankAccount(bankAccountRequestDTO);

        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccountBankAccountResponseDTO(savedBankAccount);

        return bankAccountResponseDTO;
    }
}
