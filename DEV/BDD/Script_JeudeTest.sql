---------------------------------------------------------------------------------------
-- QCM PROJECT
-- Gestion du script de cr�ation des tables.
---------------------------------------------------------------------------------------

-- Creation des types de candidats
insert into TypeCandidature (Code,Libelle)
	values('VAE  ','Valorisation des Acquis Professionnel');
insert into TypeCandidature (Code,Libelle)
	values('FC   ','Formation continue');
insert into TypeCandidature (Code,Libelle)
	values('CP   ','Contrat de professionnalisation');
insert into TypeCandidature (Code,Libelle)
	values('SEL  ','Candidat � la s�lection d''entr�e');
insert into TypeCandidature (Code,Libelle)
	values('MOD  ','Suivi d''un module uniquement');
	

-- Cr�ation des types de questions
insert into TypeQuestion (Code,Libelle)
	values ('CU','Question � choix unique');
insert into TypeQuestion (Code,Libelle)
	values ('MU','Question � choix multiple');
	
-- Cr�ation des th�mes des questions
insert into Theme (Code,Libelle)
	values('SQLSE','Sql Serveur');
insert into Theme (Code,Libelle)
	values('SQLOR','Sql Oracle');
insert into Theme (Code,Libelle)
	values('VBNET','D�veloppement VB.NET');
insert into Theme (Code,Libelle)
	values('JAVSE','Java Standard Edition');
insert into Theme (Code,Libelle)
	values('JAVEE','Java Enterprise Edition');
insert into Theme (Code,Libelle)
	values('RUP  ','Rational Unified Process');
insert into Theme (Code,Libelle)
	values('UML  ','Unified Modeling Language');
insert into Theme (Code,Libelle)
	values('CDMOR','Oracle CDM');

-- Cr�ation des destinataires des r�ponses des examens pass�s.
insert into DestinataireReponse (Nom,Email)
	values('Responsable p�dagogique','Respedago@eni-ecole.fr');
insert into DestinataireReponse (Nom,Email)
	values('Service Administratif','ServAdm@eni-ecole.fr');
	

	

	
	
	
	

