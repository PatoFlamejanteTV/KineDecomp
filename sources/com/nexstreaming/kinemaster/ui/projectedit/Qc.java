package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ListView;

/* compiled from: OptionListFragment.java */
/* loaded from: classes2.dex */
public class Qc implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Xc f22034a;

    public Qc(Xc xc) {
        this.f22034a = xc;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ListView listView;
        ListView listView2;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(view.getContext());
        if (defaultSharedPreferences.getBoolean("km.optionListGrid", false)) {
            defaultSharedPreferences.edit().putBoolean("km.optionListGrid", false).apply();
            this.f22034a.na();
            listView = this.f22034a.l;
            listView2 = this.f22034a.l;
            listView.setSelection(listView2.getCount() - 1);
        }
    }
}
