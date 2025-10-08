package enset.ma.bankaccountservice.dto;


import enset.ma.bankaccountservice.enums.AccountType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BankAccountResponseDTO {
    private  String id ;
    private Date createdDate ;
    private Double balance ;
    private  String currency;
    private AccountType type;
}
