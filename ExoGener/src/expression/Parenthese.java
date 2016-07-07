package expression;

import java.util.ArrayList;

import outils.Pair;

public class Parenthese extends Operateur {
	
	public Parenthese(Expression op){
		symbole ="(";
		priorite = Expression.prioriteParenthese;
		operandes = new ArrayList<>();
		operandes.add(op);
	}
	
	@Override
	public String toString(String destination){
		StringBuilder result = new StringBuilder();
		result.append(symbole);
		result.append(operandes.get(0).toString(destination));
		result.append(")");
		return result.toString();
	}

	@Override
	public Expression Remplacer(ArrayList<Pair<String, Expression>> liste) {
		return new Parenthese(operandes.get(0).Remplacer(liste));
	}
	
	

}
