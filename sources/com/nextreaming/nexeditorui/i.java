package com.nextreaming.nexeditorui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.AccountPicker;
import com.google.firebase.iid.FirebaseInstanceId;
import com.nexstreaming.app.general.iab.BillingResponse;
import com.nexstreaming.app.general.iab.IABManager;
import com.nexstreaming.app.general.iab.Presenter.C1695y;
import com.nexstreaming.app.general.iab.Presenter.IABBasePresent;
import com.nexstreaming.app.general.iab.Purchase;
import com.nexstreaming.app.general.iab.PurchaseType;
import com.nexstreaming.app.general.iab.SKUDetails;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.SupportLogger;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.tracelog.APCManager;
import com.nexstreaming.kinemaster.ui.SplashActivity;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nexstreaming.kinemaster.ui.projectedit.FullScreenInputActivity;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;
import com.nexstreaming.kinemaster.usage.analytics.d;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import kotlin.TypeCastException;

/* compiled from: KineMasterBaseActivity.kt */
/* loaded from: classes.dex */
public abstract class I extends AppCompatActivity {

    /* renamed from: d, reason: collision with root package name */
    private static boolean f24041d;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;

    /* renamed from: f, reason: collision with root package name */
    private boolean f24043f;

    /* renamed from: g, reason: collision with root package name */
    private long f24044g;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private String o;
    private String p;
    private IntentFilter q;
    private boolean r;
    private com.nexstreaming.app.general.service.download.i s;
    private int t;
    private int u;
    private boolean v;
    private boolean w;
    private boolean z;

    /* renamed from: e, reason: collision with root package name */
    public static final b f24042e = new b(null);

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f24038a = f24038a;

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f24038a = f24038a;

    /* renamed from: b, reason: collision with root package name */
    private static final String f24039b = f24039b;

    /* renamed from: b, reason: collision with root package name */
    private static final String f24039b = f24039b;

    /* renamed from: c, reason: collision with root package name */
    private static final String f24040c = f24040c;

    /* renamed from: c, reason: collision with root package name */
    private static final String f24040c = f24040c;

    /* renamed from: h, reason: collision with root package name */
    private final ArrayList<WeakReference<Fragment>> f24045h = new ArrayList<>();
    private final Random x = new Random();
    private final Handler y = new Handler();
    private final Runnable A = new O(this);
    private final Runnable B = new W(this);
    private final BroadcastReceiver G = new P(this);

    /* compiled from: KineMasterBaseActivity.kt */
    /* loaded from: classes.dex */
    public interface a {
        boolean onBackPressed();
    }

    /* compiled from: KineMasterBaseActivity.kt */
    /* loaded from: classes.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    private final void G() {
        Iterator<WeakReference<Fragment>> it = this.f24045h.iterator();
        ArrayList arrayList = null;
        while (it.hasNext()) {
            WeakReference<Fragment> next = it.next();
            if (next.get() == null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                kotlin.jvm.internal.h.a((Object) next, "ref");
                arrayList.add(next);
            }
        }
        if (arrayList != null) {
            this.f24045h.removeAll(arrayList);
        }
    }

    private final int H() {
        if (this.t == 0) {
            SupportLogger.Abbreviation forString = SupportLogger.Abbreviation.forString(getClass().getSimpleName());
            if (forString != null) {
                this.t = forString.code;
            } else {
                this.t = getClass().getSimpleName().hashCode();
            }
        }
        return this.t;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002e, code lost:            if (r1 == null) goto L16;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String I() {
        /*
            r6 = this;
            r0 = 0
            java.util.Scanner r1 = new java.util.Scanner     // Catch: java.lang.Throwable -> L26 java.io.FileNotFoundException -> L2d
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L26 java.io.FileNotFoundException -> L2d
            java.io.File r3 = com.nextreaming.nexeditorui.EditorGlobal.c()     // Catch: java.lang.Throwable -> L26 java.io.FileNotFoundException -> L2d
            java.lang.String r4 = "test_name.txt"
            r2.<init>(r3, r4)     // Catch: java.lang.Throwable -> L26 java.io.FileNotFoundException -> L2d
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L26 java.io.FileNotFoundException -> L2d
            java.lang.String r2 = "\\Z"
            java.util.Scanner r2 = r1.useDelimiter(r2)     // Catch: java.lang.Throwable -> L1f java.io.FileNotFoundException -> L24
            java.lang.String r0 = r2.next()     // Catch: java.lang.Throwable -> L1f java.io.FileNotFoundException -> L24
        L1b:
            r1.close()
            goto L31
        L1f:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L27
        L24:
            goto L2e
        L26:
            r1 = move-exception
        L27:
            if (r0 == 0) goto L2c
            r0.close()
        L2c:
            throw r1
        L2d:
            r1 = r0
        L2e:
            if (r1 == 0) goto L31
            goto L1b
        L31:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nextreaming.nexeditorui.I.I():java.lang.String");
    }

    private final void J() {
        if (this.C) {
            this.C = false;
            h(false);
        }
        if (this.D) {
            this.D = false;
            i(false);
        }
        if (this.E) {
            this.E = false;
            e(false);
        }
        if (this.F) {
            this.F = false;
            f(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(int i) {
        if (y().n() != null) {
            if (y().n() instanceof C1695y) {
                startActivityForResult(AccountPicker.a(null, null, new String[]{"com.google"}, false, getResources().getString(i == 8199 ? R.string.promocode_acct_sel : i == 8198 ? R.string.license_acct_sel : 0), null, null, null), i);
                return;
            }
            if (y().n() instanceof com.nexstreaming.app.general.iab.Presenter.B) {
                IABBasePresent n = y().n();
                if (n != null) {
                    com.nexstreaming.app.general.iab.Presenter.B b2 = (com.nexstreaming.app.general.iab.Presenter.B) n;
                    if (b2.s()) {
                        Intent intent = new Intent();
                        intent.putExtra("authAccount", y().n().b());
                        onActivityResult(i, -1, intent);
                        return;
                    } else {
                        if (b2.D()) {
                            y().F();
                        } else {
                            b2.a(u());
                        }
                        this.n = false;
                        return;
                    }
                }
                throw new TypeCastException("null cannot be cast to non-null type com.nexstreaming.app.general.iab.Presenter.IABWxPresent");
            }
            Intent intent2 = new Intent();
            intent2.putExtra("authAccount", y().n().b());
            onActivityResult(i, -1, intent2);
        }
    }

    public final int A() {
        if (!this.v) {
            this.u = new c.d.b.f.a(this).a();
            this.v = f24038a;
        }
        return this.u;
    }

    public final PurchaseType B() {
        return y().A();
    }

    public final boolean C() {
        if (c.d.b.f.a.a(A())) {
            if (!this.w) {
                if (y().b(this) != null) {
                    PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("put_user_type", f24038a).apply();
                }
                this.w = f24038a;
            }
            return f24038a;
        }
        if (B() == null) {
            return false;
        }
        PurchaseType B = B();
        if (B != null) {
            return B.isActivePurchaseOrPromocode();
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean D() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean E() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F() {
        y().c();
        y().z();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Context context) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(Context context) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
    }

    public final void e(boolean z) {
        if (z) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            kotlin.jvm.internal.h.a((Object) supportFragmentManager, "supportFragmentManager");
            if (supportFragmentManager.getBackStackEntryCount() > 0) {
                try {
                    getSupportFragmentManager().popBackStack((String) null, 1);
                    return;
                } catch (IllegalStateException e2) {
                    e2.printStackTrace();
                    this.E = f24038a;
                    return;
                }
            }
            return;
        }
        FragmentManager supportFragmentManager2 = getSupportFragmentManager();
        kotlin.jvm.internal.h.a((Object) supportFragmentManager2, "supportFragmentManager");
        if (supportFragmentManager2.getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack((String) null, 1);
        }
    }

    public final boolean f(boolean z) {
        if (z) {
            try {
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                kotlin.jvm.internal.h.a((Object) supportFragmentManager, "supportFragmentManager");
                if (supportFragmentManager.getBackStackEntryCount() > 0) {
                    return getSupportFragmentManager().popBackStackImmediate((String) null, 1);
                }
                return false;
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
                this.F = f24038a;
                return false;
            }
        }
        FragmentManager supportFragmentManager2 = getSupportFragmentManager();
        kotlin.jvm.internal.h.a((Object) supportFragmentManager2, "supportFragmentManager");
        if (supportFragmentManager2.getBackStackEntryCount() > 0) {
            return getSupportFragmentManager().popBackStackImmediate((String) null, 1);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(boolean z) {
        char c2;
        Purchase q = y().q();
        if (q != null && q.f() == Purchase.PurchaseState.Purchased) {
            String c3 = q.c();
            String d2 = q.d();
            if (c3 != null) {
                boolean z2 = false;
                int length = c3.length() - 1;
                int i = 0;
                boolean z3 = false;
                while (i <= length) {
                    boolean z4 = c3.charAt(!z3 ? i : length) <= ' ' ? f24038a : false;
                    if (z3) {
                        if (!z4) {
                            break;
                        } else {
                            length--;
                        }
                    } else if (z4) {
                        i++;
                    } else {
                        z3 = f24038a;
                    }
                }
                if (c3.subSequence(i, length + 1).toString().length() > 0 && d2 != null) {
                    if (kotlin.text.n.a((CharSequence) d2, (CharSequence) "annual", false, 2, (Object) null)) {
                        c2 = 40000;
                    } else {
                        c2 = kotlin.text.n.a((CharSequence) d2, (CharSequence) "month", false, 2, (Object) null) ? (char) 5000 : (char) 0;
                    }
                    if (c2 > 0) {
                        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
                        Set<String> stringSet = defaultSharedPreferences.getStringSet("km.seeniap.orders", null);
                        if (stringSet != null && stringSet.contains(c3)) {
                            z2 = f24038a;
                        }
                        if (!z2) {
                            HashSet hashSet = new HashSet();
                            if (stringSet != null) {
                                hashSet.addAll(stringSet);
                            }
                            hashSet.add(c3);
                            defaultSharedPreferences.edit().putStringSet("km.seeniap.orders", hashSet).apply();
                        }
                    }
                }
            }
        }
        if (B() != PurchaseType.Promocode && APCManager.a() && !f24041d) {
            this.y.removeCallbacks(this.B);
            this.y.postDelayed(this.B, 1000L);
        }
        if (B() != null) {
            com.nexstreaming.kinemaster.usage.analytics.d.f23910b.a(this, "User Type", y().c(this));
            PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("put_user_type", f24038a).apply();
        }
    }

    public final void h(boolean z) {
        if (z) {
            try {
                getSupportFragmentManager().popBackStack();
                return;
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
                this.C = f24038a;
                return;
            }
        }
        getSupportFragmentManager().popBackStack();
    }

    public final boolean i(boolean z) {
        if (z) {
            try {
                return getSupportFragmentManager().popBackStackImmediate();
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
                this.D = f24038a;
                return false;
            }
        }
        return getSupportFragmentManager().popBackStackImmediate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(boolean z) {
        boolean a2 = com.nexstreaming.kinemaster.ui.e.b.a((Context) this, com.nexstreaming.kinemaster.ui.e.b.f21563a) ^ f24038a;
        if (!a2 && c.d.b.m.e.f3850a.a()) {
            a2 = com.nexstreaming.kinemaster.ui.e.b.a((Context) this, com.nexstreaming.kinemaster.ui.e.b.f21567e) ^ f24038a;
        }
        if (a2) {
            return;
        }
        y().b(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        String stringExtra2;
        if (i == 8216) {
            a(i, i2, intent, false);
        } else if (i == 8215) {
            a(i, i2, intent, f24038a);
        } else if (i == 8199) {
            if (!this.n) {
                return;
            }
            this.n = false;
            if (this.m || this.l) {
                return;
            }
            if (i2 == -1 && intent != null && (stringExtra2 = intent.getStringExtra("authAccount")) != null) {
                this.m = f24038a;
                e.a aVar = new e.a(this);
                aVar.e(R.string.sub_validate_promotion_code);
                aVar.c(R.string.please_wait);
                aVar.a(false);
                com.nexstreaming.kinemaster.ui.a.e a2 = aVar.a();
                a2.show();
                y().a((String) null, stringExtra2).onResultAvailable(new Q(a2)).onFailure((Task.OnFailListener) new S(this, a2));
            }
        } else if (i == 8198) {
            if (!this.n) {
                return;
            }
            this.n = false;
            if (this.m || this.l) {
                return;
            }
            if (i2 == -1 && intent != null && (stringExtra = intent.getStringExtra("authAccount")) != null) {
                this.m = f24038a;
                e.a aVar2 = new e.a(this);
                aVar2.e(R.string.sub_validate_license_key);
                aVar2.c(R.string.please_wait);
                aVar2.a(false);
                com.nexstreaming.kinemaster.ui.a.e a3 = aVar2.a();
                a3.show();
                y().a((String) null, stringExtra).onResultAvailable(new T(a3)).onFailure((Task.OnFailListener) new U(this, a3));
            }
        } else if (i == 20496 && c.d.b.b.i.b().a(i, i2, intent)) {
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.support.v4.app.FragmentActivity
    public void onAttachFragment(Fragment fragment) {
        kotlin.jvm.internal.h.b(fragment, "fragment");
        this.f24045h.add(new WeakReference<>(fragment));
        G();
        super.onAttachFragment(fragment);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        boolean z = f24038a;
        super.onAttachedToWindow();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        Iterator<WeakReference<Fragment>> it = this.f24045h.iterator();
        while (it.hasNext()) {
            Fragment fragment = it.next().get();
            if (fragment != 0 && (fragment instanceof a) && fragment.isAdded() && ((a) fragment).onBackPressed()) {
                return;
            }
        }
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String I = I();
        if (!TextUtils.isEmpty(I)) {
            d.a aVar = com.nexstreaming.kinemaster.usage.analytics.d.f23910b;
            if (I == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            aVar.a(this, "TestName", I);
        }
        SupportLogger.Event event = SupportLogger.Event.BaseActivity_OnCreate;
        int[] iArr = new int[2];
        iArr[0] = H();
        iArr[1] = bundle != null ? 1 : 0;
        event.log(iArr);
        if (bundle != null) {
            this.C = bundle.getBoolean("is_deferred_pop_stack");
            this.D = bundle.getBoolean("is_deferred_pop_stack_immediate");
            this.E = bundle.getBoolean("is_deferred_clear_stack");
            this.F = bundle.getBoolean("is_deferred_clear_stack_immediate");
            String string = bundle.getString("BaseActivity_SKU_ProductID");
            String string2 = bundle.getString("BaseActivity_Ref");
            if (string != null && string2 != null) {
                this.l = f24038a;
                this.o = string;
                this.p = string2;
            }
        }
        this.i = f24038a;
        if (this.s == null) {
            this.s = (com.nexstreaming.app.general.service.download.i) g.a.a.a.a.a.a(this).b().a(kotlin.jvm.internal.j.a(com.nexstreaming.app.general.service.download.i.class), (org.koin.core.e.a) null, (kotlin.jvm.a.a<org.koin.core.d.a>) null);
            com.nexstreaming.app.general.service.download.i iVar = this.s;
            if (iVar != null) {
                iVar.e();
            }
        }
        super.onCreate(bundle);
        this.q = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        SupportLogger.Event.BaseActivity_OnDestroy.log(H());
        this.i = false;
        com.nexstreaming.app.general.service.download.i iVar = this.s;
        if (iVar != null) {
            iVar.d();
        }
        boolean z = f24038a;
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        this.y.removeCallbacks(this.A);
        this.y.removeCallbacks(this.B);
        SupportLogger.Event.BaseActivity_OnPause.log(H());
        this.j = false;
        boolean z = f24038a;
        this.f24043f = false;
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        J();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onRestart() {
        SupportLogger.Event.BaseActivity_OnRestart.log(H());
        boolean z = f24038a;
        super.onRestart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        SupportLogger.Event.BaseActivity_OnResume.log(H());
        this.j = f24038a;
        boolean z = f24038a;
        this.f24043f = f24038a;
        this.f24044g = SystemClock.uptimeMillis();
        this.y.postDelayed(this.A, this.x.nextInt(io.fabric.sdk.android.services.common.a.DEFAULT_TIMEOUT) + 5000);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        kotlin.jvm.internal.h.b(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(f24040c, f24038a);
        bundle.putBoolean("is_deferred_pop_stack", this.C);
        bundle.putBoolean("is_deferred_pop_stack_immediate", this.D);
        bundle.putBoolean("is_deferred_clear_stack", this.E);
        bundle.putBoolean("is_deferred_clear_stack_immediate", this.F);
        if (this.l) {
            bundle.putString("BaseActivity_SKU_ProductID", this.o);
            bundle.putString("BaseActivity_Ref", this.p);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        SupportLogger.Event.BaseActivity_OnStart.log(H());
        this.k = f24038a;
        boolean z = this instanceof SplashActivity;
        if (!z) {
            a(this, false, 1, (Object) null);
        }
        if (z && c.d.b.m.c.c(this)) {
            y().b(f24038a);
        }
        boolean z2 = f24038a;
        IntentFilter intentFilter = this.q;
        if (intentFilter != null) {
            registerReceiver(this.G, intentFilter);
            this.r = f24038a;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        SupportLogger.Event.BaseActivity_OnStop.log(H());
        SupportLogger.f19845a.b(this);
        this.k = false;
        boolean z = f24038a;
        if (this.r) {
            unregisterReceiver(this.G);
            this.r = false;
        }
        super.onStop();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        boolean z2 = f24038a;
        super.onWindowFocusChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Activity u() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final List<Fragment> v() {
        ArrayList arrayList = new ArrayList();
        Iterator<WeakReference<Fragment>> it = this.f24045h.iterator();
        while (it.hasNext()) {
            Fragment fragment = it.next().get();
            if (fragment != null) {
                arrayList.add(fragment);
            }
        }
        return arrayList;
    }

    public final com.nexstreaming.app.general.service.download.i w() {
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void x() {
        FirebaseInstanceId b2 = FirebaseInstanceId.b();
        kotlin.jvm.internal.h.a((Object) b2, "FirebaseInstanceId.getInstance()");
        b2.c().a(this, J.f24047a);
    }

    public final IABManager y() {
        return (IABManager) g.a.a.a.a.a.a(this).b().a(kotlin.jvm.internal.j.a(IABManager.class), (org.koin.core.e.a) null, (kotlin.jvm.a.a<org.koin.core.d.a>) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final NexEditor z() {
        return KineMasterApplication.f24058f.c().r();
    }

    public final void b(int i) {
        if (this.l || this.m || this.n) {
            return;
        }
        this.n = f24038a;
        if (y().w()) {
            c(i);
            return;
        }
        int i2 = 0;
        if (i == 8199) {
            i2 = R.string.account_promocode_popup_message;
        } else if (i == 8198) {
            i2 = R.string.account_license_popup_message;
        }
        e.a aVar = new e.a(this);
        aVar.e(R.string.check_account);
        aVar.c(i2);
        aVar.a(R.string.apply_to_device, new X(this, i));
        aVar.b(R.string.choose_account, new Y(this, i));
        aVar.c(R.string.button_cancel, new Z(this));
        aVar.a(new DialogInterfaceOnCancelListenerC2297aa(this));
        aVar.a().show();
    }

    public static /* synthetic */ void a(I i, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                z = false;
            }
            i.j(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startUpIAB");
    }

    private final void a(int i, int i2, Intent intent, boolean z) {
        if (this.m) {
            this.m = false;
            String string = PreferenceManager.getDefaultSharedPreferences(u()).getString("com.kinemaster.apc.sel_account_name", null);
            if ((i == 8216 || i == 8215) && i2 == 1 && string != null && string.length() > 0) {
                String e2 = FullScreenInputActivity.e(intent);
                int i3 = i == 8215 ? R.string.sub_validate_license_key : R.string.sub_validate_promotion_code;
                e.a aVar = new e.a(u());
                aVar.e(i3);
                aVar.c(R.string.please_wait);
                aVar.a(false);
                com.nexstreaming.kinemaster.ui.a.e a2 = aVar.a();
                a2.show();
                y().a(e2, string).onResultAvailable(new L(this, a2, z)).onFailure((Task.OnFailListener) new N(this, a2, z));
            }
        }
    }

    public void b(boolean z, Purchase purchase, String str) {
        HashMap hashMap = new HashMap();
        if (purchase != null) {
            String j = purchase.j();
            kotlin.jvm.internal.h.a((Object) j, "it.sku");
            hashMap.put("sku_id", j);
            IABManager y = y();
            String j2 = purchase.j();
            kotlin.jvm.internal.h.a((Object) j2, "it.sku");
            hashMap.put("type", y.a(j2));
            kotlin.k kVar = kotlin.k.f28545a;
        }
        String str2 = this.o;
        if (str2 != null) {
            hashMap.put("sku_id", str2);
            hashMap.put("type", y().a(str2));
        }
        if (z) {
            if (y().t()) {
                KMEvents.PURCHASE_PRODUCT_SUCCESS.logEvent(hashMap);
            }
        } else {
            Log.e(f24039b, "onBuyResult() called with: isSuccess = [" + z + "], message = [" + str + ']');
            if (!kotlin.text.n.b(BillingResponse.ITEM_ALREADY_OWNED.getMessage(), str, f24038a)) {
                if (kotlin.text.n.b(BillingResponse.USER_CANCELED.getMessage(), str, f24038a)) {
                    KMEvents.PURCHASE_PRODUCT_CANCEL.logEvent(hashMap);
                } else {
                    KMEvents.PURCHASE_PRODUCT_FAIL.logEvent(hashMap);
                }
            }
        }
        g(z);
        this.l = false;
        this.o = null;
        this.p = null;
    }

    public final void a(SKUDetails sKUDetails, String str) {
        kotlin.jvm.internal.h.b(sKUDetails, "sku");
        kotlin.jvm.internal.h.b(str, "ref");
        if (!this.l && !this.m && !this.n) {
            if (!EditorGlobal.v()) {
                b(false, null, null);
                return;
            }
            HashMap hashMap = new HashMap();
            IABManager y = y();
            String g2 = sKUDetails.g();
            kotlin.jvm.internal.h.a((Object) g2, "sku.productId");
            hashMap.put("button", y.a(g2));
            KMEvents.SUBSCRIPTION_CLICK_BUTTON.logEvent(hashMap);
            this.l = f24038a;
            this.o = sKUDetails.g();
            this.p = str;
            y().a(sKUDetails, this);
            return;
        }
        b(false, null, "Aleady starting Puchase");
    }
}
