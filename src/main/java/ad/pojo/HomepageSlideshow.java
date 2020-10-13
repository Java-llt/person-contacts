package ad.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "homepage_slideshow")
public class HomepageSlideshow implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -2362288509351565016L;

	/**
     * 主键ID
     */
    @Id
    private String id;

    /**
     * 公司（客户）ID
     */
    @Column(name = "company_id")
    private String companyId;

    /**
     * 公司（客户）名称
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 轮播图ID
     */
    @Column(name = "img_id")
    private String imgId;

    /**
     * 轮播图地址(路径)
     */
    @Column(name = "img_path")
    private String imgPath;

    /**
     * 轮播图广告费用
     */
    @Column(name = "img_ad_money")
    private BigDecimal imgAdMoney;

    /**
     * 开始时间
     */
    @Column(name = "start_time")
    private Date startTime;

    /**
     * 结束时间
     */
    @Column(name = "end_time")
    private Date endTime;

    /**
     * 排序字段
     */
    private Integer sort;

    /**
     * 0是启用 1是停用
     */
    private Boolean state;

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
     * 获取主键ID
     *
     * @return id - 主键ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置主键ID
     *
     * @param id 主键ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取公司（客户）ID
     *
     * @return company_id - 公司（客户）ID
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * 设置公司（客户）ID
     *
     * @param companyId 公司（客户）ID
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取公司（客户）名称
     *
     * @return company_name - 公司（客户）名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置公司（客户）名称
     *
     * @param companyName 公司（客户）名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 获取轮播图ID
     *
     * @return img_id - 轮播图ID
     */
    public String getImgId() {
        return imgId;
    }

    /**
     * 设置轮播图ID
     *
     * @param imgId 轮播图ID
     */
    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    /**
     * 获取轮播图地址(路径)
     *
     * @return img_path - 轮播图地址(路径)
     */
    public String getImgPath() {
        return imgPath;
    }

    /**
     * 设置轮播图地址(路径)
     *
     * @param imgPath 轮播图地址(路径)
     */
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    /**
     * 获取轮播图广告费用
     *
     * @return img_ad_money - 轮播图广告费用
     */
    public BigDecimal getImgAdMoney() {
        return imgAdMoney;
    }

    /**
     * 设置轮播图广告费用
     *
     * @param imgAdMoney 轮播图广告费用
     */
    public void setImgAdMoney(BigDecimal imgAdMoney) {
        this.imgAdMoney = imgAdMoney;
    }

    /**
     * 获取开始时间
     *
     * @return start_time - 开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置开始时间
     *
     * @param startTime 开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取结束时间
     *
     * @return end_time - 结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置结束时间
     *
     * @param endTime 结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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
     * 获取0是启用 1是停用
     *
     * @return state - 0是启用 1是停用
     */
    public Boolean getState() {
        return state;
    }

    /**
     * 设置0是启用 1是停用
     *
     * @param state 0是启用 1是停用
     */
    public void setState(Boolean state) {
        this.state = state;
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
}