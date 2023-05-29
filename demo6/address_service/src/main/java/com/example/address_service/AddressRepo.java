package com.example.address_service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AddressRepo extends JpaRepository<Address,Integer> {
    @Query(value = "select a.id,a.lane1,a.lane2,a.state,a.zip from address as a inner join employee as e on a.employee_id=e.id where a.employee_id=?1",nativeQuery = true)
    Address findAddressByEmployeeId(@Param("id") int employeeId);

}
