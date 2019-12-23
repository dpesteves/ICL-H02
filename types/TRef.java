package types;

public class TRef implements IType {
	
	private IType type;

    public TRef(IType type) {
        this.type = type;
    }

    public IType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "ref_" + type;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof TRef){
            return ((TRef) obj).getType().equals(this.type);
        }
        return false;
    }
}
