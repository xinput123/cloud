package com.xinput.unicloud.model.response.keypair;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.xinput.unicloud.model.response.UniResponse;

import java.util.List;

/**
 * 获取应用密钥对的云主机 响应值
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 17:36
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UniCloudGetVmByKeyPairResp extends UniResponse {

    @JsonProperty(value = "related")
    private List<Related> relateds;

    public List<Related> getRelateds() {
        return relateds;
    }

    public void setRelateds(List<Related> relateds) {
        this.relateds = relateds;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Related {

        /**
         * 云主机ID
         */
        private String instanceId;

        /**
         * 云主机名称
         */
        private String instanceName;

        /**
         * 云主机状态
         */
        private String status;

        /**
         * 云主机IP
         */
        private String ip;

        /**
         * 规格描述
         */
        private String instanceCodeName;

        public String getInstanceName() {
            return instanceName;
        }

        public void setInstanceName(String instanceName) {
            this.instanceName = instanceName;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getInstanceCodeName() {
            return instanceCodeName;
        }

        public void setInstanceCodeName(String instanceCodeName) {
            this.instanceCodeName = instanceCodeName;
        }

        public String getInstanceId() {
            return instanceId;
        }

        public void setInstanceId(String instanceId) {
            this.instanceId = instanceId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
