package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.ui.projectedit.CustomMaskEditFragment;

/* compiled from: CustomMaskEditFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.na, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewOnLongClickListenerC1959na implements View.OnLongClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CustomMaskEditFragment f22454a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnLongClickListenerC1959na(CustomMaskEditFragment customMaskEditFragment) {
        this.f22454a = customMaskEditFragment;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.f22454a.isAdded()) {
            return false;
        }
        this.f22454a.D = CustomMaskEditFragment.Tool.Eraser;
        this.f22454a.Da();
        this.f22454a.Aa();
        return true;
    }
}
