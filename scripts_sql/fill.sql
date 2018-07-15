-- fill tables

INSERT INTO COLLABORATOR (surname, name, patronymic, position) VALUES ('Novikov','Alex','Petrovich','Manager');
INSERT INTO COLLABORATOR VALUES(2,'Maximoff','Maxim','Maximovich','Manager')
INSERT INTO COLLABORATOR VALUES(3,'Lolivoch','Pavel','Ivanovich','Tester')
INSERT INTO COLLABORATOR VALUES(4,'Petrovich','Igor','Mihailovich','Programmer')
INSERT INTO COLLABORATOR VALUES(5,'Mirniy','Maxim','Nicolaevich','Senior')

INSERT INTO PROJECT VALUES(1,'Cool Qulix Project','CQP','This is very cool project!')
INSERT INTO PROJECT VALUES(2,'Web','wa','The purpose of application is to make developing projects easier')

INSERT INTO TASK VALUES(1,'Create Frontend',3,'2018-05-05','2018-05-09','IN_PROGRESS',1,1)
INSERT INTO TASK VALUES(2,'Create design',3,'2018-01-01','2018-05-09','IN_PROGRESS',2,2)
INSERT INTO TASK VALUES(3,'Create smth',3,'2018-01-01','2018-01-01','NOT_STARTED',2,1)
INSERT INTO TASK VALUES(4,'Create DB',5,'2018-01-01','2018-05-08','IN_PROGRESS',4,2)
INSERT INTO TASK VALUES(5,'sa',0,'1970-01-09','2018-05-11','NOT_STARTED',5,1)

