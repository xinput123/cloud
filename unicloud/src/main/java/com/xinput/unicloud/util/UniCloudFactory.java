package com.xinput.unicloud.util;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import com.xinput.cloud.exception.ParamException;
import com.xinput.cloud.util.JsonUtils;
import com.xinput.cloud.util.ObjectId;
import com.xinput.cloud.util.StringUtils;
import com.xinput.unicloud.consts.UniCloudConsts;
import com.xinput.unicloud.model.Context;
import com.xinput.unicloud.model.reqeust.UniRequest;
import com.xinput.unicloud.model.reqeust.ecs.UniCloudDeleteEcsReq;
import com.xinput.unicloud.model.reqeust.ecs.UniCloudDescribeEcsReq;
import com.xinput.unicloud.model.reqeust.ecs.UniCloudDetailEcsReq;
import com.xinput.unicloud.model.reqeust.ecs.UniCloudRunEcsReq;
import com.xinput.unicloud.model.reqeust.ecs.UniCloudStartEcsReq;
import com.xinput.unicloud.model.reqeust.ecs.UniCloudStopEcsReq;
import com.xinput.unicloud.model.reqeust.image.UniCloudCreateEcsSysSnapshotReq;
import com.xinput.unicloud.model.reqeust.image.UniCloudCreateImageReq;
import com.xinput.unicloud.model.reqeust.image.UniCloudDeleteImageReq;
import com.xinput.unicloud.model.reqeust.image.UniCloudDescribeImageReq;
import com.xinput.unicloud.model.reqeust.image.UniCloudEcsSysSnapshotRollBackReq;
import com.xinput.unicloud.model.reqeust.keypair.UniCloudCreateKeyPairReq;
import com.xinput.unicloud.model.reqeust.keypair.UniCloudDeleteKeyPairReq;
import com.xinput.unicloud.model.reqeust.keypair.UniCloudDescribeKeyPairReq;
import com.xinput.unicloud.model.reqeust.keypair.UniCloudGetVmByKeyPairReq;
import com.xinput.unicloud.model.reqeust.vpc.UniCloudCreateVpcReq;
import com.xinput.unicloud.model.reqeust.vpc.UniCloudDeleteSubnetReq;
import com.xinput.unicloud.model.reqeust.vpc.UniCloudDeleteVpcReq;
import com.xinput.unicloud.model.reqeust.vpc.UniCloudDescribeSubnetReq;
import com.xinput.unicloud.model.reqeust.vpc.UniCloudDescribeVpcReq;
import com.xinput.unicloud.model.response.ecs.UniCloudDeleteEcsResp;
import com.xinput.unicloud.model.response.ecs.UniCloudDesctibeEcsResp;
import com.xinput.unicloud.model.response.ecs.UniCloudDetailEcsResp;
import com.xinput.unicloud.model.response.ecs.UniCloudRunEcsResp;
import com.xinput.unicloud.model.response.ecs.UniCloudStartEcsResp;
import com.xinput.unicloud.model.response.ecs.UniCloudStopEcsResp;
import com.xinput.unicloud.model.response.image.UniCloudCreateEcsSysSnapshotResp;
import com.xinput.unicloud.model.response.image.UniCloudCreateImageResp;
import com.xinput.unicloud.model.response.image.UniCloudDeleteImageResp;
import com.xinput.unicloud.model.response.image.UniCloudDescribeImageResp;
import com.xinput.unicloud.model.response.image.UniCloudEcsSysSnapshotRollBackResp;
import com.xinput.unicloud.model.response.keypair.UniCloudCreateKeyPairResp;
import com.xinput.unicloud.model.response.keypair.UniCloudDeleteKeyPairResp;
import com.xinput.unicloud.model.response.keypair.UniCloudDescribeKeyPairResp;
import com.xinput.unicloud.model.response.keypair.UniCloudGetVmByKeyPairResp;
import com.xinput.unicloud.model.response.vpc.UniCloudCreateVpcResp;
import com.xinput.unicloud.model.response.vpc.UniCloudDeleteSubnetResp;
import com.xinput.unicloud.model.response.vpc.UniCloudDeleteVpcResp;
import com.xinput.unicloud.model.response.vpc.UniCloudDescribeSubnetResp;
import com.xinput.unicloud.model.response.vpc.UniCloudDescribeVpcResp;

import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UniCloudFactory {

    private static Context context;

    public static void init(String ak, String sk) throws ParamException {
        if (StringUtils.isAnyEmpty(ak, sk)) {
            throw new ParamException("ak,sk不能为空");
        }
        context = new Context(ak, sk);
    }

    /**
     * 主机实例
     */
    public static class Ecs {
        /**
         * 查询云主机实例列表
         */
        public static UniCloudDesctibeEcsResp describeEcs(UniCloudDescribeEcsReq uniCloudDescribeEcsReq) throws Exception {
            return JsonUtils.toBean(sendRequest(uniCloudDescribeEcsReq), UniCloudDesctibeEcsResp.class);
        }

        /**
         * 查询云主机实例详情
         */
        public static UniCloudDetailEcsResp detailEcs(UniCloudDetailEcsReq uniCloudDetailEcsReq) throws Exception {
            return JsonUtils.toBean(sendRequest(uniCloudDetailEcsReq), UniCloudDetailEcsResp.class);
        }

        /**
         * 创建云主机
         */
        public static UniCloudRunEcsResp runEcs(UniCloudRunEcsReq uniCloudRunEcsReq) throws Exception {
            return JsonUtils.toBean(sendRequest(uniCloudRunEcsReq), UniCloudRunEcsResp.class);
        }

        /**
         * 对云主机关机
         */
        public static UniCloudStopEcsResp stopEcs(UniCloudStopEcsReq uniCloudStopEcsReq) throws Exception {
            return JsonUtils.toBean(sendRequest(uniCloudStopEcsReq), UniCloudStopEcsResp.class);
        }

        /**
         * 对云主机开机
         */
        public static UniCloudStartEcsResp startEcs(UniCloudStartEcsReq uniCloudStartEcsReq) throws Exception {
            return JsonUtils.toBean(sendRequest(uniCloudStartEcsReq), UniCloudStartEcsResp.class);
        }

        /**
         * 删除云主机
         */
        public static UniCloudDeleteEcsResp deleteECs(UniCloudDeleteEcsReq uniCloudDeleteEcsReq) throws Exception {
            return JsonUtils.toBean(sendRequest(uniCloudDeleteEcsReq), UniCloudDeleteEcsResp.class);
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
         * 删除VPC网络
         */
        public static UniCloudDeleteVpcResp delete(UniCloudDeleteVpcReq deleteVpcReq) throws Exception {
            return JsonUtils.toBean(sendRequest(deleteVpcReq), UniCloudDeleteVpcResp.class);
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
        if (StringUtils.equalsIgnoreCase("GET", action.getMethod())) {
            return HttpUtils.get(urlString);
        }

        if (StringUtils.equalsIgnoreCase("POST", action.getMethod())) {
            return HttpUtils.post(urlString, uniRequest);
        }

        if (StringUtils.equalsIgnoreCase("DELETE", action.getMethod())) {
            return HttpUtils.delete(urlString);
        }

        return null;
    }

    private static String getUrl(UniRequest uniRequest, UniCloudConsts.Action action) throws Exception {
        Map<String, Object> parameters;
        if (StringUtils.equalsIgnoreCase("GET", action.getMethod())) {
            parameters = uniRequest.toMap();
        } else if (StringUtils.equalsIgnoreCase("POST", action.getMethod())) {
            parameters = Maps.newHashMap();
        } else if (StringUtils.equalsIgnoreCase("DELETE", action.getMethod())) {
            parameters = uniRequest.toMap();
        } else {
            return StringUtils.EMPTY;
        }

        // 添加公共参数
        addCommonParams(parameters);
        parameters.put("Action", action.getAction());

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

    /**
     * 组装公共参数
     *
     * @param parameters
     */
    private static void addCommonParams(Map<String, Object> parameters) {
        parameters.put("Format", "json");
        parameters.put("Version", "2020-07-30");
        parameters.put("SignatureMethod", "HMAC-SHA1");
        parameters.put("Timestamp", DateUtils.formatIso8601Date(new Date()));
        parameters.put("SignatureVersion", "1.0");
        parameters.put("SignatureNonce", ObjectId.stringId());
        parameters.put("AccessKeyId", context.getAccessKey());
    }
}
