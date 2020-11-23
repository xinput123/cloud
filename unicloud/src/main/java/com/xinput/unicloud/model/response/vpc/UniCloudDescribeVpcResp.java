package com.xinput.unicloud.model.response.vpc;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.xinput.unicloud.model.response.UniResponse;

import java.util.List;

/**
 * 查询已创建的VPC列表 响应值
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 17:36
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UniCloudDescribeVpcResp extends UniResponse {

    /**
     * 请求结果描述
     */
    @JsonProperty(value = "Msg")
    private String msg;

    /**
     * VPC 列表
     */
    @JsonProperty(value = "Res")
    private List<VpcInfo> vpcInfos;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<VpcInfo> getVpcInfos() {
        return vpcInfos;
    }

    public void setVpcInfos(List<VpcInfo> vpcInfos) {
        this.vpcInfos = vpcInfos;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class VpcInfo {
        /**
         * VPC 实例状态
         */
        @JsonProperty(value = "Status")
        private String status;

        /**
         * 地域 ID
         */
        @JsonProperty(value = "RegionId")
        private String regionId;

        /**
         * VPC 实例规格
         */
        @JsonProperty(value = "InstanceCode")
        private String instanceCode;

        /**
         * 用户 ID
         */
        @JsonProperty(value = "UserId")
        private String userId;

        /**
         * VPC 实例 ID
         */
        @JsonProperty(value = "InstanceId")
        private String instanceId;

        /**
         * VPC 实例 CIDR 网段
         */
        @JsonProperty(value = "Cidr")
        private String cidr;

        /**
         * VPC 实例名称
         */
        @JsonProperty(value = "InstanceName")
        private String instanceName;

        /**
         * 子网列表
         */
        @JsonProperty(value = "Subnets")
        private List<SubnetInfo> subnetInfos;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getRegionId() {
            return regionId;
        }

        public void setRegionId(String regionId) {
            this.regionId = regionId;
        }

        public String getInstanceCode() {
            return instanceCode;
        }

        public void setInstanceCode(String instanceCode) {
            this.instanceCode = instanceCode;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getInstanceId() {
            return instanceId;
        }

        public void setInstanceId(String instanceId) {
            this.instanceId = instanceId;
        }

        public String getCidr() {
            return cidr;
        }

        public void setCidr(String cidr) {
            this.cidr = cidr;
        }

        public String getInstanceName() {
            return instanceName;
        }

        public void setInstanceName(String instanceName) {
            this.instanceName = instanceName;
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
             * 子网名称
             */
            @JsonProperty(value = "Name")
            private String name;

            /**
             * 子网内已分配 IP 数
             */
            @JsonProperty(value = "IpAssignedCount")
            private int ipAssignedCount;

            /**
             * 子网内可用 IP 总数
             */
            @JsonProperty(value = "IpTotalCount")
            private int ipTotalCount;

            /**
             * 子网网段
             */
            @JsonProperty(value = "Cidr")
            private String cidr;

            /**
             * 网关
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

            @JsonProperty(value = "BindResources")
            private List<BindResource> bindResources;

            /**
             * DNS 域名服务器
             */
            @JsonProperty(value = "DnsNameServers")
            private List<String> dnsNameServers;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getIpAssignedCount() {
                return ipAssignedCount;
            }

            public void setIpAssignedCount(int ipAssignedCount) {
                this.ipAssignedCount = ipAssignedCount;
            }

            public int getIpTotalCount() {
                return ipTotalCount;
            }

            public void setIpTotalCount(int ipTotalCount) {
                this.ipTotalCount = ipTotalCount;
            }

            public String getCidr() {
                return cidr;
            }

            public void setCidr(String cidr) {
                this.cidr = cidr;
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

            public List<BindResource> getBindResources() {
                return bindResources;
            }

            public void setBindResources(List<BindResource> bindResources) {
                this.bindResources = bindResources;
            }

            public List<String> getDnsNameServers() {
                return dnsNameServers;
            }

            public void setDnsNameServers(List<String> dnsNameServers) {
                this.dnsNameServers = dnsNameServers;
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class AllocationPool {
                /**
                 * 可分配 IP 地址池结束 IP
                 */
                @JsonProperty(value = "End")
                private String end;

                /**
                 * 可分配 IP 地址池开始 IP
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

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class BindResource {

                /**
                 * 绑定资源的 ID
                 */
                @JsonProperty(value = "ReviceId")
                private String reviceId;

                /**
                 * 绑定资源的类型
                 */
                @JsonProperty(value = "ResourceType")
                private String ResourceType;

                public String getReviceId() {
                    return reviceId;
                }

                public void setReviceId(String reviceId) {
                    this.reviceId = reviceId;
                }

                public String getResourceType() {
                    return ResourceType;
                }

                public void setResourceType(String resourceType) {
                    ResourceType = resourceType;
                }
            }
        }
    }
}
