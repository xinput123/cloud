package com.xinput.cloud.domain.resp;

/**
 * 查询云主机实例 响应值
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-19 19:23
 */
public class DetailEcsResp {

    private String requestId;

    /**
     * 云主机ID
     */
    private String instanceId;

    /**
     * 云主机名称
     */
    private String instanceName;

    /**
     * 云主机状态
     */
    private String status;

    /**
     * 云主机区域
     */
    private String regionId;

    /**
     * 云主机区域名称
     */
    private String regionName;

    /**
     * 云主机IP
     */
    private String ip;

    public String getRequestId() {
        return requestId;
    }

    public DetailEcsResp setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public DetailEcsResp setInstanceId(String instanceId) {
        this.instanceId = instanceId;
        return this;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public DetailEcsResp setInstanceName(String instanceName) {
        this.instanceName = instanceName;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public DetailEcsResp setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getRegionId() {
        return regionId;
    }

    public DetailEcsResp setRegionId(String regionId) {
        this.regionId = regionId;
        return this;
    }

    public String getRegionName() {
        return regionName;
    }

    public DetailEcsResp setRegionName(String regionName) {
        this.regionName = regionName;
        return this;
    }

    public String getIp() {
        return ip;
    }

    public DetailEcsResp setIp(String ip) {
        this.ip = ip;
        return this;
    }
}
