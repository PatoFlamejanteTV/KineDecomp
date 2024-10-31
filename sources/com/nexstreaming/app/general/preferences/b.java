package com.nexstreaming.app.general.preferences;

import android.view.View;

/* compiled from: NexButtonPreference.java */
/* loaded from: classes2.dex */
class b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ NexButtonPreference f19663a;

    public b(NexButtonPreference nexButtonPreference) {
        this.f19663a = nexButtonPreference;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f19663a.getOnPreferenceClickListener() != null) {
            this.f19663a.getOnPreferenceClickListener().onPreferenceClick(this.f19663a);
        }
    }
}
