package enset.ma.bankaccountservice.entities;

import enset.ma.bankaccountservice.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.config.Projection;


@Projection(types = BankAccount.class, name = "p1")
public interface BankAccountProjection {
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
    public String getId()  ;
    public AccountType getAccountType();
}
}
