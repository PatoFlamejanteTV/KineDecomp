package com.nextreaming.nexeditorui;

import android.os.AsyncTask;
import android.preference.PreferenceManager;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.nexstreaming.kinemaster.usage.KMUsage;
import java.io.IOException;

/* compiled from: KineMasterBaseActivity.java */
/* loaded from: classes.dex */
public class bf extends AsyncTask<Void, Void, String> {

    /* renamed from: a */
    final /* synthetic */ ba f4543a;

    public bf(ba baVar) {
        this.f4543a = baVar;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(Void... voidArr) {
        String str;
        IOException e;
        GoogleCloudMessaging a2;
        String string = PreferenceManager.getDefaultSharedPreferences(this.f4543a).getString("kine_gcm_device_id", null);
        try {
            a2 = GoogleCloudMessaging.a(this.f4543a);
            str = a2.a("529925300807");
        } catch (IOException e2) {
            str = string;
            e = e2;
        }
        try {
            KMUsage.getMixpanelPeople(this.f4543a).c(str);
            PreferenceManager.getDefaultSharedPreferences(this.f4543a).edit().putString("kine_gcm_device_id", str).commit();
            a2.a();
        } catch (IOException e3) {
            e = e3;
            e.printStackTrace();
            return str;
        }
        return str;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        super.onPostExecute(str);
        if (str != null) {
        }
    }
}
