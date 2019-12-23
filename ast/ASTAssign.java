package ast;

import exceptions.ASTRuntimeException;
import exceptions.ASTTypeException;
import exceptions.IdNotFoundException;
import exceptions.NonReferenceAssignmentException;
import objects.CodeBlock;
import objects.IEnvironment;
import types.IType;
import types.TRef;
import values.IValue;
import values.VCell;

public class ASTAssign implements ASTNode {

	private ASTNode lhs, rhs;
    private IType lhsType, rhsType;
    
    public ASTAssign(ASTNode lhs, ASTNode rhs) {
    	this.lhs = lhs;
    	this.rhs = rhs;
    	this.lhsType = null;
    	this.rhsType = null;
    }
	
	@Override
	public IValue eval(IEnvironment<String, IValue> env) throws ASTRuntimeException {
		// TODO Auto-generated method stub
		IValue v1 = this.lhs.eval(env);
        if(v1 instanceof VCell){
            IValue v2 = this.rhs.eval(env);
            ((VCell) v1).set(v2);
            return v1;
        }
        throw new NonReferenceAssignmentException("Assigning is only valid if the arguments are Cells!");
	}

	@Override
	public IType typecheck(IEnvironment<String, IType> env) throws ASTTypeException, IdNotFoundException {
		// TODO Auto-generated method stub
		this.lhsType = this.lhs.typecheck(env);
        if(this.lhsType instanceof TRef){
            this.rhsType = this.rhs.typecheck(env);
            return lhsType;
        }
        throw new ASTTypeException("Assigning to non reference type!");
	}

	@Override
	public void compile(IEnvironment<String, IType> env, CodeBlock cb, int level) {
		// TODO Auto-generated method stub

	}

}
