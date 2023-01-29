package spyNetwork;
import java.util.ArrayList;
public class homeBase extends baseEntity {
    private static homeBase myhomebase;
    private regSystem<fieldBase> registation= new regSystem<fieldBase>();

    private homeBase(){}

    public static homeBase createHomeBase(){
        if (myhomebase==null){
            myhomebase=new homeBase();
        }
        return myhomebase;
    }
    
    public boolean checkID(entity requier){
        for (int i=0; i<this.registation.length(); i++){
            fieldBase FB=this.registation.get(i);
            if (requier==FB) return true;
            if (FB.checkInside(requier)) return true;
        }
        return false;
    }
    
    public fieldBase createFieldBaseAccount(){
        fieldBase newFB=new fieldBase(this);
        this.registation.register(newFB);
        return newFB;
    }

    public void updateScheme(scheme newScheme){
        myScheme=newScheme;
        for (int i=0; i<registation.length(); i++){
            registation.get(i).updateScheme(newScheme);
        }
    }
}
