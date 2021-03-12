package com.hungry.spring.counter.service;

import com.hungry.spring.counter.dao.CounterDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CounterServiceImpl implements CounterService {
  @Autowired
  CounterDAO counterDao;
  
  public void setTotalCount() {
    this.counterDao.setTotalCount();
  }
  
  public int getTotalCount() {
    return this.counterDao.getTotalCount();
  }
  
  public int getTodayCount() {
    return this.counterDao.getTodayCount();
  }
}
