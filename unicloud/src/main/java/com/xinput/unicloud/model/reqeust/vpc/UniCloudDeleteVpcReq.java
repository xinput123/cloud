package com.xinput.unicloud.model.reqeust.vpc;

import com.xinput.cloud.exception.ParamException;
import com.xinput.unicloud.consts.UniCloudConsts;
import com.xinput.unicloud.model.reqeust.UniRequest;
import com.xinput.unicloud.util.HttpUtils;

import javax.validation.constraints.NotEmpty;

/**
 * 创建一个专有网络 参数
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 23:31
 */
public class UniCloudDeleteVpcReq extends UniRequest {

    /**
     * 类型：string
     * 必选：是
     * 描述：VPC Id
     */
    @NotEmpty(message = "字段 [InstanceId] 不能为空")
    private String instanceId;

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    @Override
    public void checkConstraints() throws ParamException {
        this.setAction(UniCloudConsts.Action.DELETE_VPC.getAction());
        this.checkField();
    }

    @Override
    public String httpExecute(String url) throws Exception {
        return HttpUtils.delete(url);
    }
}
