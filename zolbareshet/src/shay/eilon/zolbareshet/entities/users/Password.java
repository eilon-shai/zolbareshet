package shay.eilon.zolbareshet.entities.users;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class Password {
    private byte[] encryptedPassword;

    public Password(){

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
    public String toString(){
        return "";
    }
}
