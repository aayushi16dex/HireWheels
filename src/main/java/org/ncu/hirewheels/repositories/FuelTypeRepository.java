package org.ncu.hirewheels.repositories;
import org.ncu.hirewheels.entities.Fuel_type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelTypeRepository extends JpaRepository<Fuel_type, Integer>{

}
