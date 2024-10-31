package com.nexstreaming.app.general.nexasset.assetpackage;

import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetPackageManager.java */
/* loaded from: classes2.dex */
public class f implements Comparator<a> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f19530a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(h hVar) {
        this.f19530a = hVar;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(a aVar, a aVar2) {
        return aVar.getCategoryAlias().compareTo(aVar2.getCategoryAlias());
    }
}
