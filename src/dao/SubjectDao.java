package dao;

import java.util.List;

import model.SubjectModel;

public interface SubjectDao extends GenericDao<SubjectModel> {
	SubjectModel subject(Long id_mh);
	List<SubjectModel> findAllByGVID(Long gvID);
}
