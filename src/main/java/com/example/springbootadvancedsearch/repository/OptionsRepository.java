package com.example.springbootadvancedsearch.repository;

import com.example.springbootadvancedsearch.model.Active;
import com.example.springbootadvancedsearch.model.Options;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionsRepository extends JpaRepository<Options, Long>, JpaSpecificationExecutor<Options> {
}
