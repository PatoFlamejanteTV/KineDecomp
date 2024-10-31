package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzfp;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
public class zzfo implements Q {

    /* renamed from: a, reason: collision with root package name */
    private static volatile zzfo f14037a;

    /* renamed from: b, reason: collision with root package name */
    private zzbq f14038b;

    /* renamed from: c, reason: collision with root package name */
    private zzaw f14039c;

    /* renamed from: d, reason: collision with root package name */
    private Xa f14040d;

    /* renamed from: e, reason: collision with root package name */
    private C1424k f14041e;

    /* renamed from: f, reason: collision with root package name */
    private zzfk f14042f;

    /* renamed from: g, reason: collision with root package name */
    private Ua f14043g;

    /* renamed from: h, reason: collision with root package name */
    private final zzfu f14044h;
    private C1413ea i;
    private final zzbw j;
    private boolean k;
    private boolean l;
    private boolean m;

    @VisibleForTesting
    private long n;
    private List<Runnable> o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private boolean t;
    private FileLock u;
    private FileChannel v;
    private List<Long> w;
    private List<Long> x;
    private long y;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Ya {

        /* renamed from: a, reason: collision with root package name */
        com.google.android.gms.internal.measurement.zzfw f14045a;

        /* renamed from: b, reason: collision with root package name */
        List<Long> f14046b;

        /* renamed from: c, reason: collision with root package name */
        List<com.google.android.gms.internal.measurement.zzft> f14047c;

        /* renamed from: d, reason: collision with root package name */
        private long f14048d;

        private a() {
        }

        @Override // com.google.android.gms.measurement.internal.Ya
        public final void a(com.google.android.gms.internal.measurement.zzfw zzfwVar) {
            Preconditions.a(zzfwVar);
            this.f14045a = zzfwVar;
        }

        /* synthetic */ a(zzfo zzfoVar, Ma ma) {
            this();
        }

        @Override // com.google.android.gms.measurement.internal.Ya
        public final boolean a(long j, com.google.android.gms.internal.measurement.zzft zzftVar) {
            Preconditions.a(zzftVar);
            if (this.f14047c == null) {
                this.f14047c = new ArrayList();
            }
            if (this.f14046b == null) {
                this.f14046b = new ArrayList();
            }
            if (this.f14047c.size() > 0 && a(this.f14047c.get(0)) != a(zzftVar)) {
                return false;
            }
            long zzvx = this.f14048d + zzftVar.zzvx();
            if (zzvx >= Math.max(0, zzai.w.a().intValue())) {
                return false;
            }
            this.f14048d = zzvx;
            this.f14047c.add(zzftVar);
            this.f14046b.add(Long.valueOf(j));
            return this.f14047c.size() < Math.max(1, zzai.x.a().intValue());
        }

        private static long a(com.google.android.gms.internal.measurement.zzft zzftVar) {
            return ((zzftVar.zzaxb.longValue() / 1000) / 60) / 60;
        }
    }

    private zzfo(zzft zzftVar) {
        this(zzftVar, null);
    }

    public static zzfo a(Context context) {
        Preconditions.a(context);
        Preconditions.a(context.getApplicationContext());
        if (f14037a == null) {
            synchronized (zzfo.class) {
                if (f14037a == null) {
                    f14037a = new zzfo(new zzft(context));
                }
            }
        }
        return f14037a;
    }

    private final void q() {
        this.j.zzgs().c();
    }

    private final zzbq r() {
        b(this.f14038b);
        return this.f14038b;
    }

    private final C1424k s() {
        C1424k c1424k = this.f14041e;
        if (c1424k != null) {
            return c1424k;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final zzfk t() {
        b(this.f14042f);
        return this.f14042f;
    }

    private final long u() {
        long a2 = this.j.a().a();
        C1428m q = this.j.q();
        q.l();
        q.c();
        long a3 = q.j.a();
        if (a3 == 0) {
            a3 = 1 + q.h().s().nextInt(86400000);
            q.j.a(a3);
        }
        return ((((a2 + a3) / 1000) / 60) / 60) / 24;
    }

    private final boolean v() {
        q();
        l();
        return i().A() || !TextUtils.isEmpty(i().v());
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void w() {
        /*
            Method dump skipped, instructions count: 645
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfo.w():void");
    }

    private final void x() {
        q();
        if (!this.r && !this.s && !this.t) {
            this.j.b().y().a("Stopping uploading service(s)");
            List<Runnable> list = this.o;
            if (list == null) {
                return;
            }
            Iterator<Runnable> it = list.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
            this.o.clear();
            return;
        }
        this.j.b().y().a("Not stopping services. fetch, network, upload", Boolean.valueOf(this.r), Boolean.valueOf(this.s), Boolean.valueOf(this.t));
    }

    @VisibleForTesting
    private final boolean y() {
        q();
        try {
            this.v = new RandomAccessFile(new File(this.j.getContext().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
            this.u = this.v.tryLock();
            if (this.u != null) {
                this.j.b().y().a("Storage concurrent access okay");
                return true;
            }
            this.j.b().q().a("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e2) {
            this.j.b().q().a("Failed to acquire storage lock", e2);
            return false;
        } catch (IOException e3) {
            this.j.b().q().a("Failed to access storage lock file", e3);
            return false;
        }
    }

    private final boolean z() {
        q();
        l();
        return this.l;
    }

    @Override // com.google.android.gms.measurement.internal.Q
    public final zzas b() {
        return this.j.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c() {
        this.j.zzgs().c();
        i().x();
        if (this.j.q().f13800f.a() == 0) {
            this.j.q().f13800f.a(this.j.a().a());
        }
        w();
    }

    public final zzaq d() {
        return this.j.o();
    }

    public final zzfy e() {
        return this.j.p();
    }

    public final zzq f() {
        return this.j.r();
    }

    public final zzfu g() {
        b(this.f14044h);
        return this.f14044h;
    }

    @Override // com.google.android.gms.measurement.internal.Q
    public final Context getContext() {
        return this.j.getContext();
    }

    public final Ua h() {
        b(this.f14043g);
        return this.f14043g;
    }

    public final Xa i() {
        b(this.f14040d);
        return this.f14040d;
    }

    public final zzaw j() {
        b(this.f14039c);
        return this.f14039c;
    }

    public final C1413ea k() {
        b(this.i);
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void l() {
        if (!this.k) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void m() {
        Sa b2;
        String str;
        q();
        l();
        this.t = true;
        try {
            this.j.zzgw();
            Boolean D = this.j.j().D();
            if (D == null) {
                this.j.b().t().a("Upload data called on the client side before use of service was decided");
                return;
            }
            if (D.booleanValue()) {
                this.j.b().q().a("Upload called in the client side when service should be used");
                return;
            }
            if (this.n > 0) {
                w();
                return;
            }
            q();
            if (this.w != null) {
                this.j.b().y().a("Uploading requested multiple times");
                return;
            }
            if (!j().r()) {
                this.j.b().y().a("Network not connected, ignoring upload request");
                w();
                return;
            }
            long a2 = this.j.a().a();
            a((String) null, a2 - zzq.q());
            long a3 = this.j.q().f13800f.a();
            if (a3 != 0) {
                this.j.b().x().a("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(a2 - a3)));
            }
            String v = i().v();
            if (!TextUtils.isEmpty(v)) {
                if (this.y == -1) {
                    this.y = i().C();
                }
                List<Pair<com.google.android.gms.internal.measurement.zzfw, Long>> a4 = i().a(v, this.j.r().b(v, zzai.u), Math.max(0, this.j.r().b(v, zzai.v)));
                if (!a4.isEmpty()) {
                    Iterator<Pair<com.google.android.gms.internal.measurement.zzfw, Long>> it = a4.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            str = null;
                            break;
                        }
                        com.google.android.gms.internal.measurement.zzfw zzfwVar = (com.google.android.gms.internal.measurement.zzfw) it.next().first;
                        if (!TextUtils.isEmpty(zzfwVar.zzaxv)) {
                            str = zzfwVar.zzaxv;
                            break;
                        }
                    }
                    if (str != null) {
                        int i = 0;
                        while (true) {
                            if (i >= a4.size()) {
                                break;
                            }
                            com.google.android.gms.internal.measurement.zzfw zzfwVar2 = (com.google.android.gms.internal.measurement.zzfw) a4.get(i).first;
                            if (!TextUtils.isEmpty(zzfwVar2.zzaxv) && !zzfwVar2.zzaxv.equals(str)) {
                                a4 = a4.subList(0, i);
                                break;
                            }
                            i++;
                        }
                    }
                    com.google.android.gms.internal.measurement.zzfv zzfvVar = new com.google.android.gms.internal.measurement.zzfv();
                    zzfvVar.zzaxf = new com.google.android.gms.internal.measurement.zzfw[a4.size()];
                    ArrayList arrayList = new ArrayList(a4.size());
                    boolean z = zzq.s() && this.j.r().c(v);
                    for (int i2 = 0; i2 < zzfvVar.zzaxf.length; i2++) {
                        zzfvVar.zzaxf[i2] = (com.google.android.gms.internal.measurement.zzfw) a4.get(i2).first;
                        arrayList.add((Long) a4.get(i2).second);
                        zzfvVar.zzaxf[i2].zzaxu = Long.valueOf(this.j.r().l());
                        zzfvVar.zzaxf[i2].zzaxk = Long.valueOf(a2);
                        com.google.android.gms.internal.measurement.zzfw zzfwVar3 = zzfvVar.zzaxf[i2];
                        this.j.zzgw();
                        zzfwVar3.zzaxz = false;
                        if (!z) {
                            zzfvVar.zzaxf[i2].zzayh = null;
                        }
                    }
                    String b3 = this.j.b().a(2) ? g().b(zzfvVar) : null;
                    byte[] a5 = g().a(zzfvVar);
                    String a6 = zzai.E.a();
                    try {
                        URL url = new URL(a6);
                        Preconditions.a(!arrayList.isEmpty());
                        if (this.w != null) {
                            this.j.b().q().a("Set uploading progress before finishing the previous upload");
                        } else {
                            this.w = new ArrayList(arrayList);
                        }
                        this.j.q().f13801g.a(a2);
                        this.j.b().y().a("Uploading data. app, uncompressed size, data", zzfvVar.zzaxf.length > 0 ? zzfvVar.zzaxf[0].zztt : "?", Integer.valueOf(a5.length), b3);
                        this.s = true;
                        zzaw j = j();
                        Na na = new Na(this, v);
                        j.c();
                        j.o();
                        Preconditions.a(url);
                        Preconditions.a(a5);
                        Preconditions.a(na);
                        j.zzgs().b(new RunnableC1422j(j, v, url, a5, null, na));
                    } catch (MalformedURLException unused) {
                        this.j.b().q().a("Failed to parse upload URL. Not uploading. appId", zzas.a(v), a6);
                    }
                }
            } else {
                this.y = -1L;
                String a7 = i().a(a2 - zzq.q());
                if (!TextUtils.isEmpty(a7) && (b2 = i().b(a7)) != null) {
                    a(b2);
                }
            }
        } finally {
            this.t = false;
            x();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void n() {
        q();
        l();
        if (!this.m) {
            this.m = true;
            q();
            l();
            if ((this.j.r().a(zzai.xa) || z()) && y()) {
                int a2 = a(this.v);
                int B = this.j.i().B();
                q();
                if (a2 > B) {
                    this.j.b().q().a("Panic: can't downgrade version. Previous, current version", Integer.valueOf(a2), Integer.valueOf(B));
                } else if (a2 < B) {
                    if (a(B, this.v)) {
                        this.j.b().y().a("Storage version upgraded. Previous, current version", Integer.valueOf(a2), Integer.valueOf(B));
                    } else {
                        this.j.b().q().a("Storage version upgrade failed. Previous, current version", Integer.valueOf(a2), Integer.valueOf(B));
                    }
                }
            }
        }
        if (this.l || this.j.r().a(zzai.xa)) {
            return;
        }
        this.j.b().w().a("This instance being marked as an uploader");
        this.l = true;
        w();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void o() {
        this.q++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbw p() {
        return this.j;
    }

    @Override // com.google.android.gms.measurement.internal.Q
    public final zzbr zzgs() {
        return this.j.zzgs();
    }

    @Override // com.google.android.gms.measurement.internal.Q
    public final zzn zzgw() {
        return this.j.zzgw();
    }

    private zzfo(zzft zzftVar, zzbw zzbwVar) {
        this.k = false;
        Preconditions.a(zzftVar);
        this.j = zzbw.a(zzftVar.f14050a, (zzan) null);
        this.y = -1L;
        zzfu zzfuVar = new zzfu(this);
        zzfuVar.q();
        this.f14044h = zzfuVar;
        zzaw zzawVar = new zzaw(this);
        zzawVar.q();
        this.f14039c = zzawVar;
        zzbq zzbqVar = new zzbq(this);
        zzbqVar.q();
        this.f14038b = zzbqVar;
        this.j.zzgs().a(new Ma(this, zzftVar));
    }

    private static void b(La la) {
        if (la != null) {
            if (la.n()) {
                return;
            }
            String valueOf = String.valueOf(la.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
        throw new IllegalStateException("Upload Component not created");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.Sa e(com.google.android.gms.measurement.internal.zzk r9) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfo.e(com.google.android.gms.measurement.internal.zzk):com.google.android.gms.measurement.internal.Sa");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String d(zzk zzkVar) {
        try {
            return (String) this.j.zzgs().a(new Pa(this, zzkVar)).get(com.umeng.commonsdk.proguard.c.f26227d, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
            this.j.b().q().a("Failed to get app instance id. appId", zzas.a(zzkVar.f14064a), e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(zzk zzkVar) {
        q();
        l();
        Preconditions.b(zzkVar.f14064a);
        e(zzkVar);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:185|(1:187)(1:209)|188|(7:193|194|(1:196)|197|(0)|42|(0)(0))|202|203|204|205|194|(0)|197|(0)|42|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x0231, code lost:            r0 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x0232, code lost:            r9.b().q().a("Error pruning currencies. appId", com.google.android.gms.measurement.internal.zzas.a(r15), r0);     */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0791 A[Catch: all -> 0x0803, TryCatch #0 {all -> 0x0803, blocks: (B:35:0x0106, B:38:0x0115, B:42:0x02ab, B:44:0x02e9, B:46:0x02ee, B:47:0x0307, B:51:0x0318, B:53:0x032e, B:55:0x0333, B:56:0x034e, B:61:0x0375, B:65:0x039b, B:66:0x03b4, B:69:0x03c4, B:72:0x03e7, B:73:0x0403, B:75:0x0411, B:77:0x041b, B:79:0x0427, B:81:0x042d, B:82:0x0438, B:84:0x0444, B:85:0x045b, B:87:0x0482, B:90:0x0492, B:93:0x04ce, B:94:0x04f6, B:97:0x0547, B:100:0x0569, B:102:0x057b, B:103:0x0585, B:105:0x0593, B:107:0x059d, B:109:0x05a1, B:110:0x060b, B:112:0x065a, B:114:0x0660, B:115:0x0662, B:117:0x066e, B:118:0x06d0, B:119:0x06ef, B:121:0x06f5, B:124:0x0728, B:125:0x0730, B:127:0x0738, B:128:0x073e, B:130:0x0744, B:134:0x078b, B:136:0x0791, B:137:0x07aa, B:139:0x07be, B:144:0x0752, B:146:0x0776, B:152:0x0795, B:153:0x05ae, B:155:0x05c0, B:157:0x05c4, B:159:0x05d6, B:160:0x0609, B:161:0x05ee, B:163:0x05f4, B:164:0x0563, B:165:0x0540, B:166:0x04e8, B:169:0x0124, B:172:0x0136, B:174:0x014d, B:180:0x0169, B:181:0x0195, B:183:0x019b, B:185:0x01a9, B:187:0x01b5, B:188:0x01bf, B:190:0x01ca, B:193:0x01d1, B:194:0x025a, B:196:0x0264, B:199:0x029c, B:202:0x01fb, B:204:0x021a, B:205:0x0243, B:208:0x0232, B:209:0x01ba, B:211:0x016e, B:212:0x018b), top: B:34:0x0106, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x07be A[Catch: all -> 0x0803, TRY_LEAVE, TryCatch #0 {all -> 0x0803, blocks: (B:35:0x0106, B:38:0x0115, B:42:0x02ab, B:44:0x02e9, B:46:0x02ee, B:47:0x0307, B:51:0x0318, B:53:0x032e, B:55:0x0333, B:56:0x034e, B:61:0x0375, B:65:0x039b, B:66:0x03b4, B:69:0x03c4, B:72:0x03e7, B:73:0x0403, B:75:0x0411, B:77:0x041b, B:79:0x0427, B:81:0x042d, B:82:0x0438, B:84:0x0444, B:85:0x045b, B:87:0x0482, B:90:0x0492, B:93:0x04ce, B:94:0x04f6, B:97:0x0547, B:100:0x0569, B:102:0x057b, B:103:0x0585, B:105:0x0593, B:107:0x059d, B:109:0x05a1, B:110:0x060b, B:112:0x065a, B:114:0x0660, B:115:0x0662, B:117:0x066e, B:118:0x06d0, B:119:0x06ef, B:121:0x06f5, B:124:0x0728, B:125:0x0730, B:127:0x0738, B:128:0x073e, B:130:0x0744, B:134:0x078b, B:136:0x0791, B:137:0x07aa, B:139:0x07be, B:144:0x0752, B:146:0x0776, B:152:0x0795, B:153:0x05ae, B:155:0x05c0, B:157:0x05c4, B:159:0x05d6, B:160:0x0609, B:161:0x05ee, B:163:0x05f4, B:164:0x0563, B:165:0x0540, B:166:0x04e8, B:169:0x0124, B:172:0x0136, B:174:0x014d, B:180:0x0169, B:181:0x0195, B:183:0x019b, B:185:0x01a9, B:187:0x01b5, B:188:0x01bf, B:190:0x01ca, B:193:0x01d1, B:194:0x025a, B:196:0x0264, B:199:0x029c, B:202:0x01fb, B:204:0x021a, B:205:0x0243, B:208:0x0232, B:209:0x01ba, B:211:0x016e, B:212:0x018b), top: B:34:0x0106, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0264 A[Catch: all -> 0x0803, TryCatch #0 {all -> 0x0803, blocks: (B:35:0x0106, B:38:0x0115, B:42:0x02ab, B:44:0x02e9, B:46:0x02ee, B:47:0x0307, B:51:0x0318, B:53:0x032e, B:55:0x0333, B:56:0x034e, B:61:0x0375, B:65:0x039b, B:66:0x03b4, B:69:0x03c4, B:72:0x03e7, B:73:0x0403, B:75:0x0411, B:77:0x041b, B:79:0x0427, B:81:0x042d, B:82:0x0438, B:84:0x0444, B:85:0x045b, B:87:0x0482, B:90:0x0492, B:93:0x04ce, B:94:0x04f6, B:97:0x0547, B:100:0x0569, B:102:0x057b, B:103:0x0585, B:105:0x0593, B:107:0x059d, B:109:0x05a1, B:110:0x060b, B:112:0x065a, B:114:0x0660, B:115:0x0662, B:117:0x066e, B:118:0x06d0, B:119:0x06ef, B:121:0x06f5, B:124:0x0728, B:125:0x0730, B:127:0x0738, B:128:0x073e, B:130:0x0744, B:134:0x078b, B:136:0x0791, B:137:0x07aa, B:139:0x07be, B:144:0x0752, B:146:0x0776, B:152:0x0795, B:153:0x05ae, B:155:0x05c0, B:157:0x05c4, B:159:0x05d6, B:160:0x0609, B:161:0x05ee, B:163:0x05f4, B:164:0x0563, B:165:0x0540, B:166:0x04e8, B:169:0x0124, B:172:0x0136, B:174:0x014d, B:180:0x0169, B:181:0x0195, B:183:0x019b, B:185:0x01a9, B:187:0x01b5, B:188:0x01bf, B:190:0x01ca, B:193:0x01d1, B:194:0x025a, B:196:0x0264, B:199:0x029c, B:202:0x01fb, B:204:0x021a, B:205:0x0243, B:208:0x0232, B:209:0x01ba, B:211:0x016e, B:212:0x018b), top: B:34:0x0106, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:199:0x029c A[Catch: all -> 0x0803, TRY_LEAVE, TryCatch #0 {all -> 0x0803, blocks: (B:35:0x0106, B:38:0x0115, B:42:0x02ab, B:44:0x02e9, B:46:0x02ee, B:47:0x0307, B:51:0x0318, B:53:0x032e, B:55:0x0333, B:56:0x034e, B:61:0x0375, B:65:0x039b, B:66:0x03b4, B:69:0x03c4, B:72:0x03e7, B:73:0x0403, B:75:0x0411, B:77:0x041b, B:79:0x0427, B:81:0x042d, B:82:0x0438, B:84:0x0444, B:85:0x045b, B:87:0x0482, B:90:0x0492, B:93:0x04ce, B:94:0x04f6, B:97:0x0547, B:100:0x0569, B:102:0x057b, B:103:0x0585, B:105:0x0593, B:107:0x059d, B:109:0x05a1, B:110:0x060b, B:112:0x065a, B:114:0x0660, B:115:0x0662, B:117:0x066e, B:118:0x06d0, B:119:0x06ef, B:121:0x06f5, B:124:0x0728, B:125:0x0730, B:127:0x0738, B:128:0x073e, B:130:0x0744, B:134:0x078b, B:136:0x0791, B:137:0x07aa, B:139:0x07be, B:144:0x0752, B:146:0x0776, B:152:0x0795, B:153:0x05ae, B:155:0x05c0, B:157:0x05c4, B:159:0x05d6, B:160:0x0609, B:161:0x05ee, B:163:0x05f4, B:164:0x0563, B:165:0x0540, B:166:0x04e8, B:169:0x0124, B:172:0x0136, B:174:0x014d, B:180:0x0169, B:181:0x0195, B:183:0x019b, B:185:0x01a9, B:187:0x01b5, B:188:0x01bf, B:190:0x01ca, B:193:0x01d1, B:194:0x025a, B:196:0x0264, B:199:0x029c, B:202:0x01fb, B:204:0x021a, B:205:0x0243, B:208:0x0232, B:209:0x01ba, B:211:0x016e, B:212:0x018b), top: B:34:0x0106, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x02e9 A[Catch: all -> 0x0803, TryCatch #0 {all -> 0x0803, blocks: (B:35:0x0106, B:38:0x0115, B:42:0x02ab, B:44:0x02e9, B:46:0x02ee, B:47:0x0307, B:51:0x0318, B:53:0x032e, B:55:0x0333, B:56:0x034e, B:61:0x0375, B:65:0x039b, B:66:0x03b4, B:69:0x03c4, B:72:0x03e7, B:73:0x0403, B:75:0x0411, B:77:0x041b, B:79:0x0427, B:81:0x042d, B:82:0x0438, B:84:0x0444, B:85:0x045b, B:87:0x0482, B:90:0x0492, B:93:0x04ce, B:94:0x04f6, B:97:0x0547, B:100:0x0569, B:102:0x057b, B:103:0x0585, B:105:0x0593, B:107:0x059d, B:109:0x05a1, B:110:0x060b, B:112:0x065a, B:114:0x0660, B:115:0x0662, B:117:0x066e, B:118:0x06d0, B:119:0x06ef, B:121:0x06f5, B:124:0x0728, B:125:0x0730, B:127:0x0738, B:128:0x073e, B:130:0x0744, B:134:0x078b, B:136:0x0791, B:137:0x07aa, B:139:0x07be, B:144:0x0752, B:146:0x0776, B:152:0x0795, B:153:0x05ae, B:155:0x05c0, B:157:0x05c4, B:159:0x05d6, B:160:0x0609, B:161:0x05ee, B:163:0x05f4, B:164:0x0563, B:165:0x0540, B:166:0x04e8, B:169:0x0124, B:172:0x0136, B:174:0x014d, B:180:0x0169, B:181:0x0195, B:183:0x019b, B:185:0x01a9, B:187:0x01b5, B:188:0x01bf, B:190:0x01ca, B:193:0x01d1, B:194:0x025a, B:196:0x0264, B:199:0x029c, B:202:0x01fb, B:204:0x021a, B:205:0x0243, B:208:0x0232, B:209:0x01ba, B:211:0x016e, B:212:0x018b), top: B:34:0x0106, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0316  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void b(com.google.android.gms.measurement.internal.zzag r27, com.google.android.gms.measurement.internal.zzk r28) {
        /*
            Method dump skipped, instructions count: 2062
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfo.b(com.google.android.gms.measurement.internal.zzag, com.google.android.gms.measurement.internal.zzk):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(zzft zzftVar) {
        this.j.zzgs().c();
        Xa xa = new Xa(this);
        xa.q();
        this.f14040d = xa;
        this.j.r().a(this.f14038b);
        Ua ua = new Ua(this);
        ua.q();
        this.f14043g = ua;
        C1413ea c1413ea = new C1413ea(this);
        c1413ea.q();
        this.i = c1413ea;
        zzfk zzfkVar = new zzfk(this);
        zzfkVar.q();
        this.f14042f = zzfkVar;
        this.f14041e = new C1424k(this);
        if (this.p != this.q) {
            this.j.b().q().a("Not all upload components initialized", Integer.valueOf(this.p), Integer.valueOf(this.q));
        }
        this.k = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0332 A[Catch: all -> 0x0449, TryCatch #4 {all -> 0x0449, blocks: (B:27:0x00a0, B:29:0x00ac, B:31:0x00c3, B:33:0x00eb, B:35:0x0135, B:39:0x0148, B:41:0x015c, B:44:0x0169, B:46:0x0173, B:47:0x01cd, B:49:0x01d2, B:51:0x01f1, B:54:0x0205, B:56:0x022e, B:57:0x023c, B:59:0x0269, B:60:0x026c, B:62:0x027a, B:64:0x027e, B:65:0x0283, B:67:0x028f, B:68:0x0344, B:70:0x035f, B:71:0x0362, B:72:0x03db, B:74:0x03eb, B:76:0x0401, B:77:0x0406, B:78:0x043a, B:83:0x02a6, B:86:0x02b3, B:88:0x02d4, B:90:0x02dc, B:92:0x02e4, B:93:0x02ea, B:96:0x02f4, B:98:0x0308, B:108:0x031a, B:100:0x0332, B:102:0x0338, B:103:0x033b, B:105:0x0341, B:114:0x02bc, B:120:0x037b, B:122:0x03ad, B:123:0x03b0, B:125:0x03be, B:127:0x03c2, B:128:0x03c7, B:129:0x041b, B:131:0x0421, B:133:0x01e1, B:135:0x0196, B:137:0x019e, B:139:0x01aa), top: B:26:0x00a0, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x041b A[Catch: all -> 0x0449, TryCatch #4 {all -> 0x0449, blocks: (B:27:0x00a0, B:29:0x00ac, B:31:0x00c3, B:33:0x00eb, B:35:0x0135, B:39:0x0148, B:41:0x015c, B:44:0x0169, B:46:0x0173, B:47:0x01cd, B:49:0x01d2, B:51:0x01f1, B:54:0x0205, B:56:0x022e, B:57:0x023c, B:59:0x0269, B:60:0x026c, B:62:0x027a, B:64:0x027e, B:65:0x0283, B:67:0x028f, B:68:0x0344, B:70:0x035f, B:71:0x0362, B:72:0x03db, B:74:0x03eb, B:76:0x0401, B:77:0x0406, B:78:0x043a, B:83:0x02a6, B:86:0x02b3, B:88:0x02d4, B:90:0x02dc, B:92:0x02e4, B:93:0x02ea, B:96:0x02f4, B:98:0x0308, B:108:0x031a, B:100:0x0332, B:102:0x0338, B:103:0x033b, B:105:0x0341, B:114:0x02bc, B:120:0x037b, B:122:0x03ad, B:123:0x03b0, B:125:0x03be, B:127:0x03c2, B:128:0x03c7, B:129:0x041b, B:131:0x0421, B:133:0x01e1, B:135:0x0196, B:137:0x019e, B:139:0x01aa), top: B:26:0x00a0, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01d2 A[Catch: all -> 0x0449, TryCatch #4 {all -> 0x0449, blocks: (B:27:0x00a0, B:29:0x00ac, B:31:0x00c3, B:33:0x00eb, B:35:0x0135, B:39:0x0148, B:41:0x015c, B:44:0x0169, B:46:0x0173, B:47:0x01cd, B:49:0x01d2, B:51:0x01f1, B:54:0x0205, B:56:0x022e, B:57:0x023c, B:59:0x0269, B:60:0x026c, B:62:0x027a, B:64:0x027e, B:65:0x0283, B:67:0x028f, B:68:0x0344, B:70:0x035f, B:71:0x0362, B:72:0x03db, B:74:0x03eb, B:76:0x0401, B:77:0x0406, B:78:0x043a, B:83:0x02a6, B:86:0x02b3, B:88:0x02d4, B:90:0x02dc, B:92:0x02e4, B:93:0x02ea, B:96:0x02f4, B:98:0x0308, B:108:0x031a, B:100:0x0332, B:102:0x0338, B:103:0x033b, B:105:0x0341, B:114:0x02bc, B:120:0x037b, B:122:0x03ad, B:123:0x03b0, B:125:0x03be, B:127:0x03c2, B:128:0x03c7, B:129:0x041b, B:131:0x0421, B:133:0x01e1, B:135:0x0196, B:137:0x019e, B:139:0x01aa), top: B:26:0x00a0, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01f1 A[Catch: all -> 0x0449, TRY_LEAVE, TryCatch #4 {all -> 0x0449, blocks: (B:27:0x00a0, B:29:0x00ac, B:31:0x00c3, B:33:0x00eb, B:35:0x0135, B:39:0x0148, B:41:0x015c, B:44:0x0169, B:46:0x0173, B:47:0x01cd, B:49:0x01d2, B:51:0x01f1, B:54:0x0205, B:56:0x022e, B:57:0x023c, B:59:0x0269, B:60:0x026c, B:62:0x027a, B:64:0x027e, B:65:0x0283, B:67:0x028f, B:68:0x0344, B:70:0x035f, B:71:0x0362, B:72:0x03db, B:74:0x03eb, B:76:0x0401, B:77:0x0406, B:78:0x043a, B:83:0x02a6, B:86:0x02b3, B:88:0x02d4, B:90:0x02dc, B:92:0x02e4, B:93:0x02ea, B:96:0x02f4, B:98:0x0308, B:108:0x031a, B:100:0x0332, B:102:0x0338, B:103:0x033b, B:105:0x0341, B:114:0x02bc, B:120:0x037b, B:122:0x03ad, B:123:0x03b0, B:125:0x03be, B:127:0x03c2, B:128:0x03c7, B:129:0x041b, B:131:0x0421, B:133:0x01e1, B:135:0x0196, B:137:0x019e, B:139:0x01aa), top: B:26:0x00a0, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x035f A[Catch: all -> 0x0449, TryCatch #4 {all -> 0x0449, blocks: (B:27:0x00a0, B:29:0x00ac, B:31:0x00c3, B:33:0x00eb, B:35:0x0135, B:39:0x0148, B:41:0x015c, B:44:0x0169, B:46:0x0173, B:47:0x01cd, B:49:0x01d2, B:51:0x01f1, B:54:0x0205, B:56:0x022e, B:57:0x023c, B:59:0x0269, B:60:0x026c, B:62:0x027a, B:64:0x027e, B:65:0x0283, B:67:0x028f, B:68:0x0344, B:70:0x035f, B:71:0x0362, B:72:0x03db, B:74:0x03eb, B:76:0x0401, B:77:0x0406, B:78:0x043a, B:83:0x02a6, B:86:0x02b3, B:88:0x02d4, B:90:0x02dc, B:92:0x02e4, B:93:0x02ea, B:96:0x02f4, B:98:0x0308, B:108:0x031a, B:100:0x0332, B:102:0x0338, B:103:0x033b, B:105:0x0341, B:114:0x02bc, B:120:0x037b, B:122:0x03ad, B:123:0x03b0, B:125:0x03be, B:127:0x03c2, B:128:0x03c7, B:129:0x041b, B:131:0x0421, B:133:0x01e1, B:135:0x0196, B:137:0x019e, B:139:0x01aa), top: B:26:0x00a0, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x03eb A[Catch: all -> 0x0449, TryCatch #4 {all -> 0x0449, blocks: (B:27:0x00a0, B:29:0x00ac, B:31:0x00c3, B:33:0x00eb, B:35:0x0135, B:39:0x0148, B:41:0x015c, B:44:0x0169, B:46:0x0173, B:47:0x01cd, B:49:0x01d2, B:51:0x01f1, B:54:0x0205, B:56:0x022e, B:57:0x023c, B:59:0x0269, B:60:0x026c, B:62:0x027a, B:64:0x027e, B:65:0x0283, B:67:0x028f, B:68:0x0344, B:70:0x035f, B:71:0x0362, B:72:0x03db, B:74:0x03eb, B:76:0x0401, B:77:0x0406, B:78:0x043a, B:83:0x02a6, B:86:0x02b3, B:88:0x02d4, B:90:0x02dc, B:92:0x02e4, B:93:0x02ea, B:96:0x02f4, B:98:0x0308, B:108:0x031a, B:100:0x0332, B:102:0x0338, B:103:0x033b, B:105:0x0341, B:114:0x02bc, B:120:0x037b, B:122:0x03ad, B:123:0x03b0, B:125:0x03be, B:127:0x03c2, B:128:0x03c7, B:129:0x041b, B:131:0x0421, B:133:0x01e1, B:135:0x0196, B:137:0x019e, B:139:0x01aa), top: B:26:0x00a0, inners: #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c(com.google.android.gms.measurement.internal.zzk r22) {
        /*
            Method dump skipped, instructions count: 1106
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfo.c(com.google.android.gms.measurement.internal.zzk):void");
    }

    @Override // com.google.android.gms.measurement.internal.Q
    public final Clock a() {
        return this.j.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(zzag zzagVar, String str) {
        Sa b2 = i().b(str);
        if (b2 != null && !TextUtils.isEmpty(b2.e())) {
            Boolean b3 = b(b2);
            if (b3 == null) {
                if (!"_ui".equals(zzagVar.f13897a)) {
                    this.j.b().t().a("Could not find package. appId", zzas.a(str));
                }
            } else if (!b3.booleanValue()) {
                this.j.b().q().a("App version does not match; dropping event. appId", zzas.a(str));
                return;
            }
            a(zzagVar, new zzk(str, b2.c(), b2.e(), b2.l(), b2.m(), b2.n(), b2.o(), (String) null, b2.d(), false, b2.b(), b2.B(), 0L, 0, b2.C(), b2.D(), false, b2.h()));
            return;
        }
        this.j.b().x().a("No app data available; dropping event", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(zzag zzagVar, zzk zzkVar) {
        List<zzo> a2;
        List<zzo> a3;
        List<zzo> a4;
        Preconditions.a(zzkVar);
        Preconditions.b(zzkVar.f14064a);
        q();
        l();
        String str = zzkVar.f14064a;
        long j = zzagVar.f13900d;
        if (g().a(zzagVar, zzkVar)) {
            if (!zzkVar.f14071h) {
                e(zzkVar);
                return;
            }
            i().r();
            try {
                Xa i = i();
                Preconditions.b(str);
                i.c();
                i.o();
                if (j < 0) {
                    i.b().t().a("Invalid time querying timed out conditional properties", zzas.a(str), Long.valueOf(j));
                    a2 = Collections.emptyList();
                } else {
                    a2 = i.a("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzo zzoVar : a2) {
                    if (zzoVar != null) {
                        this.j.b().x().a("User property timed out", zzoVar.f14073a, this.j.o().c(zzoVar.f14075c.f14052b), zzoVar.f14075c.getValue());
                        if (zzoVar.f14079g != null) {
                            b(new zzag(zzoVar.f14079g, j), zzkVar);
                        }
                        i().f(str, zzoVar.f14075c.f14052b);
                    }
                }
                Xa i2 = i();
                Preconditions.b(str);
                i2.c();
                i2.o();
                if (j < 0) {
                    i2.b().t().a("Invalid time querying expired conditional properties", zzas.a(str), Long.valueOf(j));
                    a3 = Collections.emptyList();
                } else {
                    a3 = i2.a("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(a3.size());
                for (zzo zzoVar2 : a3) {
                    if (zzoVar2 != null) {
                        this.j.b().x().a("User property expired", zzoVar2.f14073a, this.j.o().c(zzoVar2.f14075c.f14052b), zzoVar2.f14075c.getValue());
                        i().c(str, zzoVar2.f14075c.f14052b);
                        if (zzoVar2.k != null) {
                            arrayList.add(zzoVar2.k);
                        }
                        i().f(str, zzoVar2.f14075c.f14052b);
                    }
                }
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    b(new zzag((zzag) obj, j), zzkVar);
                }
                Xa i4 = i();
                String str2 = zzagVar.f13897a;
                Preconditions.b(str);
                Preconditions.b(str2);
                i4.c();
                i4.o();
                if (j < 0) {
                    i4.b().t().a("Invalid time querying triggered conditional properties", zzas.a(str), i4.g().a(str2), Long.valueOf(j));
                    a4 = Collections.emptyList();
                } else {
                    a4 = i4.a("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                ArrayList arrayList2 = new ArrayList(a4.size());
                for (zzo zzoVar3 : a4) {
                    if (zzoVar3 != null) {
                        zzfv zzfvVar = zzoVar3.f14075c;
                        Qa qa = new Qa(zzoVar3.f14073a, zzoVar3.f14074b, zzfvVar.f14052b, j, zzfvVar.getValue());
                        if (i().a(qa)) {
                            this.j.b().x().a("User property triggered", zzoVar3.f14073a, this.j.o().c(qa.f13679c), qa.f13681e);
                        } else {
                            this.j.b().q().a("Too many active user properties, ignoring", zzas.a(zzoVar3.f14073a), this.j.o().c(qa.f13679c), qa.f13681e);
                        }
                        if (zzoVar3.i != null) {
                            arrayList2.add(zzoVar3.i);
                        }
                        zzoVar3.f14075c = new zzfv(qa);
                        zzoVar3.f14077e = true;
                        i().a(zzoVar3);
                    }
                }
                b(zzagVar, zzkVar);
                int size2 = arrayList2.size();
                int i5 = 0;
                while (i5 < size2) {
                    Object obj2 = arrayList2.get(i5);
                    i5++;
                    b(new zzag((zzag) obj2, j), zzkVar);
                }
                i().u();
            } finally {
                i().s();
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:7|(7:9|(2:568|569)(1:11)|12|(1:14)(1:567)|15|16|(5:(1:19)|20|(2:25|(27:27|(3:28|29|(4:31|32|(6:34|(4:39|(1:43)|44|45)|47|(2:41|43)|44|45)(24:48|49|(2:51|(2:53|(6:55|(3:229|(1:226)(1:64)|(1:66)(9:225|131|(1:221)(7:134|(4:137|(2:139|140)(2:142|(2:144|145)(1:146))|141|135)|147|148|(2:150|(4:155|(1:157)(3:203|(4:209|(3:212|(2:215|216)(1:214)|210)|217|218)(0)|208)|(1:159)|160)(1:154))|220|160)|161|(5:163|(2:165|(1:(1:190)(2:172|173)))(2:191|(2:193|(1:(1:201)(2:200|173))))|(3:178|(2:183|(1:185)(1:186))|187)|188|189)|202|(4:176|178|(3:180|183|(0)(0))|187)|188|189))|58|(1:60)|226|(0)(0))(6:230|(4:232|(0)|226|(0)(0))|58|(0)|226|(0)(0)))(6:233|(4:235|(0)|226|(0)(0))|58|(0)|226|(0)(0)))(1:236)|67|(1:69)|70|71|(5:74|75|(2:77|78)(2:80|(2:82|83)(1:84))|79|72)|85|(1:224)(1:88)|(1:90)|91|(2:93|(2:94|(1:222)(2:96|(6:99|100|(1:102)|103|(1:105)|106)(1:98))))(1:223)|107|(4:112|(3:114|(2:116|117)(2:119|(2:121|122)(1:123))|118)|124|(1:(1:129)(1:130))(1:127))|131|(0)|221|161|(0)|202|(0)|188|189)|46)(1:237))|238|(4:240|(4:242|(2:244|(3:246|247|248))|(2:250|(2:256|257))(1:261)|248)|262|263)(1:488)|264|(1:266)|(8:268|(6:273|274|(2:275|(2:277|(2:280|281)(1:279))(2:287|288))|(1:283)|284|(1:286))|289|274|(3:275|(0)(0)|279)|(0)|284|(0))|290|(9:366|367|(5:369|(4:371|(1:373)|374|(6:376|(1:378)|379|(1:383)|384|385)(1:389))(5:391|(1:478)(3:394|395|(1:(2:397|(3:400|401|(1:405)(0))(1:399))(1:477)))|476|(1:407)(1:467)|(2:409|410)(7:411|(1:415)|416|(1:418)(1:466)|419|420|(4:422|423|(1:431)|432)(2:433|(4:435|(1:437)|438|439)(5:440|441|(3:443|(2:445|446)(1:462)|447)(3:463|(2:465|449)|461)|(4:451|(1:453)|454|455)(2:456|(2:458|459)(1:460))|388))))|386|387|388)|479|480|(1:482)|483|(2:486|484)|487)(1:292)|293|(6:296|(1:298)|299|(2:301|302)(1:304)|303|294)|305|306|(2:308|309)(2:346|(7:348|(1:350)(1:360)|351|(1:353)(1:359)|354|(1:356)(1:358)|357))|310|(5:312|(2:317|318)|319|(1:321)(1:322)|318)|323|(3:(2:327|328)(1:330)|329|324)|331|332|(1:334)|335|336|337|338|339|340)(4:489|490|491|492))|493|(0)(0))(4:494|495|496|497))(7:573|(1:575)(1:587)|576|(1:578)(1:586)|579|580|(5:(1:583)|20|(3:22|25|(0)(0))|493|(0)(0))(2:584|585))|498|499|(2:501|(1:503))(12:504|505|506|507|(1:509)|510|(1:512)(1:552)|513|514|515|(2:517|(1:519))|(8:520|521|522|523|524|(2:532|(1:534))|526|(2:528|(1:530))(1:531)))|20|(0)|493|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:448:0x0b04, code lost:            if (r26 != r14) goto L447;     */
    /* JADX WARN: Code restructure failed: missing block: B:560:0x024a, code lost:            r0 = e;     */
    /* JADX WARN: Code restructure failed: missing block: B:561:0x024b, code lost:            r8 = r4;     */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0672 A[Catch: all -> 0x0da7, TryCatch #4 {all -> 0x0da7, blocks: (B:3:0x000b, B:19:0x008a, B:20:0x0273, B:22:0x0277, B:27:0x0285, B:28:0x02b4, B:31:0x02c4, B:34:0x02e4, B:36:0x0317, B:41:0x032b, B:43:0x0333, B:46:0x0748, B:48:0x0359, B:51:0x036d, B:67:0x03c2, B:69:0x03c6, B:70:0x03cb, B:75:0x03db, B:77:0x03e7, B:79:0x0400, B:80:0x03f0, B:82:0x03f8, B:88:0x040b, B:90:0x044e, B:91:0x048a, B:94:0x04be, B:96:0x04c3, B:100:0x04cf, B:102:0x04d8, B:103:0x04de, B:105:0x04e1, B:106:0x04ea, B:98:0x04ed, B:107:0x04f2, B:110:0x04fc, B:112:0x052f, B:114:0x054e, B:118:0x0565, B:119:0x055c, B:127:0x056e, B:129:0x0581, B:130:0x058c, B:131:0x05a3, B:134:0x05b5, B:135:0x05ba, B:137:0x05bd, B:141:0x05d8, B:142:0x05cb, B:150:0x05de, B:152:0x05e4, B:154:0x05ea, B:159:0x063d, B:160:0x065c, B:161:0x0660, B:163:0x0672, B:165:0x067a, B:168:0x0687, B:170:0x069e, B:176:0x06e7, B:178:0x06ef, B:180:0x06f3, B:183:0x06f9, B:185:0x0704, B:186:0x071c, B:187:0x0725, B:188:0x073c, B:191:0x06ad, B:193:0x06b7, B:196:0x06c4, B:198:0x06db, B:203:0x0611, B:205:0x0617, B:210:0x0620, B:212:0x0626, B:214:0x0631, B:227:0x038b, B:230:0x0395, B:233:0x039f, B:242:0x0768, B:244:0x0774, B:246:0x077f, B:248:0x07af, B:250:0x0793, B:252:0x079c, B:254:0x07a0, B:256:0x07aa, B:264:0x07b7, B:266:0x07bf, B:268:0x07cb, B:270:0x07d9, B:273:0x07de, B:274:0x0821, B:275:0x083f, B:277:0x0844, B:281:0x0850, B:283:0x085c, B:286:0x087c, B:279:0x0856, B:289:0x0804, B:290:0x0894, B:371:0x08de, B:373:0x08f1, B:374:0x0900, B:376:0x0904, B:378:0x090e, B:379:0x091d, B:381:0x0921, B:383:0x0929, B:384:0x093a, B:395:0x0987, B:397:0x0991, B:401:0x099d, B:403:0x09a1, B:407:0x09d1, B:409:0x09e3, B:413:0x0a0b, B:415:0x0a1b, B:423:0x0a6e, B:425:0x0a76, B:427:0x0a7a, B:429:0x0a7e, B:431:0x0a82, B:435:0x0a97, B:437:0x0ab5, B:438:0x0abe, B:445:0x0ae6, B:468:0x09a9, B:470:0x09ad, B:472:0x09b5, B:474:0x09b9, B:399:0x09c3, B:503:0x0135, B:519:0x01d0, B:534:0x0204, B:530:0x0224, B:544:0x0270, B:558:0x0246, B:583:0x00e7, B:506:0x0148), top: B:2:0x000b, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x06e5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0704 A[Catch: all -> 0x0da7, TryCatch #4 {all -> 0x0da7, blocks: (B:3:0x000b, B:19:0x008a, B:20:0x0273, B:22:0x0277, B:27:0x0285, B:28:0x02b4, B:31:0x02c4, B:34:0x02e4, B:36:0x0317, B:41:0x032b, B:43:0x0333, B:46:0x0748, B:48:0x0359, B:51:0x036d, B:67:0x03c2, B:69:0x03c6, B:70:0x03cb, B:75:0x03db, B:77:0x03e7, B:79:0x0400, B:80:0x03f0, B:82:0x03f8, B:88:0x040b, B:90:0x044e, B:91:0x048a, B:94:0x04be, B:96:0x04c3, B:100:0x04cf, B:102:0x04d8, B:103:0x04de, B:105:0x04e1, B:106:0x04ea, B:98:0x04ed, B:107:0x04f2, B:110:0x04fc, B:112:0x052f, B:114:0x054e, B:118:0x0565, B:119:0x055c, B:127:0x056e, B:129:0x0581, B:130:0x058c, B:131:0x05a3, B:134:0x05b5, B:135:0x05ba, B:137:0x05bd, B:141:0x05d8, B:142:0x05cb, B:150:0x05de, B:152:0x05e4, B:154:0x05ea, B:159:0x063d, B:160:0x065c, B:161:0x0660, B:163:0x0672, B:165:0x067a, B:168:0x0687, B:170:0x069e, B:176:0x06e7, B:178:0x06ef, B:180:0x06f3, B:183:0x06f9, B:185:0x0704, B:186:0x071c, B:187:0x0725, B:188:0x073c, B:191:0x06ad, B:193:0x06b7, B:196:0x06c4, B:198:0x06db, B:203:0x0611, B:205:0x0617, B:210:0x0620, B:212:0x0626, B:214:0x0631, B:227:0x038b, B:230:0x0395, B:233:0x039f, B:242:0x0768, B:244:0x0774, B:246:0x077f, B:248:0x07af, B:250:0x0793, B:252:0x079c, B:254:0x07a0, B:256:0x07aa, B:264:0x07b7, B:266:0x07bf, B:268:0x07cb, B:270:0x07d9, B:273:0x07de, B:274:0x0821, B:275:0x083f, B:277:0x0844, B:281:0x0850, B:283:0x085c, B:286:0x087c, B:279:0x0856, B:289:0x0804, B:290:0x0894, B:371:0x08de, B:373:0x08f1, B:374:0x0900, B:376:0x0904, B:378:0x090e, B:379:0x091d, B:381:0x0921, B:383:0x0929, B:384:0x093a, B:395:0x0987, B:397:0x0991, B:401:0x099d, B:403:0x09a1, B:407:0x09d1, B:409:0x09e3, B:413:0x0a0b, B:415:0x0a1b, B:423:0x0a6e, B:425:0x0a76, B:427:0x0a7a, B:429:0x0a7e, B:431:0x0a82, B:435:0x0a97, B:437:0x0ab5, B:438:0x0abe, B:445:0x0ae6, B:468:0x09a9, B:470:0x09ad, B:472:0x09b5, B:474:0x09b9, B:399:0x09c3, B:503:0x0135, B:519:0x01d0, B:534:0x0204, B:530:0x0224, B:544:0x0270, B:558:0x0246, B:583:0x00e7, B:506:0x0148), top: B:2:0x000b, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x071c A[Catch: all -> 0x0da7, TryCatch #4 {all -> 0x0da7, blocks: (B:3:0x000b, B:19:0x008a, B:20:0x0273, B:22:0x0277, B:27:0x0285, B:28:0x02b4, B:31:0x02c4, B:34:0x02e4, B:36:0x0317, B:41:0x032b, B:43:0x0333, B:46:0x0748, B:48:0x0359, B:51:0x036d, B:67:0x03c2, B:69:0x03c6, B:70:0x03cb, B:75:0x03db, B:77:0x03e7, B:79:0x0400, B:80:0x03f0, B:82:0x03f8, B:88:0x040b, B:90:0x044e, B:91:0x048a, B:94:0x04be, B:96:0x04c3, B:100:0x04cf, B:102:0x04d8, B:103:0x04de, B:105:0x04e1, B:106:0x04ea, B:98:0x04ed, B:107:0x04f2, B:110:0x04fc, B:112:0x052f, B:114:0x054e, B:118:0x0565, B:119:0x055c, B:127:0x056e, B:129:0x0581, B:130:0x058c, B:131:0x05a3, B:134:0x05b5, B:135:0x05ba, B:137:0x05bd, B:141:0x05d8, B:142:0x05cb, B:150:0x05de, B:152:0x05e4, B:154:0x05ea, B:159:0x063d, B:160:0x065c, B:161:0x0660, B:163:0x0672, B:165:0x067a, B:168:0x0687, B:170:0x069e, B:176:0x06e7, B:178:0x06ef, B:180:0x06f3, B:183:0x06f9, B:185:0x0704, B:186:0x071c, B:187:0x0725, B:188:0x073c, B:191:0x06ad, B:193:0x06b7, B:196:0x06c4, B:198:0x06db, B:203:0x0611, B:205:0x0617, B:210:0x0620, B:212:0x0626, B:214:0x0631, B:227:0x038b, B:230:0x0395, B:233:0x039f, B:242:0x0768, B:244:0x0774, B:246:0x077f, B:248:0x07af, B:250:0x0793, B:252:0x079c, B:254:0x07a0, B:256:0x07aa, B:264:0x07b7, B:266:0x07bf, B:268:0x07cb, B:270:0x07d9, B:273:0x07de, B:274:0x0821, B:275:0x083f, B:277:0x0844, B:281:0x0850, B:283:0x085c, B:286:0x087c, B:279:0x0856, B:289:0x0804, B:290:0x0894, B:371:0x08de, B:373:0x08f1, B:374:0x0900, B:376:0x0904, B:378:0x090e, B:379:0x091d, B:381:0x0921, B:383:0x0929, B:384:0x093a, B:395:0x0987, B:397:0x0991, B:401:0x099d, B:403:0x09a1, B:407:0x09d1, B:409:0x09e3, B:413:0x0a0b, B:415:0x0a1b, B:423:0x0a6e, B:425:0x0a76, B:427:0x0a7a, B:429:0x0a7e, B:431:0x0a82, B:435:0x0a97, B:437:0x0ab5, B:438:0x0abe, B:445:0x0ae6, B:468:0x09a9, B:470:0x09ad, B:472:0x09b5, B:474:0x09b9, B:399:0x09c3, B:503:0x0135, B:519:0x01d0, B:534:0x0204, B:530:0x0224, B:544:0x0270, B:558:0x0246, B:583:0x00e7, B:506:0x0148), top: B:2:0x000b, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:225:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0277 A[Catch: all -> 0x0da7, TryCatch #4 {all -> 0x0da7, blocks: (B:3:0x000b, B:19:0x008a, B:20:0x0273, B:22:0x0277, B:27:0x0285, B:28:0x02b4, B:31:0x02c4, B:34:0x02e4, B:36:0x0317, B:41:0x032b, B:43:0x0333, B:46:0x0748, B:48:0x0359, B:51:0x036d, B:67:0x03c2, B:69:0x03c6, B:70:0x03cb, B:75:0x03db, B:77:0x03e7, B:79:0x0400, B:80:0x03f0, B:82:0x03f8, B:88:0x040b, B:90:0x044e, B:91:0x048a, B:94:0x04be, B:96:0x04c3, B:100:0x04cf, B:102:0x04d8, B:103:0x04de, B:105:0x04e1, B:106:0x04ea, B:98:0x04ed, B:107:0x04f2, B:110:0x04fc, B:112:0x052f, B:114:0x054e, B:118:0x0565, B:119:0x055c, B:127:0x056e, B:129:0x0581, B:130:0x058c, B:131:0x05a3, B:134:0x05b5, B:135:0x05ba, B:137:0x05bd, B:141:0x05d8, B:142:0x05cb, B:150:0x05de, B:152:0x05e4, B:154:0x05ea, B:159:0x063d, B:160:0x065c, B:161:0x0660, B:163:0x0672, B:165:0x067a, B:168:0x0687, B:170:0x069e, B:176:0x06e7, B:178:0x06ef, B:180:0x06f3, B:183:0x06f9, B:185:0x0704, B:186:0x071c, B:187:0x0725, B:188:0x073c, B:191:0x06ad, B:193:0x06b7, B:196:0x06c4, B:198:0x06db, B:203:0x0611, B:205:0x0617, B:210:0x0620, B:212:0x0626, B:214:0x0631, B:227:0x038b, B:230:0x0395, B:233:0x039f, B:242:0x0768, B:244:0x0774, B:246:0x077f, B:248:0x07af, B:250:0x0793, B:252:0x079c, B:254:0x07a0, B:256:0x07aa, B:264:0x07b7, B:266:0x07bf, B:268:0x07cb, B:270:0x07d9, B:273:0x07de, B:274:0x0821, B:275:0x083f, B:277:0x0844, B:281:0x0850, B:283:0x085c, B:286:0x087c, B:279:0x0856, B:289:0x0804, B:290:0x0894, B:371:0x08de, B:373:0x08f1, B:374:0x0900, B:376:0x0904, B:378:0x090e, B:379:0x091d, B:381:0x0921, B:383:0x0929, B:384:0x093a, B:395:0x0987, B:397:0x0991, B:401:0x099d, B:403:0x09a1, B:407:0x09d1, B:409:0x09e3, B:413:0x0a0b, B:415:0x0a1b, B:423:0x0a6e, B:425:0x0a76, B:427:0x0a7a, B:429:0x0a7e, B:431:0x0a82, B:435:0x0a97, B:437:0x0ab5, B:438:0x0abe, B:445:0x0ae6, B:468:0x09a9, B:470:0x09ad, B:472:0x09b5, B:474:0x09b9, B:399:0x09c3, B:503:0x0135, B:519:0x01d0, B:534:0x0204, B:530:0x0224, B:544:0x0270, B:558:0x0246, B:583:0x00e7, B:506:0x0148), top: B:2:0x000b, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0844 A[Catch: all -> 0x0da7, TryCatch #4 {all -> 0x0da7, blocks: (B:3:0x000b, B:19:0x008a, B:20:0x0273, B:22:0x0277, B:27:0x0285, B:28:0x02b4, B:31:0x02c4, B:34:0x02e4, B:36:0x0317, B:41:0x032b, B:43:0x0333, B:46:0x0748, B:48:0x0359, B:51:0x036d, B:67:0x03c2, B:69:0x03c6, B:70:0x03cb, B:75:0x03db, B:77:0x03e7, B:79:0x0400, B:80:0x03f0, B:82:0x03f8, B:88:0x040b, B:90:0x044e, B:91:0x048a, B:94:0x04be, B:96:0x04c3, B:100:0x04cf, B:102:0x04d8, B:103:0x04de, B:105:0x04e1, B:106:0x04ea, B:98:0x04ed, B:107:0x04f2, B:110:0x04fc, B:112:0x052f, B:114:0x054e, B:118:0x0565, B:119:0x055c, B:127:0x056e, B:129:0x0581, B:130:0x058c, B:131:0x05a3, B:134:0x05b5, B:135:0x05ba, B:137:0x05bd, B:141:0x05d8, B:142:0x05cb, B:150:0x05de, B:152:0x05e4, B:154:0x05ea, B:159:0x063d, B:160:0x065c, B:161:0x0660, B:163:0x0672, B:165:0x067a, B:168:0x0687, B:170:0x069e, B:176:0x06e7, B:178:0x06ef, B:180:0x06f3, B:183:0x06f9, B:185:0x0704, B:186:0x071c, B:187:0x0725, B:188:0x073c, B:191:0x06ad, B:193:0x06b7, B:196:0x06c4, B:198:0x06db, B:203:0x0611, B:205:0x0617, B:210:0x0620, B:212:0x0626, B:214:0x0631, B:227:0x038b, B:230:0x0395, B:233:0x039f, B:242:0x0768, B:244:0x0774, B:246:0x077f, B:248:0x07af, B:250:0x0793, B:252:0x079c, B:254:0x07a0, B:256:0x07aa, B:264:0x07b7, B:266:0x07bf, B:268:0x07cb, B:270:0x07d9, B:273:0x07de, B:274:0x0821, B:275:0x083f, B:277:0x0844, B:281:0x0850, B:283:0x085c, B:286:0x087c, B:279:0x0856, B:289:0x0804, B:290:0x0894, B:371:0x08de, B:373:0x08f1, B:374:0x0900, B:376:0x0904, B:378:0x090e, B:379:0x091d, B:381:0x0921, B:383:0x0929, B:384:0x093a, B:395:0x0987, B:397:0x0991, B:401:0x099d, B:403:0x09a1, B:407:0x09d1, B:409:0x09e3, B:413:0x0a0b, B:415:0x0a1b, B:423:0x0a6e, B:425:0x0a76, B:427:0x0a7a, B:429:0x0a7e, B:431:0x0a82, B:435:0x0a97, B:437:0x0ab5, B:438:0x0abe, B:445:0x0ae6, B:468:0x09a9, B:470:0x09ad, B:472:0x09b5, B:474:0x09b9, B:399:0x09c3, B:503:0x0135, B:519:0x01d0, B:534:0x0204, B:530:0x0224, B:544:0x0270, B:558:0x0246, B:583:0x00e7, B:506:0x0148), top: B:2:0x000b, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0285 A[Catch: all -> 0x0da7, TryCatch #4 {all -> 0x0da7, blocks: (B:3:0x000b, B:19:0x008a, B:20:0x0273, B:22:0x0277, B:27:0x0285, B:28:0x02b4, B:31:0x02c4, B:34:0x02e4, B:36:0x0317, B:41:0x032b, B:43:0x0333, B:46:0x0748, B:48:0x0359, B:51:0x036d, B:67:0x03c2, B:69:0x03c6, B:70:0x03cb, B:75:0x03db, B:77:0x03e7, B:79:0x0400, B:80:0x03f0, B:82:0x03f8, B:88:0x040b, B:90:0x044e, B:91:0x048a, B:94:0x04be, B:96:0x04c3, B:100:0x04cf, B:102:0x04d8, B:103:0x04de, B:105:0x04e1, B:106:0x04ea, B:98:0x04ed, B:107:0x04f2, B:110:0x04fc, B:112:0x052f, B:114:0x054e, B:118:0x0565, B:119:0x055c, B:127:0x056e, B:129:0x0581, B:130:0x058c, B:131:0x05a3, B:134:0x05b5, B:135:0x05ba, B:137:0x05bd, B:141:0x05d8, B:142:0x05cb, B:150:0x05de, B:152:0x05e4, B:154:0x05ea, B:159:0x063d, B:160:0x065c, B:161:0x0660, B:163:0x0672, B:165:0x067a, B:168:0x0687, B:170:0x069e, B:176:0x06e7, B:178:0x06ef, B:180:0x06f3, B:183:0x06f9, B:185:0x0704, B:186:0x071c, B:187:0x0725, B:188:0x073c, B:191:0x06ad, B:193:0x06b7, B:196:0x06c4, B:198:0x06db, B:203:0x0611, B:205:0x0617, B:210:0x0620, B:212:0x0626, B:214:0x0631, B:227:0x038b, B:230:0x0395, B:233:0x039f, B:242:0x0768, B:244:0x0774, B:246:0x077f, B:248:0x07af, B:250:0x0793, B:252:0x079c, B:254:0x07a0, B:256:0x07aa, B:264:0x07b7, B:266:0x07bf, B:268:0x07cb, B:270:0x07d9, B:273:0x07de, B:274:0x0821, B:275:0x083f, B:277:0x0844, B:281:0x0850, B:283:0x085c, B:286:0x087c, B:279:0x0856, B:289:0x0804, B:290:0x0894, B:371:0x08de, B:373:0x08f1, B:374:0x0900, B:376:0x0904, B:378:0x090e, B:379:0x091d, B:381:0x0921, B:383:0x0929, B:384:0x093a, B:395:0x0987, B:397:0x0991, B:401:0x099d, B:403:0x09a1, B:407:0x09d1, B:409:0x09e3, B:413:0x0a0b, B:415:0x0a1b, B:423:0x0a6e, B:425:0x0a76, B:427:0x0a7a, B:429:0x0a7e, B:431:0x0a82, B:435:0x0a97, B:437:0x0ab5, B:438:0x0abe, B:445:0x0ae6, B:468:0x09a9, B:470:0x09ad, B:472:0x09b5, B:474:0x09b9, B:399:0x09c3, B:503:0x0135, B:519:0x01d0, B:534:0x0204, B:530:0x0224, B:544:0x0270, B:558:0x0246, B:583:0x00e7, B:506:0x0148), top: B:2:0x000b, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:283:0x085c A[Catch: all -> 0x0da7, TryCatch #4 {all -> 0x0da7, blocks: (B:3:0x000b, B:19:0x008a, B:20:0x0273, B:22:0x0277, B:27:0x0285, B:28:0x02b4, B:31:0x02c4, B:34:0x02e4, B:36:0x0317, B:41:0x032b, B:43:0x0333, B:46:0x0748, B:48:0x0359, B:51:0x036d, B:67:0x03c2, B:69:0x03c6, B:70:0x03cb, B:75:0x03db, B:77:0x03e7, B:79:0x0400, B:80:0x03f0, B:82:0x03f8, B:88:0x040b, B:90:0x044e, B:91:0x048a, B:94:0x04be, B:96:0x04c3, B:100:0x04cf, B:102:0x04d8, B:103:0x04de, B:105:0x04e1, B:106:0x04ea, B:98:0x04ed, B:107:0x04f2, B:110:0x04fc, B:112:0x052f, B:114:0x054e, B:118:0x0565, B:119:0x055c, B:127:0x056e, B:129:0x0581, B:130:0x058c, B:131:0x05a3, B:134:0x05b5, B:135:0x05ba, B:137:0x05bd, B:141:0x05d8, B:142:0x05cb, B:150:0x05de, B:152:0x05e4, B:154:0x05ea, B:159:0x063d, B:160:0x065c, B:161:0x0660, B:163:0x0672, B:165:0x067a, B:168:0x0687, B:170:0x069e, B:176:0x06e7, B:178:0x06ef, B:180:0x06f3, B:183:0x06f9, B:185:0x0704, B:186:0x071c, B:187:0x0725, B:188:0x073c, B:191:0x06ad, B:193:0x06b7, B:196:0x06c4, B:198:0x06db, B:203:0x0611, B:205:0x0617, B:210:0x0620, B:212:0x0626, B:214:0x0631, B:227:0x038b, B:230:0x0395, B:233:0x039f, B:242:0x0768, B:244:0x0774, B:246:0x077f, B:248:0x07af, B:250:0x0793, B:252:0x079c, B:254:0x07a0, B:256:0x07aa, B:264:0x07b7, B:266:0x07bf, B:268:0x07cb, B:270:0x07d9, B:273:0x07de, B:274:0x0821, B:275:0x083f, B:277:0x0844, B:281:0x0850, B:283:0x085c, B:286:0x087c, B:279:0x0856, B:289:0x0804, B:290:0x0894, B:371:0x08de, B:373:0x08f1, B:374:0x0900, B:376:0x0904, B:378:0x090e, B:379:0x091d, B:381:0x0921, B:383:0x0929, B:384:0x093a, B:395:0x0987, B:397:0x0991, B:401:0x099d, B:403:0x09a1, B:407:0x09d1, B:409:0x09e3, B:413:0x0a0b, B:415:0x0a1b, B:423:0x0a6e, B:425:0x0a76, B:427:0x0a7a, B:429:0x0a7e, B:431:0x0a82, B:435:0x0a97, B:437:0x0ab5, B:438:0x0abe, B:445:0x0ae6, B:468:0x09a9, B:470:0x09ad, B:472:0x09b5, B:474:0x09b9, B:399:0x09c3, B:503:0x0135, B:519:0x01d0, B:534:0x0204, B:530:0x0224, B:544:0x0270, B:558:0x0246, B:583:0x00e7, B:506:0x0148), top: B:2:0x000b, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:286:0x087c A[Catch: all -> 0x0da7, TryCatch #4 {all -> 0x0da7, blocks: (B:3:0x000b, B:19:0x008a, B:20:0x0273, B:22:0x0277, B:27:0x0285, B:28:0x02b4, B:31:0x02c4, B:34:0x02e4, B:36:0x0317, B:41:0x032b, B:43:0x0333, B:46:0x0748, B:48:0x0359, B:51:0x036d, B:67:0x03c2, B:69:0x03c6, B:70:0x03cb, B:75:0x03db, B:77:0x03e7, B:79:0x0400, B:80:0x03f0, B:82:0x03f8, B:88:0x040b, B:90:0x044e, B:91:0x048a, B:94:0x04be, B:96:0x04c3, B:100:0x04cf, B:102:0x04d8, B:103:0x04de, B:105:0x04e1, B:106:0x04ea, B:98:0x04ed, B:107:0x04f2, B:110:0x04fc, B:112:0x052f, B:114:0x054e, B:118:0x0565, B:119:0x055c, B:127:0x056e, B:129:0x0581, B:130:0x058c, B:131:0x05a3, B:134:0x05b5, B:135:0x05ba, B:137:0x05bd, B:141:0x05d8, B:142:0x05cb, B:150:0x05de, B:152:0x05e4, B:154:0x05ea, B:159:0x063d, B:160:0x065c, B:161:0x0660, B:163:0x0672, B:165:0x067a, B:168:0x0687, B:170:0x069e, B:176:0x06e7, B:178:0x06ef, B:180:0x06f3, B:183:0x06f9, B:185:0x0704, B:186:0x071c, B:187:0x0725, B:188:0x073c, B:191:0x06ad, B:193:0x06b7, B:196:0x06c4, B:198:0x06db, B:203:0x0611, B:205:0x0617, B:210:0x0620, B:212:0x0626, B:214:0x0631, B:227:0x038b, B:230:0x0395, B:233:0x039f, B:242:0x0768, B:244:0x0774, B:246:0x077f, B:248:0x07af, B:250:0x0793, B:252:0x079c, B:254:0x07a0, B:256:0x07aa, B:264:0x07b7, B:266:0x07bf, B:268:0x07cb, B:270:0x07d9, B:273:0x07de, B:274:0x0821, B:275:0x083f, B:277:0x0844, B:281:0x0850, B:283:0x085c, B:286:0x087c, B:279:0x0856, B:289:0x0804, B:290:0x0894, B:371:0x08de, B:373:0x08f1, B:374:0x0900, B:376:0x0904, B:378:0x090e, B:379:0x091d, B:381:0x0921, B:383:0x0929, B:384:0x093a, B:395:0x0987, B:397:0x0991, B:401:0x099d, B:403:0x09a1, B:407:0x09d1, B:409:0x09e3, B:413:0x0a0b, B:415:0x0a1b, B:423:0x0a6e, B:425:0x0a76, B:427:0x0a7a, B:429:0x0a7e, B:431:0x0a82, B:435:0x0a97, B:437:0x0ab5, B:438:0x0abe, B:445:0x0ae6, B:468:0x09a9, B:470:0x09ad, B:472:0x09b5, B:474:0x09b9, B:399:0x09c3, B:503:0x0135, B:519:0x01d0, B:534:0x0204, B:530:0x0224, B:544:0x0270, B:558:0x0246, B:583:0x00e7, B:506:0x0148), top: B:2:0x000b, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0859 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:489:0x0d8a  */
    /* JADX WARN: Removed duplicated region for block: B:544:0x0270 A[Catch: all -> 0x0da7, TRY_ENTER, TryCatch #4 {all -> 0x0da7, blocks: (B:3:0x000b, B:19:0x008a, B:20:0x0273, B:22:0x0277, B:27:0x0285, B:28:0x02b4, B:31:0x02c4, B:34:0x02e4, B:36:0x0317, B:41:0x032b, B:43:0x0333, B:46:0x0748, B:48:0x0359, B:51:0x036d, B:67:0x03c2, B:69:0x03c6, B:70:0x03cb, B:75:0x03db, B:77:0x03e7, B:79:0x0400, B:80:0x03f0, B:82:0x03f8, B:88:0x040b, B:90:0x044e, B:91:0x048a, B:94:0x04be, B:96:0x04c3, B:100:0x04cf, B:102:0x04d8, B:103:0x04de, B:105:0x04e1, B:106:0x04ea, B:98:0x04ed, B:107:0x04f2, B:110:0x04fc, B:112:0x052f, B:114:0x054e, B:118:0x0565, B:119:0x055c, B:127:0x056e, B:129:0x0581, B:130:0x058c, B:131:0x05a3, B:134:0x05b5, B:135:0x05ba, B:137:0x05bd, B:141:0x05d8, B:142:0x05cb, B:150:0x05de, B:152:0x05e4, B:154:0x05ea, B:159:0x063d, B:160:0x065c, B:161:0x0660, B:163:0x0672, B:165:0x067a, B:168:0x0687, B:170:0x069e, B:176:0x06e7, B:178:0x06ef, B:180:0x06f3, B:183:0x06f9, B:185:0x0704, B:186:0x071c, B:187:0x0725, B:188:0x073c, B:191:0x06ad, B:193:0x06b7, B:196:0x06c4, B:198:0x06db, B:203:0x0611, B:205:0x0617, B:210:0x0620, B:212:0x0626, B:214:0x0631, B:227:0x038b, B:230:0x0395, B:233:0x039f, B:242:0x0768, B:244:0x0774, B:246:0x077f, B:248:0x07af, B:250:0x0793, B:252:0x079c, B:254:0x07a0, B:256:0x07aa, B:264:0x07b7, B:266:0x07bf, B:268:0x07cb, B:270:0x07d9, B:273:0x07de, B:274:0x0821, B:275:0x083f, B:277:0x0844, B:281:0x0850, B:283:0x085c, B:286:0x087c, B:279:0x0856, B:289:0x0804, B:290:0x0894, B:371:0x08de, B:373:0x08f1, B:374:0x0900, B:376:0x0904, B:378:0x090e, B:379:0x091d, B:381:0x0921, B:383:0x0929, B:384:0x093a, B:395:0x0987, B:397:0x0991, B:401:0x099d, B:403:0x09a1, B:407:0x09d1, B:409:0x09e3, B:413:0x0a0b, B:415:0x0a1b, B:423:0x0a6e, B:425:0x0a76, B:427:0x0a7a, B:429:0x0a7e, B:431:0x0a82, B:435:0x0a97, B:437:0x0ab5, B:438:0x0abe, B:445:0x0ae6, B:468:0x09a9, B:470:0x09ad, B:472:0x09b5, B:474:0x09b9, B:399:0x09c3, B:503:0x0135, B:519:0x01d0, B:534:0x0204, B:530:0x0224, B:544:0x0270, B:558:0x0246, B:583:0x00e7, B:506:0x0148), top: B:2:0x000b, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x03b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean a(java.lang.String r44, long r45) {
        /*
            Method dump skipped, instructions count: 3508
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfo.a(java.lang.String, long):boolean");
    }

    private final Boolean b(Sa sa) {
        try {
            if (sa.l() != -2147483648L) {
                if (sa.l() == Wrappers.a(this.j.getContext()).b(sa.f(), 0).versionCode) {
                    return true;
                }
            } else {
                String str = Wrappers.a(this.j.getContext()).b(sa.f(), 0).versionName;
                if (sa.e() != null && sa.e().equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(zzfv zzfvVar, zzk zzkVar) {
        q();
        l();
        if (TextUtils.isEmpty(zzkVar.f14065b) && TextUtils.isEmpty(zzkVar.r)) {
            return;
        }
        if (!zzkVar.f14071h) {
            e(zzkVar);
            return;
        }
        this.j.b().x().a("Removing user property", this.j.o().c(zzfvVar.f14052b));
        i().r();
        try {
            e(zzkVar);
            i().c(zzkVar.f14064a, zzfvVar.f14052b);
            i().u();
            this.j.b().x().a("User property removed", this.j.o().c(zzfvVar.f14052b));
        } finally {
            i().s();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(zzo zzoVar) {
        zzk a2 = a(zzoVar.f14073a);
        if (a2 != null) {
            b(zzoVar, a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(zzo zzoVar, zzk zzkVar) {
        Preconditions.a(zzoVar);
        Preconditions.b(zzoVar.f14073a);
        Preconditions.a(zzoVar.f14075c);
        Preconditions.b(zzoVar.f14075c.f14052b);
        q();
        l();
        if (TextUtils.isEmpty(zzkVar.f14065b) && TextUtils.isEmpty(zzkVar.r)) {
            return;
        }
        if (!zzkVar.f14071h) {
            e(zzkVar);
            return;
        }
        i().r();
        try {
            e(zzkVar);
            zzo e2 = i().e(zzoVar.f14073a, zzoVar.f14075c.f14052b);
            if (e2 != null) {
                this.j.b().x().a("Removing conditional user property", zzoVar.f14073a, this.j.o().c(zzoVar.f14075c.f14052b));
                i().f(zzoVar.f14073a, zzoVar.f14075c.f14052b);
                if (e2.f14077e) {
                    i().c(zzoVar.f14073a, zzoVar.f14075c.f14052b);
                }
                if (zzoVar.k != null) {
                    b(this.j.p().a(zzoVar.f14073a, zzoVar.k.f13897a, zzoVar.k.f13898b != null ? zzoVar.k.f13898b.a() : null, e2.f14074b, zzoVar.k.f13900d, true, false), zzkVar);
                }
            } else {
                this.j.b().t().a("Conditional user property doesn't exist", zzas.a(zzoVar.f14073a), this.j.o().c(zzoVar.f14075c.f14052b));
            }
            i().u();
        } finally {
            i().s();
        }
    }

    private final boolean a(com.google.android.gms.internal.measurement.zzft zzftVar, com.google.android.gms.internal.measurement.zzft zzftVar2) {
        Long l;
        Preconditions.a("_e".equals(zzftVar.name));
        g();
        com.google.android.gms.internal.measurement.zzfu a2 = zzfu.a(zzftVar, "_sc");
        String str = a2 == null ? null : a2.zzaml;
        g();
        com.google.android.gms.internal.measurement.zzfu a3 = zzfu.a(zzftVar2, "_pc");
        String str2 = a3 != null ? a3.zzaml : null;
        if (str2 == null || !str2.equals(str)) {
            return false;
        }
        g();
        com.google.android.gms.internal.measurement.zzfu a4 = zzfu.a(zzftVar, "_et");
        Long l2 = a4.zzaxe;
        if (l2 != null && l2.longValue() > 0) {
            long longValue = a4.zzaxe.longValue();
            g();
            com.google.android.gms.internal.measurement.zzfu a5 = zzfu.a(zzftVar2, "_et");
            if (a5 != null && (l = a5.zzaxe) != null && l.longValue() > 0) {
                longValue += a5.zzaxe.longValue();
            }
            g();
            zzftVar2.zzaxa = zzfu.a(zzftVar2.zzaxa, "_et", Long.valueOf(longValue));
            g();
            zzftVar.zzaxa = zzfu.a(zzftVar.zzaxa, "_fr", (Object) 1L);
        }
        return true;
    }

    @VisibleForTesting
    private static com.google.android.gms.internal.measurement.zzfu[] a(com.google.android.gms.internal.measurement.zzfu[] zzfuVarArr, String str) {
        int i = 0;
        while (true) {
            if (i >= zzfuVarArr.length) {
                i = -1;
                break;
            }
            if (str.equals(zzfuVarArr[i].name)) {
                break;
            }
            i++;
        }
        return i < 0 ? zzfuVarArr : a(zzfuVarArr, i);
    }

    @VisibleForTesting
    private static com.google.android.gms.internal.measurement.zzfu[] a(com.google.android.gms.internal.measurement.zzfu[] zzfuVarArr, int i) {
        com.google.android.gms.internal.measurement.zzfu[] zzfuVarArr2 = new com.google.android.gms.internal.measurement.zzfu[zzfuVarArr.length - 1];
        if (i > 0) {
            System.arraycopy(zzfuVarArr, 0, zzfuVarArr2, 0, i);
        }
        if (i < zzfuVarArr2.length) {
            System.arraycopy(zzfuVarArr, i + 1, zzfuVarArr2, i, zzfuVarArr2.length - i);
        }
        return zzfuVarArr2;
    }

    @VisibleForTesting
    private static com.google.android.gms.internal.measurement.zzfu[] a(com.google.android.gms.internal.measurement.zzfu[] zzfuVarArr, int i, String str) {
        for (com.google.android.gms.internal.measurement.zzfu zzfuVar : zzfuVarArr) {
            if ("_err".equals(zzfuVar.name)) {
                return zzfuVarArr;
            }
        }
        com.google.android.gms.internal.measurement.zzfu[] zzfuVarArr2 = new com.google.android.gms.internal.measurement.zzfu[zzfuVarArr.length + 2];
        System.arraycopy(zzfuVarArr, 0, zzfuVarArr2, 0, zzfuVarArr.length);
        com.google.android.gms.internal.measurement.zzfu zzfuVar2 = new com.google.android.gms.internal.measurement.zzfu();
        zzfuVar2.name = "_err";
        zzfuVar2.zzaxe = Long.valueOf(i);
        com.google.android.gms.internal.measurement.zzfu zzfuVar3 = new com.google.android.gms.internal.measurement.zzfu();
        zzfuVar3.name = "_ev";
        zzfuVar3.zzaml = str;
        zzfuVarArr2[zzfuVarArr2.length - 2] = zzfuVar2;
        zzfuVarArr2[zzfuVarArr2.length - 1] = zzfuVar3;
        return zzfuVarArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0158, code lost:            r9.j.q().f13802h.a(r9.j.a().a());     */
    @com.google.android.gms.common.util.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(int r10, java.lang.Throwable r11, byte[] r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 402
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfo.a(int, java.lang.Throwable, byte[], java.lang.String):void");
    }

    private final void a(Sa sa) {
        ArrayMap arrayMap;
        q();
        if (TextUtils.isEmpty(sa.c()) && (!zzq.u() || TextUtils.isEmpty(sa.h()))) {
            a(sa.f(), 204, null, null, null);
            return;
        }
        zzq r = this.j.r();
        Uri.Builder builder = new Uri.Builder();
        String c2 = sa.c();
        if (TextUtils.isEmpty(c2) && zzq.u()) {
            c2 = sa.h();
        }
        Uri.Builder encodedAuthority = builder.scheme(zzai.s.a()).encodedAuthority(zzai.t.a());
        String valueOf = String.valueOf(c2);
        encodedAuthority.path(valueOf.length() != 0 ? "config/app/".concat(valueOf) : new String("config/app/")).appendQueryParameter("app_instance_id", sa.a()).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", String.valueOf(r.l()));
        String uri = builder.build().toString();
        try {
            URL url = new URL(uri);
            this.j.b().y().a("Fetching remote configuration", sa.f());
            zzfp a2 = r().a(sa.f());
            String b2 = r().b(sa.f());
            if (a2 == null || TextUtils.isEmpty(b2)) {
                arrayMap = null;
            } else {
                ArrayMap arrayMap2 = new ArrayMap();
                arrayMap2.put("If-Modified-Since", b2);
                arrayMap = arrayMap2;
            }
            this.r = true;
            zzaw j = j();
            String f2 = sa.f();
            Oa oa = new Oa(this);
            j.c();
            j.o();
            Preconditions.a(url);
            Preconditions.a(oa);
            j.zzgs().b(new RunnableC1422j(j, f2, url, null, arrayMap, oa));
        } catch (MalformedURLException unused) {
            this.j.b().q().a("Failed to parse config URL. Not fetching. appId", zzas.a(sa.f()), uri);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b0, code lost:            r6.j.q().f13802h.a(r6.j.a().a());     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013a A[Catch: all -> 0x018d, TryCatch #1 {all -> 0x018d, blocks: (B:5:0x0029, B:12:0x0045, B:13:0x0179, B:23:0x0061, B:30:0x00b0, B:31:0x00c5, B:34:0x00cd, B:36:0x00d9, B:38:0x00df, B:42:0x00ec, B:47:0x0124, B:49:0x013a, B:50:0x0162, B:52:0x016c, B:54:0x0172, B:55:0x0176, B:56:0x014a, B:57:0x0103, B:59:0x010d), top: B:4:0x0029, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x014a A[Catch: all -> 0x018d, TryCatch #1 {all -> 0x018d, blocks: (B:5:0x0029, B:12:0x0045, B:13:0x0179, B:23:0x0061, B:30:0x00b0, B:31:0x00c5, B:34:0x00cd, B:36:0x00d9, B:38:0x00df, B:42:0x00ec, B:47:0x0124, B:49:0x013a, B:50:0x0162, B:52:0x016c, B:54:0x0172, B:55:0x0176, B:56:0x014a, B:57:0x0103, B:59:0x010d), top: B:4:0x0029, outer: #0 }] */
    @com.google.android.gms.common.util.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r11) {
        /*
            Method dump skipped, instructions count: 413
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfo.a(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Runnable runnable) {
        q();
        if (this.o == null) {
            this.o = new ArrayList();
        }
        this.o.add(runnable);
    }

    @VisibleForTesting
    private final int a(FileChannel fileChannel) {
        q();
        if (fileChannel != null && fileChannel.isOpen()) {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            try {
                fileChannel.position(0L);
                int read = fileChannel.read(allocate);
                if (read == 4) {
                    allocate.flip();
                    return allocate.getInt();
                }
                if (read != -1) {
                    this.j.b().t().a("Unexpected data length. Bytes read", Integer.valueOf(read));
                }
                return 0;
            } catch (IOException e2) {
                this.j.b().q().a("Failed to read from channel", e2);
                return 0;
            }
        }
        this.j.b().q().a("Bad channel to read from");
        return 0;
    }

    @VisibleForTesting
    private final boolean a(int i, FileChannel fileChannel) {
        q();
        if (fileChannel != null && fileChannel.isOpen()) {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.putInt(i);
            allocate.flip();
            try {
                fileChannel.truncate(0L);
                fileChannel.write(allocate);
                fileChannel.force(true);
                if (fileChannel.size() != 4) {
                    this.j.b().q().a("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
                }
                return true;
            } catch (IOException e2) {
                this.j.b().q().a("Failed to write to channel", e2);
                return false;
            }
        }
        this.j.b().q().a("Bad channel to read from");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final void a(zzk zzkVar) {
        if (this.w != null) {
            this.x = new ArrayList();
            this.x.addAll(this.w);
        }
        Xa i = i();
        String str = zzkVar.f14064a;
        Preconditions.b(str);
        i.c();
        i.o();
        try {
            SQLiteDatabase t = i.t();
            String[] strArr = {str};
            int delete = t.delete("apps", "app_id=?", strArr) + 0 + t.delete(com.umeng.analytics.pro.b.ao, "app_id=?", strArr) + t.delete("user_attributes", "app_id=?", strArr) + t.delete("conditional_properties", "app_id=?", strArr) + t.delete("raw_events", "app_id=?", strArr) + t.delete("raw_events_metadata", "app_id=?", strArr) + t.delete("queue", "app_id=?", strArr) + t.delete("audience_filter_values", "app_id=?", strArr) + t.delete("main_event_params", "app_id=?", strArr);
            if (delete > 0) {
                i.b().y().a("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e2) {
            i.b().q().a("Error resetting analytics data. appId, error", zzas.a(str), e2);
        }
        zzk a2 = a(this.j.getContext(), zzkVar.f14064a, zzkVar.f14065b, zzkVar.f14071h, zzkVar.o, zzkVar.p, zzkVar.m, zzkVar.r);
        if (!this.j.r().i(zzkVar.f14064a) || zzkVar.f14071h) {
            c(a2);
        }
    }

    private final zzk a(Context context, String str, String str2, boolean z, boolean z2, boolean z3, long j, String str3) {
        String str4;
        int i;
        String str5;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            this.j.b().q().a("PackageManager is null, can not log app install information");
            return null;
        }
        try {
            str4 = packageManager.getInstallerPackageName(str);
        } catch (IllegalArgumentException unused) {
            this.j.b().q().a("Error retrieving installer package name. appId", zzas.a(str));
            str4 = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
        if (str4 == null) {
            str4 = "manual_install";
        } else if ("com.android.vending".equals(str4)) {
            str4 = "";
        }
        String str6 = str4;
        try {
            PackageInfo b2 = Wrappers.a(context).b(str, 0);
            if (b2 != null) {
                CharSequence b3 = Wrappers.a(context).b(str);
                if (!TextUtils.isEmpty(b3)) {
                    b3.toString();
                }
                String str7 = b2.versionName;
                i = b2.versionCode;
                str5 = str7;
            } else {
                i = Integer.MIN_VALUE;
                str5 = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            }
            this.j.zzgw();
            return new zzk(str, str2, str5, i, str6, this.j.r().l(), this.j.p().a(context, str), (String) null, z, false, "", 0L, this.j.r().k(str) ? j : 0L, 0, z2, z3, false, str3);
        } catch (PackageManager.NameNotFoundException unused2) {
            this.j.b().q().a("Error retrieving newly installed package info. appId, appName", zzas.a(str), AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(zzfv zzfvVar, zzk zzkVar) {
        q();
        l();
        if (TextUtils.isEmpty(zzkVar.f14065b) && TextUtils.isEmpty(zzkVar.r)) {
            return;
        }
        if (!zzkVar.f14071h) {
            e(zzkVar);
            return;
        }
        int c2 = this.j.p().c(zzfvVar.f14052b);
        if (c2 != 0) {
            this.j.p();
            String a2 = zzfy.a(zzfvVar.f14052b, 24, true);
            String str = zzfvVar.f14052b;
            this.j.p().a(zzkVar.f14064a, c2, "_ev", a2, str != null ? str.length() : 0);
            return;
        }
        int b2 = this.j.p().b(zzfvVar.f14052b, zzfvVar.getValue());
        if (b2 != 0) {
            this.j.p();
            String a3 = zzfy.a(zzfvVar.f14052b, 24, true);
            Object value = zzfvVar.getValue();
            this.j.p().a(zzkVar.f14064a, b2, "_ev", a3, (value == null || !((value instanceof String) || (value instanceof CharSequence))) ? 0 : String.valueOf(value).length());
            return;
        }
        Object c3 = this.j.p().c(zzfvVar.f14052b, zzfvVar.getValue());
        if (c3 == null) {
            return;
        }
        if (this.j.r().p(zzkVar.f14064a) && "_sno".equals(zzfvVar.f14052b)) {
            long j = 0;
            Qa d2 = i().d(zzkVar.f14064a, "_sno");
            if (d2 != null) {
                Object obj = d2.f13681e;
                if (obj instanceof Long) {
                    j = ((Long) obj).longValue();
                    c3 = Long.valueOf(j + 1);
                }
            }
            C1404a b3 = i().b(zzkVar.f14064a, "_s");
            if (b3 != null) {
                j = b3.f13732c;
                this.j.b().y().a("Backfill the session number. Last used session number", Long.valueOf(j));
            }
            c3 = Long.valueOf(j + 1);
        }
        Qa qa = new Qa(zzkVar.f14064a, zzfvVar.f14057g, zzfvVar.f14052b, zzfvVar.f14053c, c3);
        this.j.b().x().a("Setting user property", this.j.o().c(qa.f13679c), c3);
        i().r();
        try {
            e(zzkVar);
            boolean a4 = i().a(qa);
            i().u();
            if (a4) {
                this.j.b().x().a("User property set", this.j.o().c(qa.f13679c), qa.f13681e);
            } else {
                this.j.b().q().a("Too many unique user properties are set. Ignoring user property", this.j.o().c(qa.f13679c), qa.f13681e);
                this.j.p().a(zzkVar.f14064a, 9, (String) null, (String) null, 0);
            }
        } finally {
            i().s();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(La la) {
        this.p++;
    }

    private final zzk a(String str) {
        Sa b2 = i().b(str);
        if (b2 != null && !TextUtils.isEmpty(b2.e())) {
            Boolean b3 = b(b2);
            if (b3 != null && !b3.booleanValue()) {
                this.j.b().q().a("App version does not match; dropping. appId", zzas.a(str));
                return null;
            }
            return new zzk(str, b2.c(), b2.e(), b2.l(), b2.m(), b2.n(), b2.o(), (String) null, b2.d(), false, b2.b(), b2.B(), 0L, 0, b2.C(), b2.D(), false, b2.h());
        }
        this.j.b().x().a("No app data available; dropping", str);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(zzo zzoVar) {
        zzk a2 = a(zzoVar.f14073a);
        if (a2 != null) {
            a(zzoVar, a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(zzo zzoVar, zzk zzkVar) {
        Preconditions.a(zzoVar);
        Preconditions.b(zzoVar.f14073a);
        Preconditions.a(zzoVar.f14074b);
        Preconditions.a(zzoVar.f14075c);
        Preconditions.b(zzoVar.f14075c.f14052b);
        q();
        l();
        if (TextUtils.isEmpty(zzkVar.f14065b) && TextUtils.isEmpty(zzkVar.r)) {
            return;
        }
        if (!zzkVar.f14071h) {
            e(zzkVar);
            return;
        }
        zzo zzoVar2 = new zzo(zzoVar);
        boolean z = false;
        zzoVar2.f14077e = false;
        i().r();
        try {
            zzo e2 = i().e(zzoVar2.f14073a, zzoVar2.f14075c.f14052b);
            if (e2 != null && !e2.f14074b.equals(zzoVar2.f14074b)) {
                this.j.b().t().a("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.j.o().c(zzoVar2.f14075c.f14052b), zzoVar2.f14074b, e2.f14074b);
            }
            if (e2 != null && e2.f14077e) {
                zzoVar2.f14074b = e2.f14074b;
                zzoVar2.f14076d = e2.f14076d;
                zzoVar2.f14080h = e2.f14080h;
                zzoVar2.f14078f = e2.f14078f;
                zzoVar2.i = e2.i;
                zzoVar2.f14077e = e2.f14077e;
                zzoVar2.f14075c = new zzfv(zzoVar2.f14075c.f14052b, e2.f14075c.f14053c, zzoVar2.f14075c.getValue(), e2.f14075c.f14057g);
            } else if (TextUtils.isEmpty(zzoVar2.f14078f)) {
                zzoVar2.f14075c = new zzfv(zzoVar2.f14075c.f14052b, zzoVar2.f14076d, zzoVar2.f14075c.getValue(), zzoVar2.f14075c.f14057g);
                zzoVar2.f14077e = true;
                z = true;
            }
            if (zzoVar2.f14077e) {
                zzfv zzfvVar = zzoVar2.f14075c;
                Qa qa = new Qa(zzoVar2.f14073a, zzoVar2.f14074b, zzfvVar.f14052b, zzfvVar.f14053c, zzfvVar.getValue());
                if (i().a(qa)) {
                    this.j.b().x().a("User property updated immediately", zzoVar2.f14073a, this.j.o().c(qa.f13679c), qa.f13681e);
                } else {
                    this.j.b().q().a("(2)Too many active user properties, ignoring", zzas.a(zzoVar2.f14073a), this.j.o().c(qa.f13679c), qa.f13681e);
                }
                if (z && zzoVar2.i != null) {
                    b(new zzag(zzoVar2.i, zzoVar2.f14076d), zzkVar);
                }
            }
            if (i().a(zzoVar2)) {
                this.j.b().x().a("Conditional property added", zzoVar2.f14073a, this.j.o().c(zzoVar2.f14075c.f14052b), zzoVar2.f14075c.getValue());
            } else {
                this.j.b().q().a("Too many conditional properties, ignoring", zzas.a(zzoVar2.f14073a), this.j.o().c(zzoVar2.f14075c.f14052b), zzoVar2.f14075c.getValue());
            }
            i().u();
        } finally {
            i().s();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(boolean z) {
        w();
    }
}
