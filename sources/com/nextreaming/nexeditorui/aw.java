package com.nextreaming.nexeditorui;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStore;
import com.nexstreaming.kinemaster.mediastore.v2.providers.AndroidMediaStoreProvider;
import com.nextreaming.a.a.c;
import java.util.Iterator;
import java.util.Set;

/* compiled from: KMMediaStoreActivity.java */
/* loaded from: classes.dex */
public class aw extends ba {
    public static final MSID b = new MSID("CloudFolder", "root");
    public static final MSID c = new MSID("CloudFolder", "_add");

    /* renamed from: a */
    private com.nexstreaming.sdk2.nexsns.ab f4531a = new com.nexstreaming.sdk2.nexsns.ab(this, new String[0]);
    private MediaStore e = null;
    private com.nexstreaming.kinemaster.mediastore.v2.b f = null;
    private a g;

    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4531a.a(bundle);
        FragmentManager fragmentManager = getFragmentManager();
        this.g = (a) fragmentManager.findFragmentByTag("media_store_wrapper");
        if (this.g == null) {
            this.g = new a();
            fragmentManager.beginTransaction().add(this.g, "media_store_wrapper").commit();
        }
        this.e = this.g.a();
        c();
    }

    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onDestroy() {
        if (!isChangingConfigurations()) {
            this.e.a();
            this.e.b();
            this.e = null;
        }
        this.f4531a.a();
        super.onDestroy();
    }

    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onStart() {
        this.f4531a.e();
        this.e.e();
        super.onStart();
    }

    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onStop() {
        this.f4531a.d();
        this.e.f();
        super.onStop();
    }

    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onPause() {
        this.f4531a.c();
        super.onPause();
    }

    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onResume() {
        this.f4531a.b();
        super.onResume();
    }

    /* compiled from: KMMediaStoreActivity.java */
    /* loaded from: classes.dex */
    public static class a extends Fragment {

        /* renamed from: a */
        private MediaStore f4532a;

        @Override // android.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setRetainInstance(true);
        }

        public void a(MediaStore mediaStore) {
            this.f4532a = mediaStore;
        }

        public MediaStore a() {
            return this.f4532a;
        }
    }

    private void c() {
        if (this.e == null) {
            this.e = new MediaStore(this);
            this.g.a(this.e);
            c.a aVar = new c.a(this, "thumb_cache");
            aVar.a(this, 0.35f);
            this.e.a(getFragmentManager(), aVar);
            if (this.f == null) {
                this.f = new com.nexstreaming.kinemaster.mediastore.v2.b(this);
            }
            this.e.a(new com.nexstreaming.kinemaster.mediastore.v2.providers.j(this));
            this.e.a(new com.nexstreaming.kinemaster.mediastore.v2.providers.k(this, this.f));
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            A();
            if (af.b(this)) {
                MSID msid = b;
                this.e.a(msid, R.drawable.special_folder_icon_cloud, R.string.mediabrowser_cloudstorage);
                this.e.a(c, msid, R.drawable.special_item_icon_add_gdrive, R.string.add_account);
                Set<String> stringSet = defaultSharedPreferences.getStringSet("com.kinemaster.cloud_folder_accts", null);
                if (stringSet != null) {
                    Iterator<String> it = stringSet.iterator();
                    while (it.hasNext()) {
                        this.e.a(new com.nexstreaming.kinemaster.mediastore.v2.providers.l(this, this.f4531a, it.next()), msid).a(true, 1800000L, 15000L);
                    }
                }
            }
            this.e.a(new AndroidMediaStoreProvider(this, defaultSharedPreferences.getBoolean("pref_mbrowser_hierarchy", false)));
        }
    }

    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        this.f4531a.a(this, i, i2, intent);
        super.onActivityResult(i, i2, intent);
    }

    public MediaStore x() {
        return this.e;
    }

    @Override // com.nextreaming.nexeditorui.ba
    public com.nexstreaming.sdk2.nexsns.ab y() {
        return this.f4531a;
    }
}
