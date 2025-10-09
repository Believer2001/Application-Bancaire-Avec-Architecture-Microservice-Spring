package enset.ma.bankaccountservice.mappers;

import enset.ma.bankaccountservice.dto.BankAccountRequestDTO;
import enset.ma.bankaccountservice.dto.BankAccountResponseDTO;
import enset.ma.bankaccountservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
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

    public BankAccount fromBankAccountRequestDTOToBankAccount(BankAccountRequestDTO bankAccountRequestDTO)
    {
        BankAccount bankAccount = new BankAccount();
        BeanUtils.copyProperties(bankAccountRequestDTO, bankAccount);
        bankAccount.setId((UUID.randomUUID().toString()));
        bankAccount.setCreatedDate(new Date());
        return bankAccount;
    }

}