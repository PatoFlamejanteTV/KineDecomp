package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ListView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionListFragment.java */
/* loaded from: classes.dex */
public class ee implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ed f3865a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ee(ed edVar) {
        this.f3865a = edVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ListView listView;
        ListView listView2;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(view.getContext());
        if (!defaultSharedPreferences.getBoolean("km.optionListGrid", false)) {
            defaultSharedPreferences.edit().putBoolean("km.optionListGrid", true).apply();
            this.f3865a.f();
            listView = this.f3865a.f3864a;
            listView2 = this.f3865a.f3864a;
            listView.setSelection(listView2.getCount() - 1);
        }
    }
}
