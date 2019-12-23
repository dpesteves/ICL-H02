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

public class ASTWhile implements ASTNode {

	private ASTNode condition, body;
	
	public ASTWhile(ASTNode condition, ASTNode body) {
		this.condition = condition;
		this.body = body;
	}
	
	@Override
	public IValue eval(IEnvironment<String, IValue> env) throws ASTRuntimeException {
		// TODO Auto-generated method stub
		IEnvironment<String,IValue> env2 = env.beginScope();
		IValue v = condition.eval(env);
		if(v instanceof VBool) {
			while(((VBool) v).getValue())
				body.eval(env2);
			return new VBool(false);
		}
		throw new NotBooleanException("The while condition must be boolean");
	}

	@Override
	public IType typecheck(IEnvironment<String, IType> env) throws ASTTypeException, IdNotFoundException {
		// TODO Auto-generated method stub
		IType typeCondition = condition.typecheck(env);
		IType typeBody = body.typecheck(env);
		
		if(typeCondition instanceof TBool) {
			return typeBody;
		}
		throw new ASTTypeException("If statement must be boolean");
	}

	@Override
	public void compile(IEnvironment<String, IType> env, CodeBlock cb, int level) {
		// TODO Auto-generated method stub

	}

}
