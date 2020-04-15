//������ ���̽� ����
create database boardtest;

//���� ���̺�
create table USER (
 userID varchar(20),
 userPassword varchar(20),
 userName varchar(20),
 userGender varchar(20),
 userEmail varchar(50),
 primary key(userID)
);

//������ ���̽� ���� 
use boardtest

//���̺� ������ Ȯ��
select * from USER;


//�Խ��� ���̺� (boardAvailavle:�� ���� ���� �Ǵ� 1. ������ ���� ������, 0. ������ ��)
create table board(
boardID int,
boardTitle varchar(50),
userID varchar(20),
boardDate DATETIME,
boardContent varchar(2048),
boardAvailable INT, 
PRIMARY KEY (boardID)
);

