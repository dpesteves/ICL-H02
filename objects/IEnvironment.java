package objects;

public interface IEnvironment<K,V> {
	
	IEnvironment<K,V> beginScope();
	
	IEnvironment<K,V> endScope();
	
	V find(K id);
	
	void assoc(K key, V value);
	
}
