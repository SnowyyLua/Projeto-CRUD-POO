package com.example;

import java.sql.Connection;
import java.sql.DriverManager;



public class Conexao {
    
    public static Connection conn;

    public static Connection getConnection(){
        try{
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/academico","root","root");
            System.out.println("Conexão estabelecida");
    }catch(Exception e){
        System.out.println("Erro na conexão");
        e.printStackTrace();
    }
        return conn;
    }

    public void closeConnection(){
        try {
            conn.close();
        } catch (Exception e) {
            System.err.println("Erro na conexão");
            e.printStackTrace();
        }
        
    }

}
