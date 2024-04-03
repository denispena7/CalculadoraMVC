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
		
		if(botonPulsado.equals("C"))
		{
			
		}
		else if(botonPulsado.equals("+"))
		{
			
		}
		else if(botonPulsado.equals("-"))
		{
			
		}
		else if(botonPulsado.equals("*"))
		{
			
		}
		else if(botonPulsado.equals("/"))
		{
			
		}
		else if(botonPulsado.equals("="))
		{
			
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