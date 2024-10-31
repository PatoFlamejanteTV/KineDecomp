package com.qq.e.comm.constants;

import com.qq.e.ads.ADActivity;
import com.qq.e.ads.LandscapeADActivity;
import com.qq.e.ads.PortraitADActivity;
import com.qq.e.comm.DownloadService;

/* loaded from: classes3.dex */
public class CustomPkgConstants {

    /* renamed from: a */
    private static final String f24946a = DownloadService.class.getName();

    /* renamed from: b */
    private static final String f24947b = ADActivity.class.getName();

    /* renamed from: c */
    private static final String f24948c = PortraitADActivity.class.getName();

    /* renamed from: d */
    private static final String f24949d = LandscapeADActivity.class.getName();

    public static String getADActivityName() {
        return f24947b;
    }

    public static String getAssetPluginDir() {
        return "gdt_plugin";
    }

    public static String getAssetPluginName() {
        return "gdtadv2.jar";
    }

    public static String getAssetPluginXorKey() {
        return "";
    }

    public static String getDownLoadServiceName() {
        return f24946a;
    }

    public static String getLandscapeADActivityName() {
        return f24949d;
    }

    public static String getPortraitADActivityName() {
        return f24948c;
    }
}
