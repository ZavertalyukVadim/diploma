package com.deploma.service;

import com.deploma.dao.TestDao;
import com.deploma.entity.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    private final TestDao testDao;

    @Autowired
    public TestService(TestDao testDao) {
        this.testDao = testDao;
    }

    public List<TestEntity> getTestData() {
        testData();
        return testDao.findAll();
    }
    private void testData(){
        TestEntity testEntity = new TestEntity();
        testEntity.setName("lol");
        testDao.save(testEntity);
    }
}
