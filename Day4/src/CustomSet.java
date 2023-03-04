import java.util.*;

public class CustomSet<E>
        extends AbstractSet<E>
        implements Set<E>, Cloneable, java.io.Serializable {

    private transient ArrayList<E> arrayList;

    public CustomSet() {
        arrayList = new ArrayList<E>();
    }

    public Iterator<E> iterator() {
        return arrayList.iterator();
    }


    public int size() {
        return arrayList.size();
    }

    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    public boolean contains(Object o) {
        return arrayList.contains(o);
    }

    public boolean add(E e) {
        return arrayList.add(e);
    }

    public boolean remove(Object o) {
        return arrayList.remove(o);
    }

    public void clear() {
        arrayList.clear();
    }

    public Object clone() {
        try {
            CustomSet<E> newCustomSet = (CustomSet<E>) super.clone();
            newCustomSet.arrayList = (ArrayList<E>) arrayList.clone();
            return newCustomSet;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }
}
