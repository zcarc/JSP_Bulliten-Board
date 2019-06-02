package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.dto.DTO;

public class DAO {
	
	Context context = null;
	DataSource dataSource = null;
	
	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet resultSet = null;
	
	
	public DAO() {
		
		
		
		try{
			
			context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// 게시글 쓰기
	// name : 글 작성자
	// title : 글 제목
	// content : 글 내용
	public void write(String name, String title, String content) {
		
		System.out.println("write...");
		System.out.println(name);
		System.out.println(title);
		System.out.println(content);
		
		try {
			
			connection = dataSource.getConnection();
			
			String did = "id";
			String dname = "name";
			String dtitle = "title";
			String dcontent = "content";
			String dhit = "hit";
			String dgroup = "group";
			String dstep = "step";
			String dindent = "indent";
			
			String sql = "insert into jsppractice_board(\""+did+"\", \""+dname+"\", \""+dtitle+"\", \""+dcontent+"\", \""+dhit+"\", \""+dgroup+"\", \""+dstep+"\", \""+dindent+"\")"
					   + "values(jsppractice_board_seq.nextval, ?, ?, ?, 0, jsppractice_board_seq.currval, 0, 0)";
			// conn.prepareStatement(sql);
			pstmt = connection.prepareStatement(sql); 
			pstmt.setString(1, name);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			
			int result = pstmt.executeUpdate();
			
			if(result == 1)
				System.out.println("Successfully written.");
			
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if(pstmt != null) 
					pstmt.close();
				
				if(connection != null) 
					connection.close();
				
			} catch(Exception e2) {
				e2.printStackTrace();
				
			}
			
			
		}
	}
	
	
	// 게시글 리스트
	public ArrayList<DTO> list() {
		
		ArrayList<DTO> DTOList = new ArrayList<DTO>();
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("select * from jsppractice_board order by \"group\" desc, \"step\" asc");
			resultSet = pstmt.executeQuery();
			
			while(resultSet.next()) {
				
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String title = resultSet.getString("title");
				String content = resultSet.getString("content");
				Date ddate =  resultSet.getDate("ddate");
				int hit = resultSet.getInt("hit");
				int group = resultSet.getInt("group");
				int step = resultSet.getInt("step");
				int indent = resultSet.getInt("indent");
				
				DTO dto = new DTO(id,name,title,content,ddate,hit,group,step,indent);
				DTOList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				
				if(resultSet != null) 
					resultSet.close();
				
				if(pstmt != null) 
					pstmt.close();
				
				if(connection != null) 
					connection.close();
				
			} catch(Exception e2) {
				e2.printStackTrace();
				
			}
			
			
		}
		
		return DTOList;
	}
	
	
	// 게시글 보기
	public DTO contentView(String id) {
		
		
		hitUp(id);
		
		
		DTO dto = null;
		
		
		try {
			
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("select * from jsppractice_board where \"id\" = ?");
			pstmt.setInt(1, Integer.parseInt(id));
			resultSet = pstmt.executeQuery();
			
			if(resultSet.next()) {
				
				int getId = resultSet.getInt("id");
				String getName = resultSet.getString("name");
				String getTitle = resultSet.getString("title");
				String getContent = resultSet.getString("content");
				Date getdDate = resultSet.getDate("ddate");
				int getHit = resultSet.getInt("hit");
				int getGroup = resultSet.getInt("group");
				int getStep = resultSet.getInt("step");
				int getIndent = resultSet.getInt("indent");
				
				dto = new DTO(getId, getName, getTitle, getContent, getdDate, getHit, getGroup, getStep, getIndent);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				
				if(resultSet != null) 
					resultSet.close();
				
				if(pstmt != null) 
					pstmt.close();
				
				if(connection != null) 
					connection.close();
				
			} catch(Exception e2) {
				e2.printStackTrace();
				
			}
			
		}
		
		return dto;
		
	} // contentView()
	
	
	// 게시글 수정
	public void modify(String title, String content, String id) {
		
		try {
			
			connection = dataSource.getConnection();
			String sql = "update jsppractice_board set \"title\" = ?, \"content\" = ? where \"id\" = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, Integer.parseInt(id));
			
			int result = pstmt.executeUpdate();
			
			if(result == 1)
				System.out.println("Successfully modified.");
			
		} catch (Exception e) {
		} finally {
			
			try {
				
				if(pstmt != null) 
					pstmt.close();
				
				if(connection != null) 
					connection.close();
				
			} catch(Exception e2) {
				e2.printStackTrace();
				
			}
			
		}
	}
	
	
	// 게시글 조회수 증가
	public void hitUp(String id) {
		
		System.out.println("hitUp...");
		System.out.println(Integer.parseInt(id));
		System.out.println("update jsppractice_board set \"hit\" = \"hit\" + 1 where \"id\" = ?");
		
		try {
			
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("update jsppractice_board set \"hit\" = \"hit\" + 1 where \"id\" = ?");
			pstmt.setInt(1, Integer.parseInt(id));
			int result = pstmt.executeUpdate();
			
			if(result == 1)
				System.out.println("Successfully hitUp.");
			else
				System.out.println("Failed hitUp.");
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if(pstmt != null) 
					pstmt.close();
				
				if(connection != null) 
					connection.close();
				
			} catch(Exception e2) {
				e2.printStackTrace();
				
			}
			
		}
		
	} // hitup()
	
	
	// 게시글 삭제
	public void delete(String id) {
		
		
		try {
			
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("delete from jsppractice_board where \"id\" = ?");
			pstmt.setInt(1, Integer.parseInt(id));
			int result = pstmt.executeUpdate();
			
			if(result == 1)
				System.out.println("Successfully deleted.");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if(pstmt != null) 
					pstmt.close();
				
				if(connection != null) 
					connection.close();
				
			} catch(Exception e2) {
				e2.printStackTrace();
				
			}
			
		}
		
	}
	
	// 게시글 답변
	public void reply(String name, String title, String content, String group, String step, String indent) {
		
		
		upStep(group, step);
		
		
		try {
			
			connection = dataSource.getConnection();
			
			String sql = "insert into jsppractice_board(\"id\", \"name\", \"title\", \"content\", \"hit\", \"group\", \"step\", \"indent\") "
						+ "values(jsppractice_board_seq.nextval, ?, ?, ?, 0, ?, ?, ?)";
			pstmt = connection.prepareStatement(sql);
			
			
			pstmt.setString(1, name);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.setInt(4, Integer.parseInt(group));
			pstmt.setInt(5, Integer.parseInt(step) + 1);
			pstmt.setInt(6, Integer.parseInt(indent) + 1);
			
			
			int result = pstmt.executeUpdate();
			
			if(result == 1)
				System.out.println("Successfully replied.");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if(pstmt != null) 
					pstmt.close();
				
				if(connection != null) 
					connection.close();
				
			} catch(Exception e2) {
				e2.printStackTrace();
				
			}
			
		}
		
	}
	
	
	
	// 게시글 답변 step 증가
	public void upStep(String group, String step) {
		
		
		try {
			
			connection = dataSource.getConnection();
			
			String sql = "update jsppractice_board set \"step\" = \"step\" + 1 where \"group\" = ? and \"step\" > ?";
			
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(group));
			pstmt.setInt(2, Integer.parseInt(step));
			
			int result = pstmt.executeUpdate();
			
			if(result == 1)
				System.out.println("Successfully increased steps.");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if(pstmt != null) 
					pstmt.close();
				
				if(connection != null) 
					connection.close();
				
			} catch(Exception e2) {
				e2.printStackTrace();
				
			}
			
		}
		
	}
	
	
	

	
	
	

}

