package expression.modele;

import java.util.ArrayList;

import expression.Expression;
import expression.Racine;
import expression.VariableLibre;

public class MRacine extends Modele {
	
	public MRacine(){
		variablesLibres = new ArrayList<>();
		minVariables = 1;
		nbVarModifiable = false;
		
		variablesLibres.add(0);
	}

	public String getNom(){
		return "Racine carrée";
	}
	
	@Override
	public Expression genererExpression() {
		return new Racine(new VariableLibre(variablesLibres.get(0)));
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("MRacine(");
		result.append(variablesLibres.get(0));
		result.append(")");
		return result.toString();
	}

}
