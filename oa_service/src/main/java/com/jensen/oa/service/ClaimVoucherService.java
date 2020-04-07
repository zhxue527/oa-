package com.jensen.oa.service;

import com.jensen.oa.entity.ClaimVoucher;
import com.jensen.oa.entity.ClaimVoucherItem;
import com.jensen.oa.entity.DealRecord;

import java.util.List;

/**
 * @PackageName: com.jensen.oa.service
 * @ClassName: ClaimVoucherService
 * @Description:
 * @Author: SKY
 * @Data:: 2020/04/06
 */
public interface ClaimVoucherService {
    void save(ClaimVoucher claimVoucher, List<ClaimVoucherItem> claimVoucherItems);

    ClaimVoucher get(int id);
    List<ClaimVoucherItem> getItems(int cvid);
    List<DealRecord> getRecords(int cvid);

    List<ClaimVoucher> getForSelf(String sn);
    List<ClaimVoucher> getForDeal(String sn);

    void update(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items);

    void submit(int id);

    void deal(DealRecord dealRecord);
}
