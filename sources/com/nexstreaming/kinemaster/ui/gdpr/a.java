package com.nexstreaming.kinemaster.ui.gdpr;

import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.gdpr.ConfirmFragment;

/* compiled from: ConfirmFragment.java */
/* loaded from: classes.dex */
class a implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ConfirmFragment f21588a;

    public a(ConfirmFragment confirmFragment) {
        this.f21588a = confirmFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ConfirmFragment.a aVar;
        ConfirmFragment.a aVar2;
        aVar = this.f21588a.f21587b;
        if (aVar != null) {
            ConfirmFragment.BUTTON button = ConfirmFragment.BUTTON.OK;
            if (view.getId() == R.id.cancel_button) {
                button = ConfirmFragment.BUTTON.CANCEL;
            }
            aVar2 = this.f21588a.f21587b;
            aVar2.a(button);
        }
    }
}
