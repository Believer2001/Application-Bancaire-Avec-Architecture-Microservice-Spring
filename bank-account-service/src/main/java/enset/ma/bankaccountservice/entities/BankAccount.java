package enset.ma.bankaccountservice.entities;

import enset.ma.bankaccountservice.enums.AccountType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BankAccount {
    @Id
    private  String id ;
    private Date createdDate ;
    private Double balance ;
    private  String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;

}
