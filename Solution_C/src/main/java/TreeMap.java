import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class TreeMap<Type1 extends Comparable<Type1>, Type2> implements Map<Type1, Type2> {

    BinaryTree<Type1, Type2> treeMap = new BinaryTree<Type1, Type2>();
    private int size = 0;

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return treeMap.isContains((Type1) key);
    }

    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    public Type2 get(Object key) {
        return treeMap.getValue((Type1) key);
    }

    @Override
    public Type2 put(Type1 key, Type2 value) {
        Type2 add = treeMap.add(key, value);
        if (add == null) {
            size = 0;
            return null;
        }
        size++;
        return add;
    }

    @Override
    public Type2 remove(Object key) {
        treeMap.remove((Type1) key);
        size--;
        return null;
    }

    @Override
    public void putAll(Map<? extends Type1, ? extends Type2> m) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    public void clear() {
        treeMap = new BinaryTree<>();
    }

    @Override
    public Set<Type1> keySet() {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    public Collection<Type2> values() {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    @Override
    public Set<Entry<Type1, Type2>> entrySet() {
        throw new UnsupportedOperationException("This operation is not supported");
    }
}
