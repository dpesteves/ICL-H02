package types;

public class TBool implements IType {
	
	public TBool() {
    }

    @Override
    public String toString() {
        return "bool";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof TBool;
    }
    
}
