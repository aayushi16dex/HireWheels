package org.ncu.hirewheels.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Location {
	@Id
	@Column(length = 10)
	private int location_id;
	
	@Column(nullable = false, length=50)
	private String location_name; 
	
	@Column(nullable = false, length=100)
	private String address; 
	
	@Column(nullable = false, length=6)
	private int pincode; 
	
	@ManyToOne
	@JsonIgnoreProperties("locations")
	@JoinColumn(name = "city_id")
	private City city; 
	
	@OneToMany(mappedBy="location",cascade = CascadeType.ALL)
	@JsonIgnoreProperties("location")
	private Set<Vehicle> vehicles;
	
	@OneToMany(mappedBy="location",cascade = CascadeType.ALL)
	@JsonIgnoreProperties("location")
	private Set<Booking> bookings;

	  
	
	/*
	 * use hirewheels;
insert into location values (1,"H-101","Om vihar",122001,1);
insert into location values (2,"82/76","Sector 5",122001,1);
insert into location values (3,"K-101","Sector 23",122001,1);
insert into location values (4,"H-117","Om vihar",122001,1);
insert into location values (5,"G-101","Patel Nagar",122851,2);
insert into location values (6,"K-101","Palam",122851,2);
insert into location values (7,"H-101","South Ex",122851,2);
SELECT * FROM hirewheels.location;
*/
}
