package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.view.View;
import android.widget.TextView;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeStorageSettingsFragment.java */
/* loaded from: classes.dex */
public class T implements com.adobe.creativesdk.foundation.internal.storage.a.b.xa {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f5845a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ U f5846b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public T(U u, View view) {
        this.f5846b = u;
        this.f5845a = view;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.xa
    public void a(Number number, Number number2, Number number3) {
        boolean z;
        z = this.f5846b.f5851c;
        if (z || number == null || number2 == null || number3 == null) {
            return;
        }
        TextView textView = (TextView) this.f5845a.findViewById(c.a.a.a.b.e.adobe_csdk_storage_settings_storageUsage);
        double doubleValue = (number.doubleValue() / number3.doubleValue()) * 100.0d;
        if (doubleValue > 100.0d) {
            doubleValue = 100.0d;
        }
        if (doubleValue < 0.0d) {
            doubleValue = 0.0d;
        }
        textView.setText(String.format(this.f5846b.getString(c.a.a.a.b.i.adobe_csdk_storage_settings_storage_usage), String.format("%.2f%%", Double.valueOf(doubleValue)), String.format("%.2f", Double.valueOf(number.doubleValue())), String.format("%.2f", Double.valueOf(number3.doubleValue()))));
    }
}
