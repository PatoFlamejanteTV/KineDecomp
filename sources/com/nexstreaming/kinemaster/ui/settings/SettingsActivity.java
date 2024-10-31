package com.nexstreaming.kinemaster.ui.settings;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.nexstreaming.app.general.iab.IABError;
import com.nexstreaming.app.general.iab.IABHelper;
import com.nexstreaming.app.general.iab.Purchase;
import com.nexstreaming.app.general.iab.SKUDetails;
import com.nexstreaming.app.general.service.notification.NotificationData;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.a.a;
import com.nexstreaming.kinemaster.ui.settings.x;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexeditorui.ba;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class SettingsActivity extends ba implements FragmentManager.OnBackStackChangedListener, x.a {

    /* renamed from: a, reason: collision with root package name */
    private Toolbar f4228a;
    private IABHelper.c b = new av(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_settings);
        getFragmentManager().addOnBackStackChangedListener(this);
        if (bundle == null) {
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            beginTransaction.replace(R.id.container, new aq());
            beginTransaction.commit();
        }
        a(getIntent());
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a(intent);
    }

    private void a(Intent intent) {
        if (intent != null && intent.getAction() != null && intent.getAction().equals(NotificationData.ACTION_NOTIFICATION) && intent.getData().getPathSegments() != null && intent.getData().getPathSegments().size() > 0) {
            new Handler().postDelayed(new ar(this, intent), 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onStart() {
        super.onStart();
        KMUsage.Activity_Settings.begin();
        this.f4228a = (Toolbar) findViewById(R.id.toolbar_settings);
        this.f4228a.setOnTouchListener(new as(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onStop() {
        KMUsage.Activity_Settings.end();
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onResume() {
        Fragment findFragmentById = getFragmentManager().findFragmentById(R.id.container);
        if (findFragmentById != null && this.f4228a != null) {
            if (findFragmentById instanceof r) {
                this.f4228a.a(getString(R.string.pref_information_about_kinemaster), 1);
            } else if (findFragmentById instanceof u) {
                this.f4228a.a(getString(R.string.about_kinemaster_legal_info), 2);
            } else if (findFragmentById instanceof a) {
                this.f4228a.a(getString(R.string.pref_information_about_account), 1);
            } else if (findFragmentById instanceof j) {
                this.f4228a.a(getString(R.string.pref_information_device_capability), 1);
            }
        }
        super.onResume();
    }

    @Override // com.nexstreaming.kinemaster.ui.settings.x.a
    public void a(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1601025775:
                if (str.equals("frag_kine_legal_info")) {
                    c = 3;
                    break;
                }
                break;
            case -879012488:
                if (str.equals("pref_information_about_kinemaster")) {
                    c = 0;
                    break;
                }
                break;
            case 649692812:
                if (str.equals("pref_information_about_account")) {
                    c = 1;
                    break;
                }
                break;
            case 900679986:
                if (str.equals("pref_information_device_capability")) {
                    c = 2;
                    break;
                }
                break;
            case 1087158432:
                if (str.equals("pref_exp_advanced")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.f4228a.a(getString(R.string.pref_information_about_kinemaster), 1);
                FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
                beginTransaction.replace(R.id.container, r.a());
                beginTransaction.addToBackStack("about_kinemaster");
                beginTransaction.commit();
                return;
            case 1:
                if (A() != null && A().d() != null) {
                    A().d().a(this.b);
                    return;
                }
                this.f4228a.a(getString(R.string.pref_information_about_account), 1);
                FragmentTransaction beginTransaction2 = getFragmentManager().beginTransaction();
                beginTransaction2.replace(R.id.container, a.a(A()), a.f4229a);
                beginTransaction2.addToBackStack(a.f4229a);
                beginTransaction2.commitAllowingStateLoss();
                return;
            case 2:
                this.f4228a.a(getString(R.string.pref_information_device_capability), 1);
                FragmentTransaction beginTransaction3 = getFragmentManager().beginTransaction();
                beginTransaction3.replace(R.id.container, j.a());
                beginTransaction3.addToBackStack("");
                beginTransaction3.commit();
                return;
            case 3:
                this.f4228a.a(getString(R.string.about_kinemaster_legal_info), 2);
                FragmentTransaction beginTransaction4 = getFragmentManager().beginTransaction();
                beginTransaction4.replace(R.id.container, u.a());
                beginTransaction4.addToBackStack("");
                beginTransaction4.commit();
                return;
            case 4:
                new a.C0074a(D()).f(R.string.adv_pref_warn_title).a(R.string.adv_pref_warn_text).b(R.string.button_cancel, new au(this)).a(R.string.adv_pref_warn_ok, new at(this)).a().show();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.ba
    public void a(boolean z) {
        super.a(z);
        d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        getFragmentManager().removeOnBackStackChangedListener(this);
    }

    @Override // android.app.FragmentManager.OnBackStackChangedListener
    public void onBackStackChanged() {
        if (getFragmentManager().findFragmentById(R.id.container) != null && (getFragmentManager().findFragmentById(R.id.container) instanceof r)) {
            this.f4228a.a(2);
        }
        if (getFragmentManager().getBackStackEntryCount() < 1) {
            this.f4228a.a(1);
        }
    }

    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onBackPressed() {
        if (!getFragmentManager().popBackStackImmediate()) {
            finish();
            overridePendingTransition(0, 0);
        }
    }

    @Override // com.nextreaming.nexeditorui.ba, com.nexstreaming.app.general.iab.IABHelper.d
    public void b(Map<IABHelper.SKUType, Map<String, SKUDetails>> map) {
        super.b(map);
        d();
    }

    @Override // com.nextreaming.nexeditorui.ba, com.nexstreaming.app.general.iab.IABHelper.c
    public void a(Map<IABHelper.SKUType, List<Purchase>> map) {
        super.a(map);
        d();
    }

    @Override // com.nextreaming.nexeditorui.ba, com.nexstreaming.app.general.iab.IABHelper.c
    public void b(IABError iABError, String str) {
        super.b(iABError, str);
        d();
    }

    @Override // com.nextreaming.nexeditorui.ba, com.nexstreaming.app.general.iab.IABHelper.a
    public void a(boolean z, Purchase purchase, String str) {
        super.a(z, purchase, str);
        d();
    }

    @Override // com.nextreaming.nexeditorui.ba, com.nexstreaming.app.general.iab.IABHelper.e
    public void a(boolean z, int i) {
        super.a(z, i);
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (D() != null && G()) {
            Log.i("SettingsActivity", "showAccountInfoFragment() called");
            this.f4228a.a(getString(R.string.pref_information_about_account), 1);
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            beginTransaction.replace(R.id.container, a.a(A()), a.f4229a);
            beginTransaction.addToBackStack(a.f4229a);
            beginTransaction.commitAllowingStateLoss();
        }
    }

    private void d() {
        Fragment findFragmentByTag = getFragmentManager().findFragmentByTag(a.f4229a);
        if (findFragmentByTag != null && (findFragmentByTag instanceof a)) {
            ((a) findFragmentByTag).d();
        }
    }
}
