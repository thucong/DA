package dao.Impl;

import java.util.List;

import dao.StudentInforDao;
import mapper.StudentInforMapper;
import model.StudentInforModel;

public class StudentInforDaoImpl extends AbstractDAOImpl<StudentInforModel> implements StudentInforDao {

	@Override
	public List<StudentInforModel> findAllByGVID(Long gvID) {
		StringBuilder sql = new StringBuilder("SELECT sinhvien.*, diem.*, monhoc.*, lop.* FROM sinhvien ");
		sql.append("JOIN diem ON sinhvien.id_user = diem.id_user ");
		sql.append("JOIN lop ON sinhvien.id_lop = lop.id_lop ");
		sql.append("JOIN monhoc ON diem.id_monhoc = monhoc.id_mh ");
		sql.append("WHERE diem.id_gv = ?");
		return query(sql.toString(), new StudentInforMapper(), gvID);
	}
}
