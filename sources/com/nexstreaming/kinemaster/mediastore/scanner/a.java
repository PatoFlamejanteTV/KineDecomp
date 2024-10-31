package com.nexstreaming.kinemaster.mediastore.scanner;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.scanner.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AllMediaScanner.java */
/* loaded from: classes.dex */
public class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f21055a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(e eVar) {
        this.f21055a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        e.c cVar;
        boolean z2;
        z = this.f21055a.f21065d;
        if (z) {
            this.f21055a.f21065d = false;
            this.f21055a.f21064c = true;
        }
        cVar = this.f21055a.l;
        if (cVar == null || this.f21055a.m == null) {
            return;
        }
        this.f21055a.l = null;
        if (this.f21055a.m != null) {
            this.f21055a.m.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
        }
        this.f21055a.m = null;
        z2 = this.f21055a.B;
        if (z2) {
            this.f21055a.B = false;
            this.f21055a.f();
        }
    }
}
