package com.nexstreaming.kinemaster.kmpackage;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;
import com.facebook.internal.Utility;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.kmpackage.KMTServerIndex;
import com.nexstreaming.kinemaster.kmpackage.OnFontChangeListener;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.av;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.ZipException;

/* loaded from: classes.dex */
public class EffectLibrary {
    private static String[] T;
    private File A;
    private String B;
    private z[] C;
    private z[] D;
    private z[] E;
    private long F;
    private URI L;
    private File O;
    private String P;
    private boolean Q;
    private boolean R;
    private String[] S;
    private List<Font> ac;
    private Task ad;
    private final Context g;
    private final File h;
    private final File i;
    private final File j;
    private final File k;
    private Task o;
    private Task p;
    private com.nextreaming.nexvideoeditor.a s;
    private ResultTask<Theme[]> t;

    /* renamed from: a */
    public static z f3411a = z.a(1);
    public static z b = z.a(2);
    private static String[] e = null;
    public static final boolean c = g();
    private static EffectLibrary f = null;
    private static Uri H = null;
    private static Map<String, String> I = null;
    private static Executor U = Executors.newSingleThreadExecutor();
    static final String[] d = {"com.nexstreaming.kinemaster.builtin.transition.slideleft", "com.nexstreaming.kinemaster.builtin.transition.slideright"};
    private static File V = null;
    private static File W = null;
    private static String X = null;
    private static z[] Y = null;
    private static z[] Z = null;
    private static z[] aa = null;
    private Map<String, Theme> l = new HashMap();
    private Map<String, com.nexstreaming.kinemaster.kmpackage.a> m = new HashMap();
    private Map<String, at> n = new HashMap();
    private int q = 0;
    private int r = 0;
    private List<d> u = new ArrayList();
    private final Object v = new Object();
    private ExecutorService w = Executors.newCachedThreadPool();
    private List<WeakReference<ap>> x = new ArrayList();
    private List<WeakReference<aq>> y = new ArrayList();
    private List<WeakReference<OnFontChangeListener>> z = new ArrayList();
    private List<String> G = new ArrayList();
    private Map<String, KMTServerIndex.FontList> J = null;
    private boolean K = false;
    private List<Font> M = new ArrayList();
    private Map<String, Map<String, String>> N = new HashMap();
    private List<y> ab = null;
    private int ae = 5000;
    private int af = 10000;
    private Map<File, c> ag = new HashMap();
    private int ah = 0;

    public static /* synthetic */ int g(EffectLibrary effectLibrary) {
        int i = effectLibrary.r;
        effectLibrary.r = i - 1;
        return i;
    }

    public static /* synthetic */ int j(EffectLibrary effectLibrary) {
        int i = effectLibrary.q;
        effectLibrary.q = i - 1;
        return i;
    }

    private static boolean g() {
        File file = new File(EditorGlobal.g(), "theme.cert");
        if (!file.exists()) {
            return false;
        }
        z[] zVarArr = {f3411a};
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                String[] split = new Scanner(file).useDelimiter("\\Z").next().split("[\r\n]");
                if (split.length < 1) {
                    return false;
                }
                String str = "";
                for (int i = 0; i < split.length - 1; i++) {
                    str = str + split[i];
                }
                if (!al.a(str, split[split.length - 1], zVarArr)) {
                    return false;
                }
                for (int i2 = 0; i2 < split.length - 1; i2++) {
                    int indexOf = split[i2].indexOf(61);
                    if (indexOf > 0) {
                        String lowerCase = split[i2].substring(0, indexOf).trim().toLowerCase(Locale.US);
                        String trim = split[i2].substring(indexOf + 1).trim();
                        if (lowerCase.equals("valid-until")) {
                            try {
                                return new SimpleDateFormat("yyyy-MM-dd").parse(trim).after(new Date());
                            } catch (ParseException e2) {
                                return false;
                            }
                        }
                    }
                }
                return false;
            } catch (FileNotFoundException e3) {
                return false;
            }
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: a */
        final File f3418a;
        final URI b;

        f(File file, URI uri) {
            this.f3418a = file;
            this.b = uri;
        }
    }

    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a */
        final Task f3416a;
        final List<f> b;
        final File c;

        public d(Task task, List<f> list, File file) {
            this.f3416a = task;
            this.b = list;
            this.c = file;
        }

        public String toString() {
            return "[InstallTaskWrapper@" + Integer.toHexString(System.identityHashCode(this)) + " " + (this.c == null ? "null" : String.valueOf(this.c.getName())) + " rf=" + (this.b == null ? "?" : Integer.valueOf(this.b.size())) + "]";
        }
    }

    public static void a(Map<String, String> map) {
        I = map;
    }

    public static void a(File file) {
        W = file;
        Z = null;
    }

    public static void a(String str) {
        Y = null;
        X = str;
    }

    public static void a(String... strArr) {
        T = strArr;
    }

    public void a(aq aqVar) {
        b((aq) null);
        this.y.add(new WeakReference<>(aqVar));
    }

    public void b(aq aqVar) {
        ArrayList arrayList = new ArrayList();
        for (WeakReference<aq> weakReference : this.y) {
            aq aqVar2 = weakReference.get();
            if (aqVar2 == null || aqVar2 == aqVar) {
                arrayList.add(weakReference);
            }
        }
        this.y.removeAll(arrayList);
    }

    public void a(Theme theme) {
        ArrayList arrayList = new ArrayList();
        for (WeakReference<aq> weakReference : this.y) {
            aq aqVar = weakReference.get();
            if (aqVar == null) {
                arrayList.add(weakReference);
            } else {
                aqVar.a(theme);
            }
        }
        this.y.removeAll(arrayList);
    }

    public void a(Theme theme, Task.TaskError taskError) {
        ArrayList arrayList = new ArrayList();
        for (WeakReference<aq> weakReference : this.y) {
            aq aqVar = weakReference.get();
            if (aqVar == null) {
                arrayList.add(weakReference);
            } else {
                aqVar.a(theme);
                aqVar.a(theme, taskError);
            }
        }
        this.y.removeAll(arrayList);
    }

    public void a(OnFontChangeListener onFontChangeListener) {
        b((OnFontChangeListener) null);
        this.z.add(new WeakReference<>(onFontChangeListener));
    }

    public void b(OnFontChangeListener onFontChangeListener) {
        ArrayList arrayList = new ArrayList();
        for (WeakReference<OnFontChangeListener> weakReference : this.z) {
            OnFontChangeListener onFontChangeListener2 = weakReference.get();
            if (onFontChangeListener2 == null || onFontChangeListener2 == onFontChangeListener) {
                arrayList.add(weakReference);
            }
        }
        this.z.removeAll(arrayList);
    }

    public void a(OnFontChangeListener.FontEvent fontEvent) {
        ArrayList arrayList = new ArrayList();
        for (WeakReference<OnFontChangeListener> weakReference : this.z) {
            OnFontChangeListener onFontChangeListener = weakReference.get();
            if (onFontChangeListener == null) {
                arrayList.add(weakReference);
            } else {
                onFontChangeListener.a(fontEvent);
            }
        }
        this.z.removeAll(arrayList);
    }

    public Font a(com.nexstreaming.kinemaster.kmpackage.b bVar) {
        String f2;
        if (bVar != null && (f2 = bVar.f()) != null) {
            for (Font font : h()) {
                if (font.a(f2)) {
                    return font;
                }
            }
            return null;
        }
        return null;
    }

    private List<Font> h() {
        if (this.ac == null) {
            this.ac = Arrays.asList(new Font("system.droidsans", "android", R.drawable.font_droid_sans, Typeface.create("Droid Sans", 0), "Droid Sans Regular"), new Font("system.droidsansb", "android", R.drawable.font_droid_sans_b, Typeface.create("Droid Sans", 1), "Droid Sans Bold"), new Font("system.droidserif", "android", R.drawable.font_droid_serif, Typeface.create(Typeface.SERIF, 0), "Droid Serif Regular"), new Font("system.droidserifb", "android", R.drawable.font_droid_serif_b, Typeface.create(Typeface.SERIF, 1), "Droid Serif Bold"), new Font("system.droidserifi", "android", R.drawable.font_droid_serif_i, Typeface.create(Typeface.SERIF, 2), "Droid Serif Italic"), new Font("system.droidserifbi", "android", R.drawable.font_droid_serif_bi, Typeface.create(Typeface.SERIF, 3), "Droid Serif Bold Italic"), new Font("builtin.font.bevan", "latin", R.drawable.font_bevan, "bevan.ttf", "Bevan"), new Font("builtin.font.creepster", "latin", R.drawable.font_creepster, "creepster-regular.ttf", "Creepster"), new Font("builtin.font.sortsmillgoudyital", "latin", R.drawable.font_sortsmillgoudyital, "goudy_stm_italic.ttf", "Sorts Mill Goudy Italic"), new Font("builtin.font.greatvibes", "latin", R.drawable.font_greatvibes, "greatvibes-regular.ttf", "Great Vibes"), new Font("builtin.font.junction", "latin", R.drawable.font_junction, "junction.ttf", "Junction"), new Font("builtin.font.knewave", "latin", R.drawable.font_knewave, "knewave.ttf", "Knewave"), new Font("builtin.font.latobold", "latin", R.drawable.font_latobold, "lato-bold.ttf", "Lato Bold"), new Font("builtin.font.leaguegothic", "latin", R.drawable.font_leaguegothic, "leaguegothic.ttf", "League Gothic"), new Font("builtin.font.leaguescriptthin", "latin", R.drawable.font_leaguescriptthin, "leaguescript.ttf", "League Script"), new Font("builtin.font.lindenhillregular", "latin", R.drawable.font_lindenhillregular, "lindenhill.ttf", "Linden Hill"), new Font("builtin.font.orbitronbold", "latin", R.drawable.font_orbitronbold, "orbitron-bold.ttf", "Orbitron Bold"), new Font("builtin.font.orbitronmedium", "latin", R.drawable.font_orbitronmedium, "orbitron-medium.ttf", "Orbitron Medium"), new Font("builtin.font.ralewaythin", "latin", R.drawable.font_ralewaythin, "raleway_thin.ttf", "Raleway Thin"), new Font("builtin.font.redressedregular", "latin", R.drawable.font_redressedregular, "redressed.ttf", "Redressed"), new Font("builtin.font.sniglet", "latin", R.drawable.font_sniglet, "sniglet.ttf", "Sniglet"));
        }
        return this.ac;
    }

    public Task a(boolean z) {
        if (this.ad != null && ((!this.ad.didSignalEvent(Task.Event.COMPLETE) || !z) && !this.ad.didSignalEvent(Task.Event.FAIL))) {
            return this.ad;
        }
        this.ad = new Task();
        if (this.K) {
            this.K = false;
            a(this.ad);
            return this.ad;
        }
        d().onComplete((Task.OnTaskEventListener) new m(this)).onFailure((Task.OnFailListener) new l(this));
        return this.ad;
    }

    public void a(Task task) {
        ArrayList arrayList = new ArrayList();
        if (this.J != null) {
            Iterator<KMTServerIndex.FontList> it = this.J.values().iterator();
            loop0: while (it.hasNext()) {
                for (KMTServerIndex.FontGroupInfo fontGroupInfo : it.next().groups) {
                    Iterator<Map.Entry<String, KMTServerIndex.FontInfo>> it2 = fontGroupInfo.fonts.entrySet().iterator();
                    while (it2.hasNext()) {
                        KMTServerIndex.FontInfo value = it2.next().getValue();
                        if (!new File(this.i, value.sample).exists()) {
                            arrayList.add(new f(new File(this.i, value.sample), this.L.resolve("ext/" + value.sample)));
                            if (arrayList.size() > 5) {
                                break loop0;
                            }
                        }
                    }
                }
            }
            if (arrayList.isEmpty()) {
                j();
                a(OnFontChangeListener.FontEvent.SERVER_UPDATE);
                if (task != null) {
                    task.signalEvent(Task.Event.SUCCESS, Task.Event.COMPLETE);
                    return;
                }
                return;
            }
            Task task2 = new Task();
            a(new d(task2, arrayList, null));
            task2.onComplete(new o(this, task)).onFailure(new n(this, task));
            m();
        }
    }

    private void a(d dVar) {
        synchronized (this.v) {
            this.u.add(dVar);
        }
    }

    private static Map<String, Integer> i() {
        HashMap hashMap = new HashMap();
        hashMap.put("latin", Integer.valueOf(R.string.fontcoll_latin));
        hashMap.put("hangul", Integer.valueOf(R.string.fontcoll_korean));
        hashMap.put("chs", Integer.valueOf(R.string.fontcoll_chs));
        hashMap.put("cht", Integer.valueOf(R.string.fontcoll_cht));
        hashMap.put("japanese", Integer.valueOf(R.string.fontcoll_jp));
        hashMap.put("android", Integer.valueOf(R.string.fontcoll_android));
        return hashMap;
    }

    public void j() {
        boolean z;
        b bVar;
        b bVar2;
        Map<String, Integer> i = i();
        HashMap hashMap = new HashMap();
        for (Font font : h()) {
            String n = font.n();
            b bVar3 = (b) hashMap.get(n);
            if (bVar3 == null) {
                Integer num = i.get(n);
                if (num == null) {
                    num = Integer.valueOf(R.string.fontcoll_other);
                }
                b bVar4 = new b(n, num.intValue());
                hashMap.put(n, bVar4);
                bVar3 = bVar4;
            }
            bVar3.c().add(font);
        }
        for (Font font2 : this.M) {
            String n2 = font2.n();
            b bVar5 = (b) hashMap.get(n2);
            if (bVar5 == null) {
                Integer num2 = i.get(n2);
                if (num2 == null) {
                    Map<String, String> map = this.N.get(n2);
                    if (map != null) {
                        bVar5 = new b(n2, map);
                    }
                } else {
                    bVar5 = new b(n2, num2.intValue());
                }
                hashMap.put(n2, bVar5);
            }
            bVar5.c().add(font2);
        }
        if (this.J != null) {
            Iterator<KMTServerIndex.FontList> it = this.J.values().iterator();
            while (it.hasNext()) {
                for (KMTServerIndex.FontGroupInfo fontGroupInfo : it.next().groups) {
                    b bVar6 = (b) hashMap.get(fontGroupInfo.id);
                    b bVar7 = bVar6;
                    for (Map.Entry<String, KMTServerIndex.FontInfo> entry : fontGroupInfo.fonts.entrySet()) {
                        String key = entry.getKey();
                        boolean z2 = false;
                        Iterator<Font> it2 = this.M.iterator();
                        while (true) {
                            z = z2;
                            if (!it2.hasNext()) {
                                break;
                            } else {
                                z2 = it2.next().m().equals(key) ? true : z;
                            }
                        }
                        if (!z) {
                            KMTServerIndex.FontInfo value = entry.getValue();
                            File file = new File(this.i, value.sample);
                            if (file.exists()) {
                                if (bVar7 == null) {
                                    Integer num3 = i.get(fontGroupInfo.id);
                                    if (num3 == null) {
                                        bVar2 = new b(fontGroupInfo.id, fontGroupInfo.labels);
                                    } else {
                                        bVar2 = new b(fontGroupInfo.id, num3.intValue());
                                    }
                                    hashMap.put(fontGroupInfo.id, bVar2);
                                    bVar = bVar2;
                                } else {
                                    bVar = bVar7;
                                }
                                bVar.c().add(new Font(key, bVar.b(), file, null, this, value.file, value.name));
                                bVar7 = bVar;
                            }
                        }
                    }
                }
            }
        }
        this.ab = Collections.unmodifiableList(new ArrayList(hashMap.values()));
    }

    public void a(Font font, Task task) {
        ArrayList arrayList = new ArrayList();
        File file = new File(this.h, font.a());
        arrayList.add(new f(file, this.L.resolve("ext/" + font.a())));
        Task task2 = new Task();
        a(new d(task2, arrayList, null));
        task2.onProgress(new r(this, task)).onComplete(new q(this, font, file, task)).onFailure(new p(this, task));
        m();
    }

    public void k() {
        StringBuilder sb = new StringBuilder();
        for (Font font : this.M) {
            sb.append('F');
            sb.append(font.m());
            sb.append((char) 27);
            sb.append(font.n());
            sb.append((char) 27);
            sb.append(font.b().getAbsolutePath());
            sb.append((char) 27);
            sb.append(font.c());
            sb.append((char) 27);
            sb.append(font.a((Context) null));
            sb.append('\n');
        }
        for (Map.Entry<String, Map<String, String>> entry : this.N.entrySet()) {
            Map<String, String> value = entry.getValue();
            sb.append('C');
            sb.append(entry.getKey());
            sb.append('\n');
            if (value != null) {
                for (Map.Entry<String, String> entry2 : value.entrySet()) {
                    sb.append('S');
                    sb.append(entry2.getKey());
                    sb.append(' ');
                    sb.append(entry2.getValue());
                    sb.append('\n');
                }
            }
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.O));
            try {
                bufferedWriter.write(sb.toString());
            } finally {
                bufferedWriter.close();
            }
        } catch (IOException e2) {
            Log.e("EffectLibrary", "Failed to write list of installed fonts", e2);
        }
    }

    public List<y> a() {
        if (this.ab == null) {
            j();
        }
        return this.ab;
    }

    public void l() {
        if (this.t != null && !this.t.isRunning()) {
            this.t = null;
        }
        ArrayList arrayList = new ArrayList();
        for (WeakReference<ap> weakReference : this.x) {
            ap apVar = weakReference.get();
            if (apVar == null) {
                arrayList.add(weakReference);
            } else {
                apVar.a();
            }
        }
        this.x.removeAll(arrayList);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:156:0x0178. Please report as an issue. */
    private EffectLibrary(Context context) {
        String[] split;
        HashMap hashMap;
        String[] strArr;
        File[] listFiles;
        this.C = null;
        this.D = null;
        this.E = null;
        e = av.a().e(com.nexstreaming.kinemaster.h.a.f(context) ? com.nexstreaming.kinemaster.tracelog.d.f : com.nexstreaming.kinemaster.tracelog.d.e);
        this.g = context;
        this.h = new File(this.g.getFilesDir(), ".km_packages");
        this.i = new File(this.h, "externals");
        if (T == null) {
            this.S = null;
        } else {
            this.S = new String[T.length];
            System.arraycopy(T, 0, this.S, 0, T.length);
        }
        if (aa == null) {
            this.E = new z[]{f3411a};
        } else {
            this.E = aa;
        }
        if (W == null) {
            this.j = null;
            this.k = null;
        } else {
            this.j = W;
            this.k = new File(this.j, "externals");
        }
        if (this.j != null) {
            this.j.mkdirs();
            this.k.mkdirs();
        }
        this.h.mkdirs();
        this.i.mkdirs();
        if (V == null) {
            this.A = new File(this.g.getCacheDir(), ".km_temp");
        } else {
            this.A = V;
        }
        if (X == null) {
            this.B = "km";
        } else {
            this.B = X;
        }
        if (Y == null) {
            this.C = new z[]{f3411a};
        } else {
            this.C = Y;
        }
        if (Z == null) {
            this.D = new z[]{f3411a, b};
        } else {
            this.D = Z;
        }
        this.A.mkdirs();
        this.o = new Task();
        this.p = new Task();
        i();
        this.O = new File(this.h, "installed_fonts");
        if (this.O.exists()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(this.O));
                try {
                    this.N.clear();
                    this.M.clear();
                    HashMap hashMap2 = null;
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            String trim = readLine.trim();
                            if (trim.length() > 0) {
                                switch (trim.charAt(0)) {
                                    case 'C':
                                        hashMap = new HashMap();
                                        this.N.put(trim.substring(1), hashMap);
                                        hashMap2 = hashMap;
                                        break;
                                    case 'F':
                                        if (trim.contains("\u001b")) {
                                            split = trim.substring(1).split("\u001b");
                                        } else {
                                            split = trim.substring(1).split(" ");
                                        }
                                        if (split.length < 4) {
                                            break;
                                        } else {
                                            this.M.add(new Font(split[0], split[1], new File(split[2]), new File(split[3]), this, null, split.length > 4 ? split[4] : "?"));
                                            hashMap = hashMap2;
                                            hashMap2 = hashMap;
                                            break;
                                        }
                                    case 'S':
                                        if (hashMap2 != null) {
                                            String[] split2 = trim.substring(1).split(" ");
                                            if (split2.length < 2) {
                                                break;
                                            } else {
                                                hashMap2.put(split2[0], split2[1]);
                                            }
                                        }
                                        hashMap = hashMap2;
                                        hashMap2 = hashMap;
                                        break;
                                    default:
                                        hashMap = hashMap2;
                                        hashMap2 = hashMap;
                                        break;
                                }
                            }
                        }
                    }
                } finally {
                    bufferedReader.close();
                }
            } catch (IOException e2) {
                Log.e("EffectLibrary", "Couldn't load list of installed fonts", e2);
            }
        }
        s sVar = new s(this);
        if (this.B != null) {
            try {
                strArr = this.g.getAssets().list(this.B);
            } catch (IOException e3) {
                e3.printStackTrace();
                strArr = null;
            }
            if (strArr != null) {
                if (this.S == null) {
                    for (String str : strArr) {
                        if (str.toLowerCase(Locale.US).endsWith(".kmt")) {
                            this.q++;
                            new ad().a(sVar).executeOnExecutor(U, new e(this.B + "/" + str, this.B + "/shared"));
                        }
                    }
                    this.p.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
                } else {
                    ArrayList<String> arrayList = new ArrayList();
                    ArrayList<String> arrayList2 = new ArrayList();
                    for (String str2 : strArr) {
                        boolean z = false;
                        String[] strArr2 = this.S;
                        int length = strArr2.length;
                        int i = 0;
                        while (true) {
                            if (i < length) {
                                if (!str2.startsWith(strArr2[i])) {
                                    i++;
                                } else {
                                    z = true;
                                }
                            }
                        }
                        if (z) {
                            arrayList.add(str2);
                        } else {
                            arrayList2.add(str2);
                        }
                    }
                    for (String str3 : arrayList) {
                        if (str3.toLowerCase(Locale.US).endsWith(".kmt")) {
                            this.q++;
                            this.r++;
                            new ad().a(true).a(sVar).executeOnExecutor(U, new e(this.B + "/" + str3, this.B + "/shared"));
                        }
                    }
                    for (String str4 : arrayList2) {
                        if (str4.toLowerCase(Locale.US).endsWith(".kmt")) {
                            this.q++;
                            new ad().a(sVar).executeOnExecutor(U, new e(this.B + "/" + str4, this.B + "/shared"));
                        }
                    }
                }
            }
        }
        if (this.h != null) {
            for (File file : this.h.listFiles()) {
                if (file.getName().toLowerCase(Locale.US).endsWith(".kmt")) {
                    try {
                        new ad().a(sVar).executeOnExecutor(U, new ao(file, this.i, this.E, true));
                        this.q++;
                    } catch (ZipException e4) {
                        e4.printStackTrace();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
            }
        }
        if (this.j != null && (listFiles = this.j.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.getName().toLowerCase(Locale.US).endsWith(".kmt")) {
                    try {
                        new ad().a(sVar).executeOnExecutor(U, new ao(file2, this.k, this.D, false));
                        this.q++;
                    } catch (ZipException e6) {
                        e6.printStackTrace();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                } else if (c) {
                    try {
                        new ad().a(sVar).executeOnExecutor(U, new ac(file2, this.k));
                        this.q++;
                    } catch (ZipException e8) {
                        e8.printStackTrace();
                    } catch (IOException e9) {
                        e9.printStackTrace();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e implements ak {
        private final String b;
        private final String c;

        public e(String str, String str2) {
            this.b = str;
            this.c = str2;
        }

        @Override // com.nexstreaming.kinemaster.kmpackage.ak
        public ag a(String str) throws IOException {
            return new ag(EffectLibrary.this.g.getAssets().open(this.b + "/" + str));
        }

        @Override // com.nexstreaming.kinemaster.kmpackage.ak
        public ag b(String str) throws IOException {
            return new ag(EffectLibrary.this.g.getAssets().open(this.c + "/" + str));
        }

        @Override // com.nexstreaming.kinemaster.kmpackage.ak
        public boolean c(String str) {
            try {
                EffectLibrary.this.g.getAssets().open(this.c + "/" + str).close();
                return true;
            } catch (IOException e) {
                return false;
            }
        }

        @Override // com.nexstreaming.kinemaster.kmpackage.ak
        public z[] a() {
            return EffectLibrary.this.C;
        }

        @Override // com.nexstreaming.kinemaster.kmpackage.ak
        public URI a(String str, boolean z) {
            try {
                File b = b(str, z);
                if (b == null) {
                    return null;
                }
                return b.toURI();
            } catch (IOException e) {
                return null;
            }
        }

        private File b(String str, boolean z) throws IOException {
            File file = new File(EffectLibrary.this.A, "sa_" + str.replaceAll("[^A-Za-z0-9_]", "") + str.hashCode() + "_.tmp");
            if (!file.exists()) {
                if (!z) {
                    return null;
                }
                InputStream inputStream = b(str).f3434a;
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[10240];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read > -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.close();
                        inputStream.close();
                        return file;
                    }
                }
            } else {
                return file;
            }
        }

        @Override // com.nexstreaming.kinemaster.kmpackage.ak
        public String b() {
            int lastIndexOf = this.b.lastIndexOf(47);
            return lastIndexOf > -1 ? this.b.substring(lastIndexOf + 1) : this.b;
        }

        @Override // com.nexstreaming.kinemaster.kmpackage.ak
        public boolean c() {
            return true;
        }

        @Override // com.nexstreaming.kinemaster.kmpackage.ak
        public boolean d() {
            return false;
        }

        @Override // com.nexstreaming.kinemaster.kmpackage.ak
        public boolean e() {
            throw new IllegalAccessError();
        }

        @Override // com.nexstreaming.kinemaster.kmpackage.ak
        public int f() {
            return 0;
        }
    }

    private synchronized void c(boolean z) {
        Iterator<Theme> it = this.l.values().iterator();
        while (it.hasNext()) {
            it.next().o();
        }
        Iterator<com.nexstreaming.kinemaster.kmpackage.a> it2 = this.m.values().iterator();
        while (it2.hasNext()) {
            it2.next().i();
        }
        Iterator<at> it3 = this.n.values().iterator();
        while (it3.hasNext()) {
            it3.next().i();
        }
    }

    public static void b(boolean z) {
        if (f != null) {
            f.c(z);
        }
        if (z) {
        }
    }

    public static EffectLibrary a(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (f != null && !f.g.getPackageName().equals(applicationContext.getPackageName())) {
            f = null;
        }
        if (f == null) {
            f = new EffectLibrary(applicationContext);
        }
        return f;
    }

    public Task b() {
        return this.o;
    }

    public at b(String str) {
        return this.n.get(str);
    }

    public com.nexstreaming.kinemaster.kmpackage.b c(String str) {
        com.nexstreaming.kinemaster.kmpackage.a d2 = d(str);
        at b2 = b(str);
        if (d2 != null) {
            if (b2 == null || d2 == b2) {
                return d2;
            }
            return null;
        }
        return b2;
    }

    public com.nexstreaming.kinemaster.kmpackage.a d(String str) {
        return this.m.get(str);
    }

    public Theme e(String str) {
        if (str == null) {
            return null;
        }
        return this.l.get(str);
    }

    public Theme a(String str, boolean z) {
        if (str == null) {
            if (z) {
                return null;
            }
            return Theme.b(str);
        }
        return this.l.get(str);
    }

    public Font f(String str) {
        if (str == null) {
            return null;
        }
        Iterator<y> it = a().iterator();
        while (it.hasNext()) {
            for (Font font : it.next().a()) {
                if (font.m().equals(str)) {
                    return font;
                }
            }
        }
        return null;
    }

    private <E extends com.nexstreaming.kinemaster.kmpackage.b> int a(Collection<E> collection, E[] eArr, int i) {
        int i2 = 0;
        if (collection != null) {
            boolean z = (i & 1) != 0;
            boolean z2 = (i & 2) != 0;
            boolean z3 = (i & 4) != 0;
            boolean z4 = (i & 8) != 0;
            for (E e2 : collection) {
                if (!e2.b() || z2) {
                    if (e2.b() || z3) {
                        if (!e2.c() || z) {
                            if (!e2.d() || z4) {
                                if (eArr != null) {
                                    eArr[i2] = e2;
                                }
                                i2++;
                            }
                        }
                    }
                }
            }
        }
        return i2;
    }

    public synchronized at[] a(int i) {
        at[] atVarArr;
        atVarArr = new at[a(this.n.values(), (com.nexstreaming.kinemaster.kmpackage.b[]) null, i)];
        a(this.n.values(), atVarArr, i);
        return atVarArr;
    }

    public synchronized com.nexstreaming.kinemaster.kmpackage.a[] b(int i) {
        com.nexstreaming.kinemaster.kmpackage.a[] aVarArr;
        aVarArr = new com.nexstreaming.kinemaster.kmpackage.a[a(this.m.values(), (com.nexstreaming.kinemaster.kmpackage.b[]) null, i)];
        a(this.m.values(), aVarArr, i);
        return aVarArr;
    }

    public synchronized Theme[] c() {
        Theme[] themeArr;
        ArrayList arrayList = new ArrayList();
        for (Theme theme : this.l.values()) {
            if (theme.p()) {
                arrayList.add(theme);
            }
        }
        themeArr = new Theme[arrayList.size()];
        arrayList.toArray(themeArr);
        return themeArr;
    }

    public ResultTask<Theme[]> d() {
        if (this.t != null && !this.t.isRunning() && System.nanoTime() - this.F > -647710720) {
            this.t = null;
        }
        if (this.t == null) {
            this.t = new ResultTask<>();
            String str = "";
            if (I != null) {
                try {
                    String str2 = "";
                    for (Map.Entry<String, String> entry : I.entrySet()) {
                        String encode = URLEncoder.encode(entry.getKey(), "utf-8");
                        String value = entry.getValue();
                        if (value == null) {
                            value = "null";
                        }
                        str2 = str2 + "&" + encode + "=" + URLEncoder.encode(value, "utf-8");
                    }
                    str = str2;
                } catch (UnsupportedEncodingException e2) {
                    throw new RuntimeException("Required encoding not supported", e2);
                }
            }
            String str3 = "?package=" + this.g.getPackageName() + "&version=" + com.nexstreaming.app.general.util.z.e(this.g) + str;
            try {
                URI[] uriArr = new URI[e.length];
                for (int i = 0; i < uriArr.length; i++) {
                    uriArr[i] = new URI(e[i] + str3);
                }
                new com.nexstreaming.kinemaster.kmpackage.d(this).executeOnExecutor(EditorGlobal.l, uriArr);
            } catch (URISyntaxException e3) {
                throw new RuntimeException("Invalid state", e3);
            }
        }
        return this.t;
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        public final long f3413a;
        public final long b;
        public final EffectLibraryTaskError c;

        public a(long j, long j2, EffectLibraryTaskError effectLibraryTaskError) {
            this.f3413a = j;
            this.b = j2;
            this.c = effectLibraryTaskError;
        }
    }

    /* loaded from: classes.dex */
    public class c extends AsyncTask<f, a, Integer> {
        private a b;

        private c() {
            this.b = null;
        }

        /* synthetic */ c(EffectLibrary effectLibrary, com.nexstreaming.kinemaster.kmpackage.c cVar) {
            this();
        }

        public a a() {
            return this.b;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
        }

        private int a(f fVar) {
            int i;
            URI uri = fVar.b;
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) uri.toURL().openConnection();
                try {
                    fVar.f3418a.delete();
                    File file = new File(fVar.f3418a.getAbsolutePath() + ".download");
                    file.delete();
                    httpURLConnection.setConnectTimeout(15000);
                    httpURLConnection.setReadTimeout(60000);
                    httpURLConnection.getResponseCode();
                    int contentLength = httpURLConnection.getContentLength();
                    if (com.nexstreaming.app.general.util.i.a(file) < 10485760 + contentLength) {
                        publishProgress(new a(0L, 0L, EffectLibraryTaskError.NotEnoughSpace));
                        return 1;
                    }
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                    if (!uri.getHost().equals(httpURLConnection.getURL().getHost())) {
                        if (EffectLibrary.H != null) {
                            Intent intent = new Intent("android.intent.action.VIEW");
                            intent.addFlags(268435456);
                            intent.setData(EffectLibrary.H);
                            EffectLibrary.this.g.startActivity(intent);
                        }
                        publishProgress(new a(0L, 0L, EffectLibraryTaskError.Redirected));
                        return 1;
                    }
                    if (contentLength < 0) {
                        publishProgress(new a(0L, 0L, EffectLibraryTaskError.ContentSizeMissing));
                        return 1;
                    }
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.setLength(contentLength);
                    randomAccessFile.getChannel().force(true);
                    randomAccessFile.seek(0L);
                    byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
                    int i2 = 0;
                    long nanoTime = System.nanoTime();
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            i = i2;
                            break;
                        }
                        randomAccessFile.write(bArr, 0, read);
                        int i3 = i2 + read;
                        long nanoTime2 = System.nanoTime();
                        if (nanoTime2 - nanoTime > 16000000 || i3 >= contentLength) {
                            publishProgress(new a(i3, contentLength, null));
                            nanoTime = nanoTime2;
                        }
                        if (i3 >= contentLength) {
                            i = i3;
                            break;
                        }
                        i2 = i3;
                    }
                    bufferedInputStream.close();
                    randomAccessFile.close();
                    fVar.f3418a.delete();
                    file.renameTo(fVar.f3418a);
                    publishProgress(new a(i, contentLength, EffectLibraryTaskError.Success));
                    httpURLConnection.disconnect();
                    return 0;
                } finally {
                    httpURLConnection.disconnect();
                }
            } catch (IOException e) {
                publishProgress(new a(0L, 0L, EffectLibraryTaskError.DownloadIOException));
                e.printStackTrace();
                return 1;
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Integer doInBackground(f... fVarArr) {
            int i = 0;
            if (fVarArr.length > 0) {
                f fVar = fVarArr[0];
                if (fVar.f3418a.exists()) {
                    long length = fVar.f3418a.length();
                    publishProgress(new a(length, length, EffectLibraryTaskError.Success));
                } else {
                    i = a(fVar);
                }
            } else {
                i = 1;
            }
            return Integer.valueOf(i);
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Integer num) {
            EffectLibrary.this.m();
            super.onPostExecute(num);
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            if (aVarArr.length > 0) {
                this.b = aVarArr[0];
            }
            EffectLibrary.this.m();
            super.onProgressUpdate(aVarArr);
        }
    }

    public void m() {
        int i = this.ah;
        this.ah++;
        if (this.Q) {
            this.R = true;
            return;
        }
        int i2 = 0;
        do {
            i2++;
            this.Q = true;
            this.R = false;
            try {
                c(i);
                this.Q = false;
            } catch (Throwable th) {
                this.Q = false;
                throw th;
            }
        } while (this.R);
    }

    private void c(int i) {
        boolean z;
        boolean z2;
        if (!this.Q) {
            throw new IllegalStateException();
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        synchronized (this.v) {
            for (d dVar : this.u) {
                long j = 0;
                long j2 = 0;
                boolean z3 = false;
                boolean z4 = true;
                arrayList2.clear();
                for (f fVar : dVar.b) {
                    File file = fVar.f3418a;
                    c cVar = this.ag.get(file);
                    if (cVar != null) {
                        a a2 = cVar.a();
                        if (a2 == null) {
                            z2 = true;
                            z = false;
                        } else {
                            if (a2.c != EffectLibraryTaskError.Success) {
                                if (a2.c != null) {
                                    arrayList2.add(a2.c);
                                    hashSet.add(file);
                                }
                                z = false;
                            } else {
                                z = z4;
                            }
                            j += a2.f3413a;
                            j2 += a2.b;
                            z2 = z3;
                        }
                    } else if (file.exists()) {
                        long length = file.length();
                        j += length;
                        j2 += length;
                        z = z4;
                        z2 = z3;
                    } else {
                        c cVar2 = new c(this, null);
                        cVar2.executeOnExecutor(this.w, fVar);
                        this.ag.put(file, cVar2);
                        z = false;
                        z2 = true;
                    }
                    z4 = z;
                    z3 = z2;
                }
                if (arrayList2.size() > 0) {
                    arrayList.add(dVar);
                    dVar.f3416a.sendFailure((Task.TaskError) arrayList2.get(0));
                } else if (z4) {
                    arrayList.add(dVar);
                    Task task = dVar.f3416a;
                    if (dVar.c == null) {
                        task.signalEvent(Task.Event.COMPLETE);
                    } else {
                        try {
                            new ad().a(new com.nexstreaming.kinemaster.kmpackage.e(this, task)).executeOnExecutor(U, new ao(dVar.c, this.i, this.E, true));
                        } catch (ZipException e2) {
                            e2.printStackTrace();
                            task.signalEvent(Task.Event.FAIL);
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            task.signalEvent(Task.Event.FAIL);
                        }
                    }
                } else if (!z3) {
                    dVar.f3416a.setProgress((int) Math.min(j, 2147483647L), (int) Math.min(j2, 2147483647L));
                }
            }
            this.u.removeAll(arrayList);
        }
        for (Map.Entry<File, c> entry : this.ag.entrySet()) {
            switch (AnonymousClass1.f3412a[entry.getValue().getStatus().ordinal()]) {
                case 1:
                    hashSet.add(entry.getKey());
                    break;
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            this.ag.remove((File) it.next());
        }
    }

    /* renamed from: com.nexstreaming.kinemaster.kmpackage.EffectLibrary$1 */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f3412a = new int[AsyncTask.Status.values().length];

        static {
            try {
                f3412a[AsyncTask.Status.FINISHED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3412a[AsyncTask.Status.PENDING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f3412a[AsyncTask.Status.RUNNING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public void a(am amVar, Task task) {
        if (amVar instanceof Theme) {
            Theme theme = (Theme) amVar;
            task.onProgress(new h(this, theme)).onComplete(new g(this, theme)).onFailure(new com.nexstreaming.kinemaster.kmpackage.f(this, theme));
        }
        URI h = amVar.h();
        ArrayList arrayList = new ArrayList();
        KMTServerIndex.Item g = amVar.g();
        if (g == null) {
            task.sendFailure(EffectLibraryTaskError.ServerConnectionError);
            return;
        }
        String str = g.pkg;
        File file = new File(this.h, str);
        arrayList.add(new f(file, h.resolve(str)));
        String[] strArr = g.dependencies;
        for (String str2 : strArr) {
            arrayList.add(new f(new File(this.i, str2), h.resolve("ext/" + str2)));
        }
        a(new d(task, arrayList, file));
        m();
    }

    /* loaded from: classes.dex */
    public enum EffectLibraryTaskError implements Task.TaskError {
        Success,
        NotUninstallable,
        PackageDeletionFailure,
        NotInstalled,
        ParameterError,
        NotEnoughSpace,
        MissingDependency,
        DownloadIOException,
        Redirected,
        ContentSizeMissing,
        DeleteAlreadyInProgress,
        DeleteCanceled,
        ServerConnectionError;

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

    public void b(Font font, Task task) {
        if (font == null) {
            task.sendFailure(EffectLibraryTaskError.ParameterError);
            return;
        }
        if (!this.M.contains(font)) {
            task.sendFailure(EffectLibraryTaskError.NotInstalled);
            return;
        }
        if (!font.k()) {
            task.sendFailure(EffectLibraryTaskError.NotUninstallable);
            return;
        }
        this.M.remove(font);
        HashSet hashSet = new HashSet();
        File c2 = font.c();
        if (c2 != null) {
            hashSet.add(c2);
        }
        new i(this, hashSet, task).executeOnExecutor(U, 0);
    }

    public void a(Set<File> set) {
        Iterator<Map.Entry<String, Theme>> it = this.l.entrySet().iterator();
        while (it.hasNext()) {
            ai k = it.next().getValue().k();
            Iterator<String> it2 = k.a().b().keySet().iterator();
            while (it2.hasNext()) {
                URI a2 = k.a(it2.next(), false);
                if (a2 != null) {
                    set.remove(new File(a2));
                }
            }
        }
        Iterator<Map.Entry<String, com.nexstreaming.kinemaster.kmpackage.a>> it3 = this.m.entrySet().iterator();
        while (it3.hasNext()) {
            ai k2 = it3.next().getValue().k();
            Iterator<String> it4 = k2.a().b().keySet().iterator();
            while (it4.hasNext()) {
                URI a3 = k2.a(it4.next(), false);
                if (a3 != null) {
                    set.remove(new File(a3));
                }
            }
        }
        Iterator<Map.Entry<String, at>> it5 = this.n.entrySet().iterator();
        while (it5.hasNext()) {
            ai k3 = it5.next().getValue().k();
            Iterator<String> it6 = k3.a().b().keySet().iterator();
            while (it6.hasNext()) {
                URI a4 = k3.a(it6.next(), false);
                if (a4 != null) {
                    set.remove(new File(a4));
                }
            }
        }
        Iterator<Font> it7 = this.M.iterator();
        while (it7.hasNext()) {
            File c2 = it7.next().c();
            if (c2 != null) {
                set.remove(c2);
            }
        }
    }

    public void g(String str) {
        this.P = str;
    }

    public synchronized void a(ai aiVar, Set<File> set, Set<String> set2, Set<String> set3, Set<String> set4) {
        Iterator<String> it = aiVar.a().b().keySet().iterator();
        while (it.hasNext()) {
            set.add(new File(aiVar.a(it.next(), false)));
        }
        for (Map.Entry<String, Theme> entry : this.l.entrySet()) {
            ai k = entry.getValue().k();
            if (k.equals(aiVar)) {
                set2.add(entry.getKey());
            } else {
                Iterator<String> it2 = k.a().b().keySet().iterator();
                while (it2.hasNext()) {
                    set.remove(new File(aiVar.a(it2.next(), false)));
                }
            }
        }
        for (Map.Entry<String, com.nexstreaming.kinemaster.kmpackage.a> entry2 : this.m.entrySet()) {
            ai k2 = entry2.getValue().k();
            if (k2.equals(aiVar)) {
                set4.add(entry2.getKey());
            } else {
                Iterator<String> it3 = k2.a().b().keySet().iterator();
                while (it3.hasNext()) {
                    set.remove(new File(aiVar.a(it3.next(), false)));
                }
            }
        }
        for (Map.Entry<String, at> entry3 : this.n.entrySet()) {
            ai k3 = entry3.getValue().k();
            if (k3.equals(aiVar)) {
                set3.add(entry3.getKey());
            } else {
                Iterator<String> it4 = k3.a().b().keySet().iterator();
                while (it4.hasNext()) {
                    set.remove(new File(aiVar.a(it4.next(), false)));
                }
            }
        }
        Iterator<Font> it5 = this.M.iterator();
        while (it5.hasNext()) {
            File c2 = it5.next().c();
            if (c2 != null) {
                set.remove(c2);
            }
        }
    }

    public synchronized void b(ai aiVar, Set<File> set, Set<String> set2, Set<String> set3, Set<String> set4) {
        for (String str : set2) {
            this.l.get(str).a(false);
            this.l.remove(str);
        }
        Iterator<String> it = set3.iterator();
        while (it.hasNext()) {
            this.n.remove(it.next());
        }
        Iterator<String> it2 = set4.iterator();
        while (it2.hasNext()) {
            this.m.remove(it2.next());
        }
        Iterator<File> it3 = set.iterator();
        while (it3.hasNext()) {
            it3.next().delete();
        }
    }

    public void b(am amVar, Task task) {
        ai k = amVar.k();
        if (!k.e()) {
            task.sendFailure(EffectLibraryTaskError.NotUninstallable);
            return;
        }
        if (k.c()) {
            task.sendFailure(EffectLibraryTaskError.DeleteAlreadyInProgress);
            return;
        }
        if (this.P != null) {
            Iterator<Theme> it = k.h().iterator();
            while (it.hasNext()) {
                if (it.next().i().equals(this.P)) {
                    task.sendFailure(EffectLibraryTaskError.NotUninstallable);
                    return;
                }
            }
        }
        k.a(true);
        new j(this, k, task).executeOnExecutor(U, 0);
    }

    public void a(Iterable<com.nexstreaming.kinemaster.kmpackage.b> iterable, NexEditor nexEditor, boolean z) {
        if (nexEditor != null && iterable != null) {
            nexEditor.b(a(iterable), z);
        }
    }

    public String a(Iterable<com.nexstreaming.kinemaster.kmpackage.b> iterable) {
        StringBuilder sb = new StringBuilder();
        sb.append("<themeset name=\"KM\" defaultTheme=\"none\" defaultTransition=\"none\" >");
        sb.append("<texture id=\"video_out\" video=\"1\" />");
        sb.append("<texture id=\"video_in\" video=\"2\" />");
        for (com.nexstreaming.kinemaster.kmpackage.b bVar : iterable) {
            if (bVar != null) {
                sb.append(bVar.l());
            }
        }
        sb.append("</themeset>");
        return sb.toString();
    }

    public synchronized void a(ai aiVar) {
        Theme[] result = (this.t == null || !this.t.didSignalEvent(Task.Event.RESULT_AVAILABLE)) ? null : this.t.getResult();
        for (Theme theme : aiVar.h()) {
            if (this.l.containsKey(theme.i())) {
                Log.w("EffectLibrary", "Duplicate ID detected [theme]: " + theme.i());
                this.G.add("Duplicate ID (theme): " + theme.i() + " (in package: " + theme.k().b() + ")");
            } else {
                theme.a(this);
                this.l.put(theme.i(), theme);
                if (result != null) {
                    int i = 0;
                    while (true) {
                        if (i >= result.length) {
                            break;
                        }
                        if (!result[i].i().equals(theme.i())) {
                            i++;
                        } else {
                            result[i].a(theme);
                            break;
                        }
                    }
                }
            }
        }
        for (at atVar : aiVar.i()) {
            if (this.n.containsKey(atVar.a())) {
                Log.w("EffectLibrary", "Duplicate ID detected [transition]: " + atVar.a());
                this.G.add("Duplicate ID (transition): " + atVar.a() + " (in package: " + atVar.k().b() + ")");
            } else {
                this.n.put(atVar.a(), atVar);
                if (!atVar.b()) {
                }
            }
        }
        for (com.nexstreaming.kinemaster.kmpackage.a aVar : aiVar.j()) {
            if (this.m.containsKey(aVar.a())) {
                Log.w("EffectLibrary", "Duplicate ID detected [clipfx]: " + aVar.a());
                this.G.add("Duplicate ID (clip effect): " + aVar.a() + " (in package: " + aVar.k().b() + ")");
            } else {
                this.m.put(aVar.a(), aVar);
            }
        }
    }

    public File h(String str) {
        Theme e2;
        String n;
        if (str == null || (e2 = e(str)) == null || (n = e2.n()) == null || n.length() < 1) {
            return null;
        }
        try {
            return e().b(str, n);
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public com.nextreaming.nexvideoeditor.a e() {
        if (this.s == null) {
            this.s = new k(this);
        }
        return this.s;
    }

    /* loaded from: classes.dex */
    public static class b implements y {

        /* renamed from: a */
        private final String f3414a;
        private final int b;
        private final List<Font> c;
        private final Map<String, String> d;

        b(String str, int i) {
            this.c = new ArrayList();
            this.f3414a = str;
            this.b = i;
            this.d = null;
        }

        b(String str, Map<String, String> map) {
            this.c = new ArrayList();
            this.f3414a = str;
            this.b = 0;
            this.d = map;
        }

        @Override // com.nexstreaming.kinemaster.kmpackage.y
        public String a(Context context) {
            if (this.b != 0) {
                return context.getString(this.b);
            }
            if (this.d != null) {
                return ah.a(context, this.d);
            }
            return null;
        }

        @Override // com.nexstreaming.kinemaster.kmpackage.y
        public List<Font> a() {
            return Collections.unmodifiableList(this.c);
        }

        @Override // com.nexstreaming.kinemaster.kmpackage.y
        public String b() {
            return this.f3414a;
        }

        List<Font> c() {
            return this.c;
        }
    }
}
