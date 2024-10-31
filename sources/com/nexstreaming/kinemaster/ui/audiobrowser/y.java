package com.nexstreaming.kinemaster.ui.audiobrowser;

import android.view.View;
import com.nexstreaming.kinemaster.ui.audiobrowser.x;

/* compiled from: SongAdapter.kt */
/* loaded from: classes.dex */
final class y implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ x f21508a;

    /* renamed from: b */
    final /* synthetic */ u f21509b;

    /* renamed from: c */
    final /* synthetic */ int f21510c;

    public y(x xVar, u uVar, int i) {
        this.f21508a = xVar;
        this.f21509b = uVar;
        this.f21510c = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        x.b bVar;
        bVar = this.f21508a.i;
        if (bVar != null) {
            bVar.a(this.f21508a, this.f21509b, this.f21510c);
        }
    }
}
