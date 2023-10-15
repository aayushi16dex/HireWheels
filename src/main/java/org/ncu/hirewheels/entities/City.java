package org.ncu.hirewheels.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {
	@Id
	@Column(length = 10)
	private int city_id;
	
	@Column(nullable = false, length=50)
	private String city_name; 
	
	@OneToMany(mappedBy = "city")
	private Set<Location> locations;
	
}

/*
 * 	use hirewheels;
//	insert into city values (1,"Gurugram");
//	insert into city values (2,"Delhi");
//	insert into city values (3,"Rohtak");
//	insert into city values (4,"Karnal");
//	insert into city values (5,"Sonipat");
//	insert into city values (6,"Hisar");
//	insert into city values (7,"Noida");
//	insert into city values (8,"Greater Noida");
//	insert into city values (9,"Faridabad");
//	insert into city values (10,"Gaziabad"); */
