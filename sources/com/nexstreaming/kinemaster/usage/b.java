package com.nexstreaming.kinemaster.usage;

import android.app.Activity;
import com.nexstreaming.app.general.util.u;
import com.nexstreaming.kinemaster.usage.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppForegroundTracker.java */
/* loaded from: classes2.dex */
public class b implements u.a<c.a> {

    /* renamed from: a */
    final /* synthetic */ Activity f23921a;

    /* renamed from: b */
    final /* synthetic */ long f23922b;

    /* renamed from: c */
    final /* synthetic */ boolean f23923c;

    /* renamed from: d */
    final /* synthetic */ c f23924d;

    public b(c cVar, Activity activity, long j, boolean z) {
        this.f23924d = cVar;
        this.f23921a = activity;
        this.f23922b = j;
        this.f23923c = z;
    }

    @Override // com.nexstreaming.app.general.util.u.a
    public void a(c.a aVar) {
        aVar.a(this.f23921a, this.f23922b, this.f23923c);
    }
}
