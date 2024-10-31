package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.ui.projectedit.HandwritingEditFragment;

/* compiled from: HandwritingEditFragment.java */
/* loaded from: classes2.dex */
class Za implements View.OnLongClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ HandwritingEditFragment f22192a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Za(HandwritingEditFragment handwritingEditFragment) {
        this.f22192a = handwritingEditFragment;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.f22192a.isAdded()) {
            return false;
        }
        this.f22192a.Z = HandwritingEditFragment.Tool.Eraser;
        this.f22192a.Ia();
        this.f22192a.Ea();
        return true;
    }
}
