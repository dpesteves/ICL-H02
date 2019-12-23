package ast;

import objects.CodeBlock;
import objects.IEnvironment;
import types.IType;
import types.TInt;
import values.IValue;
import values.VInt;

public class ASTNum implements ASTNode {
	private int eval;
		
	public ASTNum(int eval) {
		this.eval = eval;
	}

	@Override
	public IValue eval(IEnvironment<String,IValue> env) {
		// TODO Auto-generated method stub
		return new VInt(this.eval);
	}
	
	@Override
	public IType typecheck(IEnvironment<String, IType> env) {
		// TODO Auto-generated method stub
		return new TInt();
	}

	@Override
	public void compile(IEnvironment env, CodeBlock cb, int level) {
		// TODO Auto-generated method stub
		cb.emit("sipush" + eval);
	}	
}
