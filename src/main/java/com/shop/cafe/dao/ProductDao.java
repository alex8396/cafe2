package com.shop.cafe.dao;

import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.shop.cafe.dto.Product;

@Component
public class ProductDao {
	
	@Value("${spring.datasource.driver-class-name}")
	private String DB_DRIVER;
	
	@Value("${spring.datasource.url}")
	private String DB_URL;
	
	@Value("${spring.datasource.username}")
	private String DB_USER;
	
	@Value("${spring.datasource.password}")
	private String DB_PW;
	
	public List<Product> getAllproducts() throws Exception{
		//JDBC 6단계
		
		// 1. 드라이버 등록
		Class.forName(DB_DRIVER);
		
		String sql = "select * from product";
		
		// try-with-resources 기능 auto closable객체만 표현
		
		try(
				Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PW);
				
				// 3. Statment 생성
				PreparedStatement stmt = con.prepareStatement(sql);
				
				// 4. SQL 전송
				ResultSet rs = stmt.executeQuery();
				) {
			
			
			// 5. 결과 받기
			List<Product> list = new ArrayList();
			while(rs.next()) {
				int prodcode=rs.getInt("prodcode");
				String prodname=rs.getString("prodname");
				int price=rs.getInt("price");
				String pimg=rs.getString("pimg");
				
				list.add(new Product(prodname, pimg, prodcode, price));
			}
			
			return list;
		
		}
	}
}