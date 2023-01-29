import java.util.ArrayList;
import spyNetwork.*;
public class runner {
    public static void main(String[] arg){
        scheme basicScheme=new scheme1();
        scheme superScheme=new SchemeD1(new SchemeD1(basicScheme));
        //Here are the method available:
        //For all entities:
        //1.sendMessage(message,receiver): use to send message to a valid entity.
        //2.readMessage():will return the newest message in the mailbox.
        //3.checkID(entity): check whether this entity is in a system connected to you.
        //For the home base:
        //1.createHomeBase(): to creat a home base(you can only have one home base).
        //2.createFieldBaseAccount(): to create a new field base
        //3.updateScheme(scheme): update the newest scheme to all entity
        //For field bases:
        //1.createSpyAccount(): generate a new spy
        //2.goDark(): unregister to the home base and only enable to communitcation inside.
        //3.backInLight(homeBase):register to the home base again.
        //For spies:
        //1.goDie(): make this spy disappear permanently.
        homeBase sweetHome= homeBase.createHomeBase();
        sweetHome.updateScheme(superScheme);
        fieldBase childrensRoom= sweetHome.createFieldBaseAccount();
        fieldBase parentsRoom= sweetHome.createFieldBaseAccount();
        spy daughter= childrensRoom.createSpyAccount();
        spy son= childrensRoom.createSpyAccount();
        spy dad= parentsRoom.createSpyAccount();
        spy mom= parentsRoom.createSpyAccount();
        mom.sendMessage("Are you sleeping?", childrensRoom);
        System.out.println(childrensRoom.readMessage());
        childrensRoom.sendMessage("We will sleep soon!", mom);
        System.out.println(mom.readMessage());
        childrensRoom.goDark();
        mom.sendMessage("Are you sleeping?", childrensRoom);
        System.out.println(childrensRoom.readMessage());
        son.sendMessage("We are pretending to sleep!", mom);
        System.out.println(mom.readMessage());
        son.sendMessage("We can play video game now!", daughter);
        System.out.println(daughter.readMessage());
        daughter.sendMessage("We should better go sleep, we can't lie to mom", son);
        System.out.println(son.readMessage());
        son.sendMessage("You are right! We should be good kids", childrensRoom);
        System.out.println(childrensRoom.readMessage());
        childrensRoom.backInLight(sweetHome);
        dad.sendMessage("Are you awake?", childrensRoom);
        System.out.println(childrensRoom.readMessage());
        childrensRoom.sendMessage("Yes!", dad);
        System.out.println(dad.readMessage());
        //60 years later
        System.out.println("60 years later.....");
        mom.goDie();
        mom.sendMessage("Praying", sweetHome);
        System.out.println(sweetHome.readMessage());
        son.sendMessage("Mom, I miss you.",mom);
        System.out.println(mom.readMessage());
        dad.sendMessage("She must be praying for us, so just be strong and move on.", sweetHome);
        System.out.println(sweetHome.readMessage());
    }
}
