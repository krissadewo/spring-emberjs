DROP TABLE IF EXISTS master_kabupaten;

CREATE TABLE master_kabupaten (
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  id_provinsi int(11) unsigned NOT NULL,
  nama varchar(50) NOT NULL,
  kode varchar(11) NOT NULL DEFAULT '',
  PRIMARY KEY (id),
  UNIQUE KEY id_provinsi (id_provinsi,kode)
);

INSERT INTO master_kabupaten (id, id_provinsi, nama, kode)
VALUES
	(9,1,'Aceh Selatan','11.01'),
	(10,1,'Aceh Tenggara','11.02'),
	(11,1,'Aceh Timur','11.03'),
	(12,1,'Aceh Tengah','11.04'),
	(13,2,'ASAHAN','12.09');

CREATE TABLE master_provinsi (
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  kode varchar(50) NOT NULL,
  nama varchar(50) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO master_provinsi (id, kode, nama)
VALUES
	(1,'11','Aceh'),
	(2,'12','SUMATERA UTARA'),
	(3,'13','SUMATERA BARAT');


