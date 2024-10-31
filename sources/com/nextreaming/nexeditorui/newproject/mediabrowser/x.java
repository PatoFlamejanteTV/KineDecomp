package com.nextreaming.nexeditorui.newproject.mediabrowser;

import android.content.DialogInterface;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;

/* compiled from: MediaBrowserFragment.java */
/* loaded from: classes.dex */
class x implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MediaStoreItem f4746a;
    final /* synthetic */ u b;

    public x(u uVar, MediaStoreItem mediaStoreItem) {
        this.b = uVar;
        this.f4746a = mediaStoreItem;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.nexstreaming.kinemaster.mediastore.v2.b bVar;
        bVar = this.b.f4743a.u;
        bVar.c(this.f4746a.c());
        dialogInterface.dismiss();
    }
}
