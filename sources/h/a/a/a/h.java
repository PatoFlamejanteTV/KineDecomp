package h.a.a.a;

import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CalligraphyUtils.java */
/* loaded from: classes3.dex */
public class h implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ Typeface f26808a;

    public h(Typeface typeface) {
        this.f26808a = typeface;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        i.a(editable, this.f26808a);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
