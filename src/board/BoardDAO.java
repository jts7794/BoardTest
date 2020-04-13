package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BoardDAO {

	private Connection conn;
	private ResultSet rs;
	
	public BoardDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/boardtest?serverTimezone=UTC";
			String dbID = "root";
			String dbPassword = "root";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL,dbID,dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//������ �ð��� �������� �Լ�, �Խ��� �� �ۼ��� ����ð��� �������� ����
	public String getDate() {
		String SQL = "SELECT NOW()"; //���� �ð��� �������� Mysql�� ����
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";//�����ͺ��̽� ���� 
	}
	
	public int getNext() {
		String SQL = "SELECT BoardID FROM BOARD ORDER BY boardID DESC"; //�Խñ� ��ȣ�� ���� ��Ű������ �������� ���� ��ȣ�� �����ͼ� +1 
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1) + 1;
				}
			return 1; // ù ��° �Խù��� ���
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; //�����ͺ��̽� ���� 
	}
	
	public int write(String boardTitle, String userID, String boardContent) {
		String SQL = "INSERT INTO BOARD VALUES (?, ?, ?, ?, ?, ?)"; 
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext());
			pstmt.setString(2, boardTitle);
			pstmt.setString(3, userID);
			pstmt.setString(4, getDate());
			pstmt.setString(5, boardContent);
			pstmt.setInt(6, 1);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; //�����ͺ��̽� ���� 
	}
}
