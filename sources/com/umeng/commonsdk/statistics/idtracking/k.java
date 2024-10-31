package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;

/* compiled from: UMTTFiveTracker.java */
/* loaded from: classes3.dex */
public class k extends a {

    /* renamed from: a */
    private static final String f26427a = "umtt5";

    /* renamed from: b */
    private Context f26428b;

    public k(Context context) {
        super(f26427a);
        this.f26428b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        try {
            Class<?> cls = Class.forName("com.umeng.commonsdk.internal.utils.SDStorageAgent");
            if (cls != null) {
                return (String) cls.getMethod("getUmtt5", Context.class).invoke(cls, this.f26428b);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
