package com.nexstreaming.app.general.tracelog;

import android.content.Context;
import com.nexstreaming.app.general.util.N;

/* loaded from: classes2.dex */
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
        this.version = io.fabric.sdk.android.services.common.a.DEFAULT_TIMEOUT;
        this.market_id = str2;
        this.app_uuid = N.c(context);
        this.app_name = N.a(context);
        this.app_version = N.d(context);
        this.package_name = N.b();
        this.app_ucode = str;
        this.os = "ANDROID";
        this.os_version = N.g();
        this.model = N.d();
    }
}
