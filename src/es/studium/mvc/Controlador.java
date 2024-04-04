package es.studium.mvc;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Controlador implements WindowListener, ActionListener
{
	Modelo modelo;
	Vista vista;

	int operador1 = 0;
	int operador2 = 0;
	String operacion;
	boolean nuevoNumeroEnPantalla;

	public Controlador(Modelo m, Vista v) 
	{
		modelo = m;
		vista = v;

		v.ventana.addWindowListener(this);

		v.boton0.addActionListener(this);
		v.boton1.addActionListener(this);
		v.boton2.addActionListener(this);
		v.boton3.addActionListener(this);
		v.boton4.addActionListener(this);
		v.boton5.addActionListener(this);
		v.boton6.addActionListener(this);
		v.boton7.addActionListener(this);
		v.boton8.addActionListener(this);
		v.boton9.addActionListener(this);
		v.botonSuma.addActionListener(this);
		v.botonResta.addActionListener(this);
		v.botonMult.addActionListener(this);
		v.botonDiv.addActionListener(this);
		v.botonIgual.addActionListener(this);
		v.botonC.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String botonPulsado = ((Button) e.getSource()).getLabel();
		
		if (botonPulsado.equals("C")) 
		{
			vista.pantalla.setText("0");
			operador1 = 0;
			operador2 = 0;
			nuevoNumeroEnPantalla = true;
		}
		else if (botonPulsado.equals("+") || botonPulsado.equals("-") 
				|| botonPulsado.equals("*") || botonPulsado.equals("/")) 
		{
			operacion = botonPulsado;
			operador1 = Integer.parseInt(vista.pantalla.getText());
			nuevoNumeroEnPantalla = true;
		}
		else if (botonPulsado.equals("=")) 
		{
			operador2 = Integer.parseInt(vista.pantalla.getText());
			if (operacion != null) 
			{
				if (operacion.equals("+")) 
				{
					// Uso de la función suma creada en el modelo
					vista.pantalla.setText(modelo.suma(operador1, operador2));
				} 
				else if (operacion.equals("-")) 
				{
					// Uso de la función resta creada en el modelo
					vista.pantalla.setText(modelo.resta(operador1, operador2));
				} 
				else if (operacion.equals("*")) 
				{
					// Uso de la función mult creada en el modelo
					vista.pantalla.setText(modelo.mult(operador1, operador2));
				} 
				else if (operacion.equals("/")) 
				{
					// Uso de la función div creada en el modelo
					vista.pantalla.setText(modelo.div(operador1, operador2));
				}
			}
			
			nuevoNumeroEnPantalla = true;
			operacion = null;
		}
		else
		{
			if(nuevoNumeroEnPantalla == true) 
			{
				vista.pantalla.setText(botonPulsado);
				nuevoNumeroEnPantalla = false;
			} 
			else 
			{
				vista.pantalla.setText(vista.pantalla.getText() + botonPulsado);

				if((vista.pantalla.getText().length() > 1) &&
						(vista.pantalla.getText().charAt(0) == '0')) 
				{
					vista.pantalla.setText(vista.pantalla.getText().substring(1));
				}
			}
		}
	}

	@Override
	public void windowClosing(WindowEvent arg0) 
	{
		System.exit(0);
	}

	@Override
	public void windowActivated(WindowEvent arg0) {}
	@Override
	public void windowClosed(WindowEvent arg0) {}
	@Override
	public void windowDeactivated(WindowEvent arg0) {}
	@Override
	public void windowDeiconified(WindowEvent arg0) {}
	@Override
	public void windowIconified(WindowEvent arg0) {}
	@Override
	public void windowOpened(WindowEvent arg0) {}
}