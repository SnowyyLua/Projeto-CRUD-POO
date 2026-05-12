package com.example;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Conexao.getConnection();
        IDAO crud = new DAOAluno();
        // Curso c = new Curso();
        // c.setId(1);
        // Aluno a = new Aluno("Calvin", c);        
        // Aluno b = new Aluno();
        //  crud.create(a);
        List<Aluno> tomatinhos = new ArrayList<Aluno>();
        tomatinhos = crud.listAll();

         for(Aluno a1: tomatinhos){
            System.out.println(a1.toString());
         }
        
        // Optional<Aluno> result = crud.getById(1);

        // System.out.println(result.toString());
    }
}