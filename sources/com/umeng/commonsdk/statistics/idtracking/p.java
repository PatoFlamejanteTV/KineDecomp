package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;

/* compiled from: UMTTZeroTracker.java */
/* loaded from: classes3.dex */
public class p extends a {

    /* renamed from: a */
    private static final String f26437a = "umtt0";

    /* renamed from: b */
    private Context f26438b;

    public p(Context context) {
        super(f26437a);
        this.f26438b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        try {
            Class<?> cls = Class.forName("com.umeng.commonsdk.internal.utils.SDStorageAgent");
            if (cls != null) {
                return (String) cls.getMethod("getUmtt0", Context.class).invoke(cls, this.f26438b);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
