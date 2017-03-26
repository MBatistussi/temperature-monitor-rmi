package com.mbatistussi.rmiserver;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import com.mbatistussi.rmiinterface.RMIInterface;
import java.util.Random;

public class ServerFortaleza extends UnicastRemoteObject implements RMIInterface{

    private static final long serialVersionUID = 1L;

    public ServerFortaleza() throws RemoteException {

        super();

    }

    
    public String fortaleza(String city, int min, int max) throws RemoteException, InterruptedException{

        System.err.println("Você deseja receber alertas da cidade de " + city);
        while (true){
        	Random r = new Random();
        	int nextTemp = (int) (r.nextGaussian()*8+22);
        	Thread.sleep(1000);
        	if (nextTemp < min){
        		return "Alerta: A temperatura está em " + nextTemp + "°C, abaixo do mínimo indicado por você";
        	}
        	else if (nextTemp > max){
        		return "Alerta: A temperatura está em " + nextTemp + "°C, acima do máximo indicado por você";
        	}
        }

    }

    public static void main(String[] args){

        try {

            Naming.rebind("//localhost/ServerFortaleza", new ServerFortaleza());
            System.err.println("Server Fortaleza ready");

        } catch (Exception e) {

            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();

        }

    }


	@Override
	public String curitiba(String city, int min, int max) throws RemoteException, InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String natal(String city, int min, int max) throws RemoteException, InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String rio(String city, int min, int max) throws RemoteException, InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String recife(String txt, int minTemp, int maxTemp) throws RemoteException, InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}


}