package account_management.backend.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class CheckLogin {
    private String email;
    private String password;

    public CheckLogin(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
