package com.nexstreaming.kinemaster.ui.projectedit;

import android.preference.PreferenceManager;
import android.widget.ImageView;
import com.nexstreaming.kinemaster.layer.handwriting.Stroke;
import com.nexstreaming.kinemaster.ui.widget.r;

/* compiled from: CustomMaskEditFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.oa, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1968oa implements r.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewOnClickListenerC2003sa f22464a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1968oa(ViewOnClickListenerC2003sa viewOnClickListenerC2003sa) {
        this.f22464a = viewOnClickListenerC2003sa;
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.r.b
    public void a(float f2) {
        Stroke stroke;
        ImageView imageView;
        PreferenceManager.getDefaultSharedPreferences(this.f22464a.f22518a.getActivity()).edit().putFloat("km.ui.handwriting.strokeWidth", f2).apply();
        stroke = this.f22464a.f22518a.m;
        stroke.b(f2);
        imageView = this.f22464a.f22518a.B;
        imageView.setImageDrawable(new Yg(this.f22464a.f22518a.getActivity(), (f2 * this.f22464a.f22518a.S().intValue()) / 1280.0f));
    }
}
