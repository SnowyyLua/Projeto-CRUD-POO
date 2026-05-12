package com.example;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Aluno {
    
    private int id;

    @NonNull
    private String nome;

    @NonNull
    private Curso curso;

}
