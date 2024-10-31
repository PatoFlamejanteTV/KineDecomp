package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.layer.handwriting.Stroke;
import com.nextreaming.nexeditorui.ColorPickerPopup;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HandwritingEditFragment.java */
/* loaded from: classes.dex */
public class ap implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ HandwritingEditFragment f3769a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(HandwritingEditFragment handwritingEditFragment) {
        this.f3769a = handwritingEditFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Stroke stroke;
        if (this.f3769a.isAdded()) {
            ColorPickerPopup colorPickerPopup = new ColorPickerPopup(this.f3769a.getActivity(), true);
            this.f3769a.B = new WeakReference(colorPickerPopup);
            stroke = this.f3769a.d;
            colorPickerPopup.a(stroke.g());
            colorPickerPopup.a(new aq(this));
            colorPickerPopup.a(new ar(this));
            this.f3769a.P();
            colorPickerPopup.e();
        }
    }
}
