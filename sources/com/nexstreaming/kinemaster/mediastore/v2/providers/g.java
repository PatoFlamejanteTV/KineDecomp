package com.nexstreaming.kinemaster.mediastore.v2.providers;

import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import java.util.Comparator;

/* compiled from: AndroidMediaStoreProvider.java */
/* loaded from: classes.dex */
class g implements Comparator<MediaStoreItem> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f3581a;
    final /* synthetic */ AndroidMediaStoreProvider b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AndroidMediaStoreProvider androidMediaStoreProvider, int i) {
        this.b = androidMediaStoreProvider;
        this.f3581a = i;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(MediaStoreItem mediaStoreItem, MediaStoreItem mediaStoreItem2) {
        return this.f3581a * mediaStoreItem.f().compareTo(mediaStoreItem2.f());
    }
}
