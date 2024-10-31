package android.support.design.widget;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextInputLayout.java */
/* loaded from: classes.dex */
public class L implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TextInputLayout f427a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public L(TextInputLayout textInputLayout) {
        this.f427a = textInputLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f427a.d(false);
    }
}
