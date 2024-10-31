package com.nexstreaming.kinemaster.ui.projectedit;

import android.widget.ImageView;
import com.nextreaming.nexeditorui.ColorPickerPopup;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionChromaKeyFragment.java */
/* loaded from: classes.dex */
class cv implements ColorPickerPopup.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ct f3829a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(ct ctVar) {
        this.f3829a = ctVar;
    }

    @Override // com.nextreaming.nexeditorui.ColorPickerPopup.b
    public void a(int i, boolean z) {
        NexTimelineItem.c cVar;
        ImageView imageView;
        cVar = this.f3829a.f3827a.l;
        cVar.setChromaKeyColor(i);
        imageView = this.f3829a.f3827a.c;
        imageView.setImageDrawable(new q(this.f3829a.f3827a.getActivity(), i));
        if (!z) {
            this.f3829a.f3827a.d();
        } else {
            this.f3829a.f3827a.o().z().a();
        }
    }
}
