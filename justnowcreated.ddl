alter table hb_emp_tbl drop constraint FK_EMP_DEPT;
drop table if exists hb_dept_tbl;
drop table if exists hb_emp_tbl;
create table hb_dept_tbl (
   DEPTNO integer not null,
   DNAME varchar(100) not null,
   LOC varchar(100) not null,
   primary key (DEPTNO)
);
create table hb_emp_tbl (
   EMPNo integer not null,
   ENAME varchar(10) not null,
   JOB varchar(9) not null,
   MGR integer not null,
   HIREDATE datetime,
   SAL double precision not null,
   COMM double precision,
   deptno integer not null,
   primary key (EMPNo)
);
alter table hb_emp_tbl add index FK_EMP_DEPT (deptno), add constraint FK_EMP_DEPT foreign key (deptno) references hb_dept_tbl (DEPTNO);
