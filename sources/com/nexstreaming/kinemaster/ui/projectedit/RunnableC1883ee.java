package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionPanelDefaultFragment.kt */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.ee, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC1883ee implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bd f22326a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1883ee(Bd bd) {
        this.f22326a = bd;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View view;
        View view2;
        view = this.f22326a.o;
        if (view != null) {
            view2 = this.f22326a.o;
            if (view2 == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            View findViewById = view2.findViewById(R.id.camera_icon_forAnimation);
            kotlin.jvm.internal.h.a((Object) findViewById, "contentView!!.findViewBy…camera_icon_forAnimation)");
            findViewById.setVisibility(8);
        }
    }
}
