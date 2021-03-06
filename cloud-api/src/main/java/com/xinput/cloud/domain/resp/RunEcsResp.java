package com.xinput.cloud.domain.resp;

import java.util.List;

/**
 * 创建云主机 响应值
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 11:40
 */
public class RunEcsResp {

    private String RequestId;

    private String orderId;

    private List<String> instanceIds;

    public String getRequestId() {
        return RequestId;
    }

    public RunEcsResp setRequestId(String requestId) {
        RequestId = requestId;
        return this;
    }

    public String getOrderId() {
        return orderId;
    }

    public RunEcsResp setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public List<String> getInstanceIds() {
        return instanceIds;
    }

    public RunEcsResp setInstanceIds(List<String> instanceIds) {
        this.instanceIds = instanceIds;
        return this;
    }
}
