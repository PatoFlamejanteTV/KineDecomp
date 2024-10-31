package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.view.View;
import com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetViewFragment.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.nb, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class ViewOnClickListenerC0447nb implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private boolean f6344a = false;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AbstractC0414hb.b f6345b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC0447nb(AbstractC0414hb.b bVar) {
        this.f6345b = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f6344a) {
            return;
        }
        this.f6344a = true;
        view.getLayoutParams().width = -1;
    }
}
