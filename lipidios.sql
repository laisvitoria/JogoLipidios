-- Database: lipidios

-- DROP DATABASE lipidios;

CREATE DATABASE lipidios
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
	
	create table Pergunta(
	  CodPergunta integer not null check (CodPergunta >0),
	  Pergunta varchar(150),
	  Resposta varchar(50),
	  Justificativa varchar(200),
	  constraint PkPergunta primary key (CodPergunta)
	);
	
	insert into Pergunta values 
	(1, 'Os lipídidos possuem oxigênio em sua composição?', 'verdadeiro',
	 'Os lipídidos são formados principalmente por carbono, hidrogênio e oxigênio'),
	 
	 insert into Pergunta values 
	 (2, 'Uma alimentação com ausência de lipídios não é prejudicial', 'falso',
	  'os lipídios estão entre os nutrientes essenciais para o nosso corpo'),
	 
	 insert into Pergunta values 
	 (3, 'A manteiga é uma gordura de origem animal?', 'verdadeiro',
	  'Feita de gordura de origem animal, leite de vaca, possui 80% de gordura, lactose, água e sal.')
	 
	 insert into Pergunta values 
	(4, 'Os lipídidos são a principal fonte de energia das células?', 'falso',
	 'É a glicose a principal fonte de energia celular.'),
	 
	 insert into Pergunta values 
	(5, 'Os lipídidos auxiliam no controle da temperatura corporal?', 'verdadeiro',
	 'Os lipídios garantem proteção contra as baixas temperaturas e contra choques mecânicos.'),
	 
	 select * from pergunta