package com.nexstreaming.kinemaster.support;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;

/* compiled from: ChoiceCloudActivity.java */
/* loaded from: classes.dex */
public class a implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ChoiceCloudActivity f21237a;

    public a(ChoiceCloudActivity choiceCloudActivity) {
        this.f21237a = choiceCloudActivity;
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
            button2 = this.f21237a.f21217e;
            button2.setEnabled(true);
        } else {
            button = this.f21237a.f21217e;
            button.setEnabled(false);
        }
    }
}
