package com.nexstreaming.kinemaster.ui.settings;

import com.nexstreaming.kinemaster.ui.widget.DurationSpinner;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NewSettingFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.settings.da, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2163da implements DurationSpinner.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2202xa f23133a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2163da(C2202xa c2202xa) {
        this.f23133a = c2202xa;
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.DurationSpinner.a
    public void a(float f2) {
        this.f23133a.p = (int) (f2 * 1000.0f);
    }
}
