package expression;

abstract class Operateur extends Expression {
	
	protected String symbole;

	@Override
	public String toString(String destination) {
		StringBuilder result = new StringBuilder();
		Expression op0 = operandes.get(0);
		if(op0.priorite<this.priorite){
			result.append("(");
			result.append(op0.toString(destination));
			result.append(")");
		}
		else{
			result.append(op0.toString(destination));
		}
		for(int i=1;i<nbTermes();i++)
		{
			Expression opi = operandes.get(i);
			if(opi.toString(destination).startsWith("-") && this.symbole.equals("+"))
			{
				result.append(opi.toString(destination));
			}
			else{
				result.append(symbole);
				if(opi.priorite<this.priorite || opi.toString(destination).startsWith("-"))
				{
					result.append("(");
					result.append(opi.toString(destination));
					result.append(")");
				}
				else{
					result.append(opi.toString(destination));
				}
			}	
		}
		return result.toString();
	}
	
	
}
