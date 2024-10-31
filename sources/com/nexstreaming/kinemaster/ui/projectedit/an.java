package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.ui.projectedit.HandwritingEditFragment;

/* compiled from: HandwritingEditFragment.java */
/* loaded from: classes.dex */
class an implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ HandwritingEditFragment f3767a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(HandwritingEditFragment handwritingEditFragment) {
        this.f3767a = handwritingEditFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        HandwritingEditFragment.Tool tool;
        if (this.f3767a.isAdded()) {
            tool = this.f3767a.v;
            if (tool == HandwritingEditFragment.Tool.Eraser) {
                this.f3767a.J();
                return;
            }
            this.f3767a.v = HandwritingEditFragment.Tool.Eraser;
            this.f3767a.L();
        }
    }
}
