package com.hungry.spring.counter.dao;

public interface CounterDAO {
  void setTotalCount();
  
  int getTotalCount();
  
  int getTodayCount();
}
