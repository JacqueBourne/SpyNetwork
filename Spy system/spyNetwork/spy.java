package spyNetwork;
import java.util.ArrayList;
public class spy implements entity{
    private fieldBase myFieldBase;
    private mailSystem inbox= new mailSystem();
    protected scheme myScheme;


    protected spy(fieldBase FB){
        myFieldBase=FB;
        myScheme= myFieldBase.myScheme;
    }

    public void sendMessage(String message, entity receiver){
        if (myFieldBase==null) return;
        if (checkID(receiver)){
            String encryptedMessage= myScheme.encryption(message);
            receiver.receiveMessage(encryptedMessage, this);
        }
    }

    public void receiveMessage(String message, entity sender){
        if (checkID(sender)){
            inbox.receiveMail(message);
        }
    }

    public String readMessage(){
        String message= inbox.readMail();
        String decryptedMessage=myScheme.decryption(message);
        return decryptedMessage;
    }
    
    protected void updateScheme(scheme newScheme){
        myScheme= newScheme;
    }

    public boolean checkID(entity requier){
        if (requier==myFieldBase) return true;
        if (myFieldBase.checkID(requier)) return true;
        return false;
    }

    public void goDie(){
        myFieldBase.removeSpy(this);
        myFieldBase= null;
    }
}