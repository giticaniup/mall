package com.kobe.mall.entity;

import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhongchengyong
 */
public class User implements Serializable {

    private static final long serialVersionUID = 5202171371265222369L;

    public User() {
    }

    public User(String openid) {
        this.openid = openid;
    }

    public User(Integer id, String openid) {
        this.id = id;
        this.openid = openid;
    }

    /**
     * User id in alumnus system.
     */
    private Integer id;

    /***
     * Open id in weixin.
     */
    private String openid;

    /**
     * User name. Default is '新校友'
     */
    private String name;

    /**
     * School id, which is defined in school list.
     */
    private Integer schoolId;

    /**
     * The year that user graduate, default is 2015.
     */
    private Short graduateYear;

    /**
     * College.
     */
    private String college;

    /**
     * Major.
     */
    private String major;

    /**
     * Sex. 0 is female, 1 is male, 2 is unknown.
     */
    private Byte sex;

    /**
     * Create time.
     */
    private Date createTime;

    /**
     * Modify time.
     */
    private Date modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public Short getGraduateYear() {
        return graduateYear;
    }

    public void setGraduateYear(Short graduateYear) {
        this.graduateYear = graduateYear;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college == null ? null : college.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("openid", openid)
                .add("name", name)
                .add("schoolId", schoolId)
                .add("graduateYear", graduateYear)
                .add("college", college)
                .add("major", major)
                .add("sex", sex)
                .add("createTime", createTime)
                .add("modifyTime", modifyTime)
                .toString();
    }
}