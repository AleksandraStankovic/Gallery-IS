
use projektni_zadatak;



delimiter $$
create procedure unesi_stavku (in pIdRacun int, in pIdProizvod int, in pKolicina int, in pCijena decimal (10,2))
begin
INSERT INTO racun_stavka (idRacun, idProizvod, kolicina, cijena) VALUES (pIdRacun, pIdProizvod, pKolicina, pCijena);
end $$
delimiter ; 
 
    create view prikazi_slike as
    select Naziv, Ime, Prezime 
    from slika  inner join autor
    using (idAutor);
    
 
    create view  prikaz_sertifikata as
    select serijski_broj, Naziv, a.ime as autor_ime, a.prezime as autor_prezime, datum, z.Ime as zaposleni_ime, z.Prezime as zaposleni_prezime, idPoslovnica 
    from sertifikat sert inner join (slika s inner join autor a using (idAutor))
    on sert.Serijski_broj = s.idSlika 
    inner join poslovnica using (idPoslovnica) inner join zaposleni z using (idZaposleni);


create view ucitaj_sve_racune as
select idRacun, r.idZaposleni, Cijena from racun r inner join zaposleni using (idZaposleni); 


create view prikazi_sve_racune as
select idRacun, r.idZaposleni, Cijena from racun r inner join zaposleni using (idZaposleni); 


create view prikaz_inventara as 
SELECT ps.idPoslovnica, p.Ime, k.Naziv, i.kolicina, p.Cijena 
FROM 
    inventar i 
INNER JOIN 
    poslovnica ps USING (idPoslovnica)
INNER JOIN 
    proizvod p USING (idProizvod)
INNER JOIN 
    kategorija k USING (idKategorija)
    order by k.Naziv;


create view prikazi_narudzbe as
select n.idNarudzba, p.Ime, k.Naziv, p.cijena 
from narudzba n inner join narudzba_stavka using (idNarudzba)
inner join proizvod p using (idProizvod)
inner join kategorija k using (idKategorija);


delimiter $$
create procedure unos_slike (in pNazivSlike varchar (50), in pIdAutor int, in pIdKategorija int, in pImeProizvoda varchar (45), in pCijena decimal (10,2))
begin
declare vIdProizvod int; 
insert into Proizvod (idKategorija, Ime, Cijena) values (pIdKategorija, pImeProizvoda, pCijena); 
select last_insert_id() into vIdProizvod; 
insert into Slika (idSlika, Naziv, idAutor) values (vIdProizvod, pNazivSlike, pIdAutor); 
end $$
delimiter ; 


delimiter $$ 
create procedure kreiranje_sertifikata (in pIdKlijent int, in pIdPoslovnica int, in pIdSlika int, in pIdZaposleni int)
begin
insert into Sertifikat (idKlijent, Datum, idPoslovnica, idSlika, idZaposleni) 
values (pIdKlijent, CURDATE(), pIdPoslovnica, pIdSlika, pIdZaposleni); 
end $$
delimiter ;


delimiter $$
create procedure kreiraj_racun (in pIdZaposleni int) 
begin
insert into Racun (idZaposleni, Vrijeme) values (pIdZaposleni, NOW()); 
END $$
delimiter ;

call kreiraj_racun (2);

DELIMITER $$
CREATE PROCEDURE obrisi_racun(IN p_idRacun INT)
BEGIN
    DELETE FROM racun WHERE idRacun = p_idRacun;
END $$
DELIMITER ;


delimiter $$
create procedure azuriraj_racun (in pIdRacun int, pIdZaposleni int)
begin
update racun set idZaposleni = pIdZaposleni
where idRacun = pIdRacun;
end$$
delimiter ;

call azuriraj_racun (11, 2);

delimiter $$
create procedure azuriraj_proizvod (in pIdProizvod int, in pIdKategorija int,in  pIme varchar(45),in  pCijena decimal (10,2))
begin
update proizvod set idKategorija = pIdKategorija, Ime = pIme, Cijena = pCijena 
where idProizvod = pIdProizvod;
end$$
delimiter ;



DELIMITER $$

CREATE PROCEDURE prikazi_kategorije (IN pNazivKategorija VARCHAR(60))
BEGIN 
    SELECT Naziv 
    FROM Kategorija 
    WHERE Naziv = pNazivKategorija; 
END $$

DELIMITER ;


DROP PROCEDURE IF EXISTS prikazi_kategorije;
delimiter $$
CREATE PROCEDURE prikazi_sve_kategorije (IN pNazivKategorija VARCHAR(60))
BEGIN 
    SELECT Naziv 
    FROM Kategorija 
    WHERE Naziv = pNazivKategorija; 
END $$
DELIMITER ;


DELIMITER $$

CREATE PROCEDURE prikazi_sve_zaposlene (IN pIdZaposleni INT)
BEGIN
    IF pIdZaposleni IS NULL OR pIdZaposleni = 0 THEN
        SELECT Ime, Prezime 
        FROM Zaposleni;
    ELSE
        SELECT Ime, Prezime 
        FROM Zaposleni
        WHERE idZaposleni = pIdZaposleni;
    END IF;
END $$

DELIMITER ;


delimiter $$ 
create procedure trazi_proizvode_po_imenu (in pIme varchar (45))
begin
select * from proizvod inner join kategorija using (idKategorija)
where Ime like pIme; 
end $$
delimiter ; 


delimiter $$
create procedure unesi_stavku2 (in pIdRacun int, in pIdProizvod int, in pKolicina int, in pCijena decimal (10,2))
begin
INSERT INTO racun_stavka (idRacun, idProizvod, kolicina, cijena) VALUES (pIdRacun, pIdProizvod, pKolicina, pCijena);
end $$
delimiter; 

DELIMITER $$

CREATE PROCEDURE unesi_stavku (
    IN pIdRacun INT,
    IN pIdProizvod INT,
    IN pKolicina INT,
    IN pCijena DECIMAL(10, 2)
)
BEGIN
    INSERT INTO racun_stavka (idRacun, idProizvod, kolicina, cijena)
    VALUES (pIdRacun, pIdProizvod, pKolicina, pCijena);
END $$

DELIMITER ;


create view pregled_proizvoda as
	SELECT IdProizvod, Ime, Cijena, k.Naziv
    FROM proizvod inner join kategorija k using (IdKategorija) 
    ORDER BY Ime ASC;
    

create view prikazi_sve_kategorije as 
select Naziv from Kategorija; 

DROP TRIGGER IF EXISTS kupovina_proizvoda;


create trigger brisanje_slike after delete on slika
	for each row
    delete from proizvod where IdProizvod=old.IdSlika;
    









