package dao.diary;

// #00011 : import change required

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import sql.StringQuery;
import util.DataSourceManager;
import vo.day.Day;
import vo.diary.Diary;
import vo.diary.Memo;
import vo.diary.Note;
import vo.diary.Schedule;
import vo.member.Member;

public class DiaryDAO {
	private static DiaryDAO dao = new DiaryDAO();
	private DiaryDAO() {}
	public static DiaryDAO getInstance() {
		return dao;
	}
	
	public Connection getConnection() throws SQLException{
		return DataSourceManager.getInstance().getConnection();
	}
	public void closeAll(PreparedStatement ps, Connection conn)throws SQLException{
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}
	
	public void closeAll(ResultSet rs,PreparedStatement ps, Connection conn)throws SQLException{
		if(rs!=null){
			rs.close();
			closeAll(ps, conn);
		}
	}//
	
	
	// ------------------------------ Logics ------------------------------ //
	public void printMemoDate(String id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			ps = conn.prepareStatement("SELECT wrt_date FROM memo WHERE id = ?");
			//ps.setString(parameterIndex, x);
		} catch(SQLException e) {
			
		} finally {
			
		}
	}
	// ------------------------------ getAllMemo ------------------------------ //
	public Vector<Memo> getAllMemo(String id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Vector<Memo> v = null;
		
		try {
			conn = getConnection();
			v = new Vector<Memo>();
			ps = conn.prepareStatement(StringQuery.GET_ALL_MEMO);
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(rs,ps,conn);
		}
		
		return null;
		
	}
	// ------------------------------ getAllSchedule ------------------------------ //
	public Vector<Schedule> getAllSchedule(String id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Vector<Schedule> sc = null;
		
		try {
			conn = getConnection();
			sc = new Vector<Schedule>();
			ps= conn.prepareStatement(StringQuery.GET_ALL_SCHEDULE);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, ps, conn);
		}
		return null;
	}
	// ------------------------------ getAllNote ------------------------------ //
	public Vector<Note> getAllNote(String id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Vector<Note> n = null;
		
		try {
			conn = getConnection();
			n = new Vector<Note>();
			ps= conn.prepareStatement(StringQuery.GET_ALL_NOTE);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, ps, conn);
		}
		return null;
	}
}
