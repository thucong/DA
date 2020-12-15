package model;

public class TeacherModel {
	private Long id_user;
	private String hoten;
	private String ngaysinh;
	private String gioitinh;
	private Long id_khoa;
	public Long getId_user() {
		return id_user;
	}
	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public Long getId_khoa() {
		return id_khoa;
	}
	public void setId_khoa(Long id_khoa) {
		this.id_khoa = id_khoa;
	}
	
}
