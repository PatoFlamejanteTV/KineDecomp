package com.nexstreaming.kinemaster.ui.share;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExportAndShareActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.share.t, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class DialogInterfaceOnClickListenerC2235t implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ V f23384a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ExportAndShareActivity f23385b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterfaceOnClickListenerC2235t(ExportAndShareActivity exportAndShareActivity, V v) {
        this.f23385b = exportAndShareActivity;
        this.f23384a = v;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ExportedVideoDatabase exportedVideoDatabase;
        ExportAndShareActivity exportAndShareActivity = this.f23385b;
        exportedVideoDatabase = exportAndShareActivity.ca;
        exportAndShareActivity.a(exportedVideoDatabase, this.f23384a);
        dialogInterface.dismiss();
    }
}
