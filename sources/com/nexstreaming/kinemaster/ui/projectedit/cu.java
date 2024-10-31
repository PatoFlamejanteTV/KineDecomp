package com.nexstreaming.kinemaster.ui.projectedit;

import android.widget.ImageView;
import com.nextreaming.nexeditorui.ColorPickerPopup;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionChromaKeyFragment.java */
/* loaded from: classes.dex */
class cu implements ColorPickerPopup.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ct f3828a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(ct ctVar) {
        this.f3828a = ctVar;
    }

    @Override // com.nextreaming.nexeditorui.ColorPickerPopup.a
    public void a(int i) {
        NexTimelineItem.c cVar;
        ImageView imageView;
        cVar = this.f3828a.f3827a.l;
        cVar.setChromaKeyColor(i);
        imageView = this.f3828a.f3827a.c;
        imageView.setImageDrawable(new q(this.f3828a.f3827a.getActivity(), i));
        this.f3828a.f3827a.o().z().a();
    }
}
