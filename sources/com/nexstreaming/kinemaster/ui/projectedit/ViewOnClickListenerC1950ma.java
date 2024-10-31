package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.ui.projectedit.CustomMaskEditFragment;

/* compiled from: CustomMaskEditFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.ma, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewOnClickListenerC1950ma implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CustomMaskEditFragment f22443a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC1950ma(CustomMaskEditFragment customMaskEditFragment) {
        this.f22443a = customMaskEditFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CustomMaskEditFragment.Tool tool;
        if (this.f22443a.isAdded()) {
            tool = this.f22443a.D;
            CustomMaskEditFragment.Tool tool2 = CustomMaskEditFragment.Tool.Eraser;
            if (tool == tool2) {
                this.f22443a.Aa();
            } else {
                this.f22443a.D = tool2;
                this.f22443a.Da();
            }
        }
    }
}
