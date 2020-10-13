package ad.pojo;

import javax.persistence.*;

public class News {
    @Id
    private String id;

    private String title;

    @Column(name = "pic_url")
    private String picUrl;

    /**
     * 发布  0未发布 1已发布
     */
    private Boolean publish;

    /**
     * 删除行  0未删除 1已删除
     */
    @Column(name = "is_deleted")
    private Boolean isDeleted;

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

    private String content;

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
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return pic_url
     */
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * @param picUrl
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    /**
     * 获取发布  0未发布 1已发布
     *
     * @return publish - 发布  0未发布 1已发布
     */
    public Boolean getPublish() {
        return publish;
    }

    /**
     * 设置发布  0未发布 1已发布
     *
     * @param publish 发布  0未发布 1已发布
     */
    public void setPublish(Boolean publish) {
        this.publish = publish;
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
     * @return ts
     */
    public String getTs() {
        return ts;
    }

    /**
     * @param ts
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

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }
}