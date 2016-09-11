CREATE DATABASE bug_tracker;

use bug_tracker;

CREATE TABLE IssueDesc(ID int NOT NULL,ISSUEID int NOT NULL,IssueName nvarchar(50) NOT NULL,Description nvarchar(200) NULL,CreatedBy nvarchar(50) NOT NULL,CreatedDate datetime NOT NULL,UpdatedBy nvarchar(50) NULL,Status nvarchar(100) NOT NULL,FOREIGN KEY (IssueID) REFERENCES NewIssue(IssueID));

CREATE TABLE IssueMaster(IssueID int NOT NULL,IssueTitle nvarchar(100) NOT NULL,AssignedTo nvarchar(100) NULL,AssignedBy nvarchar(100) NULL,CreatedDate datetime NOT NULL,CreatedBy nvarchar(100) NOT NULL);

CREATE TABLE NewIssue(IssueId int NOT NULL auto_increment,IssueName nvarchar(100) NOT NULL,CreatedBy nvarchar(50) NOT NULL,CreatedDate datetime NOT NULL,Description nvarchar(200) NOT NULL,PRIMARY KEY (IssueId))AUTO_INCREMENT=1;
 
CREATE TABLE Registration](FirstName nvarchar(50) NOT NULL,LastName nvarchar(50) NOT NULL,EmailID nvarchar(100) NOT NULL,Role nvarchar(100) NOT NULL,Password nvarchar(15) NOT NULL,MobileNumber nvarchar(50) NOT NULL);

CREATE TABLE StateMaster(StateID int NOT NULL,StateName nvarchar(100) NOT NULL);

CREATE TABLE UserDetails(UserName nvarchar(100) NOT NULL,UserRole nvarchar(50) NOT NULL,UserEmailID nvarchar(100) NOT NULL,UserMobileNumber nvarchar(50) NULL,CreatedDate datetime NOT NULL); 