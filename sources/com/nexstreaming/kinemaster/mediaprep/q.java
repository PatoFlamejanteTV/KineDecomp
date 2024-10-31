package com.nexstreaming.kinemaster.mediaprep;

import android.content.DialogInterface;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
public class q implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MSID f3540a;
    final /* synthetic */ MediaStoreItem b;
    final /* synthetic */ MediaPrepManager c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(MediaPrepManager mediaPrepManager, MSID msid, MediaStoreItem mediaStoreItem) {
        this.c = mediaPrepManager;
        this.f3540a = msid;
        this.b = mediaStoreItem;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.c.a(this.f3540a, this.b, this.b.h());
        dialogInterface.dismiss();
    }
}
