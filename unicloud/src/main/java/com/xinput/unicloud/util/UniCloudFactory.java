package com.xinput.unicloud.util;

import com.google.common.base.Joiner;
import com.xinput.cloud.exception.ParamException;
import com.xinput.cloud.util.JsonUtils;
import com.xinput.cloud.util.StringUtils;
import com.xinput.unicloud.consts.UniCloudConsts;
import com.xinput.unicloud.model.Context;
import com.xinput.unicloud.model.reqeust.UniRequest;
import com.xinput.unicloud.model.reqeust.ecs.UniCloudDeleteEcsReq;
import com.xinput.unicloud.model.reqeust.ecs.UniCloudDescribeEcsReq;
import com.xinput.unicloud.model.reqeust.ecs.UniCloudDetailEcsReq;
import com.xinput.unicloud.model.reqeust.ecs.UniCloudRebootEcsReq;
import com.xinput.unicloud.model.reqeust.ecs.UniCloudResetEcsPasswordReq;
import com.xinput.unicloud.model.reqeust.ecs.UniCloudRunEcsReq;
import com.xinput.unicloud.model.reqeust.ecs.UniCloudStartEcsReq;
import com.xinput.unicloud.model.reqeust.ecs.UniCloudStopEcsReq;
import com.xinput.unicloud.model.reqeust.ecs.UniCloudUpdateEcsNameReq;
import com.xinput.unicloud.model.reqeust.image.UniCloudCreateEcsSysSnapshotReq;
import com.xinput.unicloud.model.reqeust.image.UniCloudCreateImageReq;
import com.xinput.unicloud.model.reqeust.image.UniCloudDeleteImageReq;
import com.xinput.unicloud.model.reqeust.image.UniCloudDescribeImageReq;
import com.xinput.unicloud.model.reqeust.image.UniCloudEcsSysSnapshotRollBackReq;
import com.xinput.unicloud.model.reqeust.keypair.UniCloudCreateKeyPairReq;
import com.xinput.unicloud.model.reqeust.keypair.UniCloudDeleteKeyPairReq;
import com.xinput.unicloud.model.reqeust.keypair.UniCloudDescribeKeyPairReq;
import com.xinput.unicloud.model.reqeust.keypair.UniCloudGetVmByKeyPairReq;
import com.xinput.unicloud.model.reqeust.vpc.UniCloudCreateSubnetReq;
import com.xinput.unicloud.model.reqeust.vpc.UniCloudCreateVpcReq;
import com.xinput.unicloud.model.reqeust.vpc.UniCloudDeleteSubnetReq;
import com.xinput.unicloud.model.reqeust.vpc.UniCloudDeleteVpcReq;
import com.xinput.unicloud.model.reqeust.vpc.UniCloudDescribeSubnetReq;
import com.xinput.unicloud.model.reqeust.vpc.UniCloudDescribeVpcReq;
import com.xinput.unicloud.model.reqeust.vpc.UniCloudUpdateVpcReq;
import com.xinput.unicloud.model.response.ecs.UniCloudDeleteEcsResp;
import com.xinput.unicloud.model.response.ecs.UniCloudDesctibeEcsResp;
import com.xinput.unicloud.model.response.ecs.UniCloudDetailEcsResp;
import com.xinput.unicloud.model.response.ecs.UniCloudRebootEcsResp;
import com.xinput.unicloud.model.response.ecs.UniCloudResetEcsPasswordResp;
import com.xinput.unicloud.model.response.ecs.UniCloudRunEcsResp;
import com.xinput.unicloud.model.response.ecs.UniCloudStartEcsResp;
import com.xinput.unicloud.model.response.ecs.UniCloudStopEcsResp;
import com.xinput.unicloud.model.response.ecs.UniCloudUpdateEcsNameResp;
import com.xinput.unicloud.model.response.image.UniCloudCreateEcsSysSnapshotResp;
import com.xinput.unicloud.model.response.image.UniCloudCreateImageResp;
import com.xinput.unicloud.model.response.image.UniCloudDeleteImageResp;
import com.xinput.unicloud.model.response.image.UniCloudDescribeImageResp;
import com.xinput.unicloud.model.response.image.UniCloudEcsSysSnapshotRollBackResp;
import com.xinput.unicloud.model.response.keypair.UniCloudCreateKeyPairResp;
import com.xinput.unicloud.model.response.keypair.UniCloudDeleteKeyPairResp;
import com.xinput.unicloud.model.response.keypair.UniCloudDescribeKeyPairResp;
import com.xinput.unicloud.model.response.keypair.UniCloudGetVmByKeyPairResp;
import com.xinput.unicloud.model.response.vpc.UniCloudCreateSubnetResp;
import com.xinput.unicloud.model.response.vpc.UniCloudCreateVpcResp;
import com.xinput.unicloud.model.response.vpc.UniCloudDeleteSubnetResp;
import com.xinput.unicloud.model.response.vpc.UniCloudDeleteVpcResp;
import com.xinput.unicloud.model.response.vpc.UniCloudDescribeSubnetResp;
import com.xinput.unicloud.model.response.vpc.UniCloudDescribeVpcResp;
import com.xinput.unicloud.model.response.vpc.UniCloudUpdateVpcResp;

import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UniCloudFactory {

    private static Context context;

    public static void init(String accessKeyId, String secretKey) throws ParamException {
        if (StringUtils.isEmpty(accessKeyId)) {
            throw new ParamException("The specified parameter [AccessKeyId] is not valid.");
        }

        if (StringUtils.isAnyEmpty(accessKeyId, secretKey)) {
            throw new ParamException("The specified parameter [secretKey] is not valid.");
        }

        context = new Context(accessKeyId, secretKey);
    }

    /**
     * 主机实例
     */
    public static class Ecs {
        /**
         * 查询云主机实例列表
         */
        public static UniCloudDesctibeEcsResp describe(UniCloudDescribeEcsReq describeEcsReq) throws Exception {
            return JsonUtils.toBean(sendRequest(describeEcsReq), UniCloudDesctibeEcsResp.class);
        }

        /**
         * 查询云主机实例详情
         */
        public static UniCloudDetailEcsResp detail(UniCloudDetailEcsReq detailEcsReq) throws Exception {
            return JsonUtils.toBean(sendRequest(detailEcsReq), UniCloudDetailEcsResp.class);
        }

        /**
         * 创建云主机
         */
        public static UniCloudRunEcsResp create(UniCloudRunEcsReq runEcsReq) throws Exception {
            return JsonUtils.toBean(sendRequest(runEcsReq), UniCloudRunEcsResp.class);
        }

        /**
         * 对云主机关机
         */
        public static UniCloudStopEcsResp stop(UniCloudStopEcsReq stopEcsReq) throws Exception {
            return JsonUtils.toBean(sendRequest(stopEcsReq), UniCloudStopEcsResp.class);
        }

        /**
         * 对云主机开机
         */
        public static UniCloudStartEcsResp start(UniCloudStartEcsReq startEcsReq) throws Exception {
            return JsonUtils.toBean(sendRequest(startEcsReq), UniCloudStartEcsResp.class);
        }

        /**
         * 删除云主机
         */
        public static UniCloudDeleteEcsResp delete(UniCloudDeleteEcsReq deleteEcsReq) throws Exception {
            return JsonUtils.toBean(sendRequest(deleteEcsReq), UniCloudDeleteEcsResp.class);
        }

        /**
         * 重启云主机
         */
        public static UniCloudRebootEcsResp reboot(UniCloudRebootEcsReq rebootEcsReq) throws Exception {
            return JsonUtils.toBean(sendRequest(rebootEcsReq), UniCloudRebootEcsResp.class);
        }

        /**
         * 修改云主机名称
         */
        public static UniCloudUpdateEcsNameResp updateEcsName(UniCloudUpdateEcsNameReq updateEcsNameReq) throws Exception {
            return JsonUtils.toBean(sendRequest(updateEcsNameReq), UniCloudUpdateEcsNameResp.class);
        }

        /**
         * 修改云主机密码
         */
        public static UniCloudResetEcsPasswordResp updatePassword(UniCloudResetEcsPasswordReq updatePwdReq) throws Exception {
            return JsonUtils.toBean(sendRequest(updatePwdReq), UniCloudResetEcsPasswordResp.class);
        }
    }

    /**
     * 镜像快照
     */
    public static class Image {
        /**
         * 私有镜像列表
         */
        public static UniCloudDescribeImageResp describe(UniCloudDescribeImageReq describeImageReq) throws Exception {
            return JsonUtils.toBean(sendRequest(describeImageReq), UniCloudDescribeImageResp.class);
        }

        /**
         * 生成镜像
         */
        public static UniCloudCreateImageResp create(UniCloudCreateImageReq createImageReq) throws Exception {
            return JsonUtils.toBean(sendRequest(createImageReq), UniCloudCreateImageResp.class);
        }

        /**
         * 释放私有镜像
         */
        public static UniCloudDeleteImageResp delete(UniCloudDeleteImageReq deleteImageReq) throws Exception {
            return JsonUtils.toBean(sendRequest(deleteImageReq), UniCloudDeleteImageResp.class);
        }

        /**
         * 创建系统盘快照
         */
        public static UniCloudCreateEcsSysSnapshotResp createSnapshot(UniCloudCreateEcsSysSnapshotReq createSnapshotReq) throws Exception {
            return JsonUtils.toBean(sendRequest(createSnapshotReq), UniCloudCreateEcsSysSnapshotResp.class);
        }

        /**
         * 系统盘快照回滚
         */
        public static UniCloudEcsSysSnapshotRollBackResp ecsSysSnapshotRollBack(UniCloudEcsSysSnapshotRollBackReq ecsSysSnapshotRollBackReq) throws Exception {
            return JsonUtils.toBean(sendRequest(ecsSysSnapshotRollBackReq), UniCloudEcsSysSnapshotRollBackResp.class);
        }
    }

    /**
     * 密钥对
     */
    public static class KeyPair {
        /**
         * 新建密钥对
         */
        public static UniCloudCreateKeyPairResp create(UniCloudCreateKeyPairReq createKeyPairReq) throws Exception {
            return JsonUtils.toBean(sendRequest(createKeyPairReq), UniCloudCreateKeyPairResp.class);
        }

        /**
         * 删除密钥对
         */
        public static UniCloudDeleteKeyPairResp delete(UniCloudDeleteKeyPairReq deleteKeyPairReq) throws Exception {
            return JsonUtils.toBean(sendRequest(deleteKeyPairReq), UniCloudDeleteKeyPairResp.class);
        }

        /**
         * 获取密钥对列表
         */
        public static UniCloudDescribeKeyPairResp describe(UniCloudDescribeKeyPairReq describeKeyPairReq) throws Exception {
            return JsonUtils.toBean(sendRequest(describeKeyPairReq), UniCloudDescribeKeyPairResp.class);
        }

        /**
         * 获取应用密钥对的云主机
         */
        public static UniCloudGetVmByKeyPairResp getVm(UniCloudGetVmByKeyPairReq getVmByKeyPairReq) throws Exception {
            return JsonUtils.toBean(sendRequest(getVmByKeyPairReq), UniCloudGetVmByKeyPairResp.class);
        }
    }

    /**
     * VPC网络
     */
    public static class Vpc {
        /**
         * 创建VPC网络
         */
        public static UniCloudCreateVpcResp create(UniCloudCreateVpcReq createVpcReq) throws Exception {
            return JsonUtils.toBean(sendRequest(createVpcReq), UniCloudCreateVpcResp.class);
        }

        /**
         * 获取VPC网络列表
         */
        public static UniCloudDescribeVpcResp describe(UniCloudDescribeVpcReq describeVpcReq) throws Exception {
            return JsonUtils.toBean(sendRequest(describeVpcReq), UniCloudDescribeVpcResp.class);
        }

        /**
         * 修改指定VPC实例的名称
         */
        public static UniCloudUpdateVpcResp updateVpc(UniCloudUpdateVpcReq updateVpcReq) throws Exception {
            return JsonUtils.toBean(sendRequest(updateVpcReq), UniCloudUpdateVpcResp.class);
        }

        /**
         * 删除VPC网络
         */
        public static UniCloudDeleteVpcResp delete(UniCloudDeleteVpcReq deleteVpcReq) throws Exception {
            return JsonUtils.toBean(sendRequest(deleteVpcReq), UniCloudDeleteVpcResp.class);
        }

        /**
         * 创建VPC子网
         */
        public static UniCloudCreateSubnetResp createSubnet(UniCloudCreateSubnetReq createSubnetReq) throws Exception {
            return JsonUtils.toBean(sendRequest(createSubnetReq), UniCloudCreateSubnetResp.class);
        }

        /**
         * VPC子网列表
         */
        public static UniCloudDescribeSubnetResp describeSubnet(UniCloudDescribeSubnetReq describeSubnetReq) throws Exception {
            return JsonUtils.toBean(sendRequest(describeSubnetReq), UniCloudDescribeSubnetResp.class);
        }

        /**
         * 释放指定VPC下的指定子网
         */
        public static UniCloudDeleteSubnetResp deleteSubnet(UniCloudDeleteSubnetReq deleteSubnetReq) throws Exception {
            return JsonUtils.toBean(sendRequest(deleteSubnetReq), UniCloudDeleteSubnetResp.class);
        }
    }

    private static String sendRequest(UniRequest uniRequest) throws Exception {
        // 字段验证
        uniRequest.checkConstraints();

        UniCloudConsts.Action action = UniCloudConsts.Action.getAction(uniRequest.getAction());
        String urlString = getUrl(uniRequest, action);
        return uniRequest.httpExecute(urlString);
    }

    private static String getUrl(UniRequest uniRequest, UniCloudConsts.Action action) throws Exception {
        // 字段验证
        uniRequest.checkConstraints();
        Map<String, Object> parameters = uniRequest.signatureParams();
        parameters.put("AccessKeyId", context.getAccessKey());

        // 将原始uri 中的key value 进行 encode
        List<String> params = SignatureUtils.paramsToQuery(parameters);

        // 排序参数
        List<String> pList = params.stream().map(SignatureUtils::encode).sorted().collect(Collectors.toList());

        // 将转译后的请求参数用&拼接   & encode 之后 是 %26
        String canonicalizedQueryString = Joiner.on("%26").join(pList);

        // 生成 stringToSign
        String stringToSign = Joiner.on("&").join(action.getMethod(), URLEncoder.encode("/", "utf-8"), canonicalizedQueryString);

        // 生成 hmac
        String hmac = SignatureUtils.hmacSHA1Encrypt(stringToSign, context.getSecretKey() + "&");

        // 最终发出的url  需要对value 进行转译
        String url = Joiner.on("&").join(params) + "&Signature=" + SignatureUtils.encode(hmac);
        return Joiner.on("?").join(action.getUrl(), url);
    }

}
