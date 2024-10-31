package com.nexstreaming.kinemaster.ui.store.controller;

import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.nexstreaming.app.general.iab.BillingResponse;
import com.nexstreaming.app.general.iab.IABError;
import com.nexstreaming.app.general.iab.Purchase;
import com.nexstreaming.app.general.iab.SKUDetails;
import com.nexstreaming.app.general.iab.Utils.IABConstant;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ad.AdManager;
import com.nexstreaming.kinemaster.ad.providers.AdmobAdProvider;
import com.nexstreaming.kinemaster.network.InterfaceC1821j;
import com.nexstreaming.kinemaster.network.InterfaceC1822k;
import com.nexstreaming.kinemaster.network.SessionError;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nexstreaming.kinemaster.ui.settings.tb;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;
import com.nexstreaming.kinemaster.usage.AssetDownloadResult;
import com.nexstreaming.kinemaster.usage.AssetStoreEntry;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;
import com.nexstreaming.kinemaster.usage.d;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class StoreActivity extends com.nextreaming.nexeditorui.I implements FragmentManager.OnBackStackChangedListener, tb.a, tb.b, fb, gb, com.nexstreaming.kinemaster.ad.m, com.nexstreaming.app.general.iab.a.a {
    private static final String TAG = "StoreActivity";
    private Toolbar H;
    private String I;
    private String J;
    private String K;
    private ResultTask<List<InterfaceC1822k>> L;
    private WeakReference<com.nexstreaming.kinemaster.ui.a.e> M;
    private BroadcastReceiver N;
    private io.reactivex.disposables.b O;
    private com.nexstreaming.kinemaster.ui.a.t P = null;

    private void K() {
        com.nexstreaming.kinemaster.ui.a.t tVar;
        if (isFinishing() || (tVar = this.P) == null || !tVar.isShowing()) {
            return;
        }
        this.P.dismiss();
    }

    private String L() {
        int i = kb.f23574a[KineMasterApplication.m().q().b().ordinal()];
        if (i == 1) {
            return getResources().getString(R.string.km_store_title) + " (DRAFT)";
        }
        if (i != 2) {
            return getResources().getString(R.string.km_store_title);
        }
        return getResources().getString(R.string.km_store_title) + " (STAGING)";
    }

    private void M() {
        if (this.N == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            this.N = new ib(this);
            registerReceiver(this.N, intentFilter);
        }
    }

    private void N() {
        com.nexstreaming.kinemaster.ui.f.a.b.a().b().a((io.reactivex.q<? super com.nexstreaming.kinemaster.ui.f.a.a>) new jb(this));
    }

    private void O() {
        eb ebVar = new eb();
        this.H.setCategoryVisiblity(false);
        if (this.K != null) {
            Bundle bundle = new Bundle();
            bundle.putString("SELECTED_PROJECT", this.K);
            ebVar.setArguments(bundle);
        }
        getSupportFragmentManager().beginTransaction().addToBackStack("myAsset").add(R.id.fragmentHolder, ebVar).commitAllowingStateLoss();
        com.nexstreaming.kinemaster.ui.f.a.b.a().a(new com.nexstreaming.kinemaster.ui.f.a.a("RX_EVENT_STOP_PLAYER", null));
    }

    private void P() {
        com.nexstreaming.kinemaster.ui.a.t tVar;
        if (this.P == null) {
            this.P = new com.nexstreaming.kinemaster.ui.a.t(this);
        }
        if (isFinishing() || (tVar = this.P) == null || tVar.isShowing()) {
            return;
        }
        this.P.a(60000L);
        this.P.show();
    }

    public ResultTask<List<InterfaceC1822k>> G() {
        if (!this.L.isComplete() && !this.L.isRunning()) {
            this.L = KineMasterApplication.m().q().g();
        }
        return this.L;
    }

    public /* synthetic */ void H() {
        if (findViewById(R.id.networkErrorHolder).getVisibility() == 0) {
            findViewById(R.id.networkErrorHolder).setVisibility(8);
        }
        if (findViewById(R.id.network_connection_error_bar).getVisibility() == 0) {
            findViewById(R.id.network_connection_error_bar).setVisibility(8);
        }
        findViewById(R.id.fragmentHolder).setVisibility(0);
    }

    public void I() {
        if (c.d.b.m.e.f3850a.a()) {
            return;
        }
        AdManager a2 = AdManager.a(u());
        a2.a((com.nexstreaming.kinemaster.ad.m) this);
        a2.d(AdmobAdProvider.STORE_AD_UNIT_ID);
    }

    @Override // com.nexstreaming.kinemaster.ad.m
    public void a(InterstitialAd interstitialAd, String str) {
    }

    @Override // com.nexstreaming.app.general.iab.a.a
    public void a(LinkedHashMap<IABConstant.SKUType, LinkedHashMap<String, SKUDetails>> linkedHashMap) {
    }

    public ResultTask<Map<String, String>> c(final int i) {
        final ResultTask<Map<String, String>> resultTask = new ResultTask<>();
        G().onResultAvailable(new ResultTask.OnResultAvailableListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.da
            @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
            public final void onResultAvailable(ResultTask resultTask2, Task.Event event, Object obj) {
                StoreActivity.a(i, resultTask, resultTask2, event, (List) obj);
            }
        }).onFailure(resultTask);
        return resultTask;
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 41) {
                if (keyEvent.hasModifiers(4096)) {
                    O();
                }
                return true;
            }
            if (keyCode == 62) {
                com.nexstreaming.kinemaster.ui.f.a.b.a().a(new com.nexstreaming.kinemaster.ui.f.a.a("RX_EVENT_PLAY_PLAYER", null));
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I
    public void g(boolean z) {
        super.g(z);
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragmentHolder);
        if (findFragmentById instanceof C2290ya) {
            ((C2290ya) findFragmentById).b(false);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.settings.tb.b
    public void i() {
        P();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I
    public void j(boolean z) {
        super.j(false);
    }

    @Override // com.nextreaming.nexeditorui.I, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (!c.d.b.m.i.f(u())) {
            findViewById(R.id.networkErrorHolder).setVisibility(0);
        }
        if (getIntent().getBooleanExtra("IS_DIRECT_ASSET_DETAIL_FRAGMENT", false)) {
            finish();
            return;
        }
        if (getSupportFragmentManager() != null && getSupportFragmentManager().getBackStackEntryCount() > 0) {
            String name = getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount() - 1).getName();
            if (name != null && name.contains(tb.class.getSimpleName())) {
                Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragmentHolder);
                if (findFragmentById instanceof C2290ya) {
                    ((C2290ya) findFragmentById).a(AssetDownloadResult.PURCHASE_CANCEL);
                }
                com.nexstreaming.kinemaster.usage.analytics.f.a("Close");
            }
            getSupportFragmentManager().popBackStack();
            return;
        }
        super.onBackPressed();
    }

    @Override // android.support.v4.app.FragmentManager.OnBackStackChangedListener
    public void onBackStackChanged() {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragmentHolder);
        if ((findFragmentById instanceof eb) || getIntent().getBooleanExtra("IS_DIRECT_ASSET_DETAIL_FRAGMENT", false)) {
            return;
        }
        this.H.setRightButtonVisiblity(true);
        if (findFragmentById instanceof C2290ya) {
            ((C2290ya) findFragmentById).b(false);
            this.H.setTitleMode(Toolbar.TitleMode.Back);
            String str = this.I;
            if (str == null) {
                this.H.setTitle(L());
                this.H.setCategoryVisiblity(false);
                return;
            } else {
                this.H.setTitle(str);
                this.H.setCategoryVisiblity(true);
                return;
            }
        }
        this.H.setTitleMode(Toolbar.TitleMode.Title);
        this.H.setTitle(L());
        this.H.setCategoryVisiblity(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.nexstreaming.kinemaster.usage.analytics.b.a(getLocalClassName());
        super.onCreate(bundle);
        setContentView(R.layout.activity_item_store);
        y().a((com.nexstreaming.app.general.iab.a.a) this);
        d.a aVar = new d.a();
        if (KineMasterApplication.m().q() != null) {
            this.L = KineMasterApplication.m().q().g();
        }
        this.H = (Toolbar) findViewById(R.id.toolbar_store);
        this.H.setClickListener(new View.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.ja
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StoreActivity.this.a(view);
            }
        });
        if (c.d.b.m.i.f(u())) {
            findViewById(R.id.networkErrorHolder).setVisibility(8);
        } else {
            findViewById(R.id.networkErrorHolder).setVisibility(0);
        }
        if (getIntent() != null) {
            this.J = getIntent().getStringExtra("SPECIFIC_URL");
            this.K = getIntent().getStringExtra("SELECTED_PROJECT");
            if (!TextUtils.isEmpty(this.J)) {
                aVar.a(this.J);
            }
            AssetStoreEntry assetStoreEntry = (AssetStoreEntry) getIntent().getSerializableExtra("fromActivity");
            if (assetStoreEntry != null) {
                aVar.a(assetStoreEntry);
            }
        }
        getSupportFragmentManager().addOnBackStackChangedListener(this);
        if (!getIntent().getBooleanExtra("IS_DIRECT_ASSET_DETAIL_FRAGMENT", false)) {
            this.H.setExitButtonMode(Toolbar.ExitButtonMode.Cancel);
            this.H.setRightButtonVisiblity(true);
            this.H.setTitle(L());
            ob f2 = ob.f(this.J);
            Uri data = getIntent().getData();
            if (data != null && data.getPathSegments().size() > 1) {
                String str = data.getPathSegments().get(2);
                String str2 = data.getPathSegments().size() > 4 ? data.getPathSegments().get(4) : AppEventsConstants.EVENT_PARAM_VALUE_NO;
                String str3 = data.getPathSegments().get(1);
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3) && f2.getArguments() != null) {
                    f2.getArguments().putString("index", str);
                    f2.getArguments().putString("sub_index", str2);
                    f2.getArguments().putString("type", str3);
                }
                if (data.getScheme() != null && data.getScheme().startsWith("tip")) {
                    aVar.a(AssetStoreEntry.TIP);
                } else if (data.getScheme() != null && data.getScheme().startsWith("dynamiclink")) {
                    aVar.a(AssetStoreEntry.DYNAMIC_LINK);
                } else {
                    aVar.a(AssetStoreEntry.PUSH);
                }
                aVar.b(data.toString());
                aVar.a(str3, str, str2);
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentHolder, f2).commit();
        } else {
            this.H.setVisibility(0);
            this.H.setExitButtonMode(Toolbar.ExitButtonMode.Cancel);
            this.H.setTitleMode(Toolbar.TitleMode.Detail);
            this.H.setTitle("");
            this.H.setRightButtonVisiblity(false);
            a(getIntent().getIntExtra("DIRECT_ASSET_DETAIL_FRAGMENT_ASSET_INDEX", 0), getIntent().getStringExtra("DIRECT_ASSET_DETAIL_FRAGMENT_ASSET_THUMBNAIL_URL"));
        }
        N();
        KMEvents.VIEW_ASSET_STORE.trackEnterAssetStore(aVar.a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        y().b((com.nexstreaming.app.general.iab.a.a) this);
        this.O.dispose();
        BroadcastReceiver broadcastReceiver = this.N;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
            this.N = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        y().a((com.nexstreaming.app.general.iab.a.a) this);
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        M();
        KMEvents.VIEW_ASSET_STORE.trackScreen(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(int i, ResultTask resultTask, ResultTask resultTask2, Task.Event event, List list) {
        Map<String, String> map;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                map = null;
                break;
            }
            InterfaceC1822k interfaceC1822k = (InterfaceC1822k) it.next();
            if (interfaceC1822k.getCategoryIdx() == i) {
                map = interfaceC1822k.getCategoryName();
                break;
            }
        }
        if (map != null) {
            resultTask.sendResult(map);
        } else {
            resultTask.sendFailure(Task.makeTaskError("Category not found"));
        }
    }

    public /* synthetic */ void c(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            intent.setData(Uri.parse("market://details?id=" + getPackageName()));
            startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName()));
            startActivity(intent);
        }
    }

    public void a(String str, String str2) {
        Toolbar toolbar = this.H;
        if (toolbar != null) {
            toolbar.setVisibility(0);
            this.H.setTitleMode(Toolbar.TitleMode.Back);
            this.H.setCategoryIcon(str);
            this.I = str2;
            this.H.setTitle(this.I);
        }
    }

    public /* synthetic */ void a(View view) {
        int id = view.getId();
        if (id == R.id.cancel_button) {
            finish();
            return;
        }
        if (id == R.id.titleHolder) {
            if (this.H.getTitleMode() == Toolbar.TitleMode.Back) {
                onBackPressed();
            }
        } else {
            if (id != R.id.toolbar_button) {
                return;
            }
            this.H.setRightButtonVisiblity(false);
            this.H.setTitleMode(Toolbar.TitleMode.Back);
            this.H.setTitle(getResources().getString(R.string.my_asset_title));
            this.H.post(new Runnable() { // from class: com.nexstreaming.kinemaster.ui.store.controller.ka
                @Override // java.lang.Runnable
                public final void run() {
                    StoreActivity.this.H();
                }
            });
            O();
        }
    }

    @Override // com.nexstreaming.app.general.iab.a.a
    public void a(boolean z, int i, boolean z2) {
        if (!z) {
            K();
        }
        if (c.d.b.m.i.f(this) || !z2) {
            return;
        }
        K();
        Toast.makeText(this, getString(R.string.theme_download_server_connection_error), 0).show();
    }

    @Override // com.nexstreaming.app.general.iab.a.a
    public void a(LinkedHashMap<IABConstant.SKUType, List<Purchase>> linkedHashMap, IABError iABError, String str) {
        K();
        runOnUiThread(new hb(this, linkedHashMap != null && y().t()));
    }

    @Override // com.nexstreaming.app.general.iab.a.a
    public void a(boolean z, Purchase purchase, String str) {
        super.b(z, purchase, str);
        if (z) {
            com.nexstreaming.kinemaster.ui.f.a.b.a().a(new com.nexstreaming.kinemaster.ui.f.a.a("RX_EVENT_HIDE_AD", null));
        }
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragmentHolder);
        if (findFragmentById instanceof C2290ya) {
            if (z) {
                ((C2290ya) findFragmentById).b(true);
            } else if (BillingResponse.ITEM_ALREADY_OWNED.getMessage().equalsIgnoreCase(str)) {
                ((C2290ya) findFragmentById).z();
            } else if (BillingResponse.USER_CANCELED.getMessage().equalsIgnoreCase(str)) {
                ((C2290ya) findFragmentById).a(AssetDownloadResult.PURCHASE_CANCEL);
            } else {
                ((C2290ya) findFragmentById).a(AssetDownloadResult.PURCHASE_FAIL);
            }
        }
        if (findFragmentById instanceof ob) {
            ob obVar = (ob) findFragmentById;
            int currentItem = obVar.z().getCurrentItem();
            qb qbVar = (qb) obVar.z().getAdapter();
            if (qbVar == null || !(qbVar.a(currentItem) instanceof Oa)) {
                return;
            }
            if (z && !getSupportFragmentManager().isStateSaved()) {
                i(true);
                com.nexstreaming.kinemaster.ui.f.a.b.a().a(new com.nexstreaming.kinemaster.ui.f.a.a("RX_EVENT_DOWNLOAD_ASSET", null));
            } else {
                if (BillingResponse.ITEM_ALREADY_OWNED.getMessage().equalsIgnoreCase(str)) {
                    return;
                }
                BillingResponse.USER_CANCELED.getMessage().equalsIgnoreCase(str);
            }
        }
    }

    public void a(InterfaceC1821j interfaceC1821j) {
        a(" ", " ");
        if (interfaceC1821j != null) {
            getSupportFragmentManager().beginTransaction().addToBackStack(TAG).add(R.id.fragmentHolder, C2290ya.a(interfaceC1821j, AssetStoreEntry.STORE)).commitAllowingStateLoss();
        }
    }

    private void a(int i, String str) {
        getSupportFragmentManager().beginTransaction().addToBackStack(TAG).add(R.id.fragmentHolder, C2290ya.a(i, str, AssetStoreEntry.PROJECT)).commitAllowingStateLoss();
    }

    public void a(InterfaceC1822k interfaceC1822k) {
        if (interfaceC1822k.getSubCategories() != null && !interfaceC1822k.getSubCategories().isEmpty()) {
            com.nexstreaming.kinemaster.ui.store.view.a.a().a(true);
        } else {
            com.nexstreaming.kinemaster.ui.store.view.a.a().a(false);
        }
        if (interfaceC1822k != null) {
            com.nexstreaming.kinemaster.usage.analytics.j.a(interfaceC1822k, AssetStoreEntry.STORE);
        }
    }

    public void a(com.nexstreaming.kinemaster.network.m mVar) {
        if (mVar != null) {
            com.nexstreaming.kinemaster.usage.analytics.j.a(mVar, AssetStoreEntry.STORE);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.settings.tb.a
    public void a(String str) {
        i(true);
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragmentHolder);
        if (findFragmentById instanceof C2290ya) {
            ((C2290ya) findFragmentById).a(AssetDownloadResult.PURCHASE_CANCEL);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.store.controller.gb
    public void a(Task.TaskError taskError) {
        com.nexstreaming.kinemaster.ui.a.e a2;
        WeakReference<com.nexstreaming.kinemaster.ui.a.e> weakReference = this.M;
        if (weakReference == null || weakReference.get() == null) {
            if (taskError == SessionError.SERVER_MAINTENANCE) {
                e.a aVar = new e.a(u());
                aVar.c(R.string.button_ok, new DialogInterface.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.ia
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                aVar.c(R.string.server_maintenance);
                a2 = aVar.a();
            } else if (taskError == SessionError.APP_UPDATE_REQUIRED_BY_SERVER) {
                if (!c.d.b.m.e.f3850a.a()) {
                    e.a aVar2 = new e.a(u());
                    aVar2.a(R.string.button_cancel, new DialogInterface.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.la
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    aVar2.c(R.string.about_kinemaster_check_version, new DialogInterface.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.fa
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            StoreActivity.this.c(dialogInterface, i);
                        }
                    });
                    aVar2.c(R.string.server_needs_app_update);
                    a2 = aVar2.a();
                } else {
                    e.a aVar3 = new e.a(u());
                    aVar3.c(R.string.button_ok, new DialogInterface.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.ha
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    aVar3.c(R.string.server_needs_app_update);
                    a2 = aVar3.a();
                }
            } else {
                e.a aVar4 = new e.a(u());
                aVar4.c(R.string.button_ok, new DialogInterface.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.ea
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                aVar4.c(R.string.theme_download_server_connection_error);
                aVar4.b(taskError.getLocalizedMessage(u()));
                aVar4.e(R.string.theme_download_server_connection_failure);
                aVar4.f(18);
                aVar4.b(true);
                a2 = aVar4.a();
            }
            if (this.M == null) {
                this.M = new WeakReference<>(a2);
            }
            a2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.ga
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    StoreActivity.this.a(dialogInterface);
                }
            });
            a2.show();
        }
    }

    public /* synthetic */ void a(DialogInterface dialogInterface) {
        this.M = null;
    }

    @Override // com.nexstreaming.kinemaster.ad.m
    public void a(UnifiedNativeAd unifiedNativeAd, String str) {
        if (C()) {
            return;
        }
        com.nexstreaming.kinemaster.ui.f.a.b.a().a(new com.nexstreaming.kinemaster.ui.f.a.a("RX_EVENT_SHOW_AD", unifiedNativeAd));
    }
}
