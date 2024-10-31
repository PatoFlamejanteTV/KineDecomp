package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import com.nexstreaming.kinemaster.layer.handwriting.Stroke;
import com.nexstreaming.kinemaster.ui.projectedit.HandwritingEditFragment;
import com.nexstreaming.kinemaster.ui.widget.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HandwritingEditFragment.java */
/* loaded from: classes.dex */
public class ax implements b.InterfaceC0078b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ HandwritingEditFragment f3777a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(HandwritingEditFragment handwritingEditFragment) {
        this.f3777a = handwritingEditFragment;
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.b.InterfaceC0078b
    public void a(com.nexstreaming.kinemaster.ui.widget.b bVar, int i) {
        HandwritingEditFragment.BrushType brushType;
        ImageView imageView;
        HandwritingEditFragment.BrushType brushType2;
        HandwritingEditFragment.BrushType brushType3;
        Stroke stroke;
        HandwritingEditFragment.BrushType brushType4;
        HandwritingEditFragment.BrushType fromId = HandwritingEditFragment.BrushType.fromId(i);
        if (fromId != null) {
            brushType = this.f3777a.w;
            if (fromId != brushType) {
                this.f3777a.w = fromId;
                imageView = this.f3777a.r;
                brushType2 = this.f3777a.w;
                imageView.setImageResource(brushType2.iconRsrc);
                brushType3 = this.f3777a.w;
                stroke = this.f3777a.d;
                brushType3.setStroke(stroke);
                SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f3777a.getActivity()).edit();
                brushType4 = this.f3777a.w;
                edit.putString("km.ui.handwriting.brush", brushType4.name()).apply();
            }
        }
    }
}
