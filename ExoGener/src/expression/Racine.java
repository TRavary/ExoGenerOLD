package expression;

import java.util.ArrayList;

import outils.Pair;

public class Racine extends Operateur {

	public Racine(Expression op){
		symbole ="racine(";
		priorite = Expression.prioriteParenthese;
		operandes = new ArrayList<>();
		operandes.add(op);
	}
	
	@Override
	public String toString(String destination){
		StringBuilder result = new StringBuilder();
		if(destination.equals(Expression.destinationLatex)){
			result.append("\\sqrt{");
			result.append(operandes.get(0).toString(destination));
			result.append("}");
		}
		else{
			result.append(symbole);
			result.append(operandes.get(0).toString(destination));
			result.append(")");
		}
		return result.toString();
	}

	@Override
	public Expression Remplacer(ArrayList<Pair<String, Expression>> liste) {
		return new Racine(operandes.get(0).Remplacer(liste));
	}
	
}
