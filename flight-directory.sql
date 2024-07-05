create database if not exists flight_directory;
use flight_directory;
drop table if exists flight;
create table flight 
(flight_no varchar(50) not null, 
airlines_name varchar(100) not null,
starting_point varchar(100) not null,
ending_point varchar(100) not null,
price int not null,
primary key(flightNo)
)
engine = InnoDB default charset= latin1;
insert into flight values
('AI 856','Air India','Ladakh ','Mumbai',10500),
('6E 5345','IndiGo','Hyderabad','New Delhi',9039),
('UK 993','Vistara','Bengaluru','Dimapur',11498),
('6E 7309','Akasa','Shillong','Ahmedabad',19590);

