package com.xinput.unicloud.consts;

import com.xinput.cloud.util.StringUtils;

/**
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-18 18:41
 */
public class UniCloudConsts {

    public enum Action {
        // 云主机
        DESCRIBE_ECS("DescribeEcs", "https://api.unicloud.com/compute", "GET", "查询云主机实例列表"),
        DETAIL_ECS("DetailEcs", "https://api.unicloud.com/compute", "GET", "查询云主机实例详情"),
        RUN_ECS("RunEcs", "https://api.unicloud.com/compute", "POST", "创建云主机"),
        START_ECS("StartEcs", "https://api.unicloud.com/compute", "GET", "开启云主机"),
        STOP_ECS("StopEcs", "https://api.unicloud.com/compute", "GET", "关闭云主机"),
        DELETE_ECS("DeleteEcs", "https://api.unicloud.com/compute", "GET", "删除云主机"),


        // 镜像快照
        DESCRIBE_IMAGE("DescribeImages", "https://api.unicloud.com/compute", "GET", "查看私有镜像列表"),
        CREATE_IMAGE("CreateImage", "https://api.unicloud.com/compute", "GET", "生成私有镜像"),
        DELETE_IMAGES("DeleteImages", "https://api.unicloud.com/compute", "GET", "释放私有镜像"),
        CREATE_ECS_SYS_SNAPSHOT("CreateEcsSysSnapshot", "https://api.unicloud.com/compute", "GET", "创建系统盘快照"),
        ECS_SYS_SNAPSHOT_ROLLBACK("EcsSysSnapshotRollBack", "https://api.unicloud.com/compute", "GET", "进行系统盘快照回滚"),
        // 密钥对
        CREATE_KEY_PAIR("CreateKeyPair", "https://api.unicloud.com/compute", "GET", "创建密钥对"),
        DELETE_KEY_PAIR("DeleteKeyPairs", "https://api.unicloud.com/compute", "GET", "删除密钥对"),
        DESCRIBE_KEY_PAIR("DescribeKeyPairs", "https://api.unicloud.com/compute", "GET", "获取密钥对列表"),
        GET_VM_BY_KEY_PAIR("GetVMByKeyPair", "https://api.unicloud.com/compute", "GET", "获取应用密钥对的云主机"),
        // VPC
        CREATE_VPC("CreateVpc", "https://api.unicloud.com/network", "POST", "创建一个专有网络(VPC)"),
        DESCRIBE_VPC("DescribeVpc", "https://api.unicloud.com/network", "GET", "查询已创建的VPC列表"),
        UPDATE_VPC("UpdateVpc", "https://api.unicloud.com/network", "PUT", "修改指定VPC实例的名称"),
        DELETE_VPC("DeleteVpc", "https://api.unicloud.com/network", "DELETE", "释放一个指定的专有网络(VPC)"),
        CREATE_SUBNET("CreateSubnet", "https://api.unicloud.com/vpc", "POST", "创建子网"),
        DESCRIBE_SUBNET("DescribeSubnet", "https://api.unicloud.com/networks", "GET", "查询子网列表"),
        DELETE_SUBNET("DeleteSubnet", "https://api.unicloud.com/networks", "DELETE", "释放指定VPC下的指定子网"),
        ;

        private String action;

        private String url;

        private String method;

        private String desc;

        Action(String action, String url, String method, String desc) {
            this.action = action;
            this.url = url;
            this.method = method;
            this.desc = desc;
        }

        public String getAction() {
            return action;
        }

        public String getMethod() {
            return method;
        }

        public String getUrl() {
            return url;
        }

        public String getDesc() {
            return desc;
        }

        public static Action getAction(String actionValue) {
            for (Action action : Action.values()) {
                if (StringUtils.equalsIgnoreCase(action.getAction(), actionValue)) {
                    return action;
                }
            }
            return null;
        }
    }
}
