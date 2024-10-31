package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.tagmanager.DataLayer;
import java.util.Map;

/* loaded from: classes2.dex */
public final class z implements DataLayer.b {

    /* renamed from: a */
    private final Context f14221a;

    public z(Context context) {
        this.f14221a = context;
    }

    @Override // com.google.android.gms.tagmanager.DataLayer.b
    public final void a(Map<String, Object> map) {
        String queryParameter;
        Object obj;
        Object obj2 = map.get("gtm.url");
        if (obj2 == null && (obj = map.get("gtm")) != null && (obj instanceof Map)) {
            obj2 = ((Map) obj).get("url");
        }
        if (obj2 == null || !(obj2 instanceof String) || (queryParameter = Uri.parse((String) obj2).getQueryParameter("referrer")) == null) {
            return;
        }
        zzcw.b(this.f14221a, queryParameter);
    }
}
