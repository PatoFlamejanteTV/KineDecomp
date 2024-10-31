package com.nexstreaming.kinemaster.ui.settings;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import com.nexstreaming.app.general.iab.IABError;
import com.nexstreaming.app.general.iab.Purchase;
import com.nexstreaming.app.general.iab.SKUDetails;
import com.nexstreaming.app.general.iab.Utils.IABConstant;
import com.nexstreaming.app.general.service.notification.NotificationData;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.codeccaps.CapabilityManager;
import com.nexstreaming.kinemaster.codeccaps.ui.CapabilityTestIntroActivity;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nexstreaming.kinemaster.ui.gdpr.ConfirmFragment;
import com.nexstreaming.kinemaster.ui.projectedit.FullScreenInputActivity;
import com.nexstreaming.kinemaster.ui.settings.Ua;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;
import com.nextreaming.nexeditorui.EditorGlobal;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: classes2.dex */
public class SettingsActivity extends com.nextreaming.nexeditorui.I implements Ua.a, FragmentManager.OnBackStackChangedListener, com.nexstreaming.app.general.iab.a.a {
    private Toolbar H;
    private io.reactivex.disposables.a I = new io.reactivex.disposables.a();

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        if (Build.VERSION.SDK_INT >= 18) {
            e.a aVar = new e.a(this);
            aVar.e(R.string.capa_hw_perform_analysis_popup_title);
            aVar.c(R.string.capa_hw_perform_analysis_popup_msg);
            aVar.c(R.string.run_analysis_now, new fb(this));
            aVar.a(R.string.rate_remind_me, new eb(this));
            aVar.a().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean L() {
        return false;
    }

    private void M() {
        if (!CapabilityManager.f20040b.t()) {
            this.H.setSelectedMenuPosition(CapabilityManager.f20040b.k().ordinal());
        }
        this.H.b(R.menu.menu_capability_mode);
        this.H.setMenuBtnVisiblity(true);
        this.H.setMenuItemClickListener(new db(this));
        P();
    }

    private void N() {
        Fragment findFragmentByTag = getFragmentManager().findFragmentByTag(FragmentC2201x.f23219a);
        if (findFragmentByTag == null || !(findFragmentByTag instanceof FragmentC2201x)) {
            return;
        }
        ((FragmentC2201x) findFragmentByTag).h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        if (u() == null || !E()) {
            return;
        }
        Log.i("SettingsActivity", "showAccountInfoFragment() called");
        this.H.a(getString(R.string.pref_information_about_account), 1);
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.container, FragmentC2201x.a(y()), FragmentC2201x.f23219a);
        beginTransaction.addToBackStack(FragmentC2201x.f23219a);
        beginTransaction.commitAllowingStateLoss();
    }

    private boolean P() {
        if (!CapabilityManager.f20040b.t()) {
            int i = CapabilityManager.f20040b.a().maxImportResolutionNoOverlap;
            int i2 = CapabilityManager.f20040b.a().maxImportResolutionWithOverlap;
            if (i > 1440 && i2 <= 1456) {
                i = 1440;
            }
            if (i != i2 && CapabilityManager.f20040b.a(CapabilityManager.CapabilityMode.MAXIMIZE_FEATURES) > 0) {
                b(R.id.maxmize_resolution, true);
                b(R.id.maxmize_features, true);
                a(R.id.run_analysis_now, true);
            } else {
                b(R.id.maxmize_resolution, false);
                b(R.id.maxmize_features, false);
                a(R.id.run_analysis_now, false);
                return false;
            }
        } else {
            b(R.id.maxmize_resolution, false);
            b(R.id.maxmize_features, false);
            a(R.id.run_analysis_now, true);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I
    public void g(boolean z) {
        super.g(z);
        N();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I
    public void j(boolean z) {
        super.j(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 8194) {
            startActivity(CapabilityTestIntroActivity.a(this, FullScreenInputActivity.e(intent), true));
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.nextreaming.nexeditorui.I, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (getFragmentManager().popBackStackImmediate()) {
            return;
        }
        finish();
        overridePendingTransition(0, 0);
    }

    @Override // android.app.FragmentManager.OnBackStackChangedListener
    public void onBackStackChanged() {
        if (getFragmentManager().findFragmentById(R.id.container) != null && (getFragmentManager().findFragmentById(R.id.container) instanceof U)) {
            this.H.a(2);
        }
        if (getFragmentManager().getBackStackEntryCount() < 1) {
            this.H.a(1);
            this.H.setMenuBtnVisiblity(false);
        }
        if (!(getFragmentManager().findFragmentById(R.id.container) instanceof G)) {
            this.H.setMenuBtnVisiblity(false);
        } else {
            M();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.nexstreaming.kinemaster.usage.analytics.b.a(getLocalClassName());
        super.onCreate(bundle);
        setContentView(R.layout.activity_settings);
        getFragmentManager().addOnBackStackChangedListener(this);
        if (bundle == null) {
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            beginTransaction.replace(R.id.container, new Ya());
            beginTransaction.commit();
        }
        if (!CapabilityManager.f20040b.t()) {
            CapabilityManager capabilityManager = CapabilityManager.f20040b;
            capabilityManager.b(capabilityManager.k());
        }
        c(getIntent());
        y().a((com.nexstreaming.app.general.iab.a.a) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        y().b((com.nexstreaming.app.general.iab.a.a) this);
        this.I.a();
        getFragmentManager().removeOnBackStackChangedListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        c(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Toolbar toolbar;
        Fragment findFragmentById = getFragmentManager().findFragmentById(R.id.container);
        if (findFragmentById != null && (toolbar = this.H) != null) {
            if (findFragmentById instanceof U) {
                toolbar.a(getString(R.string.pref_information_about_kinemaster), 1);
                this.H.setMenuBtnVisiblity(false);
            } else if (findFragmentById instanceof V) {
                toolbar.a(getString(R.string.about_kinemaster_legal_info), 2);
                this.H.setMenuBtnVisiblity(false);
            } else if (findFragmentById instanceof FragmentC2201x) {
                this.H.a(getString(R.string.pref_information_about_account), 1);
                this.H.setMenuBtnVisiblity(false);
            } else if (findFragmentById instanceof G) {
                toolbar.a(getString(R.string.pref_information_device_capability), 1);
                M();
            }
        }
        y().a((com.nexstreaming.app.general.iab.a.a) this);
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    @SuppressLint({"ClickableViewAccessibility"})
    public void onStart() {
        String stringExtra;
        super.onStart();
        KMEvents.VIEW_SETTINGS.trackScreen(this);
        this.H = (Toolbar) findViewById(R.id.toolbar_settings);
        this.H.setOnTouchListener(new cb(this));
        if (getIntent() == null || (stringExtra = getIntent().getStringExtra("SELECTED_FRAG_KEY")) == null) {
            return;
        }
        b(stringExtra);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    private void b(int i, boolean z) {
        MenuItem findItem = this.H.getMenu().findItem(i);
        if (findItem != null) {
            findItem.setVisible(z);
        }
    }

    private void c(Intent intent) {
        if (intent == null || intent.getAction() == null) {
            return;
        }
        String action = intent.getAction();
        if ((action.equals(NotificationData.ACTION_NOTIFICATION) || action.equals("android.intent.action.VIEW")) && intent.getData().getPathSegments() != null && intent.getData().getPathSegments().size() > 0) {
            new Handler().postDelayed(new bb(this, intent), 100L);
        }
    }

    private void d(int i) {
        com.nexstreaming.kinemaster.ui.gdpr.g gVar = new com.nexstreaming.kinemaster.ui.gdpr.g();
        Bundle bundle = new Bundle();
        bundle.putInt("gdprMode", i);
        gVar.setArguments(bundle);
        gVar.a(new ib(this, i, gVar));
        gVar.show(getFragmentManager(), com.nexstreaming.kinemaster.ui.gdpr.g.class.getSimpleName());
    }

    @Override // com.nexstreaming.app.general.iab.a.a
    public void a(boolean z, int i, boolean z2) {
        N();
    }

    @Override // com.nexstreaming.app.general.iab.a.a
    public void a(LinkedHashMap<IABConstant.SKUType, LinkedHashMap<String, SKUDetails>> linkedHashMap) {
        N();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.nexstreaming.kinemaster.ui.settings.Ua.a
    public void b(String str) {
        char c2;
        switch (str.hashCode()) {
            case -1601025775:
                if (str.equals("frag_kine_legal_info")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case -879012488:
                if (str.equals("pref_information_about_kinemaster")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 443244204:
                if (str.equals("pref_gdpr_ads")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case 649692812:
                if (str.equals("pref_information_about_account")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 900679986:
                if (str.equals("pref_information_device_capability")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 1087158432:
                if (str.equals("pref_exp_advanced")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 1295575648:
                if (str.equals("unlimited_layers")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case 1646105368:
                if (str.equals("pref_gdpr_echosystem")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                this.H.a(getString(R.string.pref_information_about_kinemaster), 1);
                FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
                beginTransaction.replace(R.id.container, U.a());
                beginTransaction.addToBackStack("about_kinemaster");
                beginTransaction.commit();
                return;
            case 1:
                this.H.a(getString(R.string.pref_information_about_account), 1);
                FragmentTransaction beginTransaction2 = getFragmentManager().beginTransaction();
                beginTransaction2.replace(R.id.container, FragmentC2201x.a(y()), FragmentC2201x.f23219a);
                beginTransaction2.addToBackStack(FragmentC2201x.f23219a);
                beginTransaction2.commitAllowingStateLoss();
                return;
            case 2:
                this.H.a(getString(R.string.pref_information_device_capability), 1);
                FragmentTransaction beginTransaction3 = getFragmentManager().beginTransaction();
                beginTransaction3.replace(R.id.container, G.a());
                beginTransaction3.addToBackStack("");
                beginTransaction3.commit();
                M();
                return;
            case 3:
                this.H.a(getString(R.string.about_kinemaster_legal_info), 2);
                FragmentTransaction beginTransaction4 = getFragmentManager().beginTransaction();
                beginTransaction4.replace(R.id.container, V.a());
                beginTransaction4.addToBackStack("");
                beginTransaction4.commit();
                return;
            case 4:
                e.a aVar = new e.a(u());
                aVar.e(R.string.adv_pref_warn_title);
                aVar.c(R.string.adv_pref_warn_text);
                aVar.a(R.string.button_cancel, new hb(this));
                aVar.c(R.string.adv_pref_warn_ok, new gb(this));
                aVar.a().show();
                return;
            case 5:
                d(1);
                return;
            case 6:
                d(2);
                return;
            case 7:
                Log.d("SettingsActivity", "onSettingSelectedListener: unlimited_layers");
                FragmentManager fragmentManager = getFragmentManager();
                if (fragmentManager.getBackStackEntryCount() > 0) {
                    fragmentManager.popBackStackImmediate(fragmentManager.getBackStackEntryAt(0).getName(), 1);
                }
                EditorGlobal.a(false);
                FragmentTransaction beginTransaction5 = getFragmentManager().beginTransaction();
                beginTransaction5.replace(R.id.container, new C2206za());
                beginTransaction5.addToBackStack("pref_exp_advanced");
                beginTransaction5.commit();
                return;
            default:
                return;
        }
    }

    @Override // com.nexstreaming.app.general.iab.a.a
    public void a(LinkedHashMap<IABConstant.SKUType, List<Purchase>> linkedHashMap, IABError iABError, String str) {
        runOnUiThread(new ab(this, linkedHashMap != null && y().t()));
        N();
    }

    @Override // com.nexstreaming.app.general.iab.a.a
    public void a(boolean z, Purchase purchase, String str) {
        super.b(z, purchase, str);
        N();
    }

    private void a(int i, boolean z) {
        View findViewById;
        MenuItem findItem = this.H.getMenu().findItem(i);
        if (findItem == null || findItem.getActionView() == null || (findViewById = findItem.getActionView().findViewById(R.id.divider)) == null) {
            return;
        }
        findViewById.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.nexstreaming.kinemaster.ui.gdpr.g gVar, int i, boolean z, boolean z2) {
        gVar.setCancelable(false);
        ConfirmFragment a2 = ConfirmFragment.a(getString(R.string.GDPR_Firebase_setting_uncheck_popup_msg));
        a2.a(new Za(this, a2, gVar, i, z, z2));
        a2.show(getFragmentManager(), a2.getClass().getSimpleName());
    }
}
