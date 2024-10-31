package com.nextreaming.nexeditorui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExpiredActivity.java */
/* loaded from: classes.dex */
public class C implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Activity f23983a;

    public C(Activity activity) {
        this.f23983a = activity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("market://details?id=com.nexstreaming.app.kinemasterfree"));
        this.f23983a.startActivity(intent);
    }
}
