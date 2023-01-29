package spyNetwork;
import java.util.ArrayList;
public class mailSystem {
    private ArrayList<String> mailbox;

    public mailSystem(){
        mailbox= new ArrayList<>();
    }

    public void receiveMail(String mail){
        mailbox.add(mail);
    }

    public String readMail(){
        if (mailbox.isEmpty()) return "No message";
        String mail=mailbox.get(0);
        mailbox.remove(0);
        return mail;
    }
}
