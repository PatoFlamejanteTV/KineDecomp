package com.nexstreaming.kinemaster.ui.b;

import android.view.View;
import com.nextreaming.nexeditorui.ColorPickerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EffectSettingsFragment.java */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ColorPickerView f3700a;
    final /* synthetic */ f b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(f fVar, ColorPickerView colorPickerView) {
        this.b = fVar;
        this.f3700a = colorPickerView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3700a.a(true);
    }
}
