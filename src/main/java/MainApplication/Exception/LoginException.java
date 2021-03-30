package MainApplication.Exception;

public class LoginException {

    private String falschePassword = "falsche Password!";
    private String SiehabennochkeinAccountbeiunsbitteRegiestrierenerst ="Sie haben noch kein Account bei uns! bitte Regiestrieren erst!";
    private String usernameundpasswordkönntennichtleersein = "username und password könnten nicht leer sein !";
    private int Code;
    private String message;

    public LoginException() {
    }

    public LoginException(String falschePassword, String siehabennochkeinAccountbeiunsbitteRegiestrierenerst, String usernameundpasswordkönntennichtleersein, int code, String message) {
        this.falschePassword = falschePassword;
        SiehabennochkeinAccountbeiunsbitteRegiestrierenerst = siehabennochkeinAccountbeiunsbitteRegiestrierenerst;
        this.usernameundpasswordkönntennichtleersein = usernameundpasswordkönntennichtleersein;
        Code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public String getFalschePassword() {
        return falschePassword;
    }

    public String getSiehabennochkeinAccountbeiunsbitteRegiestrierenerst() {
        return SiehabennochkeinAccountbeiunsbitteRegiestrierenerst;
    }

    public String getUsernameundpasswordkönntennichtleersein() {
        return usernameundpasswordkönntennichtleersein;
    }

    public void setFalschePassword(String falschePassword) {
        this.falschePassword = falschePassword;
    }

    public void setSiehabennochkeinAccountbeiunsbitteRegiestrierenerst(String siehabennochkeinAccountbeiunsbitteRegiestrierenerst) {
        SiehabennochkeinAccountbeiunsbitteRegiestrierenerst = siehabennochkeinAccountbeiunsbitteRegiestrierenerst;
    }

    public void setUsernameundpasswordkönntennichtleersein(String usernameundpasswordkönntennichtleersein) {
        this.usernameundpasswordkönntennichtleersein = usernameundpasswordkönntennichtleersein;
    }
}
