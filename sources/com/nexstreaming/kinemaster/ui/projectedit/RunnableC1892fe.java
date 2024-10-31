package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import com.nexstreaming.app.kinemasterfree.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionPanelDefaultFragment.kt */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.fe, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC1892fe implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bd f22334a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ImageButton f22335b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1892fe(Bd bd, ImageButton imageButton) {
        this.f22334a = bd;
        this.f22335b = imageButton;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View view;
        View view2;
        view = this.f22334a.o;
        if (view != null) {
            view2 = this.f22334a.o;
            if (view2 == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            View findViewById = view2.findViewById(R.id.camera_icon_forAnimation);
            kotlin.jvm.internal.h.a((Object) findViewById, "contentView!!.findViewBy…camera_icon_forAnimation)");
            findViewById.setVisibility(0);
        }
        this.f22335b.startAnimation(AnimationUtils.loadAnimation(this.f22334a.getActivity(), R.anim.fade_out));
    }
}
