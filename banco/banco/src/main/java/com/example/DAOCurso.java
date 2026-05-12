package com.example;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

public class DAOCurso implements IDAO<Curso> {
    @Override
    public void create (Curso t){
        try {
            PreparedStatement stmt = Conexao.getConnection().prepareStatement("INSERT INTO CURSOS (nome, semestres) VALUES (?,?");
            stmt.setString(1,t.getNome());
            stmt.setInt(2,t.getSemestres());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void delete(Curso t){
        try(PreparedStatement stmt = Conexao.getConnection().prepareStatement("DELETE FROM CURSOS WHERE nome = ?")){
            stmt.setString(1,t.getNome());
            stmt.executeUpdate();
            System.out.println("Aluno removido com sucesso");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void update(Curso t){
         throw new UnsupportedOperationException("Unimplemented method 'update'");  
    }
    @Override
    public List<Curso> listAll(){

        return null;

    }
    @Override
    public Optional<Curso> getById(int id){

        return null;

    }

}
