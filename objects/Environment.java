package objects;

import java.util.HashMap;
import java.util.Map;

public class Environment<K,V> implements IEnvironment<K,V> {
	private static final int SIZE = 50;
	Map<K,V> map;
	IEnvironment<K,V> ancestor;
	
	public Environment() {
		this.map = new HashMap<>(SIZE);
		this.ancestor = null;
	}
	
	public Environment(IEnvironment<K,V> env) {
		this.map = new HashMap<>(SIZE);
		this.ancestor = env;
	}
	
	@Override
	public IEnvironment beginScope(){
		return new Environment(this);
	}
	
	@Override
	public IEnvironment endScope(){
		return ancestor;
	}
	
	@Override
	public void assoc(K key, V value) {
		map.put(key, value);
	}
	
	@Override
	public V find(K key) {
		V value = this.map.get(key);
        if (value==null){
            if(this.ancestor!=null){
                value = this.ancestor.find(key);
            }
        }
        return value;
	}
}