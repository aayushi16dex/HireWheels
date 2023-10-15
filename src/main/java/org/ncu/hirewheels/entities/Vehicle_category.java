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
public class Vehicle_category {
	@Id
	@Column(length = 10)
	private int vehicle_category_id;
	
	@Column(nullable = false, unique = true, length=50)
	private String vehicle_category_name; 
	
	@OneToMany(mappedBy = "vehicle_category")
	private Set<Vehicle_subcategory> vehicle_subcategories;
}

//use hirewheels;
//-- insert into vehicle_category values (1,"2-wheelers");
//-- insert into vehicle_category values (2,"3-wheelers");
//-- insert into vehicle_category values (3,"4-wheelers");