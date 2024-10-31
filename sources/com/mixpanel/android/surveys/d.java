package com.mixpanel.android.surveys;

import com.mixpanel.android.mpmetrics.Survey;
import com.mixpanel.android.surveys.CardCarouselLayout;

/* compiled from: CardCarouselLayout.java */
/* loaded from: classes.dex */
class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3066a;
    final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str) {
        this.b = cVar;
        this.f3066a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        CardCarouselLayout.b bVar;
        Survey.a aVar;
        bVar = CardCarouselLayout.this.h;
        aVar = this.b.b.b;
        bVar.a(aVar, this.f3066a);
    }
}
