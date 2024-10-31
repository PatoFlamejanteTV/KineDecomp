package com.nexstreaming.kinemaster.mediastore.v2.scanner;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.v2.scanner.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AllMediaScanner.java */
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f3610a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f3610a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        a.c cVar;
        boolean z2;
        z = this.f3610a.d;
        if (z) {
            this.f3610a.d = false;
            this.f3610a.c = true;
        }
        cVar = this.f3610a.k;
        if (cVar != null && this.f3610a.l != null) {
            this.f3610a.k = null;
            if (this.f3610a.l != null) {
                this.f3610a.l.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
            }
            this.f3610a.l = null;
            z2 = this.f3610a.A;
            if (z2) {
                this.f3610a.A = false;
                this.f3610a.g();
            }
        }
    }
}
