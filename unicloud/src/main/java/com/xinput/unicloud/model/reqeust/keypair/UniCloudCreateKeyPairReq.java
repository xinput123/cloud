package com.xinput.unicloud.model.reqeust.keypair;

import com.xinput.cloud.exception.ParamException;
import com.xinput.unicloud.consts.UniCloudConsts;
import com.xinput.unicloud.model.reqeust.UniRequest;
import com.xinput.unicloud.util.HttpUtils;

import javax.validation.constraints.NotEmpty;
import java.util.Map;

/**
 * 创建密钥对 参数
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 23:31
 */
public class UniCloudCreateKeyPairReq extends UniRequest {

    /**
     * 类型：string
     * 必选：是
     * 描述：页码
     */
    @NotEmpty(message = "字段 [name] 不能为空")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void checkConstraints() throws ParamException {
        this.setAction(UniCloudConsts.Action.CREATE_KEY_PAIR.getAction());
        this.checkField();
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
