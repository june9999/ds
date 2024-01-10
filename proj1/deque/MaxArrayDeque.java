package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {

    private Comparator scom;
    public MaxArrayDeque(Comparator<T> c) {
        scom = c;
    }

    public T max() {
        T max = this.get(0);
        for (int i = 0; i < size() - 1; i++) {
            if (scom.compare(max, this.get(i + 1)) < 0) {
                max = this.get(i + 1);
            }
        }
        return max;
    }

    public  T max(Comparator<T> c) {
        T max =  this.get(0);
        for (int i = 0; i < size() - 1; i++) {
            if (c.compare(max, this.get(i + 1)) < 0) {
                max = this.get(i + 1);
            }
        }
        return max;
    }
}
