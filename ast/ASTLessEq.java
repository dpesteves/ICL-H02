package ast;

import exceptions.ASTTypeException;
import exceptions.IdNotFoundException;
import exceptions.ASTRuntimeException;
import exceptions.NotIntegerException;
import objects.CodeBlock;
import objects.IEnvironment;
import types.IType;
import types.TInt;
import values.IValue;
import values.VBool;
import values.VInt;

public class ASTLessEq implements ASTNode {
	private ASTNode lhs, rhs;
	
	public ASTLessEq(ASTNode lhs, ASTNode rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	@Override
	public IValue eval(IEnvironment<String,IValue> env) throws ASTRuntimeException {
		// TODO Auto-generated method stub
		IValue v1 = lhs.eval(env);
        if(v1 instanceof VInt){
            IValue v2 = rhs.eval(env);
            if(v2 instanceof VInt){
                return new VBool(((VInt)v1).getValue()<=((VInt)v2).getValue());
            }
        }
        throw new NotIntegerException("Relational comparison (<=) is only valid if the arguments are Integers!");
	}

	@Override
	public IType typecheck(IEnvironment<String, IType> env) throws IdNotFoundException, ASTTypeException
	{
		IType t1 = this.lhs.typecheck(env);
        IType t2 = this.rhs.typecheck(env);
        if(t1 instanceof TInt && t2 instanceof TInt){
            return new TInt();
        }
        throw new ASTTypeException("Type error in comparison (<=) operation: the arguments aren't of type int");
	}
	
	@Override
	public void compile(IEnvironment<String,IType> env, CodeBlock cb, int level) {
		// TODO Auto-generated method stub
	}

}
