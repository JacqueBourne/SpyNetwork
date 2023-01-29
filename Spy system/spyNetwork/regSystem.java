package spyNetwork;
import java.util.ArrayList;
public class regSystem <T>{
    private ArrayList<T> regList;

    public regSystem(){
        regList= new ArrayList<T>();
    }

    public void register(T a){
        regList.add(a);
    }

    public void unregister(T a){
        for (int i= 0;i< regList.size(); i++){
            if (regList.get(i)==a) {
                regList.remove(i);
                return;
            }
        }
    }

    public T get(int i){
        return regList.get(i);
    }

    public int length(){
        return regList.size();
    }
}
