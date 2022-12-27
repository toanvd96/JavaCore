package account_management.backend.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CreatNewAccount {
    private String username;
    private String email;
    private String password;

    public CreatNewAccount(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

}
