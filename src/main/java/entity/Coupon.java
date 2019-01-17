package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author tianqinghua
 * @date 2018/8/8 14:06
 */
public class Coupon {
    @JsonProperty("coupon_type")
    private String couponType;// 优惠券类型
    @JsonProperty("coupon_amt")
    private String couponAmt;// 面值/折扣值
    @JsonProperty("coupon_code")
    private String couponCode;// 优惠券编码
    @JsonProperty("start_date")
    private String startDate;//有效期起
    @JsonProperty("end_date")
    private String endDate;//有效期至
    @JsonProperty("description")
    private String description;//描述

    public String getCouponType() {
        return couponType;
    }

    public void setCouponType(String couponType) {
        this.couponType = couponType;
    }

    public String getCouponAmt() {
        return couponAmt;
    }

    public void setCouponAmt(String couponAmt) {
        this.couponAmt = couponAmt;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
