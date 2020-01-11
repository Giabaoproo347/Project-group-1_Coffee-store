package com.project.coffee.repository;

import com.project.coffee.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetails, String> {
}
