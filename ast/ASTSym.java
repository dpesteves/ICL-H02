package ast;

import exceptions.ASTRuntimeException;
import exceptions.ASTTypeException;
import exceptions.IdNotFoundException;
import exceptions.NotIntegerException;
import objects.CodeBlock;
import objects.IEnvironment;
import types.IType;
import types.TInt;
import values.IValue;
import values.VInt;

public class ASTSym implements ASTNode {
	
	private ASTNode node;
	
	public ASTSym(ASTNode node) {
		this.node = node;
	}

	@Override
	public IValue eval(IEnvironment<String, IValue> env) throws ASTRuntimeException {
		// TODO Auto-generated method stub
		IValue v = node.eval(env);
        if(v instanceof VInt){
        	return new VInt(-((VInt)v).getValue());
        }
        throw new NotIntegerException("Symmetry is only valid if the argument is Integer!");
	}

	@Override
	public IType typecheck(IEnvironment<String, IType> env) throws ASTTypeException, IdNotFoundException {
		// TODO Auto-generated method stub
		IType t = node.typecheck(env);
        if(t instanceof TInt){
        	return new TInt();
        }
        throw new ASTTypeException("Symmetry is only valid if the argument is Integer!");
	}

	@Override
	public void compile(IEnvironment<String, IType> env, CodeBlock cb, int level) {
		// TODO Auto-generated method stub

	}

}
