package com.xinput.unicloud.model.reqeust.vpc;

import com.xinput.cloud.exception.ParamException;
import com.xinput.unicloud.consts.UniCloudConsts;
import com.xinput.unicloud.model.reqeust.UniSubnetRequest;

/**
 * 查询子网列表 参数
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 23:31
 */
public class UniCloudDescribeSubnetReq extends UniSubnetRequest {

    @Override
    public void checkConstraints() throws ParamException {
        this.setAction(UniCloudConsts.Action.DESCRIBE_SUBNET.getAction());
        this.checkField();
    }
}
