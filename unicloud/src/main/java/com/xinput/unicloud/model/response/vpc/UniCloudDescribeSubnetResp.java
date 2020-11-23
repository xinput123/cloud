package com.xinput.unicloud.model.response.vpc;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.xinput.unicloud.model.response.UniResponse;

import java.util.List;

/**
 * 子网列表 响应值
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 17:36
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UniCloudDescribeSubnetResp extends UniResponse {

    @JsonProperty(value = "Msg")
    private String msg;

    @JsonProperty(value = "Res")
    private List<SubnetInfo> subnetInfos;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<SubnetInfo> getSubnetInfos() {
        return subnetInfos;
    }

    public void setSubnetInfos(List<SubnetInfo> subnetInfos) {
        this.subnetInfos = subnetInfos;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SubnetInfo {

        /**
         * 子网下的资源列表
         */
        @JsonProperty(value = "BindResources")
        private BindResources bindResources;

        /**
         * 子网名称
         */
        @JsonProperty(value = "Name")
        private String name;

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
         * 可分配 IP 地址池
         */
        @JsonProperty(value = "AllocationPool")
        private AllocationPool allocationPool;

        /**
         * 子网 ID
         */
        @JsonProperty(value = "Id")
        private String id;

        /**
         * DNS 域名服务器
         */
        @JsonProperty(value = "DnsNameServers")
        private List<String> dnsNameServers;

        public BindResources getBindResources() {
            return bindResources;
        }

        public void setBindResources(BindResources bindResources) {
            this.bindResources = bindResources;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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

        public AllocationPool getAllocationPool() {
            return allocationPool;
        }

        public void setAllocationPool(AllocationPool allocationPool) {
            this.allocationPool = allocationPool;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<String> getDnsNameServers() {
            return dnsNameServers;
        }

        public void setDnsNameServers(List<String> dnsNameServers) {
            this.dnsNameServers = dnsNameServers;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class BindResources {
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
}
