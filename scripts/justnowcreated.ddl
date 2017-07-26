use test;

alter table hb_emp_tbl drop constraint FK_EMP_DEPT;
drop table hb_dept_tbl cascade constraints;
drop table hb_emp_tbl cascade constraints;
create table hb_dept_tbl (
   DEPTNO int(10) not null,
   DNAME varchar(100) not null,
   LOC varchar(100) not null,
   primary key (DEPTNO)
);
create table hb_emp_tbl (
   EMPNo int(10) not null,
   ENAME varchar(10) not null,
   JOB varchar(9) not null,
   MGR int(10) not null,
   HIREDATE date,
   SAL double precision not null,
   COMM double precision,
   deptno int(10) not null,
   primary key (EMPNo)
);
alter table hb_emp_tbl add constraint FK_EMP_DEPT foreign key (deptno) references hb_dept_tbl(deptno);


insert into hb_dept_tbl(`DEPTNO`,`DNAME`,`LOC`) values (30,'SALES','CHICAGO');
insert into hb_dept_tbl(`DEPTNO`,`DNAME`,`LOC`) values (10,'ACCOUNTING','NEW YORK');
insert into hb_dept_tbl(`DEPTNO`,`DNAME`,`LOC`) values (20,'RESEARCH','DALLAS');
insert into hb_dept_tbl(`DEPTNO`,`DNAME`,`LOC`) values (40,'OPERATIONS','BOSTON');
insert into hb_dept_tbl(`DEPTNO`,`DNAME`,`LOC`) values (50,'Security','LA');


insert into hb_emp_tbl(`EMPNo`,`ENAME`,`JOB`,`MGR`,`HIREDATE`,`SAL`,`COMM`,`deptno`) values (1,'Scott','ANALYST',1,'2007-05-16 16:16:55',1000,50,10);
insert into hb_emp_tbl(`EMPNo`,`ENAME`,`JOB`,`MGR`,`HIREDATE`,`SAL`,`COMM`,`deptno`) values (3,'Peter','ANALYST',1,'2007-07-16 17:04:51',2000,50,10);
insert into hb_emp_tbl(`EMPNo`,`ENAME`,`JOB`,`MGR`,`HIREDATE`,`SAL`,`COMM`,`deptno`) values (7369,'SMITH','CLERK',7902,null,800,0,10);
insert into hb_emp_tbl(`EMPNo`,`ENAME`,`JOB`,`MGR`,`HIREDATE`,`SAL`,`COMM`,`deptno`) values (7499,'ALLEN','SALESMAN',7698,null,1600,300,30);
insert into hb_emp_tbl(`EMPNo`,`ENAME`,`JOB`,`MGR`,`HIREDATE`,`SAL`,`COMM`,`deptno`) values (7521,'WARD','SALESMAN',7698,null,1250,500,30);
insert into hb_emp_tbl(`EMPNo`,`ENAME`,`JOB`,`MGR`,`HIREDATE`,`SAL`,`COMM`,`deptno`) values (7566,'JONES','MANAGER',7839,null,2975,0,20);
insert into hb_emp_tbl(`EMPNo`,`ENAME`,`JOB`,`MGR`,`HIREDATE`,`SAL`,`COMM`,`deptno`) values (7654,'MARTIN','SALESMAN',7698,null,1250,1400,30);
insert into hb_emp_tbl(`EMPNo`,`ENAME`,`JOB`,`MGR`,`HIREDATE`,`SAL`,`COMM`,`deptno`) values (7698,'BLAKE','MANAGER',7839,null,2850,0,30);
insert into hb_emp_tbl(`EMPNo`,`ENAME`,`JOB`,`MGR`,`HIREDATE`,`SAL`,`COMM`,`deptno`) values (7782,'CLARK','MANAGER',7839,null,2450,0,10);
insert into hb_emp_tbl(`EMPNo`,`ENAME`,`JOB`,`MGR`,`HIREDATE`,`SAL`,`COMM`,`deptno`) values (7788,'SCOTT','ANALYST',7566,null,3000,0,20);
insert into hb_emp_tbl(`EMPNo`,`ENAME`,`JOB`,`MGR`,`HIREDATE`,`SAL`,`COMM`,`deptno`) values (7844,'TURNER','SALESMAN',7698,null,1500,0,30);
insert into hb_emp_tbl(`EMPNo`,`ENAME`,`JOB`,`MGR`,`HIREDATE`,`SAL`,`COMM`,`deptno`) values (7876,'ADAMS','CLERK',7788,null,1100,0,20);
insert into hb_emp_tbl(`EMPNo`,`ENAME`,`JOB`,`MGR`,`HIREDATE`,`SAL`,`COMM`,`deptno`) values (7900,'JAMES','CLERK',7698,null,950,0,30);
insert into hb_emp_tbl(`EMPNo`,`ENAME`,`JOB`,`MGR`,`HIREDATE`,`SAL`,`COMM`,`deptno`) values (7902,'FORD','ANALYST',7566,null,3000,0,20);
insert into hb_emp_tbl(`EMPNo`,`ENAME`,`JOB`,`MGR`,`HIREDATE`,`SAL`,`COMM`,`deptno`) values (7934,'MILLER','CLERK',7782,null,1300,0,10);
insert into hb_emp_tbl(`EMPNo`,`ENAME`,`JOB`,`MGR`,`HIREDATE`,`SAL`,`COMM`,`deptno`) values (7839,'KING','PRESIDENT',7788,null,5000,0,10);
insert into hb_emp_tbl(`EMPNo`,`ENAME`,`JOB`,`MGR`,`HIREDATE`,`SAL`,`COMM`,`deptno`) values (2,'Peter','ANALYST',1,'2007-07-17 15:24:45',1000,50,10);
insert into hb_emp_tbl(`EMPNo`,`ENAME`,`JOB`,`MGR`,`HIREDATE`,`SAL`,`COMM`,`deptno`) values (4,'Ankur','ANALYST',1,'2007-07-17 21:53:58',1000,50,30);

