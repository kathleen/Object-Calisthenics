package main.java.Collections;

/**
 * Created by atzubeli on 6/12/14.
 */
public interface RecordedMap<K, V> {

    public void createKey(K key);

    public void add(K key, V item);

    public void remove(K key, V item);

    public ListWrapper readAll(K key);



}