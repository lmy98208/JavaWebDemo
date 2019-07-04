package com.njnu.demo1.Dao;

import com.njnu.demo1.Bean.Category;

import java.util.List;

public interface ICategoryDao {
     List<Category> findAll();
}
