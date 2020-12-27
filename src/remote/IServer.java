package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import model.AccountModel;
import model.PointModel;
import model.StudentInforModel;
import model.StudentModel;
import model.SubjectModel;
import model.TeacherModel;

public interface IServer extends Remote {
	
	public AccountModel login(String username, String password) throws RemoteException;
	public StudentModel getStudentInfor(Long id_user) throws RemoteException;
	public StudentModel getStudentInfor(Long id_user, Long id_monhoc) throws RemoteException;
	public List<PointModel> getPointsList(Long userId) throws RemoteException;
	public List<PointModel> getPointsList(Long userId, String subject) throws RemoteException;
	public List<StudentInforModel> getStudentInforsList(Long gvID) throws RemoteException;
	public List<StudentInforModel> getStudentInforsListBysearchData(Long gvID, String searchData) throws RemoteException;
	public TeacherModel getTeacher(Long gvId) throws RemoteException; 
	public List<PointModel> getPointsListSt(Long userId, String studentName) throws RemoteException;
	
	void deletePoint(int id) throws RemoteException;
	List<SubjectModel> findAllByGVID(Long gvId) throws RemoteException;
}
