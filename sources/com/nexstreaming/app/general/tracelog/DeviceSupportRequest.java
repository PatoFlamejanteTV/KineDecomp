package com.nexstreaming.app.general.tracelog;

import android.content.Context;
import android.os.Build;
import com.nexstreaming.app.general.util.z;

/* loaded from: classes.dex */
public class DeviceSupportRequest {
    public String app_name;
    public String app_ucode;
    public String app_uuid;
    public String app_version;
    public String os;
    public String os_version;
    public String package_name;
    public int version = 10000;
    public String build_device = Build.DEVICE;
    public String build_model = Build.MODEL;
    public String manufacturer = Build.MANUFACTURER;
    public int os_api_level = Build.VERSION.SDK_INT;
    public String board_platform = z.g();

    public DeviceSupportRequest(Context context, String str) {
        this.app_uuid = z.a(context);
        this.app_name = z.c(context);
        this.app_version = z.e(context);
        this.package_name = z.d(context);
        this.app_ucode = str;
    }
}
