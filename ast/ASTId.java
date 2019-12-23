package ast;

import java.io.FileNotFoundException;

import exceptions.ASTTypeException;
import exceptions.IdNotFoundException;
import objects.CodeBlock;
import objects.IEnvironment;
import types.IType;
import values.IValue;

public class ASTId implements ASTNode {
	private String id;

	public ASTId(String id) {
		this.id = id;
	}

	@Override
	public IValue eval(IEnvironment<String, IValue> env) {
		// TODO Auto-generated method stub
		IValue eval = env.find(id);
		
		do {
			if(env.find(id) != null) {
				eval = env.find(id);
				break;
			}
			else
				env = env.endScope();
		} while(env != null);
		
		return eval;
	}
	
	@Override
    public IType typecheck(IEnvironment<String, IType> env) throws ASTTypeException, IdNotFoundException {
        IType type = env.find(this.id);
        if(type == null){
            throw new IdNotFoundException("The declaration of '"+this.id+"' was not found!");
        }
        return type;
    }

	
	@Override
	public void compile(IEnvironment env, CodeBlock cb, int level) {
		// TODO Auto-generated method stub
		int currLevel = level + 1;
		cb.emit("aload SL");
		for(int i=0; i<currLevel; i++)
			cb.emit(String.format("getfield f%s/sl f%s", currLevel - i, level - i));
		cb.emit(String.format("getfield f%s/%s Ljava/lang/Object", currLevel, id));
		try {
			cb.dump("compile");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
