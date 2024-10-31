package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* compiled from: ImeiTracker.java */
/* loaded from: classes3.dex */
public class f extends a {

    /* renamed from: a */
    private static final String f26416a = "imei";

    /* renamed from: b */
    private Context f26417b;

    public f(Context context) {
        super(f26416a);
        this.f26417b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfig.getImeiNew(this.f26417b);
    }
}
