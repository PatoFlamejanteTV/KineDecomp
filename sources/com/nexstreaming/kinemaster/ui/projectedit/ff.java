package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.nexstreaming.app.kinemasterfree.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionPanelDefaultFragment.java */
/* loaded from: classes.dex */
public class ff implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LinearLayout f3896a;
    final /* synthetic */ LinearLayout b;
    final /* synthetic */ ez c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ff(ez ezVar, LinearLayout linearLayout, LinearLayout linearLayout2) {
        this.c = ezVar;
        this.f3896a = linearLayout;
        this.b = linearLayout2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3896a.setVisibility(0);
        this.b.setVisibility(0);
        this.f3896a.startAnimation(AnimationUtils.loadAnimation(this.c.getActivity(), R.anim.camcorder_slide_lefttoright));
        this.b.startAnimation(AnimationUtils.loadAnimation(this.c.getActivity(), R.anim.camera_slide_righttoleft));
    }
}
