CREATE TABLE IF NOT EXISTS user ( ADT varchar(50) NOT NULL , name varchar(50) NOT NULL , lastname varchar(50) NOT NULL , email varchar(50) NOT NULL , usern>
CREATE TABLE IF NOT EXISTS employee ( ADT varchar(50) NOT NULL, UNIQUE KEY ix_empl_adt (ADT), CONSTRAINT fk_employee_user FOREIGN KEY (ADT) REFERENCES user>
CREATE TABLE IF NOT EXISTS citizen ( ADT varchar(50) NOT NULL, aplicationid int(11) , UNIQUE KEY ix_cit_adt (ADT), CONSTRAINT fk_citizen_user FOREIGN KEY (>
CREATE TABLE IF NOT EXISTS aksiomatikos ( ADT varchar(50)  , UNIQUE KEY ix_aks_adt (ADT), CONSTRAINT fk_aksiomatikos_user FOREIGN KEY (ADT) REFEREN>
CREATE TABLE IF NOT EXISTS aplication ( aplicationid int(11) NOT NULL AUTO_INCREMENT, date_created date NOT NULL , date_modified date , status int NOT NULL , paper varch>
CREATE TABLE IF NOT EXISTS authorities ( ADT varchar(50) NOT NULL , Role varchar(50) NOT NULL , UNIQUE KEY ix_auth_adt (ADT) ) ENGINE=InnoDB DEFAULT CHARSE>
INSERT INTO user VALUES ('ab 123', 'Diogenis','Antonopoulos','it21906@hua.gr','dio','$2a$12$aUn0i3oA6UyT..s5VQiu8.ocq20ixV8tWLC80lcU4KzyIx1QTtI8u','1'), ('>('ad 123', 'Panos','Charos','charos@hua.gr','charos','$2a$12$eQcGXbNoBxmQIOreu6Cxquh2zB3xG6fRQm0Z45yi3fPTF4asn0/Qy','3'),
('abc 1234', 'Blah','BlahBlah','Blah@hua.gr','Blah','$2a$12$lEc98KLANXqwa0hTpGvKAOocIXfp.HZdEKC/ifEFuQW1eNCsPpazO','4');

INSERT INTO employee VALUES ('ab 123');

INSERT INTO citizen (ADT) VALUES ('ac 123');

INSERT INTO aksiomatikos (ADT) VALUES ('ad 123');

INSERT INTO authorities VALUES ('ab 123','ROLE_USER'), ('ac 123', 'ROLE_EMPL'), ('ad 123', 'ROLE_AKS'), ('abc 1234', 'ROLE_ADMIN');
