package com.qq.e.comm.managers.plugin;

import android.content.Context;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
public class PM {
    private static final Map<Class<?>, String> l = new HashMap<Class<?>, String>() { // from class: com.qq.e.comm.managers.plugin.PM.2
        {
            put(POFactory.class, "com.qq.e.comm.plugin.POFactoryImpl");
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private final Context f24965b;

    /* renamed from: c, reason: collision with root package name */
    private String f24966c;

    /* renamed from: d, reason: collision with root package name */
    private File f24967d;

    /* renamed from: e, reason: collision with root package name */
    private int f24968e;

    /* renamed from: f, reason: collision with root package name */
    private DexClassLoader f24969f;

    /* renamed from: g, reason: collision with root package name */
    private RandomAccessFile f24970g;

    /* renamed from: h, reason: collision with root package name */
    private FileLock f24971h;
    private a.InterfaceC0127a j;

    /* renamed from: a, reason: collision with root package name */
    private ExecutorService f24964a = Executors.newSingleThreadExecutor();
    private a.b k = new a.b() { // from class: com.qq.e.comm.managers.plugin.PM.1
        @Override // com.qq.e.comm.managers.plugin.PM.a.b
        public final void a() {
            PM.a(PM.this);
        }

        @Override // com.qq.e.comm.managers.plugin.PM.a.b
        public final void b() {
            PM.this.f();
        }
    };
    private boolean i = d();

    /* loaded from: classes3.dex */
    public interface a {

        /* renamed from: com.qq.e.comm.managers.plugin.PM$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public interface InterfaceC0127a {
            void onLoadFail();

            void onLoadSuccess();
        }

        /* loaded from: classes3.dex */
        public interface b {
            void a();

            void b();
        }
    }

    public PM(Context context, a.InterfaceC0127a interfaceC0127a) {
        this.f24965b = context.getApplicationContext();
        this.j = interfaceC0127a;
        if (b()) {
            a();
        }
    }

    private void a() {
        File file;
        StringBuilder sb = new StringBuilder("PluginFile:\t");
        File file2 = this.f24967d;
        sb.append(file2 == null ? "null" : file2.getAbsolutePath());
        GDTLogger.d(sb.toString());
        if (this.f24966c == null || (file = this.f24967d) == null) {
            this.f24969f = null;
            return;
        }
        try {
            this.f24969f = new DexClassLoader(file.getAbsolutePath(), this.f24965b.getDir("e_qq_com_dex", 0).getAbsolutePath(), null, getClass().getClassLoader());
            e();
        } catch (Throwable th) {
            GDTLogger.e("exception while init plugin class loader", th);
            f();
        }
    }

    static /* synthetic */ void a(PM pm) {
        try {
            if (pm.f24969f == null && pm.c()) {
                pm.a();
            }
        } catch (Exception e2) {
            GDTLogger.report("Exception while init online plugin: ", e2);
            pm.f();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0051, code lost:            if (r2 == false) goto L15;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean b() {
        /*
            r6 = this;
            java.lang.String r0 = "TimeStap_AFTER_PLUGIN_INIT:"
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L68 java.lang.Throwable -> L6a
            java.lang.String r3 = "TimeStap_BEFORE_PLUGIN_INIT:"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L68 java.lang.Throwable -> L6a
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L68 java.lang.Throwable -> L6a
            r2.append(r3)     // Catch: java.lang.Throwable -> L68 java.lang.Throwable -> L6a
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L68 java.lang.Throwable -> L6a
            com.qq.e.comm.util.GDTLogger.d(r2)     // Catch: java.lang.Throwable -> L68 java.lang.Throwable -> L6a
            boolean r2 = r6.c()     // Catch: java.lang.Throwable -> L68 java.lang.Throwable -> L6a
            r3 = 1
            if (r2 != 0) goto L53
            boolean r2 = r6.i     // Catch: java.lang.Throwable -> L68 java.lang.Throwable -> L6a
            if (r2 != 0) goto L25
        L23:
            r2 = 0
            goto L51
        L25:
            android.content.Context r2 = r6.f24965b     // Catch: java.lang.Throwable -> L68 java.lang.Throwable -> L6a
            android.content.Context r4 = r6.f24965b     // Catch: java.lang.Throwable -> L68 java.lang.Throwable -> L6a
            java.io.File r4 = com.qq.e.comm.managers.plugin.a.a(r4)     // Catch: java.lang.Throwable -> L68 java.lang.Throwable -> L6a
            android.content.Context r5 = r6.f24965b     // Catch: java.lang.Throwable -> L68 java.lang.Throwable -> L6a
            java.io.File r5 = com.qq.e.comm.managers.plugin.a.c(r5)     // Catch: java.lang.Throwable -> L68 java.lang.Throwable -> L6a
            boolean r2 = com.qq.e.comm.managers.plugin.a.a(r2, r4, r5)     // Catch: java.lang.Throwable -> L68 java.lang.Throwable -> L6a
            if (r2 == 0) goto L4b
            java.lang.String r2 = "Y2bM35Gy7PsA2Xg8y9AX6yLOXx/WfzFNWaES89/TJw4mUVqxhBkr9lATDdkY18S2JCRzinTMxl8jiYr0EY/rga9VJQes3o7KTImNOQFbdCZwhcmmhqWFgKzGBuu9eCC2t1KKSozxl5PUYi1Z/IqmnmNt4YNqOU1BpYF0xAGZGnw="
            r6.f24966c = r2     // Catch: java.lang.Throwable -> L68 java.lang.Throwable -> L6a
            android.content.Context r2 = r6.f24965b     // Catch: java.lang.Throwable -> L68 java.lang.Throwable -> L6a
            java.io.File r2 = com.qq.e.comm.managers.plugin.a.a(r2)     // Catch: java.lang.Throwable -> L68 java.lang.Throwable -> L6a
            r6.f24967d = r2     // Catch: java.lang.Throwable -> L68 java.lang.Throwable -> L6a
            r2 = 910(0x38e, float:1.275E-42)
            r6.f24968e = r2     // Catch: java.lang.Throwable -> L68 java.lang.Throwable -> L6a
            r2 = 1
            goto L51
        L4b:
            java.lang.String r2 = "Fail to prepair Defult plugin "
            com.qq.e.comm.util.GDTLogger.e(r2)     // Catch: java.lang.Throwable -> L68 java.lang.Throwable -> L6a
            goto L23
        L51:
            if (r2 == 0) goto L54
        L53:
            r1 = 1
        L54:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r0)
        L59:
            long r3 = java.lang.System.currentTimeMillis()
            r2.append(r3)
            java.lang.String r0 = r2.toString()
            com.qq.e.comm.util.GDTLogger.d(r0)
            return r1
        L68:
            r1 = move-exception
            goto L76
        L6a:
            r2 = move-exception
            java.lang.String r3 = "Exception while init plugin manager"
            com.qq.e.comm.util.GDTLogger.report(r3, r2)     // Catch: java.lang.Throwable -> L68
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r0)
            goto L59
        L76:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r0)
            long r3 = java.lang.System.currentTimeMillis()
            r2.append(r3)
            java.lang.String r0 = r2.toString()
            com.qq.e.comm.util.GDTLogger.d(r0)
            goto L8b
        L8a:
            throw r1
        L8b:
            goto L8a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.managers.plugin.PM.b():boolean");
    }

    private boolean c() {
        if (this.i) {
            com.qq.e.comm.managers.plugin.a aVar = new com.qq.e.comm.managers.plugin.a(com.qq.e.comm.managers.plugin.a.b(this.f24965b), com.qq.e.comm.managers.plugin.a.d(this.f24965b));
            if (aVar.a()) {
                GDTLogger.d("NextExist,Updated=" + aVar.a(com.qq.e.comm.managers.plugin.a.a(this.f24965b), com.qq.e.comm.managers.plugin.a.c(this.f24965b)));
            }
        }
        com.qq.e.comm.managers.plugin.a aVar2 = new com.qq.e.comm.managers.plugin.a(com.qq.e.comm.managers.plugin.a.a(this.f24965b), com.qq.e.comm.managers.plugin.a.c(this.f24965b));
        if (!aVar2.a()) {
            return false;
        }
        if (aVar2.b() >= 910) {
            this.f24966c = aVar2.c();
            this.f24968e = aVar2.b();
            this.f24967d = com.qq.e.comm.managers.plugin.a.a(this.f24965b);
            return true;
        }
        GDTLogger.d("last updated plugin version =" + this.f24968e + ";asset plugin version=910");
        return false;
    }

    private boolean d() {
        try {
            File file = new File(this.f24965b.getDir("e_qq_com_plugin", 0), "update_lc");
            if (!file.exists()) {
                file.createNewFile();
                StringUtil.writeTo("lock", file);
            }
            if (!file.exists()) {
                return false;
            }
            this.f24970g = new RandomAccessFile(file, "rw");
            this.f24971h = this.f24970g.getChannel().tryLock();
            if (this.f24971h == null) {
                return false;
            }
            this.f24970g.writeByte(37);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void e() {
        a.InterfaceC0127a interfaceC0127a = this.j;
        if (interfaceC0127a != null) {
            interfaceC0127a.onLoadSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        a.InterfaceC0127a interfaceC0127a = this.j;
        if (interfaceC0127a != null) {
            interfaceC0127a.onLoadFail();
        }
    }

    public <T> T getFactory(Class<T> cls) throws c {
        GDTLogger.d("GetFactoryInstaceforInterface:" + cls);
        DexClassLoader dexClassLoader = this.f24969f;
        StringBuilder sb = new StringBuilder("PluginClassLoader is parent");
        sb.append(PM.class.getClassLoader() == dexClassLoader);
        GDTLogger.d(sb.toString());
        if (dexClassLoader == null) {
            throw new c("Fail to init GDTADPLugin,PluginClassLoader == null;while loading factory impl for:" + cls);
        }
        try {
            String str = l.get(cls);
            if (StringUtil.isEmpty(str)) {
                throw new c("factory  implemention name is not specified for interface:" + cls.getName());
            }
            Class<?> loadClass = dexClassLoader.loadClass(str);
            T cast = cls.cast(loadClass.getDeclaredMethod("getInstance", new Class[0]).invoke(loadClass, new Object[0]));
            GDTLogger.d("ServiceDelegateFactory =" + cast);
            return cast;
        } catch (Throwable th) {
            throw new c("Fail to getfactory implement instance for interface:" + cls.getName(), th);
        }
    }

    public String getLocalSig() {
        return this.f24966c;
    }

    public POFactory getPOFactory() throws c {
        return (POFactory) getFactory(POFactory.class);
    }

    public int getPluginVersion() {
        return this.f24968e;
    }

    public void update(String str, String str2) {
        if (this.i) {
            b bVar = new b(this.f24965b, this.f24964a);
            bVar.a(this.k);
            bVar.a(str, str2);
        }
    }
}
