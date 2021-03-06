package com.xinput.cloud.domain.req;

import com.xinput.cloud.consts.CloudConsts;

/**
 * 查询云主机实例详情
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-19 17:48
 */
public class DetailEcsReq {

    /**
     * 类型：String
     * 描述：区域Id {@link com.xinput.cloud.consts.CloudConsts.Region}
     * 适用云: {@link com.xinput.cloud.consts.CloudConsts.CloudEnum #UniCloud}
     */
    private CloudConsts.Region region;

    /**
     * 类型：string
     * 描述：云主机ID
     * 适用云: {@link com.xinput.cloud.consts.CloudConsts.CloudEnum #UniCloud}
     */
    private String instanceId;

    public CloudConsts.Region getRegion() {
        return region;
    }

    public DetailEcsReq setRegion(CloudConsts.Region region) {
        this.region = region;
        return this;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public DetailEcsReq setInstanceId(String instanceId) {
        this.instanceId = instanceId;
        return this;
    }
}
