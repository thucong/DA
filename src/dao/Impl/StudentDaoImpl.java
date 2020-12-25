package dao.Impl;

import java.util.ArrayList;
import java.util.List;

import dao.StudentDao;
import mapper.StudentMapper;
import model.StudentModel;

public class StudentDaoImpl extends AbstractDAOImpl<StudentModel> implements StudentDao{
	
	@Override
	public StudentModel findById(Long id_user) {
		String sql = "SELECT * FROM sinhvien WHERE id_user = ?";
		List<StudentModel> result = query(sql, new StudentMapper(), id_user);
		return result.isEmpty()?null : result.get(0);
	}

	@Override
	public StudentModel findBySubjectId(Long id_user, Long id_monhoc) {
		String sql = "SELECT * FROM sinvien WHERE id_user = ";
		List<StudentModel> result = query(sql, new StudentMapper(), id_user, id_monhoc);
		return result.isEmpty()?null : result.get(0);
	}

	
}
