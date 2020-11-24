package com.xinput.unicloud.model.response.vpc;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.xinput.cloud.util.StringUtils;
import com.xinput.unicloud.model.response.UniResponse;

import java.util.List;

/**
 * 创建一个专有网络 响应值
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 17:36
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UniCloudCreateVpcResp extends UniResponse {

    @JsonProperty(value = "Msg")
    private String msg;

    @JsonProperty(value = "Res")
    private VpcInfo vpcInfo;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public VpcInfo getVpcInfo() {
        return vpcInfo;
    }

    public void setVpcInfo(VpcInfo vpcInfo) {
        this.vpcInfo = vpcInfo;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class VpcInfo {

        /**
         * 新创建的 VPC 实例的 ID
         */
        @JsonProperty(value = "VpcId")
        private String vpcId;

        /**
         * 子网 Id
         */
        @JsonProperty(value = "SubnetId")
        private List<String> subnetId;

        public String getVpcId() {
            return vpcId;
        }

        public void setVpcId(String vpcId) {
            this.vpcId = vpcId;
        }

        public List<String> getSubnetId() {
            return subnetId;
        }

        public void setSubnetId(List<String> subnetId) {
            this.subnetId = subnetId;
        }
    }

    @Override
    public boolean isSuccess() {
        if (StringUtils.equalsIgnoreCase("Network.Success", this.getCode())) {
            return true;
        }
        return false;
    }
}
