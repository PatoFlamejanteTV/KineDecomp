package com.nexstreaming.app.general.tracelog;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.tracelog.TLP.BaseResponse;
import com.nextreaming.nexeditorui.EditorGlobal;
import java.net.URI;
import java.util.WeakHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class TLP<TREQUEST, TRESPONSE extends BaseResponse> {
    private static WeakHashMap<Object, TLPResponseInfo> k = new WeakHashMap<>();
    private final Class<TRESPONSE> b;
    private Context e;
    private boolean c = false;
    private boolean d = false;
    private TRESPONSE f = null;
    private long g = -1;
    private long h = -1;
    private long i = -1;
    private boolean j = false;

    /* renamed from: a, reason: collision with root package name */
    ResultTask<TRESPONSE> f3202a = null;

    /* loaded from: classes.dex */
    public interface BaseResponse {
        int getResult();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean a(ResponseCode responseCode);

    /* JADX INFO: Access modifiers changed from: protected */
    public TLP(Context context, Class<TRESPONSE> cls) {
        this.e = null;
        this.e = context.getApplicationContext();
        this.b = cls;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b<T> {

        /* renamed from: a, reason: collision with root package name */
        URI[] f3203a;
        T b;

        /* synthetic */ b(URI[] uriArr, Object obj, n nVar) {
            this(uriArr, obj);
        }

        private b(URI[] uriArr, T t) {
            this.f3203a = uriArr;
            this.b = t;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends Task.SimpleTaskError {
        public a(Exception exc, String str) {
            super(exc, str);
        }

        @Override // com.nexstreaming.app.general.task.Task.SimpleTaskError
        public String toString() {
            return getException() != null ? "<TaskIOError: " + getException().getClass().getName() + ">" : "<TaskIOError: " + getMessage() + ">";
        }
    }

    /* loaded from: classes.dex */
    public static class c extends Task.SimpleTaskError {
        public c(Exception exc, String str) {
            super(exc, str);
        }

        @Override // com.nexstreaming.app.general.task.Task.SimpleTaskError
        public String toString() {
            return getException() != null ? "<TaskParseError: " + getException().getClass().getName() + ">" : "<TaskParseError: " + getMessage() + ">";
        }
    }

    public ResultTask<TRESPONSE> a(URI[] uriArr, TREQUEST trequest) {
        return a(uriArr, (URI[]) trequest, false);
    }

    public ResultTask<TRESPONSE> b(URI[] uriArr, TREQUEST trequest) {
        return a(uriArr, (URI[]) trequest, true);
    }

    private ResultTask<TRESPONSE> a(URI[] uriArr, TREQUEST trequest, boolean z) {
        ResultTask<TRESPONSE> resultTask = null;
        boolean z2 = false;
        if (this.d && !z) {
            TRESPONSE f = f();
            long b2 = b();
            long a2 = a();
            long currentTimeMillis = System.currentTimeMillis();
            if (f != null && b2 > 0 && currentTimeMillis < b2) {
                a((TLP<TREQUEST, TRESPONSE>) f);
                z2 = true;
                resultTask = ResultTask.completedResultTask(f);
                if (a2 > 0 && currentTimeMillis < a2) {
                    return resultTask;
                }
            }
        }
        if (this.c && this.f3202a != null && this.f3202a.isRunning()) {
            return this.f3202a;
        }
        ResultTask<TRESPONSE> resultTask2 = z2 ? null : new ResultTask<>();
        if (this.c) {
            this.f3202a = resultTask2;
        }
        new n(this, resultTask2).executeOnExecutor(EditorGlobal.l, new b(uriArr, trequest, null));
        return !z2 ? resultTask2 : resultTask;
    }

    public void b(boolean z) {
        if (this.e != null) {
            this.d = z;
            h();
        }
    }

    public void c() {
        if (this.d && this.e != null) {
            this.f = null;
            this.g = -1L;
            this.j = false;
            PreferenceManager.getDefaultSharedPreferences(this.e).edit().remove(i()).remove(j()).remove(k()).apply();
        }
    }

    public TRESPONSE f() {
        if (!this.d || this.e == null) {
            return null;
        }
        h();
        return this.f;
    }

    /* loaded from: classes.dex */
    public static class TLPResponseInfo {
        public final long cacheExpiration;
        public final long cacheRefresh;
        public final long dataReceived;
        public final boolean fromCache;
        public final String originalSrc;

        /* JADX INFO: Access modifiers changed from: package-private */
        public TLPResponseInfo(boolean z, long j, long j2, long j3, String str) {
            this.fromCache = z;
            this.cacheExpiration = j;
            this.cacheRefresh = j2;
            this.dataReceived = j3;
            this.originalSrc = str;
        }
    }

    public static TLPResponseInfo a(Object obj) {
        return k.get(obj);
    }

    private void h() {
        if (!this.j && this.d && this.e != null) {
            this.j = true;
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.e);
            String string = defaultSharedPreferences.getString(i(), "");
            long j = defaultSharedPreferences.getLong(j(), -1L);
            long j2 = defaultSharedPreferences.getLong(k(), -1L);
            long j3 = defaultSharedPreferences.getLong(l(), -1L);
            String string2 = defaultSharedPreferences.getString(m(), "?");
            if (j > 0 && string != null && string.length() > 0) {
                try {
                    TRESPONSE tresponse = (TRESPONSE) new Gson().fromJson(string, (Class) this.b);
                    if (tresponse != null) {
                        k.put(tresponse, new TLPResponseInfo(true, j, j2, j3, string2));
                        this.f = tresponse;
                        this.g = j;
                        this.h = j2;
                        this.i = j3;
                    }
                } catch (JsonSyntaxException e) {
                }
            }
        }
    }

    public long b() {
        if (!this.d || this.e == null) {
            return -1L;
        }
        h();
        return this.g;
    }

    public long a() {
        if (!this.d || this.e == null) {
            return -1L;
        }
        h();
        return this.h;
    }

    public void a(TRESPONSE tresponse, long j, long j2) {
        if (this.d && this.e != null) {
            this.f = tresponse;
            this.g = j2;
            this.h = j;
            this.j = true;
            String str = "";
            TLPResponseInfo a2 = a((Object) tresponse);
            if (a2 != null) {
                str = a2.originalSrc;
            }
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.e);
            defaultSharedPreferences.edit().putString(i(), new Gson().toJson(tresponse)).putLong(j(), j2).putLong(k(), j).putLong(l(), System.currentTimeMillis()).putString(m(), str).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (str != null && this.e != null) {
            try {
                long optLong = new JSONObject(str).optLong("log_date");
                if (optLong > 0) {
                    Log.i("TLP", "saveLogDate() called with: " + getClass().getSimpleName() + " log_date = [" + optLong + "]");
                    com.nexstreaming.kinemaster.h.a.a(this.e, optLong);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private String i() {
        return "tlp_cached_data_" + this.b.getName() + d();
    }

    private String j() {
        return "tlp_cached_exp_" + this.b.getName() + d();
    }

    private String k() {
        return "tlp_cached_refresh_" + this.b.getName() + d();
    }

    private String l() {
        return "tlp_cached_lastupdate_" + this.b.getName() + d();
    }

    private String m() {
        return "tlp_cached_cachesrc_" + this.b.getName() + d();
    }

    public void a(boolean z) {
        this.c = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(TRESPONSE tresponse) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TRESPONSE tresponse) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Task.TaskError taskError, TRESPONSE tresponse) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean e() {
        return false;
    }

    protected String d() {
        return "";
    }
}
