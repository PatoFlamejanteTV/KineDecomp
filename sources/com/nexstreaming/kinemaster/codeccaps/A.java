package com.nexstreaming.kinemaster.codeccaps;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.kinemaster.codeccaps.P;
import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CodecTestCase.java */
/* loaded from: classes.dex */
public class A implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ P f20014a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public A(P p) {
        this.f20014a = p;
    }

    @Override // java.lang.Runnable
    public void run() {
        ResultTask resultTask;
        ResultTask resultTask2;
        ResultTask resultTask3;
        Object obj;
        int i;
        int i2;
        int i3;
        long j;
        resultTask = this.f20014a.F;
        if (resultTask != null) {
            resultTask2 = this.f20014a.F;
            this.f20014a.F = null;
        } else {
            resultTask2 = null;
        }
        resultTask3 = this.f20014a.E;
        if (resultTask3 != null) {
            resultTask2 = this.f20014a.E;
            this.f20014a.E = null;
        }
        if (resultTask2 != null) {
            obj = this.f20014a.f20078h;
            P.b bVar = new P.b(obj);
            i = this.f20014a.q;
            P.b.b(bVar, i);
            i2 = this.f20014a.r;
            i3 = this.f20014a.f20075e;
            P.b.a(bVar, i2, i3);
            long nanoTime = System.nanoTime();
            j = this.f20014a.s;
            P.b.a(bVar, (int) ((nanoTime - j) / 1000000));
            P.b.a(bVar, NexEditor.b.zb);
            resultTask2.sendResult(bVar);
        }
        this.f20014a.a();
    }
}
