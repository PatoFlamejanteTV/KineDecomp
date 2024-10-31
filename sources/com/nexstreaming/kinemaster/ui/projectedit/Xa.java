package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.ui.projectedit.HandwritingEditFragment;

/* compiled from: HandwritingEditFragment.java */
/* loaded from: classes2.dex */
class Xa implements View.OnLongClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ HandwritingEditFragment f22168a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Xa(HandwritingEditFragment handwritingEditFragment) {
        this.f22168a = handwritingEditFragment;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.f22168a.isAdded()) {
            return false;
        }
        this.f22168a.Z = HandwritingEditFragment.Tool.Pencil;
        this.f22168a.Ia();
        this.f22168a.Fa();
        return true;
    }
}
