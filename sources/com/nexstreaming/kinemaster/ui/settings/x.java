package com.nexstreaming.kinemaster.ui.settings;

import android.support.v7.widget.SwitchCompat;
import android.widget.CompoundButton;
import com.nexstreaming.kinemaster.ui.projectedit.Slider;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NewSettingFragment.java */
/* loaded from: classes2.dex */
public class X implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Slider f23096a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SwitchCompat f23097b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C2202xa f23098c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public X(C2202xa c2202xa, Slider slider, SwitchCompat switchCompat) {
        this.f23098c = c2202xa;
        this.f23096a = slider;
        this.f23097b = switchCompat;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f23098c.n = z;
        this.f23096a.setEnabled(z);
        this.f23097b.setChecked(z);
    }
}
