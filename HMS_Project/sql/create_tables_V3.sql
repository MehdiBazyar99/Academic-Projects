CREATE DATABASE IF NOT EXISTS hotel_database ;
USE hotel_database ;


-- ************************************** hoteladdress_id

CREATE TABLE hotel
(
 hotel_id             int NOT NULL AUTO_INCREMENT ,
 hotel_name           varchar(45) NULL DEFAULT NULL ,
 contact_number       varchar(12) NULL DEFAULT NULL ,
 email_address        varchar(45) NULL DEFAULT NULL ,
 website              varchar(45) NULL DEFAULT NULL ,
 hotel_description    varchar(100) NULL DEFAULT NULL ,
 room_capacity        int NULL DEFAULT NULL ,
  address_line 	      varchar(250) NOT NULL ,
 city                 varchar(45) NULL DEFAULT NULL ,
 state                varchar(45) NULL DEFAULT NULL ,
 country              varchar(45) NULL DEFAULT NULL ,
 postal_code          varchar(45) NULL DEFAULT NULL ,

PRIMARY KEY (hotel_id))
;




-- ************************************** room_type

CREATE TABLE room_type
(
 room_type_id     int NOT NULL AUTO_INCREMENT ,
 type_name        varchar(45) NULL DEFAULT NULL ,
 type_cost        decimal(10,2) NULL DEFAULT NULL ,
 type_description varchar(100) NULL DEFAULT NULL ,
 smoke_friendly   tinyint(1) NULL DEFAULT NULL ,

PRIMARY KEY (room_type_id)
);






-- ************************************** room

CREATE TABLE room
(
 room_id                int NOT NULL AUTO_INCREMENT ,
 room_number            int NULL DEFAULT NULL ,
 room_type_room_type_id int NOT NULL ,
 hotel_hotel_id         int NOT NULL ,

PRIMARY KEY (room_id),
KEY hotel_hotel_id (hotel_hotel_id),
CONSTRAINT rooms_ibfk_2 FOREIGN KEY hotel_hotel_id (hotel_hotel_id) REFERENCES hotel (hotel_id),
KEY room_type_room_type_id (room_type_room_type_id),
CONSTRAINT rooms_ibfk_1 FOREIGN KEY room_type_room_type_id (room_type_room_type_id) REFERENCES room_type (room_type_id)
);




-- ************************************** guests

CREATE TABLE guests
(
 guest_id             int NOT NULL AUTO_INCREMENT ,
 national_code        varchar(45) NOT NULL ,
 first_name           varchar(45) NULL DEFAULT NULL ,
 last_name            varchar(45) NULL DEFAULT NULL ,
 contact_number       varchar(12) NULL DEFAULT NULL ,
 times_been_here      int NULL DEFAULT NULL ,
 email_address        varchar(45) NULL DEFAULT NULL ,
address_line varchar(250) NOT NULL ,
 city         varchar(45) NULL DEFAULT NULL ,
 state     varchar(45) NULL DEFAULT NULL ,
 country      varchar(45) NULL DEFAULT NULL ,
 postal_code      varchar(45) NULL DEFAULT NULL ,

PRIMARY KEY (guest_id)
) ;





-- ************************************** bookings

CREATE TABLE bookings
(
 booking_id       int NOT NULL auto_increment ,
 booking_date     datetime NULL DEFAULT NULL ,
 duration_of_stay int NULL DEFAULT NULL ,
 check_in_date    datetime NULL DEFAULT NULL ,
 check_out_date   datetime NULL DEFAULT NULL ,
 hotel_hotel_id   int NOT NULL ,
 guests_guest_id  int NOT NULL ,
 room_room_id     int NOT NULL ,
 total_payment 	  int NOT NULL ,
 checked_out 	  tinyint(1) NOT NULL DEFAULT 0,

PRIMARY KEY (booking_id),
KEY fkIdx_105 (room_room_id),
CONSTRAINT FK_104 FOREIGN KEY fkIdx_105 (room_room_id) REFERENCES room (room_id),
KEY guests_guest_id (guests_guest_id),
CONSTRAINT bookings_ibfk_2 FOREIGN KEY guests_guest_id (guests_guest_id) REFERENCES guests (guest_id),
KEY hotel_hotel_id (hotel_hotel_id),
CONSTRAINT bookings_ibfk_1 FOREIGN KEY hotel_hotel_id (hotel_hotel_id) REFERENCES hotel (hotel_id)
);




-- ************************************** invoice

CREATE TABLE invoice
(
 invoice_id          int NOT NULL auto_increment ,
 invoice_date        date NULL DEFAULT NULL ,
 bookings_booking_id int NOT NULL ,
 discount_rate       int NULL DEFAULT NULL ,
 amount_billed       int NOT NULL ,

PRIMARY KEY (invoice_id),
KEY bookings_booking_id (bookings_booking_id),
CONSTRAINT invoice_ibfk_1 FOREIGN KEY bookings_booking_id (bookings_booking_id) REFERENCES bookings (booking_id)
);






-- ************************************** hotel_services

CREATE TABLE hotel_services
(
 service_id          int NOT NULL auto_increment ,
 service_name        varchar(45) NULL DEFAULT NULL ,
 service_description varchar(100) NULL DEFAULT NULL ,
 service_cost        decimal(10,2) NULL DEFAULT NULL ,
 hotel_hotel_id      int NOT NULL ,

PRIMARY KEY (service_id),
KEY hotel_hotel_id (hotel_hotel_id),
CONSTRAINT hotel_services_ibfk_1 FOREIGN KEY hotel_hotel_id (hotel_hotel_id) REFERENCES hotel (hotel_id)
);






CREATE TABLE service_used
(
 service_used_id           int NOT NULL  auto_increment,
 hotel_services_service_id int  NULL ,
 bookings_booking_id       int NOT NULL ,

PRIMARY KEY (service_used_id),
FOREIGN KEY bookings_booking_id (bookings_booking_id) REFERENCES bookings (booking_id),
FOREIGN KEY hotel_services_service_id (hotel_services_service_id) REFERENCES hotel_services (service_id)
) ;









