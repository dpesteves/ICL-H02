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

public class ASTIf implements ASTNode {
	
	private ASTNode nIf, nThen, nElse;
	
	public ASTIf(ASTNode nIf, ASTNode nThen, ASTNode nElse) {
		this.nIf = nIf;
		this.nThen = nThen;
		this.nElse = nElse;
	}

	@Override
	public IValue eval(IEnvironment<String, IValue> env) throws ASTRuntimeException {
		// TODO Auto-generated method stub
		IEnvironment<String,IValue> env2 = env.beginScope();
		IValue valIf = nIf.eval(env);
		if(valIf instanceof VBool) {
			if (((VBool) valIf).getValue())
				return nThen.eval(env2);
			else
				return nElse.eval(env2);
		}
		throw new NotBooleanException("If statement must be boolean");
	}

	@Override
	public IType typecheck(IEnvironment<String, IType> env) throws ASTTypeException, IdNotFoundException {
		// TODO Auto-generated method stub
		IType typeIf = nIf.typecheck(env);
		IType typeThen = nThen.typecheck(env);
		IType typeElse = nElse.typecheck(env);
		
		if(typeIf instanceof TBool) {
			if(typeThen.equals(typeElse))
				return typeThen;
			else
				throw new ASTTypeException("If return types are different in then and else parts");
		}
		throw new ASTTypeException("If statement must be boolean");
	}

	@Override
	public void compile(IEnvironment<String, IType> env, CodeBlock cb, int level) {
		// TODO Auto-generated method stub

	}

}
