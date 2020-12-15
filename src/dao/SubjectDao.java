package dao;

import model.SubjectModel;

public interface SubjectDao extends GenericDao<SubjectModel> {
	SubjectModel subject(Long id_mh);
	
}
