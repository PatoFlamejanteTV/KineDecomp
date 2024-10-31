package com.nextreaming.nexeditorui.newproject.mediabrowser;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaBrowserFragment.java */
/* loaded from: classes.dex */
public class aw implements DialogInterface.OnShowListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaBrowserFragment f4719a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(MediaBrowserFragment mediaBrowserFragment) {
        this.f4719a = mediaBrowserFragment;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        if (this.f4719a.isDetached() || this.f4719a.isRemoving()) {
            dialogInterface.dismiss();
        }
    }
}
