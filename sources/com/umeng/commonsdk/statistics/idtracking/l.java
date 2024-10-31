package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;

/* compiled from: UMTTFourTracker.java */
/* loaded from: classes3.dex */
public class l extends a {

    /* renamed from: a */
    private static final String f26429a = "umtt4";

    /* renamed from: b */
    private Context f26430b;

    public l(Context context) {
        super(f26429a);
        this.f26430b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        try {
            Class<?> cls = Class.forName("com.umeng.commonsdk.internal.utils.SDStorageAgent");
            if (cls != null) {
                return (String) cls.getMethod("getUmtt4", Context.class).invoke(cls, this.f26430b);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
