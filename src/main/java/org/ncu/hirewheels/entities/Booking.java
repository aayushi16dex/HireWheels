package org.ncu.hirewheels.entities;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
//@EqualsAndHashCode(exclude = {"location", "vehicle", "user"})
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
	@Id
	@Column(length = 10)
	private int booking_id;
	
	@Column(name="pickup_date", nullable = false)
	private Date pickup_date; 
	
	@Column(name="dropoff_Date",nullable = false)
	private Date dropoff_date; 
	
	@Column(nullable = false)
	private Date booking_date; 
	
	@Column(nullable = false, length=10)
	private double amount; 
	
	@ManyToOne
	@JoinColumn(name = "location_id")
	@JsonIgnoreProperties("bookings")
	private Location location;
	
	@ManyToOne
	@JoinColumn(name = "vehicle_id")
	@JsonIgnoreProperties("bookings")
	private Vehicle vehicle;

	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnoreProperties("bookings")
	private User user;

}

//{
//	"booking_id": 1001,
//	"pickup_date": "2023-11-23" ,
//	"dropoff_date": "2023-11-19" ,
//	"booking_date": "2023-10-11" ,
//	"amount": 1000,
//	"location_id": 1,
//    "user": {
//        "user_id": 101
//    },
//    "vehicle":{
//	    "vehicle_id": 201
//    }	
//}
