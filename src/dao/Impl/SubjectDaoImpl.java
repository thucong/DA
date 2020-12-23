package dao.Impl;

import java.util.List;

import dao.SubjectDao;
import mapper.SubjectMapper;
import model.SubjectModel;

public class SubjectDaoImpl extends AbstractDAOImpl<SubjectModel> implements SubjectDao {
	@Override
	public SubjectModel subject(Long id_mh) {
		String sql = "SELECT * FROM monhoc WHERE id_mh = ?";
		List<SubjectModel> result = query(sql, new SubjectMapper(), id_mh);
		return result.isEmpty()?null : result.get(0);
	}
}
