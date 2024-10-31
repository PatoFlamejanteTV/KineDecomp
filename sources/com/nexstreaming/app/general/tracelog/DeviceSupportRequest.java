package com.nexstreaming.app.general.tracelog;

import android.content.Context;
import android.os.Build;
import com.nexstreaming.app.general.util.N;

/* loaded from: classes2.dex */
public class DeviceSupportRequest {
    public String app_name;
    public String app_ucode;
    public String app_uuid;
    public String app_version;
    public String os;
    public String os_version;
    public int version = io.fabric.sdk.android.services.common.a.DEFAULT_TIMEOUT;
    public String package_name = N.b();
    public String build_device = Build.DEVICE;
    public String build_model = Build.MODEL;
    public String manufacturer = Build.MANUFACTURER;
    public int os_api_level = Build.VERSION.SDK_INT;
    public String board_platform = N.a();

    public DeviceSupportRequest(Context context, String str) {
        this.app_uuid = N.c(context);
        this.app_name = N.a(context);
        this.app_version = N.d(context);
        this.app_ucode = str;
    }
}
