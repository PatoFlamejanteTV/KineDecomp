package com.nexstreaming.kinemaster.mediastore.scanner;

import com.nexstreaming.kinemaster.mediastore.scanner.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AllMediaScanner.java */
/* loaded from: classes.dex */
public class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f21060a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(e eVar) {
        this.f21060a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        e.c cVar;
        this.f21060a.j.removeCallbacks(this);
        cVar = this.f21060a.l;
        if (cVar == null) {
            this.f21060a.f();
        } else {
            this.f21060a.B = true;
        }
    }
}
