package com.project.coffee.repository;

import com.project.coffee.model.Payments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payments, String> {
}
