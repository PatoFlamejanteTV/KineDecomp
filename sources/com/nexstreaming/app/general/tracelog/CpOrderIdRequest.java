package com.nexstreaming.app.general.tracelog;

import android.content.Context;
import com.nexstreaming.app.general.util.z;

/* loaded from: classes.dex */
public class CpOrderIdRequest {
    public String app_name;
    public String app_ucode;
    public String app_uuid;
    public String app_version;
    public String market_id;
    public String package_name;
    public String payload;
    public int productcode_idx;
    public String uid;
    public int version;

    public CpOrderIdRequest() {
        this.payload = null;
    }

    public CpOrderIdRequest(Context context, String str, String str2, String str3, int i, String str4) {
        this.payload = null;
        this.version = 10000;
        this.app_uuid = z.a(context);
        this.app_name = z.c(context);
        this.app_version = z.e(context);
        this.package_name = z.d(context);
        this.app_ucode = str;
        this.uid = str3;
        this.productcode_idx = i;
        this.market_id = str2;
        this.payload = str4;
    }
}
