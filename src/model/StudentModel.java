package model;

public class StudentModel {
	private static final long serialVersionUID = 1L;
	private Long id_user;
	private String hoten;
	private String gioitinh;
	private String ngaysinh;
	private Long id_lop;
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
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public String getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public Long getId_lop() {
		return id_lop;
	}
	public void setId_lop(Long id_lop) {
		this.id_lop = id_lop;
	}
	public Long getId_khoa() {
		return id_khoa;
	}
	public void setId_khoa(Long id_khoa) {
		this.id_khoa = id_khoa;
	}
	
	
}
