package dao;

import model.StudentModel;

public interface StudentDao extends GenericDao<StudentModel> {
	StudentModel findById(Long id_user);
}
