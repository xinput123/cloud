package com.xinput.unicloud.model.response.vpc;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.xinput.cloud.util.StringUtils;
import com.xinput.unicloud.model.response.UniResponse;

import java.util.List;

/**
 * 删除子网 响应值
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 17:36
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UniCloudCreateSubnetResp extends UniResponse {

    @JsonProperty(value = "Msg")
    private String msg;

    /**
     * 子网下的资源列表
     */
    @JsonProperty(value = "Res")
    private SubnetVpc subnetVpc;


    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SubnetVpc {

        /**
         * 子网名称
         */
        @JsonProperty(value = "Name")
        private String name;

        /**
         * DNS 域名服务器
         */
        @JsonProperty(value = "DnsNameServers")
        private List<String> dnsNameServers;

        /**
         * 子网内已分配 IP 数
         */
        @JsonProperty(value = "IpAssignedCount")
        private Integer ipAssignedCount;

        /**
         * 子网网段
         */
        @JsonProperty(value = "Cidr")
        private String cidr;

        /**
         * 子网内可用 IP 总数
         */
        @JsonProperty(value = "IpTotalCount")
        private Integer ipTotalCount;

        /**
         * 网关地址
         */
        @JsonProperty(value = "GatewayIp")
        private String gatewayIp;

        /**
         * 子网 ID
         */
        @JsonProperty(value = "Id")
        private String id;

        /**
         * 可分配 IP 地址池
         */
        @JsonProperty(value = "AllocationPool")
        private AllocationPool AllocationPool;

        @JsonProperty(value = "VpcId")
        private String vpcId;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getDnsNameServers() {
            return dnsNameServers;
        }

        public void setDnsNameServers(List<String> dnsNameServers) {
            this.dnsNameServers = dnsNameServers;
        }

        public Integer getIpAssignedCount() {
            return ipAssignedCount;
        }

        public void setIpAssignedCount(Integer ipAssignedCount) {
            this.ipAssignedCount = ipAssignedCount;
        }

        public String getCidr() {
            return cidr;
        }

        public void setCidr(String cidr) {
            this.cidr = cidr;
        }

        public Integer getIpTotalCount() {
            return ipTotalCount;
        }

        public void setIpTotalCount(Integer ipTotalCount) {
            this.ipTotalCount = ipTotalCount;
        }

        public String getGatewayIp() {
            return gatewayIp;
        }

        public void setGatewayIp(String gatewayIp) {
            this.gatewayIp = gatewayIp;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public SubnetVpc.AllocationPool getAllocationPool() {
            return AllocationPool;
        }

        public void setAllocationPool(SubnetVpc.AllocationPool allocationPool) {
            AllocationPool = allocationPool;
        }

        public String getVpcId() {
            return vpcId;
        }

        public void setVpcId(String vpcId) {
            this.vpcId = vpcId;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class AllocationPool {

            /**
             * 可分配 IP 地址池结束 IP
             */
            @JsonProperty(value = "End")
            private String end;

            /**
             * 可分配 IP 地址池起始 IP
             */
            @JsonProperty(value = "Start")
            private String start;

            public String getEnd() {
                return end;
            }

            public void setEnd(String end) {
                this.end = end;
            }

            public String getStart() {
                return start;
            }

            public void setStart(String start) {
                this.start = start;
            }
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
