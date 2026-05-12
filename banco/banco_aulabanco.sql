create database academico;

use academico;

create table alunos(
	id int not null auto_increment primary key,
    nome varchar(150) not null
    );
    
create table cursos(
	id int not null auto_increment primary key,
    nome varchar(150) not null,
    semestres int not null
	);
    
alter table alunos add column id_curso int;
INSERT INTO cursos(nome, semestres) VALUES('Tecnologia em Análise e Desenvolvimento de Sistemas', 6);

SELECT
alunos.id,
alunos.nome,
alunos.id_curso,
cursos.nome,
cursos.semestres

FROM alunos
INNER JOIN cursos ON alunos.id_curso = cursos.id;

UPDATE alunos SET id_curso = 1 WHERE id > 0;

select * from alunos;
select * from cursos;