package main.pq;

public class MyEntry implements Entry {

    private Object key;
    private Object value;

    @Override
    public void setKey(Object k) {
        key = k;
    }

    @Override
    public void setValue(Object v) {
        value = v;
    }

    @Override
    public Object getKey() {
        return key;
    }

    @Override
    public Object getValue() {
        return value;
    }

}
