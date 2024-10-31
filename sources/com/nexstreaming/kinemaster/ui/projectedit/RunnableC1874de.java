package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: OptionPanelDefaultFragment.kt */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.de, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class RunnableC1874de implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bd f22311a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ LinearLayout f22312b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ LinearLayout f22313c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1874de(Bd bd, LinearLayout linearLayout, LinearLayout linearLayout2) {
        this.f22311a = bd;
        this.f22312b = linearLayout;
        this.f22313c = linearLayout2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LinearLayout linearLayout = this.f22312b;
        kotlin.jvm.internal.h.a((Object) linearLayout, "camcorderBtnHolder");
        linearLayout.setVisibility(0);
        LinearLayout linearLayout2 = this.f22313c;
        kotlin.jvm.internal.h.a((Object) linearLayout2, "cameraBtnHolder");
        linearLayout2.setVisibility(0);
        this.f22312b.startAnimation(AnimationUtils.loadAnimation(this.f22311a.getActivity(), R.anim.camcorder_slide_lefttoright));
        this.f22313c.startAnimation(AnimationUtils.loadAnimation(this.f22311a.getActivity(), R.anim.camera_slide_righttoleft));
    }
}
