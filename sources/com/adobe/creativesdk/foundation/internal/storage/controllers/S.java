package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.view.View;

/* compiled from: AdobeStorageSettingsFragment.java */
/* loaded from: classes.dex */
class S implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ U f5813a;

    public S(U u) {
        this.f5813a = u;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f5813a.a(view, "https://accounts.adobe.com");
    }
}
