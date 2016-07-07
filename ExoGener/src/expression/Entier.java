package expression;

import java.util.ArrayList;

import outils.Pair;

public class Entier extends Terme {
	int valeur;
	
	public Entier(int valeur){
		if(valeur>=0){
			priorite = Expression.prioriteParenthese;
		}
		else{
			priorite = Expression.prioriteProduit;
		}
		this.valeur = valeur;
		this.operandes = new ArrayList<>();
	}
	
	@Override
	public String toString(String destination) {
		return String.valueOf(valeur);
	}

	@Override
	public Expression Remplacer(ArrayList<Pair<String, Expression>> liste) {
		return new Entier(valeur);
	}
	
	@Override
	public boolean isVariable(String nom)
	{
		return false;
	}
}
