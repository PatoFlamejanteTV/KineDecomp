package com.nexstreaming.kinemaster.ui.projectedit;

import android.widget.ImageView;
import com.nextreaming.nexeditorui.ColorPickerPopup;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionChromaKeyFragment.java */
/* loaded from: classes2.dex */
class Zb implements ColorPickerPopup.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewOnClickListenerC1845ac f22193a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Zb(ViewOnClickListenerC1845ac viewOnClickListenerC1845ac) {
        this.f22193a = viewOnClickListenerC1845ac;
    }

    @Override // com.nextreaming.nexeditorui.ColorPickerPopup.a
    public void a(int i) {
        NexTimelineItem.d dVar;
        ImageView imageView;
        dVar = this.f22193a.f22216a.w;
        dVar.setChromaKeyColor(i);
        imageView = this.f22193a.f22216a.n;
        imageView.setImageDrawable(new C1897ga(this.f22193a.f22216a.getActivity(), i));
        this.f22193a.f22216a.da().n().execute();
    }
}
