package expression.modele;

import java.util.ArrayList;

import expression.Expression;
import expression.Somme;
import expression.VariableLibre;

public class MSomme extends Modele {
	
	public MSomme(){
		variablesLibres = new ArrayList<>();
		minVariables = 2;
		nbVarModifiable = true;
		
		variablesLibres.add(0);
		variablesLibres.add(1);
	}
	
	public String getNom(){
		return "Somme";
	}
	
	@Override
	public Expression genererExpression() {
		ArrayList<Expression> variables = new ArrayList<>();
		for(int i=0;i<variablesLibres.size();i++){
			variables.add(new VariableLibre(variablesLibres.get(i)));
		}
		return new Somme(variables);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("MSomme(");
		result.append(variablesLibres.get(0));
		for(int i=1;i<variablesLibres.size();i++){
			result.append(",");
			result.append(variablesLibres.get(i));
		}
		result.append(")");
		return result.toString();
	}

}
