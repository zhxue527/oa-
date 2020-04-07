package com.jensen.oa.dao;

import com.jensen.oa.entity.DealRecord;

import java.util.List;

/**
 * @PackageName: com.jensen.oa.dao
 * @ClassName: DealRecordDao
 * @Description:
 * @Author: SKY
 * @Data:: 2020/04/06
 */
public interface DealRecordDao {
    void insert(DealRecord dealRecord);
    List<DealRecord> selectByClaimVoucher(int cvid);
}
