package com.xinput.cloud.domain.resp;

import java.util.List;

/**
 * 云主机列表
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 17:34
 */
public class DescribeEcsResp {

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

    private List<CloudEcsInfo> ecsInfos;

    public Integer getPage() {
        return page;
    }

    public DescribeEcsResp setPage(Integer page) {
        this.page = page;
        return this;
    }

    public Integer getSize() {
        return size;
    }

    public DescribeEcsResp setSize(Integer size) {
        this.size = size;
        return this;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public DescribeEcsResp setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public DescribeEcsResp setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
        return this;
    }

    public List<CloudEcsInfo> getEcsInfos() {
        return ecsInfos;
    }

    public DescribeEcsResp setEcsInfos(List<CloudEcsInfo> ecsInfos) {
        this.ecsInfos = ecsInfos;
        return this;
    }

    public static class CloudEcsInfo {

        /**
         * 云主机ID
         */
        private String instanceId;

        /**
         * 云主机名称
         */
        private String instanceName;

        /**
         * 主机状态
         */
        private String status;

        /**
         * 主机IP
         */
        private String ip;

        /**
         * 主机所在可见域
         */
        private String zone;

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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getZone() {
            return zone;
        }

        public void setZone(String zone) {
            this.zone = zone;
        }
    }
}
