package com.adobe.creativesdk.foundation.internal.settings;

import android.view.View;

/* compiled from: CloudPickerActivity.java */
/* loaded from: classes.dex */
class b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CloudPickerActivity f5202a;

    public b(CloudPickerActivity cloudPickerActivity) {
        this.f5202a = cloudPickerActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f5202a.onBackPressed();
    }
}
