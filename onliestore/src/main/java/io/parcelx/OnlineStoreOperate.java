package io.parcelx;

import io.parcelx.jsonrpc.ApiException;
import io.parcelx.open.api.sdk.v1.model.*;
import io.parcelx.utils.Constants;
import io.parcelx.open.api.sdk.v1.ECommerceApi;
import io.parcelx.utils.JsonConverterUtil;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;

/**
 * 电商相关操作基本调用
 *
 * @author xinfeng
 * @version 1.0
 * @Description
 * @date 2019/7/23 17:34
 */
public class OnlineStoreOperate {

    public static void main(String[] args) {
        // 1.上传包裹
        createParcel();
        // 2.确认包裹上传 如果按在第一步上传时开始自动确认，则无需调用该方法
        //placeOrder();
        // 3.获取包裹面单
        //getLabel();
        // 4.获取追踪信息
        //getLabel();
        // 5.修复包裹异常数据
        //fixException();
        // 6.电商确认服务完成
        //confirmServiceComplete();
    }

    /**
     * 包裹确认收件完成
     *
     * @date 2019/7/29 15:35
     */
    public static void confirmServiceComplete() {
        try {
            // 创建编号参数
            ParcelNoParam parcelNoParam = new ParcelNoParam();
            // 编号类型，默认是parcelNo
            parcelNoParam.setType(ParcelNoType.ParcelNo);
            // 设置编号
            parcelNoParam.setValue("PX2492922d2803000");
            // 执行成功后无返回结果，不抛异常，即为正常执行
            getProviderApi().confirmServiceComplete(parcelNoParam);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    /**
     * 修复包裹异常
     *
     * @date 2019/7/29 15:17
     */
    public static void fixException() {
        try {
            // 创建编号参数
            ParcelNoParam parcelNoParam = new ParcelNoParam();
            // 编号类型，默认是parcelNo
            parcelNoParam.setType(ParcelNoType.ParcelNo);
            // 设置编号
            parcelNoParam.setValue("PX2492922d2803000");
            // 创建修复包裹参数，与创建包裹参数一样的
            FixParcelInfoParam fixParcelInfoParam = new FixParcelInfoParam();
            // 支付公司
            fixParcelInfoParam.setPaymentCompanyName("alili");
            // 执行成功后无返回结果，不抛异常，即为正常执行
            getProviderApi().fixException(parcelNoParam, fixParcelInfoParam);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取包裹追踪信息
     *
     * @date 2019/7/29 15:34
     */
    public static void getTracking() {
        try {
            // 创建编号参数
            ParcelNoParam parcelNoParam = new ParcelNoParam();
            // 编号类型，默认是parcelNo
            parcelNoParam.setType(ParcelNoType.ParcelNo);
            // 设置编号
            parcelNoParam.setValue("PX2492922d2803000");
            // 返回结果
            ParcelTrackingResult result = getProviderApi().getTracking(parcelNoParam);
            // 转换Json字符串输出
            JsonConverterUtil.getJsonString(result);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取包裹面单信息
     *
     * @date 2019/7/29 14:30
     */
    public static void getLabel() {
        try {
            // 创建编号参数
            ParcelNoParam parcelNoParam = new ParcelNoParam();
            // 编号类型，默认是parcelNo
            parcelNoParam.setType(ParcelNoType.ParcelNo);
            // 设置编号
            parcelNoParam.setValue("PX2492922d2803000");
            // 返回结果
            ParcelLabelResult result = getProviderApi().getLabel(parcelNoParam);
            // 转换Json字符串输出
            JsonConverterUtil.getJsonString(result);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    /**
     * 确认包裹上传
     *
     * @date 2019/7/29 12:14
     */
    public static void placeOrder() {
        try {
            // 创建编号参数
            ParcelNoParam parcelNoParam = new ParcelNoParam();
            // 编号类型，默认是parcelNo
            parcelNoParam.setType(ParcelNoType.ParcelNo);
            // 设置编号
            parcelNoParam.setValue("PX2492922d2803000");
            // 执行成功后无返回结果，不抛异常，即为正常执行
            getProviderApi().placeOrder(parcelNoParam);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    /**
     * 上传包裹
     *
     * @date 2019/7/29 11:50
     */
    public static void createParcel() {
        try {
            // 封装一个包裹参数实体
            CreateParcelParam createParcelParam = getCreateParcelParam();
            // 调用上传  true表示自动确定包裹即下单，false则不自动确认包裹，需手动确认下单
            ParcelCreationResult result = getProviderApi().createParcel(createParcelParam, false);
            // 转换Json字符串输出
            JsonConverterUtil.getJsonString(result);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    // 创建一个包裹上传的参数
    private static CreateParcelParam getCreateParcelParam() {
        CreateParcelParam createParcelParam = new CreateParcelParam();
        createParcelParam.setRouteCode("UBI.CN2AU.AUPOST");
        createParcelParam.setOnlineOrderNo("order0005152976003");
        createParcelParam.setFacility("230031");
        createParcelParam.setLot("235231232");
        createParcelParam.setSkuNumber(2);
        createParcelParam.setVolume(new BigDecimal(0));
        createParcelParam.setGrossWeight(new BigDecimal(2.1));
        createParcelParam.setNetWeight(new BigDecimal(2));
        createParcelParam.setItemAmount(new BigDecimal(10));
        createParcelParam.setTradeCountry("AU");
        createParcelParam.setPayerLegalName("蒋英语");
        createParcelParam.setPayerIdType("1");
        createParcelParam.setPayerIdNo("440501195305174406");
        createParcelParam.setPayerPhone("15024566166");
        createParcelParam.setPayerIdPicture("https://www.leangoo.com/kanban/task/downloadFile/2744320/bbe0132a64eed9ab/454618");
        createParcelParam.setPayerIdPicture2("https://www.leangoo.com/kanban/task/downloadFile/2744320/bbe0132a64eed9ab/454618");
        createParcelParam.setPaymentCompanyName("哎呀巴巴");
        createParcelParam.setPaymentCompanyCode("ayabb");
        createParcelParam.setPaymentOrderNo("ayabb2912783");
        createParcelParam.setPaymentTime(Instant.now());
        createParcelParam.setPaymentAmount(new BigDecimal(10));
        createParcelParam.setSenderIdType("1");
        createParcelParam.setSenderIdNo("440501195305174406");
        createParcelParam.setSenderIdcardBack("https://www.leangoo.com/kanban/task/downloadFile/2744320/bbe0132a64eed9ab/454618");
        createParcelParam.setSenderIdcardFront("https://www.leangoo.com/kanban/task/downloadFile/2744320/bbe0132a64eed9ab/454618");
        createParcelParam.setSenderCountryCode("AUD");
        createParcelParam.setSenderPrimaryAdministrative("北京市");
        createParcelParam.setSenderSecondAdministrative("北京市");
        createParcelParam.setSenderAddress("朝阳区");
        createParcelParam.setSenderStreetNum("102号");
        createParcelParam.setSenderCompanyName("ayabba");
        createParcelParam.setSenderName("cxk");
        createParcelParam.setSenderPhone("28231231241");
        createParcelParam.setSenderEmail("2723923@ayabba.com");
        createParcelParam.setRecipientIdType("1");
        createParcelParam.setRecipientIdNo("41358965746685");
        createParcelParam.setRecipientPrimaryAdministrative("beijing");
        createParcelParam.setRecipientSecondAdministrative("beiing");
        createParcelParam.setRecipientThirdAdministrative("beijing");
        createParcelParam.setRecipientAddress("1024号2048栋");
        createParcelParam.setRecipientStreetNum("4096");
        createParcelParam.setRecipientPostcode("3927123");
        createParcelParam.setRecipientCompanyName("上海五幺店子");
        createParcelParam.setRecipientName("前台");
        createParcelParam.setRecipientPhone("17606060066");
        createParcelParam.setRecipientEmail("codeem@163.com");
        createParcelParam.setReturnPostcode("1923");
        createParcelParam.setReturnStreetNum("2048");
        createParcelParam.setReturnAddress("2048号4096栋");
        createParcelParam.setReturnPrimaryAdministrative("shanghai");
        createParcelParam.setReturnSecondAdministrative("shanghai");
        createParcelParam.setReturnCountryCode("AUD");
        createParcelParam.setReturnEmail("283129@we.com");
        createParcelParam.setReturnPhone("18230292315");
        createParcelParam.setReturnName("江影");
        createParcelParam.setReturnCompanyName("个体商户");
        createParcelParam.setReturnType("back_to_owner");
        createParcelParam.setBuyerEcAccount("5555520");
        createParcelParam.setBuyerFullName("5520");
        createParcelParam.setBuyerPhone("1877878887");
        createParcelParam.setBuyerIdType("1");
        createParcelParam.setBuyerIdNo("2478694584368");
        createParcelParam.setBuyerIdPicture("https://www.leangoo.com/kanban/task/downloadFile/2744320/bbe0132a64eed9ab/454618");
        createParcelParam.setBuyerIdPicture2("https://www.leangoo.com/kanban/task/downloadFile/2744320/bbe0132a64eed9ab/454618");
        createParcelParam.setPredictPutTime(Instant.now());
        createParcelParam.setNeedSignature(0);
        createParcelParam.setEbcName("ayababa");
        createParcelParam.setEbcCode("sku-10001");
        createParcelParam.setEbpName("晤曜");
        createParcelParam.setEbpCode("292215123");
        createParcelParam.setIsDangerous(false);
        ArrayList<ParcelItem> items = new ArrayList<>();
        ParcelItem parcelItemsParam = new ParcelItem();
        parcelItemsParam.setItemNo("I2237123521");
        parcelItemsParam.setHsCode("201907291141");
        parcelItemsParam.setBarCode("829238129523");
        parcelItemsParam.setBrand("可口可乐");
        parcelItemsParam.setProductName("可口可乐");
        parcelItemsParam.setNativeProductName("可口可乐");
        parcelItemsParam.setProductDescription("三瓶可口可乐");
        parcelItemsParam.setProductUnit("瓶");
        parcelItemsParam.setUrl("http://www.baidu.com/");
        parcelItemsParam.setOrigin("USA");
        parcelItemsParam.setSpecification("nostrud ullamco qui");
        parcelItemsParam.setGrossWeight(new BigDecimal(2.1));
        parcelItemsParam.setNetWeight(new BigDecimal(2));
        parcelItemsParam.setUnitPrice(new BigDecimal(10));
        parcelItemsParam.setCurrency("CNY");
        parcelItemsParam.setQuantity(1);
        items.add(parcelItemsParam);
        createParcelParam.setItems(items);
        return createParcelParam;
    }

    private static ECommerceApi getProviderApi() {
        return new ECommerceApi(Constants.url, Constants.apiKey, Constants.apiSecret);
    }
}
