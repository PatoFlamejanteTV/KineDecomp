package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ListView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionListFragment.java */
/* loaded from: classes.dex */
public class ef implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ed f3866a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ef(ed edVar) {
        this.f3866a = edVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ListView listView;
        ListView listView2;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(view.getContext());
        if (defaultSharedPreferences.getBoolean("km.optionListGrid", false)) {
            defaultSharedPreferences.edit().putBoolean("km.optionListGrid", false).apply();
            this.f3866a.f();
            listView = this.f3866a.f3864a;
            listView2 = this.f3866a.f3864a;
            listView.setSelection(listView2.getCount() - 1);
        }
    }
}
