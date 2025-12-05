package com.banking.specification;

import com.banking.Enum.AccountType;
import com.banking.entity.Account;
import org.springframework.data.jpa.domain.Specification;

import javax.management.Query;

public class AccountSpecifications {

    public static Specification<Account> hasAccountType(AccountType accountType) {
        return (root, query, cb) -> cb.equal(root.get("accountType"), accountType);
    }
    public static Specification<Account> hasMinimumBalance(double minimumBalance) {
        return(root, query, cb) ->cb.greaterThanOrEqualTo(root.get("balance"), minimumBalance);
    }
    public static Specification<Account> isActive() {
        return (root, query, cb) -> cb.equal(root.get("isActive"), true);
    }

}
