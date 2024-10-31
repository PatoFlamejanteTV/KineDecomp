package com.nexstreaming.kinemaster.codeccaps;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.kinemaster.codeccaps.P;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: CodecTestCase.java */
/* loaded from: classes.dex */
class L implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f20066a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ M f20067b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public L(M m, int i) {
        this.f20067b = m;
        this.f20066a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        NexEditor.u uVar;
        long j;
        int i3;
        int i4;
        int i5;
        Object obj;
        int i6;
        int i7;
        long j2;
        int i8;
        int i9;
        NexEditor.u uVar2;
        ResultTask resultTask;
        ResultTask resultTask2;
        this.f20067b.f20068a.c();
        i = this.f20067b.f20068a.i;
        i2 = this.f20067b.f20068a.f20076f;
        int i10 = (i * (i2 <= 0 ? 30 : this.f20067b.f20068a.f20076f)) / 1000;
        NexEditor.PerformanceCounter performanceCounter = NexEditor.PerformanceCounter.FRAME_DROP;
        uVar = this.f20067b.f20068a.u;
        long since = performanceCounter.since(uVar);
        long j3 = NexEditor.PerformanceCounter.FRAME_DROP.get();
        j = this.f20067b.f20068a.y;
        int i11 = (int) (j3 - j);
        i3 = this.f20067b.f20068a.i;
        i4 = this.f20067b.f20068a.A;
        int i12 = i3 - i4;
        i5 = this.f20067b.f20068a.f20076f;
        int i13 = (i11 * 100) / ((i12 * (i5 > 0 ? this.f20067b.f20068a.f20076f : 30)) / 1000);
        obj = this.f20067b.f20068a.f20078h;
        P.b bVar = new P.b(obj);
        P.b.a(bVar);
        i6 = this.f20067b.f20068a.r;
        i7 = this.f20067b.f20068a.f20075e;
        P.b.a(bVar, i6, i7);
        long nanoTime = System.nanoTime();
        j2 = this.f20067b.f20068a.s;
        P.b.a(bVar, (int) ((nanoTime - j2) / 1000000));
        i8 = this.f20067b.f20068a.q;
        P.b.b(bVar, i8);
        i9 = this.f20067b.f20068a.r;
        P.b.a(bVar, i9, 0);
        uVar2 = this.f20067b.f20068a.u;
        P.b.a(bVar, new NexEditor.u(uVar2));
        P.b.a(bVar, this.f20066a, i10, since, i13);
        resultTask = this.f20067b.f20068a.E;
        if (resultTask != null) {
            resultTask2 = this.f20067b.f20068a.E;
            resultTask2.sendResult(bVar);
        }
        this.f20067b.f20068a.E = null;
    }
}
