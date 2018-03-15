package com.demo;

/*
 * Mybatis数据映射，数据库sql见: resource/mybatis/db.sql
 */
public interface DataMapper {
	DbUser getUserLoginInfo(String username);
}
