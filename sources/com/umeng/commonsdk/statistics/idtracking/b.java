package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* compiled from: AndroidIdTracker.java */
/* loaded from: classes3.dex */
public class b extends a {

    /* renamed from: a */
    private static final String f26400a = "android_id";

    /* renamed from: b */
    private Context f26401b;

    public b(Context context) {
        super(f26400a);
        this.f26401b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfig.getAndroidId(this.f26401b);
    }
}
