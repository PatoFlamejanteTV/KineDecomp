package com.nexstreaming.app.general.tracelog;

import android.content.Context;
import com.nexstreaming.app.general.util.N;

/* loaded from: classes2.dex */
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
        this.version = io.fabric.sdk.android.services.common.a.DEFAULT_TIMEOUT;
        this.app_uuid = N.c(context);
        this.app_name = N.a(context);
        this.app_version = N.d(context);
        this.package_name = N.b();
        this.app_ucode = str;
        this.promocode = str2;
        this.email = str3;
    }
}
