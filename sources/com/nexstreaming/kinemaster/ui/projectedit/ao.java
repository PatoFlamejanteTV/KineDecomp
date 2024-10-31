package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.ui.projectedit.HandwritingEditFragment;

/* compiled from: HandwritingEditFragment.java */
/* loaded from: classes.dex */
class ao implements View.OnLongClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ HandwritingEditFragment f3768a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(HandwritingEditFragment handwritingEditFragment) {
        this.f3768a = handwritingEditFragment;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.f3768a.isAdded()) {
            return false;
        }
        this.f3768a.v = HandwritingEditFragment.Tool.Eraser;
        this.f3768a.L();
        this.f3768a.J();
        return true;
    }
}
