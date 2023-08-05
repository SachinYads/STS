package com.example.series.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.series.entity.Office;

public interface OfficeRepository extends CrudRepository<Office, Long> {

}
