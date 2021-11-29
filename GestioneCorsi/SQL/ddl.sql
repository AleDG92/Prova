<--------------------------------------------Docente ->
create table docente(
cod_docente int not null,
nome_docente varchar2(30) not null,
cognome_docente varchar2(30) not null,
cv varchar2(50) not null,
constraint p_cod_docente primary key(cod_docente));

<--------------------------------------------Corso ->
create table corso(
cod_corso int not null,
nome_corso varchar2(30) not null,
datainizio_corso date not null,
datafine_corso date not null,
costo_corso double,
commenti_corso varchar2(500),
aula_corso int,
constraint p_cod_corso primary key(cod_corso));
constraint f_cod_docente foreign key(cod_docente) references docente(cod_docente) on delete cascade;
<--------------------------------------------Corsista ->

create table corsista(
cod_corsista int not null,
nome_corsista varchar2(30) not null,
cognome_corsista varchar2(30),
precedenti_formativi boolean,
aula_corso int,
constraint p_cod_corsista primary key(cod_corsista));

<--------------------------------------------Corsista ->

create table corso_corsista(
cod_corsista int,
cod_corso int,
constraint f_cod_corsista foreign key(cod_corsista) references ordine(cod_corsista) on delete cascade,
constraint f_cod_corso foreign key(cod_corso) references articolo(cod_corso) on delete cascade,
constraint p_oa primary key(id_ordine, id_articolo));

<--------------------------------------------admin ->

create table amministratore(
nome_admin varchar2(10),
cognome varchar2(500) not null,
cod_admin int not null unique,
constraint p_admin primary key(cod_admin));

