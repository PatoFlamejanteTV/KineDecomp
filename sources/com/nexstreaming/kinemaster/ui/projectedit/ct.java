package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.ColorPickerPopup;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionChromaKeyFragment.java */
/* loaded from: classes.dex */
class ct implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ cr f3827a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(cr crVar) {
        this.f3827a = crVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NexTimelineItem.c cVar;
        NexTimelineItem.c cVar2;
        ColorPickerPopup colorPickerPopup = new ColorPickerPopup(this.f3827a.getActivity(), false);
        cVar = this.f3827a.l;
        colorPickerPopup.a(cVar.getChromaKeyColor());
        String string = this.f3827a.getString(R.string.palette_chroma_recommend);
        cVar2 = this.f3827a.l;
        colorPickerPopup.a(string, cVar2.getChromaKeyRecommendedColors());
        colorPickerPopup.a(new cu(this));
        colorPickerPopup.a(new cv(this));
        colorPickerPopup.e();
    }
}
