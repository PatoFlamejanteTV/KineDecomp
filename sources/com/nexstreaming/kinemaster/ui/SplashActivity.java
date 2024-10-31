package com.nexstreaming.kinemaster.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.nexstreaming.app.general.service.notification.NotificationData;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.intent.KMIntentData;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nexstreaming.kinemaster.ui.a.r;
import com.nexstreaming.kinemaster.ui.e.c;
import com.nexstreaming.kinemaster.ui.gdpr.ConfirmFragment;
import com.nexstreaming.kinemaster.ui.projectgallery.ProjectGalleryActivity;
import com.nexstreaming.kinemaster.ui.share.Da;
import com.nexstreaming.kinemaster.ui.welcome.WelcomeActivity;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.I;
import com.nextreaming.nexeditorui.KineMasterApplication;
import com.umeng.analytics.pro.k;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.TypeCastException;
import kotlin.jvm.internal.PropertyReference1Impl;

/* compiled from: SplashActivity.kt */
/* loaded from: classes.dex */
public final class SplashActivity extends I implements Da.b, c.b {
    static final /* synthetic */ kotlin.reflect.g[] H;
    public static final a I;
    private static final String TAG;
    private com.nexstreaming.kinemaster.ui.a.r J;
    private final Handler K = new Handler();
    private final kotlin.d L = kotlin.e.a(new kotlin.jvm.a.a<Locale>() { // from class: com.nexstreaming.kinemaster.ui.SplashActivity$currentLanguage$2
        @Override // kotlin.jvm.a.a
        public final Locale invoke() {
            return Locale.getDefault();
        }
    });
    private com.nexstreaming.kinemaster.ui.a.e M;
    private com.nexstreaming.kinemaster.ui.a.e N;
    private com.nexstreaming.kinemaster.ui.e.c O;
    private HashMap P;

    /* compiled from: SplashActivity.kt */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SplashActivity.kt */
    /* loaded from: classes.dex */
    public static final class b extends AsyncTask<Object, Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<SplashActivity> f21295a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f21296b;

        public b(Context context, boolean z) {
            kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
            this.f21296b = z;
            this.f21295a = new WeakReference<>((SplashActivity) context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r2) {
            super.onPostExecute(r2);
            SplashActivity splashActivity = this.f21295a.get();
            if (this.f21296b) {
                if (splashActivity != null) {
                    splashActivity.P();
                }
            } else if (splashActivity != null) {
                splashActivity.c(splashActivity.getIntent());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Void doInBackground(Object... objArr) {
            kotlin.jvm.internal.h.b(objArr, "objects");
            KineMasterApplication c2 = KineMasterApplication.f24058f.c();
            com.nexstreaming.app.general.nexasset.assetpackage.h e2 = com.nexstreaming.app.general.nexasset.assetpackage.h.e();
            c2.r();
            e2.g();
            e2.c(EditorGlobal.k());
            if (!PreferenceManager.getDefaultSharedPreferences(c2).getBoolean("asset_dev_mode", false)) {
                return null;
            }
            try {
                c2.a(e2.b(EditorGlobal.k()));
                return null;
            } catch (IOException e3) {
                c2.a(e3.getLocalizedMessage());
                return null;
            }
        }

        public /* synthetic */ b(Context context, boolean z, int i, kotlin.jvm.internal.f fVar) {
            this(context, (i & 2) != 0 ? false : z);
        }
    }

    static {
        PropertyReference1Impl propertyReference1Impl = new PropertyReference1Impl(kotlin.jvm.internal.j.a(SplashActivity.class), "currentLanguage", "getCurrentLanguage()Ljava/util/Locale;");
        kotlin.jvm.internal.j.a(propertyReference1Impl);
        H = new kotlin.reflect.g[]{propertyReference1Impl};
        I = new a(null);
        TAG = SplashActivity.class.getSimpleName();
    }

    private final void K() {
        PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("is_subscription_or_promotion", false).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L() {
        List c2;
        String[] strArr = com.nexstreaming.kinemaster.ui.e.b.f21563a;
        kotlin.jvm.internal.h.a((Object) strArr, "PermissionHelper.STORAGE");
        c2 = kotlin.collections.g.c(strArr);
        if (c.d.b.m.e.f3850a.a()) {
            String[] strArr2 = com.nexstreaming.kinemaster.ui.e.b.f21567e;
            kotlin.jvm.internal.h.a((Object) strArr2, "PermissionHelper.PHONE");
            kotlin.collections.i.a(c2, strArr2);
        }
        if (c2 != null) {
            Object[] array = c2.toArray(new String[0]);
            if (array != null) {
                if (!com.nexstreaming.kinemaster.ui.e.b.a((Context) this, (String[]) array) && Build.VERSION.SDK_INT > 23) {
                    Locale N = N();
                    kotlin.jvm.internal.h.a((Object) N, "currentLanguage");
                    if (c.d.b.m.h.a(N)) {
                        if (this.O == null) {
                            c.a aVar = com.nexstreaming.kinemaster.ui.e.c.f21570b;
                            if (c2 != null) {
                                Object[] array2 = c2.toArray(new String[0]);
                                if (array2 != null) {
                                    this.O = aVar.a((String[]) array2);
                                } else {
                                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                                }
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
                            }
                        }
                        com.nexstreaming.kinemaster.ui.e.c cVar = this.O;
                        if (cVar == null) {
                            kotlin.jvm.internal.h.a();
                            throw null;
                        }
                        if (cVar.isVisible()) {
                            return;
                        }
                        com.nexstreaming.kinemaster.ui.e.c cVar2 = this.O;
                        if (cVar2 != null) {
                            cVar2.a(this, this);
                            return;
                        } else {
                            kotlin.jvm.internal.h.a();
                            throw null;
                        }
                    }
                    Locale N2 = N();
                    kotlin.jvm.internal.h.a((Object) N2, "currentLanguage");
                    if (c.d.b.m.h.a(N2)) {
                        return;
                    }
                    if (c2 != null) {
                        Object[] array3 = c2.toArray(new String[0]);
                        if (array3 != null) {
                            String[] c3 = c((String[]) array3);
                            if (!com.nexstreaming.kinemaster.ui.e.b.a((Activity) this, c3)) {
                                b(c3).show();
                                return;
                            } else {
                                com.nexstreaming.kinemaster.ui.e.b.a(this, c3, k.a.v);
                                return;
                            }
                        }
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                    throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
                }
                O();
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
    }

    private final void M() {
        this.K.postDelayed(new com.nexstreaming.kinemaster.ui.b(this), 500L);
    }

    private final Locale N() {
        kotlin.d dVar = this.L;
        kotlin.reflect.g gVar = H[0];
        return (Locale) dVar.getValue();
    }

    private final void O() {
        new Handler().postDelayed(new h(this), 3000L);
        kotlin.jvm.internal.f fVar = null;
        boolean z = false;
        if (KineMasterApplication.f24058f.c().h() != null) {
            com.nexstreaming.kinemaster.mediastore.scanner.e h2 = KineMasterApplication.f24058f.c().h();
            Task a2 = h2 != null ? h2.a() : null;
            if (a2 != null && a2.isRunning()) {
                new b(this, true).execute(new Object[0]);
                return;
            }
        }
        new b(this, z, 2, fVar).execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P() {
        com.nexstreaming.kinemaster.ui.a.r rVar;
        com.nexstreaming.kinemaster.mediastore.scanner.e h2 = KineMasterApplication.f24058f.c().h();
        if (h2 != null) {
            Task a2 = h2.a();
            if (a2 != null && a2.isRunning()) {
                long currentTimeMillis = System.currentTimeMillis();
                KMUsage.Media_Indexing_Start.logEvent("Activity", "SplashActivity");
                com.nexstreaming.kinemaster.ui.a.r rVar2 = this.J;
                if (rVar2 != null) {
                    if (rVar2 != null) {
                        if (rVar2.isShowing() || (rVar = this.J) == null) {
                            return;
                        }
                        rVar.show();
                        return;
                    }
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                r.a aVar = new r.a(this);
                aVar.a(false);
                aVar.b(R.string.indexing_media_title);
                aVar.a(R.string.indexing_media_message);
                this.J = aVar.a();
                a2.onProgress(new m(this)).onComplete(new n(this)).onCancel(new o(this, currentTimeMillis));
                com.nexstreaming.kinemaster.ui.a.r rVar3 = this.J;
                if (rVar3 != null) {
                    rVar3.show();
                    return;
                }
                return;
            }
            c(getIntent());
            return;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    public View c(int i) {
        if (this.P == null) {
            this.P = new HashMap();
        }
        View view = (View) this.P.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.P.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I
    public void j(boolean z) {
        super.j(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String localClassName = getLocalClassName();
        kotlin.jvm.internal.h.a((Object) localClassName, "this.localClassName");
        com.nexstreaming.kinemaster.usage.analytics.b.a(localClassName);
        super.onCreate(bundle);
        setContentView(R.layout.activity_splash);
        if (!c.d.b.c.a.e(this) && c.d.b.c.a.a()) {
            com.nexstreaming.kinemaster.ui.gdpr.g gVar = new com.nexstreaming.kinemaster.ui.gdpr.g();
            gVar.a(new k(this, gVar));
            gVar.show(getFragmentManager(), "GDPR");
        } else {
            c.d.b.c.a.d(getApplicationContext(), c.d.b.c.a.d(getApplicationContext()));
            com.nexstreaming.kinemaster.usage.analytics.a a2 = com.nexstreaming.kinemaster.usage.analytics.a.f23905b.a();
            Context applicationContext = getApplicationContext();
            kotlin.jvm.internal.h.a((Object) applicationContext, "this.applicationContext");
            a2.a(applicationContext, c.d.b.c.a.d(getApplicationContext()));
            K();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        kotlin.jvm.internal.h.b(intent, "intent");
        super.onNewIntent(intent);
        c(intent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        kotlin.jvm.internal.h.b(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        kotlin.jvm.internal.h.b(iArr, "grantResults");
        if (i == 8201) {
            boolean a2 = com.nexstreaming.kinemaster.ui.e.b.a(this, strArr, iArr);
            if (Build.VERSION.SDK_INT < 23) {
                return;
            }
            Locale N = N();
            kotlin.jvm.internal.h.a((Object) N, "currentLanguage");
            if (c.d.b.m.h.a(N)) {
                finish();
            }
            if (a2) {
                O();
            } else if (a2 || com.nexstreaming.kinemaster.ui.e.b.a((Activity) this, strArr)) {
                a(strArr).show();
            } else {
                b(strArr).show();
            }
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        M();
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com.nexstreaming.kinemaster.ui.a.e eVar = this.N;
        if (eVar != null) {
            if (eVar == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            if (eVar.isShowing()) {
                com.nexstreaming.kinemaster.ui.a.e eVar2 = this.N;
                if (eVar2 == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                eVar2.dismiss();
            }
        }
        com.nexstreaming.kinemaster.ui.a.e eVar3 = this.M;
        if (eVar3 != null) {
            if (eVar3 == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            if (eVar3.isShowing()) {
                com.nexstreaming.kinemaster.ui.a.e eVar4 = this.M;
                if (eVar4 == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                eVar4.dismiss();
            }
        }
        super.onStop();
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        kotlin.jvm.internal.h.b(intent, "intent");
        super.startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    private final String[] c(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT < 23) {
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                return (String[]) array;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        for (String str : strArr) {
            if (checkSelfPermission(str) == -1) {
                arrayList.add(str);
            }
        }
        Object[] array2 = arrayList.toArray(new String[0]);
        if (array2 != null) {
            return (String[]) array2;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    private final boolean d(Intent intent) {
        if (intent.getExtras() != null) {
            Bundle extras = intent.getExtras();
            if (extras == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            if (extras.containsKey("google.message_id")) {
                Bundle extras2 = intent.getExtras();
                if (extras2 == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                if (extras2.containsKey(ShareConstants.MEDIA_URI)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final com.nexstreaming.kinemaster.ui.a.e b(String[] strArr) {
        if (this.N == null) {
            e.a a2 = com.nexstreaming.kinemaster.ui.e.b.a(this, strArr, new f(this));
            a2.a(new g(this));
            this.N = a2.a();
        }
        com.nexstreaming.kinemaster.ui.a.e eVar = this.N;
        if (eVar != null) {
            return eVar;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(com.nexstreaming.kinemaster.ui.gdpr.g gVar, boolean z, boolean z2) {
        ConfirmFragment a2 = ConfirmFragment.a(getString(R.string.GDPR_Firebase_uncheck_popup_msg));
        gVar.setCancelable(false);
        a2.a(new l(this, a2, gVar, z, z2));
        a2.show(getFragmentManager(), a2.getClass().getSimpleName());
    }

    public final void c(Intent intent) {
        String action;
        if (intent != null && (action = intent.getAction()) != null && (kotlin.jvm.internal.h.a((Object) action, (Object) KMIntentData.ACTION_KINEMASTER_NEW_PROJECT_INTENT) || kotlin.jvm.internal.h.a((Object) action, (Object) "android.intent.action.SEND") || kotlin.jvm.internal.h.a((Object) action, (Object) "android.intent.action.SEND_MULTIPLE"))) {
            getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new Da()).commitAllowingStateLoss();
        } else {
            a(intent, 603979776);
        }
    }

    private final com.nexstreaming.kinemaster.ui.a.e a(String[] strArr) {
        if (this.M == null) {
            e.a a2 = com.nexstreaming.kinemaster.ui.e.b.a(this, strArr, new c(this, strArr), new d(this));
            a2.a(new e(this));
            this.M = a2.a();
        }
        com.nexstreaming.kinemaster.ui.a.e eVar = this.M;
        if (eVar != null) {
            return eVar;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Intent intent, int i) {
        if (intent == null) {
            intent = new Intent();
        }
        if (d(intent)) {
            Intent intent2 = new Intent(NotificationData.ACTION_NOTIFICATION, Uri.parse(intent.getStringExtra(ShareConstants.MEDIA_URI)));
            if (intent2.hasExtra("weblink")) {
                intent2.putExtra("weblink", intent2.getStringExtra("weblink"));
            }
            intent = intent2;
        }
        if (c.d.b.m.c.c(this)) {
            intent.setClass(this, WelcomeActivity.class);
        } else {
            intent.setClass(this, ProjectGalleryActivity.class);
        }
        intent.setFlags(i);
        startActivity(intent);
        finish();
    }

    @Override // com.nexstreaming.kinemaster.ui.share.Da.b
    public void a(Intent intent) {
        kotlin.jvm.internal.h.b(intent, "intent");
        a(intent, 268468224);
    }

    @Override // com.nexstreaming.kinemaster.ui.share.Da.b
    public void a(File file, MediaInfo mediaInfo, String str) {
        e.a a2 = com.nexstreaming.kinemaster.ui.a.e.a(this);
        a2.a(getString(R.string.rec_video_fail_formaterr));
        a2.a(i.f21614a);
        a2.c(R.string.button_ok, new j(this));
        if (str != null) {
            a2.b(str);
        }
        a2.a().show();
    }

    @Override // com.nexstreaming.kinemaster.ui.e.c.b
    public void a(int i) {
        if (i != -1) {
            finish();
        } else {
            O();
        }
    }
}
