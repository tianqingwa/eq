package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 会员实体类
 *
 * @author tianqinghua
 * @date 2018/8/2 17:15
 */
public class Member {
    @JsonProperty("tenant_id")
    private String tenantId;//商户id
    @JsonProperty("third_member_id")
    private String thirdMemberId;//三方会员id
    @JsonProperty("name")
    private String name;//姓名
    @JsonProperty("sex")
    private String sex;//性别
    @JsonProperty("mobile")
    private String mobile;//手机号
    @JsonProperty("birthday")
    private String birthday;//生日
    @JsonProperty("nickname")
    private String nickname;//昵称
    @JsonProperty("id_number")
    private String idNumber;//证件号码
    @JsonProperty("address")
    private String address;//地址
    @JsonProperty("wechat_id")
    private String wechatId;//微信openid
    @JsonProperty("alipay_id")
    private String alipayId;//支付宝uid
    @JsonProperty("member_level_id")
    private String memberLevelId;//会员等级id
    @JsonProperty("member_level_name")
    private String memberLevelName;//会员等级名称
    @JsonProperty("status")
    private String status;//会员状态：0正常，1停用，2冻结
    @JsonProperty("email")
    private String email;//邮箱
    @JsonProperty("consume_pwd")
    private String consumePwd;//消费密码
    @JsonProperty("channel")
    private String channel;//会员来源
    @JsonProperty("register_store_id")
    private String registerStoreId;//注册门店id
    @JsonProperty("register_date")
    private String registerDate;//注册时间

    @JsonProperty("bala_amt")
    private String balaAmt;//储值金额
    @JsonProperty("capital_amt")
    private String capitalAmt;//储值本金
    @JsonProperty("gift_amt")
    private String giftAmt;//储值赠送金额
    @JsonProperty("total_consume_amount")
    private String totalConsumeAmount;//累计消费金额
    @JsonProperty("last_consume_amount")
    private String lastConsumeAmount;// 上次消费金额
    @JsonProperty("point")
    private String point;// 剩余积分
    @JsonProperty("total_point")
    private String totalPoint;// 累计获得积分
    @JsonProperty("coupon_list")
    private List<Coupon> couponList;//优惠券列表
    @JsonProperty("member_id")
    private String memberId;//会员id

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public List<Coupon> getCouponList() {
        return couponList;
    }

    public void setCouponList(List<Coupon> couponList) {
        this.couponList = couponList;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getThirdMemberId() {
        return thirdMemberId;
    }

    public void setThirdMemberId(String thirdMemberId) {
        this.thirdMemberId = thirdMemberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public String getAlipayId() {
        return alipayId;
    }

    public void setAlipayId(String alipayId) {
        this.alipayId = alipayId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConsumePwd() {
        return consumePwd;
    }

    public void setConsumePwd(String consumePwd) {
        this.consumePwd = consumePwd;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getRegisterStoreId() {
        return registerStoreId;
    }

    public void setRegisterStoreId(String registerStoreId) {
        this.registerStoreId = registerStoreId;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getMemberLevelId() {
        return memberLevelId;
    }

    public void setMemberLevelId(String memberLevelId) {
        this.memberLevelId = memberLevelId;
    }

    public String getMemberLevelName() {
        return memberLevelName;
    }

    public void setMemberLevelName(String memberLevelName) {
        this.memberLevelName = memberLevelName;
    }

    public String getBalaAmt() {
        return balaAmt;
    }

    public void setBalaAmt(String balaAmt) {
        this.balaAmt = balaAmt;
    }

    public String getCapitalAmt() {
        return capitalAmt;
    }

    public void setCapitalAmt(String capitalAmt) {
        this.capitalAmt = capitalAmt;
    }

    public String getGiftAmt() {
        return giftAmt;
    }

    public void setGiftAmt(String giftAmt) {
        this.giftAmt = giftAmt;
    }

    public String getTotalConsumeAmount() {
        return totalConsumeAmount;
    }

    public void setTotalConsumeAmount(String totalConsumeAmount) {
        this.totalConsumeAmount = totalConsumeAmount;
    }

    public String getLastConsumeAmount() {
        return lastConsumeAmount;
    }

    public void setLastConsumeAmount(String lastConsumeAmount) {
        this.lastConsumeAmount = lastConsumeAmount;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(String totalPoint) {
        this.totalPoint = totalPoint;
    }

}
