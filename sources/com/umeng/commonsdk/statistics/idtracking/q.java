package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;

/* compiled from: UOPTracker.java */
/* loaded from: classes3.dex */
public class q extends a {

    /* renamed from: a */
    public static final String f26439a = "uopdta";

    /* renamed from: b */
    private static final String f26440b = "uop";

    /* renamed from: c */
    private Context f26441c;

    public q(Context context) {
        super(f26440b);
        this.f26441c = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(this.f26441c);
        return sharedPreferences != null ? sharedPreferences.getString(f26439a, "") : "";
    }
}
