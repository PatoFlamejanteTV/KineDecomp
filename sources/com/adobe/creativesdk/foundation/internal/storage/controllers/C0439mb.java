package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetViewFragment.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.mb, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0439mb implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f6254a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AbstractC0414hb.b f6255b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0439mb(AbstractC0414hb.b bVar, View view) {
        this.f6255b = bVar;
        this.f6254a = view;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (this.f6254a == null) {
            return;
        }
        if (!editable.toString().equals("")) {
            this.f6254a.setBackgroundResource(c.a.a.a.b.d.search_box_appearance_query);
        } else {
            this.f6254a.setBackgroundResource(c.a.a.a.b.d.search_box_appearance);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
