package com.google.android.gms.internal;

import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements Comparator<String> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbm f1668a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(zzbm zzbmVar) {
        this.f1668a = zzbmVar;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(String str, String str2) {
        return str2.length() - str.length();
    }
}
