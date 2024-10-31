package com.nexstreaming.kinemaster.ui.share;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExportAndShareActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.share.j, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class ViewOnClickListenerC2225j implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ExportAndShareActivity f23356a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC2225j(ExportAndShareActivity exportAndShareActivity) {
        this.f23356a = exportAndShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f23356a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://support.kinemaster.com/hc/articles/115000073001")));
    }
}
