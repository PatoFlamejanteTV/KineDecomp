package com.nexstreaming.kinemaster.mediastore.v2.providers;

import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import java.util.Comparator;

/* compiled from: GoogleDriveMediaStoreProvider.java */
/* loaded from: classes.dex */
class z implements Comparator<MediaStoreItem> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f3599a;
    final /* synthetic */ l b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(l lVar, int i) {
        this.b = lVar;
        this.f3599a = i;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(MediaStoreItem mediaStoreItem, MediaStoreItem mediaStoreItem2) {
        return this.f3599a * Long.valueOf(mediaStoreItem.i()).compareTo(Long.valueOf(mediaStoreItem2.i()));
    }
}
