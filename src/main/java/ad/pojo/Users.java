package ad.pojo;

import java.util.Date;
import javax.persistence.*;

public class Users {
    /**
     * 用户主键ID
     */
    @Id
    private String id;

    /**
     * 微信用户唯一标识
     */
    private String openid;

    /**
     * 电话
     */
    private String tel;

    /**
     * 用户地址
     */
    @Column(name = "user_address")
    private String userAddress;

    /**
     * 昵称（用户名）
     */
    private String nickname;

    /**
     * 性别
     */
    private Boolean gender;

    /**
     * 用户头像地址
     */
    @Column(name = "avatar_url")
    private String avatarUrl;

    /**
     * 用户积分
     */
    private Integer score;

    /**
     * 是否商家
     */
    @Column(name = "sf_company")
    private Boolean sfCompany;

    /**
     * 商家ID
     */
    @Column(name = "company_id")
    private String companyId;

    /**
     * 商家电话
     */
    @Column(name = "company_tel")
    private String companyTel;

    /**
     * 用户状态0禁用1正常
     */
    private Boolean state;

    /**
     * 排序字段
     */
    private Integer sort;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 时间戳
     */
    private Date ts;

    /**
     * 备注
     */
    private String remark;

    /**
     * 获取用户主键ID
     *
     * @return id - 用户主键ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置用户主键ID
     *
     * @param id 用户主键ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取微信用户唯一标识
     *
     * @return openid - 微信用户唯一标识
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 设置微信用户唯一标识
     *
     * @param openid 微信用户唯一标识
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * 获取电话
     *
     * @return tel - 电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置电话
     *
     * @param tel 电话
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取用户地址
     *
     * @return user_address - 用户地址
     */
    public String getUserAddress() {
        return userAddress;
    }

    /**
     * 设置用户地址
     *
     * @param userAddress 用户地址
     */
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    /**
     * 获取昵称（用户名）
     *
     * @return nickname - 昵称（用户名）
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称（用户名）
     *
     * @param nickname 昵称（用户名）
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取性别
     *
     * @return gender - 性别
     */
    public Boolean getGender() {
        return gender;
    }

    /**
     * 设置性别
     *
     * @param gender 性别
     */
    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    /**
     * 获取用户头像地址
     *
     * @return avatar_url - 用户头像地址
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * 设置用户头像地址
     *
     * @param avatarUrl 用户头像地址
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    /**
     * 获取用户积分
     *
     * @return score - 用户积分
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 设置用户积分
     *
     * @param score 用户积分
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 获取是否商家
     *
     * @return sf_company - 是否商家
     */
    public Boolean getSfCompany() {
        return sfCompany;
    }

    /**
     * 设置是否商家
     *
     * @param sfCompany 是否商家
     */
    public void setSfCompany(Boolean sfCompany) {
        this.sfCompany = sfCompany;
    }

    /**
     * 获取商家ID
     *
     * @return company_id - 商家ID
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * 设置商家ID
     *
     * @param companyId 商家ID
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取商家电话
     *
     * @return company_tel - 商家电话
     */
    public String getCompanyTel() {
        return companyTel;
    }

    /**
     * 设置商家电话
     *
     * @param companyTel 商家电话
     */
    public void setCompanyTel(String companyTel) {
        this.companyTel = companyTel;
    }

    /**
     * 获取用户状态0禁用1正常
     *
     * @return state - 用户状态0禁用1正常
     */
    public Boolean getState() {
        return state;
    }

    /**
     * 设置用户状态0禁用1正常
     *
     * @param state 用户状态0禁用1正常
     */
    public void setState(Boolean state) {
        this.state = state;
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
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
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