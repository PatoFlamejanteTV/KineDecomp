package com.nexstreaming.kinemaster.mediaprep;

import android.content.DialogInterface;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
public class p implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MSID f3539a;
    final /* synthetic */ MediaStoreItem b;
    final /* synthetic */ MediaPrepManager c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(MediaPrepManager mediaPrepManager, MSID msid, MediaStoreItem mediaStoreItem) {
        this.c = mediaPrepManager;
        this.f3539a = msid;
        this.b = mediaStoreItem;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.c.a(this.f3539a, this.b, this.b.h());
        dialogInterface.dismiss();
    }
}
