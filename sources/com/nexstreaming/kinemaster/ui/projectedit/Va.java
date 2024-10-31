package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.ui.projectedit.HandwritingEditFragment;

/* compiled from: HandwritingEditFragment.java */
/* loaded from: classes2.dex */
class Va implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ HandwritingEditFragment f22150a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Va(HandwritingEditFragment handwritingEditFragment) {
        this.f22150a = handwritingEditFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        HandwritingEditFragment.Tool tool;
        if (this.f22150a.isAdded()) {
            tool = this.f22150a.Z;
            HandwritingEditFragment.Tool tool2 = HandwritingEditFragment.Tool.Pencil;
            if (tool == tool2) {
                this.f22150a.Fa();
            } else {
                this.f22150a.Z = tool2;
                this.f22150a.Ia();
            }
        }
    }
}
