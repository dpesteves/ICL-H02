package values;

public class VCell implements IValue {
	
	IValue val;

	public VCell(IValue val) {
		this.val = val;
	}
	
	public IValue get() {
		return val;
	}
	
	public void set(IValue val) {
		this.val = val;
	}
	
	@Override
    public boolean equals(Object o) {
        return this==o;
    }

    @Override
    public String toString() {
        return "Cell{value="+this.val.toString()+"}";
    }

    @Override
    public void show() {
        System.out.println(this.toString());
    }

}
