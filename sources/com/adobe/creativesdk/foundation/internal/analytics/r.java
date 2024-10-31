package com.adobe.creativesdk.foundation.internal.analytics;

import android.content.Context;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: AdobeAnalyticsSession.java */
/* loaded from: classes.dex */
public class r {

    /* renamed from: a */
    private static volatile r f4742a;

    /* renamed from: b */
    private Map<Context, s> f4743b = new HashMap();

    public static r a() {
        if (f4742a == null) {
            synchronized (r.class) {
                if (f4742a == null) {
                    f4742a = new r();
                }
            }
        }
        return f4742a;
    }

    public Boolean b() {
        if (this.f4743b.size() == 0) {
            return false;
        }
        return true;
    }

    public void a(String str, Map<String, Object> map) {
        if (b().booleanValue()) {
            Iterator<Context> it = this.f4743b.keySet().iterator();
            while (it.hasNext()) {
                this.f4743b.get(it.next()).a(str, map);
            }
        }
    }
}
