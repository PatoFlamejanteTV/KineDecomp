package com.nexstreaming.kinemaster.ui.share;

import com.nexstreaming.kinemaster.ui.share.Da;
import java.io.File;

/* compiled from: ShareIntentCheckFragment.java */
/* loaded from: classes2.dex */
class Aa implements Da.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Da.d f23244a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Da f23245b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Aa(Da da, Da.d dVar) {
        this.f23245b = da;
        this.f23244a = dVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.share.Da.c
    public void a(int i) {
    }

    @Override // com.nexstreaming.kinemaster.ui.share.Da.c
    public void a(File file) {
    }

    @Override // com.nexstreaming.kinemaster.ui.share.Da.c
    public void b(File file) {
        if (file != null) {
            if (this.f23245b.getActivity() != null) {
                Da da = this.f23245b;
                new Da.e(da.getActivity(), file, new za(this, file));
                return;
            }
            return;
        }
        this.f23244a.a(file, null);
    }
}
