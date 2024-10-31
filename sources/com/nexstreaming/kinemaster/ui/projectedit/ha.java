package com.nexstreaming.kinemaster.ui.projectedit;

import android.text.Editable;
import android.text.TextWatcher;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: FullScreenInputActivity.java */
/* loaded from: classes2.dex */
class Ha implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    int f21885a;

    /* renamed from: b, reason: collision with root package name */
    String f21886b;

    /* renamed from: c, reason: collision with root package name */
    int f21887c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ FullScreenInputActivity f21888d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ha(FullScreenInputActivity fullScreenInputActivity) {
        this.f21888d = fullScreenInputActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        boolean z;
        z = this.f21888d.f21859g;
        if (z) {
            String obj = this.f21888d.f21853a.getText().toString();
            if (com.nexstreaming.kinemaster.project.k.g(obj).getAbsolutePath().getBytes().length > 200) {
                this.f21888d.b(R.string.project_rename_fail_too_long);
                if (com.nexstreaming.kinemaster.project.k.g(this.f21886b).getAbsolutePath().getBytes().length > 200) {
                    if (this.f21886b.length() < obj.length()) {
                        this.f21887c = this.f21888d.f21853a.getSelectionEnd() - this.f21885a;
                        this.f21888d.f21853a.setText(this.f21886b);
                        return;
                    }
                    return;
                }
                this.f21887c = this.f21886b.length() <= this.f21888d.f21853a.getSelectionEnd() + (-1) ? this.f21886b.length() : this.f21888d.f21853a.getSelectionEnd() - this.f21885a;
                this.f21888d.f21853a.setText(this.f21886b);
            }
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z;
        z = this.f21888d.f21859g;
        if (z) {
            this.f21886b = charSequence.toString();
            this.f21885a = i3 - i2;
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z;
        int i4;
        z = this.f21888d.f21859g;
        if (!z || (i4 = this.f21887c) <= 0) {
            return;
        }
        if (i4 > this.f21888d.f21853a.length()) {
            this.f21888d.f21853a.setSelection(r1.length() - 1);
        } else {
            this.f21888d.f21853a.setSelection(this.f21887c);
        }
        this.f21887c = 0;
    }
}
