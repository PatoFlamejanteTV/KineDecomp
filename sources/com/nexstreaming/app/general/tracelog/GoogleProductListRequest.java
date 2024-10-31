package com.nexstreaming.app.general.tracelog;

import android.content.Context;
import com.nexstreaming.app.general.util.z;

/* loaded from: classes.dex */
public class GoogleProductListRequest {
    public String app_name;
    public String app_ucode;
    public String app_uuid;
    public String app_version;
    public String package_name;
    public int version;

    public GoogleProductListRequest() {
    }

    public GoogleProductListRequest(Context context, String str) {
        this.version = 10000;
        this.app_uuid = z.a(context);
        this.app_name = z.c(context);
        this.app_version = z.e(context);
        this.package_name = z.d(context);
        this.app_ucode = str;
    }
}
