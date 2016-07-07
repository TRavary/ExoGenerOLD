package expression;

import java.util.ArrayList;

import outils.Pair;

public class Somme extends Operateur {
	
	public Somme(Expression op1, Expression op2, Expression... ops){
		priorite = Expression.prioriteSomme;
		symbole = "+";
		operandes = new ArrayList<>();
		operandes.add(op1);
		operandes.add(op2);
		for(int i=0;i<ops.length;i++){operandes.add(ops[i]);}
	}
	
	public Somme(ArrayList<Expression> ops)
	{
		priorite = Expression.prioriteSomme;
		symbole = "+";
		operandes = new ArrayList<>();
		for(int i=0;i<ops.size();i++){operandes.add(ops.get(i));}
	}
	
	public static void test(){
		
		Entier deux = new Entier(2);
		Entier m1 = new Entier(-1);
		Variable x = new Variable("x");
		
		System.out.println("Test somme :");
		System.out.print("2+2 -> ");
		System.out.println(new Somme(deux,deux));
		
		System.out.print("-1+(-1) -> ");
		System.out.println(new Somme(m1,m1));
		
		System.out.print("-1+(-1)+(-1)+(-1)+(-1) -> ");
		System.out.println(new Somme(m1,m1,m1,m1,m1));
		
		System.out.print("((-1)+(-1))+(-1)*(-1)+(-1)/(-1)+(-1)^(-1)+Racine(-1) -> ");
		System.out.println(new Somme(new Somme(m1,m1),new Produit(m1,m1),new Quotient(m1,m1),new Puissance(m1,m1),new Racine(m1)));
		
		System.out.print("parenthese(x+x)+oppose(x-x) -> ");
		System.out.println(new Somme(new Parenthese(new Somme(x,x)),new Oppose(new Somme(x,new Oppose(x)))));
		
		System.out.println("");
	}

	@Override
	public Expression Remplacer(ArrayList<Pair<String, Expression>> liste) {
		ArrayList<Expression> newOps = new ArrayList<>();
		for(int i = 0;i<nbTermes();i++){
			newOps.add(operandes.get(i).Remplacer(liste));
		}
		return new Somme(newOps);
	}
}