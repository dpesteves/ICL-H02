package values;

public class VInt implements IValue{
	private int val;

    public VInt(int val) {
    	this.val = val;
    }

    public int getValue() {
        return val;
    }

    @Override
    public boolean equals(Object other){
        if(other instanceof VInt){
            return this.val == ((VInt)other).getValue();
        }
        return false;
    }

    @Override
    public String toString() {
        return Integer.toString(this.val);
    }

    @Override
    public void show() {
        System.out.println(this.toString());
    }
}
