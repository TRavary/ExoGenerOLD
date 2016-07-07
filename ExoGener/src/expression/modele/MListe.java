package expression.modele;

import java.util.ArrayList;
import expression.Expression;
import expression.VariableLibre;


public class MListe extends Modele {
	public MListe(){
		variablesLibres = new ArrayList<>();
		variablesLibres.add(0);
		variablesLibres.add(1);
		minVariables = 2;
		nbVarModifiable = true;
	}
	public String getNom(){
		return "Liste";
	}
	@Override
	public Expression genererExpression() {
		double seuil = Math.random();
		double u = 0;
		for(int i=0;i<variablesLibres.size();i++){
			u+=1./variablesLibres.size();
			if(u>seuil)
			{
				return new VariableLibre(variablesLibres.get(i));
			}
		}
		return new VariableLibre(variablesLibres.get(variablesLibres.size()-1));
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("MListe(");
		result.append(variablesLibres.get(0));
		for(int i=1;i<variablesLibres.size();i++){
			result.append(",");
			result.append(variablesLibres.get(i));
		}
		result.append(")");
		return result.toString();
	}
}
