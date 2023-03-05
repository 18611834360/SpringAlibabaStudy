package com.tulingxueyuan.order.mapper;

import com.tulingxueyuan.order.pojo.StockInfo;
import com.tulingxueyuan.order.pojo.StockInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockInfoMapper {
    long countByExample(StockInfoExample example);

    int deleteByExample(StockInfoExample example);


    int deleteByPrimaryKey(Integer goodsId);

    int insert(StockInfo record);

    int insertSelective(StockInfo record);

    List<StockInfo> selectByExample(StockInfoExample example);

    StockInfo selectByPrimaryKey(Integer goodsId);

    int updateByExampleSelective(@Param("record") StockInfo record, @Param("example") StockInfoExample example);

    int updateByExample(@Param("record") StockInfo record, @Param("example") StockInfoExample example);

    int updateByPrimaryKeySelective(StockInfo record);

    int updateByPrimaryKey(StockInfo record);
}