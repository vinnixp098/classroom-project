create table aulas(
    id bigint not null auto_increment,
    sala varchar(100) not null,
    curso varchar(100) not null,
    horario varchar(100) not null,
    professor varchar(100) not null,
    disciplina varchar(100) not null,
    andar varchar(100) not null,
    dia varchar(100) not null,
    bloco varchar(100) not null,
    turno varchar(100) not null,

    primary key (id)
)