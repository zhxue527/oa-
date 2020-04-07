package com.jensen.oa.dao;

import com.jensen.oa.entity.ClaimVoucher;

import java.util.List;

/**
 * @PackageName: com.jensen.oa.dao
 * @ClassName: ClaimVoucherDao
 * @Description:
 * @Author: SKY
 * @Data:: 2020/04/06
 */
public interface ClaimVoucherDao {
    void insert(ClaimVoucher claimVoucher);
    void update(ClaimVoucher claimVoucher);
    void delete(int id);
    ClaimVoucher select(int id);
    List<ClaimVoucher> selectByNextDealSn(String ndsn);
    List<ClaimVoucher> selectByCreateSn(String csn);
}
