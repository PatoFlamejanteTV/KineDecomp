package com.nextreaming.nexeditorui.newproject.mediabrowser;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaBrowserFragment.java */
/* loaded from: classes.dex */
public class o implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaBrowserFragment f4737a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(MediaBrowserFragment mediaBrowserFragment) {
        this.f4737a = mediaBrowserFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
