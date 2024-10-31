package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Nb implements DialogInterface.OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ zzaod f11703a;

    public Nb(zzaod zzaodVar) {
        this.f11703a = zzaodVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f11703a.zzda("User canceled the download.");
    }
}
