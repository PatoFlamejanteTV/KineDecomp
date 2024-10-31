package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.drawable.ClipDrawable;
import com.nexstreaming.kinemaster.ui.projectedit.mr;
import java.io.File;

/* compiled from: VoiceRecorderFragment.java */
/* loaded from: classes.dex */
class mg implements mr.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ mf f4088a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public mg(mf mfVar) {
        this.f4088a = mfVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.mr.b
    public void a(mr.a aVar) {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.mr.b
    public void a(File file) {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.mr.b
    public void a(boolean z) {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.mr.b
    public void a(boolean z, boolean z2, int i) {
        ClipDrawable clipDrawable;
        if (this.f4088a.isAdded() && !z && z2 && i > -1) {
            clipDrawable = this.f4088a.d;
            clipDrawable.setLevel(i);
        }
    }
}
