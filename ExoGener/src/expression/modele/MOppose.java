package expression.modele;

import java.util.ArrayList;

import expression.Expression;
import expression.Oppose;
import expression.VariableLibre;

public class MOppose extends Modele {
	
	public MOppose(){
		variablesLibres = new ArrayList<>();
		minVariables = 1;
		nbVarModifiable = false;
		
		variablesLibres.add(0);
	}
	public String getNom(){
		return "Oppose";
	}
	@Override
	public Expression genererExpression() {
		return new Oppose(new VariableLibre(variablesLibres.get(0)));
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("MOppose(");
		result.append(variablesLibres.get(0));
		result.append(")");
		return result.toString();
	}

}
