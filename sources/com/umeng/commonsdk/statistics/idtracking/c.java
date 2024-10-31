package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;

/* compiled from: IDFATracker.java */
/* loaded from: classes3.dex */
public class c extends a {

    /* renamed from: a */
    private static final String f26402a = "idfa";

    /* renamed from: b */
    private Context f26403b;

    public c(Context context) {
        super(f26402a);
        this.f26403b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        String a2 = com.umeng.commonsdk.statistics.common.a.a(this.f26403b);
        return a2 == null ? "" : a2;
    }
}
