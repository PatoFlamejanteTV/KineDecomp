package com.nexstreaming.kinemaster.ui.projectedit;

import com.nextreaming.nexeditorui.ColorPickerPopup;

/* compiled from: HandwritingEditFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.ab, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1844ab implements ColorPickerPopup.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewOnClickListenerC1853bb f22215a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1844ab(ViewOnClickListenerC1853bb viewOnClickListenerC1853bb) {
        this.f22215a = viewOnClickListenerC1853bb;
    }

    @Override // com.nextreaming.nexeditorui.ColorPickerPopup.b
    public void a(int i, boolean z) {
        this.f22215a.f22273a.fa = null;
        this.f22215a.f22273a.Ba();
    }
}
