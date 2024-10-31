package com.adobe.creativesdk.foundation.internal.utils;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDialogFragment.java */
/* loaded from: classes.dex */
public class h implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ j f6856a;

    public h(j jVar) {
        this.f6856a = jVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (z) {
            this.f6856a.f6860c.post(new g(this));
        }
    }
}
