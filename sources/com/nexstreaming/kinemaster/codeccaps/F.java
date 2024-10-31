package com.nexstreaming.kinemaster.codeccaps;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.codeccaps.P;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: CodecTestCase.java */
/* loaded from: classes.dex */
class F implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ G f20055a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public F(G g2) {
        this.f20055a = g2;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        String str;
        int i;
        int i2;
        long j;
        int i3;
        int i4;
        int i5;
        Object obj;
        long j2;
        int i6;
        int i7;
        int i8;
        NexEditor.u uVar;
        int i9;
        NexEditor.u uVar2;
        str = this.f20055a.f20056c.f20057a.f20060c.f20073c;
        MediaInfo a2 = MediaInfo.a(str);
        this.f20055a.f20056c.f20057a.f20060c.c();
        i = this.f20055a.f20056c.f20057a.f20060c.i;
        i2 = this.f20055a.f20056c.f20057a.f20060c.f20076f;
        int i10 = (i * (i2 <= 0 ? 30 : this.f20055a.f20056c.f20057a.f20060c.f20076f)) / 1000;
        long j3 = NexEditor.PerformanceCounter.FRAME_DROP.get();
        j = this.f20055a.f20056c.f20057a.f20060c.y;
        int i11 = (int) (j3 - j);
        i3 = this.f20055a.f20056c.f20057a.f20060c.i;
        i4 = this.f20055a.f20056c.f20057a.f20060c.A;
        int i12 = i3 - i4;
        i5 = this.f20055a.f20056c.f20057a.f20060c.f20076f;
        int i13 = (i11 * 100) / ((i12 * (i5 > 0 ? this.f20055a.f20056c.f20057a.f20060c.f20076f : 30)) / 1000);
        I i14 = this.f20055a.f20056c.f20057a;
        ResultTask resultTask = i14.f20059b;
        obj = i14.f20060c.f20078h;
        P.b bVar = new P.b(obj);
        long nanoTime = System.nanoTime();
        j2 = this.f20055a.f20056c.f20057a.f20060c.s;
        P.b.a(bVar, (int) ((nanoTime - j2) / 1000000));
        P.b.a(bVar);
        i6 = this.f20055a.f20056c.f20057a.f20060c.q;
        P.b.b(bVar, i6);
        i7 = this.f20055a.f20056c.f20057a.f20060c.r;
        i8 = this.f20055a.f20056c.f20057a.f20060c.f20075e;
        P.b.a(bVar, i7, i8);
        P.b.a(bVar, a2);
        uVar = this.f20055a.f20056c.f20057a.f20060c.u;
        P.b.a(bVar, new NexEditor.u(uVar));
        i9 = this.f20055a.f20056c.f20057a.f20060c.o;
        NexEditor.PerformanceCounter performanceCounter = NexEditor.PerformanceCounter.FRAME_DROP;
        uVar2 = this.f20055a.f20056c.f20057a.f20060c.u;
        P.b.a(bVar, i9, i10, performanceCounter.since(uVar2), i13);
        resultTask.sendResult(bVar);
    }
}
