package ast;

import exceptions.ASTRuntimeException;
import exceptions.ASTTypeException;
import exceptions.IdNotFoundException;
import objects.CodeBlock;
import objects.IEnvironment;
import types.IType;
import values.IValue;

public class ASTPrint implements ASTNode {

	private ASTNode node;
    private IType type;

    public ASTPrint(ASTNode node) {
        this.node = node;
        this.type = null;
    }
	
	@Override
	public IValue eval(IEnvironment<String, IValue> env) throws ASTRuntimeException {
		// TODO Auto-generated method stub
		return node.eval(env);
	}

	@Override
	public IType typecheck(IEnvironment<String, IType> env) throws ASTTypeException, IdNotFoundException {
		// TODO Auto-generated method stub
		IType t = node.typecheck(env);
		type = t;
		return t;
	}

	@Override
	public void compile(IEnvironment<String, IType> env, CodeBlock cb, int level) {
		// TODO Auto-generated method stub

	}

}
