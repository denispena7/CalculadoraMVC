package es.studium.mvc;

public class Modelo 
{
	public String suma(int op1, int op2)
	{
		int resultado = op1 + op2;
		return resultado + "";
	}

	public String resta(int op1, int op2) 
	{
		int resultado = op1 - op2;
		return resultado + "";
	}
	
	public String mult(int op1,int op2)
	{
		int resultado = op1 * op2;
		return resultado + "";
	}
	
	public String div(int op1, int op2)
	{
		int resultado = op1 / op2;
		return resultado + "";
	}
}


