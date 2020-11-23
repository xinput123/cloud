package com.xinput.unicloud.model.response.ecs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xinput.unicloud.model.response.UniResponse;

import java.util.List;

/**
 * 使用RunEcs创建云主机响应值
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 00:08
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UniCloudRunEcsResp extends UniResponse {

    /**
     * 订单号
     */
    private String orderId;

    /**
     * 云主机ID列表
     */
    private List<String> instanceIds;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<String> getInstanceIds() {
        return instanceIds;
    }

    public void setInstanceIds(List<String> instanceIds) {
        this.instanceIds = instanceIds;
    }
}
