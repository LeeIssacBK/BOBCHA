package com.hungry.spring.counter.service;

public interface CounterService {
  void setTotalCount();
  
  int getTotalCount();
  
  int getTodayCount();
}
