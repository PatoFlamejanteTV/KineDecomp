package com.adobe.creativesdk.foundation.internal.utils;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;

/* compiled from: AdobeDialogFragment.java */
/* loaded from: classes.dex */
class g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ h f6855a;

    public g(h hVar) {
        this.f6855a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f6855a.f6856a.getActivity() != null) {
            Context applicationContext = this.f6855a.f6856a.getActivity().getApplicationContext();
            this.f6855a.f6856a.getActivity();
            ((InputMethodManager) applicationContext.getSystemService("input_method")).showSoftInput(this.f6855a.f6856a.f6860c, 1);
        }
    }
}
