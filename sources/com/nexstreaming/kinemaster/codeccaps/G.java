package com.nexstreaming.kinemaster.codeccaps;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.util.C1709m;
import com.nexstreaming.kinemaster.codeccaps.P;
import com.nexstreaming.kinemaster.editorwrapper.H264Level;
import com.nexstreaming.kinemaster.editorwrapper.H264Profile;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CodecTestCase.java */
/* loaded from: classes.dex */
public class G extends NexEditor.q {

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ H f20056c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public G(H h2) {
        this.f20056c = h2;
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.q
    public void a(int i, int i2) {
        boolean z;
        boolean z2;
        NexEditor d2;
        String str;
        NexEditor d3;
        String str2;
        int i3;
        int i4;
        int i5;
        int i6;
        H264Profile h264Profile;
        int i7;
        H264Level h264Level;
        int i8;
        H264Level h264Level2;
        H264Profile h264Profile2;
        z = this.f20056c.f20057a.f20060c.p;
        if (z) {
            this.f20056c.f20057a.f20060c.c();
            return;
        }
        this.f20056c.f20057a.f20060c.u = new NexEditor.u();
        I i9 = this.f20056c.f20057a;
        i9.f20060c.F = i9.f20059b;
        z2 = this.f20056c.f20057a.f20060c.f20072b;
        if (z2) {
            str = this.f20056c.f20057a.f20060c.f20073c;
            long a2 = C1709m.a(new File(str));
            d3 = this.f20056c.f20057a.f20060c.d();
            str2 = this.f20056c.f20057a.f20060c.f20073c;
            i3 = this.f20056c.f20057a.f20060c.f20074d;
            i4 = this.f20056c.f20057a.f20060c.f20075e;
            i5 = this.f20056c.f20057a.f20060c.f20077g;
            i6 = this.f20056c.f20057a.f20060c.f20076f;
            int i10 = i6 * 100;
            h264Profile = this.f20056c.f20057a.f20060c.n;
            if (h264Profile != null) {
                h264Profile2 = this.f20056c.f20057a.f20060c.n;
                i7 = h264Profile2.value;
            } else {
                i7 = 0;
            }
            h264Level = this.f20056c.f20057a.f20060c.m;
            if (h264Level != null) {
                h264Level2 = this.f20056c.f20057a.f20060c.m;
                i8 = h264Level2.value;
            } else {
                i8 = 0;
            }
            d3.a(str2, i3, i4, i5, a2, 0, false, i10, i7, i8, 44100, 0).onSuccess(new F(this)).onFailure(new E(this)).onProgress(new D(this));
            return;
        }
        I i11 = this.f20056c.f20057a;
        i11.f20060c.E = i11.f20059b;
        d2 = this.f20056c.f20057a.f20060c.d();
        d2.r();
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.q
    public void a(NexEditor.b bVar) {
        Object obj;
        int i;
        int i2;
        int i3;
        long j;
        this.f20056c.f20057a.f20060c.c();
        I i4 = this.f20056c.f20057a;
        ResultTask resultTask = i4.f20059b;
        obj = i4.f20060c.f20078h;
        P.b bVar2 = new P.b(obj);
        i = this.f20056c.f20057a.f20060c.q;
        P.b.b(bVar2, i);
        i2 = this.f20056c.f20057a.f20060c.r;
        i3 = this.f20056c.f20057a.f20060c.f20075e;
        P.b.a(bVar2, i2, i3);
        long nanoTime = System.nanoTime();
        j = this.f20056c.f20057a.f20060c.s;
        P.b.a(bVar2, (int) ((nanoTime - j) / 1000000));
        P.b.a(bVar2, bVar);
        resultTask.sendResult(bVar2);
    }
}
