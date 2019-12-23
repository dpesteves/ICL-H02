package ast;

import exceptions.ASTRuntimeException;
import exceptions.ASTTypeException;
import exceptions.IdNotFoundException;
import exceptions.NotIntegerException;
import exceptions.NotRefException;
import objects.CodeBlock;
import objects.IEnvironment;
import types.IType;
import types.TInt;
import types.TRef;
import values.IValue;
import values.VCell;
import values.VInt;

public class ASTDeref implements ASTNode {

	private ASTNode ref;
	private IType type;
	
	public ASTDeref(ASTNode ref) {
		this.ref = ref;
	}
	
	@Override
	public IValue eval(IEnvironment<String, IValue> env) throws ASTRuntimeException {
		// TODO Auto-generated method stub
		IValue v = ref.eval(env);
        if(v instanceof VCell){
        	return ((VCell)v).get();
        }
        throw new NotRefException("Dereferenciation is only valid if the argument is a Cell!");
	}

	@Override
	public IType typecheck(IEnvironment<String, IType> env) throws ASTTypeException, IdNotFoundException {
		// TODO Auto-generated method stub
		IType v = ref.typecheck(env);
        if(v instanceof TRef){
        	return ((TRef)type).getType();
        }
        throw new ASTTypeException("Dereferenciation of a non reference type");
    }
	
	@Override
	public void compile(IEnvironment<String, IType> env, CodeBlock cb, int level) {
		// TODO Auto-generated method stub

	}

}
