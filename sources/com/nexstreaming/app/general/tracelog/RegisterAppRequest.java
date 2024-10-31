package com.nexstreaming.app.general.tracelog;

import android.content.Context;
import com.nexstreaming.app.general.util.z;

/* loaded from: classes.dex */
public class RegisterAppRequest {
    public String app_name;
    public String app_ucode;
    public String app_uuid;
    public String app_version;
    public String device_type;
    public String market_id;
    public String package_name;
    public int version = 10000;
    public String os = "ANDROID";
    public String os_version = z.b();
    public String os_build_num = z.c();
    public String model = z.d();
    public String locale = z.a();
    public String maker = z.e();
    public String platform = z.f();

    public RegisterAppRequest(Context context, String str, String str2) {
        this.app_uuid = z.a(context);
        this.app_name = z.c(context);
        this.app_version = z.e(context);
        this.package_name = z.d(context);
        this.app_ucode = str;
        this.device_type = z.b(context);
        this.market_id = str2;
    }
}
