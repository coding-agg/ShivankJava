package Section14_Interfaces_and_Generics;

import java.util.Comparator;

public class carcolorComparator implements Comparator<car> {

    @Override
    public int compare(car tcar, car ocar) {
        return tcar.color.compareTo(ocar.color);
    }
}
