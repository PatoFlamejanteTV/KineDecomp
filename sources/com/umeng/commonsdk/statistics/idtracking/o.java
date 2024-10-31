package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;

/* compiled from: UMTTTwoTracker.java */
/* loaded from: classes3.dex */
public class o extends a {

    /* renamed from: a */
    private static final String f26435a = "umtt2";

    /* renamed from: b */
    private Context f26436b;

    public o(Context context) {
        super(f26435a);
        this.f26436b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        try {
            Class<?> cls = Class.forName("com.umeng.commonsdk.internal.utils.SDStorageAgent");
            if (cls != null) {
                return (String) cls.getMethod("getUmtt2", Context.class).invoke(cls, this.f26436b);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
