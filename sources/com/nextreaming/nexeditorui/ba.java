package com.nextreaming.nexeditorui;

import android.app.Activity;
import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.util.Log;
import com.facebook.appevents.AppEventsLogger;
import com.google.android.gms.common.AccountPicker;
import com.nexstreaming.app.general.iab.BuyResult;
import com.nexstreaming.app.general.iab.IABError;
import com.nexstreaming.app.general.iab.IABHelper;
import com.nexstreaming.app.general.iab.Purchase;
import com.nexstreaming.app.general.iab.PurchaseType;
import com.nexstreaming.app.general.iab.SKUDetails;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.SupportLogger;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.tracelog.KMAppUsage;
import com.nexstreaming.kinemaster.ui.a.a;
import com.nexstreaming.kinemaster.ui.projectedit.FullScreenInputActivity;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: KineMasterBaseActivity.java */
/* loaded from: classes.dex */
public abstract class ba extends Activity implements IABHelper.a, IABHelper.b, IABHelper.c, IABHelper.d, IABHelper.e {
    protected static boolean d = false;

    /* renamed from: a, reason: collision with root package name */
    private boolean f4537a;
    private long b;
    private af i;
    private boolean k;
    private boolean l;
    private List<WeakReference<Fragment>> c = new ArrayList();
    private com.nexstreaming.sdk2.nexsns.ab e = null;
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;
    private boolean j = false;
    private String m = null;
    private String n = null;
    private IntentFilter o = null;
    private int p = 0;
    private BroadcastReceiver q = new be(this);

    /* compiled from: KineMasterBaseActivity.java */
    /* loaded from: classes.dex */
    public interface a {
        boolean l_();
    }

    public com.nexstreaming.sdk2.nexsns.ab y() {
        if (this.e == null) {
            this.e = new com.nexstreaming.sdk2.nexsns.ab(this, new String[0]);
            if (this.f) {
                this.e.a((Bundle) null);
            }
            if (this.g) {
                this.e.b();
            }
            if (this.h) {
                this.e.e();
            }
            this.e.d("youtube", "AIzaSyC56BwKH_dtuXy_f36IKVHF7M-ldGJOy-8");
        }
        return this.e;
    }

    private void c() {
        ArrayList arrayList;
        ArrayList arrayList2 = null;
        for (WeakReference<Fragment> weakReference : this.c) {
            if (weakReference.get() == null) {
                arrayList = arrayList2 == null ? new ArrayList() : arrayList2;
                arrayList.add(weakReference);
            } else {
                arrayList = arrayList2;
            }
            arrayList2 = arrayList;
        }
        if (arrayList2 != null) {
            this.c.removeAll(arrayList2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<Fragment> z() {
        ArrayList arrayList = new ArrayList();
        Iterator<WeakReference<Fragment>> it = this.c.iterator();
        while (it.hasNext()) {
            Fragment fragment = it.next().get();
            if (fragment != null) {
                arrayList.add(fragment);
            }
        }
        return arrayList;
    }

    @Override // android.app.Activity
    public void onAttachFragment(Fragment fragment) {
        this.c.add(new WeakReference<>(fragment));
        c();
        super.onAttachFragment(fragment);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Iterator<WeakReference<Fragment>> it = this.c.iterator();
        while (it.hasNext()) {
            ComponentCallbacks2 componentCallbacks2 = (Fragment) it.next().get();
            if (componentCallbacks2 != null && (componentCallbacks2 instanceof a) && ((a) componentCallbacks2).l_()) {
                return;
            }
        }
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.e != null) {
            this.e.b(bundle);
            bundle.putBoolean("km.snsmanager.hasinstance", true);
        }
        if (this.j) {
            bundle.putString("BaseActivity_SKU_ProductID", this.m);
            bundle.putString("BaseActivity_Ref", this.n);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        SupportLogger.Event event = SupportLogger.Event.BaseActivity_OnCreate;
        int[] iArr = new int[2];
        iArr[0] = d();
        iArr[1] = bundle == null ? 0 : 1;
        event.log(iArr);
        if (bundle != null) {
            if (bundle.getBoolean("km.snsmanager.hasinstance", false)) {
                this.e = new com.nexstreaming.sdk2.nexsns.ab(this, new String[0]);
            }
            String string = bundle.getString("BaseActivity_SKU_ProductID");
            String string2 = bundle.getString("BaseActivity_Ref");
            if (string != null && string2 != null) {
                this.j = true;
                this.m = string;
                this.n = string2;
            }
        }
        if (this.i == null) {
            this.i = new af(D());
        }
        this.f = true;
        if (this.e != null) {
            this.e.a(bundle);
        }
        super.onCreate(bundle);
        this.o = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    }

    private int d() {
        if (this.p == 0) {
            SupportLogger.Abbreviation forString = SupportLogger.Abbreviation.forString(getClass().getSimpleName());
            if (forString != null) {
                this.p = forString.code;
            } else {
                this.p = getClass().getSimpleName().hashCode();
            }
        }
        return this.p;
    }

    private final void a(Bundle bundle) {
        PurchaseType fromId;
        if (EditorGlobal.e() && bundle != null && (fromId = PurchaseType.fromId(bundle.getInt("KMBA_PT", 0))) != null && fromId.isActivePurchaseOrPromocode()) {
            A().C();
        }
    }

    public af A() {
        return this.i;
    }

    public final boolean B() {
        if (EditorGlobal.f == EditorGlobal.VersionType.ShowDemo) {
            return true;
        }
        if (C() == null) {
            return false;
        }
        return C().isActivePurchaseOrPromocode();
    }

    public final PurchaseType C() {
        return EditorGlobal.f == EditorGlobal.VersionType.ShowDemo ? PurchaseType.Promocode : A().m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z) {
        if (C() != null) {
            try {
                String s = A().s();
                KMUsage.getMixpanelInstance(this).a(new JSONObject().put("User Type", s));
                KMUsage.getMixpanelPeople(this).a("User Type", s);
                PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("put_user_type", true).apply();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        SupportLogger.Event.BaseActivity_OnDestroy.log(d());
        this.f = false;
        if (this.e != null) {
            this.e.a();
        }
        if (this.i != null) {
            this.i.c();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        SupportLogger.Event.BaseActivity_OnPause.log(d());
        AppEventsLogger.deactivateApp(this);
        this.g = false;
        if (this.e != null) {
            this.e.c();
        }
        if (this.f4537a) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.b;
            if (uptimeMillis / 1000 > 1) {
                KMAppUsage.a(this).a(KMAppUsage.KMMetric.SecondsSpentInKineMaster, (int) (uptimeMillis / 1000));
            }
        }
        this.f4537a = false;
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStart() {
        SupportLogger.Event.BaseActivity_OnStart.log(d());
        this.h = true;
        if (this.e != null) {
            this.e.e();
        }
        h_();
        super.onStart();
        KMUsage.onStart(this);
        KMAppUsage.a(this).a(this);
        if (this.q != null && this.o != null) {
            registerReceiver(this.q, this.o);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h_() {
        if (this.i != null) {
            this.i.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i_() {
        if (this.i != null) {
            this.i.v();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        AppEventsLogger.activateApp(this);
        SupportLogger.Event.BaseActivity_OnResume.log(d());
        this.g = true;
        if (this.e != null) {
            this.e.b();
        }
        this.f4537a = true;
        this.b = SystemClock.uptimeMillis();
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStop() {
        SupportLogger.Event.BaseActivity_OnStop.log(d());
        SupportLogger.f3223a.b(this);
        this.h = false;
        if (this.e != null) {
            this.e.d();
        }
        i_();
        super.onStop();
        KMUsage.onStop(this);
        KMAppUsage.a(this).b(this);
        if (this.q != null) {
            unregisterReceiver(this.q);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onRestart() {
        SupportLogger.Event.BaseActivity_OnRestart.log(d());
        super.onRestart();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        if (this.e != null) {
            this.e.a(this, i, i2, intent);
        }
        if (i == R.id.buyintent && this.i != null) {
            this.i.a(i, i2, intent);
        } else if (i == R.id.fullscreen_promocode_text_input) {
            a(i, i2, intent);
        } else if (i == R.id.choose_google_account_promocode) {
            if (this.l) {
                this.l = false;
                if (!this.k && !this.j) {
                    if (i2 == -1 && intent != null && (stringExtra = intent.getStringExtra("authAccount")) != null) {
                        this.k = true;
                        com.nexstreaming.kinemaster.ui.a.a a2 = new a.C0074a(this).f(R.string.sub_validate_promotion_code).a(R.string.please_wait).a(false).a();
                        a2.show();
                        A().a((String) null, stringExtra).onResultAvailable(new bg(this, a2)).onFailure((Task.OnFailListener) new bb(this, a2));
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    private void a(int i, int i2, Intent intent) {
        if (this.k) {
            this.k = false;
            String string = PreferenceManager.getDefaultSharedPreferences(D()).getString("com.kinemaster.apc.sel_account_name", null);
            if (i == R.id.fullscreen_promocode_text_input && i2 == 1 && string != null && string.length() > 0) {
                String b = FullScreenInputActivity.b(intent);
                com.nexstreaming.kinemaster.ui.a.a a2 = new a.C0074a(D()).f(R.string.sub_validate_promotion_code).a(R.string.please_wait).a(false).a();
                a2.show();
                A().a(b, string).onResultAvailable(new bj(this, a2)).onFailure((Task.OnFailListener) new bh(this, a2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Activity D() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public NexEditor E() {
        return EditorGlobal.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean F() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean G() {
        return this.h;
    }

    public void a(SKUDetails sKUDetails, String str) {
        if (this.j || this.k || this.l) {
            a(false, (Purchase) null, "Aleady starting Puchase");
            return;
        }
        if (!EditorGlobal.e()) {
            a(false, (Purchase) null, (String) null);
            return;
        }
        KMUsage.PurchaseButtonClick.logEvent("SKU", this.m, "ref", this.n);
        this.j = true;
        this.m = sKUDetails.a();
        this.n = str;
        this.i.a(sKUDetails);
    }

    public void H() {
        if (!this.j && !this.k && !this.l) {
            this.l = true;
            if (A() != null && A().D()) {
                e();
            } else {
                new a.C0074a(this).f(R.string.check_account).a(R.string.account_promocode_popup_message).b(R.string.apply_to_device, new bo(this)).c(R.string.choose_account, new bn(this)).a(R.string.button_cancel, new bm(this)).a(new bl(this)).a().show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (A() != null && A().d() != null) {
            if (A().d() instanceof com.nexstreaming.app.general.iab.a.a) {
                startActivityForResult(AccountPicker.a(null, null, new String[]{"com.google"}, false, getResources().getString(R.string.promocode_acct_sel), null, null, null), R.id.choose_google_account_promocode);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("authAccount", A().d().t());
            onActivityResult(R.id.choose_google_account_promocode, -1, intent);
        }
    }

    public void a(boolean z, int i) {
        if (z) {
            a((Bundle) null);
            A().x();
        } else if (!d && i == -1) {
            A().b(new bc(this));
        }
        a(A().e());
    }

    public void b(Map<IABHelper.SKUType, Map<String, SKUDetails>> map) {
    }

    public void a(Map<IABHelper.SKUType, List<Purchase>> map) {
        boolean z = false;
        if (map != null && this.i != null && this.i.e()) {
            z = true;
        }
        a(z);
    }

    public void b(IABError iABError, String str) {
        if (iABError != null) {
            switch (iABError) {
                case PurchasedNotFound:
                    a(A().e());
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper.a
    public void a(BuyResult buyResult) {
    }

    public void a(boolean z, Purchase purchase, String str) {
        if (z) {
            if (this.i.e()) {
                KMUsage.PurchaseFlowComplete.logEvent("SKU", this.m, "ref", this.n);
            }
        } else {
            Log.e("BaseActivity", "onBuyResult() called with: isSuccess = [" + z + "], message = [" + str + "]");
        }
        a(z);
        this.j = false;
        this.m = null;
        this.n = null;
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper.b
    public void a(SKUDetails sKUDetails, Purchase purchase) {
        runOnUiThread(new bd(this, sKUDetails));
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper.b
    public void a(IABError iABError, String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Context context) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Context context) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I() {
        A();
        if (af.b(this)) {
            Log.i("BaseActivity", "registerGcm : start register");
            new bf(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            Log.i("BaseActivity", "registerGcm : Device has no Google mobile service");
        }
    }
}
