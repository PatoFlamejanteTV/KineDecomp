package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import com.nexstreaming.kinemaster.layer.handwriting.Stroke;
import com.nexstreaming.kinemaster.ui.projectedit.CustomMaskEditFragment;
import com.nexstreaming.kinemaster.ui.widget.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CustomMaskEditFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.ta, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2012ta implements e.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CustomMaskEditFragment f22534a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2012ta(CustomMaskEditFragment customMaskEditFragment) {
        this.f22534a = customMaskEditFragment;
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.e.b
    public void a(com.nexstreaming.kinemaster.ui.widget.e eVar, int i) {
        CustomMaskEditFragment.BrushType brushType;
        ImageView imageView;
        CustomMaskEditFragment.BrushType brushType2;
        CustomMaskEditFragment.BrushType brushType3;
        Stroke stroke;
        CustomMaskEditFragment.BrushType brushType4;
        CustomMaskEditFragment.BrushType fromId = CustomMaskEditFragment.BrushType.fromId(i);
        if (fromId != null) {
            brushType = this.f22534a.E;
            if (fromId != brushType) {
                this.f22534a.E = fromId;
                imageView = this.f22534a.A;
                brushType2 = this.f22534a.E;
                imageView.setImageResource(brushType2.iconRsrc);
                brushType3 = this.f22534a.E;
                stroke = this.f22534a.m;
                brushType3.setStroke(stroke);
                SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f22534a.getActivity()).edit();
                brushType4 = this.f22534a.E;
                edit.putString("km.ui.handwriting.brush", brushType4.name()).apply();
            }
        }
    }
}
