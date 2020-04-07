package com.jensen.oa.dao;

import com.jensen.oa.entity.ClaimVoucherItem;

import java.util.List;

/**
 * @PackageName: com.jensen.oa.dao
 * @ClassName: ClaimVoucherItemDao
 * @Description:
 * @Author: SKY
 * @Data:: 2020/04/06
 */
public interface ClaimVoucherItemDao {
    void insert(ClaimVoucherItem claimVoucherItem);
    void update(ClaimVoucherItem claimVoucherItem);
    void delete(int id);
    List<ClaimVoucherItem> selectByClaimVoucher(int cvid);
}
