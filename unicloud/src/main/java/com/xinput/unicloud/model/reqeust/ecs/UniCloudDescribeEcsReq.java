package com.xinput.unicloud.model.reqeust.ecs;

import com.xinput.cloud.domain.req.DescribeEcsReq;
import com.xinput.cloud.exception.ParamException;
import com.xinput.unicloud.consts.UniCloudConsts;
import com.xinput.unicloud.model.reqeust.UniRequest;
import com.xinput.unicloud.util.HttpUtils;

import java.util.Map;

/**
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-19 11:28
 */
public class UniCloudDescribeEcsReq extends UniRequest {

    /**
     * 类型：int
     * 必选：否
     * 描述：页码，默认1
     */
    private Integer page;

    /**
     * 类型：int
     * 必选：否
     * 描述：列表容量，默认10
     */
    private Integer size;

    /**
     * 类型：String
     * 必选：否
     * 描述：云主机ID
     */
    private String instanceId;

    /**
     * 类型：String
     * 必选：否
     * 描述：云主机名称
     */
    private String instanceName;

    /**
     * 类型：String
     * 必选：否
     * 描述：云主机IP
     */
    private String ipAddr;

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

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public UniCloudDescribeEcsReq() {
    }

    public UniCloudDescribeEcsReq(DescribeEcsReq describeEcsReq) {
        if (describeEcsReq.getRegion() != null) {
            super.setRegionId(describeEcsReq.getRegion().getRegionId());
        }
        this.page = describeEcsReq.getPage();
        this.size = describeEcsReq.getSize();
        this.instanceId = describeEcsReq.getInstanceId();
        this.instanceName = describeEcsReq.getInstanceName();
        this.ipAddr = describeEcsReq.getIpAddr();
    }

    @Override
    public void checkConstraints() throws ParamException {
        this.setAction(UniCloudConsts.Action.DESCRIBE_ECS.getAction());

        if (this.page == null || this.page < 1) {
            this.page = 1;
        }

        if (this.size == null || this.size < 10) {
            this.size = 10;
        }

        checkField();
    }

    @Override
    public Map<String, Object> signatureParams() {
        Map<String, Object> params = this.toMap();
        this.addCommonParams(params);
        return params;
    }

    @Override
    public String httpExecute(String url) throws Exception {
        return HttpUtils.get(url);
    }
}
