package expression.modele;

import java.util.ArrayList;

import expression.Expression;
import expression.Parenthese;
import expression.VariableLibre;

public class MParenthese extends Modele {
	
	public MParenthese(){
		variablesLibres = new ArrayList<>();
		minVariables = 1;
		nbVarModifiable = false;
		
		variablesLibres.add(0);
	}
	
	public String getNom(){
		return "Parentheses";
	}
	
	@Override
	public Expression genererExpression() {
		return new Parenthese(new VariableLibre(variablesLibres.get(0)));
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("MParenthese(");
		result.append(variablesLibres.get(0));
		result.append(")");
		return result.toString();
	}

}
