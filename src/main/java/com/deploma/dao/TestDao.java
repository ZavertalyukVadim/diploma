package com.deploma.dao;

import com.deploma.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestDao extends JpaRepository<TestEntity,Integer>{
}
