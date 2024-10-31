package com.nexstreaming.app.general.tracelog;

import android.content.Context;
import com.nexstreaming.app.general.util.z;

/* loaded from: classes.dex */
public class NotifyAppRequest {
    public String app_name;
    public String app_ucode;
    public String app_uuid;
    public String app_version;
    public String locale;
    public String market_id;
    public String model;
    public String os;
    public String os_version;
    public String package_name;
    public int version;

    public NotifyAppRequest() {
    }

    public NotifyAppRequest(Context context, String str, String str2) {
        this.version = 10000;
        this.market_id = str2;
        this.app_uuid = z.a(context);
        this.app_name = z.c(context);
        this.app_version = z.e(context);
        this.package_name = z.d(context);
        this.app_ucode = str;
        this.os = "ANDROID";
        this.os_version = z.b();
        this.model = z.d();
    }
}