package enset.ma.bankaccountservice.service;

import enset.ma.bankaccountservice.dto.BankAccountRequestDTO;
import enset.ma.bankaccountservice.dto.BankAccountResponseDTO;
import enset.ma.bankaccountservice.entities.BankAccount;

public interface AccountService {
public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTODTO);
}
