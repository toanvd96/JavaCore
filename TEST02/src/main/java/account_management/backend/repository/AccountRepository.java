package account_management.backend.repository;

import account_management.backend.database.AccountDB;
import account_management.backend.model.Account;
import account_management.backend.utils.FileUtils;

import java.util.List;

public class AccountRepository {
    public List<Account> findAll() {
        return AccountDB.accounts;
    }

    public void updateFiles(List<Account> accounts) {
        FileUtils.setDataToFile("account.json", accounts);
    }
}
