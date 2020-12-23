package dao.Impl;

import java.util.List;

import dao.PointDao;
import mapper.PointMapper;
import model.PointModel;

public class PointDaoImpl extends AbstractDAOImpl<PointModel> implements PointDao {

	@Override
	public List<PointModel> findAllByUserId(Long userId) {
		StringBuilder sql = new StringBuilder("SELECT TenMH, id_user, id_monhoc, diembt, diemgk, diemck ");
		sql.append("FROM diem INNER JOIN monhoc ON diem.id_monhoc = monhoc.id_mh WHERE id_user = ?");
		return query(sql.toString(), new PointMapper(), userId);
	}
}
