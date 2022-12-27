package account_management.frontend.ui;

import account_management.backend.controller.AccountController;
import account_management.backend.model.Account;
import account_management.backend.request.CheckLogin;
import account_management.backend.request.CreatNewAccount;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class AccountUI {
    AccountController accountController = new AccountController();

    public void run() {
        Scanner sc = new Scanner(System.in);

        int option = 0;
        boolean isQuit = false;

        while (!isQuit) {
            showMainMenu();

            try {
                System.out.print("Nhập lựa chọn : ");
                option = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ");
                continue;
            }

            switch (option) {
                case 1: {
                    System.out.println("Nhập vào email: ");
                    String email = sc.nextLine();

                    System.out.println("Nhập vào password: ");
                    String password = sc.nextLine();

                    CheckLogin request = new CheckLogin(email, password);
                    if(accountController.checkLogin(request)){
                        int subOption = 0;
                        boolean isSubQuit = false;

                        while (!isSubQuit) {
                            showSubMenu();
                        }
                    } else {
                        System.out.println("Email hoặc password không chính xác");
                    }
                    break;
                }
                case 2:{
                    System.out.println("Nhập vào Username: ");
                    String username = sc.nextLine();
                    String email = emailValid();
                    String password = passwordValid();

                    CreatNewAccount request = new CreatNewAccount(username,email,password);
                    Account account = accountController.creatNewAccount(request);
                    System.out.println("Tài khoản mới được tạo là: ");
                    System.out.println(account);
                    break;
                }

                case 3:{
                    forgotPassword();
                    System.out.println("Thay mật khẩu thành công");
                    break;
                }

                case 4: {
                    isQuit = true;
                    break;
                }
                default: {
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
                }
            }
        }
    }

    public static void showMainMenu() {
        System.out.println("\n********* MENU *********");
        System.out.println("1 - Đăng nhập");
        System.out.println("2 - Đăng ký");
        System.out.println("3 - Quên mật khẩu");
        System.out.println("4 - Thoát\n");
    }
    public static void showSubMenu() {
        System.out.println("\n********* MENU *********");
        System.out.println("1 - Thay đổi username");
        System.out.println("2 - Thay đổi email");
        System.out.println("3 - Thay đổi mật khẩu");
        System.out.println("4 - Đăng xuất");
        System.out.println("5 - Thoát chương trình\n");
    }

    private String emailValid(){
        Scanner sc = new Scanner(System.in);
        boolean checkEmail = false;
        String email = "";
        while (!checkEmail){
            System.out.println("Nhập vào email: ");
            email = sc.nextLine();
            if (accountController.checkEmailValid(email)){
                if (!accountController.checkEmailExist(email)){
                    checkEmail = true;
                } else {
                    System.out.println("Email đã tồn tại");
                }
            }else {
                System.out.println("Email không đúng định dạng");
            }
        }
        return email;
    }
    private String passwordValid(){
        Scanner sc = new Scanner(System.in);
        boolean checkPass = false;
        String password = "";
        while (!checkPass){
            System.out.println("Nhập vào password: ");
           password = sc.nextLine();
            if (accountController.checkPassValid(password)){
                checkPass = true;
            }else {
                System.out.println("Mật khẩu phải có ít nhất từ 7 đến 15 ký tự");
            }
        }
        return password;
    }
    public void forgotPassword(){
        Scanner sc = new Scanner(System.in);
        boolean checkEmail = false;
        while (!checkEmail){
            System.out.println("Nhập vào email của bạn: ");
            String email = sc.nextLine();
            if (accountController.checkEmailExist(email)){
                System.out.println("--- ĐỔI MẬT KHẨU ---");
                String newPassword = passwordValid();
                accountController.changePassword(email,newPassword);
                checkEmail = true;
            } else {
                System.out.println("Chưa tồn tại tài khoản");
            }
        }
    }
}
