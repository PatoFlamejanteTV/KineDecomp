package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Rect;
import android.view.View;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: CustomMaskEditFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.ka, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewOnClickListenerC1932ka implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CustomMaskEditFragment f22411a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC1932ka(CustomMaskEditFragment customMaskEditFragment) {
        this.f22411a = customMaskEditFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NexTimelineItem.j xa;
        Rect rect;
        if (this.f22411a.isAdded()) {
            xa = this.f22411a.xa();
            xa.addCMEraseAll();
            rect = this.f22411a.w;
            rect.set(0, 0, 1280, 720);
            this.f22411a.Ca();
            this.f22411a.Ea();
            this.f22411a.C = true;
        }
    }
}
