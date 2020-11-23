package com.xinput.unicloud.model.reqeust;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xinput.cloud.domain.BaseInfo;
import com.xinput.cloud.util.ObjectId;
import com.xinput.unicloud.model.Context;
import com.xinput.unicloud.util.DateUtils;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.Map;

/**
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-19 10:42
 */
public abstract class UniRequest extends BaseInfo {

    /**
     * 类型：String
     * 必选：是
     * 描述：操作名取值DescribeEcs
     */
    @JsonIgnore
    @NotEmpty(message = "字段 [action] 不能为空")
    private String action;

    /**
     * 类型：String
     * 必选：是
     * 描述：区域Id {@link com.xinput.cloud.consts.CloudConsts.Region}
     */
    @JsonIgnore
    @NotEmpty(message = "字段 [regionId] 不能为空")
    private String regionId;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    /**
     * 组装公共参数
     *
     * @param parameters
     */
    private void addCommonParams(final Context context, Map<String, Object> parameters) {
        parameters.put("Format", "json");
        parameters.put("Version", "2020-07-30");
        parameters.put("SignatureMethod", "HMAC-SHA1");
        parameters.put("Timestamp", DateUtils.formatIso8601Date(new Date()));
        parameters.put("SignatureVersion", "1.0");
        parameters.put("SignatureNonce", ObjectId.stringId());
        parameters.put("AccessKeyId", context.getAccessKey());
    }
}
