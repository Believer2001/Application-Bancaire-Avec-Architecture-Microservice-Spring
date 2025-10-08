package enset.ma.bankaccountservice.mappers;

import enset.ma.bankaccountservice.dto.BankAccountRequestDTO;
import enset.ma.bankaccountservice.dto.BankAccountResponseDTO;
import enset.ma.bankaccountservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;

public class AccountMapper {

    public BankAccountResponseDTO fromBankAccountBankAccountResponseDTO(BankAccount bankAccount)
    {
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount, bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }

    public BankAccountRequestDTO fromBankAccountToBankAccountRequestDTO(BankAccount bankAccount)
    {
        BankAccountRequestDTO bankAccountRequestDTO = new BankAccountRequestDTO();
        BeanUtils.copyProperties(bankAccount, bankAccountRequestDTO);
        return bankAccountRequestDTO;
    }

}