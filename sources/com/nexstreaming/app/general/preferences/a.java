package com.nexstreaming.app.general.preferences;

import android.view.View;

/* compiled from: NexButtonPreference.java */
/* loaded from: classes2.dex */
class a implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ NexButtonPreference f19662a;

    public a(NexButtonPreference nexButtonPreference) {
        this.f19662a = nexButtonPreference;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f19662a.getOnPreferenceClickListener() != null) {
            this.f19662a.getOnPreferenceClickListener().onPreferenceClick(this.f19662a);
        }
    }
}
