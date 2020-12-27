package dao;

import java.util.List;

import model.PointModel;

public interface PointDao extends GenericDao<PointModel> {
	List<PointModel> findAllByUserId(Long userId);
	List<PointModel> findSubject(Long userId, String subject);
	List<PointModel> findAllByStudent(Long id_monhoc);
	List<PointModel> findStudent(Long userId, String studentName);
	public void delete(int id);
}
