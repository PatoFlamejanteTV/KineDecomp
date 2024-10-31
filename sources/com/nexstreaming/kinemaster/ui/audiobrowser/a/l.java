package com.nexstreaming.kinemaster.ui.audiobrowser.a;

import com.nexstreaming.kinemaster.ui.audiobrowser.a.k;
import java.util.Comparator;

/* compiled from: ThemeMusicLister.java */
/* loaded from: classes.dex */
class l implements Comparator<k.a> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f3666a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.f3666a = kVar;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(k.a aVar, k.a aVar2) {
        return aVar.b.compareTo(aVar2.b);
    }
}
