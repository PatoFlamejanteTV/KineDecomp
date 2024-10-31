package com.nexstreaming.app.general.tracelog;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.tracelog.TLP.BaseResponse;
import java.net.URI;
import java.util.WeakHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class TLP<TREQUEST, TRESPONSE extends BaseResponse> {

    /* renamed from: a */
    private static WeakHashMap<Object, TLPResponseInfo> f19769a = new WeakHashMap<>();

    /* renamed from: b */
    private final Class<TRESPONSE> f19770b;

    /* renamed from: e */
    private Context f19773e;

    /* renamed from: c */
    private boolean f19771c = false;

    /* renamed from: d */
    private boolean f19772d = false;

    /* renamed from: f */
    private TRESPONSE f19774f = null;

    /* renamed from: g */
    private long f19775g = -1;

    /* renamed from: h */
    private long f19776h = -1;
    private long i = -1;
    private boolean j = false;
    ResultTask<TRESPONSE> k = null;

    /* loaded from: classes2.dex */
    public interface BaseResponse {
        int getResult();
    }

    /* loaded from: classes2.dex */
    public static class TLPResponseInfo {
        public final long cacheExpiration;
        public final long cacheRefresh;
        public final long dataReceived;
        public final boolean fromCache;
        public final String originalSrc;

        public TLPResponseInfo(boolean z, long j, long j2, long j3, String str) {
            this.fromCache = z;
            this.cacheExpiration = j;
            this.cacheRefresh = j2;
            this.dataReceived = j3;
            this.originalSrc = str;
        }
    }

    /* loaded from: classes2.dex */
    public static class a extends Task.SimpleTaskError {
        public a(Exception exc, String str) {
            super(exc, str);
        }

        @Override // com.nexstreaming.app.general.task.Task.SimpleTaskError
        public String toString() {
            if (getException() != null) {
                return "<TaskIOError: " + getException().getClass().getName() + ">";
            }
            return "<TaskIOError: " + getMessage() + ">";
        }
    }

    /* loaded from: classes2.dex */
    public static class b<T> {

        /* renamed from: a */
        URI[] f19777a;

        /* renamed from: b */
        T f19778b;

        /* synthetic */ b(URI[] uriArr, Object obj, s sVar) {
            this(uriArr, obj);
        }

        private b(URI[] uriArr, T t) {
            this.f19777a = uriArr;
            this.f19778b = t;
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends Task.SimpleTaskError {
        public c(Exception exc, String str) {
            super(exc, str);
        }

        @Override // com.nexstreaming.app.general.task.Task.SimpleTaskError
        public String toString() {
            if (getException() != null) {
                return "<TaskParseError: " + getException().getClass().getName() + ">";
            }
            return "<TaskParseError: " + getMessage() + ">";
        }
    }

    public TLP(Context context, Class<TRESPONSE> cls) {
        this.f19773e = null;
        this.f19773e = context.getApplicationContext();
        this.f19770b = cls;
    }

    private void i() {
        Context context;
        if (this.j || !this.f19772d || (context = this.f19773e) == null) {
            return;
        }
        this.j = true;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String string = defaultSharedPreferences.getString(k(), "");
        long j = defaultSharedPreferences.getLong(l(), -1L);
        long j2 = defaultSharedPreferences.getLong(n(), -1L);
        long j3 = defaultSharedPreferences.getLong(m(), -1L);
        String string2 = defaultSharedPreferences.getString(j(), "?");
        long j4 = defaultSharedPreferences.getLong(o(), -1L);
        StringBuilder sb = new StringBuilder();
        sb.append(string);
        sb.append(j);
        sb.append(j2);
        sb.append(string2);
        if (j > 0 && string != null && string.length() > 0 && j4 == ((long) sb.toString().hashCode()) * ((long) FirebaseInstanceId.b().a().hashCode())) {
            try {
                TRESPONSE tresponse = (TRESPONSE) new Gson().fromJson(string, (Class) this.f19770b);
                if (tresponse != null) {
                    f19769a.put(tresponse, new TLPResponseInfo(true, j, j2, j3, string2));
                    this.f19774f = tresponse;
                    this.f19775g = j;
                    this.f19776h = j2;
                    this.i = j3;
                }
            } catch (JsonSyntaxException unused) {
            }
        }
    }

    private String j() {
        return "tlp_cached_cachesrc_" + this.f19770b.getName() + f();
    }

    private String k() {
        return "tlp_cached_data_" + this.f19770b.getName() + f();
    }

    private String l() {
        return "tlp_cached_exp_" + this.f19770b.getName() + f();
    }

    private String m() {
        return "tlp_cached_lastupdate_" + this.f19770b.getName() + f();
    }

    private String n() {
        return "tlp_cached_refresh_" + this.f19770b.getName() + f();
    }

    private String o() {
        return "tlp_cached_v_" + this.f19770b.getName() + f();
    }

    public void a(Task.TaskError taskError, TRESPONSE tresponse) {
    }

    public void a(TRESPONSE tresponse) {
    }

    public abstract boolean a(ResponseCode responseCode);

    public void b(TRESPONSE tresponse) {
    }

    public long e() {
        if (!this.f19772d || this.f19773e == null) {
            return -1L;
        }
        i();
        return this.f19776h;
    }

    protected String f() {
        return "";
    }

    public void g() {
        if (this.f19772d && this.f19773e != null) {
            this.f19774f = null;
            this.f19775g = -1L;
            this.j = false;
        }
    }

    public boolean h() {
        return false;
    }

    public ResultTask<TRESPONSE> b(URI[] uriArr, TREQUEST trequest) {
        return a(uriArr, (URI[]) trequest, true);
    }

    public TRESPONSE c() {
        if (!this.f19772d || this.f19773e == null) {
            return null;
        }
        i();
        return this.f19774f;
    }

    public long d() {
        if (!this.f19772d || this.f19773e == null) {
            return -1L;
        }
        i();
        return this.f19775g;
    }

    public void b() {
        if (this.f19772d && this.f19773e != null) {
            g();
            PreferenceManager.getDefaultSharedPreferences(this.f19773e).edit().remove(k()).remove(l()).remove(n()).apply();
        }
    }

    public ResultTask<TRESPONSE> a(URI[] uriArr, TREQUEST trequest) {
        return a(uriArr, (URI[]) trequest, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x004f  */
    @android.annotation.SuppressLint({"StaticFieldLeak"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.nexstreaming.app.general.task.ResultTask<TRESPONSE> a(java.net.URI[] r13, TREQUEST r14, boolean r15) {
        /*
            r12 = this;
            boolean r0 = r12.f19772d
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L38
            if (r15 != 0) goto L38
            com.nexstreaming.app.general.tracelog.TLP$BaseResponse r15 = r12.c()
            long r4 = r12.d()
            long r6 = r12.e()
            long r8 = java.lang.System.currentTimeMillis()
            if (r15 == 0) goto L38
            r10 = 0
            int r0 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r0 <= 0) goto L38
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 >= 0) goto L38
            r12.a(r15)
            com.nexstreaming.app.general.task.ResultTask r15 = com.nexstreaming.app.general.task.ResultTask.completedResultTask(r15)
            int r0 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r0 <= 0) goto L35
            int r0 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r0 >= 0) goto L35
            return r15
        L35:
            r0 = r15
            r15 = 1
            goto L3a
        L38:
            r0 = r3
            r15 = 0
        L3a:
            boolean r4 = r12.f19771c
            if (r4 == 0) goto L4b
            com.nexstreaming.app.general.task.ResultTask<TRESPONSE extends com.nexstreaming.app.general.tracelog.TLP$BaseResponse> r4 = r12.k
            if (r4 == 0) goto L4b
            boolean r4 = r4.isRunning()
            if (r4 == 0) goto L4b
            com.nexstreaming.app.general.task.ResultTask<TRESPONSE extends com.nexstreaming.app.general.tracelog.TLP$BaseResponse> r13 = r12.k
            return r13
        L4b:
            if (r15 == 0) goto L4f
            r4 = r3
            goto L54
        L4f:
            com.nexstreaming.app.general.task.ResultTask r4 = new com.nexstreaming.app.general.task.ResultTask
            r4.<init>()
        L54:
            boolean r5 = r12.f19771c
            if (r5 == 0) goto L5a
            r12.k = r4
        L5a:
            com.nexstreaming.app.general.tracelog.s r5 = new com.nexstreaming.app.general.tracelog.s
            r5.<init>(r12, r4)
            java.util.concurrent.Executor r6 = com.nextreaming.nexeditorui.EditorGlobal.C
            com.nexstreaming.app.general.tracelog.TLP$b[] r1 = new com.nexstreaming.app.general.tracelog.TLP.b[r1]
            com.nexstreaming.app.general.tracelog.TLP$b r7 = new com.nexstreaming.app.general.tracelog.TLP$b
            r7.<init>(r13, r14, r3)
            r1[r2] = r7
            r5.executeOnExecutor(r6, r1)
            if (r15 == 0) goto L70
            goto L71
        L70:
            r0 = r4
        L71:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.app.general.tracelog.TLP.a(java.net.URI[], java.lang.Object, boolean):com.nexstreaming.app.general.task.ResultTask");
    }

    public void b(boolean z) {
        this.f19771c = z;
    }

    public void a(boolean z) {
        if (this.f19773e == null) {
            return;
        }
        this.f19772d = z;
        i();
    }

    public static TLPResponseInfo a(Object obj) {
        return f19769a.get(obj);
    }

    public void a(TRESPONSE tresponse, long j, long j2) {
        if (this.f19772d && this.f19773e != null) {
            this.f19774f = tresponse;
            this.f19775g = j2;
            this.f19776h = j;
            this.j = true;
            TLPResponseInfo a2 = a((Object) tresponse);
            String str = a2 != null ? a2.originalSrc : "";
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f19773e);
            defaultSharedPreferences.edit().putString(k(), new Gson().toJson(tresponse)).putLong(l(), j2).putLong(n(), j).putLong(m(), System.currentTimeMillis()).putString(j(), str).putLong(o(), (r7 + j2 + j + str).hashCode() * FirebaseInstanceId.b().a().hashCode()).apply();
        }
    }

    public void a(String str) {
        if (str == null || this.f19773e == null) {
            return;
        }
        try {
            long optLong = new JSONObject(str).optLong("log_date");
            if (optLong > 0) {
                Log.i("TLP", "saveLogDate() called with: " + getClass().getSimpleName() + " log_date = [" + optLong + "]");
                c.d.b.m.i.a(this.f19773e, optLong);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
