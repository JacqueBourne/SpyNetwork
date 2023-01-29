package spyNetwork;
import java.util.ArrayList;
abstract class baseEntity implements entity{
    protected mailSystem inbox= new mailSystem();
    protected scheme myScheme;

    public baseEntity(){}
    
    public void sendMessage(String message, entity receiver){
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
    
    public boolean checkID(entity requier){
        return false;
    }
}