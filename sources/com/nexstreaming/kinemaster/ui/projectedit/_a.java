package com.nexstreaming.kinemaster.ui.projectedit;

import android.preference.PreferenceManager;
import android.widget.ImageView;
import com.nexstreaming.kinemaster.layer.handwriting.Stroke;
import com.nextreaming.nexeditorui.ColorPickerPopup;

/* compiled from: HandwritingEditFragment.java */
/* loaded from: classes2.dex */
class _a implements ColorPickerPopup.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewOnClickListenerC1853bb f22199a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public _a(ViewOnClickListenerC1853bb viewOnClickListenerC1853bb) {
        this.f22199a = viewOnClickListenerC1853bb;
    }

    @Override // com.nextreaming.nexeditorui.ColorPickerPopup.a
    public void a(int i) {
        Stroke stroke;
        ImageView imageView;
        PreferenceManager.getDefaultSharedPreferences(this.f22199a.f22273a.getActivity()).edit().putInt("km.ui.handwriting.color", i).apply();
        stroke = this.f22199a.f22273a.H;
        stroke.a(i);
        imageView = this.f22199a.f22273a.W;
        imageView.setImageDrawable(new C1897ga(this.f22199a.f22273a.getActivity(), i));
    }
}
