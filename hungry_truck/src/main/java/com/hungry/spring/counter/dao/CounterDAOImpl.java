package com.hungry.spring.counter.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CounterDAOImpl implements CounterDAO {
  @Autowired
  private SqlSession sqlSession;
  
  public void setTotalCount() {
    this.sqlSession.insert("insert_count");
  }
  
  public int getTotalCount() {
    return ((Integer)this.sqlSession.selectOne("tot_count")).intValue();
  }
  
  public int getTodayCount() {
    return ((Integer)this.sqlSession.selectOne("today_count")).intValue();
  }
}
