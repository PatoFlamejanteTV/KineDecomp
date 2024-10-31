package com.nexstreaming.kinemaster.support;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;

/* compiled from: SupportInputActivity.java */
/* loaded from: classes.dex */
public class o implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ SupportInputActivity f21252a;

    public o(SupportInputActivity supportInputActivity) {
        this.f21252a = supportInputActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Button button;
        Button button2;
        if (i3 > 0) {
            button2 = this.f21252a.f21232d;
            button2.setEnabled(true);
        } else {
            button = this.f21252a.f21232d;
            button.setEnabled(false);
        }
    }
}
