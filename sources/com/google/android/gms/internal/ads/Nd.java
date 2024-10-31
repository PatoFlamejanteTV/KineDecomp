package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Nd implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f11706a;

    /* renamed from: b */
    private final /* synthetic */ String f11707b;

    /* renamed from: c */
    private final /* synthetic */ boolean f11708c;

    /* renamed from: d */
    private final /* synthetic */ boolean f11709d;

    public Nd(zzazj zzazjVar, Context context, String str, boolean z, boolean z2) {
        this.f11706a = context;
        this.f11707b = str;
        this.f11708c = z;
        this.f11709d = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f11706a);
        builder.setMessage(this.f11707b);
        if (this.f11708c) {
            builder.setTitle("Error");
        } else {
            builder.setTitle("Info");
        }
        if (this.f11709d) {
            builder.setNeutralButton("Dismiss", (DialogInterface.OnClickListener) null);
        } else {
            builder.setPositiveButton("Learn More", new Od(this));
            builder.setNegativeButton("Dismiss", (DialogInterface.OnClickListener) null);
        }
        builder.create().show();
    }
}
