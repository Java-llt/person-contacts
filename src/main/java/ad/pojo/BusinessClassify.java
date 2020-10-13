package ad.pojo;

import javax.persistence.*;

@Table(name = "business_classify")
public class BusinessClassify {
    @Id
    private String id;

    private String pname;

    private String name;

    private String pcode;

    private String code;

    private String icon;

    /**
     * 拼音首字母
     */
    private String pinyin;

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
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return pname
     */
    public String getPname() {
        return pname;
    }

    /**
     * @param pname
     */
    public void setPname(String pname) {
        this.pname = pname;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return pcode
     */
    public String getPcode() {
        return pcode;
    }

    /**
     * @param pcode
     */
    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    /**
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取拼音首字母
     *
     * @return pinyin - 拼音首字母
     */
    public String getPinyin() {
        return pinyin;
    }

    /**
     * 设置拼音首字母
     *
     * @param pinyin 拼音首字母
     */
    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
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