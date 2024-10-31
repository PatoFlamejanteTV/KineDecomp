package com.nexstreaming.kinemaster.ui.projectgallery;

import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import c.d.b.b.d;
import com.crashlytics.android.Crashlytics;
import com.google.gson.Gson;
import com.nexstreaming.app.general.service.notification.NotificationData;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.tracelog.NotifyAppResponse;
import com.nexstreaming.app.general.util.C1704h;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ad.AdManager;
import com.nexstreaming.kinemaster.ad.providers.AdmobAdProvider;
import com.nexstreaming.kinemaster.ad.providers.tencent.TencentAdListener;
import com.nexstreaming.kinemaster.ad.providers.tencent.TencentAdManager;
import com.nexstreaming.kinemaster.ad.providers.tencent.TencentAdProvider;
import com.nexstreaming.kinemaster.codeccaps.CapabilityManager;
import com.nexstreaming.kinemaster.codeccaps.CapabilityReport;
import com.nexstreaming.kinemaster.codeccaps.ui.CapabilityTestIntroActivity;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.integration.cloud.KMCloud;
import com.nexstreaming.kinemaster.intent.KMIntentData;
import com.nexstreaming.kinemaster.support.SupportAppsActivity;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nexstreaming.kinemaster.ui.a.r;
import com.nexstreaming.kinemaster.ui.e.c;
import com.nexstreaming.kinemaster.ui.projectedit.FullScreenInputActivity;
import com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity;
import com.nexstreaming.kinemaster.ui.projectgallery.Eb;
import com.nexstreaming.kinemaster.ui.settings.SettingsActivity;
import com.nexstreaming.kinemaster.ui.share.AsyncTaskC2214da;
import com.nexstreaming.kinemaster.ui.share.ExportedVideoDatabase;
import com.nexstreaming.kinemaster.ui.share.qa;
import com.nexstreaming.kinemaster.ui.store.controller.StoreActivity;
import com.nexstreaming.kinemaster.ui.widget.ImageCyclerView;
import com.nexstreaming.kinemaster.usage.AssetStoreEntry;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;
import com.nexstreaming.kinemaster.util.update.AssetUpdateChecker;
import com.nextreaming.nexeditorui.BailActivity;
import com.nextreaming.nexeditorui.C2343y;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.ExpiredActivity;
import com.nextreaming.nexeditorui.KineMasterApplication;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.newproject.NewProjectActivity;
import com.nextreaming.nexvideoeditor.NexEditor;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.umeng.analytics.pro.k;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes2.dex */
public class ProjectGalleryActivity extends com.nextreaming.nexeditorui.I implements qa.a, d.a, Eb.b {
    static int H = 0;
    private static int I = 1;
    private static Bitmap J;
    private WeakReference<com.nexstreaming.kinemaster.ui.a.e> Aa;
    private O Ba;
    private TencentAdManager Ca;
    private KMCloud Da;
    private com.nexstreaming.kinemaster.ui.a.e Ga;
    private com.nexstreaming.kinemaster.ui.a.e Ha;
    private com.nexstreaming.kinemaster.ui.e.c Ia;
    private boolean K;
    private boolean L;
    private float R;
    private float S;
    private float T;
    private float U;
    private View V;
    private View W;
    private View X;
    private View Y;
    private View Z;
    private View aa;
    private View ba;
    private View ca;
    private View[] da;
    private TextView ea;
    private TextView fa;
    private ImageView ga;
    private ImageView ha;
    private ImageButton ia;
    private ImageButton ja;
    private ImageButton ka;
    private ImageButton la;
    private ImageButton ma;
    private ImageButton na;
    private ImageButton oa;
    private ImageButton pa;
    private ImageButton qa;
    private ImageButton ra;
    private RecyclerView sa;
    private ImageCyclerView ta;
    private Eb ua;
    private com.nexstreaming.kinemaster.project.k va;
    private Runnable wa;
    private SortingMode ya;
    private com.nexstreaming.kinemaster.ui.a.r za;
    private boolean M = false;
    private boolean N = false;
    private boolean O = false;
    private int[] P = new int[2];
    private int Q = 0;
    private EnumSet<LoadingTask> xa = EnumSet.noneOf(LoadingTask.class);
    private ArrayList<String> Ea = new ArrayList<>();
    private Locale Fa = Locale.getDefault();
    KMCloud.b Ja = new C2134oa(this);
    private TencentAdListener.NativeExpressAdListener Ka = new La(this);
    private com.nexstreaming.kinemaster.ad.m La = new Na(this);
    private Runnable Ma = new RunnableC2104db(this);
    int Na = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum LoadingTask {
        ProjectList,
        DeviceCompatibilityDBCheck
    }

    /* loaded from: classes2.dex */
    public enum SortingMode {
        EDIT,
        MAKE,
        NAME;

        public static SortingMode fromString(String str) {
            if (str == null) {
                return EDIT;
            }
            if (str.equalsIgnoreCase("edit")) {
                return EDIT;
            }
            if (str.equalsIgnoreCase("make")) {
                return MAKE;
            }
            if (str.equalsIgnoreCase("name")) {
                return NAME;
            }
            return EDIT;
        }

        public boolean needsFaceDetection() {
            return this == EDIT;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements ResultTask.OnResultAvailableListener<NotifyAppResponse>, Task.OnFailListener {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<ProjectGalleryActivity> f22877a;

        public a(ProjectGalleryActivity projectGalleryActivity) {
            this.f22877a = new WeakReference<>(projectGalleryActivity);
        }

        @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultAvailable(ResultTask<NotifyAppResponse> resultTask, Task.Event event, NotifyAppResponse notifyAppResponse) {
            ProjectGalleryActivity projectGalleryActivity = this.f22877a.get();
            if (projectGalleryActivity != null) {
                projectGalleryActivity.a(notifyAppResponse);
            }
        }

        @Override // com.nexstreaming.app.general.task.Task.OnFailListener
        public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
            ProjectGalleryActivity projectGalleryActivity = this.f22877a.get();
            if (projectGalleryActivity != null) {
                projectGalleryActivity.b(taskError);
            }
        }
    }

    private void P() {
        AssetUpdateChecker.a(this).b().onResultAvailable(new C2109fa(this));
    }

    private void Q() {
        int a2 = com.nextreaming.nexeditorui.E.c().a(c.d.b.m.i.d(this) ? 1000 : 5000);
        if (com.nextreaming.nexeditorui.E.c().a(true)) {
            Log.i("START_FLOW", "ProjectGalleryActivity:checkForDeviceSupportDBUpdates LOCAL");
            a(LoadingTask.DeviceCompatibilityDBCheck);
            return;
        }
        Log.i("START_FLOW", "ProjectGalleryActivity:checkForDeviceSupportDBUpdates timeout=" + a2);
        com.nexstreaming.kinemaster.tracelog.f.a(this).setTimeout((long) a2).onResultAvailable(new Qa(this)).onFailure((Task.OnFailListener) new Pa(this));
    }

    private void R() {
        a aVar = new a(this);
        com.nexstreaming.kinemaster.tracelog.f.b(this).onResultAvailable(aVar).onFailure((Task.OnFailListener) aVar);
    }

    private void S() {
        String action = getIntent().getAction();
        if (action != null) {
            if (!action.equals("android.intent.action.MAIN")) {
                if (action.equals(KMIntentData.ACTION_KINEMASTER_NEW_PROJECT_INTENT)) {
                    getIntent().getBooleanExtra(KMIntentData.KEY_FROM_SDK, false);
                } else {
                    action.equals(NotificationData.ACTION_NOTIFICATION);
                }
            }
            Log.d("ProjectGalleryActivity", "checkMPOpenEvent() called with: " + action);
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            if (defaultSharedPreferences.getBoolean("first_open", true)) {
                defaultSharedPreferences.edit().putBoolean("first_open", false).apply();
            }
        }
    }

    private void T() {
        String str;
        if (EditorGlobal.f24026e == EditorGlobal.VersionType.RC || EditorGlobal.f24026e == EditorGlobal.VersionType.Release) {
            return;
        }
        if (EditorGlobal.f24026e != EditorGlobal.VersionType.Beta || EditorGlobal.r() == null) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            if (14242 != defaultSharedPreferences.getInt("km_versionWarningVer", 0)) {
                switch (zb.f23012c[EditorGlobal.f24026e.ordinal()]) {
                    case 1:
                        str = "WARNING! This is an ALPHA version.";
                        break;
                    case 2:
                        str = "WARNING! This is a BETA version.";
                        break;
                    case 3:
                        str = "WARNING! This is an EVALUATION/TEST version.";
                        break;
                    case 4:
                        str = "Important: This is an KineMaster Team evaluation version, for use by authorized recipients only.";
                        break;
                    case 5:
                        str = "WARNING! This is a DEVELOPER version.";
                        break;
                    case 6:
                        str = "WARNING! This version is for TRADESHOW DEMO use only.";
                        break;
                    default:
                        str = "WARNING! This is a TEST version.";
                        break;
                }
                e.a aVar = new e.a(this);
                aVar.a(str + "\nNot for release or distribution!");
                aVar.b("(Version: " + com.nexstreaming.app.general.util.N.d(this).replace(".FREE", "") + ")");
                aVar.c(R.string.button_ok, new Oa(this, defaultSharedPreferences));
                aVar.a().show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        e.a aVar = new e.a(this);
        aVar.e(R.string.capa_hw_perform_analysis_cancel_notice_popup_title);
        aVar.c(R.string.capa_hw_perform_analysis_cancel_notice_popup_msg);
        aVar.c(R.string.run_analysis_now, new Xa(this));
        aVar.a(R.string.button_cancel, new Wa(this));
        aVar.a().show();
    }

    private void V() {
        com.nexstreaming.kinemaster.ui.a.e eVar = new com.nexstreaming.kinemaster.ui.a.e(this);
        eVar.a(getString(R.string.exit_project_confirmation_dialog));
        eVar.c(getString(R.string.button_yes), new xb(this, eVar));
        eVar.a(getString(R.string.button_no), new yb(this, eVar));
        eVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        File file;
        String str;
        String string = EditorGlobal.t() ? "Demo Project" : getResources().getString(R.string.default_project_name);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        defaultSharedPreferences.getBoolean("km.pga.tried_new_proj_assist", false);
        defaultSharedPreferences.getBoolean("km.pga.tried_new_proj_empty", false);
        defaultSharedPreferences.edit().putBoolean("km.pga.tried_new_proj_empty", true).apply();
        int i = 0;
        while (true) {
            if (i >= 10000) {
                file = null;
                break;
            }
            String absolutePath = EditorGlobal.o().getAbsolutePath();
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            String str2 = "";
            if (i > 0) {
                str = " " + i;
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(VideoEditor.u());
            file = new File(absolutePath, sb.toString());
            String absolutePath2 = EditorGlobal.o().getAbsolutePath();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(string);
            if (i > 0) {
                str2 = " " + i;
            }
            sb2.append(str2);
            sb2.append(".nexvideoproject");
            File file2 = new File(absolutePath2, sb2.toString());
            if (!file.exists() && !file2.exists()) {
                break;
            } else {
                i++;
            }
        }
        if (file != null) {
            String a2 = C2343y.a();
            HashMap hashMap = new HashMap();
            hashMap.put("aspect_ratio", a2);
            hashMap.put("type", "empty");
            KMEvents.PROJECT_NEW.logEvent(hashMap);
            startActivityForResult(ProjectEditActivity.a(this, file), 8226);
            overridePendingTransition(0, 0);
            ha();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        com.nexstreaming.kinemaster.ui.a.r rVar = this.za;
        if (rVar != null) {
            rVar.dismiss();
            this.za = null;
        }
    }

    private void Y() {
        PreferenceManager.getDefaultSharedPreferences(this);
        R();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        Intent intent = new Intent(this, (Class<?>) StoreActivity.class);
        intent.putExtra("fromActivity", AssetStoreEntry.PROJECT_LIST);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa() {
        startActivity(new Intent(this, (Class<?>) SupportAppsActivity.class));
        overridePendingTransition(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Task.TaskError taskError) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba() {
        startActivity(new Intent(this, (Class<?>) SettingsActivity.class));
        overridePendingTransition(0, 0);
    }

    private void ca() {
        Date d2;
        Log.i("START_FLOW", "ProjectGalleryActivity:onFinishedLoading");
        z();
        O();
        if (isFinishing()) {
            return;
        }
        Y();
        ArrayList<com.nexstreaming.kinemaster.project.k> h2 = this.ua.h();
        Date date = null;
        int i = 0;
        for (int i2 = 0; i2 < h2.size(); i2++) {
            com.nexstreaming.kinemaster.project.k kVar = h2.get(i2);
            if (kVar != null && (d2 = kVar.d()) != null && (date == null || d2.after(date))) {
                i = i2;
                date = d2;
            }
        }
        ma();
        this.W.setVisibility(0);
        this.W.setAlpha(0.0f);
        this.W.animate().setStartDelay(0L).alpha(1.0f).setDuration(600L);
        this.sa.post(new Ra(this, i));
        if (!ExpiredActivity.a(this)) {
            ExpiredActivity.b(this).onComplete(new Sa(this));
        }
        ja();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void da() {
        Dialog dialog = new Dialog(this, android.R.style.Theme.Light);
        dialog.requestWindowFeature(1);
        dialog.setContentView(R.layout.dialog_select_aspect_ratio);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        ((ImageButton) dialog.findViewById(R.id.ratio16v9)).setOnClickListener(new tb(this, dialog));
        ((ImageButton) dialog.findViewById(R.id.ratio9v16)).setOnClickListener(new ub(this, dialog));
        ((ImageButton) dialog.findViewById(R.id.ratio1v1)).setOnClickListener(new vb(this, dialog));
        ((ImageButton) dialog.findViewById(R.id.close)).setOnClickListener(new wb(this, dialog));
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ea() {
        String f2 = this.va.f();
        FullScreenInputActivity.a a2 = FullScreenInputActivity.a(this);
        a2.b(f2);
        a2.c(false);
        a2.e(false);
        a2.d(true);
        a2.a(true);
        startActivityForResult(a2.a(), FullScreenInputActivity.s());
    }

    private void fa() {
        Log.i("START_FLOW", "ProjectGalleryActivity:refreshProjectList");
        if (Build.VERSION.SDK_INT >= 23) {
            String[] strArr = com.nexstreaming.kinemaster.ui.e.b.f21563a;
            if (c.d.b.m.e.f3850a.a()) {
                strArr = com.nexstreaming.kinemaster.ui.e.b.f21568f;
            }
            if (!com.nexstreaming.kinemaster.ui.e.b.a((Context) this, strArr)) {
                if (c.d.b.m.h.a(Locale.getDefault())) {
                    if (this.Ia == null) {
                        this.Ia = com.nexstreaming.kinemaster.ui.e.c.a(strArr);
                    }
                    if (!this.Ia.isVisible()) {
                        this.Ia.a(this, new c.b() { // from class: com.nexstreaming.kinemaster.ui.projectgallery.h
                            @Override // com.nexstreaming.kinemaster.ui.e.c.b
                            public final void a(int i) {
                                ProjectGalleryActivity.this.d(i);
                            }
                        });
                    }
                } else if (com.nexstreaming.kinemaster.ui.e.b.a((Activity) this, strArr)) {
                    b(strArr).show();
                } else {
                    com.nexstreaming.kinemaster.ui.e.b.a(this, strArr, k.a.v);
                }
            }
        }
        if (this.ya == null) {
            this.ya = SortingMode.fromString(PreferenceManager.getDefaultSharedPreferences(this).getString("sorting_project", "edit"));
        }
        Log.i("START_FLOW", "ProjectGalleryActivity:refreshProjectList GET/BEGIN");
        com.nexstreaming.kinemaster.project.k.a(this.ya).onResultAvailable(new C2110fb(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ga() {
        O o;
        this.L = false;
        if (!this.K || (o = this.Ba) == null || o.e()) {
            return;
        }
        this.K = false;
        this.va = null;
        this.W.setVisibility(0);
        this.X.setVisibility(4);
        this.W.setAlpha(1.0f);
        this.ta.setBlur(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ha() {
        this.L = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"StringFormatInvalid"})
    public void ia() {
        e.a aVar = new e.a(this);
        aVar.a(getString(R.string.asset_update_confirm_content, new Object[]{AssetUpdateChecker.a(this).d()}));
        aVar.a(new Ha(this));
        aVar.a(R.string.asset_update_confirm_update_later, new Ga(this));
        aVar.c(R.string.asset_update_confirm_update_now, new Fa(this));
        aVar.a().show();
    }

    private void ja() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ka() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        e.a aVar = new e.a(this);
        aVar.e(R.string.rate_review_popup_title);
        aVar.c(R.string.rate_review_popup_msg);
        aVar.a(new Ea(this, defaultSharedPreferences));
        aVar.b(R.string.button_never_show, new Da(this, defaultSharedPreferences));
        aVar.a(R.string.button_remind_me_later, new Ca(this, defaultSharedPreferences));
        aVar.c(R.string.button_rate, new Aa(this, defaultSharedPreferences));
        aVar.a().show();
    }

    private void la() {
        boolean z = PreferenceManager.getDefaultSharedPreferences(this).getBoolean("wx_event", false);
        boolean z2 = y().v() ? !y().t() : false;
        if ((c.d.b.m.i.a() || c.d.b.m.i.b()) && c.d.b.m.i.b(this) <= EditorGlobal.f().getTime() && com.nexstreaming.app.kinemasterfree.wxapi.e.b(this).isWXAppInstalled() && com.nexstreaming.app.kinemasterfree.wxapi.e.b(this).isWXAppSupportAPI() && z2 && !z && !this.O) {
            this.O = true;
            getSupportFragmentManager().beginTransaction().add(android.R.id.content, new com.nexstreaming.kinemaster.ui.share.qa(), com.nexstreaming.kinemaster.ui.share.qa.class.getName()).addToBackStack(com.nexstreaming.kinemaster.ui.share.qa.class.getName()).commitAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ma() {
        if (!this.ua.h().isEmpty()) {
            this.sa.setVisibility(0);
            this.V.setVisibility(0);
        } else {
            this.sa.setVisibility(8);
            this.V.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int s(ProjectGalleryActivity projectGalleryActivity) {
        int i = projectGalleryActivity.Q;
        projectGalleryActivity.Q = i + 1;
        return i;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        if (keyEvent.hasModifiers(4096)) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 29) {
                this.ka.performClick();
                return true;
            }
            if (keyCode == 36) {
                this.na.performClick();
                return true;
            }
            if (keyCode == 42) {
                this.oa.performClick();
                return true;
            }
            if (keyCode == 47) {
                this.ma.performClick();
                return true;
            }
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // com.nextreaming.nexeditorui.I, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 8194) {
            startActivity(new Intent(this, (Class<?>) CapabilityTestIntroActivity.class).putExtra("device_id", FullScreenInputActivity.e(intent)));
        } else if (i != 8211 && i != 8212) {
            if (i == FullScreenInputActivity.s()) {
                if (this.va == null) {
                    return;
                }
                File d2 = FullScreenInputActivity.d(intent);
                String e2 = FullScreenInputActivity.e(intent);
                if (i2 == 1 && d2 != null && e2 != null) {
                    a(e2, d2);
                }
            } else if (intent != null && i == FullScreenInputActivity.t()) {
                File d3 = FullScreenInputActivity.d(intent);
                Intent intent2 = new Intent(this, (Class<?>) NewProjectActivity.class);
                intent2.putExtra("ProjectPath", d3);
                startActivityForResult(intent2, 8226);
            } else if (i == 8195) {
                if (i2 == -1) {
                    String stringExtra = intent.getStringExtra("cloudName");
                    VideoEditor videoEditor = new VideoEditor(z(), this, false, null);
                    videoEditor.a(this.va.e()).onComplete(new C2119ib(this, videoEditor, stringExtra));
                }
            } else if (i == 8226) {
                fa();
                ga();
            }
        } else {
            fa();
        }
        KMCloud kMCloud = this.Da;
        if (kMCloud != null) {
            kMCloud.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.nextreaming.nexeditorui.I, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (getFragmentManager().popBackStackImmediate()) {
            return;
        }
        if (this.K) {
            this.K = false;
            this.va = null;
            ObjectAnimator.ofObject(this.ta, "blur", new FloatEvaluator(), 1, 0).setDuration(500L).start();
            this.W.setAlpha(0.0f);
            this.aa.animate().setStartDelay(0L).alpha(0.0f).setDuration(100L);
            this.Y.animate().setStartDelay(75L).translationX(this.R).translationY(this.S).scaleX(this.T).scaleY(this.U).setDuration(300L);
            this.Z.animate().setStartDelay(0L).alpha(0.0f).setDuration(410L).withEndAction(new RunnableC2107eb(this));
            this.W.setVisibility(0);
            this.W.animate().setStartDelay(150L).alpha(1.0f).setDuration(258L);
            this.sa.requestFocus();
            return;
        }
        if (c.d.b.m.e.f3850a.a(this)) {
            V();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        com.nexstreaming.kinemaster.usage.analytics.b.a(getLocalClassName());
        super.onCreate(bundle);
        Log.i("START_FLOW", "ProjectGalleryActivity:onCreate");
        if (!isTaskRoot() && com.nexstreaming.kinemaster.ui.share.U.b().c()) {
            finish();
            return;
        }
        if (ExpiredActivity.a(this)) {
            return;
        }
        this.M = true;
        setContentView(R.layout.project_gallery);
        if ((Build.PRODUCT.startsWith("j7e3g") || Build.PRODUCT.startsWith("j7elte")) && Build.VERSION.SDK_INT < 23) {
            BailActivity.a(this, getResources().getString(R.string.device_nosupport_android_version_ins, "6.0"), BailActivity.ReasonCode.NeedUpgrade, NexEditorDeviceProfile.getDeviceProfile().getDeviceNotSupportedReason().getCode());
        }
        if (Build.PRODUCT.startsWith("j7ltechn") || Build.PRODUCT.startsWith("j75ltektt")) {
            BailActivity.a(this, R.string.device_support_none, NexEditorDeviceProfile.getDeviceProfile().getDeviceNotSupportedReason());
        }
        this.sa = (RecyclerView) findViewById(R.id.projectList);
        this.V = findViewById(R.id.projectListHolder);
        this.W = findViewById(R.id.foregroundLayout);
        this.X = findViewById(R.id.projectDetails);
        this.Y = findViewById(R.id.projectDetailsThumbHolder);
        this.Z = findViewById(R.id.projectDetailsNonthumb);
        this.ga = (ImageView) findViewById(R.id.projectDetailsThumb);
        this.aa = findViewById(R.id.editProject);
        this.ba = findViewById(R.id.tipAndOverlayGHolder);
        this.ca = findViewById(R.id.tipHolder);
        this.ea = (TextView) findViewById(R.id.tipText);
        this.ha = (ImageView) findViewById(R.id.tipIcon);
        this.ia = (ImageButton) findViewById(R.id.youtubeButton);
        this.ja = (ImageButton) findViewById(R.id.weiboButton);
        this.ka = (ImageButton) findViewById(R.id.storeButton);
        this.la = (ImageButton) findViewById(R.id.assistantButton);
        this.ma = (ImageButton) findViewById(R.id.settingsButton);
        this.na = (ImageButton) findViewById(R.id.helpButton);
        this.oa = (ImageButton) findViewById(R.id.addProject);
        this.fa = (TextView) findViewById(R.id.projectDetailsTitle);
        this.pa = (ImageButton) findViewById(R.id.projectPreviewPlay);
        this.qa = (ImageButton) findViewById(R.id.projectShare);
        this.ra = (ImageButton) findViewById(R.id.projectDelete);
        this.sa.setVisibility(8);
        this.W.setVisibility(4);
        this.ta = (ImageCyclerView) findViewById(R.id.image_cycler_view);
        if (c.d.b.m.e.f3850a.a()) {
            this.ia.setVisibility(8);
            this.ma.setNextFocusLeftId(R.id.weiboButton);
        } else {
            this.ja.setVisibility(8);
            this.ma.setNextFocusLeftId(R.id.youtubeButton);
        }
        this.sa.setNextFocusLeftId(R.id.assistantButton);
        this.sa.setNextFocusRightId(R.id.storeButton);
        this.ia.setOnClickListener(new C2112ga(this));
        this.ja.setOnClickListener(new Ba(this));
        int dimension = (int) getResources().getDimension(R.dimen.project_gallery_thumb_width);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.ua = new Eb(this, com.bumptech.glide.c.a((FragmentActivity) this), this.la, this.ka, dimension, Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels), new ArrayList());
        this.ua.a(this);
        this.sa.setAdapter(this.ua);
        this.W.getViewTreeObserver().addOnGlobalLayoutListener(new Ma(this));
        this.sa.setOnFocusChangeListener(new Ya(this));
        this.la.setOnClickListener(new pb(this));
        this.oa.setOnClickListener(new Ab(this));
        this.ma.setOnClickListener(new Bb(this));
        this.na.setOnClickListener(new Cb(this));
        this.fa.setOnKeyListener(new Db(this));
        if (c.d.b.m.e.f3850a.a()) {
            this.ka.setImageResource(R.drawable.btn_tiktok_selector);
        }
        this.ka.setOnClickListener(new Q(this));
        this.da = new View[]{findViewById(R.id.overlay_a), findViewById(R.id.overlay_b), findViewById(R.id.overlay_c), findViewById(R.id.overlay_d), findViewById(R.id.overlay_e), findViewById(R.id.overlay_f), findViewById(R.id.overlay_g)};
        for (View view : this.da) {
            view.setVisibility("np".equals(view.getTag()) ? 8 : 4);
            view.setOnClickListener(new S(this));
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        this.ya = SortingMode.fromString(defaultSharedPreferences.getString("sorting_project", "edit"));
        fa();
        if (defaultSharedPreferences.getBoolean("asset_dev_mode", false)) {
            EditorGlobal.k().mkdirs();
            String u = KineMasterApplication.i().u();
            if (u != null) {
                e.a aVar = new e.a(this);
                aVar.a("Error loading assets from /KineMaster/AssetPlugins");
                aVar.b(u);
                aVar.c(R.string.button_ok, new T(this));
                aVar.a().show();
                KineMasterApplication.i().f();
            } else if (KineMasterApplication.i().v()) {
                e.a aVar2 = new e.a(this);
                aVar2.a("Assets updated from /KineMaster/AssetPlugins");
                aVar2.c(R.string.button_ok, new U(this));
                aVar2.a().show();
                KineMasterApplication.i().g();
            }
        }
        this.aa.setOnClickListener(new V(this));
        Q();
        this.fa.setOnTouchListener(new W(this));
        this.pa.setOnClickListener(new X(this));
        this.qa.setOnClickListener(new C2097ba(this));
        this.ra.setOnClickListener(new C2103da(this));
        findViewById(R.id.projectDuplicate).setOnClickListener(new View.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.projectgallery.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ProjectGalleryActivity.this.a(view2);
            }
        });
        if (!c.d.b.m.e.f3850a.a() && EditorGlobal.f24026e == EditorGlobal.VersionType.RC) {
            M();
        }
        if (!EditorGlobal.f24025d) {
            T();
        }
        x();
        S();
        this.Ba = new O(this, w());
        P();
        G();
    }

    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        F();
        super.onDestroy();
        O o = this.Ba;
        if (o != null) {
            o.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i("ProjectGalleryActivity", "onNewIntent() called with: intent = [" + intent + "]");
        c(intent);
    }

    @Override // com.nextreaming.nexeditorui.I, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com.nexstreaming.kinemaster.ad.g a2;
        Runnable runnable;
        View view = this.ca;
        if (view != null && (runnable = this.Ma) != null) {
            view.removeCallbacks(runnable);
        }
        KMCloud kMCloud = this.Da;
        if (kMCloud != null) {
            kMCloud.onPause();
        }
        if (!C() && (a2 = AdManager.a(this).a(AdmobAdProvider.PL_AD_UNIT_ID)) != null) {
            a2.clearAd();
        }
        super.onPause();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 8201) {
            boolean a2 = com.nexstreaming.kinemaster.ui.e.b.a(this, com.nexstreaming.kinemaster.ui.e.b.f21563a, iArr);
            if (c.d.b.m.h.a(this.Fa)) {
                finish();
            }
            if (a2) {
                K();
            } else if (!com.nexstreaming.kinemaster.ui.e.b.a((Activity) this, strArr)) {
                b(strArr).show();
            } else {
                a(strArr).show();
            }
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // com.nextreaming.nexeditorui.I, android.app.Activity
    protected void onRestart() {
        if (this.L) {
            ga();
        }
        SortingMode fromString = SortingMode.fromString(PreferenceManager.getDefaultSharedPreferences(this).getString("sorting_project", "edit"));
        this.ta.setAnimationEnabled(true);
        if (this.N || this.ya != fromString) {
            this.N = false;
            fa();
        }
        this.ya = fromString;
        super.onRestart();
    }

    @Override // com.nextreaming.nexeditorui.I, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        CapabilityManager.f20040b.b((CapabilityManager.CapabilityMode) null);
        super.onResume();
        KMCloud kMCloud = this.Da;
        if (kMCloud != null) {
            kMCloud.onResume();
        }
        if (c.d.b.m.e.f3850a.a()) {
            if (!C() && !EditorGlobal.s()) {
                this.Ca = new TencentAdManager(this, this.Ka, TencentAdProvider.Companion.getPG_UNIT_ID());
                this.Ca.setContainer();
                this.Ca.requestNativeExpressAd();
            } else if (!this.ua.j()) {
                this.ua.a((FrameLayout) null);
            }
        } else if (!C()) {
            AdManager a2 = AdManager.a(this);
            a2.a(this.La);
            a2.d(AdmobAdProvider.PL_AD_UNIT_ID);
            a2.f(AdmobAdProvider.TIMELINE_AD_UNIT_ID);
        } else if (!this.ua.j()) {
            this.ua.a((FrameLayout) null);
        }
        com.nexstreaming.kinemaster.ui.gdpr.l.a(this);
    }

    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        Runnable runnable;
        Log.i("START_FLOW", "ProjectGalleryActivity:onResume");
        KMEvents.VIEW_PROJECT_LIST.trackScreen(this);
        View view = this.ca;
        if (view != null && (runnable = this.Ma) != null) {
            WeakReference<com.nexstreaming.kinemaster.ui.a.e> weakReference = this.Aa;
            if (weakReference != null) {
                if (weakReference.get() == null) {
                    this.ca.post(this.Ma);
                }
            } else {
                view.post(runnable);
            }
        }
        c.d.b.b.i.b().a((d.a) this);
        super.onStart();
    }

    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        boolean z = this.K;
        this.ta.setAnimationEnabled(false);
        KMCloud kMCloud = this.Da;
        if (kMCloud != null) {
            kMCloud.onStop();
        }
        c.d.b.b.i.b().b(this);
        com.nexstreaming.kinemaster.ui.a.e eVar = this.Ga;
        if (eVar != null && eVar.isShowing()) {
            this.Ga.dismiss();
        }
        com.nexstreaming.kinemaster.ui.a.e eVar2 = this.Ha;
        if (eVar2 != null && eVar2.isShowing()) {
            this.Ha.dismiss();
        }
        super.onStop();
    }

    @Override // com.nextreaming.nexeditorui.I, android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            if (this.ua.getItemCount() > 0) {
                if (this.ua.i() != -1) {
                    this.sa.requestFocus();
                    return;
                } else {
                    this.oa.requestFocus();
                    return;
                }
            }
            this.oa.requestFocus();
            this.sa.clearFocus();
            this.ua.f();
        }
    }

    private void K() {
        if (com.nextreaming.nexeditorui.E.c().d()) {
            Log.d("ProjectGalleryActivity", "KMConfigFile.getInstance().isFileExists()");
            PreferenceManager.getDefaultSharedPreferences(this).edit().remove("apc_sku_date").remove("apc_skus").commit();
            System.exit(0);
            return;
        }
        fa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean L() {
        return this.K && this.va != null;
    }

    private void M() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        int i = 0;
        boolean z = defaultSharedPreferences.getBoolean("rate_neverShowReviewPopup", false);
        int i2 = defaultSharedPreferences.getInt("rate_export_success_count", 0);
        long j = defaultSharedPreferences.getLong("rate_nextShowPopupDate", 0L);
        boolean z2 = j > 0 && new Date().getTime() > j;
        File d2 = EditorGlobal.d(this);
        if (d2.exists() && d2.listFiles() != null) {
            i = d2.listFiles().length;
        }
        if (!z && z2) {
            ka();
            return;
        }
        if (z || i < 2 || i2 < 2 || j != 0) {
            return;
        }
        e.a aVar = new e.a(this);
        aVar.c(R.string.rate_like_km_popup_msg);
        aVar.a(new DialogInterfaceOnCancelListenerC2155za(this, defaultSharedPreferences));
        aVar.a(R.string.button_no, new DialogInterfaceOnClickListenerC2153ya(this, defaultSharedPreferences));
        aVar.c(R.string.button_review_yes, new DialogInterfaceOnClickListenerC2145ua(this));
        aVar.a().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        CapabilityReport.CapabilityInfo b2 = CapabilityManager.f20040b.b();
        if (b2 == null || b2.versionNum <= 0) {
            com.nexstreaming.kinemaster.ui.a.t tVar = new com.nexstreaming.kinemaster.ui.a.t(this);
            tVar.show();
            CapabilityManager.f20040b.a(new Va(this, tVar, b2));
        }
    }

    private void O() {
        NexEditor.EditorInitException l = KineMasterApplication.i().l();
        if (l != null) {
            Log.i("ProjectGalleryActivity", "bail: initException", l);
            if (l.hasErrorCode) {
                BailActivity.a(this, R.string.bail_init_fail, BailActivity.ReasonCode.InitFail, l.errorCode);
                return;
            } else {
                BailActivity.a(this, R.string.bail_init_fail, BailActivity.ReasonCode.InitFail);
                return;
            }
        }
        UnsatisfiedLinkError n = KineMasterApplication.i().n();
        if (n != null) {
            Log.i("ProjectGalleryActivity", "bail: linkException", n);
            BailActivity.a(this, R.string.bail_bad_install, BailActivity.ReasonCode.LinkFail);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(boolean z) {
        if (z) {
            this.va = null;
            com.nexstreaming.kinemaster.project.k.a(this.ya).onResultAvailable(new nb(this));
        } else {
            e.a aVar = new e.a(this);
            aVar.c(R.string.project_gallery_duplicate_fail_project_popup);
            aVar.a(R.string.button_ok, new ob(this));
            aVar.a().show();
        }
    }

    public void G() {
        if (c.d.b.m.e.f3850a.a()) {
            this.ia.clearFocus();
        } else {
            this.ja.clearFocus();
        }
        this.ma.clearFocus();
        this.na.clearFocus();
        this.la.clearFocus();
        this.ka.clearFocus();
        this.oa.clearFocus();
    }

    @Override // com.nextreaming.nexeditorui.I
    protected void j(boolean z) {
        if (Build.VERSION.SDK_INT < 23 || com.nexstreaming.kinemaster.ui.e.b.a((Context) this, com.nexstreaming.kinemaster.ui.e.b.f21563a)) {
            super.j(false);
            la();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.share.qa.a
    public void o() {
        getFragmentManager().popBackStackImmediate();
    }

    @Override // com.nexstreaming.kinemaster.ui.share.qa.a
    public void q() {
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        WXWebpageObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = getString(R.string.wx_promotion_event_url);
        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
        wXMediaMessage.title = getString(R.string.wechat_share_event_message);
        wXMediaMessage.description = getString(R.string.wechat_share_event_message);
        wXMediaMessage.setThumbImage(decodeResource);
        decodeResource.recycle();
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = "webpage" + System.currentTimeMillis();
        req.message = wXMediaMessage;
        req.scene = 1;
        com.nexstreaming.app.kinemasterfree.wxapi.e.b(this).sendReq(req);
        getFragmentManager().popBackStackImmediate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"StringFormatInvalid"})
    public void e(String str) {
        com.nexstreaming.kinemaster.ui.a.r rVar = this.za;
        if (rVar != null) {
            rVar.dismiss();
            this.za = null;
        }
        if (this.za == null) {
            r.a aVar = new r.a(this);
            aVar.a(false);
            aVar.a(getString(R.string.uploading_project, new Object[]{str}));
            this.za = aVar.a();
            this.za.show();
        }
    }

    public /* synthetic */ void d(DialogInterface dialogInterface, int i) {
        com.nexstreaming.kinemaster.project.k kVar = this.va;
        if (kVar == null) {
            return;
        }
        if (c(kVar.e().getName())) {
            a(this.va);
            dialogInterface.dismiss();
        } else {
            boolean b2 = b(this.va);
            dialogInterface.dismiss();
            k(b2);
        }
    }

    public static Bitmap c(int i) {
        if (i == 0 || I != i) {
            return null;
        }
        return J;
    }

    private com.nexstreaming.kinemaster.ui.a.e b(String[] strArr) {
        if (this.Ga == null) {
            e.a a2 = com.nexstreaming.kinemaster.ui.e.b.a(this, strArr, new DialogInterface.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.projectgallery.l
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    ProjectGalleryActivity.this.c(dialogInterface, i);
                }
            });
            a2.a(new DialogInterface.OnDismissListener() { // from class: com.nexstreaming.kinemaster.ui.projectgallery.j
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    ProjectGalleryActivity.this.a(dialogInterface);
                }
            });
            this.Ga = a2.a();
        }
        return this.Ga;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Intent intent) {
        String action;
        Intent intent2;
        File file;
        String str;
        if (intent == null || (action = intent.getAction()) == null) {
            return;
        }
        if (action.equals(KMIntentData.ACTION_KINEMASTER_NEW_PROJECT_INTENT)) {
            this.N = true;
            String stringExtra = intent.getStringExtra(KMIntentData.KEY_KINEMASTER_INTENT_PROJET_DATA);
            if (stringExtra != null) {
                this.Ba.a((KMIntentData) new Gson().fromJson(stringExtra, KMIntentData.class), y().e()).onComplete(new C2139ra(this, intent)).onCancel(new C2138qa(this)).onFailure(new C2136pa(this, intent));
                return;
            } else {
                d(intent);
                return;
            }
        }
        if (!action.equals(NotificationData.ACTION_NOTIFICATION) && !action.equals("android.intent.action.VIEW")) {
            if (action.equals("com.nexstreaming.app.kinemasterfree.wechat.share.timeline.completed")) {
                com.nexstreaming.kinemaster.ui.a.e eVar = new com.nexstreaming.kinemaster.ui.a.e(this);
                eVar.setTitle(R.string.wechat_share_event_completed_title);
                eVar.e(R.string.wechat_share_event_completed_message);
                eVar.c(getString(R.string.wechat_share_event_popup_close), new DialogInterfaceOnClickListenerC2141sa(this));
                eVar.setOnCancelListener(new DialogInterfaceOnCancelListenerC2143ta(this));
                eVar.show();
                return;
            }
            return;
        }
        if (intent.hasExtra("weblink")) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(intent.getStringExtra("weblink"))));
            return;
        }
        Uri data = intent.getData();
        if (data != null) {
            if (EditorGlobal.p) {
                Crashlytics.log("[PG] intent uri:" + data.toString());
            }
            if (data.getScheme() != null) {
                if (C1704h.b(data)) {
                    Class<? extends Activity> a2 = C1704h.a(intent.getData());
                    if (a2 != null) {
                        if (a2.equals(ProjectEditActivity.class)) {
                            String string = EditorGlobal.t() ? "Demo Project" : getResources().getString(R.string.default_project_name);
                            int i = 0;
                            while (true) {
                                if (i >= 10000) {
                                    file = null;
                                    break;
                                }
                                String absolutePath = EditorGlobal.o().getAbsolutePath();
                                StringBuilder sb = new StringBuilder();
                                sb.append(string);
                                String str2 = "";
                                if (i > 0) {
                                    str = " " + i;
                                } else {
                                    str = "";
                                }
                                sb.append(str);
                                sb.append(VideoEditor.u());
                                file = new File(absolutePath, sb.toString());
                                String absolutePath2 = EditorGlobal.o().getAbsolutePath();
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(string);
                                if (i > 0) {
                                    str2 = " " + i;
                                }
                                sb2.append(str2);
                                sb2.append(".nexvideoproject");
                                File file2 = new File(absolutePath2, sb2.toString());
                                if (!file.exists() && !file2.exists()) {
                                    break;
                                } else {
                                    i++;
                                }
                            }
                            if (file != null) {
                                intent.setData(Uri.fromFile(file));
                            }
                            ha();
                        }
                        intent.setClass(this, a2);
                        intent.setFlags(67108864);
                        startActivityForResult(intent, 8212);
                        overridePendingTransition(0, 0);
                        setIntent(null);
                        return;
                    }
                    return;
                }
                if (data.getScheme().equals("appupdate")) {
                    String packageName = getPackageName();
                    try {
                        intent2 = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName));
                    } catch (ActivityNotFoundException unused) {
                        intent2 = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + packageName));
                    }
                    startActivity(intent2);
                    return;
                }
                if (data.getScheme().equals("http") || data.getScheme().equals("https")) {
                    startActivity(new Intent("android.intent.action.VIEW", intent.getData()));
                }
            }
        }
    }

    private void d(String str) {
        KMCloud kMCloud = this.Da;
        if (kMCloud != null && kMCloud.b() != KMCloud.KMCloudState.KM_CLOUD_STATE_LOGGED_OUT) {
            this.Da.d();
        }
        if (str.equals("Google Drive")) {
            this.Da.c();
        } else if (str.equals("Adobe Creative Cloud")) {
            this.Da = new com.nexstreaming.kinemaster.integration.cloud.p(this, this.Ja);
            this.Da.c();
        }
    }

    public /* synthetic */ void b(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.N = true;
        fa();
    }

    private boolean b(com.nexstreaming.kinemaster.project.k kVar) {
        File file;
        String str;
        String u = VideoEditor.u();
        String string = getResources().getString(R.string.project_copy_name);
        String name = kVar.e().getName();
        if (name.endsWith(".nexvideoproject") || !name.endsWith(u)) {
            return false;
        }
        String substring = name.substring(0, name.length() - u.length());
        int i = 0;
        while (true) {
            if (i >= 10000) {
                file = null;
                break;
            }
            String absolutePath = EditorGlobal.o().getAbsolutePath();
            StringBuilder sb = new StringBuilder();
            sb.append(substring);
            sb.append(" ");
            sb.append(string);
            String str2 = "";
            if (i > 0) {
                str = " " + i;
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(u);
            file = new File(absolutePath, sb.toString());
            String absolutePath2 = EditorGlobal.o().getAbsolutePath();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(substring);
            sb2.append(" ");
            sb2.append(string);
            if (i > 0) {
                str2 = " " + i;
            }
            sb2.append(str2);
            sb2.append(".nexvideoproject");
            File file2 = new File(absolutePath2, sb2.toString());
            if (!file.exists() && !file2.exists()) {
                break;
            }
            i++;
        }
        if (file == null) {
            return false;
        }
        return a(kVar.e(), file);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Intent intent) {
        intent.setClass(this, ProjectEditActivity.class);
        intent.setFlags(67108864);
        startActivityForResult(intent, 8212);
        overridePendingTransition(0, 0);
        setIntent(null);
    }

    public /* synthetic */ void a(View view) {
        e.a aVar = new e.a(this);
        aVar.e(R.string.project_gallery_duplicate_project);
        aVar.c(R.string.project_gallery_duplicate_project_popup);
        aVar.b(this.va.f());
        aVar.c(R.string.button_ok, new DialogInterface.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.projectgallery.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ProjectGalleryActivity.this.d(dialogInterface, i);
            }
        });
        aVar.a(R.string.button_cancel, new DialogInterface.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.projectgallery.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        aVar.a().show();
    }

    public /* synthetic */ void d(int i) {
        if (i == -1) {
            K();
        } else {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NexTimeline nexTimeline, String str) {
        this.Ea.clear();
        c.d.b.d.b.a.a aVar = new c.d.b.d.b.a.a(this);
        aVar.a(this.va.f());
        aVar.a(nexTimeline);
        aVar.a(1280, 720, 30);
        ArrayList<String> a2 = aVar.a();
        if (a2 != null && a2.size() > 0) {
            this.Ea.addAll(a2);
        }
        c.d.b.d.a.a.b bVar = new c.d.b.d.a.a.b(this);
        bVar.a(this.va.f());
        bVar.a(nexTimeline);
        bVar.a(1280, 720, 30);
        ArrayList<String> a3 = bVar.a();
        if (a3 != null && a3.size() > 0) {
            Iterator<String> it = a3.iterator();
            while (it.hasNext()) {
                String next = it.next();
                Log.i("XML", "[FCPXML] Output : " + next);
                if (!this.Ea.contains(next)) {
                    this.Ea.add(next);
                }
            }
        }
        if (this.Ea.size() > 0) {
            d(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(File file) {
        File file2;
        String str;
        String u = VideoEditor.u();
        String string = getResources().getString(R.string.project_copy_name);
        String name = file.getName();
        if (name.endsWith(".nexvideoproject") || !name.endsWith(u)) {
            return false;
        }
        String substring = name.substring(0, name.length() - u.length());
        int i = 0;
        while (true) {
            if (i >= 10000) {
                file2 = null;
                break;
            }
            String absolutePath = EditorGlobal.o().getAbsolutePath();
            StringBuilder sb = new StringBuilder();
            sb.append(substring);
            sb.append(" ");
            sb.append(string);
            String str2 = "";
            if (i > 0) {
                str = " " + i;
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(u);
            file2 = new File(absolutePath, sb.toString());
            String absolutePath2 = EditorGlobal.o().getAbsolutePath();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(substring);
            sb2.append(" ");
            sb2.append(string);
            if (i > 0) {
                str2 = " " + i;
            }
            sb2.append(str2);
            sb2.append(".nexvideoproject");
            File file3 = new File(absolutePath2, sb2.toString());
            if (!file2.exists() && !file3.exists()) {
                break;
            }
            i++;
        }
        if (file2 == null) {
            return false;
        }
        return a(file, file2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.nexstreaming.kinemaster.project.k kVar, String str) {
        this.Ba.a(kVar.e(), y().e(), false).onComplete(new Ka(this, kVar)).onCancel(new Ja(this)).onFailure(new Ia(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadingTask loadingTask) {
        if (this.M) {
            Log.i("START_FLOW", "ProjectGalleryActivity:completedLoadingTask(" + loadingTask.name() + ")");
            this.xa.add(loadingTask);
            for (LoadingTask loadingTask2 : LoadingTask.values()) {
                if (!this.xa.contains(loadingTask2)) {
                    return;
                }
            }
            this.M = false;
            ca();
        }
    }

    public /* synthetic */ void c(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        finish();
    }

    public /* synthetic */ void a(DialogInterface dialogInterface) {
        this.N = true;
    }

    private com.nexstreaming.kinemaster.ui.a.e a(String[] strArr) {
        if (this.Ha == null) {
            this.Ha = com.nexstreaming.kinemaster.ui.e.b.a(this, strArr, new DialogInterface.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.projectgallery.g
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    ProjectGalleryActivity.this.b(dialogInterface, i);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.projectgallery.k
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    ProjectGalleryActivity.this.a(dialogInterface, i);
                }
            }).a();
        }
        return this.Ha;
    }

    private boolean c(String str) {
        if (str == null) {
            return false;
        }
        return str.endsWith(".nexvideoproject");
    }

    public /* synthetic */ void a(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NotifyAppResponse notifyAppResponse) {
        for (NotifyAppResponse.Notice notice : notifyAppResponse.notices) {
            if (!com.nexstreaming.app.general.tracelog.r.b(this, notice.idx)) {
                int i = zb.f23013d[notice.getType().ordinal()];
                if (i == 1 || i == 2 || i != 3) {
                    return;
                }
                int i2 = notice.idx;
                this.Na = -1;
                e.a aVar = new e.a(this);
                aVar.g(R.layout.project_gallery_notifyapp_popup);
                aVar.c(R.string.button_ok, new DialogInterfaceOnClickListenerC2113gb(this, i2));
                com.nexstreaming.kinemaster.ui.a.e a2 = aVar.a();
                a2.show();
                WebView webView = (WebView) a2.findViewById(R.id.webview);
                webView.setBackgroundColor(16777216);
                webView.setWebViewClient(new C2116hb(this, i2, a2));
                webView.loadUrl(notice.notice);
                return;
            }
        }
    }

    private void a(String str, File file) {
        if (file.getAbsolutePath().getBytes().length > 200) {
            Toast.makeText(this, R.string.project_rename_fail_too_long, 1).show();
            return;
        }
        if (file.exists()) {
            Toast.makeText(this, R.string.project_rename_fail_name_conflict, 1).show();
            return;
        }
        if (this.va.c(file)) {
            new AsyncTaskC2214da(ExportedVideoDatabase.a(this), this.va.f(), str, (AsyncTaskC2214da.a) null).execute(3);
            this.va.h(str);
            this.fa.setText(this.va.f());
            Log.i("START_FLOW", "ProjectGalleryActivity:renameProjectTo GET/BEGIN");
            com.nexstreaming.kinemaster.project.k.a(this.ya).onResultAvailable(new C2125kb(this, str));
            return;
        }
        Toast.makeText(this, R.string.project_rename_fail_general, 1).show();
    }

    private void a(com.nexstreaming.kinemaster.project.k kVar) {
        VideoEditor videoEditor = new VideoEditor(z(), this, false, null);
        videoEditor.a(kVar.e()).onComplete(new mb(this, videoEditor, kVar));
    }

    private boolean a(File file, File file2) {
        Throwable th;
        FileChannel fileChannel;
        if (file.getName().endsWith(".nexvideoproject") || file2.exists()) {
            return false;
        }
        FileChannel fileChannel2 = null;
        try {
            fileChannel = new FileInputStream(file).getChannel();
            try {
                fileChannel2 = new FileOutputStream(file2).getChannel();
                long size = fileChannel.size();
                long j = 0;
                while (size > 0) {
                    long transferTo = fileChannel.transferTo(j, size, fileChannel2);
                    size -= transferTo;
                    j += transferTo;
                }
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                if (fileChannel2 == null) {
                    return true;
                }
                try {
                    fileChannel2.close();
                    return true;
                } catch (IOException e3) {
                    e3.printStackTrace();
                    return true;
                }
            } catch (IOException unused) {
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                if (fileChannel2 != null) {
                    try {
                        fileChannel2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                if (fileChannel2 != null) {
                    try {
                        fileChannel2.close();
                        throw th;
                    } catch (IOException e7) {
                        e7.printStackTrace();
                        throw th;
                    }
                }
                throw th;
            }
        } catch (IOException unused2) {
            fileChannel = null;
        } catch (Throwable th3) {
            th = th3;
            fileChannel = null;
        }
    }

    @Override // c.d.b.b.d.a
    public void a(c.d.b.b.d dVar, c.d.b.b.a.e eVar) {
        Eb eb;
        Log.i("ProjectGalleryActivity", "onUserChanged!!! user : " + eVar);
        if (C() && (eb = this.ua) != null) {
            eb.a((FrameLayout) null);
        }
        if (eVar != null) {
            com.nexstreaming.kinemaster.ui.gdpr.l.a(this);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectgallery.Eb.b
    public void a(View view, int i) {
        if (this.K) {
            return;
        }
        Runnable runnable = this.wa;
        if (runnable != null) {
            this.sa.removeCallbacks(runnable);
            this.wa = null;
            a(this.ua.getItem(i), "double_tap");
        } else {
            com.nexstreaming.kinemaster.project.k item = this.ua.getItem(i);
            if (item != null) {
                this.fa.setText(item.f());
                this.wa = new sb(this, view, i);
                this.sa.postDelayed(this.wa, 200L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        if (J != bitmap) {
            J = bitmap;
            I++;
        }
        return I;
    }
}
