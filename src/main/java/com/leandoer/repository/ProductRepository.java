package com.leandoer.repository;

import com.leandoer.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    @Query("select p from Product p join fetch p.manufacturer join fetch p.category")
    List<Product> findAll();

    @Override
    @Query("select p from Product p join fetch p.manufacturer join fetch p.category where p.id =:id")
    Optional<Product> findById(@Param("id") Long id);

}
