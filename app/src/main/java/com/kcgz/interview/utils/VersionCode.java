package com.kcgz.interview.utils;

/**
 * Author:zhao
 * VersionCode:1.0
 * Created by Administrator on 2017/3/24 0024.
 */

public class VersionCode {

    /**
     * 根据版本号判断App是否需要更新
     * （说明：Android-App的版本格式一般为*.*.*.*.*）
     *
     * @param nativeVersion  本地版本号 - 已知
     * @param serviceVersion 服务端版本号
     * @return false:最新版本不需要更新；true:版本不是最新版本需要更新
     */
    public static boolean versionCompara(String nativeVersion, String serviceVersion) {
//        Log.d("versionCode:","本地版本号："+nativeVersion+",服务端版本号："+serviceVersion);
//        System.out.println("本地版本号："+nativeVersion+",服务端版本号："+serviceVersion);
        //版本号为空，不更新
        if (nativeVersion == null || nativeVersion.length() == 0
                || serviceVersion == null || serviceVersion.length() == 0) {
            return false;
        }
        //通过"."将一整个字符串转换为字符串数组
        String[] nativeCodes = nativeVersion.split("\\.");
        String[] serviceCodes = serviceVersion.split("\\.");
        //若本地数组长度大于服务端的长度，不需要更新
        if (nativeCodes.length>serviceCodes.length) {
            return false;
        }
        //逐个版本比较,发现服务端的版本大于本地时，需要更新
        int count=Math.min(nativeCodes.length,serviceCodes.length);
        try{
            for(int i=0;i<count;i++){
                //若版本号中存在负数，不需要更新
                if (Integer.parseInt(serviceCodes[i])<0||Integer.parseInt(nativeCodes[i])<0)
                    return false;
                if(Integer.parseInt(serviceCodes[i])>Integer.parseInt(nativeCodes[i])){
                    return true;
                }
            }
            //若服务端的版本号长度增加，则根据增加的版本号是否大于0判断是否需要更新
            while (count<serviceCodes.length){
                if ( Integer.parseInt(serviceCodes[count])>0){
                    return true;
                }
                count++;
            }
        }catch (NumberFormatException e){
            e.printStackTrace();
            System.out.println("传入的版本号中有不合法的字符");
        }
        return false;
    }

    public static void main(String[] args) {
        //不正常的输入（程序员自己的失误或者网络原因引起的）
        System.out.println(versionCompara(null, null));
        System.out.println(versionCompara("", null));
        System.out.println(versionCompara(null, ""));
        System.out.println(versionCompara("version", "1.0.1"));
        System.out.println(versionCompara("1.0.1", "1.0.-2"));
        //正常情况
        System.out.println(versionCompara("1.0.1", "1.0.1"));
        System.out.println(versionCompara("1.0.1", "1.0.2"));
        System.out.println(versionCompara("1.0.1", "1.0.2.1"));
    }
}
