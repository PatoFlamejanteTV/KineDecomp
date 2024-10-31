package com.mixpanel.android.surveys;

import android.view.View;
import android.widget.AdapterView;
import com.mixpanel.android.surveys.CardCarouselLayout;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CardCarouselLayout.java */
/* loaded from: classes.dex */
public class c implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CardCarouselLayout f3065a;
    final /* synthetic */ CardCarouselLayout.c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(CardCarouselLayout.c cVar, CardCarouselLayout cardCarouselLayout) {
        this.b = cVar;
        this.f3065a = cardCarouselLayout;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        CardCarouselLayout.b bVar;
        bVar = CardCarouselLayout.this.h;
        if (bVar != null) {
            CardCarouselLayout.this.postDelayed(new d(this, adapterView.getItemAtPosition(i).toString()), 165L);
        }
    }
}
