package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.PointModel;

public class PointMapper implements RowMapper<PointModel> {

	@Override
	public PointModel mapRow(ResultSet resultSet) {
		try {
			PointModel model = new PointModel();
			model.setUserId(resultSet.getLong("id_user"));
			model.setSubjectId(resultSet.getLong("id_monhoc"));
			model.setHomeworkPoint(resultSet.getDouble("diembt"));
			model.setMidTermPoint(resultSet.getDouble("diemgk"));
			model.setEndTermPoint(resultSet.getDouble("diemck"));
			model.setSubjectName(resultSet.getString("TenMH"));
			return model;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
