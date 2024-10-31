package com.nexstreaming.kinemaster.ui.share;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.StatFs;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.FileProvider;
import android.text.format.Formatter;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import c.d.b.b.d;
import com.facebook.share.internal.ShareConstants;
import com.nexstreaming.app.general.iab.IABError;
import com.nexstreaming.app.general.iab.Presenter.IABBasePresent;
import com.nexstreaming.app.general.iab.Purchase;
import com.nexstreaming.app.general.iab.SKUDetails;
import com.nexstreaming.app.general.iab.Utils.IABConstant;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.DiagnosticLogger;
import com.nexstreaming.app.general.util.SupportLogger;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ad.AdManager;
import com.nexstreaming.kinemaster.ad.providers.AdmobAdProvider;
import com.nexstreaming.kinemaster.ad.providers.AdmobInterstitialAdProvider;
import com.nexstreaming.kinemaster.ad.providers.tencent.TencentAdListener;
import com.nexstreaming.kinemaster.ad.providers.tencent.TencentAdManager;
import com.nexstreaming.kinemaster.ad.providers.tencent.TencentAdProvider;
import com.nexstreaming.kinemaster.codeccaps.CapabilityManager;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nexstreaming.kinemaster.ui.projectedit.Slider;
import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;
import com.nexstreaming.kinemaster.ui.settings.tb;
import com.nexstreaming.kinemaster.ui.share.AsyncTaskC2214da;
import com.nexstreaming.kinemaster.ui.share.U;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;
import com.nexstreaming.kinemaster.ui.widget.TransparentTextButton;
import com.nexstreaming.kinemaster.ui.widget.WheelPicker;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import com.nextreaming.nexeditorui.NexExportProfile;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
public class ExportAndShareActivity extends na implements tb.a, tb.b, WheelPicker.a, AsyncTaskC2214da.a, Task.OnTaskEventListener, Task.OnFailListener, Task.OnProgressListener, d.a, com.nexstreaming.app.general.iab.a.a {
    private static final Executor L = Executors.newSingleThreadExecutor();
    private ListView M;
    private NexExportProfile[] N;
    private Toolbar O;
    private WheelPicker P;
    private WheelPicker Q;
    private TransparentTextButton R;
    private Slider S;
    private TextView T;
    private TextView U;
    private TextView V;
    private C2220ga W;
    private LinearLayout X;
    private TextView Y;
    private ProgressBar Z;
    private TransparentTextButton aa;
    private ArrayList<V> ba;
    private ExportedVideoDatabase ca;
    private String da;
    private SharedPreferences ia;
    private float ja;
    private boolean ea = false;
    private Intent fa = null;
    private boolean ga = false;
    private TencentAdManager ha = null;
    private boolean ka = false;
    private boolean la = false;
    private com.nexstreaming.kinemaster.ui.a.t ma = null;
    private com.nexstreaming.kinemaster.ad.m na = new C2213d(this);
    boolean oa = false;
    private TencentAdListener.NativeExpressAdListener pa = new C2232p(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        private String f23272a;

        /* renamed from: b, reason: collision with root package name */
        private String f23273b;

        a(String str, String str2) {
            this.f23272a = str;
            this.f23273b = str2;
        }

        boolean a(Intent intent) {
            return intent.getPackage().equals(this.f23272a) && intent.getComponent().getClassName().equals(this.f23273b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        if (this.Z.getMax() <= 0 || this.Z.getProgress() <= 0) {
            return;
        }
        U.b().a();
        this.X.setVisibility(4);
    }

    private void N() {
        com.nexstreaming.kinemaster.ui.a.t tVar;
        if (isFinishing() || (tVar = this.ma) == null || !tVar.isShowing()) {
            return;
        }
        this.ma.dismiss();
    }

    private void O() {
        if (this.ga) {
            h(R.string.export_muserk_notice_msg);
            return;
        }
        IABBasePresent n = y().n();
        if (n instanceof com.nexstreaming.app.general.iab.Presenter.B) {
            if (n.s()) {
                if (C()) {
                    d(P());
                    return;
                } else {
                    fa();
                    return;
                }
            }
            fa();
            return;
        }
        if (!C()) {
            fa();
        } else {
            d(P());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NexExportProfile P() {
        NexExportProfile[] nexExportProfileArr = this.N;
        if (nexExportProfileArr.length > 0) {
            return nexExportProfileArr[this.P.getValue()];
        }
        return null;
    }

    private String[] Q() {
        if (this.ia.getBoolean("pref_export_60fps", false)) {
            return getResources().getStringArray(R.array.frame_rate_list_value60);
        }
        return getResources().getStringArray(R.array.frame_rate_list_value);
    }

    private int R() {
        ArrayList<V> arrayList = this.ba;
        int i = 1;
        if (arrayList != null && !arrayList.isEmpty()) {
            com.nexstreaming.kinemaster.project.k H = H();
            V v = this.ba.get(0);
            r1 = H.d().getTime() != v.i;
            i = v.f23314c;
        }
        return r1 ? i + 1 : i;
    }

    private void S() {
        this.M = (ListView) findViewById(R.id.exportFileList);
        this.O = (Toolbar) findViewById(R.id.toolbar_quality);
        this.P = (WheelPicker) findViewById(R.id.resolution_picker);
        this.Q = (WheelPicker) findViewById(R.id.fps_picker);
        this.S = (Slider) findViewById(R.id.quality_slider);
        this.V = (TextView) findViewById(R.id.exportBitrateLabel);
        this.T = (TextView) findViewById(R.id.file_capacity_text);
        this.U = (TextView) findViewById(R.id.available_capacity_text);
        this.R = (TransparentTextButton) findViewById(R.id.export_button);
        this.X = (LinearLayout) findViewById(R.id.export_layout);
        this.Y = (TextView) findViewById(R.id.exporting_text);
        this.Z = (ProgressBar) findViewById(R.id.exporting_progress);
        this.aa = (TransparentTextButton) findViewById(R.id.export_cancel_button);
        this.W = new C2220ga();
        this.ca = ExportedVideoDatabase.a(this);
        this.ia = PreferenceManager.getDefaultSharedPreferences(this);
        NexExportProfile[] supportedExportProfiles = NexEditorDeviceProfile.getDeviceProfile().getSupportedExportProfiles(z().b(), CapabilityManager.f20040b.t());
        this.N = new NexExportProfile[supportedExportProfiles.length];
        this.ja = this.ia.getFloat("export_user_custom_bitrate_percent", EditorGlobal.B);
        int i = 0;
        while (true) {
            NexExportProfile[] nexExportProfileArr = this.N;
            if (i >= nexExportProfileArr.length) {
                break;
            }
            nexExportProfileArr[i] = supportedExportProfiles[i].mutableCopy();
            String str = "export_" + this.N[i].width() + FragmentC2201x.f23219a + this.N[i].height() + "_bitrate";
            if (this.ia.contains(str)) {
                this.ia.edit().remove(str).apply();
            }
            this.N[i].setBitrate(a(this.ja, this.N[i]));
            i++;
        }
        this.da = getIntent() == null ? null : getIntent().getStringExtra(ShareConstants.FEED_SOURCE_PARAM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        if (this.ea || this.N.length == 0) {
            return;
        }
        SupportLogger.Event.Activity_ShareQuality_ExportQualityClick.log(new int[0]);
        if (AdManager.a(this).b() == AdManager.ExportInterstitialAdsType.BEFORE) {
            this.la = true;
            da();
        } else {
            O();
        }
    }

    private void U() {
        if (this.N.length > 0) {
            this.S.setMinValue(0.0f);
            this.S.setMaxValue(100.0f);
            this.S.setValue(this.ja);
            this.S.setHideValueTab(true);
            this.S.setFocusable(false);
            this.S.setListener(new C2236u(this));
        }
    }

    private void V() {
        this.aa.setOnClickListener(new ViewOnClickListenerC2221h(this));
    }

    private void W() {
        ba();
        L();
        X();
        U();
        aa();
        Z();
        ca();
        Y();
        V();
        ga();
    }

    private void X() {
        this.R.setOnClickListener(new ViewOnClickListenerC2211c(this));
    }

    private void Y() {
        this.X.setOnTouchListener(new View.OnTouchListener() { // from class: com.nexstreaming.kinemaster.ui.share.b
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return ExportAndShareActivity.a(view, motionEvent);
            }
        });
    }

    private void Z() {
        this.M.setAdapter((ListAdapter) this.W);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        return true;
    }

    private void aa() {
        this.W.a(new ViewOnClickListenerC2233q(this));
    }

    private void ba() {
        String format;
        NexExportProfile[] nexExportProfileArr = this.N;
        if (nexExportProfileArr.length <= 0) {
            return;
        }
        String[] strArr = new String[nexExportProfileArr.length];
        int i = 0;
        while (true) {
            NexExportProfile[] nexExportProfileArr2 = this.N;
            if (i < nexExportProfileArr2.length) {
                int displayHeight = nexExportProfileArr2[i].displayHeight();
                if (displayHeight >= 500) {
                    format = String.format(Locale.US, "%s %dp", this.N[i].label(getResources()), Integer.valueOf(displayHeight));
                } else {
                    format = String.format(Locale.US, "%dp", Integer.valueOf(displayHeight));
                }
                strArr[i] = format;
                i++;
            } else {
                int i2 = this.ia.getInt("exporting_resolution", nexExportProfileArr2[0].displayHeight());
                com.nexstreaming.kinemaster.ui.widget.y yVar = new com.nexstreaming.kinemaster.ui.widget.y(this, strArr);
                this.P.setOnValueChangedListener(this);
                this.P.setViewAdapter(yVar);
                this.P.a(g(i2), false);
                return;
            }
        }
    }

    private void ca() {
        this.O.setTitle(getResources().getString(R.string.export_dialog_title));
        this.O.setLogo(R.drawable.title_share);
    }

    private void da() {
        com.nexstreaming.kinemaster.ad.g c2;
        if (c.d.b.m.e.f3850a.a() || (c2 = AdManager.a(u()).c(AdmobInterstitialAdProvider.class.getSimpleName())) == null) {
            return;
        }
        if (!C() && c2.isReady()) {
            if (c2.isReady()) {
                c2.showAd(this);
            }
        } else if (AdManager.a(u()).b() == AdManager.ExportInterstitialAdsType.BEFORE) {
            this.la = false;
            O();
        }
    }

    private void ea() {
        com.nexstreaming.kinemaster.ui.a.t tVar;
        if (this.ma == null) {
            this.ma = new com.nexstreaming.kinemaster.ui.a.t(this);
        }
        if (isFinishing() || (tVar = this.ma) == null || tVar.isShowing()) {
            return;
        }
        this.ma.a(60000L);
        this.ma.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fa() {
        getSupportFragmentManager().beginTransaction().replace(android.R.id.content, tb.a(y(), 0, "share", "Export", R.string.no_thanks_export_with_watermark), tb.f23200a).addToBackStack(tb.f23200a).commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ga() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        this.U.setText(getString(R.string.storage_remaining_msg, new Object[]{a(statFs.getAvailableBlocks() * statFs.getBlockSize())}));
    }

    @Override // com.nexstreaming.kinemaster.ui.share.na
    protected void J() {
        SupportLogger.Event.Activity_ShareQuality_OnProjectInfoAvailable.log(new int[0]);
        NexExportProfile P = P();
        if (P != null) {
            e(P);
            h(P);
        }
        try {
            com.nexstreaming.kinemaster.ui.projectgallery.O.a(this, H().e()).onResultAvailable(new C2217f(this)).onFailure((Task.OnFailListener) new C2215e(this));
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        }
        new AsyncTaskC2214da(this.ca, H().f(), this).executeOnExecutor(L, 0);
    }

    public void L() {
        String[] stringArray;
        if (this.ia.getBoolean("pref_export_60fps", false)) {
            stringArray = getResources().getStringArray(R.array.exporting_frame_rate_list_items60);
        } else {
            stringArray = getResources().getStringArray(R.array.exporting_frame_rate_list_items);
        }
        int f2 = f((int) Float.parseFloat(this.ia.getString("exporting_frame_rate", "30")));
        i(f2);
        this.Q.setViewAdapter(new com.nexstreaming.kinemaster.ui.widget.y(this, stringArray));
        this.Q.setOnValueChangedListener(this);
        this.Q.a(f2, false);
    }

    @Override // com.nexstreaming.app.general.iab.a.a
    public void a(LinkedHashMap<IABConstant.SKUType, LinkedHashMap<String, SKUDetails>> linkedHashMap) {
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        if (keyEvent.hasModifiers(4096) && keyEvent.getKeyCode() == 33) {
            T();
            return true;
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Intent intent2;
        super.onActivityResult(i, i2, intent);
        if (i != 100 || (intent2 = this.fa) == null) {
            return;
        }
        File file = new File(intent2.getStringExtra("path"));
        if (file.exists()) {
            file.delete();
        }
        this.fa = null;
    }

    @Override // com.nexstreaming.kinemaster.ui.share.na, com.nextreaming.nexeditorui.I, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.X.getVisibility() == 0) {
            M();
            return;
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager != null) {
            if (supportFragmentManager.findFragmentById(android.R.id.content) instanceof tb) {
                com.nexstreaming.kinemaster.usage.analytics.f.a("Close");
            }
            if (supportFragmentManager.popBackStackImmediate()) {
                return;
            }
        }
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.nexstreaming.kinemaster.usage.analytics.b.a(getLocalClassName());
        super.onCreate(bundle);
        SupportLogger.Event.Activity_ShareQuality_OnCreate.log(new int[0]);
        setContentView(R.layout.export_and_share_activity);
        a(bundle);
        S();
        W();
        y().a((com.nexstreaming.app.general.iab.a.a) this);
        if (!c.d.b.m.e.f3850a.a() || Build.VERSION.SDK_INT < 21) {
            return;
        }
        this.ha = new TencentAdManager(this, this.pa, TencentAdProvider.Companion.getES_UNIT_ID());
        this.ha.setContainer();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        y().b((com.nexstreaming.app.general.iab.a.a) this);
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        if (taskError instanceof DiagnosticLogger.a) {
            SupportLogger.Event.ExportDialogFragment_OnFail.log(((DiagnosticLogger.a) taskError).getIntErrorCode());
        } else {
            SupportLogger.Event.ExportDialogFragment_OnFail.log(new int[0]);
        }
        a((File) null, (NexExportProfile) null);
        b(taskError);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com.nexstreaming.kinemaster.ad.g a2;
        if (!C() && (a2 = AdManager.a(u()).a(AdmobAdProvider.EAS_AD_UNIT_ID)) != null) {
            a2.clearAd();
        }
        super.onPause();
    }

    @Override // com.nexstreaming.app.general.task.Task.OnProgressListener
    public void onProgress(Task task, Task.Event event, int i, int i2) {
        if (i2 > 0) {
            this.Z.setMax(i2);
            this.Z.setProgress(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        if (!C()) {
            if (c.d.b.m.e.f3850a.a()) {
                if (Build.VERSION.SDK_INT >= 21) {
                    this.ha.requestNativeExpressAd();
                }
            } else {
                AdManager a2 = AdManager.a(this);
                a2.a(this.na);
                a2.d(AdmobAdProvider.EAS_AD_UNIT_ID);
                a2.e(AdmobAdProvider.EAS_AD_INTERSTITIAL_ID);
            }
        }
        a(this.ba, true);
        if (this.la) {
            this.la = false;
            O();
        }
        y().a((com.nexstreaming.app.general.iab.a.a) this);
        super.onResume();
        if (this.oa) {
            Log.d("jason", "onResume: ");
            i(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        KMEvents.VIEW_EXPORT_SHARE.trackScreen(this);
        c.d.b.b.i.b().a((d.a) this);
        super.onStart();
    }

    @Override // com.nexstreaming.kinemaster.ui.share.na, com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        c.d.b.b.i.b().b(this);
        super.onStop();
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        if (event == Task.Event.COMPLETE) {
            U.a aVar = (U.a) task;
            a(aVar.a(), aVar.b());
        }
    }

    private int e(int i) {
        return this.N[i].displayHeight();
    }

    private void f(NexExportProfile nexExportProfile) {
        this.V.setText(String.format(Locale.US, " %.2f%s", Float.valueOf(nexExportProfile.bitrate() / 1048576.0f), "Mbps"));
    }

    private int g(int i) {
        int i2 = 0;
        while (true) {
            NexExportProfile[] nexExportProfileArr = this.N;
            if (i2 >= nexExportProfileArr.length) {
                return 0;
            }
            if (i == nexExportProfileArr[i2].displayHeight()) {
                return i2;
            }
            i2++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(NexExportProfile nexExportProfile) {
        String str;
        com.nexstreaming.kinemaster.project.k H = H();
        if (H != null) {
            str = getResources().getString(R.string.export_estimated_size, Integer.valueOf(Math.max(1, (((H.g() / 1000) * (nexExportProfile.bitrate() / 1024)) / 1024) / 8)));
        } else {
            str = "";
        }
        this.T.setText(str);
    }

    private void i(int i) {
        SharedPreferences.Editor edit = this.ia.edit();
        edit.putString("exporting_frame_rate", d(i));
        edit.apply();
    }

    private void j(int i) {
        SharedPreferences.Editor edit = this.ia.edit();
        edit.putInt("exporting_resolution", e(i));
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(NexExportProfile nexExportProfile) {
        a(nexExportProfile, false, R.string.export_dialog_message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(NexExportProfile nexExportProfile) {
        g(nexExportProfile);
        f(nexExportProfile);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(V v) {
        File file = new File(v.f23316e);
        e.a aVar = new e.a(this);
        aVar.b(getResources().getDimensionPixelOffset(R.dimen.muserk_license_popup_min_width));
        aVar.c(file.getName());
        aVar.c(R.string.exproted_file_delete_popup_msg);
        aVar.c(R.string.button_delete, new DialogInterfaceOnClickListenerC2235t(this, v));
        aVar.a(R.string.button_cancel, new DialogInterfaceOnClickListenerC2234s(this));
        aVar.a().show();
    }

    private String d(int i) {
        return Q()[i];
    }

    private int f(int i) {
        String[] Q = Q();
        for (int i2 = 0; i2 < Q.length; i2++) {
            if (i == Integer.parseInt(Q[i2])) {
                return i2;
            }
        }
        return 0;
    }

    private void g(NexExportProfile nexExportProfile) {
        nexExportProfile.setBitrate(a(this.S.getValue(), nexExportProfile));
    }

    private int b(NexExportProfile nexExportProfile) {
        return (int) (((((((float) (nexExportProfile.width() * nexExportProfile.height())) * 30.0f) * 4.0f) * 0.07f) / 1000.0f) * 1024.0f * 1.75f);
    }

    private void d(V v) {
        boolean z;
        Uri uriForFile = FileProvider.getUriForFile(this, getPackageName(), new File(v.f23316e));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("video/*");
        List<ResolveInfo> queryIntentActivities = getPackageManager().queryIntentActivities(intent, 0);
        a[] aVarArr = {new a("com.google.android.youtube", "com.google.android.youtube.UploadIntentHandlingActivity"), new a("com.facebook.katana", "com.facebook.composer.shareintent.ImplicitShareIntentHandlerDefaultAlias"), new a("com.dropbox.android", "com.dropbox.android.activity.DropboxSendTo")};
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            String str = resolveInfo.activityInfo.packageName;
            if (!str.equals(getPackageName())) {
                Intent intent2 = new Intent("android.intent.action.SEND");
                intent2.setType("video/*");
                intent2.putExtra("android.intent.extra.STREAM", uriForFile);
                intent2.setPackage(str);
                intent2.setClassName(str, resolveInfo.loadLabel(getPackageManager()).toString());
                intent2.setComponent(new ComponentName(str, resolveInfo.activityInfo.name));
                intent2.putExtra("displayName", resolveInfo.activityInfo.loadLabel(getPackageManager()));
                intent2.addFlags(3);
                int length = aVarArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = false;
                        break;
                    } else {
                        if (aVarArr[i].a(intent2)) {
                            z = true;
                            break;
                        }
                        i++;
                    }
                }
                if (z) {
                    arrayList.add(intent2);
                } else {
                    arrayList2.add(intent2);
                }
            }
        }
        View inflate = View.inflate(this, R.layout.share_intent_chooser_popup, null);
        com.nexstreaming.kinemaster.ui.a.e eVar = new com.nexstreaming.kinemaster.ui.a.e(this);
        eVar.setTitle(R.string.exprot_share);
        eVar.a(inflate, R.drawable.sns_dialog_bg);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(eVar.getWindow().getAttributes());
        layoutParams.width = getResources().getDimensionPixelOffset(R.dimen.share_popup_width);
        C2229m c2229m = new C2229m(this, v, eVar);
        if (!c.d.b.m.i.d(this) && arrayList.size() > 0) {
            inflate.findViewById(R.id.top_layout).setVisibility(0);
            ua uaVar = new ua(this, (Intent[]) arrayList.toArray(new Intent[0]));
            GridView gridView = (GridView) inflate.findViewById(R.id.top_share_targets);
            gridView.setOnItemClickListener(c2229m);
            gridView.setAdapter((ListAdapter) uaVar);
        }
        if (arrayList2.size() > 0) {
            ua uaVar2 = new ua(this, (Intent[]) arrayList2.toArray(new Intent[0]));
            GridView gridView2 = (GridView) inflate.findViewById(R.id.bottom_share_targets);
            gridView2.setOnItemClickListener(c2229m);
            gridView2.setAdapter((ListAdapter) uaVar2);
        }
        eVar.show();
        Window window = eVar.getWindow();
        window.setAttributes(layoutParams);
        window.setBackgroundDrawable(new ColorDrawable(0));
    }

    @Override // com.nexstreaming.kinemaster.ui.settings.tb.b
    public void i() {
        ea();
    }

    private void b(File file) {
        MediaScannerConnection.scanFile(this, new String[]{file.getAbsolutePath()}, null, new C2238w(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.nexstreaming.kinemaster.ui.a.e h(int i) {
        com.nexstreaming.kinemaster.ui.a.e eVar = new com.nexstreaming.kinemaster.ui.a.e(this);
        View inflate = View.inflate(this, R.layout.muserk_license_agreement_popup, null);
        eVar.a(inflate);
        eVar.c(getResources().getDimensionPixelOffset(R.dimen.muserk_license_popup_min_width));
        TextView textView = (TextView) inflate.findViewById(R.id.tv_msg);
        textView.setText(getText(i));
        textView.setOnClickListener(new ViewOnClickListenerC2225j(this));
        eVar.c(getResources().getString(R.string.agree_and_continue), new DialogInterfaceOnClickListenerC2227k(this));
        eVar.a(getResources().getString(R.string.button_cancel), new DialogInterfaceOnClickListenerC2228l(this));
        eVar.show();
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Uri b(Context context, File file) {
        String absolutePath = file.getAbsolutePath();
        Cursor query = context.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=? ", new String[]{absolutePath}, null);
        Uri uri = null;
        if (query != null) {
            if (query.moveToFirst()) {
                int i = query.getInt(query.getColumnIndex("_id"));
                uri = Uri.withAppendedPath(Uri.parse("content://media/external/video/media"), "" + i);
            }
            query.close();
        }
        if (uri != null) {
            return uri;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("_data", absolutePath);
        return context.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
    }

    private int a(float f2, NexExportProfile nexExportProfile) {
        double d2 = f2;
        Double.isNaN(d2);
        double b2 = b(nexExportProfile) - c(nexExportProfile);
        Double.isNaN(b2);
        return ((int) ((d2 / 100.0d) * b2)) + c(nexExportProfile);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(V v) {
        File file = new File(v.f23316e);
        if (file.exists()) {
            a(file, v.f23317f, v.f23318g);
            HashMap hashMap = new HashMap();
            hashMap.put("where", ExportAndShareActivity.class.getSimpleName());
            KMEvents.SHARE_EXPORT_PREVIEW.logEvent(hashMap);
            return;
        }
        a(v, R.string.file_not_found_play);
    }

    private int c(NexExportProfile nexExportProfile) {
        return (int) (((((((float) (nexExportProfile.width() * nexExportProfile.height())) * 30.0f) * 1.0f) * 0.07f) / 1000.0f) * 1024.0f * 0.75f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(V v) {
        if (new File(v.f23316e).exists()) {
            d(v);
        } else {
            a(v, R.string.file_not_found_share);
        }
    }

    private void a(V v, int i) {
        File file = new File(v.f23316e);
        e.a aVar = new e.a(this);
        aVar.b(getResources().getDimensionPixelOffset(R.dimen.muserk_license_popup_min_width));
        aVar.c(file.getName());
        aVar.c(i);
        aVar.c(R.string.button_ok, new r(this));
        aVar.a().show();
    }

    private void b(Task.TaskError taskError) {
        int i;
        if (taskError == NexEditor.b.db) {
            i = R.string.encoding_fail_notready;
        } else if (taskError == NexEditor.b.L) {
            i = R.string.encoding_fail_notready_transcode;
        } else if (taskError == NexEditor.b.ib) {
            i = R.string.encoding_fail_missingrsrc_text;
        } else if (taskError == NexEditor.b.hb) {
            i = R.string.encoding_fail_emptyproject_text;
        } else {
            i = taskError == NexEditor.b.X ? R.string.encoding_fail_diskfull_text : 0;
        }
        if (i != 0) {
            e.a aVar = new e.a(u());
            aVar.c(i);
            aVar.c(R.string.button_ok, new DialogInterfaceOnClickListenerC2230n(this));
            aVar.a().show();
            return;
        }
        e.a aVar2 = new e.a(u());
        aVar2.c(R.string.encoding_fail_error_text);
        aVar2.b(taskError.getLocalizedMessage(u()));
        aVar2.c(R.string.button_ok, new DialogInterfaceOnClickListenerC2231o(this));
        aVar2.a().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float a(NexExportProfile nexExportProfile) {
        double bitrate = nexExportProfile.bitrate() - c(nexExportProfile);
        double b2 = b(nexExportProfile) - c(nexExportProfile);
        Double.isNaN(bitrate);
        Double.isNaN(b2);
        return (float) ((bitrate / b2) * 100.0d);
    }

    private String a(long j) {
        return Formatter.formatFileSize(this, j);
    }

    private void a(ExportedVideoDatabase exportedVideoDatabase, File file, NexExportProfile nexExportProfile) {
        V v = new V();
        com.nexstreaming.kinemaster.project.k H = H();
        v.f23313b = H.f();
        v.f23314c = R();
        v.i = H.d().getTime();
        v.f23315d = H.c().getTime();
        v.f23316e = file.getAbsolutePath();
        v.f23317f = nexExportProfile.width();
        v.f23318g = nexExportProfile.displayHeight();
        v.f23319h = this.ga;
        this.ba.add(0, v);
        new AsyncTaskC2214da(exportedVideoDatabase, H().f(), v, new C2237v(this, exportedVideoDatabase)).executeOnExecutor(L, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ExportedVideoDatabase exportedVideoDatabase, V v) {
        File file = new File(v.f23316e);
        if (file.exists()) {
            file.delete();
        }
        this.ba.remove(v);
        b(file);
        HashMap hashMap = new HashMap();
        hashMap.put("where", ExportAndShareActivity.class.getSimpleName());
        KMEvents.SHARE_EXPORT_DELETE.logEvent(hashMap);
        new AsyncTaskC2214da(exportedVideoDatabase, H().f(), v, new C2239x(this, exportedVideoDatabase)).executeOnExecutor(L, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NexExportProfile nexExportProfile, boolean z, int i) {
        U.a a2 = a(nexExportProfile, z);
        if (a2 != null) {
            SupportLogger.Event.ShareBaseActivity_MadeExportDialog.log(new int[0]);
            this.Z.setProgress(0);
            this.X.setVisibility(0);
            this.Y.setText(i);
            a2.onComplete(this);
            a2.onFailure(this);
            a2.onProgress(this);
            a2.onCancel(this);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.share.na
    public void a(File file, NexExportProfile nexExportProfile) {
        Handler handler = new Handler();
        int i = 0;
        if (file != null) {
            if (this.fa != null) {
                this.fa.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(this, getPackageName(), file));
                this.fa.putExtra("path", file.getAbsolutePath());
                startActivityForResult(this.fa, 100);
            } else {
                a(this.ca, file, nexExportProfile);
                if (AdManager.a(this).b() == AdManager.ExportInterstitialAdsType.AFTER) {
                    da();
                    i = 500;
                }
                handler.post(new RunnableC2219g(this));
            }
        }
        handler.postDelayed(new RunnableC2223i(this), i);
    }

    @Override // com.nexstreaming.kinemaster.ui.share.AsyncTaskC2214da.a
    public void a(ArrayList<V> arrayList) {
        if (arrayList != null) {
            this.ba = arrayList;
            a(this.ba, false);
            this.W.a(this.ba);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.settings.tb.a
    public void a(String str) {
        i(true);
        d(P());
    }

    @Override // com.nexstreaming.app.general.iab.a.a
    public void a(boolean z, int i, boolean z2) {
        if (!z) {
            N();
        }
        if (c.d.b.m.i.f(this) || !z2) {
            return;
        }
        N();
        Toast.makeText(this, getString(R.string.theme_download_server_connection_error), 0).show();
    }

    @Override // com.nexstreaming.app.general.iab.a.a
    public void a(LinkedHashMap<IABConstant.SKUType, List<Purchase>> linkedHashMap, IABError iABError, String str) {
        N();
    }

    @Override // com.nexstreaming.app.general.iab.a.a
    public void a(boolean z, Purchase purchase, String str) {
        super.b(z, purchase, str);
        if (z) {
            try {
                this.oa = true;
                this.W.a((FrameLayout) null);
            } catch (Exception e2) {
                e2.printStackTrace();
                Fragment findFragmentById = getSupportFragmentManager().findFragmentById(android.R.id.content);
                if (findFragmentById != null && findFragmentById.isAdded() && (findFragmentById instanceof tb)) {
                    ((tb) findFragmentById).b(true);
                }
            }
            d(P());
        }
    }

    @Override // c.d.b.b.d.a
    public void a(c.d.b.b.d dVar, c.d.b.b.a.e eVar) {
        C2220ga c2220ga;
        if (!C() || (c2220ga = this.W) == null) {
            return;
        }
        c2220ga.a((FrameLayout) null);
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.WheelPicker.a
    public void a(WheelPicker wheelPicker, int i, int i2) {
        int id = wheelPicker.getId();
        if (id == R.id.fps_picker) {
            i(i2);
        } else {
            if (id != R.id.resolution_picker) {
                return;
            }
            j(i2);
            e(this.N[i2]);
            h(this.N[i2]);
        }
    }

    private void a(ArrayList<V> arrayList, boolean z) {
        if (arrayList == null) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<V> it = arrayList.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            V next = it.next();
            if (!new File(next.f23316e).exists()) {
                arrayList2.add(next);
                z2 = true;
            }
        }
        if (!z2 || arrayList2.size() <= 0) {
            return;
        }
        new AsyncTaskC2214da(this.ca, H().f(), (ArrayList<V>) arrayList2, (AsyncTaskC2214da.a) null).executeOnExecutor(L, 5);
        arrayList.removeAll(arrayList2);
        if (z) {
            this.W.a(arrayList);
        }
    }
}
