package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
import android.widget.EditText;

/* loaded from: classes2.dex */
final class Bf implements DialogInterface.OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ JsPromptResult f11403a;

    /* renamed from: b */
    private final /* synthetic */ EditText f11404b;

    public Bf(JsPromptResult jsPromptResult, EditText editText) {
        this.f11403a = jsPromptResult;
        this.f11404b = editText;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f11403a.confirm(this.f11404b.getText().toString());
    }
}
