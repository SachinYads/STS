package com.example.series.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.series.entity.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

}
