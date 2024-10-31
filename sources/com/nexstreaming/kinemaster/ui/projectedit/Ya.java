package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.ui.projectedit.HandwritingEditFragment;

/* compiled from: HandwritingEditFragment.java */
/* loaded from: classes2.dex */
class Ya implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ HandwritingEditFragment f22178a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ya(HandwritingEditFragment handwritingEditFragment) {
        this.f22178a = handwritingEditFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        HandwritingEditFragment.Tool tool;
        if (this.f22178a.isAdded()) {
            tool = this.f22178a.Z;
            HandwritingEditFragment.Tool tool2 = HandwritingEditFragment.Tool.Eraser;
            if (tool == tool2) {
                this.f22178a.Ea();
            } else {
                this.f22178a.Z = tool2;
                this.f22178a.Ia();
            }
        }
    }
}
