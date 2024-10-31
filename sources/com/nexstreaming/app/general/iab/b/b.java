package com.nexstreaming.app.general.iab.b;

import com.nexstreaming.app.general.iab.Purchase;
import java.util.Comparator;

/* compiled from: WxIABHelper.java */
/* loaded from: classes.dex */
class b implements Comparator<Purchase> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f3158a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f3158a = aVar;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Purchase purchase, Purchase purchase2) {
        if (purchase.c().getTime() > purchase2.c().getTime()) {
            return -1;
        }
        return purchase.c().getTime() > purchase2.c().getTime() ? 1 : 0;
    }
}
