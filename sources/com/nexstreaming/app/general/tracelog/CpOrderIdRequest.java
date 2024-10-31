package com.nexstreaming.app.general.tracelog;

import android.content.Context;
import com.nexstreaming.app.general.util.N;

/* loaded from: classes2.dex */
public class CpOrderIdRequest {
    public String app_name;
    public String app_ucode;
    public String app_uuid;
    public String app_version;
    public String edition;
    public String market_id;
    public String package_name;
    public String payload;
    public String productId;
    public int purchaseType;
    public String uid;
    public int version;

    public CpOrderIdRequest() {
        this.payload = null;
    }

    public CpOrderIdRequest(Context context, String str, String str2, String str3, String str4, int i, String str5, String str6) {
        this.payload = null;
        this.version = io.fabric.sdk.android.services.common.a.DEFAULT_TIMEOUT;
        this.app_uuid = N.c(context);
        this.app_name = N.a(context);
        this.app_version = N.d(context);
        this.package_name = N.b(context);
        this.app_ucode = str;
        this.uid = str3;
        this.productId = str4;
        this.market_id = str2;
        this.purchaseType = i;
        this.edition = str5;
        this.payload = str6;
    }
}
