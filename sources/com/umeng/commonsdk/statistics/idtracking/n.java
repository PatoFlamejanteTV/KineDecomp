package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;

/* compiled from: UMTTThreeTracker.java */
/* loaded from: classes3.dex */
public class n extends a {

    /* renamed from: a */
    private static final String f26433a = "umtt3";

    /* renamed from: b */
    private Context f26434b;

    public n(Context context) {
        super(f26433a);
        this.f26434b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        try {
            Class<?> cls = Class.forName("com.umeng.commonsdk.internal.utils.SDStorageAgent");
            if (cls != null) {
                return (String) cls.getMethod("getUmtt3", Context.class).invoke(cls, this.f26434b);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
