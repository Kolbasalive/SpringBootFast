package com.example.demo;

import org.springframework.data.repository.CrudRepository;

interface CoffeeRepository extends CrudRepository<Coffee, String> {}
