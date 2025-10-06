package enset.ma.bankaccountservice.repositories;

import enset.ma.bankaccountservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
}
