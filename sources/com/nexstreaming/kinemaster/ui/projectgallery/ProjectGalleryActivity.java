package com.nexstreaming.kinemaster.ui.projectgallery;

import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.internal.NativeProtocol;
import com.google.gson.Gson;
import com.nexstreaming.app.general.service.notification.NotificationData;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.tracelog.NotifyAppResponse;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.intent.KMIntentData;
import com.nexstreaming.kinemaster.kmpackage.EffectLibrary;
import com.nexstreaming.kinemaster.tracelog.KMAppUsage;
import com.nexstreaming.kinemaster.ui.a.a;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nexstreaming.kinemaster.ui.projectedit.FullScreenInputActivity;
import com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity;
import com.nexstreaming.kinemaster.ui.share.aq;
import com.nexstreaming.kinemaster.ui.widget.ImageCyclerView;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.a.a.c;
import com.nextreaming.nexeditorui.BailActivity;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.ExpiredActivity;
import com.nextreaming.nexeditorui.KineMasterApplication;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import com.nextreaming.nexeditorui.newproject.NewProjectActivity;
import com.nextreaming.nexvideoeditor.NexEditor;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.channels.FileChannel;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ProjectGalleryActivity extends com.nextreaming.nexeditorui.ba implements aq.a {
    private static Bitmap P;
    private static int Q = 1;
    private SortingMode E;
    private long F;
    private View K;
    private View L;
    private TextView M;
    private ImageView N;
    private View O;
    private boolean b;
    private boolean c;
    private GridView e;
    private View f;
    private x g;
    private View h;
    private View i;
    private View j;
    private ImageCyclerView k;
    private View[] l;
    private View m;
    private ImageView n;
    private View p;
    private com.nexstreaming.kinemaster.project.f q;
    private View r;
    private View s;
    private View t;
    private float u;
    private float v;
    private float w;
    private float x;
    private boolean y;
    private Runnable z;
    private int[] o = new int[2];
    private boolean A = false;
    private boolean B = false;
    private boolean C = false;
    private EnumSet<LoadingTask> D = EnumSet.noneOf(LoadingTask.class);
    private boolean G = false;
    private boolean H = false;
    private com.nexstreaming.kinemaster.ui.a.e I = null;
    private WeakReference<com.nexstreaming.kinemaster.ui.a.a> J = null;
    private Runnable R = new bp(this);

    /* renamed from: a */
    int f4123a = -1;

    /* loaded from: classes.dex */
    public enum DeviceSupportChange {
        FirstTimeLimited,
        Increase,
        Decrease,
        Change,
        NoChange
    }

    /* loaded from: classes.dex */
    public enum LoadingTask {
        ProjectList,
        DeviceCompatibilityDBCheck
    }

    public static int b(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        if (P != bitmap) {
            P = bitmap;
            Q++;
        }
        return Q;
    }

    public static Bitmap a(int i) {
        if (i == 0 || Q != i) {
            return null;
        }
        return P;
    }

    /* loaded from: classes.dex */
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

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i("ProjectGalleryActivity", "onNewIntent() called with: intent = [" + intent + "]");
        a(intent);
    }

    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isTaskRoot() && com.nexstreaming.kinemaster.ui.share.k.a().b()) {
            finish();
            return;
        }
        if (!ExpiredActivity.a(this, false)) {
            this.A = true;
            setContentView(R.layout.project_gallery);
            this.g = new x();
            this.g.a(this, getFragmentManager(), new c.a(this, (File) null));
            this.e = (GridView) findViewById(R.id.projectList);
            this.f = findViewById(R.id.projectListHolder);
            this.h = findViewById(R.id.foregroundLayout);
            this.i = findViewById(R.id.projectDetails);
            this.j = findViewById(R.id.projectDetailsThumbHolder);
            this.m = findViewById(R.id.projectDetailsNonthumb);
            this.n = (ImageView) findViewById(R.id.projectDetailsThumb);
            this.p = findViewById(R.id.editProject);
            this.r = findViewById(R.id.addProject);
            this.s = findViewById(R.id.skip);
            this.t = findViewById(R.id.getStarted);
            this.K = findViewById(R.id.tipAndOverlayGHolder);
            this.L = findViewById(R.id.tipHolder);
            this.M = (TextView) findViewById(R.id.tipText);
            this.N = (ImageView) findViewById(R.id.tipIcon);
            this.O = findViewById(R.id.tipLinkIcon);
            this.e.setAdapter((ListAdapter) this.g);
            this.e.setVisibility(8);
            this.f.setVisibility(8);
            this.e.addOnLayoutChangeListener(new z(this));
            this.h.setVisibility(4);
            this.k = (ImageCyclerView) findViewById(R.id.imageCycler);
            this.t.setOnClickListener(new av(this));
            this.s.setOnClickListener(new bj(this));
            findViewById(R.id.settingsButton).setOnClickListener(new bz(this));
            findViewById(R.id.helpButton).setOnClickListener(new cn(this));
            findViewById(R.id.supportButton).setOnClickListener(new ct(this));
            this.l = new View[]{findViewById(R.id.overlay_a), findViewById(R.id.overlay_b), findViewById(R.id.overlay_c), findViewById(R.id.overlay_d), findViewById(R.id.overlay_e), findViewById(R.id.overlay_f), findViewById(R.id.overlay_g)};
            for (View view : this.l) {
                view.setVisibility("np".equals(view.getTag()) ? 8 : 4);
                view.setOnClickListener(new cu(this));
            }
            this.E = SortingMode.fromString(PreferenceManager.getDefaultSharedPreferences(this).getString("sorting_project", "edit"));
            q();
            this.r.setOnClickListener(new cv(this));
            this.p.setOnClickListener(new cw(this));
            i();
            this.e.setOnItemClickListener(new ab(this));
            ((TextView) findViewById(R.id.projectDetailsTitle)).setOnTouchListener(new ae(this));
            findViewById(R.id.projectPreviewPlay).setOnClickListener(new af(this));
            findViewById(R.id.projectShare).setOnClickListener(new ag(this));
            findViewById(R.id.projectDelete).setOnClickListener(new ah(this));
            findViewById(R.id.projectOverflow).setVisibility(0);
            findViewById(R.id.projectOverflow).setOnClickListener(new am(this));
            if (EditorGlobal.f == EditorGlobal.VersionType.RC) {
                f();
            }
            h();
            I();
            e();
        }
    }

    private void e() {
        String action = getIntent().getAction();
        if (action != null) {
            String str = "App Icon";
            String str2 = "Normal";
            if (!action.equals("android.intent.action.MAIN")) {
                if (action.equals(KMIntentData.ACTION_KINEMASTER_NEW_PROJECT_INTENT)) {
                    str = getIntent().getBooleanExtra(KMIntentData.KEY_FROM_SDK, false) ? "SDK" : "Share";
                } else if (action.equals(NotificationData.ACTION_NOTIFICATION)) {
                    str = "Push Notification";
                }
            }
            Log.d("ProjectGalleryActivity", "checkMPOpenEvent() called with: " + action);
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            if (defaultSharedPreferences.getBoolean("first_open", true)) {
                str2 = "First";
                defaultSharedPreferences.edit().putBoolean("first_open", false).apply();
            }
            a(str, str2);
        }
    }

    private void a(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Origination", str);
            jSONObject.put("Type", str2);
            KMUsage.getMixpanelInstance(this).a("App Open", jSONObject);
            Log.i("ProjectGalleryActivity", "MP openEvent - " + str + " : " + str2);
        } catch (Exception e) {
            Log.e("ProjectGalleryActivity", "MP openEvent - " + e.toString());
        }
    }

    public void a(Intent intent) {
        String action;
        if (intent != null && (action = intent.getAction()) != null) {
            if (action.equals(KMIntentData.ACTION_KINEMASTER_NEW_PROJECT_INTENT)) {
                this.B = true;
                String stringExtra = intent.getStringExtra(KMIntentData.KEY_KINEMASTER_INTENT_PROJET_DATA);
                if (stringExtra != null) {
                    new com.nexstreaming.kinemaster.ui.projectgallery.a(this, (KMIntentData) new Gson().fromJson(stringExtra, KMIntentData.class)).b().onComplete(new at(this, intent)).onCancel(new as(this)).onFailure(new ar(this, intent));
                    return;
                } else {
                    KMUsage.ProjectList_EditProject.logEvent(NativeProtocol.WEB_DIALOG_ACTION, "Shared KM Intent");
                    b(intent);
                    return;
                }
            }
            if (action.equals(NotificationData.ACTION_NOTIFICATION)) {
                Class<? extends Activity> a2 = com.nexstreaming.app.general.util.d.a(intent.getData());
                if (a2 != null) {
                    intent.setClass(this, a2);
                    intent.setFlags(67108864);
                    startActivityForResult(intent, R.id.create_project_by_external_intent);
                    overridePendingTransition(0, 0);
                    setIntent(null);
                    return;
                }
                return;
            }
            if (action.equals("com.nexstreaming.app.kinemasterfree.wechat.share.timeline.completed")) {
                com.nexstreaming.kinemaster.ui.a.a aVar = new com.nexstreaming.kinemaster.ui.a.a(this);
                aVar.setTitle(R.string.wechat_share_event_completed_title);
                aVar.c(R.string.wechat_share_event_completed_message);
                aVar.a(getString(R.string.wechat_share_event_popup_close), new au(this));
                aVar.setOnCancelListener(new aw(this));
                aVar.show();
            }
        }
    }

    public void b(Intent intent) {
        intent.setClass(this, ProjectEditActivity.class);
        intent.setFlags(67108864);
        startActivityForResult(intent, R.id.create_project_by_external_intent);
        overridePendingTransition(0, 0);
        setIntent(null);
    }

    private void f() {
        int i = 0;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean z = defaultSharedPreferences.getBoolean("rate_neverShowReviewPopup", false);
        int i2 = defaultSharedPreferences.getInt("rate_export_success_count", 0);
        long j = defaultSharedPreferences.getLong("rate_nextShowPopupDate", 0L);
        boolean z2 = j > 0 ? new Date().getTime() > j : false;
        File e = EditorGlobal.e(this);
        if (e.exists() && e.listFiles() != null) {
            i = e.listFiles().length;
        }
        if (!z && z2) {
            g();
        } else if (!z && i >= 2 && i2 >= 2 && j == 0) {
            new a.C0074a(D()).a(R.string.rate_like_km_popup_msg).a(new bc(this, defaultSharedPreferences)).b(R.string.button_no, new ay(this, defaultSharedPreferences)).a(R.string.button_review_yes, new ax(this)).a().show();
        }
    }

    public void g() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        new a.C0074a(D()).f(R.string.rate_review_popup_title).a(R.string.rate_review_popup_msg).a(new bg(this, defaultSharedPreferences)).c(R.string.button_never_show, new bf(this, defaultSharedPreferences)).b(R.string.button_remind_me_later, new be(this, defaultSharedPreferences)).a(R.string.button_rate, new bd(this, defaultSharedPreferences)).a().show();
    }

    public void a(com.nexstreaming.kinemaster.project.f fVar, String str) {
        com.nexstreaming.kinemaster.ui.projectgallery.a aVar = new com.nexstreaming.kinemaster.ui.projectgallery.a(this, fVar.a());
        aVar.b().onComplete(new bi(this, str, aVar, fVar)).onCancel(new bh(this));
    }

    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onStart() {
        KMUsage.Activity_ProjectList.begin();
        if (this.L != null && this.R != null) {
            if (this.J != null) {
                if (this.J.get() == null) {
                    this.L.post(this.R);
                }
            } else {
                this.L.post(this.R);
            }
        }
        super.onStart();
    }

    private void h() {
        String str;
        if (EditorGlobal.f == EditorGlobal.VersionType.RC || EditorGlobal.f == EditorGlobal.VersionType.Release) {
            return;
        }
        if (EditorGlobal.f != EditorGlobal.VersionType.Beta || EditorGlobal.l() == null) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            if (8291 != defaultSharedPreferences.getInt("km_versionWarningVer", 0)) {
                switch (EditorGlobal.f) {
                    case Alpha:
                        str = "WARNING! This is an ALPHA version.";
                        break;
                    case Beta:
                        str = "WARNING! This is a BETA version.";
                        break;
                    case Dev:
                        str = "WARNING! This is a DEVELOPER version.";
                        break;
                    case ShowDemo:
                        str = "WARNING! This version is for TRADESHOW DEMO use only.";
                        break;
                    default:
                        str = "WARNING! This is a TEST version.";
                        break;
                }
                new a.C0074a(D()).a(str + "\nNot for release or distribution!").b("Version: " + com.nexstreaming.app.general.util.z.e(this)).a(R.string.button_ok, new bk(this, defaultSharedPreferences)).a().show();
            }
        }
    }

    private void i() {
        int a2 = com.nextreaming.nexeditorui.av.a().a(5000);
        if (com.nextreaming.nexeditorui.av.a().b(false)) {
            a(LoadingTask.DeviceCompatibilityDBCheck);
        } else {
            com.nexstreaming.kinemaster.tracelog.d.d(this).setTimeout(a2).onResultAvailable(new bm(this)).onFailure((Task.OnFailListener) new bl(this));
        }
    }

    public void a(LoadingTask loadingTask) {
        if (this.A) {
            this.D.add(loadingTask);
            for (LoadingTask loadingTask2 : LoadingTask.values()) {
                if (!this.D.contains(loadingTask2)) {
                    return;
                }
            }
            this.A = false;
            l();
        }
    }

    private void j() {
        NexEditor.EditorInitException g = KineMasterApplication.a().g();
        if (g != null) {
            Log.i("ProjectGalleryActivity", "bail: initException", g);
            if (g.hasErrorCode) {
                BailActivity.a(this, R.string.bail_init_fail, BailActivity.ReasonCode.InitFail, g.errorCode);
                return;
            } else {
                BailActivity.a(this, R.string.bail_init_fail, BailActivity.ReasonCode.InitFail);
                return;
            }
        }
        UnsatisfiedLinkError f = KineMasterApplication.a().f();
        if (f != null) {
            Log.i("ProjectGalleryActivity", "bail: linkException", f);
            BailActivity.a(this, R.string.bail_bad_install, BailActivity.ReasonCode.LinkFail);
        }
    }

    private void k() {
        String str;
        if (!NexEditorDeviceProfile.getDeviceProfile().getIsDeviceSupported()) {
            Log.i("ProjectGalleryActivity", "bail: isDeviceSupported returned false : ac=" + NexEditorDeviceProfile.getDeviceProfile().getAudioCodecMaxCount() + " avc/mpv4=" + NexEditorDeviceProfile.getDeviceProfile().getAVCSupported() + "/" + NexEditorDeviceProfile.getDeviceProfile().getMPEGV4Supported());
            int supportIfUpgradeVersion = NexEditorDeviceProfile.getDeviceProfile().getSupportIfUpgradeVersion();
            if (supportIfUpgradeVersion > 0) {
                switch (supportIfUpgradeVersion) {
                    case 16:
                        str = "4.1.2";
                        break;
                    case 17:
                        str = "4.2";
                        break;
                    case 18:
                        str = "4.3";
                        break;
                    case 19:
                        str = "4.4";
                        break;
                    case 20:
                        str = "5.0";
                        break;
                    case 21:
                        str = "5.0";
                        break;
                    case 22:
                        str = "5.0";
                        break;
                    case 23:
                        str = "5.0";
                        break;
                    default:
                        str = "5.0";
                        break;
                }
                BailActivity.a(this, getResources().getString(R.string.device_nosupport_android_version_ins, str), BailActivity.ReasonCode.NeedUpgrade, NexEditorDeviceProfile.getDeviceProfile().getDeviceNotSupportedReason().getCode());
                return;
            }
            BailActivity.a(this, R.string.device_support_none, NexEditorDeviceProfile.getDeviceProfile().getDeviceNotSupportedReason());
            return;
        }
        NexEditor E = E();
        if (E != null && NexEditorDeviceProfile.getDeviceProfile().getSupportedExportProfiles(E.i()).length < 1) {
            BailActivity.a(this, R.string.device_support_none, BailActivity.ReasonCode.NoExportProfiles);
        }
        int max = Math.max(getResources().getConfiguration().screenWidthDp, getResources().getConfiguration().screenHeightDp);
        if (max < 460) {
            Log.i("ProjectGalleryActivity", "bail: screenWidthDp : " + getResources().getConfiguration().screenWidthDp);
            BailActivity.a(this, R.string.device_support_none, BailActivity.ReasonCode.ScreenTooSmall, max);
        } else if (Build.VERSION.SDK_INT < 16) {
            Log.i("ProjectGalleryActivity", "bail: SDK_INT : " + Build.VERSION.SDK_INT);
            BailActivity.a(this, R.string.device_nosupport_android_version, BailActivity.ReasonCode.SDKIntTooSmall, Build.VERSION.SDK_INT);
        } else if (Build.VERSION.SDK_INT == 16 && !Build.VERSION.RELEASE.contains("4.1.2")) {
            Log.i("ProjectGalleryActivity", "bail: osver : " + Build.VERSION.RELEASE);
            BailActivity.a(this, R.string.device_nosupport_android_version, BailActivity.ReasonCode.OSVersionTooLow);
        }
    }

    private void l() {
        int i;
        E();
        j();
        if (!isFinishing()) {
            k();
            if (!isFinishing()) {
                s();
                m();
                if (KineMasterApplication.a().c().a().isRunning()) {
                    this.h.postDelayed(new bn(this), 500L);
                } else {
                    a(getIntent());
                }
                List<com.nexstreaming.kinemaster.project.f> a2 = this.g.a();
                Date date = null;
                int i2 = 0;
                int i3 = 0;
                while (i2 < a2.size()) {
                    Date c = a2.get(i2).c();
                    if (c == null) {
                        c = date;
                        i = i3;
                    } else if (date == null || c.after(date)) {
                        i = i2;
                    } else {
                        c = date;
                        i = i3;
                    }
                    i2++;
                    i3 = i;
                    date = c;
                }
                r();
                this.h.setVisibility(0);
                this.h.setAlpha(0.0f);
                this.h.animate().setStartDelay(0L).alpha(1.0f).setDuration(600L);
                this.e.post(new bo(this, i3));
                ExpiredActivity.a(this, true);
            }
        }
    }

    private void m() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        com.nexstreaming.kinemaster.tracelog.d.a(this, A().F());
        EffectLibrary.a(D()).a(true);
        n();
        if (defaultSharedPreferences.getBoolean("report_anon_usage", false) || !EditorGlobal.h) {
            KMAppUsage.a(this).a();
        }
    }

    private void n() {
        a aVar = new a(this);
        com.nexstreaming.kinemaster.tracelog.d.b(this).onResultAvailable(aVar).onFailure((Task.OnFailListener) aVar);
    }

    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onBackPressed() {
        if (!getFragmentManager().popBackStackImmediate()) {
            if (this.c) {
                b(false);
                return;
            }
            if (this.b) {
                KMUsage.ProjectList_ProjectDetails.end();
                this.b = false;
                this.q = null;
                ObjectAnimator.ofObject(this.k, "blur", new FloatEvaluator(), 1, 0).setDuration(500L).start();
                this.h.setAlpha(0.0f);
                this.p.animate().setStartDelay(0L).alpha(0.0f).setDuration(100L);
                this.j.animate().setStartDelay(75L).translationX(this.u).translationY(this.v).scaleX(this.w).scaleY(this.x).setDuration(300L);
                this.m.animate().setStartDelay(0L).alpha(0.0f).setDuration(410L).withEndAction(new bv(this));
                this.h.setVisibility(0);
                this.h.animate().setStartDelay(150L).alpha(1.0f).setDuration(258L);
                return;
            }
            super.onBackPressed();
        }
    }

    public void o() {
        this.y = true;
    }

    public void p() {
        this.y = false;
        if (this.c) {
            this.c = false;
            View findViewById = findViewById(R.id.addProjectPlus);
            View findViewById2 = findViewById(R.id.addProjectSel);
            findViewById.setRotation(0.0f);
            findViewById2.setVisibility(8);
            this.s.setVisibility(8);
            this.t.setVisibility(8);
            for (View view : this.l) {
                view.setVisibility("np".equals(view.getTag()) ? 8 : 4);
            }
        }
        if (this.b) {
            KMUsage.ProjectList_ProjectDetails.end();
            this.b = false;
            this.q = null;
            this.h.setVisibility(0);
            this.i.setVisibility(4);
            this.h.setAlpha(1.0f);
            this.k.setBlur(0.0f);
        }
    }

    public void b(boolean z) {
        if (z != this.c) {
            this.c = z;
            View findViewById = findViewById(R.id.addProjectPlus);
            View findViewById2 = findViewById(R.id.addProjectSel);
            findViewById.setPivotX(findViewById.getWidth() / 2);
            findViewById.setPivotY(findViewById.getHeight() * 0.55f);
            int size = this.g.a().size();
            if (z) {
                findViewById2.setVisibility(0);
                this.s.setVisibility(0);
                this.t.setVisibility(0);
                findViewById2.setAlpha(0.0f);
                this.s.setAlpha(0.0f);
                this.t.setAlpha(0.0f);
                this.t.setRotation(45.0f);
                this.s.setRotation(50.0f);
                findViewById.animate().rotation(-45.0f).setDuration(400L);
                findViewById2.animate().alpha(1.0f).setDuration(400L).setListener(new bw(this));
                this.t.animate().rotation(0.0f).alpha(1.0f).setDuration(270L);
                this.s.animate().setStartDelay(150L).rotation(0.0f).alpha(1.0f).setDuration(350L);
                for (View view : this.l) {
                    if ("np".equals(view.getTag()) && size > 0) {
                        view.setVisibility(8);
                    } else {
                        view.setVisibility(0);
                        view.setAlpha(0.0f);
                        view.animate().alpha(1.0f).setDuration(300L);
                    }
                }
                return;
            }
            findViewById.animate().rotation(0.0f).setDuration(400L);
            findViewById2.animate().alpha(0.0f).setDuration(400L).setListener(new bx(this, findViewById2, size));
            this.t.animate().setStartDelay(150L).rotation(45.0f).alpha(0.0f).setDuration(350L);
            this.s.animate().rotation(50.0f).alpha(0.0f).setDuration(270L);
            for (View view2 : this.l) {
                if ("np".equals(view2.getTag()) && size > 0) {
                    view2.setVisibility(8);
                } else {
                    view2.animate().setStartDelay(70L).alpha(0.0f).setDuration(300L);
                }
            }
        }
    }

    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onDestroy() {
        if (this.g != null) {
            this.g.b();
            this.g = null;
        }
        super.onDestroy();
    }

    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onPause() {
        if (this.L != null && this.R != null) {
            this.L.removeCallbacks(this.R);
        }
        super.onPause();
    }

    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onStop() {
        if (this.b) {
            KMUsage.ProjectList_ProjectDetails.end();
        }
        KMUsage.Activity_ProjectList.end();
        this.k.setAnimationEnabled(false);
        super.onStop();
    }

    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onResume() {
        if (this.C) {
            this.C = false;
            q();
            p();
        }
        super.onResume();
    }

    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onRestart() {
        if (this.y) {
            p();
        }
        this.k.setAnimationEnabled(true);
        if (this.B) {
            this.B = false;
            q();
        }
        SortingMode fromString = SortingMode.fromString(PreferenceManager.getDefaultSharedPreferences(this).getString("sorting_project", "edit"));
        if (this.E != fromString) {
            this.E = fromString;
            q();
        }
        super.onRestart();
    }

    @Override // com.nextreaming.nexeditorui.ba
    public void h_() {
        if (Build.VERSION.SDK_INT >= 23) {
            boolean z = checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0;
            boolean z2 = checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
            if (!z || !z2) {
                return;
            }
        }
        super.h_();
        u();
    }

    @Override // com.nextreaming.nexeditorui.ba
    public void i_() {
        if (Build.VERSION.SDK_INT >= 23) {
            boolean z = checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0;
            boolean z2 = checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
            if (!z || !z2) {
                return;
            }
        }
        super.i_();
    }

    private void q() {
        if (Build.VERSION.SDK_INT >= 23) {
            boolean z = checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0;
            boolean z2 = checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
            if (!z || !z2) {
                boolean shouldShowRequestPermissionRationale = shouldShowRequestPermissionRationale("android.permission.READ_EXTERNAL_STORAGE");
                boolean shouldShowRequestPermissionRationale2 = shouldShowRequestPermissionRationale("android.permission.WRITE_EXTERNAL_STORAGE");
                if (shouldShowRequestPermissionRationale || shouldShowRequestPermissionRationale2) {
                    d(false);
                    return;
                } else {
                    this.F = -1L;
                    this.k.postDelayed(new by(this), 1500L);
                    return;
                }
            }
            h_();
        }
        if (this.E == null) {
            this.E = SortingMode.fromString(PreferenceManager.getDefaultSharedPreferences(this).getString("sorting_project", "edit"));
        }
        com.nexstreaming.kinemaster.project.f.a(this.E).onResultAvailable(new ca(this));
    }

    public void r() {
        if (this.g.a().size() > 0) {
            this.e.setVisibility(0);
            this.f.setVisibility(0);
        } else {
            this.e.setVisibility(8);
            this.f.setVisibility(8);
        }
    }

    /* loaded from: classes.dex */
    public static class a implements ResultTask.OnResultAvailableListener<NotifyAppResponse>, Task.OnFailListener {

        /* renamed from: a */
        private final WeakReference<ProjectGalleryActivity> f4125a;

        public a(ProjectGalleryActivity projectGalleryActivity) {
            this.f4125a = new WeakReference<>(projectGalleryActivity);
        }

        @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
        /* renamed from: a */
        public void onResultAvailable(ResultTask<NotifyAppResponse> resultTask, Task.Event event, NotifyAppResponse notifyAppResponse) {
            ProjectGalleryActivity projectGalleryActivity = this.f4125a.get();
            if (projectGalleryActivity != null) {
                projectGalleryActivity.a(notifyAppResponse);
            }
        }

        @Override // com.nexstreaming.app.general.task.Task.OnFailListener
        public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
            ProjectGalleryActivity projectGalleryActivity = this.f4125a.get();
            if (projectGalleryActivity != null) {
                projectGalleryActivity.a(taskError);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void s() {
        /*
            Method dump skipped, instructions count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.projectgallery.ProjectGalleryActivity.s():void");
    }

    public void a(Task.TaskError taskError) {
    }

    public void a(NotifyAppResponse notifyAppResponse) {
        for (NotifyAppResponse.Notice notice : notifyAppResponse.notices) {
            if (!com.nexstreaming.app.general.tracelog.j.a(D(), notice.idx)) {
                switch (notice.getType()) {
                    case HTML:
                    case Text:
                    default:
                        return;
                    case URL:
                        int i = notice.idx;
                        this.f4123a = -1;
                        com.nexstreaming.kinemaster.ui.a.a a2 = new a.C0074a(this).b(R.layout.project_gallery_notifyapp_popup).a(R.string.button_ok, new cc(this, i)).a();
                        a2.show();
                        WebView webView = (WebView) a2.findViewById(R.id.webview);
                        webView.setBackgroundColor(16777216);
                        webView.setWebViewClient(new cd(this, i, a2));
                        webView.loadUrl(notice.notice);
                        return;
                }
            }
        }
    }

    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == R.id.req_perm_settings || i == R.id.create_project_by_external_intent) {
            q();
            return;
        }
        if (i == FullScreenInputActivity.a()) {
            if (this.q != null) {
                File a2 = FullScreenInputActivity.a(intent);
                String b = FullScreenInputActivity.b(intent);
                if (i2 == 1 && a2 != null && b != null) {
                    a(b, a2);
                    return;
                }
                return;
            }
            return;
        }
        if (intent != null && i == FullScreenInputActivity.b()) {
            File a3 = FullScreenInputActivity.a(intent);
            Intent intent2 = new Intent(this, (Class<?>) NewProjectActivity.class);
            intent2.putExtra("ProjectPath", a3);
            startActivity(intent2);
        }
    }

    private void a(String str, File file) {
        KMUsage.ProjectList_RenameProject.logEvent();
        if (file.getAbsolutePath().getBytes().length > 200) {
            Toast.makeText(this, R.string.project_rename_fail_too_long, 1).show();
            return;
        }
        if (file.exists()) {
            Toast.makeText(this, R.string.project_rename_fail_name_conflict, 1).show();
        } else {
            if (this.q.a(file)) {
                this.q.a(str);
                ((TextView) findViewById(R.id.projectDetailsTitle)).setText(this.q.f());
                com.nexstreaming.kinemaster.project.f.a(this.E).onResultAvailable(new ce(this, str));
                return;
            }
            Toast.makeText(this, R.string.project_rename_fail_general, 1).show();
        }
    }

    public void a(com.nexstreaming.kinemaster.project.f fVar) {
        VideoEditor videoEditor = new VideoEditor(E(), this, false, null);
        videoEditor.b(fVar.a()).onComplete(new ch(this, videoEditor, fVar));
    }

    public boolean a(String str) {
        return str != null && str.endsWith(".nexvideoproject");
    }

    public boolean b(com.nexstreaming.kinemaster.project.f fVar) {
        File file;
        String a2 = VideoEditor.a();
        String string = getResources().getString(R.string.project_copy_name);
        String name = fVar.a().getName();
        if (!name.endsWith(".nexvideoproject") && name.endsWith(a2)) {
            String substring = name.substring(0, name.length() - a2.length());
            int i = 0;
            while (true) {
                if (i >= 10000) {
                    file = null;
                    break;
                }
                File file2 = new File(EditorGlobal.j().getAbsolutePath(), substring + " " + string + (i > 0 ? " " + i : "") + a2);
                File file3 = new File(EditorGlobal.j().getAbsolutePath(), substring + " " + string + (i > 0 ? " " + i : "") + ".nexvideoproject");
                if (!file2.exists() && !file3.exists()) {
                    file = file2;
                    break;
                }
                i++;
            }
            if (file == null) {
                return false;
            }
            return a(fVar.a(), file);
        }
        return false;
    }

    public boolean a(File file) {
        File file2;
        String a2 = VideoEditor.a();
        String string = getResources().getString(R.string.project_copy_name);
        String name = file.getName();
        if (!name.endsWith(".nexvideoproject") && name.endsWith(a2)) {
            String substring = name.substring(0, name.length() - a2.length());
            int i = 0;
            while (true) {
                if (i >= 10000) {
                    file2 = null;
                    break;
                }
                File file3 = new File(EditorGlobal.j().getAbsolutePath(), substring + " " + string + (i > 0 ? " " + i : "") + a2);
                File file4 = new File(EditorGlobal.j().getAbsolutePath(), substring + " " + string + (i > 0 ? " " + i : "") + ".nexvideoproject");
                if (!file3.exists() && !file4.exists()) {
                    file2 = file3;
                    break;
                }
                i++;
            }
            if (file2 == null) {
                return false;
            }
            return a(file, file2);
        }
        return false;
    }

    private boolean a(File file, File file2) {
        FileChannel fileChannel;
        FileChannel fileChannel2 = null;
        if (file.getName().endsWith(".nexvideoproject") || file2.exists()) {
            return false;
        }
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
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fileChannel2 != null) {
                    try {
                        fileChannel2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                return true;
            } catch (IOException e3) {
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                if (fileChannel2 == null) {
                    return false;
                }
                try {
                    fileChannel2.close();
                    return false;
                } catch (IOException e5) {
                    e5.printStackTrace();
                    return false;
                }
            } catch (Throwable th) {
                th = th;
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
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e8) {
            fileChannel = null;
        } catch (Throwable th2) {
            th = th2;
            fileChannel = null;
        }
    }

    public void c(boolean z) {
        if (z) {
            this.q = null;
            com.nexstreaming.kinemaster.project.f.a(this.E).onResultAvailable(new cj(this));
        } else {
            a.C0074a c0074a = new a.C0074a(this);
            c0074a.a(R.string.project_gallery_duplicate_fail_project_popup);
            c0074a.b(R.string.button_ok, new ck(this));
            c0074a.a().show();
        }
    }

    public View b(int i) {
        if (this.e != null) {
            int childCount = this.e.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.e.getChildAt(i2);
                if (this.e.getPositionForView(childAt) == i) {
                    return childAt;
                }
            }
        }
        return null;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        boolean z;
        boolean z2;
        if (i == R.id.reqperms) {
            int min = Math.min(strArr.length, iArr.length);
            int i2 = 0;
            boolean z3 = false;
            boolean z4 = false;
            while (i2 < min) {
                if (strArr[i2].equals("android.permission.READ_EXTERNAL_STORAGE")) {
                    boolean z5 = z3;
                    z2 = iArr[i2] == 0;
                    z = z5;
                } else if (strArr[i2].equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
                    z = iArr[i2] == 0;
                    z2 = z4;
                } else {
                    z = z3;
                    z2 = z4;
                }
                i2++;
                z4 = z2;
                z3 = z;
            }
            if (z4 && z3) {
                if (com.nextreaming.nexeditorui.av.f4530a.exists()) {
                    SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
                    defaultSharedPreferences.edit().remove("apc_sku_date").commit();
                    defaultSharedPreferences.edit().remove("apc_skus").commit();
                    System.exit(0);
                } else {
                    q();
                }
            } else {
                d((System.nanoTime() - this.F) / 1000000 < 190);
            }
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    private void d(boolean z) {
        if (z) {
            findViewById(R.id.permissionRationale).setVisibility(8);
            findViewById(R.id.permissionSettings).setVisibility(0);
            findViewById(R.id.button_permissionSettings).setOnClickListener(new cl(this));
        } else {
            findViewById(R.id.permissionRationale).setVisibility(0);
            findViewById(R.id.permissionSettings).setVisibility(8);
            findViewById(R.id.button_permissionAllow).setOnClickListener(new cm(this));
        }
    }

    public boolean t() {
        return this.b && this.q != null;
    }

    private void u() {
        boolean z = false;
        boolean z2 = PreferenceManager.getDefaultSharedPreferences(this).getBoolean("wx_event", false);
        if (A().f()) {
            if (!A().e()) {
                z = true;
            }
        } else {
            z = com.nexstreaming.kinemaster.tracelog.e.b(this);
        }
        if ((com.nexstreaming.kinemaster.h.a.a() || com.nexstreaming.kinemaster.h.a.b()) && com.nexstreaming.kinemaster.h.a.g(this) <= EditorGlobal.m().getTime() && KMUsage.getWXAPIInstance(this).isWXAppInstalled() && KMUsage.getWXAPIInstance(this).isWXAppSupportAPI() && z && !z2 && !this.G) {
            this.G = true;
            if (this.I != null && this.I.isShowing()) {
                this.I.dismiss();
            }
            getFragmentManager().beginTransaction().add(android.R.id.content, new com.nexstreaming.kinemaster.ui.share.aq(), com.nexstreaming.kinemaster.ui.share.aq.class.getName()).addToBackStack(com.nexstreaming.kinemaster.ui.share.aq.class.getName()).commitAllowingStateLoss();
            KMUsage.Show_WeChat_Promotion.logEvent();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.share.aq.a
    public void c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("Promotion Name", "WeChat_Later");
            KMUsage.getMixpanelPeople(this).a(jSONObject);
            KMUsage.getMixpanelInstanceFromContext(this).a(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        v();
        getFragmentManager().popBackStackImmediate();
    }

    @Override // com.nexstreaming.kinemaster.ui.share.aq.a
    public void d() {
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.n3_icon);
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
        KMUsage.getWXAPIInstance(this).sendReq(req);
        getFragmentManager().popBackStackImmediate();
    }

    public void v() {
        Task a2 = KineMasterApplication.a().c().a();
        if (a2 != null && a2.isRunning()) {
            long currentTimeMillis = System.currentTimeMillis();
            KMUsage.Media_Indexing_Start.logEvent("Activity", "ProjectGalleryActivity");
            if (this.I == null) {
                this.I = new e.a(this).a(false).a(R.string.indexing_media_title).c(R.string.indexing_media_message).a();
                a2.onProgress(new cs(this)).onComplete(new cr(this, currentTimeMillis)).onCancel(new cq(this));
                if (getFragmentManager().getBackStackEntryCount() == 0 && !this.I.isShowing()) {
                    this.I.show();
                    return;
                }
                return;
            }
            if (!this.I.isShowing()) {
                this.I.show();
            }
        }
    }
}
