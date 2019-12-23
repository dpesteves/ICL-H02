package ast;

import exceptions.ASTRuntimeException;
import exceptions.ASTTypeException;
import exceptions.IdNotFoundException;
import exceptions.NotIntegerException;
import objects.CodeBlock;
import objects.IEnvironment;
import types.IType;
import types.TBool;
import values.IValue;
import values.VBool;
import values.VInt;

public class ASTNot implements ASTNode {
	
	private ASTNode node;
	
	public ASTNot(ASTNode node) {
		this.node = node;
	}

	@Override
	public IValue eval(IEnvironment<String, IValue> env) throws ASTRuntimeException {
		// TODO Auto-generated method stub
		IValue v = node.eval(env);
        if(v instanceof VBool){
        	return new VBool(!((VBool)v).getValue());
        }
        throw new NotIntegerException("Symmetry is only valid if the argument is Integer!");
	}

	@Override
	public IType typecheck(IEnvironment<String, IType> env) throws ASTTypeException, IdNotFoundException {
		// TODO Auto-generated method stub
		IType t = node.typecheck(env);
        if(t instanceof TBool){
        	return new TBool();
        }
        throw new ASTTypeException("Symmetry is only valid if the argument is Integer!");
	}

	@Override
	public void compile(IEnvironment<String, IType> env, CodeBlock cb, int level) {
		// TODO Auto-generated method stub

	}

}
