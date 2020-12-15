package dao;

import model.TeacherModel;

public interface TeacherDao extends GenericDao<TeacherModel> {
	TeacherModel teacher(Long id_user);
}
