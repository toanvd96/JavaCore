package account_management.backend.controller;

import account_management.backend.model.Account;
import account_management.backend.request.CheckLogin;
import account_management.backend.request.CreatNewAccount;
import account_management.backend.service.AccountService;

public class AccountController {
    AccountService accountService = new AccountService();
    public boolean checkEmailValid(String email) {
        return accountService.checkEmailValid(email);
    }

    public boolean checkPassValid(String password) {
        return accountService.checkPassValid(password);
    }


    public boolean checkLogin(CheckLogin request) {
        return accountService.checkLogin(request);
    }

    public Account creatNewAccount(CreatNewAccount request) {
        return accountService.creatNewAccount(request);
    }

    public boolean checkEmailExist(String email) {
        return accountService.checkEmailExist(email);
    }

    public void changePassword(String email, String newPassword) {
        accountService.changePassword(email,newPassword);
    }
}
