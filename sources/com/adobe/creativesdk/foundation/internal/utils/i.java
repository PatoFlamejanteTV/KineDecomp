package com.adobe.creativesdk.foundation.internal.utils;

import android.view.KeyEvent;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDialogFragment.java */
/* loaded from: classes.dex */
public class i implements View.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ j f6857a;

    public i(j jVar) {
        this.f6857a = jVar;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i != 111) {
            return false;
        }
        this.f6857a.dismiss();
        return false;
    }
}
