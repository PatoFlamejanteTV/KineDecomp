package com.nexstreaming.kinemaster.mediastore.v2.providers;

import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import java.util.Comparator;

/* compiled from: GoogleDriveMediaStoreProvider.java */
/* loaded from: classes.dex */
class ab implements Comparator<MediaStoreItem> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f3574a;
    final /* synthetic */ l b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(l lVar, int i) {
        this.b = lVar;
        this.f3574a = i;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(MediaStoreItem mediaStoreItem, MediaStoreItem mediaStoreItem2) {
        return this.f3574a * mediaStoreItem.f().compareTo(mediaStoreItem2.f());
    }
}
