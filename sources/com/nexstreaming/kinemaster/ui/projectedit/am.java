package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.ui.projectedit.HandwritingEditFragment;

/* compiled from: HandwritingEditFragment.java */
/* loaded from: classes.dex */
class am implements View.OnLongClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ HandwritingEditFragment f3766a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(HandwritingEditFragment handwritingEditFragment) {
        this.f3766a = handwritingEditFragment;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.f3766a.isAdded()) {
            return false;
        }
        this.f3766a.v = HandwritingEditFragment.Tool.Pencil;
        this.f3766a.L();
        this.f3766a.K();
        return true;
    }
}
