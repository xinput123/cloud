package com.xinput.cloud.domain.req;

import com.xinput.cloud.consts.CloudConsts;

/**
 * 开机参数
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 17:13
 */
public class StartEcsReq {

    /**
     * 类型：String
     * 描述：区域Id {@link CloudConsts.Region}
     * 适用云: {@link CloudConsts.CloudEnum #UniCloud}
     */
    private CloudConsts.Region region;

    /**
     * 类型：string
     * 描述：云主机ID
     * 适用云: {@link CloudConsts.CloudEnum #UniCloud}
     */
    private String instanceId;

    public CloudConsts.Region getRegion() {
        return region;
    }

    public void setRegion(CloudConsts.Region region) {
        this.region = region;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }
}
