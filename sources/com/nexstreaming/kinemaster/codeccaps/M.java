package com.nexstreaming.kinemaster.codeccaps;

import android.os.Handler;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.kinemaster.codeccaps.P;
import com.nextreaming.nexvideoeditor.NexEditor;
import com.nextreaming.nexvideoeditor.ha;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CodecTestCase.java */
/* loaded from: classes.dex */
public class M implements ha {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ P f20068a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public M(P p) {
        this.f20068a = p;
    }

    @Override // com.nextreaming.nexvideoeditor.ha
    public void a() {
        int i;
        ResultTask resultTask;
        this.f20068a.k = true;
        i = this.f20068a.o;
        resultTask = this.f20068a.E;
        if (resultTask != null) {
            new Handler().postDelayed(new L(this, i), 100L);
        }
    }

    @Override // com.nextreaming.nexvideoeditor.ha
    public void a(int i) {
    }

    @Override // com.nextreaming.nexvideoeditor.ha
    public void a(int i, int i2) {
    }

    @Override // com.nextreaming.nexvideoeditor.ha
    public void a(int i, int i2, int i3) {
    }

    @Override // com.nextreaming.nexvideoeditor.ha
    public void a(NexEditor.PlayState playState, NexEditor.PlayState playState2) {
    }

    @Override // com.nextreaming.nexvideoeditor.ha
    public void a(NexEditor.b bVar) {
    }

    @Override // com.nextreaming.nexvideoeditor.ha
    public void a(NexEditor.b bVar, int i, int i2) {
    }

    @Override // com.nextreaming.nexvideoeditor.ha
    public void a(boolean z) {
    }

    @Override // com.nextreaming.nexvideoeditor.ha
    public void b() {
    }

    @Override // com.nextreaming.nexvideoeditor.ha
    public void b(int i) {
        int i2;
        long j;
        long j2;
        ResultTask resultTask;
        ResultTask resultTask2;
        int i3;
        i2 = this.f20068a.i;
        if (i > i2 - 33) {
            this.f20068a.k = true;
        }
        j = this.f20068a.B;
        if (j <= 0) {
            this.f20068a.B = System.nanoTime();
        }
        long nanoTime = System.nanoTime();
        j2 = this.f20068a.B;
        if ((nanoTime - j2) / 1000000 > 5000) {
            this.f20068a.B = System.nanoTime();
            resultTask = this.f20068a.F;
            if (resultTask != null) {
                resultTask2 = this.f20068a.F;
                i3 = this.f20068a.i;
                resultTask2.setProgress(i, i3);
            }
        }
    }

    @Override // com.nextreaming.nexvideoeditor.ha
    public void b(NexEditor.b bVar) {
    }

    @Override // com.nextreaming.nexvideoeditor.ha
    public void b(NexEditor.b bVar, int i) {
    }

    @Override // com.nextreaming.nexvideoeditor.ha
    public void c() {
    }

    @Override // com.nextreaming.nexvideoeditor.ha
    public void c(NexEditor.b bVar) {
        this.f20068a.k = true;
    }

    @Override // com.nextreaming.nexvideoeditor.ha
    public void d() {
    }

    @Override // com.nextreaming.nexvideoeditor.ha
    public void d(NexEditor.b bVar) {
        ResultTask resultTask;
        ResultTask resultTask2;
        Object obj;
        int i;
        int i2;
        int i3;
        long j;
        resultTask = this.f20068a.E;
        if (resultTask != null) {
            this.f20068a.c();
            resultTask2 = this.f20068a.E;
            obj = this.f20068a.f20078h;
            P.b bVar2 = new P.b(obj);
            i = this.f20068a.q;
            P.b.b(bVar2, i);
            i2 = this.f20068a.r;
            i3 = this.f20068a.f20075e;
            P.b.a(bVar2, i2, i3);
            long nanoTime = System.nanoTime();
            j = this.f20068a.s;
            P.b.a(bVar2, (int) ((nanoTime - j) / 1000000));
            P.b.a(bVar2, bVar);
            resultTask2.sendResult(bVar2);
            this.f20068a.E = null;
        }
    }

    @Override // com.nextreaming.nexvideoeditor.ha
    public void a(NexEditor.b bVar, int i) {
        ResultTask resultTask;
        ResultTask resultTask2;
        Object obj;
        int i2;
        int i3;
        int i4;
        long j;
        resultTask = this.f20068a.E;
        if (resultTask != null) {
            this.f20068a.c();
            resultTask2 = this.f20068a.E;
            obj = this.f20068a.f20078h;
            P.b bVar2 = new P.b(obj);
            i2 = this.f20068a.q;
            P.b.b(bVar2, i2);
            i3 = this.f20068a.r;
            i4 = this.f20068a.f20075e;
            P.b.a(bVar2, i3, i4);
            long nanoTime = System.nanoTime();
            j = this.f20068a.s;
            P.b.a(bVar2, (int) ((nanoTime - j) / 1000000));
            P.b.a(bVar2, bVar);
            resultTask2.sendResult(bVar2);
            this.f20068a.E = null;
        }
    }
}
