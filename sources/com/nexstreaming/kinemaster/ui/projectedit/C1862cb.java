package com.nexstreaming.kinemaster.ui.projectedit;

import android.preference.PreferenceManager;
import android.widget.ImageView;
import com.nexstreaming.kinemaster.layer.handwriting.Stroke;
import com.nexstreaming.kinemaster.ui.widget.r;
import com.nextreaming.nexeditorui.EditorGlobal;

/* compiled from: HandwritingEditFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.cb, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1862cb implements r.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewOnClickListenerC1898gb f22297a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1862cb(ViewOnClickListenerC1898gb viewOnClickListenerC1898gb) {
        this.f22297a = viewOnClickListenerC1898gb;
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.r.b
    public void a(float f2) {
        Stroke stroke;
        ImageView imageView;
        PreferenceManager.getDefaultSharedPreferences(this.f22297a.f22348a.getActivity()).edit().putFloat("km.ui.handwriting.strokeWidth", f2).apply();
        stroke = this.f22297a.f22348a.H;
        stroke.b(f2);
        imageView = this.f22297a.f22348a.X;
        imageView.setImageDrawable(new Yg(this.f22297a.f22348a.getActivity(), (f2 * this.f22297a.f22348a.S().intValue()) / EditorGlobal.n()));
    }
}
