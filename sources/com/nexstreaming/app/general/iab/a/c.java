package com.nexstreaming.app.general.iab.a;

import com.nexstreaming.app.general.iab.IABHelper;
import com.nexstreaming.app.general.iab.Purchase;
import java.util.List;

/* compiled from: GoogleIABHelper.java */
/* loaded from: classes.dex */
class c implements IABHelper.f {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f3145a;
    final /* synthetic */ int b;
    final /* synthetic */ a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, List list, int i) {
        this.c = aVar;
        this.f3145a = list;
        this.b = i;
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper.f
    public void a(Purchase purchase, int i) {
        ((List) this.f3145a.get((((((IABHelper.f3141a >> 24) & 15) ^ i) + this.b) - 2) & 7)).add(purchase);
    }
}
