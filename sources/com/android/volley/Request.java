package com.android.volley;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.android.volley.a;
import com.android.volley.m;
import com.android.volley.p;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class Request<T> implements Comparable<Request<T>> {

    /* renamed from: a */
    private final p.a f7973a;

    /* renamed from: b */
    private final int f7974b;

    /* renamed from: c */
    private final String f7975c;

    /* renamed from: d */
    private final int f7976d;

    /* renamed from: e */
    private final Object f7977e;

    /* renamed from: f */
    private m.a f7978f;

    /* renamed from: g */
    private Integer f7979g;

    /* renamed from: h */
    private l f7980h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private o m;
    private a.C0040a n;
    private a o;

    /* loaded from: classes.dex */
    public enum Priority {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(Request<?> request);

        void a(Request<?> request, m<?> mVar);
    }

    public Request(int i, String str, m.a aVar) {
        this.f7973a = p.a.f8093a ? new p.a() : null;
        this.f7977e = new Object();
        this.i = true;
        this.j = false;
        this.k = false;
        this.l = false;
        this.n = null;
        this.f7974b = i;
        this.f7975c = str;
        this.f7978f = aVar;
        a((o) new d());
        this.f7976d = c(str);
    }

    private static int c(String str) {
        Uri parse;
        String host;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null) {
            return 0;
        }
        return host.hashCode();
    }

    public boolean B() {
        boolean z;
        synchronized (this.f7977e) {
            z = this.j;
        }
        return z;
    }

    public void C() {
        synchronized (this.f7977e) {
            this.k = true;
        }
    }

    public void D() {
        a aVar;
        synchronized (this.f7977e) {
            aVar = this.o;
        }
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public final boolean E() {
        return this.i;
    }

    public final boolean F() {
        return this.l;
    }

    public abstract m<T> a(j jVar);

    public abstract void a(T t);

    public VolleyError b(VolleyError volleyError) {
        return volleyError;
    }

    public void b(String str) {
        l lVar = this.f7980h;
        if (lVar != null) {
            lVar.b(this);
        }
        if (p.a.f8093a) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new k(this, str, id));
            } else {
                this.f7973a.a(str, id);
                this.f7973a.a(toString());
            }
        }
    }

    public String d() {
        return "application/x-www-form-urlencoded; charset=" + j();
    }

    public a.C0040a e() {
        return this.n;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Request<?> f(int i) {
        this.f7979g = Integer.valueOf(i);
        return this;
    }

    public Map<String, String> g() throws AuthFailureError {
        return Collections.emptyMap();
    }

    public Priority getPriority() {
        return Priority.NORMAL;
    }

    public int h() {
        return this.f7974b;
    }

    protected Map<String, String> i() throws AuthFailureError {
        return null;
    }

    protected String j() {
        return "UTF-8";
    }

    @Deprecated
    public byte[] k() throws AuthFailureError {
        Map<String, String> l = l();
        if (l == null || l.size() <= 0) {
            return null;
        }
        return a(l, m());
    }

    @Deprecated
    protected Map<String, String> l() throws AuthFailureError {
        return i();
    }

    @Deprecated
    protected String m() {
        return j();
    }

    public o n() {
        return this.m;
    }

    public final int o() {
        return this.m.b();
    }

    public int p() {
        return this.f7976d;
    }

    public String q() {
        return this.f7975c;
    }

    public boolean t() {
        boolean z;
        synchronized (this.f7977e) {
            z = this.k;
        }
        return z;
    }

    public String toString() {
        String str = "0x" + Integer.toHexString(p());
        StringBuilder sb = new StringBuilder();
        sb.append(this.j ? "[X] " : "[ ] ");
        sb.append(q());
        sb.append(" ");
        sb.append(str);
        sb.append(" ");
        sb.append(getPriority());
        sb.append(" ");
        sb.append(this.f7979g);
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> a(o oVar) {
        this.m = oVar;
        return this;
    }

    public String f() {
        return q();
    }

    public void a(String str) {
        if (p.a.f8093a) {
            this.f7973a.a(str, Thread.currentThread().getId());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> a(l lVar) {
        this.f7980h = lVar;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> a(a.C0040a c0040a) {
        this.n = c0040a;
        return this;
    }

    public byte[] a() throws AuthFailureError {
        Map<String, String> i = i();
        if (i == null || i.size() <= 0) {
            return null;
        }
        return a(i, j());
    }

    private byte[] a(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append(URLEncoder.encode(entry.getKey(), str));
                sb.append('=');
                sb.append(URLEncoder.encode(entry.getValue(), str));
                sb.append('&');
            }
            return sb.toString().getBytes(str);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Encoding not supported: " + str, e2);
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(Request<T> request) {
        Priority priority = getPriority();
        Priority priority2 = request.getPriority();
        if (priority == priority2) {
            return this.f7979g.intValue() - request.f7979g.intValue();
        }
        return priority2.ordinal() - priority.ordinal();
    }

    public void a(VolleyError volleyError) {
        m.a aVar;
        synchronized (this.f7977e) {
            aVar = this.f7978f;
        }
        if (aVar != null) {
            aVar.a(volleyError);
        }
    }

    public void a(a aVar) {
        synchronized (this.f7977e) {
            this.o = aVar;
        }
    }

    public void a(m<?> mVar) {
        a aVar;
        synchronized (this.f7977e) {
            aVar = this.o;
        }
        if (aVar != null) {
            aVar.a(this, mVar);
        }
    }
}
