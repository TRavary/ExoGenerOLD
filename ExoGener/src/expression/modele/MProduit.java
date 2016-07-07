package expression.modele;

import java.util.ArrayList;

import expression.Expression;
import expression.Produit;
import expression.VariableLibre;

public class MProduit extends Modele {
	
	public MProduit(){
		variablesLibres = new ArrayList<>();
		minVariables = 2;
		nbVarModifiable = true;
		
		variablesLibres.add(0);
		variablesLibres.add(1);
	}
	
	public String getNom(){
		return "Produit";
	}
	@Override
	public Expression genererExpression() {
		ArrayList<Expression> variables = new ArrayList<>();
		for(int i=0;i<variablesLibres.size();i++){
			variables.add(new VariableLibre(variablesLibres.get(i)));
		}
		return new Produit(variables);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("MProduit(");
		result.append(variablesLibres.get(0));
		for(int i=1;i<variablesLibres.size();i++){
			result.append(",");
			result.append(variablesLibres.get(i));
		}
		result.append(")");
		return result.toString();
	}

}
