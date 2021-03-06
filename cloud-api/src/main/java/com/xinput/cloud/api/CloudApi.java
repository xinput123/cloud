package com.xinput.cloud.api;

import com.xinput.cloud.domain.CloudConfig;
import com.xinput.cloud.domain.req.DeleteEcsReq;
import com.xinput.cloud.domain.req.DescribeEcsReq;
import com.xinput.cloud.domain.req.DetailEcsReq;
import com.xinput.cloud.domain.req.RunEcsReq;
import com.xinput.cloud.domain.req.StartEcsReq;
import com.xinput.cloud.domain.req.StopEcsReq;
import com.xinput.cloud.domain.resp.DeleteEcsResp;
import com.xinput.cloud.domain.resp.DescribeEcsResp;
import com.xinput.cloud.domain.resp.DetailEcsResp;
import com.xinput.cloud.domain.resp.RunEcsResp;
import com.xinput.cloud.domain.resp.StartEcsResp;
import com.xinput.cloud.domain.resp.StopEcsResp;
import com.xinput.cloud.exception.ParamException;

public interface CloudApi {

    /**
     * 初始化配置
     *
     * @param cloudConfig
     * @throws ParamException
     */
    void initCloud(CloudConfig cloudConfig) throws ParamException;

    // 主机实例 API

    /**
     * 云主机实例列表
     *
     * @return
     * @throws Exception exception
     */
    DescribeEcsResp describeEcs(DescribeEcsReq describeEcsReq) throws Exception;

    /**
     * 云主机实例详情
     *
     * @throws Exception exception
     */
    DetailEcsResp detailEcs(DetailEcsReq detailEcsReq) throws Exception;


    /**
     * 购买主机实例（返主机ID）
     *
     * @return
     * @throws Exception exception
     */
    RunEcsResp runEcs(RunEcsReq runEcsReq) throws Exception;

    /**
     * 开机
     *
     * @throws Exception exception
     */
    StartEcsResp startEcs(StartEcsReq startEcsReq) throws Exception;

    /**
     * 关机
     *
     * @throws Exception exception
     */
    StopEcsResp stopEcs(StopEcsReq stopEcsReq) throws Exception;

    /**
     * 重启
     *
     * @throws Exception exception
     */
    void rebootEcs() throws Exception;

    /**
     * 实例改名
     *
     * @throws Exception exception
     */
    void updateEcsName() throws Exception;

    /**
     * 重装操作系统
     *
     * @throws Exception exception
     */
    void rebuildEcs() throws Exception;

    /**
     * 修改密码
     *
     * @throws Exception exception
     */
    void resetEcsPassword() throws Exception;

    /**
     * 释放主机实例
     *
     * @throws Exception exception
     */
    DeleteEcsResp deleteEcs(DeleteEcsReq deleteEcsReq) throws Exception;

    /**
     * 调整配置
     *
     * @throws Exception exception
     */
    void updateEcsConfig() throws Exception;

    /**
     * 获取虚拟机密码
     *
     * @throws Exception exception
     */
    void getEcsPassword() throws Exception;

    /**
     * 系统盘扩容
     *
     * @throws Exception exception
     */
    void resizeEcsSystemDisk() throws Exception;

    /**
     * 监控
     *
     * @throws Exception exception
     */
    void monitor() throws Exception;

    /**
     * 挂载云硬盘
     *
     * @throws Exception exception
     */
    void ecsAttachDisk() throws Exception;

    /**
     * 卸载云硬盘
     *
     * @throws Exception exception
     */
    void ecsDetachDisk() throws Exception;

    // 镜像快照 API

    /**
     * 私有镜像列表
     *
     * @throws Exception exception
     */
    void describeImages() throws Exception;

    /**
     * 创建私有镜像
     *
     * @throws Exception exception
     */
    void createImage() throws Exception;

    /**
     * 释放私有镜像
     *
     * @throws Exception exception
     */
    void deleteImages() throws Exception;

    /**
     * 创建系统盘快照
     *
     * @throws Exception exception
     */
    void createEcsSysSnapshot() throws Exception;

    /**
     * 系统盘快照回滚
     *
     * @throws Exception exception
     */
    void ecsSysSnapshotRollBack() throws Exception;

    // 密钥对 API

    /**
     * 密钥对列表
     *
     * @throws Exception exception
     */
    void describeKeyPairs() throws Exception;

    /**
     * 创建密钥对
     *
     * @throws Exception exception
     */
    void createKeyPair() throws Exception;

    /**
     * 释放密钥对
     *
     * @throws Exception exception
     */
    void deleteKeyPairs() throws Exception;

    /**
     * 密钥对关联的主机
     *
     * @throws Exception exception
     */
    void getEcsByKeyPair() throws Exception;
}
