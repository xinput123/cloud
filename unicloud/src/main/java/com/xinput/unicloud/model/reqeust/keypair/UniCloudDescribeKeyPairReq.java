package com.xinput.unicloud.model.reqeust.keypair;

import com.xinput.cloud.exception.ParamException;
import com.xinput.unicloud.consts.UniCloudConsts;
import com.xinput.unicloud.model.reqeust.UniRequest;
import com.xinput.unicloud.util.HttpUtils;

import java.util.Map;

/**
 * 获取密钥对列表 参数
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 23:31
 */
public class UniCloudDescribeKeyPairReq extends UniRequest {

    /**
     * 类型：int
     * 必选：否
     * 描述：页码
     */
    private Integer page;

    /**
     * 类型：int
     * 必选：否
     * 描述：页面容量
     */
    private Integer size;

    /**
     * 类型：String
     * 必选：否
     * 描述：密钥对名称
     */
    private String keyPairName;

    /**
     * 类型：String
     * 必选：否
     * 描述：密钥对ID
     */
    private String instanceId;

    /**
     * 类型：String
     * 必选：否
     * 描述：指纹
     */
    private String fingerPrint;

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

    public String getKeyPairName() {
        return keyPairName;
    }

    public void setKeyPairName(String keyPairName) {
        this.keyPairName = keyPairName;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getFingerPrint() {
        return fingerPrint;
    }

    public void setFingerPrint(String fingerPrint) {
        this.fingerPrint = fingerPrint;
    }

    @Override
    public void checkConstraints() throws ParamException {
        this.setAction(UniCloudConsts.Action.DESCRIBE_KEY_PAIR.getAction());
        this.checkField();

        if (this.page == null || this.page < 1) {
            this.page = 1;
        }
        if (this.size == null || this.size < 1) {
            this.size = 10;
        }
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
