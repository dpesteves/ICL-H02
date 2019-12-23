package ast;

import exceptions.ASTRuntimeException;
import exceptions.ASTTypeException;
import exceptions.IdNotFoundException;
import objects.CodeBlock;
import objects.IEnvironment;
import types.IType;
import types.TRef;
import values.IValue;
import values.VCell;

public class ASTNew implements ASTNode {
	
	private ASTNode val;
	private IType type;
	
	public ASTNew(ASTNode val) {
		this.val = val;
	}

	@Override
	public IValue eval(IEnvironment<String, IValue> env) throws ASTRuntimeException {
		// TODO Auto-generated method stub
		IValue v = val.eval(env);
		return new VCell(v);
	}

	@Override
	public IType typecheck(IEnvironment<String, IType> env) throws ASTTypeException, IdNotFoundException {
		// TODO Auto-generated method stub
		IType t = this.val.typecheck(env);
        this.type = t;
        return new TRef(t);
	}

	@Override
	public void compile(IEnvironment<String, IType> env, CodeBlock cb, int level) {
		// TODO Auto-generated method stub

	}

}
