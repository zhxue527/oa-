package com.jensen.oa.dto;

import com.jensen.oa.entity.ClaimVoucher;
import com.jensen.oa.entity.ClaimVoucherItem;

import java.util.List;

/**
 * @PackageName: com.jensen.oa.dto
 * @ClassName: ClaimVoucherInfo
 * @Description:
 * @Author: SKY
 * @Data:: 2020/04/06
 */
public class ClaimVoucherInfo {
    private ClaimVoucher claimVoucher;
    private List<ClaimVoucherItem> items;

    public ClaimVoucher getClaimVoucher() {
        return claimVoucher;
    }

    public void setClaimVoucher(ClaimVoucher claimVoucher) {
        this.claimVoucher = claimVoucher;
    }

    public List<ClaimVoucherItem> getItems() {
        return items;
    }

    public void setItems(List<ClaimVoucherItem> items) {
        this.items = items;
    }
}
