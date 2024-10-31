package com.nexstreaming.kinemaster.usage;

import android.app.Activity;
import com.nexstreaming.app.general.util.m;
import com.nexstreaming.kinemaster.usage.a;

/* compiled from: AppForegroundTracker.java */
/* loaded from: classes.dex */
class c implements m.a<a.InterfaceC0079a> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f4406a;
    final /* synthetic */ long b;
    final /* synthetic */ boolean c;
    final /* synthetic */ a d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, Activity activity, long j, boolean z) {
        this.d = aVar;
        this.f4406a = activity;
        this.b = j;
        this.c = z;
    }

    @Override // com.nexstreaming.app.general.util.m.a
    public void a(a.InterfaceC0079a interfaceC0079a) {
        interfaceC0079a.a(this.f4406a, this.b, this.c);
    }
}
