package ad.pojo;

import java.util.Date;
import javax.persistence.*;

public class Company {
    /**
     * 公司主键ID
     */
    @Id
    @Column(name = "company_id")
    private String companyId;

    /**
     * 公司名称
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 公司地址
     */
    @Column(name = "company_address")
    private String companyAddress;

    /**
     * 公司电话
     */
    @Column(name = "company_tel")
    private String companyTel;

    /**
     * 电话拨打次数
     */
    @Column(name = "tel_call_num")
    private Integer telCallNum;

    /**
     * 主营业务
     */
    @Column(name = "primary_business")
    private String primaryBusiness;

    @Column(name = "primary_business_code")
    private String primaryBusinessCode;

    /**
     * 兼营业务
     */
    @Column(name = "sideline_business")
    private String sidelineBusiness;

    @Column(name = "sideline_business_code")
    private String sidelineBusinessCode;

    /**
     * 公司详情
     */
    @Column(name = "company_detail")
    private String companyDetail;

    /**
     * 公司星级 0 1 2 3 4 5
     */
    @Column(name = "star_level")
    private Integer starLevel;

    /**
     * 排序字段
     */
    private Integer sort;

    /**
     * 1是启用 0是停用
     */
    @Column(name = "is_using")
    private Boolean isUsing;

    /**
     * 停用原因（如：未续费）
     */
    @Column(name = "stop_reason")
    private String stopReason;

    /**
     * 创建人ID
     */
    @Column(name = "create_user_id")
    private String createUserId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改人ID
     */
    @Column(name = "update_user_id")
    private String updateUserId;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 时间戳
     */
    private Date ts;

    /**
     * 删除行  0未删除 1已删除
     */
    @Column(name = "is_deleted")
    private Boolean isDeleted;

    /**
     * 备注
     */
    private String remark;

    /**
     * 预留字段1
     */
    private String reserve1;

    /**
     * 预留字段2
     */
    private String reserve2;

    /**
     * 预留字段3
     */
    private String reserve3;

    /**
     * 预留字段4
     */
    private String reserve4;

    /**
     * 首页轮播图地址
     */
    @Column(name = "homepage_slideshow")
    private String homepageSlideshow;

    /**
     * 列表小图
     */
    @Column(name = "list_mini_pic")
    private String listMiniPic;

    /**
     * 获取公司主键ID
     *
     * @return company_id - 公司主键ID
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * 设置公司主键ID
     *
     * @param companyId 公司主键ID
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取公司名称
     *
     * @return company_name - 公司名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置公司名称
     *
     * @param companyName 公司名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 获取公司地址
     *
     * @return company_address - 公司地址
     */
    public String getCompanyAddress() {
        return companyAddress;
    }

    /**
     * 设置公司地址
     *
     * @param companyAddress 公司地址
     */
    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    /**
     * 获取公司电话
     *
     * @return company_tel - 公司电话
     */
    public String getCompanyTel() {
        return companyTel;
    }

    /**
     * 设置公司电话
     *
     * @param companyTel 公司电话
     */
    public void setCompanyTel(String companyTel) {
        this.companyTel = companyTel;
    }

    /**
     * 获取电话拨打次数
     *
     * @return tel_call_num - 电话拨打次数
     */
    public Integer getTelCallNum() {
        return telCallNum;
    }

    /**
     * 设置电话拨打次数
     *
     * @param telCallNum 电话拨打次数
     */
    public void setTelCallNum(Integer telCallNum) {
        this.telCallNum = telCallNum;
    }

    /**
     * 获取主营业务
     *
     * @return primary_business - 主营业务
     */
    public String getPrimaryBusiness() {
        return primaryBusiness;
    }

    /**
     * 设置主营业务
     *
     * @param primaryBusiness 主营业务
     */
    public void setPrimaryBusiness(String primaryBusiness) {
        this.primaryBusiness = primaryBusiness;
    }

    /**
     * @return primary_business_code
     */
    public String getPrimaryBusinessCode() {
        return primaryBusinessCode;
    }

    /**
     * @param primaryBusinessCode
     */
    public void setPrimaryBusinessCode(String primaryBusinessCode) {
        this.primaryBusinessCode = primaryBusinessCode;
    }

    /**
     * 获取兼营业务
     *
     * @return sideline_business - 兼营业务
     */
    public String getSidelineBusiness() {
        return sidelineBusiness;
    }

    /**
     * 设置兼营业务
     *
     * @param sidelineBusiness 兼营业务
     */
    public void setSidelineBusiness(String sidelineBusiness) {
        this.sidelineBusiness = sidelineBusiness;
    }

    /**
     * @return sideline_business_code
     */
    public String getSidelineBusinessCode() {
        return sidelineBusinessCode;
    }

    /**
     * @param sidelineBusinessCode
     */
    public void setSidelineBusinessCode(String sidelineBusinessCode) {
        this.sidelineBusinessCode = sidelineBusinessCode;
    }

    /**
     * 获取公司详情
     *
     * @return company_detail - 公司详情
     */
    public String getCompanyDetail() {
        return companyDetail;
    }

    /**
     * 设置公司详情
     *
     * @param companyDetail 公司详情
     */
    public void setCompanyDetail(String companyDetail) {
        this.companyDetail = companyDetail;
    }

    /**
     * 获取公司星级 0 1 2 3 4 5
     *
     * @return star_level - 公司星级 0 1 2 3 4 5
     */
    public Integer getStarLevel() {
        return starLevel;
    }

    /**
     * 设置公司星级 0 1 2 3 4 5
     *
     * @param starLevel 公司星级 0 1 2 3 4 5
     */
    public void setStarLevel(Integer starLevel) {
        this.starLevel = starLevel;
    }

    /**
     * 获取排序字段
     *
     * @return sort - 排序字段
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序字段
     *
     * @param sort 排序字段
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取1是启用 0是停用
     *
     * @return is_using - 1是启用 0是停用
     */
    public Boolean getIsUsing() {
        return isUsing;
    }

    /**
     * 设置1是启用 0是停用
     *
     * @param isUsing 1是启用 0是停用
     */
    public void setIsUsing(Boolean isUsing) {
        this.isUsing = isUsing;
    }

    /**
     * 获取停用原因（如：未续费）
     *
     * @return stop_reason - 停用原因（如：未续费）
     */
    public String getStopReason() {
        return stopReason;
    }

    /**
     * 设置停用原因（如：未续费）
     *
     * @param stopReason 停用原因（如：未续费）
     */
    public void setStopReason(String stopReason) {
        this.stopReason = stopReason;
    }

    /**
     * 获取创建人ID
     *
     * @return create_user_id - 创建人ID
     */
    public String getCreateUserId() {
        return createUserId;
    }

    /**
     * 设置创建人ID
     *
     * @param createUserId 创建人ID
     */
    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改人ID
     *
     * @return update_user_id - 修改人ID
     */
    public String getUpdateUserId() {
        return updateUserId;
    }

    /**
     * 设置修改人ID
     *
     * @param updateUserId 修改人ID
     */
    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取时间戳
     *
     * @return ts - 时间戳
     */
    public Date getTs() {
        return ts;
    }

    /**
     * 设置时间戳
     *
     * @param ts 时间戳
     */
    public void setTs(Date ts) {
        this.ts = ts;
    }

    /**
     * 获取删除行  0未删除 1已删除
     *
     * @return is_deleted - 删除行  0未删除 1已删除
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * 设置删除行  0未删除 1已删除
     *
     * @param isDeleted 删除行  0未删除 1已删除
     */
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取预留字段1
     *
     * @return reserve1 - 预留字段1
     */
    public String getReserve1() {
        return reserve1;
    }

    /**
     * 设置预留字段1
     *
     * @param reserve1 预留字段1
     */
    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1;
    }

    /**
     * 获取预留字段2
     *
     * @return reserve2 - 预留字段2
     */
    public String getReserve2() {
        return reserve2;
    }

    /**
     * 设置预留字段2
     *
     * @param reserve2 预留字段2
     */
    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2;
    }

    /**
     * 获取预留字段3
     *
     * @return reserve3 - 预留字段3
     */
    public String getReserve3() {
        return reserve3;
    }

    /**
     * 设置预留字段3
     *
     * @param reserve3 预留字段3
     */
    public void setReserve3(String reserve3) {
        this.reserve3 = reserve3;
    }

    /**
     * 获取预留字段4
     *
     * @return reserve4 - 预留字段4
     */
    public String getReserve4() {
        return reserve4;
    }

    /**
     * 设置预留字段4
     *
     * @param reserve4 预留字段4
     */
    public void setReserve4(String reserve4) {
        this.reserve4 = reserve4;
    }

    /**
     * 获取首页轮播图地址
     *
     * @return homepage_slideshow - 首页轮播图地址
     */
    public String getHomepageSlideshow() {
        return homepageSlideshow;
    }

    /**
     * 设置首页轮播图地址
     *
     * @param homepageSlideshow 首页轮播图地址
     */
    public void setHomepageSlideshow(String homepageSlideshow) {
        this.homepageSlideshow = homepageSlideshow;
    }

    /**
     * 获取列表小图
     *
     * @return list_mini_pic - 列表小图
     */
    public String getListMiniPic() {
        return listMiniPic;
    }

    /**
     * 设置列表小图
     *
     * @param listMiniPic 列表小图
     */
    public void setListMiniPic(String listMiniPic) {
        this.listMiniPic = listMiniPic;
    }
}