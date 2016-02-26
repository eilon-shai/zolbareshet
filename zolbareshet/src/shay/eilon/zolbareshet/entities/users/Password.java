package shay.eilon.zolbareshet.entities.users;

/**
 * Created by eilons on 2/23/2016.
 */
public class Password {
    private byte[] encryptedPassword;

    public Password(){
        this(null);
    }
    public Password(String pass){
        encryptedPassword = encrypt(pass);
    }

    public byte[] getEncryptedPassword() {
        return encryptedPassword;
    }

    public byte[] encrypt(String pass){
        byte[] res = null;
        return res;
    }
}
