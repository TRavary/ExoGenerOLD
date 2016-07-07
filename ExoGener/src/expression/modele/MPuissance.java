package expression.modele;

import java.util.ArrayList;

import expression.Expression;
import expression.Puissance;
import expression.VariableLibre;

public class MPuissance extends Modele {
	
	public MPuissance(){
		variablesLibres = new ArrayList<>();
		minVariables = 2;
		nbVarModifiable = false;
		
		variablesLibres.add(0);
		variablesLibres.add(1);
	}
	
	public String getNom(){
		return "Puissance";
	}
	@Override
	public Expression genererExpression() {
		return new Puissance(new VariableLibre(variablesLibres.get(0)),new VariableLibre(variablesLibres.get(1)));
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("MPuissance(");
		result.append(variablesLibres.get(0));
		result.append(",");
		result.append(variablesLibres.get(1));
		result.append(")");
		return result.toString();
	}

}
