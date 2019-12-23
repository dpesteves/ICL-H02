package ast;

import exceptions.ASTTypeException;
import exceptions.IdNotFoundException;
import exceptions.ASTRuntimeException;
import objects.CodeBlock;
import objects.IEnvironment;
import types.IType;
import values.IValue;

public interface ASTNode {
	public IValue eval(IEnvironment<String, IValue> env) throws ASTRuntimeException;
    public IType typecheck(IEnvironment<String,IType> env) throws ASTTypeException, IdNotFoundException;
	public void compile(IEnvironment<String, IType> env, CodeBlock cb, int level);
}
