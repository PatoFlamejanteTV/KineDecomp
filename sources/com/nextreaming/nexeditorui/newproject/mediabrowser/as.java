package com.nextreaming.nexeditorui.newproject.mediabrowser;

import android.content.DialogInterface;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nextreaming.nexeditorui.newproject.mediabrowser.MediaBrowserFragment;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaBrowserFragment.java */
/* loaded from: classes.dex */
public class as implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaStoreItem f4715a;
    final /* synthetic */ MediaBrowserFragment b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(MediaBrowserFragment mediaBrowserFragment, MediaStoreItem mediaStoreItem) {
        this.b = mediaBrowserFragment;
        this.f4715a = mediaStoreItem;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        MediaBrowserFragment.b bVar;
        int i2;
        boolean z;
        bVar = this.b.t;
        MediaStoreItem mediaStoreItem = this.f4715a;
        i2 = this.b.e;
        bVar.a(mediaStoreItem, i2);
        dialogInterface.dismiss();
        if (!this.f4715a.p().isNotSupported()) {
            z = this.b.h;
            if (z) {
                this.b.getFragmentManager().popBackStack();
            }
        }
    }
}
