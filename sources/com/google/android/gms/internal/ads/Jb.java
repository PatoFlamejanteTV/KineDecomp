package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Jb implements DialogInterface.OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ zzanx f11621a;

    public Jb(zzanx zzanxVar) {
        this.f11621a = zzanxVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f11621a.zzda("Operation denied by user.");
    }
}
