package top.moxingwang.springbootfeature.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @description:
 * @author: MoXingwang 2019-08-01 14:03
 **/
@Entity
@Table(name = "tx_config", schema = "tx_order", catalog = "")
public class TxConfigEntity {
    private long id;
    private String configName;
    private String configDescription;
    private Integer configRank;
    private Integer autoCloseOrderType;
    private Timestamp startTime;
    private Timestamp endTime;
    private Long durationTime;
    private Byte deleteFlag;
    private Timestamp createTime;
    private String createUser;
    private Timestamp updateTime;
    private Timestamp updateUser;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "config_name", nullable = false, length = 100)
    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    @Basic
    @Column(name = "config_description", nullable = true, length = 200)
    public String getConfigDescription() {
        return configDescription;
    }

    public void setConfigDescription(String configDescription) {
        this.configDescription = configDescription;
    }

    @Basic
    @Column(name = "config_rank", nullable = true)
    public Integer getConfigRank() {
        return configRank;
    }

    public void setConfigRank(Integer configRank) {
        this.configRank = configRank;
    }

    @Basic
    @Column(name = "auto_close_order_type", nullable = true)
    public Integer getAutoCloseOrderType() {
        return autoCloseOrderType;
    }

    public void setAutoCloseOrderType(Integer autoCloseOrderType) {
        this.autoCloseOrderType = autoCloseOrderType;
    }

    @Basic
    @Column(name = "start_time", nullable = true)
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "end_time", nullable = true)
    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "duration_time", nullable = true)
    public Long getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(Long durationTime) {
        this.durationTime = durationTime;
    }

    @Basic
    @Column(name = "delete_flag", nullable = true)
    public Byte getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Byte deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Basic
    @Column(name = "create_time", nullable = true)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "create_user", nullable = true, length = 255)
    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Basic
    @Column(name = "update_time", nullable = true)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "update_user", nullable = true)
    public Timestamp getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Timestamp updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TxConfigEntity that = (TxConfigEntity) o;
        return id == that.id &&
                Objects.equals(configName, that.configName) &&
                Objects.equals(configDescription, that.configDescription) &&
                Objects.equals(configRank, that.configRank) &&
                Objects.equals(autoCloseOrderType, that.autoCloseOrderType) &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(endTime, that.endTime) &&
                Objects.equals(durationTime, that.durationTime) &&
                Objects.equals(deleteFlag, that.deleteFlag) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(createUser, that.createUser) &&
                Objects.equals(updateTime, that.updateTime) &&
                Objects.equals(updateUser, that.updateUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, configName, configDescription, configRank, autoCloseOrderType, startTime, endTime, durationTime, deleteFlag, createTime, createUser, updateTime, updateUser);
    }
}
