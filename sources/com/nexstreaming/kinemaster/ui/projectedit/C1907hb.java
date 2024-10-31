package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import com.nexstreaming.kinemaster.layer.handwriting.Stroke;
import com.nexstreaming.kinemaster.ui.projectedit.HandwritingEditFragment;
import com.nexstreaming.kinemaster.ui.widget.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HandwritingEditFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.hb, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1907hb implements e.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ HandwritingEditFragment f22362a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1907hb(HandwritingEditFragment handwritingEditFragment) {
        this.f22362a = handwritingEditFragment;
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.e.b
    public void a(com.nexstreaming.kinemaster.ui.widget.e eVar, int i) {
        HandwritingEditFragment.BrushType brushType;
        ImageView imageView;
        HandwritingEditFragment.BrushType brushType2;
        HandwritingEditFragment.BrushType brushType3;
        Stroke stroke;
        HandwritingEditFragment.BrushType brushType4;
        HandwritingEditFragment.BrushType fromId = HandwritingEditFragment.BrushType.fromId(i);
        if (fromId != null) {
            brushType = this.f22362a.aa;
            if (fromId != brushType) {
                this.f22362a.aa = fromId;
                imageView = this.f22362a.V;
                brushType2 = this.f22362a.aa;
                imageView.setImageResource(brushType2.iconRsrc);
                brushType3 = this.f22362a.aa;
                stroke = this.f22362a.H;
                brushType3.setStroke(stroke);
                SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f22362a.getActivity()).edit();
                brushType4 = this.f22362a.aa;
                edit.putString("km.ui.handwriting.brush", brushType4.name()).apply();
            }
        }
    }
}
