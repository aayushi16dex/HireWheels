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
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@Column(nullable=false, length=10)
	private int user_id;
	
	@Column(nullable=false, length=50)
	private String first_name;
	
	@Column(nullable=true, length=50)
	private String last_name;
	
	@Column(nullable=false, length=50)
	private String password;
	
	@Column(nullable=false, length=50, unique=true)
	private String email;
	
	@Column(nullable=false, length=10)
	private long mobile_no;
	
	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;
	
	@Column(nullable=false, length=10, unique=true)
	private double wallet_money;
	
	@OneToMany(mappedBy = "user")
	private Set<Booking> bookings;
}

//{
//    "user_id":101,
//    "first_name": "Aayushi",
//    "last_name": "Singh",
//    "password":"aayushi12345",
//    "email":"aayushi123@gmail.com",
//    "mobile_no":7846595138,
//    "wallet_money":10000.00,
//    "role" : {
//        "role_id": 2
//    }
//}
