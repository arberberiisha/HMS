USE [master]
GO
/****** Object:  Database [HotelDB]    Script Date: 21-Jun-19 3:12:13 AM ******/
CREATE DATABASE [HotelDB]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'HotelDB', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\HotelDB.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'HotelDB_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\HotelDB_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [HotelDB] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [HotelDB].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [HotelDB] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [HotelDB] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [HotelDB] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [HotelDB] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [HotelDB] SET ARITHABORT OFF 
GO
ALTER DATABASE [HotelDB] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [HotelDB] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [HotelDB] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [HotelDB] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [HotelDB] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [HotelDB] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [HotelDB] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [HotelDB] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [HotelDB] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [HotelDB] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [HotelDB] SET  DISABLE_BROKER 
GO
ALTER DATABASE [HotelDB] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [HotelDB] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [HotelDB] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [HotelDB] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [HotelDB] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [HotelDB] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [HotelDB] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [HotelDB] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [HotelDB] SET  MULTI_USER 
GO
ALTER DATABASE [HotelDB] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [HotelDB] SET DB_CHAINING OFF 
GO
ALTER DATABASE [HotelDB] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [HotelDB] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [HotelDB]
GO
/****** Object:  Table [dbo].[Admin]    Script Date: 21-Jun-19 3:12:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Admin](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NOT NULL,
	[password] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Admin] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Dhoma]    Script Date: 21-Jun-19 3:12:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Dhoma](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Emertimi] [varchar](250) NULL,
	[NrShtreterve] [int] NULL,
	[LlojiDhomesID] [int] NULL,
	[KatiID] [int] NULL,
 CONSTRAINT [PK_Dhoma] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Kati]    Script Date: 21-Jun-19 3:12:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Kati](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Emertimi] [varchar](250) NOT NULL,
 CONSTRAINT [PK_Kati] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
///****** Object:  Table [dbo].[Klienti]    Script Date: 21-Jun-19 3:12:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Klienti](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[Emri] [varchar](50) NULL,
	[Mbiemri] [varchar](50) NULL,
	[Telefoni] [int] NULL,
	[QytetiID] [int] NULL,
	[ShtetiID] [int] NULL,
	[PersonalNumber] [int] NOT NULL,
 CONSTRAINT [PK_Klienti_1] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[LlojiDhomes]    Script Date: 21-Jun-19 3:12:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[LlojiDhomes](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Emertimi] [varchar](250) NOT NULL,
 CONSTRAINT [PK_LlojiDhomes] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[LogIn]    Script Date: 21-Jun-19 3:12:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[LogIn](
	[LoginID] [int] NOT NULL,
	[UserName] [varchar](50) NOT NULL,
	[Password] [varchar](50) NOT NULL,
	[IDRoli] [int] NOT NULL,
 CONSTRAINT [PK_LogIn] PRIMARY KEY CLUSTERED 
(
	[LoginID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Qyteti]    Script Date: 21-Jun-19 3:12:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Qyteti](
	[id] [int] NOT NULL,
	[Qyteti] [varchar](50) NULL,
	[ShtetiID] [int] NULL,
 CONSTRAINT [PK_Qyteti] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Rezervimi]    Script Date: 21-Jun-19 3:12:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Rezervimi](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[DhomaID] [int] NOT NULL,
	[StafiID] [int] NULL,
	[KlientiID] [int] NOT NULL,
	[Cmimi] [int] NOT NULL,
	[NgaData] [date] NOT NULL,
	[Deri] [date] NOT NULL,
	[DataRegjistrimit] [date] NULL,
 CONSTRAINT [PK_Rezervimi] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Roli]    Script Date: 21-Jun-19 3:12:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Roli](
	[id] [int] NOT NULL,
	[roli] [varchar](20) NOT NULL,
 CONSTRAINT [PK_Roli] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Shteti]    Script Date: 21-Jun-19 3:12:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Shteti](
	[id] [int] NOT NULL,
	[Shteti] [varchar](50) NULL,
 CONSTRAINT [PK_Shteti] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Admin] ON 

INSERT [dbo].[Admin] ([ID], [name], [password]) VALUES (1, N'Arber', N'Arber321')
INSERT [dbo].[Admin] ([ID], [name], [password]) VALUES (2, N'admin', N'admin')
SET IDENTITY_INSERT [dbo].[Admin] OFF
SET IDENTITY_INSERT [dbo].[Dhoma] ON 

INSERT [dbo].[Dhoma] ([ID], [Emertimi], [NrShtreterve], [LlojiDhomesID], [KatiID]) VALUES (1, N'001', 5, 1, 1)
INSERT [dbo].[Dhoma] ([ID], [Emertimi], [NrShtreterve], [LlojiDhomesID], [KatiID]) VALUES (2, N'002', 3, 3, 1)
INSERT [dbo].[Dhoma] ([ID], [Emertimi], [NrShtreterve], [LlojiDhomesID], [KatiID]) VALUES (3, N'003', 4, 4, 1)
INSERT [dbo].[Dhoma] ([ID], [Emertimi], [NrShtreterve], [LlojiDhomesID], [KatiID]) VALUES (4, N'004', 3, 4, 1)
INSERT [dbo].[Dhoma] ([ID], [Emertimi], [NrShtreterve], [LlojiDhomesID], [KatiID]) VALUES (5, N'005', 3, 1, 1)
INSERT [dbo].[Dhoma] ([ID], [Emertimi], [NrShtreterve], [LlojiDhomesID], [KatiID]) VALUES (6, N'006', 4, 4, 2)
INSERT [dbo].[Dhoma] ([ID], [Emertimi], [NrShtreterve], [LlojiDhomesID], [KatiID]) VALUES (7, N'007', 1, 1, 2)
INSERT [dbo].[Dhoma] ([ID], [Emertimi], [NrShtreterve], [LlojiDhomesID], [KatiID]) VALUES (8, N'008', 2, 3, 2)
INSERT [dbo].[Dhoma] ([ID], [Emertimi], [NrShtreterve], [LlojiDhomesID], [KatiID]) VALUES (9, N'009', 2, 1, 2)
INSERT [dbo].[Dhoma] ([ID], [Emertimi], [NrShtreterve], [LlojiDhomesID], [KatiID]) VALUES (10, N'010', 2, 3, 2)
INSERT [dbo].[Dhoma] ([ID], [Emertimi], [NrShtreterve], [LlojiDhomesID], [KatiID]) VALUES (11, N'011', 3, 4, 3)
INSERT [dbo].[Dhoma] ([ID], [Emertimi], [NrShtreterve], [LlojiDhomesID], [KatiID]) VALUES (12, N'012', 2, 1, 3)
INSERT [dbo].[Dhoma] ([ID], [Emertimi], [NrShtreterve], [LlojiDhomesID], [KatiID]) VALUES (13, N'013', 4, 3, 3)
INSERT [dbo].[Dhoma] ([ID], [Emertimi], [NrShtreterve], [LlojiDhomesID], [KatiID]) VALUES (18, N'014', 2, 3, 3)
INSERT [dbo].[Dhoma] ([ID], [Emertimi], [NrShtreterve], [LlojiDhomesID], [KatiID]) VALUES (19, N'015', 3, 4, 3)
INSERT [dbo].[Dhoma] ([ID], [Emertimi], [NrShtreterve], [LlojiDhomesID], [KatiID]) VALUES (20, N'550', 4, 1, 1)
SET IDENTITY_INSERT [dbo].[Dhoma] OFF
SET IDENTITY_INSERT [dbo].[Kati] ON 

INSERT [dbo].[Kati] ([ID], [Emertimi]) VALUES (1, N'Kati Pare')
INSERT [dbo].[Kati] ([ID], [Emertimi]) VALUES (2, N'Kati Dyte')
INSERT [dbo].[Kati] ([ID], [Emertimi]) VALUES (3, N'Kati Trete')
INSERT [dbo].[Kati] ([ID], [Emertimi]) VALUES (4, N'Kati Katert')
SET IDENTITY_INSERT [dbo].[Kati] OFF
SET IDENTITY_INSERT [dbo].[Klienti] ON 

INSERT [dbo].[Klienti] ([id], [Emri], [Mbiemri], [Telefoni], [QytetiID], [ShtetiID], [PersonalNumber]) VALUES (1, N'Arber', N'Berisha', 1230123, 2, 1, 123456789)
INSERT [dbo].[Klienti] ([id], [Emri], [Mbiemri], [Telefoni], [QytetiID], [ShtetiID], [PersonalNumber]) VALUES (2, N'Urim', N'Morina', 1243412, 1, 2, 876543456)
INSERT [dbo].[Klienti] ([id], [Emri], [Mbiemri], [Telefoni], [QytetiID], [ShtetiID], [PersonalNumber]) VALUES (3, N'asd', N'asdasd', 123123, 3, 2, 123123)
INSERT [dbo].[Klienti] ([id], [Emri], [Mbiemri], [Telefoni], [QytetiID], [ShtetiID], [PersonalNumber]) VALUES (4, N'asdasda', N'asdasd', 123123, 1, 1, 33231331)
INSERT [dbo].[Klienti] ([id], [Emri], [Mbiemri], [Telefoni], [QytetiID], [ShtetiID], [PersonalNumber]) VALUES (5, N'Enes', N'Nuzi', 324421, 1, 1, 43211234)
INSERT [dbo].[Klienti] ([id], [Emri], [Mbiemri], [Telefoni], [QytetiID], [ShtetiID], [PersonalNumber]) VALUES (6, N'Okendi', N'Gjepali', 909090, 4, 1, 0)
INSERT [dbo].[Klienti] ([id], [Emri], [Mbiemri], [Telefoni], [QytetiID], [ShtetiID], [PersonalNumber]) VALUES (7, N'Urim', N'MM', 54545, 1, 2, 54545454)
INSERT [dbo].[Klienti] ([id], [Emri], [Mbiemri], [Telefoni], [QytetiID], [ShtetiID], [PersonalNumber]) VALUES (8, N'asddasdasdas', N'asdasdasd', 123123, 2, 1, 123123)
INSERT [dbo].[Klienti] ([id], [Emri], [Mbiemri], [Telefoni], [QytetiID], [ShtetiID], [PersonalNumber]) VALUES (9, N'hgghhg', N'kjjkkj', 87678687, 2, 1, 45454)
INSERT [dbo].[Klienti] ([id], [Emri], [Mbiemri], [Telefoni], [QytetiID], [ShtetiID], [PersonalNumber]) VALUES (10, N'dsfdsf', N'dsfdsf', 21123, 1, 1, 213)
INSERT [dbo].[Klienti] ([id], [Emri], [Mbiemri], [Telefoni], [QytetiID], [ShtetiID], [PersonalNumber]) VALUES (11, N'gdfsdfd', N'asdad', 231231, 2, 1, 123123)
INSERT [dbo].[Klienti] ([id], [Emri], [Mbiemri], [Telefoni], [QytetiID], [ShtetiID], [PersonalNumber]) VALUES (12, N'arber', N'arber', 123123, 2, 1, 123123)
INSERT [dbo].[Klienti] ([id], [Emri], [Mbiemri], [Telefoni], [QytetiID], [ShtetiID], [PersonalNumber]) VALUES (13, N'asdasd', N'asdasd', 321123, 2, 1, 321123)
INSERT [dbo].[Klienti] ([id], [Emri], [Mbiemri], [Telefoni], [QytetiID], [ShtetiID], [PersonalNumber]) VALUES (14, N'ok', N'ok', 666, 1, 1, 666)
SET IDENTITY_INSERT [dbo].[Klienti] OFF
SET IDENTITY_INSERT [dbo].[LlojiDhomes] ON 

INSERT [dbo].[LlojiDhomes] ([ID], [Emertimi]) VALUES (1, N'VIP')
INSERT [dbo].[LlojiDhomes] ([ID], [Emertimi]) VALUES (3, N'Mesatare')
INSERT [dbo].[LlojiDhomes] ([ID], [Emertimi]) VALUES (4, N'E Thjeshte')
SET IDENTITY_INSERT [dbo].[LlojiDhomes] OFF
INSERT [dbo].[LogIn] ([LoginID], [UserName], [Password], [IDRoli]) VALUES (1, N'Urim', N'ubt123', 1)
INSERT [dbo].[LogIn] ([LoginID], [UserName], [Password], [IDRoli]) VALUES (2, N'Arber', N'Arber123', 1)
INSERT [dbo].[LogIn] ([LoginID], [UserName], [Password], [IDRoli]) VALUES (3, N'Lavdim', N'ubt123', 1)
INSERT [dbo].[LogIn] ([LoginID], [UserName], [Password], [IDRoli]) VALUES (4, N'Admin', N'admin', 1)
INSERT [dbo].[LogIn] ([LoginID], [UserName], [Password], [IDRoli]) VALUES (5, N'Enes', N'ubt123', 2)
INSERT [dbo].[LogIn] ([LoginID], [UserName], [Password], [IDRoli]) VALUES (7, N'a', N'a', 1)
INSERT [dbo].[Qyteti] ([id], [Qyteti], [ShtetiID]) VALUES (1, N'Prishtine', 1)
INSERT [dbo].[Qyteti] ([id], [Qyteti], [ShtetiID]) VALUES (2, N'Prizren', 1)
INSERT [dbo].[Qyteti] ([id], [Qyteti], [ShtetiID]) VALUES (3, N'Ferizaj', 1)
INSERT [dbo].[Qyteti] ([id], [Qyteti], [ShtetiID]) VALUES (4, N'Gjakove', 1)
INSERT [dbo].[Qyteti] ([id], [Qyteti], [ShtetiID]) VALUES (5, N'Gjilan', 1)
SET IDENTITY_INSERT [dbo].[Rezervimi] ON 

INSERT [dbo].[Rezervimi] ([ID], [DhomaID], [StafiID], [KlientiID], [Cmimi], [NgaData], [Deri], [DataRegjistrimit]) VALUES (1, 1, 2, 1, 10, CAST(0x4C320B00 AS Date), CAST(0x684D0B00 AS Date), CAST(0xBA3F0B00 AS Date))
INSERT [dbo].[Rezervimi] ([ID], [DhomaID], [StafiID], [KlientiID], [Cmimi], [NgaData], [Deri], [DataRegjistrimit]) VALUES (7, 3, 3, 2, 10, CAST(0x6B430B00 AS Date), CAST(0xD8440B00 AS Date), CAST(0xBA3F0B00 AS Date))
INSERT [dbo].[Rezervimi] ([ID], [DhomaID], [StafiID], [KlientiID], [Cmimi], [NgaData], [Deri], [DataRegjistrimit]) VALUES (8, 1, 1, 1, 10, CAST(0xD8440B00 AS Date), CAST(0x8D4A0B00 AS Date), CAST(0xBA3F0B00 AS Date))
INSERT [dbo].[Rezervimi] ([ID], [DhomaID], [StafiID], [KlientiID], [Cmimi], [NgaData], [Deri], [DataRegjistrimit]) VALUES (10, 5, 1, 2, 10, CAST(0x45460B00 AS Date), CAST(0xB3470B00 AS Date), CAST(0xBA3F0B00 AS Date))
INSERT [dbo].[Rezervimi] ([ID], [DhomaID], [StafiID], [KlientiID], [Cmimi], [NgaData], [Deri], [DataRegjistrimit]) VALUES (11, 6, 2, 2, 10, CAST(0x6B430B00 AS Date), CAST(0xB3470B00 AS Date), CAST(0xBA3F0B00 AS Date))
INSERT [dbo].[Rezervimi] ([ID], [DhomaID], [StafiID], [KlientiID], [Cmimi], [NgaData], [Deri], [DataRegjistrimit]) VALUES (12, 12, 7, 2, 25, CAST(0xBF3F0B00 AS Date), CAST(0xC73F0B00 AS Date), CAST(0xBA3F0B00 AS Date))
INSERT [dbo].[Rezervimi] ([ID], [DhomaID], [StafiID], [KlientiID], [Cmimi], [NgaData], [Deri], [DataRegjistrimit]) VALUES (13, 8, 2, 1, 10, CAST(0x8D4A0B00 AS Date), CAST(0xFA4B0B00 AS Date), CAST(0xBA3F0B00 AS Date))
INSERT [dbo].[Rezervimi] ([ID], [DhomaID], [StafiID], [KlientiID], [Cmimi], [NgaData], [Deri], [DataRegjistrimit]) VALUES (19, 4, 1, 2, 10, CAST(0xFA4B0B00 AS Date), CAST(0x684D0B00 AS Date), CAST(0xBA3F0B00 AS Date))
INSERT [dbo].[Rezervimi] ([ID], [DhomaID], [StafiID], [KlientiID], [Cmimi], [NgaData], [Deri], [DataRegjistrimit]) VALUES (23, 10, 7, 2, 50, CAST(0xC03F0B00 AS Date), CAST(0xA0420B00 AS Date), CAST(0xBA3F0B00 AS Date))
INSERT [dbo].[Rezervimi] ([ID], [DhomaID], [StafiID], [KlientiID], [Cmimi], [NgaData], [Deri], [DataRegjistrimit]) VALUES (24, 11, 7, 1, 50, CAST(0xC03F0B00 AS Date), CAST(0xA0420B00 AS Date), CAST(0xBA3F0B00 AS Date))
INSERT [dbo].[Rezervimi] ([ID], [DhomaID], [StafiID], [KlientiID], [Cmimi], [NgaData], [Deri], [DataRegjistrimit]) VALUES (25, 4, 7, 2, 50, CAST(0xC03F0B00 AS Date), CAST(0xA0420B00 AS Date), CAST(0xBA3F0B00 AS Date))
INSERT [dbo].[Rezervimi] ([ID], [DhomaID], [StafiID], [KlientiID], [Cmimi], [NgaData], [Deri], [DataRegjistrimit]) VALUES (29, 2, 7, 1, 20, CAST(0xC63F0B00 AS Date), CAST(0xC83F0B00 AS Date), CAST(0xBA3F0B00 AS Date))
INSERT [dbo].[Rezervimi] ([ID], [DhomaID], [StafiID], [KlientiID], [Cmimi], [NgaData], [Deri], [DataRegjistrimit]) VALUES (30, 12, 7, 2, 25, CAST(0xBF3F0B00 AS Date), CAST(0xC73F0B00 AS Date), CAST(0xBA3F0B00 AS Date))
INSERT [dbo].[Rezervimi] ([ID], [DhomaID], [StafiID], [KlientiID], [Cmimi], [NgaData], [Deri], [DataRegjistrimit]) VALUES (34, 19, 7, 1, 5, CAST(0xC13F0B00 AS Date), CAST(0xE3460B00 AS Date), CAST(0xBA3F0B00 AS Date))
INSERT [dbo].[Rezervimi] ([ID], [DhomaID], [StafiID], [KlientiID], [Cmimi], [NgaData], [Deri], [DataRegjistrimit]) VALUES (36, 12, 7, 2, 25, CAST(0xBF3F0B00 AS Date), CAST(0xC73F0B00 AS Date), NULL)
INSERT [dbo].[Rezervimi] ([ID], [DhomaID], [StafiID], [KlientiID], [Cmimi], [NgaData], [Deri], [DataRegjistrimit]) VALUES (37, 12, 7, 1, 25, CAST(0xBF3F0B00 AS Date), CAST(0xC73F0B00 AS Date), NULL)
INSERT [dbo].[Rezervimi] ([ID], [DhomaID], [StafiID], [KlientiID], [Cmimi], [NgaData], [Deri], [DataRegjistrimit]) VALUES (39, 8, 7, 5, 25, CAST(0xBD3F0B00 AS Date), CAST(0xCF3F0B00 AS Date), NULL)
INSERT [dbo].[Rezervimi] ([ID], [DhomaID], [StafiID], [KlientiID], [Cmimi], [NgaData], [Deri], [DataRegjistrimit]) VALUES (40, 13, 7, 6, 25, CAST(0xBD3F0B00 AS Date), CAST(0xD53F0B00 AS Date), NULL)
SET IDENTITY_INSERT [dbo].[Rezervimi] OFF
INSERT [dbo].[Roli] ([id], [roli]) VALUES (1, N'Admin')
INSERT [dbo].[Roli] ([id], [roli]) VALUES (2, N'Staf')
INSERT [dbo].[Shteti] ([id], [Shteti]) VALUES (1, N'Kosova    ')
INSERT [dbo].[Shteti] ([id], [Shteti]) VALUES (2, N'Shqiperia ')
ALTER TABLE [dbo].[Dhoma]  WITH CHECK ADD  CONSTRAINT [FK_Dhoma_Kati] FOREIGN KEY([KatiID])
REFERENCES [dbo].[Kati] ([ID])
GO
ALTER TABLE [dbo].[Dhoma] CHECK CONSTRAINT [FK_Dhoma_Kati]
GO
ALTER TABLE [dbo].[Dhoma]  WITH CHECK ADD  CONSTRAINT [FK_Dhoma_LlojiDhomes] FOREIGN KEY([LlojiDhomesID])
REFERENCES [dbo].[LlojiDhomes] ([ID])
GO
ALTER TABLE [dbo].[Dhoma] CHECK CONSTRAINT [FK_Dhoma_LlojiDhomes]
GO
ALTER TABLE [dbo].[Klienti]  WITH CHECK ADD  CONSTRAINT [FK_Klienti_Qyteti] FOREIGN KEY([QytetiID])
REFERENCES [dbo].[Qyteti] ([id])
GO
ALTER TABLE [dbo].[Klienti] CHECK CONSTRAINT [FK_Klienti_Qyteti]
GO
ALTER TABLE [dbo].[Klienti]  WITH CHECK ADD  CONSTRAINT [FK_Klienti_Shteti] FOREIGN KEY([ShtetiID])
REFERENCES [dbo].[Shteti] ([id])
GO
ALTER TABLE [dbo].[Klienti] CHECK CONSTRAINT [FK_Klienti_Shteti]
GO
ALTER TABLE [dbo].[LogIn]  WITH CHECK ADD  CONSTRAINT [FK_LogIn_Roli] FOREIGN KEY([IDRoli])
REFERENCES [dbo].[Roli] ([id])
GO
ALTER TABLE [dbo].[LogIn] CHECK CONSTRAINT [FK_LogIn_Roli]
GO
ALTER TABLE [dbo].[Qyteti]  WITH CHECK ADD  CONSTRAINT [FK_Qyteti_Shteti] FOREIGN KEY([ShtetiID])
REFERENCES [dbo].[Shteti] ([id])
GO
ALTER TABLE [dbo].[Qyteti] CHECK CONSTRAINT [FK_Qyteti_Shteti]
GO
ALTER TABLE [dbo].[Rezervimi]  WITH CHECK ADD  CONSTRAINT [FK_Rezervimi_Dhoma] FOREIGN KEY([DhomaID])
REFERENCES [dbo].[Dhoma] ([ID])
GO
ALTER TABLE [dbo].[Rezervimi] CHECK CONSTRAINT [FK_Rezervimi_Dhoma]
GO
ALTER TABLE [dbo].[Rezervimi]  WITH CHECK ADD  CONSTRAINT [FK_Rezervimi_Klienti] FOREIGN KEY([KlientiID])
REFERENCES [dbo].[Klienti] ([id])
GO
ALTER TABLE [dbo].[Rezervimi] CHECK CONSTRAINT [FK_Rezervimi_Klienti]
GO
ALTER TABLE [dbo].[Rezervimi]  WITH CHECK ADD  CONSTRAINT [FK_Rezervimi_LogIn] FOREIGN KEY([StafiID])
REFERENCES [dbo].[LogIn] ([LoginID])
GO
ALTER TABLE [dbo].[Rezervimi] CHECK CONSTRAINT [FK_Rezervimi_LogIn]
GO
USE [master]
GO
ALTER DATABASE [HotelDB] SET  READ_WRITE 
GO
