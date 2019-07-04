package com.njnu.demo1.Dao.mysql;

import com.njnu.demo1.Bean.Category;
import com.njnu.demo1.Dao.BaseDao;
import com.njnu.demo1.Dao.ICategoryDao;

import java.util.List;

public class MySqlCategoryDao extends BaseDao implements ICategoryDao {
    @Override
    public List<Category> findAll() {
        String sql="select * from category";
        return this.getListBySql(Category.class,sql);
    }
}
