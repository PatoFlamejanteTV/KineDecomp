package com.nexstreaming.kinemaster.ui.projectedit;

import android.preference.PreferenceManager;
import android.widget.ImageView;
import com.nexstreaming.kinemaster.layer.handwriting.Stroke;
import com.nexstreaming.kinemaster.ui.widget.r;

/* compiled from: CustomMaskEditFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.qa, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1986qa implements r.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewOnClickListenerC2003sa f22484a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1986qa(ViewOnClickListenerC2003sa viewOnClickListenerC2003sa) {
        this.f22484a = viewOnClickListenerC2003sa;
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.r.b
    public void a(float f2) {
        Stroke stroke;
        ImageView imageView;
        PreferenceManager.getDefaultSharedPreferences(this.f22484a.f22518a.getActivity()).edit().putFloat("km.ui.handwriting.eraserWidth", f2).apply();
        stroke = this.f22484a.f22518a.n;
        stroke.b(f2);
        imageView = this.f22484a.f22518a.B;
        imageView.setImageDrawable(new Yg(this.f22484a.f22518a.getActivity(), (f2 * this.f22484a.f22518a.S().intValue()) / 1280.0f));
    }
}
