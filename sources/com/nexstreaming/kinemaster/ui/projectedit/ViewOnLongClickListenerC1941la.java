package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.ui.projectedit.CustomMaskEditFragment;

/* compiled from: CustomMaskEditFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.la, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewOnLongClickListenerC1941la implements View.OnLongClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CustomMaskEditFragment f22432a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnLongClickListenerC1941la(CustomMaskEditFragment customMaskEditFragment) {
        this.f22432a = customMaskEditFragment;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.f22432a.isAdded()) {
            return false;
        }
        this.f22432a.D = CustomMaskEditFragment.Tool.Pencil;
        this.f22432a.Da();
        this.f22432a.Ba();
        return true;
    }
}
