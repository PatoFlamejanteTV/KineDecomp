package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.ColorPickerPopup;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionChromaKeyFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.ac, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewOnClickListenerC1845ac implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1899gc f22216a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC1845ac(C1899gc c1899gc) {
        this.f22216a = c1899gc;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NexTimelineItem.d dVar;
        NexTimelineItem.d dVar2;
        ColorPickerPopup colorPickerPopup = new ColorPickerPopup(this.f22216a.getActivity(), false);
        dVar = this.f22216a.w;
        colorPickerPopup.b(dVar.getChromaKeyColor());
        String string = this.f22216a.getString(R.string.palette_chroma_recommend);
        dVar2 = this.f22216a.w;
        colorPickerPopup.a(string, dVar2.getChromaKeyRecommendedColors());
        colorPickerPopup.a(new Zb(this));
        colorPickerPopup.a(new _b(this));
        colorPickerPopup.e();
    }
}
