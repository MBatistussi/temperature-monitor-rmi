package com.mbatistussi.rmiinterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIInterface extends Remote {

	public String curitiba(String city, int min, int max) throws RemoteException, InterruptedException;
	public String natal(String city, int min, int max) throws RemoteException, InterruptedException;
	public String rio(String city, int min, int max) throws RemoteException, InterruptedException;
	public String fortaleza(String city, int min, int max) throws RemoteException, InterruptedException;
	public String recife(String txt, int minTemp, int maxTemp) throws RemoteException, InterruptedException;

}