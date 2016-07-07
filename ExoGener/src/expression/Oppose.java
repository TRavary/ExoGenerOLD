package expression;

import java.util.ArrayList;

import outils.Pair;

public class Oppose extends Operateur {

	public Oppose(Expression op){
		symbole ="-";
		priorite = Expression.prioriteProduit;
		operandes = new ArrayList<>();
		operandes.add(op);
	}
	
	@Override
	public String toString(String destination){
		StringBuilder result = new StringBuilder();
		result.append("-");
		Expression op = operandes.get(0);
		if(op.toString(destination).startsWith("-") || op.priorite<this.priorite){
			result.append("(");
			result.append(op.toString(destination));
			result.append(")");
		}
		else{
			result.append(op.toString(destination));
		}
		return result.toString();
	}

	@Override
	public Expression Remplacer(ArrayList<Pair<String, Expression>> liste) {
		return new Oppose(operandes.get(0).Remplacer(liste));
	}
	

}
