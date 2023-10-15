use hirewheels;
insert into city values (1,"Gurugram");
insert into city values (2,"Delhi");
insert into city values (3,"Rohtak");
insert into city values (4,"Karnal");
insert into city values (5,"Sonipat");
insert into city values (6,"Hisar");
insert into city values (7,"Noida");
insert into city values (8,"Greater Noida");
insert into city values (9,"Faridabad");
insert into city values (10,"Gaziabad");

insert into fuel_type values (1,"DIESEL");
insert into fuel_type values (2,"PETROL");
insert into fuel_type values (3,"CNG");

insert into location (location_id, address, location_name, pincode, city_id) values (1,"H-101","Om vihar",122001,1);
insert into location (location_id, address, location_name, pincode, city_id) values (2,"82/76","Sector 5",122001,1);
insert into location (location_id, address, location_name, pincode, city_id) values (3,"K-101","Sector 23",122001,1);
insert into location (location_id, address, location_name, pincode, city_id) values (4,"H-117","Om vihar",122001,1);
insert into location (location_id, address, location_name, pincode, city_id) values (5,"G-101","Patel Nagar",122851,2);
insert into location (location_id, address, location_name, pincode, city_id) values (6,"K-101","Palam",122851,2);
insert into location (location_id, address, location_name, pincode, city_id) values (7,"H-101","South Ex",122851,2);

insert into role (role_id, role_name) values (1, "admin");
insert into role (role_id, role_name) values (2, "user"); 

insert into vehicle_category values (1,"2-wheelers");
insert into vehicle_category values (2,"3-wheelers");
insert into vehicle_category values (3,"4-wheelers");

insert into vehicle_subcategory (vehicle_subcategory_id, price_per_day, vehicle_category_id, vehicle_subcategory_name) values (1,600.00,1,"2-seater");
insert into vehicle_subcategory (vehicle_subcategory_id, price_per_day, vehicle_category_id, vehicle_subcategory_name) values (2,1500.00,2,"3-seater");
insert into vehicle_subcategory (vehicle_subcategory_id, price_per_day, vehicle_category_id, vehicle_subcategory_name) values (3,2500.00,3,"5-seater");
insert into vehicle_subcategory (vehicle_subcategory_id, price_per_day, vehicle_category_id, vehicle_subcategory_name) values (4,4000.00,3,"7-seater");
insert into vehicle_subcategory (vehicle_subcategory_id, price_per_day, vehicle_category_id, vehicle_subcategory_name) values (5,5500.00,3,"9-seater");

