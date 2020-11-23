package com.xinput.cloud.domain.req;

import com.xinput.cloud.consts.CloudConsts;

/**
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-19 15:32
 */
public class DescribeEcsReq {

    /**
     * 类型：String
     * 描述：区域Id {@link com.xinput.cloud.consts.CloudConsts.Region}
     * 适用云: {@link com.xinput.cloud.consts.CloudConsts.CloudEnum #UniCloud}
     */
    private CloudConsts.Region region;

    /**
     * 类型：int
     * 描述：页码，默认1
     * 适用云: {@link com.xinput.cloud.consts.CloudConsts.CloudEnum #UniCloud}
     */
    private Integer page;

    /**
     * 类型：int
     * 描述：列表容量，默认10
     * 适用云: {@link com.xinput.cloud.consts.CloudConsts.CloudEnum #UniCloud}
     */
    private Integer size;

    /**
     * 类型：string
     * 描述：云主机ID
     * 适用云: {@link com.xinput.cloud.consts.CloudConsts.CloudEnum #UniCloud}
     */
    private String instanceId;

    /**
     * 类型：string
     * 描述：云主机名称
     * 适用云: {@link com.xinput.cloud.consts.CloudConsts.CloudEnum #UniCloud}
     */
    private String instanceName;

    /**
     * 类型：string
     * 描述：云主机IP地址
     * 适用云: {@link com.xinput.cloud.consts.CloudConsts.CloudEnum #UniCloud}
     */
    private String ipAddr;

    public CloudConsts.Region getRegion() {
        return region;
    }

    public DescribeEcsReq setRegion(CloudConsts.Region region) {
        this.region = region;
        return this;
    }

    public Integer getPage() {
        return page;
    }

    public DescribeEcsReq setPage(Integer page) {
        this.page = page;
        return this;
    }

    public Integer getSize() {
        return size;
    }

    public DescribeEcsReq setSize(Integer size) {
        this.size = size;
        return this;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public DescribeEcsReq setInstanceId(String instanceId) {
        this.instanceId = instanceId;
        return this;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public DescribeEcsReq setInstanceName(String instanceName) {
        this.instanceName = instanceName;
        return this;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public DescribeEcsReq setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
        return this;
    }
}
