package dao;

import java.util.List;

import model.StudentInforModel;

public interface StudentInforDao extends GenericDao<StudentInforModel> {
	List<StudentInforModel> findAllByGVID(Long gvID);
}
