package com.mbatistussi.rmiclient;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import com.mbatistussi.rmiinterface.RMIInterface;
public class ClientOperation {

	private static RMIInterface look_up;

	public static void main(String[] args)
		throws MalformedURLException, RemoteException, NotBoundException, InterruptedException {

		
		String txt = JOptionPane.showInputDialog("De qual cidade você quer receber notificações de temperatura?");
		int minTemp = Integer.parseInt(JOptionPane.showInputDialog("Qual a temperatura mínima que deseja?"));
		int maxTemp = Integer.parseInt (JOptionPane.showInputDialog("Qual a temperatura máxima que deseja?"));
		txt.toLowerCase();
		System.out.println(txt);
		
		String response = "";
		if (txt.equals("natal")){
			look_up = (RMIInterface) Naming.lookup("//localhost/ServerNatal");
			response = look_up.natal(txt, minTemp, maxTemp);
		}
		else if (txt.equals("curitiba")){
			look_up = (RMIInterface) Naming.lookup("//localhost/ServerCuritiba");
			response = look_up.curitiba(txt, minTemp, maxTemp);
		}
		else if (txt.equals("fortaleza")){
			look_up = (RMIInterface) Naming.lookup("//localhost/ServerFortaleza");
			response = look_up.fortaleza(txt, minTemp, maxTemp);
		}
		else if (txt.equals("rio") || txt.equals("rio de janeiro")){
			look_up = (RMIInterface) Naming.lookup("//localhost/ServerRio");
			response = look_up.rio(txt, minTemp, maxTemp);
		}
		else if (txt.equals("recife") || txt.equals("recife")){
			look_up = (RMIInterface) Naming.lookup("//localhost/ServerRecife");
			response = look_up.recife(txt, minTemp, maxTemp);
		}
		else{
			System.out.println("não entrou em nada");
		}
		JOptionPane.showMessageDialog(null, response);

	}

}