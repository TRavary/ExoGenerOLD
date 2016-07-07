package expression;

import java.util.ArrayList;

import outils.Pair;

public class Variable extends Terme {
	String nom;
	
	public Variable(String nom){
		priorite = Expression.prioriteParenthese;
		this.nom = nom;
		this.operandes = new ArrayList<>();
	}
	
	@Override
	public String toString(String destination) {
		return nom;
	}

	@Override
	public Expression Remplacer(ArrayList<Pair<String, Expression>> liste) {
		for(int i=0;i<liste.size();i++)
		{
			if(nom.equals(liste.get(i).left))
			{
				return liste.get(i).right;
			}
		}
		return new Variable(nom);
	}
	
	@Override
	public boolean isVariable(String nom){
		if(this.nom.equals(nom)){return true;}
		return false;
	}
	
	


}
