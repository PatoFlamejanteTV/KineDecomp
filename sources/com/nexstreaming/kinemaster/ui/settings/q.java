package com.nexstreaming.kinemaster.ui.settings;

import android.view.View;
import com.nexstreaming.kinemaster.ui.settings.Ua;

/* compiled from: KineInfoFragment.java */
/* loaded from: classes2.dex */
class Q implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ U f23075a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Q(U u) {
        this.f23075a = u;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Ua.a aVar;
        Ua.a aVar2;
        aVar = this.f23075a.f23083b;
        if (aVar != null) {
            aVar2 = this.f23075a.f23083b;
            aVar2.b("frag_kine_legal_info");
        }
    }
}
