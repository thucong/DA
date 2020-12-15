package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

import model.AccountModel;
import model.StudentModel;

public interface IServer extends Remote {
	
	public AccountModel login(String username, String password) throws RemoteException;
	public StudentModel list(Long id_user) throws RemoteException;
}
