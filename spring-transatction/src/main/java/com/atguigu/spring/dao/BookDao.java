package com.atguigu.spring.dao;

public interface BookDao {
    //查询价格
    Integer getPriceByBookId(Integer bookId);
    //更新库存
    void updateStock(Integer bookId);


//    更新余额
    void updateBanlance(Integer userId, Integer price);
}
