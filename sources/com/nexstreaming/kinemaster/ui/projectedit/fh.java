package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import com.nexstreaming.app.kinemasterfree.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionPanelDefaultFragment.java */
/* loaded from: classes.dex */
public class fh implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ImageButton f3898a;
    final /* synthetic */ ez b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fh(ez ezVar, ImageButton imageButton) {
        this.b = ezVar;
        this.f3898a = imageButton;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        view = this.b.b;
        view.findViewById(R.id.camera_icon_forAnimation).setVisibility(0);
        this.f3898a.startAnimation(AnimationUtils.loadAnimation(this.b.getActivity(), R.anim.fade_out));
    }
}
