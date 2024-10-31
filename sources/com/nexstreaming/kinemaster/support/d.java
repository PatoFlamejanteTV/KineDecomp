package com.nexstreaming.kinemaster.support;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SupportInputActivity.java */
/* loaded from: classes.dex */
public class d implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SupportInputActivity f3633a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(SupportInputActivity supportInputActivity) {
        this.f3633a = supportInputActivity;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Button button;
        Button button2;
        if (i3 > 0) {
            button2 = this.f3633a.d;
            button2.setEnabled(true);
        } else {
            button = this.f3633a.d;
            button.setEnabled(false);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
