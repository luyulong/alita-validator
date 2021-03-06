package top.klw8.alita.validator.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.StringUtils;

/**
 * @author klw
 * @ClassName: ValidateUtil
 * @Description: 一些常用效验
 * @date 2018-11-22 09:48:57
 */
public class ValidateUtil {

    /**
     * @param str
     * @param regex
     * @return
     * @Title: checkStrByRegex
     * @Description: 根据正则表达式效验字符串
     */
    public static boolean checkStrByRegex(String str, String regex) {
        return str.matches(regex);
    }

    /**
     * @param ip
     * @return
     * @Title: checkIpFormatting
     * @Description: 检查IP格式是否正确
     */
    public static boolean checkIpFormatting(String ip) {
        String regex = "(2[5][0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})";
        return ip.matches(regex);
    }

    /**
     * @param dateStr
     * @param formatStr
     * @return
     * @Title: checkDateFormatting
     * @Description: 检查传入的字符串是否是指定的日期格式
     */
    public static boolean checkDateFormatting(String dateStr, String formatStr) {
        DateFormat formatter = new SimpleDateFormat(formatStr);
        try {
            formatter.parse(dateStr);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @param lng
     * @param lat
     * @Title: checkLngLatRange
     * @Description: 检查经纬度值是否在经纬度范围内(经度 : - 90 ~ 90, 纬度 : - 180 ~ 180)
     */
    public static boolean checkLatLngRange(Double lat, Double lng) {
        if (lat == null || lng == null) {
            return false;
        }
        if (lat < -180D || lat > 180D || lng < -90D || lng > 90D) {
            return false;
        }
        return true;
    }

    /**
     * @param lng
     * @return
     * @Title: checkLongitudeRange
     * @author klw
     * @Description: 检查经度范围
     */
    public static boolean checkLongitudeRange(Double lng) {
        if (lng == null) {
            return false;
        }
        if (lng < -90D || lng > 90D) {
            return false;
        }
        return true;
    }

    /**
     * @param lat
     * @return
     * @Title: checkLatitudeRange
     * @author klw
     * @Description: 检查纬度范围
     */
    public static boolean checkLatitudeRange(Double lat) {
        if (lat == null) {
            return false;
        }
        if (lat < -180D || lat > 180D) {
            return false;
        }
        return true;
    }


    /**
     * @param mobileNo
     * @return
     * @Title: isMobileNO
     * @Description: 验证手机号格式是否正确
     */
    public static boolean isMobileNO(String mobileNo) {
        String telRegex = "^1[345789]\\d{9}$";
        return checkStringByRegx(mobileNo, telRegex);
    }

    /**
     * @param idCardNo
     * @return
     * @Title: isChinaIdCardNo
     * @Description: 检查是否是身份证号
     */
    public static boolean isChinaIdCardNo(String idCardNo) {
        String idCardRegex = "(^\\d{15}$)|(^\\d{17}([0-9]|X)$)";
        return checkStringByRegx(idCardNo, idCardRegex);
    }

    /**
     * @param str
     * @param regx
     * @return
     * @Title: checkStringByRegx
     * @Description: 根据正则表达式验证字符串
     */
    private static boolean checkStringByRegx(String str, String regx) {
        if (StringUtils.isBlank(str)) {
            return false;
        }
        return str.matches(regx);
    }

    /**
     * @param dateStr
     * @return
     * @Title: checkDateFormatting
     * @Description: 检查日期格式是否是 yyyyMMddHHmmss
     */
    public static boolean checkDateFormatting_yyyyMMddHHmmss(String dateStr) {
        try {
            Long.parseLong(dateStr);
        } catch (Exception e) {
            return false;
        }
        return ValidateUtil.checkDateFormatting(dateStr, "yyyyMMddHHmmss");
    }
}
