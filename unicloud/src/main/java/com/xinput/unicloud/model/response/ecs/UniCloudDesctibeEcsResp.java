package com.xinput.unicloud.model.response.ecs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.xinput.unicloud.model.response.UniResponse;

import java.util.List;

/**
 * 云主机实例列表 响应值
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 17:36
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UniCloudDesctibeEcsResp extends UniResponse {

    /**
     * 请求page
     */
    private Integer page;

    /**
     * 请求size
     */
    private Integer size;

    /**
     * 总条数
     */
    private Integer totalCount;

    /**
     * 总页数
     */
    private Integer totalPages;

    @JsonProperty(value = "list")
    private List<UniCloudEcsInfo> uniCloudEcsInfos;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<UniCloudEcsInfo> getUniCloudEcsInfos() {
        return uniCloudEcsInfos;
    }

    public void setUniCloudEcsInfos(List<UniCloudEcsInfo> uniCloudEcsInfos) {
        this.uniCloudEcsInfos = uniCloudEcsInfos;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class UniCloudEcsInfo {

        /**
         * 云主机ID
         */
        private String instanceId;

        /**
         * 云主机名称
         */
        private String instanceName;

        /**
         * 规格编码
         */
        private String instanceCode;

        /**
         * 规格描述
         */
        private String instanceCodeName;

        /**
         * 主机状态
         */
        private String status;

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
         * 镜像规格族编码
         */
        private String imageParentCode;

        /**
         * 主机描述
         */
        private String description;

        /**
         * 主机IP
         */
        private String ip;

        /**
         * EIP-ID
         */
        private String eipId;

        /**
         *
         */
        private String eipAddr;

        /**
         * EIP带宽
         */
        private String eipSize;

        /**
         * EIP规格
         */
        private String eipCode;

        /**
         * 系统盘大小
         */
        private Integer sysDiskSize;

        /**
         * 系统盘规格
         */
        private String sysDiskCode;

        /**
         * 主机开通时间
         */
        private Long startTime;

        /**
         * 主机到期时间
         */
        private Long endTime;

        /**
         * 已绑定硬盘数量
         */
        private Integer bindDiskCount;

        /**
         * 主机主网卡ID
         */
        private String eniId;

        /**
         * 辅助网卡ID(目前只支持绑定一块辅助网卡)
         */
        private String secondaryEni;

        /**
         * 主机所在可见域
         */
        private String azoneId;

        /**
         * 计费方式
         */
        private String payType;

        public String getInstanceId() {
            return instanceId;
        }

        public void setInstanceId(String instanceId) {
            this.instanceId = instanceId;
        }

        public String getInstanceName() {
            return instanceName;
        }

        public void setInstanceName(String instanceName) {
            this.instanceName = instanceName;
        }

        public String getInstanceCode() {
            return instanceCode;
        }

        public void setInstanceCode(String instanceCode) {
            this.instanceCode = instanceCode;
        }

        public String getInstanceCodeName() {
            return instanceCodeName;
        }

        public void setInstanceCodeName(String instanceCodeName) {
            this.instanceCodeName = instanceCodeName;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
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

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getEipId() {
            return eipId;
        }

        public void setEipId(String eipId) {
            this.eipId = eipId;
        }

        public String getEipAddr() {
            return eipAddr;
        }

        public void setEipAddr(String eipAddr) {
            this.eipAddr = eipAddr;
        }

        public String getEipSize() {
            return eipSize;
        }

        public void setEipSize(String eipSize) {
            this.eipSize = eipSize;
        }

        public String getEipCode() {
            return eipCode;
        }

        public void setEipCode(String eipCode) {
            this.eipCode = eipCode;
        }

        public Integer getSysDiskSize() {
            return sysDiskSize;
        }

        public void setSysDiskSize(Integer sysDiskSize) {
            this.sysDiskSize = sysDiskSize;
        }

        public String getSysDiskCode() {
            return sysDiskCode;
        }

        public void setSysDiskCode(String sysDiskCode) {
            this.sysDiskCode = sysDiskCode;
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

        public Integer getBindDiskCount() {
            return bindDiskCount;
        }

        public void setBindDiskCount(Integer bindDiskCount) {
            this.bindDiskCount = bindDiskCount;
        }

        public String getEniId() {
            return eniId;
        }

        public void setEniId(String eniId) {
            this.eniId = eniId;
        }

        public String getSecondaryEni() {
            return secondaryEni;
        }

        public void setSecondaryEni(String secondaryEni) {
            this.secondaryEni = secondaryEni;
        }

        public String getAzoneId() {
            return azoneId;
        }

        public void setAzoneId(String azoneId) {
            this.azoneId = azoneId;
        }

        public String getPayType() {
            return payType;
        }

        public void setPayType(String payType) {
            this.payType = payType;
        }
    }
}
