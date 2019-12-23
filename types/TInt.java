package types;

public class TInt implements IType {
	public TInt() {
    }

    @Override
    public String toString() {
        return "int";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof TInt;
    }
}
