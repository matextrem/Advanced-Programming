package com.tpa.streetnumbers;

public class StreetNumbers {

	
	public static int getStreetNumber(int total) {
		int cantCasas = total; 
		int result = 0;
		long sumaD=total;
		long sumaI=1;
		for(int i = 2; i <cantCasas; i++){
		  if(sumaI > sumaD){
			cantCasas--;
			sumaD += cantCasas;
			i--;
		  }else{
			  sumaI += i;
		  }
		  if(sumaD == sumaI){
				result = i + 1;
		  }
		}
		return result;
		
	}
}
