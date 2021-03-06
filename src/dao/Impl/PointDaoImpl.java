package dao.Impl;

import java.util.List;

import dao.PointDao;
import mapper.PointMapper;
import model.PointModel;

public class PointDaoImpl extends AbstractDAOImpl<PointModel> implements PointDao {

	@Override
	public List<PointModel> findAllByUserId(Long userId) {
		StringBuilder sql = new StringBuilder("SELECT TenMH, id_user, id_monhoc, diembt, diemgk, diemck, diemtb "); 
		sql.append("FROM diem INNER JOIN monhoc ON diem.id_monhoc = monhoc.id_mh WHERE id_user = ?");
		return query(sql.toString(), new PointMapper(), userId);
	}
	public List<PointModel> findSubject(Long userId, String subject){
		StringBuilder sql = new StringBuilder("SELECT TenMH, id_user, id_monhoc, diembt, diemgk, diemck, diemtb "); 
		sql.append("FROM diem INNER JOIN monhoc ON diem.id_monhoc = monhoc.id_mh WHERE id_user = ? and TenMH like '%" + subject + "%'");
		return query(sql.toString(), new PointMapper(), userId);
	}
	public List<PointModel> findAllByStudent(Long id_monhoc){
		StringBuilder sql = new StringBuilder("SELECT hoten, ngaysinh, lop, diembt, diemgk, diemck ");
		sql.append("FROM diem INNER JOIN monhoc ON diem.id_monhoc = monhoc.id_monhoc INNER JOIN sinhvien ON diem.id_user = sinhvien.id_user WHERE id_monhoc = ?");
		return query(sql.toString(), new PointMapper(),id_monhoc);
	}
	public List<PointModel> findStudent(Long userId, String studentName){
		StringBuilder sql = new StringBuilder("SELECT sinhvien.*, diem.*, monhoc.*, lop.* FROM sinhvien ");
		sql.append("JOIN diem ON sinhvien.id_user = diem.id_user ");
		sql.append("JOIN lop ON sinhvien.id_lop = lop.id_lop ");
		sql.append("JOIN monhoc ON diem.id_monhoc = monhoc.id_mh ");
		sql.append("WHERE sinhvien.hoten like '%"+studentName+"%'");
		return query(sql.toString(), new PointMapper(), userId, studentName);
	}
	
	public void delete(int id) {
		String sql = "DELETE FROM diem WHERE id = ?";
		update(sql, id);
	}
	
}
