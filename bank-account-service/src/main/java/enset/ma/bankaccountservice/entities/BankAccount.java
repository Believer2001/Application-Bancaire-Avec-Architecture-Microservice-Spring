package enset.ma.bankaccountservice.entities;

import enset.ma.bankaccountservice.enums.AccountType;
import jakarta.persistence.Entity;
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
    private double balance ;
    private  String currency;
    private AccountType type;

}
