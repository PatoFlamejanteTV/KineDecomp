package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;

/* compiled from: UMTTOneTracker.java */
/* loaded from: classes3.dex */
public class m extends a {

    /* renamed from: a */
    private static final String f26431a = "umtt1";

    /* renamed from: b */
    private Context f26432b;

    public m(Context context) {
        super(f26431a);
        this.f26432b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        try {
            Class<?> cls = Class.forName("com.umeng.commonsdk.internal.utils.SDStorageAgent");
            if (cls != null) {
                return (String) cls.getMethod("getUmtt1", Context.class).invoke(cls, this.f26432b);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
