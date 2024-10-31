package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Rect;
import android.view.View;
import com.nexstreaming.kinemaster.layer.HandwritingLayer;

/* compiled from: HandwritingEditFragment.java */
/* loaded from: classes.dex */
class al implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ HandwritingEditFragment f3765a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(HandwritingEditFragment handwritingEditFragment) {
        this.f3765a = handwritingEditFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        HandwritingLayer N;
        Rect rect;
        if (this.f3765a.isAdded()) {
            N = this.f3765a.N();
            N.addEraseAll();
            rect = this.f3765a.n;
            rect.set(0, 0, 1280, 720);
            this.f3765a.M();
            this.f3765a.I();
            this.f3765a.u = true;
        }
    }
}
