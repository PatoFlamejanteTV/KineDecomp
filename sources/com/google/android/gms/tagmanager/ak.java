package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.tagmanager.DataLayer;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements DataLayer.b {

    /* renamed from: a, reason: collision with root package name */
    private final Context f2216a;

    public ak(Context context) {
        this.f2216a = context;
    }

    @Override // com.google.android.gms.tagmanager.DataLayer.b
    public void a(Map<String, Object> map) {
        String queryParameter;
        Object obj;
        Object obj2 = map.get("gtm.url");
        Object obj3 = (obj2 == null && (obj = map.get("gtm")) != null && (obj instanceof Map)) ? ((Map) obj).get("url") : obj2;
        if (obj3 == null || !(obj3 instanceof String) || (queryParameter = Uri.parse((String) obj3).getQueryParameter("referrer")) == null) {
            return;
        }
        zzax.a(this.f2216a, queryParameter);
    }
}
