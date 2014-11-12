package com.stu.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.stu.bean.Student;
import com.stu.bean.User;


public class Main {
	Connection conn=null;
	public static void main(String[] args) throws SQLException {

	}

	public Student createStudent(Student bean) {

		conn=DBUtil.getInstance().getConnection();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		boolean insert=true;
		try {
			stmt=conn.prepareStatement("select id from stu where id=?");
			stmt.setInt(1, bean.getId());
			rs=stmt.executeQuery();
			while(rs.next()){
				if(bean.getId()==rs.getInt("id")){
					bean.setId(0);
					insert=false;
				}		
			}
			if(insert==true){
				stmt=conn.prepareStatement("insert into stu (id) values (?)");
				stmt.setInt(1,bean.getId());
				stmt.executeUpdate();
			}
			conn.close();
			DBUtil.getInstance().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}
	public Student retrieveStudent(int id) {
		String sql="select * from stu where id=?";
		conn=DBUtil.getInstance().getConnection();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		Student bean=new Student();
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs=stmt.executeQuery();

			while(rs.next()){
				if(rs.getInt("id")==0){
					break;
				}else{
					bean.setId(rs.getInt("id"));
					bean.setFirstname(rs.getString("firstname"));
					bean.setLastname(rs.getString("lastname"));	
					bean.setDateob(rs.getString("dateob"));
					bean.setMajor(rs.getString("major"));
					bean.setDescription(rs.getString("description"));
					bean.setCourse1name(rs.getString("course1name"));
					bean.setCourse1grade(rs.getInt("course1grade"));
					bean.setCourse2name(rs.getString("course2name"));
					bean.setCourse2grade(rs.getInt("course2grade"));
					bean.setCourse3name(rs.getString("course3name"));
					bean.setCourse3grade(rs.getInt("course3grade"));
					bean.setCourse4name(rs.getString("course4name"));
					bean.setCourse4grade(rs.getInt("course4grade"));
					bean.setCourse5name(rs.getString("course5name"));
					bean.setCourse5grade(rs.getInt("course5grade"));							
				}
			}	
			conn.close();
			DBUtil.getInstance().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;

	}	

	public void updateStudent(Student bean){
		String sql="UPDATE stu SET firstname=?,lastname=?,dateob=?,major=?,description=?," +
				"course1name=?,course1grade=?,course2name=?,course2grade=?,course3name=?,course3grade=?,course4name=?,course4grade=?," +
				"course5name=?,course5grade=? WHERE id=?";
		conn=DBUtil.getInstance().getConnection();
		PreparedStatement stmt=null;
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1,bean.getFirstname());
			stmt.setString(2,bean.getLastname());
			stmt.setString(3,bean.getDateob());
			stmt.setString(4,bean.getMajor());
			stmt.setString(5,bean.getDescription());
			stmt.setString(6,bean.getCourse1name());
			stmt.setInt(7,bean.getCourse1grade());
			stmt.setString(8,bean.getCourse2name());
			stmt.setInt(9,bean.getCourse2grade());
			stmt.setString(10,bean.getCourse3name());
			stmt.setInt(11,bean.getCourse3grade());
			stmt.setString(12,bean.getCourse4name());
			stmt.setInt(13,bean.getCourse4grade());
			stmt.setString(14,bean.getCourse5name());
			stmt.setInt(15,bean.getCourse5grade());
			stmt.setInt(16, bean.getId());
			stmt.executeUpdate();//					must execute
			System.out.println(bean.getFirstname());
			conn.close();
			DBUtil.getInstance().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteStudent(int id) {
		String sql="delete from stu where id=?";
		conn=DBUtil.getInstance().getConnection();
		PreparedStatement stmt=null;
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			conn.close();
			DBUtil.getInstance().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean compareUser(User bean){
		boolean compare=false;
		String sql="select * from user where uname like ?";
		conn=DBUtil.getInstance().getConnection();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1,bean.getUname());
			rs=stmt.executeQuery();
			while(rs.next()){
				if(bean.getUpass().equals(rs.getString("upass"))){  //!!!!use equals() to compare
					compare=true;
				}
			}
			conn.close();
			DBUtil.getInstance().close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		if(compare){
			return true;
		}else{
			return false;
		}
	}

	public boolean signup(User bean) {
		conn=DBUtil.getInstance().getConnection();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		boolean userexsited=false;
		try {
			stmt=conn.prepareStatement("select uname from user where uname like ?");
			stmt.setString(1, bean.getUname());
			rs=stmt.executeQuery();
			if(rs.next()==false){
				userexsited=true;					
			} 
			if(userexsited){
				stmt=conn.prepareStatement("insert into user (uname, upass) values (?,?)");
				stmt.setString(1, bean.getUname());
				stmt.setString(2, bean.getUpass());
				stmt.executeUpdate();
				conn.close();
				DBUtil.getInstance().close();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		if(userexsited)return true;
		else return false;
	}
}

