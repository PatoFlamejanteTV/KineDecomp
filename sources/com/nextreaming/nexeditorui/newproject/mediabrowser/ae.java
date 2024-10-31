package com.nextreaming.nexeditorui.newproject.mediabrowser;

import android.content.DialogInterface;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStore;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaBrowserFragment.java */
/* loaded from: classes.dex */
public class ae implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f4701a;
    final /* synthetic */ MediaStoreItem b;
    final /* synthetic */ MediaBrowserFragment c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(MediaBrowserFragment mediaBrowserFragment, boolean z, MediaStoreItem mediaStoreItem) {
        this.c = mediaBrowserFragment;
        this.f4701a = z;
        this.b = mediaStoreItem;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        MediaStore mediaStore;
        MediaStore mediaStore2;
        dialogInterface.dismiss();
        if (!this.f4701a) {
            mediaStore = this.c.s;
            if (mediaStore.d(this.b)) {
                mediaStore2 = this.c.s;
                mediaStore2.f(this.b);
            }
        }
    }
}
