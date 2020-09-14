import java.util.HashMap;
import java.util.Map;

public class UserMap<T> extends HashMap<T, Integer> implements CountMap<T> {

    @Override
    public void add(T o) {
        if(super.containsKey(o)){
            super.put(o, (Integer)super.get(o)+1);
        }
        else super.put(o, 1);
    }

    @Override
    public int getCount(T o) {
        Integer i= new Integer(super.get(o));
        if(i==null) i=0;
        return i;
    }

    @Override
    public int removeItem(T o) {
        int r = 0;
        if(super.containsKey(o)) {
            r=super.get(o);
            super.remove(o);
        }
        return r;
    }

    @Override
    public void addAll(CountMap source) {
        super.putAll(source.toMap());

    }

    @Override
    public Map toMap() {
        HashMap mapa= new HashMap(this);

        return mapa;
    }

    @Override
    public void toMap(Map destination) {
        destination.putAll(this.toMap());
    }
}
