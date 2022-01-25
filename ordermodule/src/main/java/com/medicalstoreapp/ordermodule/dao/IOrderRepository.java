package com.medicalstoreapp.ordermodule.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medicalstoreapp.ordermodule.entities.CreatedOrder;

@Repository
public interface IOrderRepository extends JpaRepository<CreatedOrder,Long>{

	@Query("FROM CreatedOrder where orderDate between :startDate and :endDate")
	List<CreatedOrder> findInPeriod(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
