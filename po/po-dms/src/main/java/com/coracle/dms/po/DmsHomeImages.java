/**
 * create by Administrator
 * @date 2017-08
 */
package com.coracle.dms.po;

import com.coracle.yk.base.po.AdapterEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
@ApiModel(description = "DMS图片集合表")
public class DmsHomeImages extends AdapterEntity implements Serializable {
    @ApiModelProperty("主键ID")
    private Long id;
    @ApiModelProperty("附件id")
    private Long attachId;
    @ApiModelProperty("附件名称")
    private String attachName;
    @ApiModelProperty("链接地址")
    private String linkUrl;
    @ApiModelProperty("排序")
    private Long sort;

    private Long createdBy;

    private Date createdDate;

    private Long lastUpdatedBy;

    private Date lastUpdatedDate;
    @ApiModelProperty("软删除标识（0：未删除，1已删除）")
    private Integer removeFlag;
    @ApiModelProperty("图片类型（0首页banner图）")
    private Integer imageType;

    private String expand1;

    private String expand2;

    private String expand3;

    private String expand4;

    private String expand5;

    private String expand6;

    private String expand7;

    private String expand8;

    private String expand9;

    private String expand10;

    private String expand11;

    private String expand12;

    private String expand13;

    private String expand14;

    private String expand15;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAttachId() {
        return attachId;
    }

    public void setAttachId(Long attachId) {
        this.attachId = attachId;
    }

    public String getAttachName() {
        return attachName;
    }

    public void setAttachName(String attachName) {
        this.attachName = attachName;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl == null ? null : linkUrl.trim();
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public Integer getRemoveFlag() {
        return removeFlag;
    }

    public void setRemoveFlag(Integer removeFlag) {
        this.removeFlag = removeFlag;
    }

    public Integer getImageType() {
        return imageType;
    }

    public void setImageType(Integer imageType) {
        this.imageType = imageType;
    }

    public String getExpand1() {
        return expand1;
    }

    public void setExpand1(String expand1) {
        this.expand1 = expand1 == null ? null : expand1.trim();
    }

    public String getExpand2() {
        return expand2;
    }

    public void setExpand2(String expand2) {
        this.expand2 = expand2 == null ? null : expand2.trim();
    }

    public String getExpand3() {
        return expand3;
    }

    public void setExpand3(String expand3) {
        this.expand3 = expand3 == null ? null : expand3.trim();
    }

    public String getExpand4() {
        return expand4;
    }

    public void setExpand4(String expand4) {
        this.expand4 = expand4 == null ? null : expand4.trim();
    }

    public String getExpand5() {
        return expand5;
    }

    public void setExpand5(String expand5) {
        this.expand5 = expand5 == null ? null : expand5.trim();
    }

    public String getExpand6() {
        return expand6;
    }

    public void setExpand6(String expand6) {
        this.expand6 = expand6 == null ? null : expand6.trim();
    }

    public String getExpand7() {
        return expand7;
    }

    public void setExpand7(String expand7) {
        this.expand7 = expand7 == null ? null : expand7.trim();
    }

    public String getExpand8() {
        return expand8;
    }

    public void setExpand8(String expand8) {
        this.expand8 = expand8 == null ? null : expand8.trim();
    }

    public String getExpand9() {
        return expand9;
    }

    public void setExpand9(String expand9) {
        this.expand9 = expand9 == null ? null : expand9.trim();
    }

    public String getExpand10() {
        return expand10;
    }

    public void setExpand10(String expand10) {
        this.expand10 = expand10 == null ? null : expand10.trim();
    }

    public String getExpand11() {
        return expand11;
    }

    public void setExpand11(String expand11) {
        this.expand11 = expand11 == null ? null : expand11.trim();
    }

    public String getExpand12() {
        return expand12;
    }

    public void setExpand12(String expand12) {
        this.expand12 = expand12 == null ? null : expand12.trim();
    }

    public String getExpand13() {
        return expand13;
    }

    public void setExpand13(String expand13) {
        this.expand13 = expand13 == null ? null : expand13.trim();
    }

    public String getExpand14() {
        return expand14;
    }

    public void setExpand14(String expand14) {
        this.expand14 = expand14 == null ? null : expand14.trim();
    }

    public String getExpand15() {
        return expand15;
    }

    public void setExpand15(String expand15) {
        this.expand15 = expand15 == null ? null : expand15.trim();
    }
}