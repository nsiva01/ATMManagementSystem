package com.sk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sk.model.Account;
import com.sk.util.DBConnection;

public class AccountDAO implements IAccountDAO {

	@Override
	public boolean validateUser(long accNo, int pin)  {
		Connection con=DBConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("select acc_no from bank_account where acc_no=? and pin=?");
		ps.setLong(1, accNo);
		ps.setInt(2, pin);
		ResultSet rs=ps.executeQuery();
		return rs.next();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Account getAccount(long accNo) {
		try(Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from bank_account where acc_no=?")){
			ps.setLong(1, accNo);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return new Account(
						rs.getLong("acc_no"),
						rs.getString("name"),
						rs.getInt("pin"),
						rs.getDouble("balance"));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateAccount(long accNo, double balance) {
		String update="update bank_account set balance=? where acc_no=?";
		try(Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement(update)){
			ps.setLong(1, accNo);
			ps.setDouble(2, balance);
			int rows = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
