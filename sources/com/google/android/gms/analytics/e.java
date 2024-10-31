package com.google.android.gms.analytics;

import com.google.android.gms.analytics.Tracker;
import java.util.Map;

/* loaded from: classes.dex */
public final class e implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ Map f10344a;

    /* renamed from: b */
    private final /* synthetic */ boolean f10345b;

    /* renamed from: c */
    private final /* synthetic */ String f10346c;

    /* renamed from: d */
    private final /* synthetic */ long f10347d;

    /* renamed from: e */
    private final /* synthetic */ boolean f10348e;

    /* renamed from: f */
    private final /* synthetic */ boolean f10349f;

    /* renamed from: g */
    private final /* synthetic */ String f10350g;

    /* renamed from: h */
    private final /* synthetic */ Tracker f10351h;

    public e(Tracker tracker, Map map, boolean z, String str, long j, boolean z2, boolean z3, String str2) {
        this.f10351h = tracker;
        this.f10344a = map;
        this.f10345b = z;
        this.f10346c = str;
        this.f10347d = j;
        this.f10348e = z2;
        this.f10349f = z3;
        this.f10350g = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Tracker.a aVar;
        aVar = this.f10351h.f10339d;
        aVar.a();
        throw null;
    }
}
