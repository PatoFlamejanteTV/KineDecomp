package com.nexstreaming.kinemaster.ui.settings;

import com.nexstreaming.kinemaster.ui.widget.DurationSpinner;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NewSettingFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.settings.fa, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2167fa implements DurationSpinner.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2202xa f23140a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2167fa(C2202xa c2202xa) {
        this.f23140a = c2202xa;
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.DurationSpinner.a
    public void a(float f2) {
        this.f23140a.q = (int) (f2 * 1000.0f);
    }
}
