package account_management.backend.service;

import account_management.backend.model.Account;
import account_management.backend.repository.AccountRepository;
import account_management.backend.request.CheckLogin;
import account_management.backend.request.CreatNewAccount;

import java.util.List;

public class AccountService {

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String PASSWORD_PATTERN =
            "^[_A-Za-z0-9-]{7,15}$";
    AccountRepository accountRepository = new AccountRepository();
    List<Account> accounts = accountRepository.findAll();
    public boolean checkEmailValid(String email) {
        return email.matches(EMAIL_PATTERN);
    }
    public boolean checkEmailExist(String email) {
        for (Account a: accounts){
            if (a.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }
    public boolean checkPassValid(String password) {
        return password.matches(PASSWORD_PATTERN);
    }


    public boolean checkLogin(CheckLogin request) {
        for (Account a: accounts){
            if(a.getEmail().equals(request.getEmail())){
                return true;
            }
        }
        return false;
    }

    public Account creatNewAccount(CreatNewAccount request) {
        Account account = new Account();
        account.setUsername(request.getUsername()); ;
        account.setEmail(request.getEmail());
        account.setPassword(request.getPassword());
        accounts.add(account);
        accountRepository.updateFiles(accounts);

        return account;
    }


    public void changePassword(String email, String newPassword) {
        for (Account a: accounts){
            if (a.getEmail().equals(email)){
                a.setPassword(newPassword);
            }
        }
        accountRepository.updateFiles(accounts);
    }
}
