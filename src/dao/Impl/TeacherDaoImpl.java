package dao.Impl;

import java.util.List;

import dao.TeacherDao;

import mapper.TeacherMapper;

import model.TeacherModel;

public class TeacherDaoImpl extends AbstractDAOImpl<TeacherModel> implements TeacherDao {

	@Override
	public TeacherModel teacher(Long id_user) {
		String sql = "SELECT * FROM giangvien WHERE id_user = ?";
		List<TeacherModel> result = query(sql, new TeacherMapper(), id_user);
		return result.isEmpty()?null : result.get(0);
		
	}
	
}
