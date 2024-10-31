package com.nexstreaming.kinemaster.mediastore.v2.providers;

import android.app.Activity;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import java.util.Comparator;

/* compiled from: GoogleDriveMediaStoreProvider.java */
/* loaded from: classes.dex */
class aa implements Comparator<MediaStoreItem> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f3573a;
    final /* synthetic */ l b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(l lVar, int i) {
        this.b = lVar;
        this.f3573a = i;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(MediaStoreItem mediaStoreItem, MediaStoreItem mediaStoreItem2) {
        Activity activity;
        Activity activity2;
        int i = this.f3573a;
        activity = this.b.j;
        String a2 = mediaStoreItem.a(activity);
        activity2 = this.b.j;
        return i * a2.compareTo(mediaStoreItem2.a(activity2));
    }
}
