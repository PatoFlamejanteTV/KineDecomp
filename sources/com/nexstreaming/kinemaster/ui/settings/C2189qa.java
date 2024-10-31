package com.nexstreaming.kinemaster.ui.settings;

import android.view.View;
import android.widget.CompoundButton;

/* compiled from: NewSettingFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.settings.qa */
/* loaded from: classes2.dex */
public class C2189qa implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ View f23181a;

    /* renamed from: b */
    final /* synthetic */ C2202xa f23182b;

    public C2189qa(C2202xa c2202xa, View view) {
        this.f23182b = c2202xa;
        this.f23181a = view;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f23182b.s = z;
        if (!z) {
            this.f23181a.setVisibility(0);
            this.f23181a.setAlpha(0.0f);
            this.f23181a.setTranslationY(0.0f);
            this.f23181a.animate().translationY(1.0f).alpha(1.0f).setDuration(100L).setListener(new C2185oa(this));
            return;
        }
        this.f23181a.setAlpha(1.0f);
        this.f23181a.setTranslationY(1.0f);
        this.f23181a.animate().translationY(0.0f).alpha(0.0f).setDuration(150L).setListener(new C2187pa(this));
    }
}
