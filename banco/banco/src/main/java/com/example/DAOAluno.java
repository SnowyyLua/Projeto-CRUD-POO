package com.example;

import java.lang.reflect.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DAOAluno implements IDAO<Aluno>{

    @Override
    public void create(Aluno t) {
        try{
    	    PreparedStatement stmt = Conexao.getConnection().prepareStatement("INSERT INTO ALUNOS (nome,id_curso) VALUES (?,?)");
            stmt.setString(1,t.getNome());
            stmt.setInt(2,t.getCurso().getId());
		    stmt.executeUpdate();
            System.out.println("Aluno inserido com sucesso");
        }catch(Exception e){
            e.printStackTrace();
        }           
    }


    @Override
    public void delete(Aluno t) {
        try(PreparedStatement stmt = Conexao.getConnection().prepareStatement("DELETE FROM ALUNOS WHERE id = ?")){
            stmt.setInt(1,t.getId());
            stmt.executeUpdate();
            System.out.println("Aluno removido com sucesso");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void update(Aluno t) {
        try{
    	    PreparedStatement stmt = Conexao.getConnection().prepareStatement("UPDATE alunos SET nome = ? WHERE id = ?");
            stmt.setString(1,t.getNome());
            stmt.setInt(2,t.getCurso().getId());
		    stmt.executeUpdate();
            System.out.println("Aluno atualizado com sucesso");
        }catch(Exception e){
            e.printStackTrace();
        }    
    }

    @Override
    public List<Aluno> listAll() {
        List<Aluno> alunos = new ArrayList<Aluno>();
        try{
           PreparedStatement stmt = Conexao.getConnection().prepareStatement(
            "SELECT \r\n" + 
                        "alunos.id,\r\n" + 
                        "alunos.nome as nome_aluno,\r\n" + 
                        "alunos.id_curso,\r\n" + 
                        "cursos.nome as nome_curso,\r\n" + 
                        "cursos.semestres\r\n" + 
                        "\r\n" + 
                        "FROM alunos\r\n" + 
                        "INNER JOIN cursos ON alunos.id_curso = cursos.id\r\n"                         
           ); 

           ResultSet rs = stmt.executeQuery();

           while(rs.next()){
                Aluno a = new Aluno();
                Curso c = new Curso();
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome_aluno"));
                c.setId(rs.getInt("id_curso"));
                c.setNome(rs.getString("nome_curso"));
                c.setSemestres(rs.getInt("semestres"));
                a.setCurso(c);                
                alunos.add(a);
                a = null;
                c = null;
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if(alunos.isEmpty()){
            System.out.println("Nenhum aluno encontrado");
            return null;
        }else{
            return alunos;
        }
    }
    
    public List<Aluno> selectAllPorCurso(){
        List<Aluno> alunos = new ArrayList<>();
        try {
            PreparedStatement stmt = Conexao.getConnection().prepareStatement(
            "SELECT * FROM alunos\r\n" +
            "INNER JOIN cursos ON alunos.id_curso = cursos.id\r\n" +
            "WHERE alunos.id_curso = 1");

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                Aluno a = new Aluno();
                Curso c = new Curso();
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome_aluno"));
                c.setId(rs.getInt("id_curso"));
                c.setNome(rs.getString("nome_curso"));
                c.setSemestres(rs.getInt("semestres"));
                a.setCurso(c);

               
                System.out.println("ID: "+ a.getId() +
                "\r\nNome_Aluno: "+ a.getNome()+
                "\r\nID_curso: " + c.getId()+
                "\r\nNome_curos: "+ c.getNome()+
                "\r\nSemestres: "+ c.getSemestres());
                
                 alunos.add(a);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        if(alunos.isEmpty()){
            System.out.println("Nenhum aluno encontrado");
            return null;
        }else{
            return alunos;
        }
    }





 @Override
    public Optional<Aluno> getById(int id) {
    Aluno aluno = new Aluno();
	Curso curso = new Curso();
        try {
        PreparedStatement stmt = Conexao.getConnection().prepareStatement("SELECT \r\n" + //
                        "alunos.id,\r\n" + 
                        "alunos.nome as nome_aluno,\r\n" + 
                        "alunos.id_curso,\r\n" + 
                        "cursos.nome as nome_curso,\r\n" + 
                        "cursos.semestres\r\n" + 
                        "\r\n" + 
                        "FROM alunos\r\n" + 
                        "INNER JOIN cursos ON alunos.id_curso = cursos.id\r\n" + 
                        "WHERE alunos.id = ?");    
	    stmt.setInt(1,id);
        ResultSet rs = stmt.executeQuery();
                
        while(rs.next()){
            aluno.setNome(rs.getString("nome_aluno"));
            aluno.setId(rs.getInt("id"));
	        curso.setId(rs.getInt("id_curso"));
	        curso.setNome(rs.getString("nome_curso"));
	        curso.setSemestres(rs.getInt("semestres"));
        }
	    aluno.setCurso(curso);
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return Optional.of(aluno);
    }




}
