package com.jensen.oa.service.impl;

import com.jensen.oa.dao.ClaimVoucherDao;
import com.jensen.oa.dao.ClaimVoucherItemDao;
import com.jensen.oa.dao.DealRecordDao;
import com.jensen.oa.dao.EmployeeDao;
import com.jensen.oa.entity.ClaimVoucher;
import com.jensen.oa.entity.ClaimVoucherItem;
import com.jensen.oa.entity.DealRecord;
import com.jensen.oa.entity.Employee;
import com.jensen.oa.global.Content;
import com.jensen.oa.service.ClaimVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @PackageName: com.jensen.oa.service.impl
 * @ClassName: ClaimVoucherServiceImpl
 * @Description:
 * @Author: SKY
 * @Data:: 2020/04/06
 */
@Service("claimVoucherService")
public class ClaimVoucherServiceImpl implements ClaimVoucherService {

    @Autowired
    private ClaimVoucherDao claimVoucherDao;
    @Autowired
    private ClaimVoucherItemDao claimVoucherItemDao;
    @Autowired
    private DealRecordDao dealRecordDao;
    @Autowired
    private EmployeeDao employeeDao;

    public void save(ClaimVoucher claimVoucher, List<ClaimVoucherItem> claimVoucherItems) {
        claimVoucher.setCreateTime(new Date());
        claimVoucher.setNextDealSn(claimVoucher.getCreateSn());
        claimVoucher.setStatus(Content.CLAIM_CREATE);
        claimVoucherDao.insert(claimVoucher);

        for (ClaimVoucherItem item: claimVoucherItems
             ) {
            item.setClaimVoucherId(claimVoucher.getId());
            claimVoucherItemDao.insert(item);
        }
    }

    public ClaimVoucher get(int id) {
        return claimVoucherDao.select(id);
    }

    public List<ClaimVoucherItem> getItems(int cvid) {
        return claimVoucherItemDao.selectByClaimVoucher(cvid);
    }

    public List<DealRecord> getRecords(int cvid) {
        return dealRecordDao.selectByClaimVoucher(cvid);
    }

    public List<ClaimVoucher> getForSelf(String sn) {
        return claimVoucherDao.selectByCreateSn(sn);
    }

    public List<ClaimVoucher> getForDeal(String sn) {
        return claimVoucherDao.selectByNextDealSn(sn);
    }


    public void update(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items) {
        claimVoucher.setNextDealSn(claimVoucher.getCreateSn());
        claimVoucher.setStatus(Content.CLAIM_CREATE);
        claimVoucherDao.update(claimVoucher);

        List<ClaimVoucherItem> olds = claimVoucherItemDao.selectByClaimVoucher(claimVoucher.getId());
        for(ClaimVoucherItem old:olds){
            boolean isHave=false;
            for(ClaimVoucherItem item:items){
                if(item.getId()==old.getId()){
                    isHave=true;
                    break;
                }
            }
            if(!isHave){
                claimVoucherItemDao.delete(old.getId());
            }
        }
        for(ClaimVoucherItem item:items){
            item.setClaimVoucherId(claimVoucher.getId());
            if(item.getId()>0){
                claimVoucherItemDao.update(item);
            }else{
                claimVoucherItemDao.insert(item);
            }
        }
    }

    public void submit(int id) {
        ClaimVoucher claimVoucher = claimVoucherDao.select(id);
        Employee employee = employeeDao.select(claimVoucher.getCreateSn());

        claimVoucher.setStatus(Content.CLAIM_SUBMIT);
        claimVoucher.setNextDealSn(employeeDao.selectByDepartmentAndPost(employee.getDepartmentSn(),Content.POST_FM).get(0).getSn());
        claimVoucherDao.update(claimVoucher);

        DealRecord dealRecord = new DealRecord();
        dealRecord.setDealWay(Content.DEAL_SUBMIT);
        dealRecord.setDealSn(employee.getSn());
        dealRecord.setClaimVoucherId(id);
        dealRecord.setDealResult(Content.CLAIM_SUBMIT);
        dealRecord.setDealTime(new Date());
        dealRecord.setComment("鏃");
        dealRecordDao.insert(dealRecord);
    }

    public void deal(DealRecord dealRecord) {
        ClaimVoucher claimVoucher = claimVoucherDao.select(dealRecord.getClaimVoucherId());
        Employee employee = employeeDao.select(dealRecord.getDealSn());
        dealRecord.setDealTime(new Date());
        System.out.println(dealRecord.getDealWay());
        if(dealRecord.getDealWay().equals(Content.DEAL_PASS)){
            if(claimVoucher.getTotalAmount()<=Content.LIMIT_CHECK || employee.getPost().equals(Content.POST_GM)){
                claimVoucher.setStatus(Content.CLAIM_APPROVED);
                claimVoucher.setNextDealSn(employeeDao.selectByDepartmentAndPost(null,Content.POST_CASHIER).get(0).getSn());
                System.out.println("111111");
                dealRecord.setDealResult(Content.CLAIM_APPROVED);
            }else{
                claimVoucher.setStatus(Content.CLAIM_RECHECK);
                claimVoucher.setNextDealSn(employeeDao.selectByDepartmentAndPost(null,Content.POST_GM).get(0).getSn());
                System.out.println("22222");
                dealRecord.setDealResult(Content.CLAIM_RECHECK);
            }
        }else if(dealRecord.getDealWay().equals(Content.DEAL_BACK)){
            claimVoucher.setStatus(Content.CLAIM_BACK);
            claimVoucher.setNextDealSn(claimVoucher.getCreateSn());
            System.out.println("33333");
            dealRecord.setDealResult(Content.CLAIM_BACK);
        }else if(dealRecord.getDealWay().equals(Content.DEAL_REJECT)){
            claimVoucher.setStatus(Content.CLAIM_TERMINATED);
            claimVoucher.setNextDealSn(null);
            System.out.println("44444");
            dealRecord.setDealResult(Content.CLAIM_TERMINATED);
        }else if(dealRecord.getDealWay().equals(Content.DEAL_PAID)){
            claimVoucher.setStatus(Content.CLAIM_PAID);
            claimVoucher.setNextDealSn(null);
            System.out.println("5555");
            dealRecord.setDealResult(Content.CLAIM_PAID);
        }
        System.out.println("6666");
        claimVoucherDao.update(claimVoucher);
        dealRecordDao.insert(dealRecord);
    }



}
