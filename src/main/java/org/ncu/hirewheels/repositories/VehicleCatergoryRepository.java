package org.ncu.hirewheels.repositories;

import org.ncu.hirewheels.entities.Vehicle_category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleCatergoryRepository extends JpaRepository<Vehicle_category, Integer> {

}
