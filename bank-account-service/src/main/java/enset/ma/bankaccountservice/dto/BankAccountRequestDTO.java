package enset.ma.bankaccountservice.dto;

import enset.ma.bankaccountservice.enums.AccountType;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BankAccountRequestDTO {
    private Double balance ;
    private  String currency;
    private AccountType type;
}
