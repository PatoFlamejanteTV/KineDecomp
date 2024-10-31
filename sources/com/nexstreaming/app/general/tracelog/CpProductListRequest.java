package com.nexstreaming.app.general.tracelog;

import android.content.Context;
import com.nexstreaming.app.general.util.N;

/* loaded from: classes2.dex */
public class CpProductListRequest {
    public String app_name;
    public String app_ucode;
    public String app_uuid;
    public String app_version;
    public String package_name;
    public String type;
    public String uid;
    public int version;

    public CpProductListRequest() {
    }

    public CpProductListRequest(Context context, String str, String str2, boolean z) {
        this.version = io.fabric.sdk.android.services.common.a.DEFAULT_TIMEOUT;
        this.app_uuid = N.c(context);
        this.app_name = N.a(context);
        this.app_version = N.d(context);
        this.package_name = N.b(context);
        this.app_ucode = str;
        this.uid = str2;
        this.type = z ? "2" : "1";
    }
}
