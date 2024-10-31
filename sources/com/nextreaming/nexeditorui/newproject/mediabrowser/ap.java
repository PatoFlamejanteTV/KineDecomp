package com.nextreaming.nexeditorui.newproject.mediabrowser;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaBrowserFragment.java */
/* loaded from: classes.dex */
public class ap implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaBrowserFragment f4712a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(MediaBrowserFragment mediaBrowserFragment) {
        this.f4712a = mediaBrowserFragment;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
    }
}
