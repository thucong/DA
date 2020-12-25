package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import model.AccountModel;
import model.PointModel;
import model.StudentModel;

public interface IServer extends Remote {
	
	public AccountModel login(String username, String password) throws RemoteException;
	public StudentModel getStudentInfor(Long id_user) throws RemoteException;
	
	public List<PointModel> getPointsList(Long userId) throws RemoteException;
	public List<PointModel> getPointsList( String subject) throws RemoteException;
}
