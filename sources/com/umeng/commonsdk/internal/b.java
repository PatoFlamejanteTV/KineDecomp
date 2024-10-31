package com.umeng.commonsdk.internal;

import android.content.Context;

/* compiled from: UMInternalData.java */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b */
    private static b f26058b;

    /* renamed from: a */
    private Context f26059a;

    /* renamed from: c */
    private c f26060c;

    private b(Context context) {
        this.f26059a = context;
        this.f26060c = new c(context);
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (f26058b == null) {
                f26058b = new b(context.getApplicationContext());
            }
            bVar = f26058b;
        }
        return bVar;
    }

    public c a() {
        return this.f26060c;
    }
}
