package com.nexstreaming.kinemaster.ui.projectedit;

import android.preference.PreferenceManager;
import android.widget.ImageView;
import com.nexstreaming.kinemaster.layer.handwriting.Stroke;
import com.nexstreaming.kinemaster.ui.widget.n;

/* compiled from: HandwritingEditFragment.java */
/* loaded from: classes.dex */
class at implements n.b {

    /* renamed from: a */
    final /* synthetic */ as f3773a;

    public at(as asVar) {
        this.f3773a = asVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.n.b
    public void a(float f) {
        Stroke stroke;
        ImageView imageView;
        PreferenceManager.getDefaultSharedPreferences(this.f3773a.f3772a.getActivity()).edit().putFloat("km.ui.handwriting.strokeWidth", f).apply();
        stroke = this.f3773a.f3772a.d;
        stroke.b(f);
        imageView = this.f3773a.f3772a.t;
        imageView.setImageDrawable(new lg(this.f3773a.f3772a.getActivity(), (this.f3773a.f3772a.x() * f) / 1280.0f));
    }
}
