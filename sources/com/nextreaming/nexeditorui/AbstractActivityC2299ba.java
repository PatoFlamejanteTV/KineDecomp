package com.nextreaming.nexeditorui;

import android.databinding.ViewDataBinding;
import android.os.Bundle;

/* compiled from: KineMasterBindingActivity.java */
/* renamed from: com.nextreaming.nexeditorui.ba, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractActivityC2299ba<Binding extends ViewDataBinding> extends I {
    private Binding H;

    protected abstract int G();

    public Binding H() {
        Binding binding = this.H;
        if (binding != null) {
            return binding;
        }
        throw new IllegalStateException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.H = (Binding) android.databinding.e.a(this, G());
    }
}
