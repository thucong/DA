package dao;

import model.UserSubjectModel;

public interface UserSubjectDao extends GenericDao<UserSubjectModel> {
	UserSubjectModel model(Long id_user, Long id_mh);
}
