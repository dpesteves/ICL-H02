package ast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import exceptions.ASTRuntimeException;
import exceptions.ASTTypeException;
import exceptions.IdNotFoundException;
import objects.CodeBlock;
import objects.IEnvironment;
import types.IType;
import values.IValue;

public class ASTLet implements ASTNode {
	
	private class Declaration{
        private IType type;
        private String id;
        private ASTNode val;

        Declaration(IType type, String id, ASTNode val) {
            this.type = type;
            this.id = id;
            this.val = val;
        }

        private String getId() {
            return id;
        }

        private ASTNode getVal() {
            return val;
        }

        private IType getType() {
            return type;
        }
    }

	private List<Declaration> declarations;
	private ASTNode body;
	
	public ASTLet() {
		this.declarations = new ArrayList<Declaration>();
	}
	
	public void insertDeclaration(IType type, String id, ASTNode val) {
		this.declarations.add(new Declaration(type, id, val));
	}
	public void setBody(ASTNode body) {
		this.body = body;
	}
	
	@Override
	public IValue eval(IEnvironment<String, IValue> env) throws ASTRuntimeException {
		// TODO Auto-generated method stub
		IEnvironment<String, IValue> env2 = env.beginScope();
		
		for(Declaration d : declarations) {
			IValue a = d.getVal().eval(env);
			env2.assoc(d.getId(), a);
		}
		
		env = env2;
		
		IValue b = body.eval(env);
		env = env.endScope();
		
		return b;
	}

	@Override
	public IType typecheck(IEnvironment<String, IType> env) throws ASTTypeException, IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void compile(IEnvironment env, CodeBlock cb, int level) {
		// TODO Auto-generated method stub
//		int currentLevel = level + 1;
//		
//		for(Map.Entry<String, ASTNode> entry : map.entrySet()) {
//			env.assoc(entry.getKey(), currentLevel);
//		}
//		
//		String frameId = "f" + currentLevel;
//		cb.emit("new " + frameId);
//		cb.emit("dup");
//		cb.emit("invokespecial " + frameId + "/<init>()V");
//		cb.emit("dup");
//		cb.emit("aload " + currentLevel);
	}

}
