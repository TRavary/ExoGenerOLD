package expression.modele;

import java.util.ArrayList;

import expression.Expression;
import expression.Quotient;
import expression.VariableLibre;

public class MQuotient extends Modele {
	
	public MQuotient(){
		variablesLibres = new ArrayList<>();
		minVariables = 2;
		nbVarModifiable = false;
		
		variablesLibres.add(0);
		variablesLibres.add(1);
	}
	
	public String getNom(){
		return "Quotient";
	}
	@Override
	public Expression genererExpression() {
		return new Quotient(new VariableLibre(variablesLibres.get(0)),new VariableLibre(variablesLibres.get(1)));
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("MQuotient(");
		result.append(variablesLibres.get(0));
		result.append(",");
		result.append(variablesLibres.get(1));
		result.append(")");
		return result.toString();
	}

}
