package org.ncu.hirewheels.repositories;

import org.ncu.hirewheels.entities.Vehicle_subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleSubCategoryRepository extends JpaRepository<Vehicle_subcategory, Integer> {

}
