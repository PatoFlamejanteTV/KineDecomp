package com.nextreaming.nexeditorui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;

/* compiled from: ExpiredActivity.java */
/* loaded from: classes.dex */
final class ad implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f4511a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(Activity activity) {
        this.f4511a = activity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://play.google.com/apps/testing/com.nexstreaming.app.kinemasterfree"));
        this.f4511a.startActivity(intent);
    }
}
