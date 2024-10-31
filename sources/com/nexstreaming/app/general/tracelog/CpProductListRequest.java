package com.nexstreaming.app.general.tracelog;

import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import com.nexstreaming.app.general.util.z;

/* loaded from: classes.dex */
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
        this.version = 10000;
        this.app_uuid = z.a(context);
        this.app_name = z.c(context);
        this.app_version = z.e(context);
        this.package_name = z.d(context);
        this.app_ucode = str;
        this.uid = str2;
        this.type = z ? "2" : AppEventsConstants.EVENT_PARAM_VALUE_YES;
    }
}
