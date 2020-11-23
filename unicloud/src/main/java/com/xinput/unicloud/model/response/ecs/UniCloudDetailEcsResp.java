package com.xinput.unicloud.model.response.ecs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xinput.unicloud.model.response.UniResponse;

import java.util.List;

/**
 * 查询云主机实例 响应值
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-19 18:13
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UniCloudDetailEcsResp extends UniResponse {

    /**
     * 云主机Id
     */
    private String id;

    /**
     * 云主机名称
     */
    private String name;

    /**
     * 状态: RUNNING运行中
     */
    private String status;

    /**
     * 描述
     */
    private String description;

    /**
     * 使用的密钥对
     */
    private String keyPair;

    /**
     * 开通时间，单位:毫秒
     */
    private Long startTime;

    /**
     * 到期时间, 单位:毫秒
     */
    private Long endTime;

    /**
     * 区域ID
     */
    private String regionId;

    /**
     * 区域名
     */
    private String regionName;

    /**
     * CPU数量(核)
     */
    private Integer cpu;

    /**
     * 内存数量(G)
     */
    private Integer memory;

    /**
     * 系统盘规格
     */
    private String sysDiskCode;

    /**
     * 系统盘大小
     */
    private Integer sysDiskSize;

    /**
     * EIP ID
     */
    private String eipId;

    /**
     * EIP 地址
     */
    private String eipIp;

    /**
     * EIP带宽
     */
    private String bandWidth;

    /**
     * 云主机IP
     */
    private String ip;

    /**
     * 镜像ID
     */
    private String imageId;

    /**
     * 镜像类型
     */
    private String imageType;


    /**
     * 镜像规格
     */
    private String imageCode;

    /**
     * 镜像规格族
     */
    private String imageParentCode;

    /**
     * 主网卡ID
     */
    private String eniId;

    /**
     * 关联数据盘ID
     */
    private List<DataDiskIdsBean> dataDiskIds;

    /**
     * 关联安全组ID
     */
    private List<String> sgIds;

    /**
     * 实例系统
     */
    private String instanceSystem;

    /**
     * 磁盘最大容量
     */
    private Integer maxDisk;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeyPair() {
        return keyPair;
    }

    public void setKeyPair(String keyPair) {
        this.keyPair = keyPair;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Integer getCpu() {
        return cpu;
    }

    public void setCpu(Integer cpu) {
        this.cpu = cpu;
    }

    public Integer getMemory() {
        return memory;
    }

    public void setMemory(Integer memory) {
        this.memory = memory;
    }

    public String getSysDiskCode() {
        return sysDiskCode;
    }

    public void setSysDiskCode(String sysDiskCode) {
        this.sysDiskCode = sysDiskCode;
    }

    public Integer getSysDiskSize() {
        return sysDiskSize;
    }

    public void setSysDiskSize(Integer sysDiskSize) {
        this.sysDiskSize = sysDiskSize;
    }

    public String getEipId() {
        return eipId;
    }

    public void setEipId(String eipId) {
        this.eipId = eipId;
    }

    public String getEipIp() {
        return eipIp;
    }

    public void setEipIp(String eipIp) {
        this.eipIp = eipIp;
    }

    public String getBandWidth() {
        return bandWidth;
    }

    public void setBandWidth(String bandWidth) {
        this.bandWidth = bandWidth;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getImageCode() {
        return imageCode;
    }

    public void setImageCode(String imageCode) {
        this.imageCode = imageCode;
    }

    public String getImageParentCode() {
        return imageParentCode;
    }

    public void setImageParentCode(String imageParentCode) {
        this.imageParentCode = imageParentCode;
    }

    public String getEniId() {
        return eniId;
    }

    public void setEniId(String eniId) {
        this.eniId = eniId;
    }

    public List<DataDiskIdsBean> getDataDiskIds() {
        return dataDiskIds;
    }

    public void setDataDiskIds(List<DataDiskIdsBean> dataDiskIds) {
        this.dataDiskIds = dataDiskIds;
    }

    public List<String> getSgIds() {
        return sgIds;
    }

    public void setSgIds(List<String> sgIds) {
        this.sgIds = sgIds;
    }

    public String getInstanceSystem() {
        return instanceSystem;
    }

    public void setInstanceSystem(String instanceSystem) {
        this.instanceSystem = instanceSystem;
    }

    public Integer getMaxDisk() {
        return maxDisk;
    }

    public void setMaxDisk(Integer maxDisk) {
        this.maxDisk = maxDisk;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DataDiskIdsBean {
    }
}
