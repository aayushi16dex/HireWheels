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
public class Fuel_type {
	@Id
	@Column(length = 10)
	private int fuel_type_id;
	
	@Column(nullable = false, unique = true, length=50)
	private String fuel_type; 
	
	@OneToMany(mappedBy="fuel_type")
	private Set<Vehicle> vehicles;
}

//use hirewheels;
//-- insert into fuel_type values (1,"DIESEL");
//-- insert into fuel_type values (2,"PETROL");
//-- insert into fuel_type values (3,"CNG");