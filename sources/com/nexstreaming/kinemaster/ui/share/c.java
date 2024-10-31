package com.nexstreaming.kinemaster.ui.share;

import android.content.DialogInterface;

/* compiled from: ExportDialogFragment.java */
/* loaded from: classes.dex */
class c implements DialogInterface.OnShowListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f4338a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.f4338a = aVar;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        int i;
        if (this.f4338a.a() != null) {
            i = this.f4338a.c;
            if (i <= 0) {
                this.f4338a.a().hide();
            }
        }
    }
}
