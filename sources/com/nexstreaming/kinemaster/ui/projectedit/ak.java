package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.ui.projectedit.HandwritingEditFragment;

/* compiled from: HandwritingEditFragment.java */
/* loaded from: classes.dex */
class ak implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ HandwritingEditFragment f3764a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(HandwritingEditFragment handwritingEditFragment) {
        this.f3764a = handwritingEditFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        HandwritingEditFragment.Tool tool;
        if (this.f3764a.isAdded()) {
            tool = this.f3764a.v;
            if (tool == HandwritingEditFragment.Tool.Pencil) {
                this.f3764a.K();
                return;
            }
            this.f3764a.v = HandwritingEditFragment.Tool.Pencil;
            this.f3764a.L();
        }
    }
}
