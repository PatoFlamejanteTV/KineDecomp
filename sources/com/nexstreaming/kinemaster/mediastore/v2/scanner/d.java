package com.nexstreaming.kinemaster.mediastore.v2.scanner;

import com.nexstreaming.kinemaster.mediastore.v2.scanner.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AllMediaScanner.java */
/* loaded from: classes.dex */
public class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f3612a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.f3612a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.c cVar;
        this.f3612a.i.removeCallbacks(this);
        cVar = this.f3612a.k;
        if (cVar != null) {
            this.f3612a.A = true;
        } else {
            this.f3612a.g();
        }
    }
}
