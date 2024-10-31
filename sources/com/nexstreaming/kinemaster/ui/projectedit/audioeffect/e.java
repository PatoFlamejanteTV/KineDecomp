package com.nexstreaming.kinemaster.ui.projectedit.audioeffect;

import android.view.View;
import com.nexstreaming.kinemaster.ui.projectedit.audioeffect.f;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AudioEffectAdapter.kt */
/* loaded from: classes2.dex */
public final class e implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ f.a f22230a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ b f22231b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(f.a aVar, b bVar) {
        this.f22230a = aVar;
        this.f22231b = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        i iVar;
        iVar = this.f22230a.y.f22237h;
        iVar.a(this.f22231b);
    }
}
