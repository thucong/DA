package dao;

import model.StudentModel;

public interface StudentDao extends GenericDao<StudentModel> {
	StudentModel findById(Long id_user);
	StudentModel findBySubjectId(Long id_user,Long id_monhoc);
}
