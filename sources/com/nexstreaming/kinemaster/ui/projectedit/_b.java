package com.nexstreaming.kinemaster.ui.projectedit;

import android.widget.ImageView;
import com.nextreaming.nexeditorui.ColorPickerPopup;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionChromaKeyFragment.java */
/* loaded from: classes2.dex */
class _b implements ColorPickerPopup.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewOnClickListenerC1845ac f22200a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public _b(ViewOnClickListenerC1845ac viewOnClickListenerC1845ac) {
        this.f22200a = viewOnClickListenerC1845ac;
    }

    @Override // com.nextreaming.nexeditorui.ColorPickerPopup.b
    public void a(int i, boolean z) {
        NexTimelineItem.d dVar;
        ImageView imageView;
        dVar = this.f22200a.f22216a.w;
        dVar.setChromaKeyColor(i);
        imageView = this.f22200a.f22216a.n;
        imageView.setImageDrawable(new C1897ga(this.f22200a.f22216a.getActivity(), i));
        if (!z) {
            this.f22200a.f22216a.G();
        } else {
            this.f22200a.f22216a.da().n().execute();
        }
    }
}
