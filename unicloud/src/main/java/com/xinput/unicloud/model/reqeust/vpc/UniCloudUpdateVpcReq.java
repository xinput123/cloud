package com.xinput.unicloud.model.reqeust.vpc;

import com.xinput.cloud.exception.ParamException;
import com.xinput.unicloud.consts.UniCloudConsts;
import com.xinput.unicloud.model.reqeust.UniRequest;
import com.xinput.unicloud.util.HttpUtils;

/**
 * 修改指定 VPC 实例的名称 参数
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 23:31
 */
public class UniCloudUpdateVpcReq extends UniRequest {

    /**
     * 类型：String
     * 必选：否
     * 描述：指定 VPC 实例的 ID
     */
    private String vpcId;

    /**
     * 类型：String
     * 必选：否
     * 描述：指定 VPC 实例的名称
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVpcId() {
        return vpcId;
    }

    public void setVpcId(String vpcId) {
        this.vpcId = vpcId;
    }

    @Override
    public void checkConstraints() throws ParamException {
        this.setAction(UniCloudConsts.Action.UPDATE_VPC.getAction());
        this.checkField();

    }

    @Override
    public String httpExecute(String url) throws Exception {
        return HttpUtils.put(url);
    }
}
