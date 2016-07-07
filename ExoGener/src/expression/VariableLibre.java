package expression;

import java.util.ArrayList;

import outils.Pair;

public class VariableLibre extends Terme {
	int numero;
	
	public VariableLibre(int numero)
	{
		this.numero = numero;
		this.operandes = new ArrayList<>();
		priorite=Expression.prioriteParenthese;
	}
	
	public static String getNom(int numero){
		String result = "%";
		result = result.concat(String.valueOf(numero));
		return result;
	}
	
	public static int getNumero(String nom){
		return Integer.valueOf(nom.substring(1));
	}
	
	@Override
	public String toString(String destination) {
		return VariableLibre.getNom(numero);
	}

	@Override
	public Expression Remplacer(ArrayList<Pair<String, Expression>> liste) {
		for(int i=0;i<liste.size();i++)
		{
			if(toString().equals(liste.get(i).left))
			{
				return liste.get(i).right;
			}
		}
		return new VariableLibre(numero);
	}
	
	@Override
	public boolean isVariable(String nom){
		if(this.toString().equals(nom)){return true;}
		return false;
	}
	
	@Override
	public int getNextVariableLibre(int curVar){
		if(numero>curVar){return numero;}
		return -1;
	}
}
