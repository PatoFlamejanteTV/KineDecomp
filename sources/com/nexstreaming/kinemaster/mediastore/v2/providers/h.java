package com.nexstreaming.kinemaster.mediastore.v2.providers;

import android.content.Context;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import java.util.Comparator;

/* compiled from: AndroidMediaStoreProvider.java */
/* loaded from: classes.dex */
class h implements Comparator<MediaStoreItem> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f3582a;
    final /* synthetic */ AndroidMediaStoreProvider b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AndroidMediaStoreProvider androidMediaStoreProvider, int i) {
        this.b = androidMediaStoreProvider;
        this.f3582a = i;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(MediaStoreItem mediaStoreItem, MediaStoreItem mediaStoreItem2) {
        Context context;
        Context context2;
        int i = this.f3582a;
        context = this.b.e;
        String a2 = mediaStoreItem.a(context);
        context2 = this.b.e;
        return i * a2.compareTo(mediaStoreItem2.a(context2));
    }
}
