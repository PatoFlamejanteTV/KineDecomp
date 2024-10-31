package com.nexstreaming.app.general.tracelog;

import android.content.Context;
import com.nexstreaming.app.general.util.z;

/* loaded from: classes.dex */
public class RegisterIAPRequest {
    public String app_name;
    public String app_ucode;
    public String app_uuid;
    public String app_version;
    public String market_id;
    public String order_id;
    public String package_name;
    public String subscription_id;
    public String token;
    public int version;

    public RegisterIAPRequest() {
    }

    public RegisterIAPRequest(Context context, String str, String str2, String str3, String str4, String str5) {
        this.version = 10000;
        this.app_uuid = z.a(context);
        this.app_name = z.c(context);
        this.app_version = z.e(context);
        this.package_name = z.d(context);
        this.app_ucode = str;
        this.order_id = str2;
        this.token = str3;
        this.subscription_id = str4;
        this.market_id = str5;
    }
}
