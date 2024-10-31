package com.nexstreaming.kinemaster.ui.store.controller;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.UnderlineSpan;
import com.nexstreaming.kinemaster.ui.store.controller.Ja;

/* compiled from: AudioPageAssetListAdapter.java */
/* loaded from: classes2.dex */
class Ia extends UnderlineSpan {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Ja.a f23450a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ia(Ja.a aVar) {
        this.f23450a = aVar;
    }

    @Override // android.text.style.UnderlineSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setUnderlineText(false);
        textPaint.setColor(Color.parseColor("#ff5b5b"));
    }
}
