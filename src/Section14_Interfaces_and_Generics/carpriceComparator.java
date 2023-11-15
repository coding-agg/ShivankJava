package Section14_Interfaces_and_Generics;

import java.util.Comparator;

public class carpriceComparator implements Comparator<car> {

    @Override
    public int compare(car tcar, car ocar) {
        return ocar.price-tcar.price;
    }
}
