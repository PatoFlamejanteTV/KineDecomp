package com.nexstreaming.kinemaster.ui.projectedit;

import android.media.AudioRecord;
import com.nexstreaming.kinemaster.ui.projectedit.Oh;

/* compiled from: VoiceRecordingController.java */
/* loaded from: classes2.dex */
public class Nh implements Oh.a {

    /* renamed from: a */
    final /* synthetic */ Oh f21976a;

    public Nh(Oh oh) {
        this.f21976a = oh;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Oh.a
    public void a() {
        this.f21976a.f21991e = false;
        this.f21976a.a(true);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Oh.a
    public void b() {
        boolean z;
        boolean z2;
        AudioRecord audioRecord;
        Oh.b bVar;
        boolean z3;
        boolean z4;
        z = this.f21976a.f21991e;
        if (z) {
            synchronized (this.f21976a) {
                z2 = this.f21976a.f21991e;
                this.f21976a.f21991e = false;
            }
            if (z2) {
                audioRecord = this.f21976a.f21993g;
                audioRecord.startRecording();
                this.f21976a.f21990d = true;
                bVar = this.f21976a.f21994h;
                z3 = this.f21976a.f21991e;
                z4 = this.f21976a.f21989c;
                bVar.a(z3, z4, -1);
            }
        }
    }
}
