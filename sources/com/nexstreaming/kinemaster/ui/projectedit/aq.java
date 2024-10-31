package com.nexstreaming.kinemaster.ui.projectedit;

import android.preference.PreferenceManager;
import android.widget.ImageView;
import com.nexstreaming.kinemaster.layer.handwriting.Stroke;
import com.nextreaming.nexeditorui.ColorPickerPopup;

/* compiled from: HandwritingEditFragment.java */
/* loaded from: classes.dex */
class aq implements ColorPickerPopup.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ap f3770a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ap apVar) {
        this.f3770a = apVar;
    }

    @Override // com.nextreaming.nexeditorui.ColorPickerPopup.a
    public void a(int i) {
        Stroke stroke;
        ImageView imageView;
        PreferenceManager.getDefaultSharedPreferences(this.f3770a.f3769a.getActivity()).edit().putInt("km.ui.handwriting.color", i).apply();
        stroke = this.f3770a.f3769a.d;
        stroke.a(i);
        imageView = this.f3770a.f3769a.s;
        imageView.setImageDrawable(new q(this.f3770a.f3769a.getActivity(), i));
    }
}
