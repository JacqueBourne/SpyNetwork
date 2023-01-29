package spyNetwork;
import java.util.ArrayList;
public class fieldBase extends baseEntity{
    private homeBase myHomeBase;
    private regSystem<spy> registation;

    protected fieldBase(homeBase HB){
        myHomeBase=HB;
        myScheme=HB.myScheme;
        registation= new regSystem<spy>();
    }

    @Override
    public boolean checkID(entity requier){
        if (requier==myHomeBase) return true;
        if (checkInside(requier)) return true;
        if (myHomeBase!=null){
            if (myHomeBase.checkID(requier)) return true;
        }
        return false;
    }

    protected boolean checkInside(entity requier){
        for (int i=0; i<registation.length(); i++){
            if (requier==registation.get(i)) return true;
        }
        return false;
    }

    public void goDark(){
        myHomeBase=null;
    }

    public void backInLight(homeBase HB){
        myHomeBase=HB;
    }

    public spy createSpyAccount(){
        spy newSpy=new spy(this);
        registation.register(newSpy);
        return newSpy;
    }

    protected void updateScheme(scheme newScheme){
        myScheme=newScheme;
        for (int i=0; i<registation.length(); i++){
            registation.get(i).updateScheme(newScheme);
        }
    }

    protected void removeSpy(spy deadSpy){
        registation.unregister(deadSpy);
    }
}