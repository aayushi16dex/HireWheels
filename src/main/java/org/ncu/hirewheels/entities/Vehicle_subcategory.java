package org.ncu.hirewheels.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
//@EqualsAndHashCode(exclude = {"vehicle_category", "vehicles"} )
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle_subcategory {
	
	@Id
	@Column(nullable=false, length=10)
	private int vehicle_subcategory_id;
	
	@Column(nullable=false, length=50, unique=true)
	private String vehicle_subcategory_name;
	
	@Column(nullable=false, length=10)
	private double price_per_day;
	
	@ManyToOne
	@JoinColumn(name = "vehicle_category_id")
	private Vehicle_category vehicle_category;
	
	
	@OneToMany(mappedBy = "vehicleSubcategory")
	private Set<Vehicle> vehicles;
	
}

//use hirewheels;
//-- insert into vehicle_subcategory values (1,600.00,1,"2-seater");
//-- insert into vehicle_subcategory values (2,1500.00,2,"3-seater");
//-- insert into vehicle_subcategory values (3,2500.00,3,"5-seater");
//-- insert into vehicle_subcategory values (4,4000.00,3,"7-seater");
//-- insert into vehicle_subcategory values (5,5500.00,3,"9-seater");
