package dao;

import model.StudentModel;

public interface StudentDao extends GenericDao<StudentModel> {
	StudentModel student(Long id_user);
}
