package com.nexstreaming.kinemaster.mediaprep;

import android.content.DialogInterface;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
public class p implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaStoreItemId f20815a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.mediastore.item.c f20816b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ MediaPrepManager f20817c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(MediaPrepManager mediaPrepManager, MediaStoreItemId mediaStoreItemId, com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        this.f20817c = mediaPrepManager;
        this.f20815a = mediaStoreItemId;
        this.f20816b = cVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        MediaPrepManager mediaPrepManager = this.f20817c;
        MediaStoreItemId mediaStoreItemId = this.f20815a;
        com.nexstreaming.kinemaster.mediastore.item.c cVar = this.f20816b;
        mediaPrepManager.a(mediaStoreItemId, cVar, cVar.getPath());
        dialogInterface.dismiss();
    }
}
