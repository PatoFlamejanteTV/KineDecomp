package com.google.android.gms.phenotype;

import java.util.Comparator;

/* loaded from: classes2.dex */
final class e implements Comparator<zzi> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzi zziVar, zzi zziVar2) {
        zzi zziVar3 = zziVar;
        zzi zziVar4 = zziVar2;
        int i = zziVar3.i;
        int i2 = zziVar4.i;
        return i == i2 ? zziVar3.f14112b.compareTo(zziVar4.f14112b) : i - i2;
    }
}
