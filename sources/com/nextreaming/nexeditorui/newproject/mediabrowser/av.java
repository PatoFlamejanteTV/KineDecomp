package com.nextreaming.nexeditorui.newproject.mediabrowser;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaBrowserFragment.java */
/* loaded from: classes.dex */
public class av implements DialogInterface.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaBrowserFragment f4718a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(MediaBrowserFragment mediaBrowserFragment) {
        this.f4718a = mediaBrowserFragment;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f4718a.D = null;
    }
}
