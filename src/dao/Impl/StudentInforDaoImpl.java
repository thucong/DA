package dao.Impl;

import java.util.List;

import dao.StudentInforDao;
import mapper.StudentInforMapper;
import model.StudentInforModel;

public class StudentInforDaoImpl extends AbstractDAOImpl<StudentInforModel> implements StudentInforDao {

	@Override
	public List<StudentInforModel> findAllByGVID(Long gvID) {
		StringBuilder sql = new StringBuilder("SELECT DISTINCT sinhvien.*, diem.*, monhoc.*, lop.*, users.* FROM diem ");
		sql.append("JOIN sinhvien ON sinhvien.id_user = diem.id_user ");
		sql.append("JOIN lop ON sinhvien.id_lop = lop.id_lop ");
		sql.append("JOIN monhoc ON diem.id_monhoc = monhoc.id_mh ");
		sql.append("JOIN users ON sinhvien.id_user = users.id_user ");
		sql.append("WHERE diem.id_gv = ?");
		return query(sql.toString(), new StudentInforMapper(), gvID);
	}

	@Override
	public List<StudentInforModel> findAllByGVIDAndsearchData(Long gvID, String searchData) {
		StringBuilder sql = new StringBuilder("SELECT DISTINCT sinhvien.*, diem.*, monhoc.*, lop.*, users.* FROM sinhvien ");
		sql.append("JOIN diem ON sinhvien.id_user = diem.id_user ");
		sql.append("JOIN lop ON sinhvien.id_lop = lop.id_lop ");
		sql.append("JOIN monhoc ON diem.id_monhoc = monhoc.id_mh ");
		sql.append("JOIN users ON sinhvien.id_user = users.id_user ");
		sql.append("WHERE diem.id_gv = ? AND (sinhvien.hoten like '%" + searchData + "%' ");
		sql.append(" OR lop.lop LIKE '%" + searchData + "%' OR users.username LIKE '%" + searchData + "%')");
		return query(sql.toString(), new StudentInforMapper(), gvID);
	}

	@Override
	public void delete(Long svID, Long gvID, Long mhID) {
		String sql = "DELETE FROM diem WHERE id_user = ? and id_gv = ? and id_monhoc = ?";
		update(sql, svID, gvID, mhID);
	}
}
