package com.nexstreaming.kinemaster.codeccaps;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.codeccaps.P;

/* compiled from: CodecTestCase.java */
/* loaded from: classes.dex */
class E implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ G f20054a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public E(G g2) {
        this.f20054a = g2;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        Object obj;
        int i;
        int i2;
        int i3;
        long j;
        this.f20054a.f20056c.f20057a.f20060c.c();
        I i4 = this.f20054a.f20056c.f20057a;
        ResultTask resultTask = i4.f20059b;
        obj = i4.f20060c.f20078h;
        P.b bVar = new P.b(obj);
        i = this.f20054a.f20056c.f20057a.f20060c.q;
        P.b.b(bVar, i);
        i2 = this.f20054a.f20056c.f20057a.f20060c.r;
        i3 = this.f20054a.f20056c.f20057a.f20060c.f20075e;
        P.b.a(bVar, i2, i3);
        long nanoTime = System.nanoTime();
        j = this.f20054a.f20056c.f20057a.f20060c.s;
        P.b.a(bVar, (int) ((nanoTime - j) / 1000000));
        P.b.a(bVar, taskError);
        resultTask.sendResult(bVar);
    }
}
