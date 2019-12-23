package values;

public class VBool implements IValue {

	private boolean value;

    public VBool(boolean value){
        this.value=value;
    }

    public boolean getValue(){
        return this.value;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof VBool){
            return this.value==((VBool)obj).getValue();
        }
        return false;
    }

    @Override
    public String toString() {
        return Boolean.toString(this.value);
    }

    @Override
    public void show() {
        System.out.println(this.toString());
    }

}
