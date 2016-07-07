package expression.modele;

import java.util.ArrayList;

public class MManager extends MArbre {
	
	public MManager(){
		
	}
	
	public Modele getModele(int idModele){
		return modeles.get(idModele);
	}
	
	public int getLastIdModele(){
		return modeles.size()-1;
	}
	
	public ArrayList<Integer> getVariablesLibres(int idModele){
		return variablesLibres;
	}
	
	public boolean isLien(int variable){
		return variable2idModele.containsKey(variable);
	}
	
	public int getIdLien(int variable){
		if(isLien(variable)){
			return variable2idModele.get(variable);
		}
		return -1;
	}
	
}
