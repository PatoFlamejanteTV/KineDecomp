package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.drawable.ClipDrawable;
import com.nexstreaming.kinemaster.ui.projectedit.Oh;
import java.io.File;

/* compiled from: VoiceRecorderFragment.kt */
/* loaded from: classes2.dex */
public final class Ah implements Oh.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zh f21743a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ah(zh zhVar) {
        this.f21743a = zhVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Oh.b
    public void a(Oh.a aVar) {
        kotlin.jvm.internal.h.b(aVar, "cueCallback");
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Oh.b
    public void a(File file) {
        kotlin.jvm.internal.h.b(file, "recordedFile");
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Oh.b
    public void a(boolean z) {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Oh.b
    public void a(boolean z, boolean z2, int i) {
        ClipDrawable clipDrawable;
        if (this.f21743a.isAdded() && !z && z2 && i > -1) {
            clipDrawable = this.f21743a.n;
            if (clipDrawable != null) {
                clipDrawable.setLevel(i);
            } else {
                kotlin.jvm.internal.h.a();
                throw null;
            }
        }
    }
}
