package com.jensen.oa.global;

import java.util.ArrayList;
import java.util.List;

/**
 * @PackageName: com.jensen.oa.global
 * @ClassName: Content
 * @Description:
 * @Author: SKY
 * @Data:: 2020/04/06
 */
public class Content {
    //职务
    public static final String POST_STAFF = "员工";
    public static final String POST_FM = "部门经理";
    public static final String POST_GM = "总经理";
    public static final String POST_CASHIER = "财务";

    //报销单状态
    public static final String  CLAIM_CREATE = "新创建";
    public static final String  CLAIM_SUBMIT = "已提交";
    public static final String  CLAIM_APPROVED = "已审核";
    public static final String  CLAIM_BACK = "已打回";
    public static final String  CLAIM_TERMINATED = "已终止";
    public static final String  CLAIM_RECHECK = "待复审";
    public static final String  CLAIM_PAID = "已打款";

    //审核额度
    public static final double LIMIT_CHECK = 5000.00;

    //处理方式
    public static final String DEAL_CREATE = "创建报销单";
    public static final String DEAL_SUBMIT = "提交";
    public static final String DEAL_UPDATE = "修改";
    public static final String DEAL_BACK = "打回";
    public static final String DEAL_REJECT = "拒绝";
    public static final String DEAL_PASS = "通过";
    public static final String DEAL_PAID = "打款";

    public static List<String> getPosts() {
        List<String> list = new ArrayList<String>();
        list.add(POST_STAFF);
        list.add(POST_FM);
        list.add(POST_GM);
        list.add(POST_CASHIER);
        return list;
    }

    //费用类别
    public static List<String> getItems() {
        List<String> list = new ArrayList<String>();
        list.add("交通");
        list.add("餐饮");
        list.add("住宿");
        list.add("办公");
        return list;
    }

}
