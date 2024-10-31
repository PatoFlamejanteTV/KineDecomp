package com.google.android.gms.internal;

import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ch implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1474a;
    final /* synthetic */ String b;
    final /* synthetic */ zzfe c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(zzfe zzfeVar, String str, String str2) {
        this.c = zzfeVar;
        this.f1474a = str;
        this.b = str2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Context context;
        context = this.c.mContext;
        try {
            ((DownloadManager) context.getSystemService("download")).enqueue(this.c.zzg(this.f1474a, this.b));
        } catch (IllegalStateException e) {
            this.c.zzak("Could not store picture.");
        }
    }
}
