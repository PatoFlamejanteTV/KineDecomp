package com.nextreaming.nexeditorui.newproject.mediabrowser;

import android.content.DialogInterface;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nextreaming.nexeditorui.newproject.mediabrowser.MediaBrowserFragment;

/* compiled from: MediaBrowserFragment.java */
/* loaded from: classes.dex */
class an implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ al f4710a;

    public an(al alVar) {
        this.f4710a = alVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        MediaBrowserFragment.b bVar;
        int i2;
        boolean z;
        bVar = this.f4710a.b.t;
        MediaStoreItem mediaStoreItem = this.f4710a.f4708a;
        i2 = this.f4710a.b.e;
        bVar.a(mediaStoreItem, i2);
        if (!this.f4710a.f4708a.p().isNotSupported()) {
            z = this.f4710a.b.h;
            if (z) {
                this.f4710a.b.getFragmentManager().popBackStack();
            }
        }
        dialogInterface.dismiss();
    }
}
