package com.nexstreaming.kinemaster.mediastore.v2.providers;

import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidMediaStoreProvider.java */
/* loaded from: classes.dex */
public class d implements Comparator<MediaStoreItem> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f3578a;
    final /* synthetic */ AndroidMediaStoreProvider b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AndroidMediaStoreProvider androidMediaStoreProvider, int i) {
        this.b = androidMediaStoreProvider;
        this.f3578a = i;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(MediaStoreItem mediaStoreItem, MediaStoreItem mediaStoreItem2) {
        return this.f3578a * Long.valueOf(mediaStoreItem.i()).compareTo(Long.valueOf(mediaStoreItem2.i()));
    }
}
