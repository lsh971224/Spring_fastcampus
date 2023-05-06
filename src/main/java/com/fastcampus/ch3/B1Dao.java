package com.fastcampus.ch3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class B1Dao {
    @Autowired
    DataSource ds;

    public int insert(int key, int value) throws Exception{
        Connection con = null;
        PreparedStatement psmt = null;
        try {
            con = DataSourceUtils.getConnection(ds);
            String sql = "insert into b1 values(?,?)";
            psmt = con.prepareStatement(sql);
            psmt.setInt(1,key);
            psmt.setInt(2,value);
            return psmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DataSourceUtils.releaseConnection(con,ds);
        }
    }
    public int deleteAll(){
        Connection con = null;
        PreparedStatement psmt = null;
        try {
            con = DataSourceUtils.getConnection(ds);
            String sql = "delete from b1";
            psmt = con.prepareStatement(sql);
            return psmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
