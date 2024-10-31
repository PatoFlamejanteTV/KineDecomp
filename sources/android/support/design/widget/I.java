package android.support.design.widget;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextInputLayout.java */
/* loaded from: classes.dex */
public class I implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TextInputLayout f423a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public I(TextInputLayout textInputLayout) {
        this.f423a = textInputLayout;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        boolean z;
        TextInputLayout textInputLayout = this.f423a;
        z = textInputLayout.O;
        textInputLayout.a(!z);
        TextInputLayout textInputLayout2 = this.f423a;
        if (textInputLayout2.p) {
            textInputLayout2.a(editable.length());
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
