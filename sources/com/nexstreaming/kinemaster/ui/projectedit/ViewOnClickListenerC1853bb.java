package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.layer.handwriting.Stroke;
import com.nextreaming.nexeditorui.ColorPickerPopup;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HandwritingEditFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.bb, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class ViewOnClickListenerC1853bb implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ HandwritingEditFragment f22273a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC1853bb(HandwritingEditFragment handwritingEditFragment) {
        this.f22273a = handwritingEditFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Stroke stroke;
        if (this.f22273a.isAdded()) {
            ColorPickerPopup colorPickerPopup = new ColorPickerPopup(this.f22273a.getActivity(), true);
            this.f22273a.fa = new WeakReference(colorPickerPopup);
            stroke = this.f22273a.H;
            colorPickerPopup.b(stroke.d());
            colorPickerPopup.a(new _a(this));
            colorPickerPopup.a(new C1844ab(this));
            this.f22273a.Aa();
            colorPickerPopup.e();
        }
    }
}
