package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Student;
import com.mysql.cj.protocol.Resultset;

public class StudentDao {

	private Connection con;

	public StudentDao(Connection con) {
		
		this.con = con;
	}
	
	public boolean registerStudent(Student st) {
		boolean f=false;
		
		try {
			String sql="insert into student (name,dob,address,qualification,email) values(?,?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,st.getFullName());
			ps.setString(2,st.getDob());
			ps.setString(3,st.getAddress());
			ps.setString(4,st.getQualification());
			ps.setString(5,st.getEmail());
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
					
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return f;
	}
	
	public List<Student> getAllStudent(){
		List<Student> list = new ArrayList<Student>();
		Student st=null;
		try {
			String sql="select * from student";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				st=new Student();
				st.setId(rs.getInt(1));
				st.setFullName(rs.getString(2));
				st.setDob(rs.getString(3));
				st.setAddress(rs.getString(4));
				st.setQualification(rs.getString(5));
				st.setEmail(rs.getString(6));
				list.add(st);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	
	public Student getDetailById(int id) {
		Student st=null;
		try {
			
			String sql="select * from student where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				st=new Student();
				st.setId(rs.getInt(1));
				st.setFullName(rs.getString(2));
				st.setDob(rs.getString(3));
				st.setAddress(rs.getString(4));
				st.setQualification(rs.getString(5));
				st.setEmail(rs.getString(6));
			}	
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return st;
		}
	
	
	public boolean updateStudent(Student st) {
		boolean f=false;
		
		try {
			String sql = "update student set name=?,dob=?,address=?,qualification=?,email=? where id =?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,st.getFullName());
			ps.setString(2,st.getDob());
			ps.setString(3,st.getAddress());
			ps.setString(4,st.getQualification());
			ps.setString(5,st.getEmail());
			ps.setInt(6, st.getId());
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
					
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return f;
	}
	
	
	public boolean deleteStudent(int id) {
		boolean f=false;
		try {
			
			String sql="delete from student where id=?";
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setInt(1, id);
			int i=ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return f;
	}
	

	
}
