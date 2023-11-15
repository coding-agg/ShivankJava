package Section14_Interfaces_and_Generics;

import java.util.Comparator;

public class carspeedComparator implements Comparator<car> {
    public int compare(car tcar,car ocar){
        return tcar.speed-ocar.speed;
    }
}
