package com.nextreaming.nexeditorui.newproject.mediabrowser;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStore;
import java.util.HashSet;
import java.util.Set;

/* compiled from: MediaBrowserFragment.java */
/* loaded from: classes.dex */
class v implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ com.nexstreaming.kinemaster.mediastore.v2.l f4744a;
    final /* synthetic */ String b;
    final /* synthetic */ u c;

    public v(u uVar, com.nexstreaming.kinemaster.mediastore.v2.l lVar, String str) {
        this.c = uVar;
        this.f4744a = lVar;
        this.b = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        MediaStore mediaStore;
        HashSet hashSet;
        mediaStore = this.c.f4743a.s;
        mediaStore.b(this.f4744a.a());
        this.c.f4743a.c();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.c.f4743a.getActivity());
        Set<String> stringSet = defaultSharedPreferences.getStringSet("com.kinemaster.cloud_folder_accts", null);
        if (stringSet == null) {
            hashSet = new HashSet();
        } else {
            hashSet = new HashSet(stringSet);
        }
        hashSet.remove(this.b);
        defaultSharedPreferences.edit().putStringSet("com.kinemaster.cloud_folder_accts", hashSet).apply();
        dialogInterface.dismiss();
    }
}
