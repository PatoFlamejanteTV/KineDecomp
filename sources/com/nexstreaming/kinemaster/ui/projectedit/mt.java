package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.ui.projectedit.mr;

/* compiled from: VoiceRecordingControler.java */
/* loaded from: classes.dex */
class mt implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4101a;
    final /* synthetic */ ms b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public mt(ms msVar, int i) {
        this.b = msVar;
        this.f4101a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        mr.b bVar;
        int min = (Math.min(this.f4101a, 255) * 10000) / 255;
        bVar = this.b.f4100a.h;
        bVar.a(this.b.f4100a.d(), this.b.f4100a.c(), min);
    }
}
