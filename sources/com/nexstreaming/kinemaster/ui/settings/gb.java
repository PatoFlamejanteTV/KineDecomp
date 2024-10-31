package com.nexstreaming.kinemaster.ui.settings;

import android.app.FragmentTransaction;
import android.content.DialogInterface;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsActivity.java */
/* loaded from: classes2.dex */
public class gb implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SettingsActivity f23145a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gb(SettingsActivity settingsActivity) {
        this.f23145a = settingsActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Toolbar toolbar;
        dialogInterface.dismiss();
        toolbar = this.f23145a.H;
        toolbar.a(this.f23145a.getString(R.string.pref_exp_advanced), 1);
        FragmentTransaction beginTransaction = this.f23145a.getFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.container, new C2206za());
        beginTransaction.addToBackStack("pref_exp_advanced");
        beginTransaction.commit();
    }
}
