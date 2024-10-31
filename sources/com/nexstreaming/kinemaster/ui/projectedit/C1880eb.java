package com.nexstreaming.kinemaster.ui.projectedit;

import android.preference.PreferenceManager;
import android.widget.ImageView;
import com.nexstreaming.kinemaster.layer.handwriting.Stroke;
import com.nexstreaming.kinemaster.ui.widget.r;
import com.nextreaming.nexeditorui.EditorGlobal;

/* compiled from: HandwritingEditFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.eb, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1880eb implements r.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewOnClickListenerC1898gb f22323a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1880eb(ViewOnClickListenerC1898gb viewOnClickListenerC1898gb) {
        this.f22323a = viewOnClickListenerC1898gb;
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.r.b
    public void a(float f2) {
        Stroke stroke;
        ImageView imageView;
        PreferenceManager.getDefaultSharedPreferences(this.f22323a.f22348a.getActivity()).edit().putFloat("km.ui.handwriting.eraserWidth", f2).apply();
        stroke = this.f22323a.f22348a.I;
        stroke.b(f2);
        imageView = this.f22323a.f22348a.X;
        imageView.setImageDrawable(new Yg(this.f22323a.f22348a.getActivity(), (f2 * this.f22323a.f22348a.S().intValue()) / EditorGlobal.n()));
    }
}
