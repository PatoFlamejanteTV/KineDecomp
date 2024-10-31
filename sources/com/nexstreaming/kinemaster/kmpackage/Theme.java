package com.nexstreaming.kinemaster.kmpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.LruCache;
import android.util.Pair;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.nexstreaming.app.general.expression.Expression;
import com.nexstreaming.app.general.expression.ExpressionEvalException;
import com.nexstreaming.app.general.expression.ExpressionParseException;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.kmpackage.KMTServerIndex;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class Theme extends am {
    private static final Executor E = Executors.newFixedThreadPool(3);
    private static LruCache<String, Bitmap> F = new LruCache<>(3);
    private static Map<String, WeakReference<Theme>> H = new HashMap();
    private static Map<String, Long> I = new HashMap();
    private static long J = 1;

    /* renamed from: a, reason: collision with root package name */
    private String f3427a;
    private String b;
    private String c;
    private String d;
    private String e;
    private URI f;
    private URI g;
    private String h;
    private String i;
    private ThemeEffectType n;
    private String o;
    private boolean p;
    private EffectLibrary q;
    private Task r;
    private Task s;
    private KMTServerIndex.Item t;
    private URI u;
    private boolean v;
    private List<Object> x;
    private List<KMTAuthRule> j = new ArrayList();
    private Map<ThemeEffectType, String> k = new HashMap();
    private ArrayList<Pair<Expression, String>> l = new ArrayList<>();
    private ArrayList<Pair<Expression, String>> m = new ArrayList<>();
    private boolean w = false;
    private long y = 0;
    private int z = -1;
    private int A = -1;
    private int B = 0;
    private int C = 0;
    private int D = -1;
    private Map<String, Map<String, String>> G = new HashMap();
    private long K = 0;
    private WeakReference<Bitmap> L = null;
    private ResultTask<Bitmap> M = null;

    public long a() {
        if (this.K != 0) {
            return this.K;
        }
        Long l = I.get(i());
        if (l == null) {
            l = Long.valueOf(J);
            I.put(i(), Long.valueOf(J));
            J++;
        }
        this.K = l.longValue();
        return l.longValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Theme b(String str) {
        Theme theme;
        WeakReference<Theme> weakReference = H.get(str);
        if (weakReference == null || (theme = weakReference.get()) == null) {
            Theme theme2 = new Theme(str);
            H.put(str, new WeakReference<>(theme2));
            return theme2;
        }
        return theme;
    }

    private Theme(String str) {
        this.f3427a = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        j();
        this.p = true;
        this.v = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(KMTServerIndex.Item item, URI uri, EffectLibrary effectLibrary, boolean z) {
        this.G = item.strings;
        this.p = false;
        this.q = effectLibrary;
        this.v = z;
        a(item, uri);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Theme theme) {
        if (theme != this) {
            if (!this.f3427a.equals(theme.f3427a)) {
                throw new RuntimeException("ID mismatch");
            }
            this.b = theme.b;
            this.c = theme.c;
            this.G = theme.G;
            this.k = theme.k;
            this.l = theme.l;
            this.m = theme.m;
            this.d = theme.d;
            this.y = theme.y;
        }
        this.p = true;
        this.v = false;
        this.x = null;
        if (theme != this) {
            j();
            a(theme.k());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(KMTServerIndex.Item item, URI uri) {
        long j;
        if (this.g == null) {
            this.g = uri.resolve("ext/" + item.thumbnail);
        }
        try {
            j = Long.parseLong(item.version);
        } catch (NumberFormatException e) {
            j = 0;
        }
        if (this.p && this.y < j) {
            this.w = true;
        } else {
            this.w = false;
        }
        this.f = uri.resolve("ext/" + item.preview);
        this.u = uri;
        this.t = item;
        this.f3427a = item.id;
        this.z = item.package_size;
        this.A = item.dependency_size;
        this.D = item.optional_dependency_size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(EffectLibrary effectLibrary) {
        this.q = effectLibrary;
    }

    @Override // com.nexstreaming.kinemaster.kmpackage.am
    protected KMTServerIndex.Item g() {
        return this.t;
    }

    @Override // com.nexstreaming.kinemaster.kmpackage.am
    protected URI h() {
        return this.u;
    }

    public int c() {
        return this.z < 0 ? k().g() : this.z;
    }

    public String a(EffectAutoSelectContext effectAutoSelectContext) {
        ArrayList<Pair<Expression, String>> arrayList;
        ar arVar = new ar(this, effectAutoSelectContext);
        if (effectAutoSelectContext instanceof TransitionEffectAutoSelectContext) {
            arrayList = this.l;
        } else {
            if (!(effectAutoSelectContext instanceof ClipEffectAutoSelectContext)) {
                return null;
            }
            arrayList = this.m;
        }
        Iterator<Pair<Expression, String>> it = arrayList.iterator();
        while (it.hasNext()) {
            Pair<Expression, String> next = it.next();
            Expression expression = (Expression) next.first;
            expression.a((com.nexstreaming.app.general.expression.ae) arVar);
            try {
                expression.a();
            } catch (ExpressionEvalException e) {
                e.printStackTrace();
            }
            if (expression.b()) {
                return (String) next.second;
            }
        }
        return null;
    }

    public String a(ThemeEffectType themeEffectType) {
        return this.k.get(themeEffectType);
    }

    public String[] d() {
        String[] strArr = new String[this.k.values().size() + this.l.size() + this.m.size()];
        Iterator<String> it = this.k.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            strArr[i] = it.next();
            i++;
        }
        Iterator<Pair<Expression, String>> it2 = this.l.iterator();
        while (it2.hasNext()) {
            strArr[i] = (String) it2.next().second;
            i++;
        }
        Iterator<Pair<Expression, String>> it3 = this.m.iterator();
        while (it3.hasNext()) {
            strArr[i] = (String) it3.next().second;
            i++;
        }
        return strArr;
    }

    public String a(Context context) {
        String a2 = a(context, ThemeStringType.NAME);
        if (a2 == null || a2.trim().length() < 1) {
            String i = i();
            if (i != null && i.length() > 25) {
                return "..." + i.substring(i.length() - 25);
            }
            return i;
        }
        return a2;
    }

    public String a(Context context, ThemeStringType themeStringType) {
        String lowerCase = themeStringType.name().toLowerCase(Locale.US);
        if (this.G.containsKey(lowerCase)) {
            return ah.a(context, this.G.get(lowerCase));
        }
        return null;
    }

    public URI e() {
        if (p()) {
            URI a2 = k().a(this.d, false);
            if (a2 == null || !new File(a2).exists()) {
                if (this.f != null) {
                    return this.f;
                }
                return null;
            }
            return a2;
        }
        return this.f;
    }

    public ResultTask<Bitmap> f() {
        if (this.M != null && this.M.isRunning()) {
            return this.M;
        }
        ResultTask<Bitmap> resultTask = new ResultTask<>();
        this.M = resultTask;
        Bitmap bitmap = null;
        if (this.L != null) {
            bitmap = this.L.get();
        }
        if (bitmap == null) {
            bitmap = F.get(i());
        }
        if (bitmap != null) {
            resultTask.setResult(bitmap);
            resultTask.signalEvent(Task.Event.COMPLETE);
            return resultTask;
        }
        new as(this, resultTask).executeOnExecutor(E, new Integer[0]);
        return resultTask;
    }

    public String i() {
        return this.f3427a;
    }

    @Override // com.nexstreaming.kinemaster.kmpackage.am
    protected void a(String str, ae aeVar, int i) throws KineMasterPackageException {
        if (str.equalsIgnoreCase("theme")) {
            this.f3427a = aeVar.a(ShareConstants.WEB_DIALOG_PARAM_ID);
            this.b = aeVar.a("icon");
            this.c = aeVar.a("music");
            this.d = aeVar.a("preview");
            this.y = aeVar.b(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION);
            this.e = aeVar.a("ratio");
            return;
        }
        if (str.equalsIgnoreCase("string")) {
            this.h = aeVar.a("locale");
            this.i = aeVar.a("name");
            if (this.h == null) {
                this.h = "en-us";
                return;
            }
            return;
        }
        if (str.equalsIgnoreCase("auth")) {
            this.j.add(new KMTAuthRule(aeVar));
        } else {
            if (str.equalsIgnoreCase("ref")) {
                this.n = (ThemeEffectType) an.a(aeVar.a("type"), ThemeEffectType.values());
                this.o = aeVar.a("cond");
                return;
            }
            throw new KineMasterPackageException("Unsupported element '" + str + "'");
        }
    }

    @Override // com.nexstreaming.kinemaster.kmpackage.am
    protected void a(String str, String str2, int i) throws KineMasterPackageException {
        if (str.equalsIgnoreCase("string") && this.i != null) {
            if (!this.G.containsKey(this.i)) {
                this.G.put(this.i, new HashMap());
            }
            this.G.get(this.i).put(this.h.toLowerCase(Locale.US), str2.trim());
            this.i = null;
            this.h = null;
            return;
        }
        if (str.equalsIgnoreCase("ref") && this.n != null) {
            if (this.o != null) {
                try {
                    if (this.n == ThemeEffectType.TRANSITION) {
                        this.l.add(new Pair<>(new Expression(this.o), str2));
                    } else {
                        this.m.add(new Pair<>(new Expression(this.o), str2));
                    }
                } catch (ExpressionParseException e) {
                    e.printStackTrace();
                }
            } else {
                this.k.put(this.n, str2);
            }
            this.n = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap z() {
        try {
            return BitmapFactory.decodeStream(new BufferedInputStream(this.g.toURL().openConnection().getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap m() {
        try {
            InputStream a2 = k().a(this.b);
            Bitmap decodeStream = BitmapFactory.decodeStream(a2);
            try {
                a2.close();
                return decodeStream;
            } catch (IOException e) {
                e.printStackTrace();
                return decodeStream;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String n() {
        return this.c;
    }

    public void o() {
    }

    public boolean p() {
        if (!this.p || k() == null || k().c()) {
            return false;
        }
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        if (this.p != z) {
            this.p = z;
            if (!this.p) {
                j();
            }
        }
    }

    public boolean q() {
        return this.w;
    }

    public boolean r() {
        return this.r != null && this.r.isRunning();
    }

    public int s() {
        if (p()) {
            return 100;
        }
        if (!r() || this.C < 1) {
            return 0;
        }
        return this.B;
    }

    public int t() {
        if (!p() && r() && this.C >= 1) {
            return this.C;
        }
        return 100;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2) {
        this.B = i;
        this.C = i2;
    }

    public Task u() {
        if (this.r != null && this.r.isRunning()) {
            return this.r;
        }
        this.r = new Task();
        this.B = 0;
        this.C = 100;
        if (this.s != null && this.s.isRunning()) {
            if (k().c()) {
                k().a(false);
                this.r.signalEvent(Task.Event.COMPLETE);
                return this.r;
            }
            this.r.signalEvent(Task.Event.FAIL);
            return this.r;
        }
        this.s = null;
        if (p() && !q()) {
            this.r.signalEvent(Task.Event.COMPLETE);
        } else if (this.q == null) {
            this.r.signalEvent(Task.Event.FAIL);
        } else {
            this.q.a(this, this.r);
        }
        return this.r;
    }

    public boolean v() {
        ai k = k();
        if (k == null) {
            return false;
        }
        return k.d();
    }

    public boolean w() {
        ai k = k();
        if (k == null) {
            return false;
        }
        return k.e();
    }

    /* loaded from: classes.dex */
    public enum UninstallError implements Task.TaskError {
        NotUninstallable,
        NoLibrary;

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public Exception getException() {
            return null;
        }

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public String getMessage() {
            return name();
        }

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public String getLocalizedMessage(Context context) {
            return getMessage();
        }
    }

    public Task x() {
        if (this.s != null && this.s.isRunning()) {
            return this.s;
        }
        this.s = new Task();
        if (!w()) {
            this.s.sendFailure(UninstallError.NotUninstallable);
            return this.s;
        }
        if (this.r != null && this.r.isRunning()) {
            return this.s;
        }
        this.r = null;
        if (!p()) {
            this.s.signalEvent(Task.Event.COMPLETE);
        } else if (this.q == null) {
            this.s.sendFailure(UninstallError.NoLibrary);
        } else {
            this.q.b(this, this.s);
        }
        return this.s;
    }

    @Override // com.nexstreaming.kinemaster.kmpackage.am
    protected void a(String str) {
    }
}
