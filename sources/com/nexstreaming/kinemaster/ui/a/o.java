package com.nexstreaming.kinemaster.ui.a;

import android.view.View;

/* compiled from: NexFullScreenDialog.kt */
/* loaded from: classes.dex */
final class o implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ m f21359a;

    public o(m mVar) {
        this.f21359a = mVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f21359a.A() != null) {
            l A = this.f21359a.A();
            if (A != null) {
                A.stop();
            } else {
                kotlin.jvm.internal.h.a();
                throw null;
            }
        }
    }
}
