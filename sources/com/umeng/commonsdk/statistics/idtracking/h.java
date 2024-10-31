package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;

/* compiled from: NewUMIDTracker.java */
/* loaded from: classes3.dex */
public class h extends a {

    /* renamed from: a */
    private static final String f26420a = "newumid";

    /* renamed from: b */
    private Context f26421b;

    public h(Context context) {
        super(f26420a);
        this.f26421b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return UMEnvelopeBuild.imprintProperty(this.f26421b, com.umeng.commonsdk.proguard.e.f26239f, null);
    }
}
