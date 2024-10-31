package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetViewFragment.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.ib, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class ViewOnFocusChangeListenerC0419ib implements View.OnFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AbstractC0414hb.b f6144a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnFocusChangeListenerC0419ib(AbstractC0414hb.b bVar) {
        this.f6144a = bVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (z) {
            return;
        }
        ((InputMethodManager) AbstractC0414hb.this.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
