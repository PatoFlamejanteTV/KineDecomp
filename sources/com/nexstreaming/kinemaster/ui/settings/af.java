package com.nexstreaming.kinemaster.ui.settings;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;
import com.nexstreaming.app.kinemasterfree.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingFragment.java */
/* loaded from: classes.dex */
public class af implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ x f4236a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(x xVar) {
        this.f4236a = xVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f4236a.getActivity());
        SharedPreferences.Editor edit = defaultSharedPreferences.edit();
        edit.putBoolean("sticker_guide_shown", false);
        edit.putBoolean("export_popup_shown", false);
        edit.putBoolean("native_camera_import_warning", false);
        for (String str : defaultSharedPreferences.getAll().keySet()) {
            if (str.startsWith("helpoverlay_")) {
                edit.putBoolean(str, false);
            }
        }
        edit.apply();
        dialogInterface.dismiss();
        Toast.makeText(this.f4236a.getActivity(), R.string.reset_guide_balloons_complete, 0).show();
    }
}
