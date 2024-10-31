package com.nexstreaming.kinemaster.ui.settings;

import android.view.View;
import com.nexstreaming.kinemaster.ui.settings.x;

/* compiled from: KineInfoFragment.java */
/* loaded from: classes.dex */
class s implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ r f4269a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.f4269a = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        x.a aVar;
        x.a aVar2;
        aVar = this.f4269a.b;
        if (aVar != null) {
            aVar2 = this.f4269a.b;
            aVar2.a("frag_kine_legal_info");
        }
    }
}
