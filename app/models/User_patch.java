package models;

import play.data.validation.Constraints;

public class User_patch {

    @Constraints.Required(message = "error_required")
    @Constraints.MinLength(value=2,message = "error_extension")
    private String nick;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}
