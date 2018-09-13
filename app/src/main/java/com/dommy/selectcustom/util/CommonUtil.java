package com.dommy.selectcustom.util;

import android.widget.CheckBox;

import java.util.List;

/**
 * 通用工具类
 */
public class CommonUtil {

    /**
     * 取消checkbox选中状态
     *
     * @param checkBoxList 复选框列表
     */
    public static void unCheck(List<CheckBox> checkBoxList) {
        for (CheckBox chb : checkBoxList) {
            chb.setChecked(false);
        }
    }

    /**
     * 选中checkbox
     *
     * @param checkBoxList 复选框列表
     */
    public static void checkOne(List<CheckBox> checkBoxList, String tag) {
        unCheck(checkBoxList);
        for (CheckBox chb : checkBoxList) {
            if (chb.getTag() == null) {
                continue;
            }
            if (chb.getTag().toString().equals(tag)) {
                chb.setChecked(true);
            }
        }
    }

    /**
     * 选中多个checkbox
     *
     * @param checkBoxList
     * @param values       值
     */
    public static void checkMany(List<CheckBox> checkBoxList, String values) {
        if (values == null || values.length() == 0) {
            return;
        }
        unCheck(checkBoxList);
        String[] strArray = values.split(",");
        for (CheckBox chb : checkBoxList) {
            if (chb.getTag() == null) {
                continue;
            }
            String tag = chb.getTag().toString();
            if (isContains(strArray, tag)) {
                chb.setChecked(true);
            }
        }
    }

    /**
     * 获取单选值
     *
     * @param checkBoxList
     * @return String 单选值
     */
    public static String getOne(List<CheckBox> checkBoxList) {
        String tag = "";
        for (CheckBox chb : checkBoxList) {
            if (chb.getTag() == null) {
                continue;
            }
            if (chb.isChecked()) {
                tag = chb.getTag().toString();
                break;
            }
        }
        return tag;
    }

    /**
     * 获取多选值
     *
     * @param checkBoxList
     * @return String 多个值结合，逗号分隔
     */
    public static String getMany(List<CheckBox> checkBoxList) {
        StringBuffer sb = new StringBuffer();
        for (CheckBox chb : checkBoxList) {
            if (chb.getTag() == null) {
                continue;
            }
            if (chb.isChecked()) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(chb.getTag().toString());
            }
        }
        return sb.toString();
    }

    /**
     * 判断集合中是否包含特定值
     *
     * @param strArray
     * @param value
     * @return
     */
    private static boolean isContains(String[] strArray, String value) {
        if (strArray == null || strArray.length == 0) {
            return false;
        }
        if (value == null || value.length() == 0) {
            return false;
        }
        for (String str : strArray) {
            if (str == null) {
                continue;
            }
            if (str.trim().equals(value)) {
                return true;
            }
        }
        return false;
    }

}
