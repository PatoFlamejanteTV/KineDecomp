package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.ui.projectedit.CustomMaskEditFragment;

/* compiled from: CustomMaskEditFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.ja, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewOnClickListenerC1923ja implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CustomMaskEditFragment f22400a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC1923ja(CustomMaskEditFragment customMaskEditFragment) {
        this.f22400a = customMaskEditFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CustomMaskEditFragment.Tool tool;
        if (this.f22400a.isAdded()) {
            tool = this.f22400a.D;
            CustomMaskEditFragment.Tool tool2 = CustomMaskEditFragment.Tool.Pencil;
            if (tool == tool2) {
                this.f22400a.Ba();
            } else {
                this.f22400a.D = tool2;
                this.f22400a.Da();
            }
        }
    }
}
