package models;

import play.data.validation.Constraints;
import validators.Password;

public class User_patch {

    @Constraints.MinLength(value=2,message = "error-nick_extension")
    private String nick;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}
