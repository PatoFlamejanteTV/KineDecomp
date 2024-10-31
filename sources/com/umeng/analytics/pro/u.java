package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SessionIdManager.java */
/* loaded from: classes3.dex */
public class u {

    /* renamed from: c, reason: collision with root package name */
    private static volatile u f25968c;

    /* renamed from: a, reason: collision with root package name */
    private s f25969a = new t();

    /* renamed from: b, reason: collision with root package name */
    private String f25970b;

    /* renamed from: d, reason: collision with root package name */
    private List<a> f25971d;

    /* renamed from: e, reason: collision with root package name */
    private String f25972e;

    /* compiled from: SessionIdManager.java */
    /* loaded from: classes3.dex */
    public interface a {
        void a(String str, long j, long j2);

        void a(String str, String str2, long j, long j2);
    }

    private u() {
    }

    public static u a() {
        if (f25968c == null) {
            synchronized (u.class) {
                if (f25968c == null) {
                    f25968c = new u();
                }
            }
        }
        return f25968c;
    }

    private String f(Context context) {
        try {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(context).edit();
            edit.putString(q.f25956d, d(context));
            edit.commit();
        } catch (Exception unused) {
        }
        long h2 = h(context);
        long i = i(context);
        String str = this.f25970b;
        a(i, h2, str, false);
        this.f25970b = this.f25969a.a(context);
        a(i, h2, str, true);
        this.f25969a.a(context, this.f25970b);
        return this.f25970b;
    }

    private boolean g(Context context) {
        return !TextUtils.isEmpty(this.f25970b) && g.a(context).a(this.f25970b) > 0;
    }

    private long h(Context context) {
        return a(context, q.f25958f);
    }

    private long i(Context context) {
        return a(context, q.f25953a);
    }

    private boolean j(Context context) {
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(UMGlobalContext.getAppContext(context));
            long j = sharedPreferences.getLong(q.f25957e, 0L);
            long j2 = sharedPreferences.getLong(q.f25958f, 0L);
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> interval of last session is: " + (j2 - j));
            return this.f25969a.a(j, j2);
        } catch (Exception unused) {
            return false;
        }
    }

    public long b() {
        return this.f25969a.a();
    }

    public String c(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        try {
            this.f25970b = f(appContext);
        } catch (Exception unused) {
        }
        return this.f25970b;
    }

    public String d(Context context) {
        if (TextUtils.isEmpty(this.f25970b)) {
            try {
                this.f25970b = PreferenceWrapper.getDefault(context).getString(q.f25955c, null);
            } catch (Exception unused) {
            }
        }
        return this.f25970b;
    }

    public boolean e(Context context) {
        if (TextUtils.isEmpty(this.f25970b)) {
            this.f25970b = d(context);
        }
        return TextUtils.isEmpty(this.f25970b) || j(context) || g(context);
    }

    public synchronized String b(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        this.f25970b = d(appContext);
        if (e(appContext)) {
            try {
                this.f25970b = f(appContext);
            } catch (Exception unused) {
            }
        }
        return this.f25970b;
    }

    public void a(long j) {
        this.f25969a.a(j);
    }

    public String a(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        String str = "";
        try {
            synchronized (u.class) {
                str = PreferenceWrapper.getDefault(appContext).getString(q.f25956d, "");
            }
        } catch (Exception unused) {
        }
        return str;
    }

    public void b(a aVar) {
        List<a> list;
        if (aVar == null || (list = this.f25971d) == null || list.size() == 0) {
            return;
        }
        this.f25971d.remove(aVar);
    }

    public String a(Context context, long j) {
        if (TextUtils.isEmpty(this.f25972e)) {
            String str = "SUB" + j;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(String.format("%0" + (32 - str.length()) + com.umeng.commonsdk.proguard.e.am, 0));
            this.f25972e = sb.toString();
        }
        return this.f25972e;
    }

    private long a(Context context, String str) {
        long j;
        try {
            j = PreferenceWrapper.getDefault(context).getLong(str, 0L);
        } catch (Exception unused) {
            j = 0;
        }
        return j <= 0 ? System.currentTimeMillis() : j;
    }

    private void a(long j, long j2, String str, boolean z) {
        List<a> list = this.f25971d;
        if (list != null) {
            for (a aVar : list) {
                if (z) {
                    try {
                        aVar.a(str, this.f25970b, j, j2);
                    } catch (Exception unused) {
                    }
                } else {
                    aVar.a(this.f25970b, j, j2);
                }
            }
        }
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f25971d == null) {
            this.f25971d = new ArrayList();
        }
        if (this.f25971d.contains(aVar)) {
            return;
        }
        this.f25971d.add(aVar);
    }
}
