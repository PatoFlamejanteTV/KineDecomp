package com.nexstreaming.kinemaster.ui.settings;

import android.app.FragmentTransaction;
import android.content.DialogInterface;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsActivity.java */
/* loaded from: classes.dex */
public class at implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SettingsActivity f4246a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(SettingsActivity settingsActivity) {
        this.f4246a = settingsActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Toolbar toolbar;
        dialogInterface.dismiss();
        toolbar = this.f4246a.f4228a;
        toolbar.a(this.f4246a.getString(R.string.pref_exp_advanced), 1);
        FragmentTransaction beginTransaction = this.f4246a.getFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.container, new v());
        beginTransaction.addToBackStack("pref_exp_advanced");
        beginTransaction.commit();
    }
}
