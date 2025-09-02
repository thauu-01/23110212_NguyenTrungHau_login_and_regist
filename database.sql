CREATE DATABASE hau;
GO

USE hau;
GO

CREATE TABLE [User] (
    id INT IDENTITY(1,1) PRIMARY KEY,
    email NVARCHAR(255) NOT NULL,
    username NVARCHAR(50) NOT NULL UNIQUE,
    fullname NVARCHAR(100) NOT NULL,
    password NVARCHAR(255) NOT NULL,
    avatar NVARCHAR(255),
    roleid INT NOT NULL,
    phone NVARCHAR(20),
    createdDate DATE NOT NULL
);
GO

CREATE LOGIN hau WITH PASSWORD = '123';
GO


USE hau;
GO
CREATE USER hau FOR LOGIN hau;
GO


ALTER ROLE db_owner ADD MEMBER hau;
GO
Use hau;
INSERT INTO [User] (email, username, fullname, password, avatar, roleid, phone, createdDate)
VALUES ('hau@example.com', 'hau', 'Hau User', '123', NULL, 3, '0123456789', GETDATE());
Go