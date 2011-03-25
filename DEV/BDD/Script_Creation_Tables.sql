---------------------------------------------------------------------------------------
-- QCM PROJECT
-- Gestion du script de création des tables.
---------------------------------------------------------------------------------------

CREATE TABLE Theme (
  Code CHAR(5)  NOT NULL  ,
  Libelle VARCHAR(45)  NOT NULL    ,
PRIMARY KEY(Code));
GO



CREATE TABLE Test (
  Numero INTEGER  NOT NULL   IDENTITY ,
  Nom VARCHAR(100)  NOT NULL  ,
  Duree INTEGER    ,
  SeuilReussite NUMERIC      ,
PRIMARY KEY(Numero));
GO



CREATE TABLE TypeCandidature (
  Code CHAR(5)  NOT NULL  ,
  Libelle VARCHAR(80)  NOT NULL    ,
PRIMARY KEY(Code));
GO



CREATE TABLE TypeQuestion (
  Code CHAR(2)  NOT NULL  ,
  Libelle VARCHAR(45)  NOT NULL    ,
PRIMARY KEY(Code));
GO



CREATE TABLE DestinataireReponse (
  Numero INTEGER  NOT NULL   IDENTITY ,
  Nom VARCHAR(45)  NOT NULL  ,
  Email VARCHAR(45)  NOT NULL    ,
PRIMARY KEY(Numero));
GO



CREATE TABLE Section (
  Numero INTEGER  NOT NULL   IDENTITY ,
  Test_Numero INTEGER  NOT NULL  ,
  NumeroOrdre INTEGER  NOT NULL  ,
  Nom VARCHAR(255)  NOT NULL  ,
  NbQuestion INTEGER      ,
PRIMARY KEY(Numero)  ,
  FOREIGN KEY(Test_Numero)
    REFERENCES Test(Numero));
GO


CREATE INDEX Section_FKI_TestNum ON Section (Test_Numero);
GO



CREATE TABLE Candidat (
  Numero INTEGER  NOT NULL   IDENTITY ,
  TypeCandidature_Code CHAR(5)  NOT NULL  ,
  Nom VARCHAR(45)  NOT NULL  ,
  Prenom VARCHAR(45)  NOT NULL  ,
  Email VARCHAR(45)  NOT NULL  ,
  Promotion VARCHAR(45)    ,
  Login VARCHAR(50)  NOT NULL  ,
  MotDePasse VARCHAR(10)  NOT NULL    ,
PRIMARY KEY(Numero)  ,
  FOREIGN KEY(TypeCandidature_Code)
    REFERENCES TypeCandidature(Code));
GO


CREATE INDEX Candidat_FKI_TypeCandidat ON Candidat (TypeCandidature_Code);
GO



CREATE TABLE Examen (
  Numero INTEGER  NOT NULL   IDENTITY ,
  Test_Numero INTEGER  NOT NULL  ,
  DestinataireReponse_Numero INTEGER  NOT NULL  ,
  DateDebut DATETIME  NOT NULL  ,
  DateFin DATETIME  NOT NULL  ,
  TpsRestant INTEGER  NOT NULL    ,
PRIMARY KEY(Numero)    ,
  FOREIGN KEY(DestinataireReponse_Numero)
    REFERENCES DestinataireReponse(Numero),
  FOREIGN KEY(Test_Numero)
    REFERENCES Test(Numero));
GO


CREATE INDEX Examen_FKI_Dest_Rep ON Examen (DestinataireReponse_Numero);
GO
CREATE INDEX Examen_FKI_TestNum ON Examen (Test_Numero);
GO



CREATE TABLE Question (
  Numero INTEGER  NOT NULL   IDENTITY ,
  Theme_Code CHAR(5)  NOT NULL  ,
  TypeQuestion_Code CHAR(2)  NOT NULL  ,
  Enonce VARCHAR(255)  NOT NULL  ,
  ImageIllustration VARCHAR(255)    ,
  MiseEnForme VARCHAR(255)      ,
PRIMARY KEY(Numero)    ,
  FOREIGN KEY(TypeQuestion_Code)
    REFERENCES TypeQuestion(Code),
  FOREIGN KEY(Theme_Code)
    REFERENCES Theme(Code));
GO


CREATE INDEX Question_FKI_TypeQuest ON Question (TypeQuestion_Code);
GO
CREATE INDEX Question_FKI_ThemeCod ON Question (Theme_Code);
GO



CREATE TABLE SessionCandidat (
  NumSession INTEGER  NOT NULL  ,
  Candidat_Numero INTEGER  NOT NULL  ,
  Examen_Numero INTEGER  NOT NULL  ,
  TempsRestant INTEGER  NOT NULL   IDENTITY   ,
PRIMARY KEY(NumSession)    ,
  FOREIGN KEY(Candidat_Numero)
    REFERENCES Candidat(Numero),
  FOREIGN KEY(Examen_Numero)
    REFERENCES Examen(Numero));
GO


CREATE INDEX SessionCandidat_FKIndex1 ON SessionCandidat (Candidat_Numero);
GO
CREATE INDEX SessionCandidat_FKIndex2 ON SessionCandidat (Examen_Numero);
GO



CREATE TABLE Reponse (
  Numero INTEGER  NOT NULL   IDENTITY ,
  Question_Numero INTEGER  NOT NULL  ,
  Libelle VARCHAR(255)  NOT NULL  ,
  BonneReponse BIT  NOT NULL    ,
PRIMARY KEY(Numero)  ,
  FOREIGN KEY(Question_Numero)
    REFERENCES Question(Numero));
GO


CREATE INDEX Reponse_FKI_QuestNum ON Reponse (Question_Numero);
GO



CREATE TABLE DetailSection (
  Question_Numero INTEGER  NOT NULL  ,
  Section_Numero INTEGER  NOT NULL    ,
PRIMARY KEY(Question_Numero, Section_Numero)    ,
  FOREIGN KEY(Section_Numero)
    REFERENCES Section(Numero),
  FOREIGN KEY(Question_Numero)
    REFERENCES Question(Numero));
GO


CREATE INDEX DetailSection_FKI_SectionNum ON DetailSection (Section_Numero);
GO
CREATE INDEX DetailSection_FKI_QuestNum ON DetailSection (Question_Numero);
GO



CREATE TABLE DetailExamen (
  NumQuestionTiree INTEGER  NOT NULL  ,
  DetailSection_Section_Numero INTEGER  NOT NULL  ,
  DetailSection_Question_Numero INTEGER  NOT NULL  ,
  SessionCandidat_NumSession INTEGER  NOT NULL    ,
PRIMARY KEY(NumQuestionTiree)    ,
  FOREIGN KEY(SessionCandidat_NumSession)
    REFERENCES SessionCandidat(NumSession),
  FOREIGN KEY(DetailSection_Question_Numero, DetailSection_Section_Numero)
    REFERENCES DetailSection(Question_Numero, Section_Numero));
GO


CREATE INDEX DetailExamen_FKI_SessionNum ON DetailExamen (SessionCandidat_NumSession);
GO
CREATE INDEX DetailExamen_FKI_DetailTest_Num ON DetailExamen (DetailSection_Question_Numero, DetailSection_Section_Numero);
GO



CREATE TABLE ReponseExamen (
  NumReponseExam INTEGER  NOT NULL  ,
  Reponse_Numero INTEGER  NOT NULL  ,
  DetailExamen_NumQuestionTiree INTEGER  NOT NULL    ,
PRIMARY KEY(NumReponseExam)    ,
  FOREIGN KEY(DetailExamen_NumQuestionTiree)
    REFERENCES DetailExamen(NumQuestionTiree),
  FOREIGN KEY(Reponse_Numero)
    REFERENCES Reponse(Numero));
GO


CREATE INDEX ReponseExamen_FKI_QuestNum ON ReponseExamen (DetailExamen_NumQuestionTiree);
GO
CREATE INDEX ReponseExamen_FKI_RepNum ON ReponseExamen (Reponse_Numero);
GO




