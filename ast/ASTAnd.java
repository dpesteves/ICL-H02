package ast;

import exceptions.ASTRuntimeException;
import exceptions.ASTTypeException;
import exceptions.IdNotFoundException;
import exceptions.NotBooleanException;
import objects.CodeBlock;
import objects.IEnvironment;
import types.IType;
import types.TBool;
import values.IValue;
import values.VBool;

public class ASTAnd implements ASTNode {
	private ASTNode lhs, rhs;
	
	public ASTAnd(ASTNode lhs, ASTNode rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	@Override
	public IValue eval(IEnvironment<String, IValue> env) throws ASTRuntimeException {
		// TODO Auto-generated method stub
		IValue v1 = lhs.eval(env);
		if(v1 instanceof VBool) {
			IValue v2 = rhs.eval(env);
        	if(v2 instanceof VBool)
        		return new VBool(((VBool)v1).getValue()&&((VBool)v2).getValue());
        }
        throw new NotBooleanException("Disjunction is only valid if the arguments are Booleans!");
	}

	@Override
	public IType typecheck(IEnvironment<String, IType> env) throws ASTTypeException, IdNotFoundException {
		IType leftType = this.lhs.typecheck(env);
		IType rightType = this.rhs.typecheck(env);

	    if(leftType instanceof TBool && rightType instanceof TBool){
	    	return new TBool();
	    }
	    throw new ASTTypeException("Type checking error in OR operation: the arguments aren't of type bool"); 
	}

	@Override
	public void compile(IEnvironment<String, IType> env, CodeBlock cb, int level) {
		// TODO Auto-generated method stub

	}

}