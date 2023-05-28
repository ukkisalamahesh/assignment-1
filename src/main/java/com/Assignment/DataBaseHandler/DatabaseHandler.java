package com.Assignment.DataBaseHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.map.HashedMap;

public class DatabaseHandler {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/springboot";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    private Connection connection;

    public DatabaseHandler() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Boolean createTable(String tableName, String tableSchema) {
        String query = "CREATE TABLE IF NOT EXISTS " + tableName + " (" + tableSchema + ")";

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
            return true;
        } catch (SQLException e) { 
        	e.printStackTrace();
        	return false;
        }
    }

    public void deleteTable(String tableName) {
        String query = "DROP TABLE IF EXISTS " + tableName;

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertData(String tableName, List<String> columns, List<String> values) {
        String query = "INSERT INTO " + tableName + " (" + String.join(",", columns) + ") VALUES (";

        for (int i = 0; i < values.size(); i++) {
            query += "'" + values.get(i) + "'";
            if (i < values.size() - 1) {
                query += ",";
            }
        }

        query += ")";
        System.out.println(query);
        try (Statement statement = connection.createStatement()) {
           statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteData(String tableName, String searchColumn, String searchValue) {
        String query = "DELETE FROM " + tableName + " WHERE " + searchColumn + " = " + searchValue;

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateData(String tableName, String searchColumn, String searchValue, HashMap<String, String> data) {
    	Object[] keys = data.keySet().toArray();
    	String query = "UPDATE " + tableName + " SET ";
    	 for (int i = 0; i < keys.length; i++) {
             query += keys[i] + " = '" + data.get(keys[i]) + "' ";
             if (i < keys.length - 1) {
                 query += ",";
             }
         }
    	 query  +="WHERE " + searchColumn + " LIKE '%" + searchValue + "%'" ;
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<HashMap<String, String>> fetchData(String tableName, List<String> columns, 
    	String searchColumn, String searchValue, int pageSize, int pageNumber) {
        int offset = (pageNumber - 1) * pageSize;String query ="";
        if (searchColumn == "") {
        	query = "SELECT id," + String.join(",", columns) + " FROM " + tableName +
                       " LIMIT " + pageSize + " OFFSET " + offset;
        }else {
        	query = "SELECT id," + String.join(",", columns) + " FROM " + tableName +
                       " WHERE " + searchColumn + " LIKE '%" + searchValue + "%'" +
                       " LIMIT " + pageSize + " OFFSET " + offset;
        }
        System.out.println(query);
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
             List<HashMap<String, String>> dataMap = new ArrayList<>();
             while (resultSet.next()) {
            	 HashMap<String, String> data = new HashMap<>();
            	 Integer id = resultSet.getInt("id");
            	 data.put("id",id.toString());
            	 for (String column  : columns) {
            		 data.put(column,resultSet.getString(column));
            	 }
                 dataMap.add(data);
             }
        	return dataMap;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<HashMap<String, String>> fetchDataFilter(String tableName, List<String> columns,
    		HashMap<String, String> filters, int pageSize, int pageNumber) {
    	
            int offset = (pageNumber - 1) * pageSize;String query ="";
            query = "SELECT id," + String.join(",", columns) + " FROM " + tableName + " WHERE (";
            Object[] keys = filters.keySet().toArray();
        	 for (int i = 0; i < keys.length; i++) {
                 query += keys[i] +" LIKE '%"+filters.get(keys[i])+"%' ";
                 if (i < keys.length - 1) {
                     query += " OR ";
                 }
             }
        	 query += ") LIMIT " + pageSize + " OFFSET " + offset;
            System.out.println(query);
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
                 List<HashMap<String, String>> dataMap = new ArrayList<>();
                 while (resultSet.next()) {
                	 HashMap<String, String> data = new HashMap<>();
                	 Integer id = resultSet.getInt("id");
                	 data.put("id",id.toString());
                	 for (String column  : columns) {
                		 data.put(column,resultSet.getString(column));
                	 }
                     dataMap.add(data);
                 }
            	return dataMap;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
    public Boolean createStudentTable() {
    	String schema = 
    			"id INT PRIMARY KEY AUTO_INCREMENT,"
    			+ "  name VARCHAR(100),"
    			+ "  standard VARCHAR(50),"
    			+ "  attendance INT,"
    			+ "  gender ENUM('Male', 'Female', 'Other'),"
    			+ "  phoneNumber VARCHAR(20),"
    			+ "  parentName VARCHAR(100),"
    			+ "  remarks VARCHAR(255)";

        try {
            this.createTable("students",schema);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public Boolean createSubjectTable() {
    	String schema =  "id INT PRIMARY KEY AUTO_INCREMENT,"
    			+ "  student_id INT,"
    			+ "  telugu_marks INT,"
    			+ "  hindi_marks INT,"
    			+ "  english_marks INT,"
    			+ "  maths_marks INT,"
    			+ "  science_marks INT,"
    			+ "  social_marks INT,"
    			+ "  FOREIGN KEY (student_id) REFERENCES students(id) ON DELETE CASCADE";
        try {
            this.createTable("mark_sheet",schema);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}