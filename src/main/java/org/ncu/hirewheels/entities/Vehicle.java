package org.ncu.hirewheels.entities;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

	@Id
	@Column(length=10)
	private int vehicle_id;
	
	@Column(nullable=false, length=50)
	private String vehicle_model;
	
	@Column(nullable=false, length=10)
	private String vehicle_number;
	
	@Column(nullable=false, length=50)
	private String color;
	
	@ManyToOne
	@JoinColumn(name = "vehicle_subcategory_id")
	@JsonIgnoreProperties("vehicles")
	private Vehicle_subcategory vehicleSubcategory;
	
	@ManyToOne
	@JoinColumn(name = "location_id")
	@JsonIgnoreProperties("vehicles")
	private Location location;

	@ManyToOne
	@JoinColumn(name = "fuel_type_id")
	@JsonIgnoreProperties("vehicles")
	private Fuel_type fuel_type; 
	
	@Column(name = "availability_status",nullable=false, length=1)
	private boolean availabilityStatus;
	
	@Column(nullable=false, length=500)
	private String vehicle_image_url;
	
	@JsonIgnoreProperties("vehicle")
	@OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Booking> bookings;
	
}

//{
//	"vehicle_id":201,
//	"vehicle_model":"LX1",
//	"vehicle_number":"HR56AC123",
//	"color":"Red",
//	"vehicleSubcategory":{
//		"vehicle_subcategory_id":3
//	},
//	"location":{
//		"location_id":1
//	},
//	"fuel_type":{
//		"fuel_type_id":2
//	},
//	"availabilityStatus":1,
//	"vehicle_image_url":"img.redcar"
//}
