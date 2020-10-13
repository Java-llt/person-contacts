package ad.pojo;

import javax.persistence.*;

@Table(name = "tel_call_record")
public class TelCallRecord {
    /**
     * 主键
     */
    @Id
    private String id;

    /**
     * 微信用户唯一id
     */
    private String openid;

    /**
     * 客户id
     */
    @Column(name = "company_id")
    private String companyId;

    /**
     * 客户名称
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 客户电话
     */
    private String tel;

    /**
     * 时间戳
     */
    private String ts;

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
     * 获取主键
     *
     * @return id - 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取微信用户唯一id
     *
     * @return openid - 微信用户唯一id
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 设置微信用户唯一id
     *
     * @param openid 微信用户唯一id
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * 获取客户id
     *
     * @return company_id - 客户id
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * 设置客户id
     *
     * @param companyId 客户id
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取客户名称
     *
     * @return company_name - 客户名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置客户名称
     *
     * @param companyName 客户名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 获取客户电话
     *
     * @return tel - 客户电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置客户电话
     *
     * @param tel 客户电话
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取时间戳
     *
     * @return ts - 时间戳
     */
    public String getTs() {
        return ts;
    }

    /**
     * 设置时间戳
     *
     * @param ts 时间戳
     */
    public void setTs(String ts) {
        this.ts = ts;
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
}