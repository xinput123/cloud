package com.xinput.unicloud.model.reqeust;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xinput.cloud.domain.BaseInfo;
import com.xinput.unicloud.util.HttpUtils;

import javax.validation.constraints.NotEmpty;

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
    @NotEmpty(message = "字段 [regionId] 不能为空")
    private String regionId;

    /**
     * 请求，这里默认是get方式，所有请求数据在url上，如果是其他方式，请使用子类覆盖
     */
    public String httpExecute(String url) throws Exception {
        return HttpUtils.get(url);
    }

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
}
