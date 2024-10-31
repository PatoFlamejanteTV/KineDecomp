package com.nextreaming.nexeditorui.newproject.mediabrowser;

import android.content.DialogInterface;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;

/* compiled from: MediaBrowserFragment.java */
/* loaded from: classes.dex */
class z implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MediaStoreItem f4748a;
    final /* synthetic */ u b;

    public z(u uVar, MediaStoreItem mediaStoreItem) {
        this.b = uVar;
        this.f4748a = mediaStoreItem;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.nexstreaming.kinemaster.mediastore.v2.b bVar;
        bVar = this.b.f4743a.u;
        bVar.b(this.f4748a.c());
        dialogInterface.dismiss();
    }
}
