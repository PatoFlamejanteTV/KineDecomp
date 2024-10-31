package com.nexstreaming.app.general.tracelog;

import android.content.Context;
import com.nexstreaming.app.general.util.N;

/* loaded from: classes2.dex */
public class RegisterAppRequest {
    public String app_name;
    public String app_ucode;
    public String app_uuid;
    public String app_version;
    public String device_type;
    public String market_id;
    public String package_name;
    public int version = io.fabric.sdk.android.services.common.a.DEFAULT_TIMEOUT;
    public String os = "ANDROID";
    public String os_version = N.g();
    public String os_build_num = N.f();
    public String model = N.d();
    public String locale = N.e();
    public String maker = N.c();
    public String platform = N.a();

    public RegisterAppRequest(Context context, String str, String str2) {
        this.app_uuid = N.c(context);
        this.app_name = N.a(context);
        this.app_version = N.d(context);
        this.package_name = N.b(context);
        this.app_ucode = str;
        this.device_type = N.e(context);
        this.market_id = str2;
    }
}
