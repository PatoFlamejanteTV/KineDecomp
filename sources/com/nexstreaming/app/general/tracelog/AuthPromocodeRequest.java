package com.nexstreaming.app.general.tracelog;

import android.content.Context;
import com.nexstreaming.app.general.util.z;

/* loaded from: classes.dex */
public class AuthPromocodeRequest {
    public String app_name;
    public String app_ucode;
    public String app_uuid;
    public String app_version;
    public String email;
    public String package_name;
    public String promocode;
    public int version;

    public AuthPromocodeRequest() {
    }

    public AuthPromocodeRequest(Context context, String str, String str2, String str3) {
        this.version = 10000;
        this.app_uuid = z.a(context);
        this.app_name = z.c(context);
        this.app_version = z.e(context);
        this.package_name = z.d(context);
        this.app_ucode = str;
        this.promocode = str2;
        this.email = str3;
    }
}
