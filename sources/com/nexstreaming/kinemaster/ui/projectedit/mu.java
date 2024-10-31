package com.nexstreaming.kinemaster.ui.projectedit;

import android.media.AudioRecord;
import com.nexstreaming.kinemaster.ui.projectedit.mr;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VoiceRecordingControler.java */
/* loaded from: classes.dex */
public class mu implements mr.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ mr f4102a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public mu(mr mrVar) {
        this.f4102a = mrVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.mr.a
    public void a() {
        boolean z;
        boolean z2;
        AudioRecord audioRecord;
        mr.b bVar;
        boolean z3;
        boolean z4;
        z = this.f4102a.e;
        if (z) {
            synchronized (this.f4102a) {
                z2 = this.f4102a.e;
                this.f4102a.e = false;
            }
            if (z2) {
                audioRecord = this.f4102a.g;
                audioRecord.startRecording();
                this.f4102a.d = true;
                bVar = this.f4102a.h;
                z3 = this.f4102a.e;
                z4 = this.f4102a.c;
                bVar.a(z3, z4, -1);
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.mr.a
    public void b() {
        this.f4102a.e = false;
        this.f4102a.a(true);
    }
}
