package com.nexstreaming.kinemaster.mediaprep;

import android.content.DialogInterface;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
public class o implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaStoreItemId f20812a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.mediastore.item.c f20813b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ MediaPrepManager f20814c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(MediaPrepManager mediaPrepManager, MediaStoreItemId mediaStoreItemId, com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        this.f20814c = mediaPrepManager;
        this.f20812a = mediaStoreItemId;
        this.f20813b = cVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        MediaPrepManager mediaPrepManager = this.f20814c;
        MediaStoreItemId mediaStoreItemId = this.f20812a;
        com.nexstreaming.kinemaster.mediastore.item.c cVar = this.f20813b;
        mediaPrepManager.a(mediaStoreItemId, cVar, cVar.getPath());
        dialogInterface.dismiss();
    }
}
