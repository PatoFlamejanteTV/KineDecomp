package com.mixpanel.android.surveys;

import android.view.KeyEvent;
import android.widget.TextView;
import com.mixpanel.android.mpmetrics.Survey;
import com.mixpanel.android.surveys.CardCarouselLayout;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CardCarouselLayout.java */
/* loaded from: classes.dex */
public class b implements TextView.OnEditorActionListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CardCarouselLayout f3064a;
    final /* synthetic */ CardCarouselLayout.c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(CardCarouselLayout.c cVar, CardCarouselLayout cardCarouselLayout) {
        this.b = cVar;
        this.f3064a = cardCarouselLayout;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        CardCarouselLayout.b bVar;
        CardCarouselLayout.b bVar2;
        Survey.a aVar;
        if (!(keyEvent != null && keyEvent.getKeyCode() == 66 && keyEvent.getAction() == 0 && (keyEvent.getFlags() & 32) == 0) && i != 6) {
            return false;
        }
        textView.clearComposingText();
        bVar = CardCarouselLayout.this.h;
        if (bVar != null) {
            String charSequence = textView.getText().toString();
            bVar2 = CardCarouselLayout.this.h;
            aVar = this.b.b;
            bVar2.a(aVar, charSequence);
        }
        return true;
    }
}
