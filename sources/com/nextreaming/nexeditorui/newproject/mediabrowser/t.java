package com.nextreaming.nexeditorui.newproject.mediabrowser;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaBrowserFragment.java */
/* loaded from: classes.dex */
public class t implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaBrowserFragment f4742a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(MediaBrowserFragment mediaBrowserFragment) {
        this.f4742a = mediaBrowserFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
