package ast;

import exceptions.ASTRuntimeException;
import exceptions.ASTTypeException;
import exceptions.IdNotFoundException;
import objects.CodeBlock;
import objects.IEnvironment;
import types.IType;
import values.IValue;

public class ASTSeq implements ASTNode{

	private ASTNode lhs, rhs;
	
	public ASTSeq(ASTNode lhs, ASTNode rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	@Override
	public IValue eval(IEnvironment<String, IValue> env) throws ASTRuntimeException {
		// TODO Auto-generated method stub
		lhs.eval(env);
		IValue v2 = rhs.eval(env);
		return v2;
	}

	@Override
	public IType typecheck(IEnvironment<String, IType> env) throws ASTTypeException, IdNotFoundException {
		// TODO Auto-generated method stub
		this.lhs.typecheck(env);
        return this.rhs.typecheck(env);
	}

	@Override
	public void compile(IEnvironment<String, IType> env, CodeBlock cb, int level) {
		// TODO Auto-generated method stub
		
	}

}
