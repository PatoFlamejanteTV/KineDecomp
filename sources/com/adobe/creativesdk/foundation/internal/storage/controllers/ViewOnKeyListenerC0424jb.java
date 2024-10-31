package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.view.KeyEvent;
import android.view.View;
import com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetViewFragment.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.jb, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class ViewOnKeyListenerC0424jb implements View.OnKeyListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AbstractC0414hb.b f6152a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnKeyListenerC0424jb(AbstractC0414hb.b bVar) {
        this.f6152a = bVar;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i != 111) {
            return false;
        }
        AbstractC0414hb.this.A();
        return false;
    }
}
