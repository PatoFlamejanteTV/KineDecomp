package com.nexstreaming.app.general.iab;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.internal.view.SupportMenu;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import android.widget.Toast;
import com.android.billingclient.api.M;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.gson.Gson;
import com.nexstreaming.app.general.iab.Presenter.B;
import com.nexstreaming.app.general.iab.Presenter.C1695y;
import com.nexstreaming.app.general.iab.Presenter.IABBasePresent;
import com.nexstreaming.app.general.iab.Purchase;
import com.nexstreaming.app.general.iab.Utils.IABConstant;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.DiagnosticLogger;
import com.nexstreaming.app.general.util.N;
import com.nexstreaming.app.general.util.SupportLogger;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.network.InterfaceC1821j;
import com.nexstreaming.kinemaster.tracelog.APCManager;
import com.nexstreaming.kinemaster.tracelog.KMAppUsage;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nextreaming.nexeditorui.E;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.PatternSyntaxException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.Regex;

/* compiled from: IABManager.kt */
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes2.dex */
public final class IABManager extends com.nexstreaming.app.general.iab.a.b {
    private final boolean A;
    private boolean B;
    private boolean C;
    private final HashMap<String, Purchase> D;
    private final long E;
    private boolean F;
    private boolean G;
    private String H;
    private boolean I;
    private final io.reactivex.disposables.a J;
    private final String K;
    private com.nexstreaming.kinemaster.ui.a.e L;
    private List<? extends InterfaceC1821j> M;
    private boolean N;
    private final ExecutorService O;

    /* renamed from: d, reason: collision with root package name */
    private final String f19319d;

    /* renamed from: e, reason: collision with root package name */
    private final com.nexstreaming.app.general.iab.Utils.a f19320e;

    /* renamed from: f, reason: collision with root package name */
    private Context f19321f;

    /* renamed from: g, reason: collision with root package name */
    private IABBasePresent f19322g;

    /* renamed from: h, reason: collision with root package name */
    private final Gson f19323h;
    private SharedPreferences i;
    private boolean j;
    private final HashSet<Long> k;
    private boolean l;
    private String m;
    private PurchaseType n;
    private Purchase o;
    private Purchase p;
    private int q;
    private int r;
    private int s;
    private int t;
    private boolean u;
    private SKUDetails v;
    private SKUDetails w;
    private SKUDetails x;
    private final boolean y;
    private boolean z;

    /* renamed from: c, reason: collision with root package name */
    public static final a f19318c = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static int f19317b = -1;

    /* compiled from: IABManager.kt */
    /* loaded from: classes2.dex */
    public enum BillingType {
        FREE,
        PREMIUM
    }

    /* compiled from: IABManager.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final int a() {
            return b();
        }

        public final int b() {
            return IABManager.f19317b;
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public IABManager(Context context) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        this.f19319d = "IABManager";
        this.f19320e = new com.nexstreaming.app.general.iab.Utils.a();
        this.f19321f = context;
        this.f19323h = new Gson();
        this.k = new HashSet<>();
        this.z = true;
        this.A = true;
        this.D = new HashMap<>();
        this.E = 86400000;
        this.J = new io.reactivex.disposables.a();
        this.K = "EMPTY_ERROR_MESSAGE";
        this.O = Executors.newSingleThreadExecutor();
        this.f19322g = e(context);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        kotlin.jvm.internal.h.a((Object) defaultSharedPreferences, "PreferenceManager.getDef…haredPreferences(context)");
        this.i = defaultSharedPreferences;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G() {
        this.q = 0;
        this.p = null;
        this.D.clear();
    }

    private final int H() {
        if (!this.u) {
            this.t = new c.d.b.f.a(this.f19321f).a();
            this.u = true;
        }
        return this.t;
    }

    private final boolean I() {
        c.d.b.b.d b2 = c.d.b.b.i.b();
        kotlin.jvm.internal.h.a((Object) b2, "FirebaseManager.getAccount()");
        c.d.b.b.a.e b3 = b2.b();
        return b3 != null && kotlin.text.n.b(NotificationCompat.CATEGORY_PROMO, b3.getAccountType(), true) && System.currentTimeMillis() < b3.getAccountExpiration();
    }

    private final boolean J() {
        if (this.i == null) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f19321f);
            kotlin.jvm.internal.h.a((Object) defaultSharedPreferences, "PreferenceManager.getDef…haredPreferences(context)");
            this.i = defaultSharedPreferences;
        }
        return this.j && !TextUtils.isEmpty(this.i.getString("com.kinemaster.apc.sel_account_name", null));
    }

    private final boolean K() {
        c.d.b.b.d b2 = c.d.b.b.i.b();
        kotlin.jvm.internal.h.a((Object) b2, "FirebaseManager.getAccount()");
        c.d.b.b.a.e b3 = b2.b();
        return b3 != null && kotlin.text.n.b("standard", b3.getAccountType(), true) && System.currentTimeMillis() < b3.getAccountExpiration();
    }

    private final boolean L() {
        c.d.b.b.d b2 = c.d.b.b.i.b();
        kotlin.jvm.internal.h.a((Object) b2, "FirebaseManager.getAccount()");
        c.d.b.b.a.e b3 = b2.b();
        return b3 != null && kotlin.text.n.b("team", b3.getAccountType(), true) && System.currentTimeMillis() < b3.getAccountExpiration();
    }

    public final PurchaseType A() {
        if (this.l) {
            this.n = PurchaseType.None;
            return this.n;
        }
        if (c.d.b.f.a.a(H())) {
            this.n = PurchaseType.Partner;
        } else if (this.f19322g != null) {
            if (L()) {
                this.n = PurchaseType.Team;
            } else if (K()) {
                this.n = PurchaseType.Standard;
            } else if (!J() && !I()) {
                Purchase purchase = this.o;
                if (purchase != null) {
                    if (purchase == null) {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                    if (purchase.f() == Purchase.PurchaseState.Purchased) {
                        com.nexstreaming.app.general.iab.Utils.a aVar = this.f19320e;
                        Purchase purchase2 = this.o;
                        if (purchase2 == null) {
                            kotlin.jvm.internal.h.a();
                            throw null;
                        }
                        this.n = aVar.a(purchase2.d());
                    }
                }
                Purchase purchase3 = this.p;
                if (purchase3 != null) {
                    if (purchase3 == null) {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                    if (purchase3.f() == Purchase.PurchaseState.Purchased) {
                        if (this.q > 0) {
                            this.n = PurchaseType.OneTimeValid;
                        } else {
                            this.n = PurchaseType.OneTimeExpired;
                        }
                    }
                }
                this.n = PurchaseType.None;
            } else {
                this.n = PurchaseType.Promocode;
            }
        } else {
            this.n = PurchaseType.None;
        }
        return this.n;
    }

    public final void B() {
        if (this.f19322g != null) {
            G();
            this.f19322g.w();
        }
    }

    public final ResultTask<Boolean> C() {
        return this.f19322g.y();
    }

    public final void D() {
        if (this.N) {
            return;
        }
        synchronized (this) {
            this.J.b(this.f19322g.z().b(io.reactivex.g.b.a(this.O)).a(io.reactivex.a.b.b.a()).a(new p(this), new q(this)));
        }
    }

    public final void E() {
        this.C = true;
        this.f19322g.x();
        b(true);
    }

    public final void F() {
        if (this.f19322g != null) {
            a(IABBasePresent.State.SEND_RESULT);
            this.f19322g.A();
        }
    }

    public final String g() {
        IABBasePresent iABBasePresent = this.f19322g;
        if (iABBasePresent != null) {
            if (iABBasePresent instanceof C1695y) {
                return this.f19321f.getString(R.string.iab_connection_fail_message);
            }
            if (iABBasePresent instanceof B) {
                kotlin.jvm.internal.l lVar = kotlin.jvm.internal.l.f28544a;
                String string = this.f19321f.getString(R.string.account_login_message);
                kotlin.jvm.internal.h.a((Object) string, "context.getString(R.string.account_login_message)");
                Object[] objArr = {this.f19321f.getString(R.string.sns_wechat)};
                String format = String.format(string, Arrays.copyOf(objArr, objArr.length));
                kotlin.jvm.internal.h.a((Object) format, "java.lang.String.format(format, *args)");
                return format;
            }
            return this.f19321f.getString(R.string.iab_connection_fail_message);
        }
        return this.f19321f.getString(R.string.iab_connection_fail_message);
    }

    public final Context h() {
        return this.f19321f;
    }

    public final IABConstant.HELPERType i() {
        IABBasePresent iABBasePresent = this.f19322g;
        if (iABBasePresent != null) {
            if (iABBasePresent instanceof C1695y) {
                return IABConstant.HELPERType.google;
            }
            if (iABBasePresent instanceof B) {
                return IABConstant.HELPERType.wechat;
            }
            return IABConstant.HELPERType.none;
        }
        return IABConstant.HELPERType.none;
    }

    public final int j() {
        return this.s;
    }

    public final SKUDetails k() {
        return this.v;
    }

    public final SKUDetails l() {
        for (SKUDetails sKUDetails : new SKUDetails[]{this.v, this.w, this.x}) {
            if (this.f19320e.d(sKUDetails)) {
                return sKUDetails;
            }
        }
        return null;
    }

    public final int m() {
        return this.q;
    }

    public final IABBasePresent n() {
        return this.f19322g;
    }

    public final SKUDetails o() {
        return this.w;
    }

    public final List<InterfaceC1821j> p() {
        ArrayList arrayList = new ArrayList();
        if (this.M == null) {
            return arrayList;
        }
        IABBasePresent iABBasePresent = this.f19322g;
        if (iABBasePresent instanceof B) {
            List<Purchase> list = iABBasePresent.l().get(IABConstant.SKUType.wechat);
            if (list != null) {
                for (Purchase purchase : list) {
                    List<? extends InterfaceC1821j> list2 = this.M;
                    if (list2 != null) {
                        for (InterfaceC1821j interfaceC1821j : list2) {
                            String b2 = interfaceC1821j.b();
                            String j = purchase.j();
                            kotlin.jvm.internal.h.a((Object) j, "p.sku");
                            if (b2.compareTo(j) == 0) {
                                arrayList.add(interfaceC1821j);
                            }
                        }
                    } else {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                }
            }
        } else {
            List<Purchase> list3 = iABBasePresent.l().get(IABConstant.SKUType.inapp);
            if (list3 != null) {
                for (Purchase purchase2 : list3) {
                    List<? extends InterfaceC1821j> list4 = this.M;
                    if (list4 != null) {
                        for (InterfaceC1821j interfaceC1821j2 : list4) {
                            String b3 = interfaceC1821j2.b();
                            String d2 = purchase2.d();
                            kotlin.jvm.internal.h.a((Object) d2, "p.productId");
                            if (b3.compareTo(d2) == 0) {
                                arrayList.add(interfaceC1821j2);
                            }
                        }
                    } else {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                }
            }
        }
        return arrayList;
    }

    public final Purchase q() {
        return this.o;
    }

    public final String r() {
        return this.f19319d;
    }

    public final SKUDetails s() {
        return this.x;
    }

    public final boolean t() {
        if (A() != null) {
            PurchaseType A = A();
            if (A != null) {
                switch (b.f19437b[A.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        this.i.edit().putBoolean("is_subscription_or_promotion", true).apply();
                        return true;
                }
            }
            this.i.edit().putBoolean("is_subscription_or_promotion", false).apply();
        }
        return false;
    }

    public final boolean u() {
        return this.f19322g != null;
    }

    public final boolean v() {
        return (this.f19322g.d("one") == null && this.f19322g.d("subs") == null && !this.f19322g.r()) ? false : true;
    }

    public final boolean w() {
        return this.f19322g.s();
    }

    public final void x() {
        if (this.f19322g == null || this.f19321f == null) {
            return;
        }
        synchronized (this) {
            this.J.b(this.f19322g.t().b(io.reactivex.g.b.a(this.O)).a(io.reactivex.a.b.b.a()).a(new h(this), new i(this)));
        }
    }

    public final void y() {
        if (this.f19321f != null && this.f19322g != null) {
            synchronized (this) {
                this.J.b(this.f19322g.u().b(io.reactivex.g.b.a(this.O)).a(io.reactivex.a.b.b.a()).a(new j(this), new k(this)));
            }
            return;
        }
        a((LinkedHashMap<IABConstant.SKUType, LinkedHashMap<String, SKUDetails>>) null);
    }

    public final void z() {
        IABBasePresent iABBasePresent = this.f19322g;
        if (iABBasePresent != null) {
            iABBasePresent.v();
        }
        this.J.a();
    }

    private final boolean c(Purchase purchase) {
        int i = 0;
        if (this.f19320e.d(purchase.d())) {
            DiagnosticLogger.b().a(DiagnosticLogger.Tag.IW_P_PREFIX_OK);
            this.o = purchase;
            if (purchase.e() != null && (this.f19320e.d(purchase) || this.f19320e.c(purchase))) {
                if (this.f19320e.d(purchase)) {
                    i = 30;
                } else if (this.f19320e.c(purchase)) {
                    i = 365;
                }
                long j = this.E * i;
                IABBasePresent iABBasePresent = this.f19322g;
                Date g2 = purchase.g();
                kotlin.jvm.internal.h.a((Object) g2, "p.purchaseTime");
                iABBasePresent.a("subs", purchase, j + g2.getTime());
                this.i.edit().putBoolean("is_subscription_or_promotion", true).apply();
            }
            return true;
        }
        DiagnosticLogger.b().a(DiagnosticLogger.Tag.IW_P_PREFIX_NOT_FOUND);
        return false;
    }

    private final boolean d(Purchase purchase) {
        IABBasePresent iABBasePresent = this.f19322g;
        if (iABBasePresent == null) {
            return false;
        }
        if (iABBasePresent instanceof B) {
            return true;
        }
        double random = Math.random();
        double d2 = SupportMenu.USER_MASK;
        Double.isNaN(d2);
        int i = (int) (random * d2);
        return (((purchase.b() ^ 79225) & SupportMenu.USER_MASK) ^ (this.f19322g.a(i) - (i ^ 4660))) == 51916;
    }

    private final IABBasePresent e(Context context) {
        String a2 = c.d.b.m.a.a();
        if (c.d.b.m.e.f3850a.a()) {
            kotlin.jvm.internal.h.a((Object) a2, "installer");
            return new B(context, a2, this);
        }
        kotlin.jvm.internal.h.a((Object) a2, "installer");
        return new C1695y(context, a2, this);
    }

    public final void b(boolean z) {
        this.z = z;
        b();
        if (z) {
            z = !(this.f19322g instanceof B);
        }
        this.z = z;
        Purchase d2 = this.f19322g.d("one");
        if (d2 != null) {
            b(d2);
        } else {
            this.p = null;
            this.q = 0;
        }
        Purchase d3 = this.f19322g.d("subs");
        if (d3 != null) {
            c(d3);
        } else {
            this.o = null;
        }
        this.J.b(this.f19322g.B().b(io.reactivex.g.b.b()).a(io.reactivex.a.b.b.a()).a(new y(this), new z(this)));
    }

    public final com.nexstreaming.app.general.iab.Utils.a f() {
        return this.f19320e;
    }

    public final String e() {
        IABBasePresent iABBasePresent = this.f19322g;
        if (iABBasePresent != null) {
            return iABBasePresent.c();
        }
        return null;
    }

    public final SKUDetails d() {
        for (SKUDetails sKUDetails : new SKUDetails[]{this.v, this.w, this.x}) {
            if (this.f19320e.c(sKUDetails)) {
                return sKUDetails;
            }
        }
        return null;
    }

    public final boolean a(Context context) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        return isGooglePlayServicesAvailable == 0 || isGooglePlayServicesAvailable == 2 || isGooglePlayServicesAvailable == 18 || isGooglePlayServicesAvailable == 3;
    }

    public final void a(boolean z, int i) {
        if (z) {
            x();
            y();
            D();
        }
        if (this.C && !z && i != IABError.ErrorCancel.ordinal()) {
            Context context = this.f19321f;
            Toast.makeText(context, context.getResources().getString(R.string.cloud_connect_fail), 0).show();
            this.C = false;
        }
        a(z, i, this.z);
    }

    public final boolean d(Context context) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        int i = f19317b;
        if (i == -1) {
            return false;
        }
        if (i == 0 || i == 1 || i == 2 || i != 3) {
            return true;
        }
        System.exit(0);
        return true;
    }

    public final String c(Context context) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        String b2 = b(context);
        if (b2 != null) {
            return b2;
        }
        PurchaseType A = A();
        if (A == null) {
            return "Free";
        }
        switch (b.f19439d[A.ordinal()]) {
            case 1:
                return "Sub-Annual";
            case 2:
                return "Sub-Monthly";
            case 3:
                return "Free-prom";
            case 4:
                return "Team";
            case 5:
                return "Standard";
            case 6:
                return "Partner";
            case 7:
                if (this.y) {
                    return "Pass-" + j() + "days-ext";
                }
                return "Pass-" + j() + "days";
            default:
                return "Free";
        }
    }

    public final void a(SKUDetails sKUDetails, Context context) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        IABBasePresent iABBasePresent = this.f19322g;
        if (iABBasePresent != null) {
            if (sKUDetails != null) {
                this.J.b(iABBasePresent.a(sKUDetails, b(sKUDetails, context), (Activity) context).b(io.reactivex.g.b.b()).a(io.reactivex.a.b.b.a()).a(new f(this), new g(this)));
            } else {
                a(false, (Purchase) null, "Context or Sku is null");
            }
        }
    }

    private final boolean b(Purchase purchase) {
        boolean c2 = this.f19320e.c(purchase.d());
        int a2 = this.f19320e.a(purchase);
        if (c2 && a2 > 0) {
            this.r = a2;
            this.s = this.r;
            long j = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            long i = purchase.i();
            Date g2 = purchase.g();
            kotlin.jvm.internal.h.a((Object) g2, "p.purchaseTime");
            int min = this.r - ((int) Math.min(j, (i - g2.getTime()) / this.E));
            DeveloperPayLoad developerPayLoad = null;
            try {
                developerPayLoad = (DeveloperPayLoad) this.f19323h.fromJson(purchase.a(), DeveloperPayLoad.class);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (developerPayLoad != null) {
                min += developerPayLoad.a();
                this.r += developerPayLoad.a();
            }
            if (min > 0) {
                DiagnosticLogger.b().a(DiagnosticLogger.Tag.IW_P_PREFIX_OK_INAPP);
                this.p = purchase;
                this.q = min;
                this.f19322g.a("one", purchase, this.f19320e.a(this.f19321f) + (this.E * min));
                this.i.edit().putBoolean("is_subscription_or_promotion", true).apply();
                return true;
            }
            DiagnosticLogger.b().a(DiagnosticLogger.Tag.IW_P_EXPIRED);
            if (min <= this.q && this.p != null) {
                return false;
            }
            this.p = purchase;
            this.q = min;
            this.D.put(purchase.d(), purchase);
            return false;
        }
        DiagnosticLogger.b().a(DiagnosticLogger.Tag.IW_P_PREFIX_NOT_FOUND_INAPP);
        return false;
    }

    public final void c() {
        IABBasePresent iABBasePresent = this.f19322g;
        if (iABBasePresent != null) {
            iABBasePresent.a();
        }
    }

    public final void c(String str) {
        kotlin.jvm.internal.h.b(str, "remoteconfig");
        this.m = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Map<IABConstant.SKUType, ? extends List<? extends Purchase>> map) {
        IABBasePresent iABBasePresent = this.f19322g;
        if (iABBasePresent instanceof C1695y) {
            map.get(IABConstant.SKUType.inapp);
            map.get(IABConstant.SKUType.subs);
            if (map.get(IABConstant.SKUType.inapp) != null) {
                if (map.get(IABConstant.SKUType.inapp) == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                if (!r0.isEmpty()) {
                    a(map.get(IABConstant.SKUType.inapp));
                }
            }
            if (map.get(IABConstant.SKUType.subs) != null) {
                if (map.get(IABConstant.SKUType.subs) == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                if (!r0.isEmpty()) {
                    b(map.get(IABConstant.SKUType.subs));
                    return;
                }
                return;
            }
            return;
        }
        if (!(iABBasePresent instanceof B) || map.get(IABConstant.SKUType.wechat) == null) {
            return;
        }
        if (map.get(IABConstant.SKUType.wechat) == null) {
            kotlin.jvm.internal.h.a();
            throw null;
        }
        if (!r0.isEmpty()) {
            a(map.get(IABConstant.SKUType.wechat));
        }
    }

    private final void a(List<? extends Purchase> list) {
        if (list != null) {
            DiagnosticLogger.b().a(DiagnosticLogger.ParamTag.IW_GETP_RESULT_INAPP, list.size());
            G();
            for (Purchase purchase : list) {
                if (!d(purchase)) {
                    DiagnosticLogger.b().a(DiagnosticLogger.Tag.IW_P_NOTVALID_INAPP);
                    KMAppUsage.a(this.f19321f).a(KMAppUsage.KMMetric.SubInfo, "no_vfy_ia");
                } else if (purchase.f() != Purchase.PurchaseState.Purchased) {
                    Purchase.PurchaseState f2 = purchase.f();
                    if (f2 != null) {
                        int i = b.f19440e[f2.ordinal()];
                        if (i == 1) {
                            DiagnosticLogger.b().a(DiagnosticLogger.Tag.IW_P_NOTPURCHASED_CANCELED);
                        } else if (i == 2) {
                            DiagnosticLogger.b().a(DiagnosticLogger.Tag.IW_P_NOTPURCHASED_REFUNDED);
                        }
                        KMAppUsage.a(this.f19321f).a(KMAppUsage.KMMetric.SubInfo, "no_pur_iap");
                    }
                    DiagnosticLogger.b().a(DiagnosticLogger.Tag.IW_P_NOTPURCHASED_OTHER);
                    KMAppUsage.a(this.f19321f).a(KMAppUsage.KMMetric.SubInfo, "no_pur_iap");
                } else if (b(purchase)) {
                    break;
                }
            }
            SupportLogger.Event.IW_Once_Success.log(new int[0]);
        }
    }

    public final boolean b() {
        this.j = APCManager.a(this.f19321f);
        if (this.j && !this.G && !this.F) {
            IABBasePresent iABBasePresent = this.f19322g;
            boolean z = iABBasePresent == null || (iABBasePresent instanceof C1695y);
            this.G = true;
            APCManager.a(this.f19321f, z).onResultAvailable(new c(this));
        }
        return this.j;
    }

    public final String b(Context context) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        if (!this.I) {
            int a2 = new c.d.b.f.a(context).a();
            if (c.d.b.f.a.a(a2)) {
                if (a2 == 1001) {
                    this.H = "Partner-LGE-ANNA";
                } else {
                    this.H = "Partner-OTHER";
                }
            }
            this.I = true;
        }
        return this.H;
    }

    public final void b(boolean z, Purchase purchase, String str) {
        if (z && purchase != null) {
            if (c(purchase)) {
                KMAppUsage.a(this.f19321f).a(KMAppUsage.KMMetric.SubAction, "purchase");
            } else if (b(purchase)) {
                KMAppUsage.a(this.f19321f).a(KMAppUsage.KMMetric.SubAction, "purchase_managed");
            } else {
                KMAppUsage.a(this.f19321f).a(KMAppUsage.KMMetric.SubAction, "bad_sku");
            }
        }
        a(z, purchase, str);
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i) {
        e.a aVar = new e.a(this.f19321f);
        aVar.c(i);
        aVar.b(100);
        aVar.c(R.string.button_ok, x.f19496a);
        aVar.a().show();
    }

    public final void a(IABBasePresent iABBasePresent, Map<String, ? extends SKUDetails> map) {
        List a2;
        if (iABBasePresent == null || map == null) {
            return;
        }
        if (map.get(iABBasePresent.g()) != null) {
            this.v = map.get(iABBasePresent.g());
        }
        if (map.get(iABBasePresent.m()) != null) {
            this.w = map.get(iABBasePresent.m());
        }
        if (map.get(iABBasePresent.p()) != null) {
            this.x = map.get(iABBasePresent.p());
        }
        int[] iArr = {2, 2, 2};
        if (kotlin.jvm.internal.h.a((Object) "googlePlay", (Object) "googlePlay")) {
            if (!kotlin.jvm.internal.h.a((Object) "release", (Object) "debug") && !kotlin.jvm.internal.h.a((Object) "release", (Object) UMModuleRegister.INNER)) {
                c.d.b.b.k d2 = c.d.b.b.i.d();
                kotlin.jvm.internal.h.a((Object) d2, "FirebaseManager.getRemoteConfig()");
                iArr = d2.g();
                kotlin.jvm.internal.h.a((Object) iArr, "FirebaseManager.getRemot…ig().subscriptionIndex_V2");
            } else {
                String str = this.m;
                if (str != null) {
                    try {
                        List<String> split = new Regex(",").split(str, 0);
                        if (!split.isEmpty()) {
                            ListIterator<String> listIterator = split.listIterator(split.size());
                            while (listIterator.hasPrevious()) {
                                if (!(listIterator.previous().length() == 0)) {
                                    a2 = kotlin.collections.i.b(split, listIterator.nextIndex() + 1);
                                    break;
                                }
                            }
                        }
                        a2 = kotlin.collections.i.a();
                        if (a2 != null) {
                            Object[] array = a2.toArray(new String[0]);
                            if (array != null) {
                                String[] strArr = (String[]) array;
                                int length = iArr.length;
                                for (int i = 0; i < length; i++) {
                                    iArr[i] = Integer.parseInt(strArr[i]);
                                }
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                            }
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
                        }
                    } catch (PatternSyntaxException unused) {
                    }
                } else {
                    c.d.b.b.k d3 = c.d.b.b.i.d();
                    kotlin.jvm.internal.h.a((Object) d3, "FirebaseManager.getRemoteConfig()");
                    iArr = d3.g();
                    kotlin.jvm.internal.h.a((Object) iArr, "FirebaseManager.getRemot…ig().subscriptionIndex_V2");
                }
            }
            LinkedHashMap<String, SKUDetails> a3 = this.f19322g.a(IABConstant.SKUType.subs);
            if (a3 != null) {
                for (SKUDetails sKUDetails : a3.values()) {
                    if (sKUDetails.a() == 1 && sKUDetails.h() == iArr[0]) {
                        this.v = sKUDetails;
                    }
                    if (sKUDetails.a() == 2 && sKUDetails.h() == iArr[1]) {
                        this.w = sKUDetails;
                    }
                    if (sKUDetails.a() == 3 && sKUDetails.h() == iArr[2]) {
                        this.x = sKUDetails;
                    }
                }
                return;
            }
            return;
        }
        if (c.d.b.m.e.f3850a.a()) {
            E c2 = E.c();
            kotlin.jvm.internal.h.a((Object) c2, "KMConfigFile.getInstance()");
            if (c2.f()) {
                for (int i2 = 0; i2 <= 2; i2++) {
                    iArr[i2] = iArr[i2] + 900;
                }
            }
        }
        LinkedHashMap<String, SKUDetails> a4 = this.f19322g.a(IABConstant.SKUType.wechat);
        if (a4 != null) {
            for (SKUDetails sKUDetails2 : a4.values()) {
                kotlin.jvm.internal.h.a((Object) sKUDetails2, "detail");
                if (sKUDetails2.a() == 1 && sKUDetails2.h() == iArr[0]) {
                    this.v = sKUDetails2;
                }
                if (sKUDetails2.a() == 2 && sKUDetails2.h() == iArr[1]) {
                    this.w = sKUDetails2;
                }
                if (sKUDetails2.a() == 3 && sKUDetails2.h() == iArr[2]) {
                    this.x = sKUDetails2;
                }
            }
        }
    }

    private final DeveloperPayLoad b(SKUDetails sKUDetails, Context context) {
        SecureRandom secureRandom = new SecureRandom();
        String str = Integer.toHexString(secureRandom.nextInt()) + "XXXXXXXX";
        if (str != null) {
            String substring = str.substring(0, 8);
            kotlin.jvm.internal.h.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String str2 = Integer.toHexString(secureRandom.nextInt()) + "XXXXXXXX";
            if (str2 != null) {
                kotlin.jvm.internal.h.a((Object) str2.substring(0, 8), "(this as java.lang.Strin…ing(startIndex, endIndex)");
                DeveloperPayLoad developerPayLoad = new DeveloperPayLoad();
                if (sKUDetails != null && this.q >= 0) {
                    String str3 = "KM313X." + substring + "." + N.c(context);
                    Purchase purchase = this.p;
                    developerPayLoad.b(purchase != null ? purchase.j() : null);
                    int i = this.q;
                    if (i < 0) {
                        i = 0;
                    }
                    developerPayLoad.a(i);
                    developerPayLoad.a(str3);
                }
                return developerPayLoad;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    private final void b(List<? extends Purchase> list) {
        if (list != null) {
            DiagnosticLogger.b().a(DiagnosticLogger.ParamTag.IW_GETP_RESULT_INAPP, list.size());
            for (Purchase purchase : list) {
                if (!d(purchase)) {
                    DiagnosticLogger.b().a(DiagnosticLogger.Tag.IW_P_NOTVALID_INAPP);
                    KMAppUsage.a(this.f19321f).a(KMAppUsage.KMMetric.SubInfo, "no_vfy_ia");
                } else if (purchase.f() != Purchase.PurchaseState.Purchased) {
                    Purchase.PurchaseState f2 = purchase.f();
                    if (f2 != null) {
                        int i = b.f19441f[f2.ordinal()];
                        if (i == 1) {
                            DiagnosticLogger.b().a(DiagnosticLogger.Tag.IW_P_NOTPURCHASED_CANCELED);
                        } else if (i == 2) {
                            DiagnosticLogger.b().a(DiagnosticLogger.Tag.IW_P_NOTPURCHASED_REFUNDED);
                        }
                        KMAppUsage.a(this.f19321f).a(KMAppUsage.KMMetric.SubInfo, "no_pur_iap");
                    }
                    DiagnosticLogger.b().a(DiagnosticLogger.Tag.IW_P_NOTPURCHASED_OTHER);
                    KMAppUsage.a(this.f19321f).a(KMAppUsage.KMMetric.SubInfo, "no_pur_iap");
                } else if (c(purchase)) {
                    break;
                }
            }
            SupportLogger.Event.IW_Once_Success.log(new int[0]);
        }
    }

    private final void b(String str, String str2) {
        KMAppUsage.a(this.f19321f).a(KMAppUsage.KMMetric.SubAction, str2);
        a(false, (Purchase) null, str);
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [T, java.lang.Object, java.lang.String] */
    public final void b(DialogInterface.OnClickListener onClickListener) {
        if (this.L == null) {
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = "";
            if (this.f19322g instanceof C1695y) {
                ?? string = this.f19321f.getString(R.string.google);
                kotlin.jvm.internal.h.a((Object) string, "context.getString(R.string.google)");
                ref$ObjectRef.element = string;
            }
            this.L = new com.nexstreaming.kinemaster.ui.a.e(this.f19321f);
            com.nexstreaming.kinemaster.ui.a.e eVar = this.L;
            if (eVar != null) {
                kotlin.jvm.internal.l lVar = kotlin.jvm.internal.l.f28544a;
                String string2 = this.f19321f.getString(R.string.account_of);
                kotlin.jvm.internal.h.a((Object) string2, "context.getString(R.string.account_of)");
                Object[] objArr = {(String) ref$ObjectRef.element};
                String format = String.format(string2, Arrays.copyOf(objArr, objArr.length));
                kotlin.jvm.internal.h.a((Object) format, "java.lang.String.format(format, *args)");
                eVar.setTitle(format);
                kotlin.jvm.internal.l lVar2 = kotlin.jvm.internal.l.f28544a;
                String string3 = this.f19321f.getString(R.string.account_login_popup_message);
                kotlin.jvm.internal.h.a((Object) string3, "context.getString(R.stri…ount_login_popup_message)");
                Object[] objArr2 = {(String) ref$ObjectRef.element};
                String format2 = String.format(string3, Arrays.copyOf(objArr2, objArr2.length));
                kotlin.jvm.internal.h.a((Object) format2, "java.lang.String.format(format, *args)");
                eVar.a(format2);
                eVar.f(12);
                eVar.g(18);
                eVar.a(this.f19321f.getString(R.string.continue_with_watermark), new v(this, ref$ObjectRef, onClickListener));
                eVar.c(this.f19321f.getString(R.string.service_login_required), new w(this, ref$ObjectRef, onClickListener));
            }
        }
        com.nexstreaming.kinemaster.ui.a.e eVar2 = this.L;
        if (eVar2 == null || !eVar2.isShowing()) {
            return;
        }
        eVar2.show();
    }

    public final String a(String str) {
        kotlin.jvm.internal.h.b(str, "skuId");
        SKUDetails l = l();
        SKUDetails d2 = d();
        return (l == null || !kotlin.text.n.b(l.g(), str, true)) ? (d2 == null || !kotlin.text.n.b(d2.g(), str, true)) ? "Others" : "Annual Subscription" : "Monthly Subscription";
    }

    public final boolean b(String str) {
        IABBasePresent iABBasePresent = this.f19322g;
        if (iABBasePresent instanceof B) {
            List<Purchase> list = iABBasePresent.l().get(IABConstant.SKUType.wechat);
            if (list == null) {
                return false;
            }
            Iterator<Purchase> it = list.iterator();
            while (it.hasNext()) {
                if (kotlin.jvm.internal.h.a((Object) it.next().j(), (Object) str)) {
                    return true;
                }
            }
            return false;
        }
        List<Purchase> list2 = iABBasePresent.l().get(IABConstant.SKUType.inapp);
        if (list2 == null) {
            return false;
        }
        Iterator<Purchase> it2 = list2.iterator();
        while (it2.hasNext()) {
            if (kotlin.jvm.internal.h.a((Object) it2.next().d(), (Object) str)) {
                return true;
            }
        }
        return false;
    }

    public final void a(int i, List<M> list) {
        if (this.f19322g == null || this.f19321f == null) {
            return;
        }
        Task.TaskError[] taskErrorArr = new Task.TaskError[2];
        if (list != null) {
            Iterator<M> it = list.iterator();
            while (it.hasNext()) {
                Purchase a2 = this.f19322g.a(i, it.next());
                if (!d(a2)) {
                    KMAppUsage.a(this.f19321f).a(KMAppUsage.KMMetric.SubAction, "no_vfy");
                    a(false, a2, IABError.InternalErrorA0.name());
                    return;
                } else {
                    if (a2.f() != Purchase.PurchaseState.Purchased) {
                        KMAppUsage.a(this.f19321f).a(KMAppUsage.KMMetric.SubAction, "no_pur");
                        a(false, a2, IABError.InternalErrorA1.name());
                        return;
                    }
                    b(true, a2, null);
                }
            }
            return;
        }
        taskErrorArr[0] = BillingResponse.NULL_INTENT_DATA;
        if (i == BillingResponse.USER_CANCELED.getIntErrorCode()) {
            taskErrorArr[0] = BillingResponse.USER_CANCELED_ACTIVITY;
            taskErrorArr[1] = BillingResponse.USER_CANCELED;
        } else {
            taskErrorArr[0] = BillingResponse.BAD_ACTIVITY_RESULT;
        }
        if (taskErrorArr[0] != null && taskErrorArr[0] == BillingResponse.USER_CANCELED_ACTIVITY && taskErrorArr[1] != null) {
            Task.TaskError taskError = taskErrorArr[1];
            if (taskError == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            String message = taskError.getMessage();
            kotlin.jvm.internal.h.a((Object) message, "error[1]!!.getMessage()");
            b(message, "cancel");
            return;
        }
        if (taskErrorArr[0] != null) {
            Task.TaskError taskError2 = taskErrorArr[0];
            if (taskError2 != null) {
                String message2 = taskError2.getMessage();
                kotlin.jvm.internal.h.a((Object) message2, "errorMessage");
                b(message2, message2);
                return;
            }
            kotlin.jvm.internal.h.a();
            throw null;
        }
        String str = this.K;
        b(str, str);
    }

    public final void a(DialogInterface.OnClickListener onClickListener) {
        DiagnosticLogger.b().a();
        kotlin.jvm.internal.h.a((Object) DiagnosticLogger.b().toString(), "DiagnosticLogger.getInstance().toString()");
        if (this.f19322g != null && !c.d.b.m.e.f3850a.a()) {
            e.a aVar = new e.a(this.f19321f);
            aVar.e(R.string.iab_no_connection);
            aVar.f(18);
            aVar.a(g());
            aVar.d(12);
            aVar.b(R.string.continue_with_watermark, new r(onClickListener));
            aVar.a(R.string.check_account, new s(this));
            aVar.c(R.string.retry, new t(this));
            aVar.a().show();
            return;
        }
        b(new u(onClickListener));
    }

    public final ResultTask<APCManager.a> a(String str, String str2) {
        kotlin.jvm.internal.h.b(str2, "account");
        ResultTask<APCManager.a> resultTask = new ResultTask<>();
        if (!APCManager.a(str)) {
            resultTask.sendFailure(new APCManager.a(false, "verifyFail", R.string.apc_err_verify_fail, null));
            return resultTask;
        }
        Context context = this.f19321f;
        IABBasePresent iABBasePresent = this.f19322g;
        APCManager.a(context, str, str2, iABBasePresent == null || (iABBasePresent instanceof C1695y)).onResultAvailable(new l(this, resultTask)).onFailure((Task.OnFailListener) new m(this, resultTask));
        return resultTask;
    }

    public final void a(boolean z) {
        this.B = z;
    }

    public final void a(Purchase purchase) {
        if (purchase == null) {
            HashMap<String, Purchase> hashMap = this.D;
        }
    }

    public final void a(IABBasePresent.State state) {
        kotlin.jvm.internal.h.b(state, ServerProtocol.DIALOG_PARAM_STATE);
        this.f19322g.a(state);
    }

    public final void a(String str, Context context) {
        List<Purchase> list = this.f19322g.l().get(IABConstant.SKUType.inapp);
        if (list == null || str == null) {
            if (context != null) {
                Toast.makeText(context, context.getString(R.string.iab_refund_fail), 0).show();
                return;
            } else {
                Toast.makeText(context, "Consume fail", 0).show();
                return;
            }
        }
        for (Purchase purchase : list) {
            if (kotlin.jvm.internal.h.a((Object) purchase.d(), (Object) str) && this.f19322g.n().get(IABConstant.SKUType.inapp) != null) {
                this.J.b(this.f19322g.a(purchase).b(io.reactivex.g.b.b()).a(io.reactivex.a.b.b.a()).a(new d(this, purchase, context), new e(this)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SKUDetails a(InterfaceC1821j interfaceC1821j, IABConstant.SKUType sKUType) {
        SKUDetails sKUDetails = new SKUDetails();
        sKUDetails.j(interfaceC1821j.b());
        sKUDetails.a(-1);
        sKUDetails.c(interfaceC1821j.a());
        sKUDetails.l(interfaceC1821j.f());
        String s = interfaceC1821j.s();
        sKUDetails.h(s);
        if (s != null && kotlin.text.n.a((CharSequence) s, (CharSequence) "元", false, 2, (Object) null)) {
            String substring = s.substring(0, kotlin.text.n.b(s, "元", 0, false, 6, null));
            kotlin.jvm.internal.h.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            if (Float.valueOf(substring) != null) {
                sKUDetails.a(r11.floatValue() * 100);
            } else {
                kotlin.jvm.internal.h.a();
                throw null;
            }
        }
        sKUDetails.m(sKUType.name());
        return sKUDetails;
    }

    public final void a(Context context, String str, IABConstant.SKUType sKUType, IABBasePresent.b bVar) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.h.b(sKUType, "type");
        kotlin.jvm.internal.h.b(bVar, "ll");
        if (str == null) {
            bVar.a(null);
            return;
        }
        new ArrayList().add(str);
        List<? extends InterfaceC1821j> list = this.M;
        if (list != null) {
            if (list == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            if (!list.isEmpty()) {
                if (this.f19322g.a(sKUType) == null) {
                    bVar.a(null);
                    return;
                }
                LinkedHashMap<String, SKUDetails> a2 = this.f19322g.a(sKUType);
                if (a2 != null) {
                    bVar.a(a2.get(str));
                    return;
                } else {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
            }
        }
        bVar.a(null);
    }

    public final String a(String str, IABConstant.SKUType sKUType) {
        kotlin.jvm.internal.h.b(sKUType, "type");
        if (str == null) {
            return "";
        }
        IABBasePresent iABBasePresent = this.f19322g;
        if (iABBasePresent instanceof B) {
            if (iABBasePresent.n().get(IABConstant.SKUType.wechat) != null) {
                LinkedHashMap<String, SKUDetails> linkedHashMap = this.f19322g.n().get(IABConstant.SKUType.wechat);
                if (linkedHashMap == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                if (linkedHashMap.get(str) != null) {
                    LinkedHashMap<String, SKUDetails> linkedHashMap2 = this.f19322g.n().get(IABConstant.SKUType.wechat);
                    if (linkedHashMap2 == null) {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                    SKUDetails sKUDetails = linkedHashMap2.get(str);
                    if (sKUDetails == null) {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                    kotlin.jvm.internal.h.a((Object) sKUDetails, "present.getSkuInventorie…KUType.wechat]!![SkuID]!!");
                    String c2 = sKUDetails.c();
                    kotlin.jvm.internal.h.a((Object) c2, "present.getSkuInventorie….wechat]!![SkuID]!!.price");
                    return c2;
                }
            }
        } else if (iABBasePresent.n().get(sKUType) != null) {
            LinkedHashMap<String, SKUDetails> linkedHashMap3 = this.f19322g.n().get(sKUType);
            if (linkedHashMap3 == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            if (linkedHashMap3.get(str) != null) {
                LinkedHashMap<String, SKUDetails> linkedHashMap4 = this.f19322g.n().get(sKUType);
                if (linkedHashMap4 == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                SKUDetails sKUDetails2 = linkedHashMap4.get(str);
                if (sKUDetails2 == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                kotlin.jvm.internal.h.a((Object) sKUDetails2, "present.getSkuInventories()[type]!![SkuID]!!");
                String c3 = sKUDetails2.c();
                kotlin.jvm.internal.h.a((Object) c3, "present.getSkuInventories()[type]!![SkuID]!!.price");
                return c3;
            }
        }
        return "";
    }
}
