package remote.Impl;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.AccountDao;
import dao.PointDao;
import dao.StudentDao;
import dao.StudentInforDao;
import dao.TeacherDao;
import dao.Impl.AccountDaoImpl;
import dao.Impl.PointDaoImpl;
import dao.Impl.StudentDaoImpl;
import dao.Impl.StudentInforDaoImpl;
import dao.Impl.TeacherDaoImpl;
import model.AccountModel;
import model.PointModel;
import model.StudentInforModel;
import model.StudentModel;
import model.TeacherModel;
import remote.IServer;

public class ServerImpl extends UnicastRemoteObject implements IServer, Remote {

	private static final long serialVersionUID = -3329743653490415260L;
	private AccountDao accountDao;
	private StudentDao studentDao;
	private PointDao pointDao;
	private TeacherDao teacherDao;
	private StudentInforDao studentInforDao;

	public ServerImpl() throws RemoteException {
		super();
		accountDao = new AccountDaoImpl();
		studentDao = new StudentDaoImpl();
		pointDao = new PointDaoImpl();
		teacherDao = new TeacherDaoImpl();
		studentInforDao = new StudentInforDaoImpl();
	}

	@Override
	public AccountModel login(String username, String password) throws RemoteException {
		AccountModel account = accountDao.findByUsernameAndPassword(username, password);
		return account;
	}

	public StudentModel getStudentInfor(Long id_user) throws RemoteException {
		StudentModel student = studentDao.findById(id_user);
		return student;
	}
	public StudentModel getStudentInfor(Long id_user, Long id_monhoc) throws RemoteException{
		StudentModel student = studentDao.findBySubjectId(id_user, id_monhoc);
		return student;
	}
	@Override
	public List<PointModel> getPointsList(Long userId) throws RemoteException {
		return pointDao.findAllByUserId(userId);
	}

	public List<PointModel> getPointsList(Long userId,String subject) throws RemoteException {
		return pointDao.findSubject(userId,subject);
	}

	@Override
	public List<StudentInforModel> getStudentInforsList(Long gvID) throws RemoteException {
		return studentInforDao.findAllByGVID(gvID);
	}

	@Override
	public TeacherModel getTeacher(Long gvId) throws RemoteException {
		return teacherDao.teacher(gvId);
	}
}
