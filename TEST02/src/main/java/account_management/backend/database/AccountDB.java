package account_management.backend.database;

import account_management.backend.model.Account;
import account_management.backend.utils.FileUtils;

import java.util.ArrayList;

public class AccountDB {
    public static ArrayList<Account> accounts = FileUtils.getDataFromFile("account.json");
}
