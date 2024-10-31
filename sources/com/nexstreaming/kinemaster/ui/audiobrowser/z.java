package com.nexstreaming.kinemaster.ui.audiobrowser;

import android.widget.CompoundButton;
import com.nexstreaming.kinemaster.ui.audiobrowser.x;

/* compiled from: SongAdapter.kt */
/* loaded from: classes.dex */
final class z implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ x f21511a;

    /* renamed from: b */
    final /* synthetic */ int f21512b;

    /* renamed from: c */
    final /* synthetic */ u f21513c;

    public z(x xVar, int i, u uVar) {
        this.f21511a = xVar;
        this.f21512b = i;
        this.f21513c = uVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        x.b bVar;
        bVar = this.f21511a.i;
        if (bVar != null) {
            bVar.b(this.f21511a, this.f21513c, this.f21512b);
        }
    }
}
