package ast;

import exceptions.ASTRuntimeException;
import exceptions.ASTTypeException;
import exceptions.IdNotFoundException;
import objects.CodeBlock;
import objects.IEnvironment;
import types.IType;
import types.TBool;
import values.IValue;
import values.VBool;

public class ASTEq implements ASTNode {
	
	private ASTNode lhs, rhs;
	
	public ASTEq(ASTNode lhs, ASTNode rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	@Override
	public IValue eval(IEnvironment<String, IValue> env) throws ASTRuntimeException {
		// TODO Auto-generated method stub
		return new VBool(lhs.eval(env).equals(rhs.eval(env)));
	}

	@Override
	public IType typecheck(IEnvironment<String, IType> env) throws ASTTypeException, IdNotFoundException {
		// TODO Auto-generated method stub
		IType lhsType = lhs.typecheck(env);
		IType rhsType = rhs.typecheck(env);
		
		if(lhsType.equals(rhsType))
			return new TBool();
		
		throw new ASTTypeException("Type checking error in == operation: the arguments aren't of the same type");
	}

	@Override
	public void compile(IEnvironment<String, IType> env, CodeBlock cb, int level) {
		// TODO Auto-generated method stub

	}

}
