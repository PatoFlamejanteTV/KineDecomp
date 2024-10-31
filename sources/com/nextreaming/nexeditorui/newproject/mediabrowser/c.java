package com.nextreaming.nexeditorui.newproject.mediabrowser;

import android.view.View;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaBrowserFragment.java */
/* loaded from: classes.dex */
public class c implements View.OnLongClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaStoreItem f4725a;
    final /* synthetic */ MediaBrowserFragment b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(MediaBrowserFragment mediaBrowserFragment, MediaStoreItem mediaStoreItem) {
        this.b = mediaBrowserFragment;
        this.f4725a = mediaStoreItem;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (this.f4725a.n()) {
            com.nexstreaming.kinemaster.mediainfo.ad.a(this.b.getActivity(), (String) null, this.f4725a);
            return false;
        }
        com.nexstreaming.kinemaster.mediainfo.ad.a(this.b.getActivity(), this.f4725a.h(), null);
        return false;
    }
}
