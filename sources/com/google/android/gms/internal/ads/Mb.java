package com.google.android.gms.internal.ads;

import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Environment;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Mb implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f11678a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f11679b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzaod f11680c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Mb(zzaod zzaodVar, String str, String str2) {
        this.f11680c = zzaodVar;
        this.f11678a = str;
        this.f11679b = str2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Context context;
        context = this.f11680c.mContext;
        DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
        try {
            String str = this.f11678a;
            String str2 = this.f11679b;
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
            com.google.android.gms.ads.internal.zzbv.g().zza(request);
            downloadManager.enqueue(request);
        } catch (IllegalStateException unused) {
            this.f11680c.zzda("Could not store picture.");
        }
    }
}
