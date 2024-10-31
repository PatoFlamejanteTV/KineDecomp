package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

@KeepForSdk
/* loaded from: classes.dex */
public final class DynamiteModule {

    /* renamed from: a */
    private static Boolean f11319a = null;

    /* renamed from: b */
    private static zzi f11320b = null;

    /* renamed from: c */
    private static zzk f11321c = null;

    /* renamed from: d */
    private static String f11322d = null;

    /* renamed from: e */
    private static int f11323e = -1;

    /* renamed from: f */
    private static final ThreadLocal<a> f11324f = new ThreadLocal<>();

    /* renamed from: g */
    private static final VersionPolicy.zza f11325g = new com.google.android.gms.dynamite.a();

    /* renamed from: h */
    @KeepForSdk
    public static final VersionPolicy f11326h = new com.google.android.gms.dynamite.b();

    @KeepForSdk
    public static final VersionPolicy i = new c();

    @KeepForSdk
    public static final VersionPolicy j = new d();

    @KeepForSdk
    public static final VersionPolicy k = new e();

    @KeepForSdk
    public static final VersionPolicy l = new f();
    private static final VersionPolicy m = new g();
    private final Context n;

    @DynamiteApi
    /* loaded from: classes.dex */
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    @KeepForSdk
    /* loaded from: classes.dex */
    public static class LoadingException extends Exception {
        private LoadingException(String str) {
            super(str);
        }

        private LoadingException(String str, Throwable th) {
            super(str, th);
        }

        /* synthetic */ LoadingException(String str, com.google.android.gms.dynamite.a aVar) {
            this(str);
        }

        /* synthetic */ LoadingException(String str, Throwable th, com.google.android.gms.dynamite.a aVar) {
            this(str, th);
        }
    }

    /* loaded from: classes.dex */
    public interface VersionPolicy {

        /* loaded from: classes.dex */
        public interface zza {
            int a(Context context, String str);

            int a(Context context, String str, boolean z) throws LoadingException;
        }

        /* loaded from: classes.dex */
        public static class zzb {

            /* renamed from: a */
            public int f11327a = 0;

            /* renamed from: b */
            public int f11328b = 0;

            /* renamed from: c */
            public int f11329c = 0;
        }

        zzb a(Context context, String str, zza zzaVar) throws LoadingException;
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        public Cursor f11330a;

        private a() {
        }

        /* synthetic */ a(com.google.android.gms.dynamite.a aVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static class b implements VersionPolicy.zza {

        /* renamed from: a */
        private final int f11331a;

        /* renamed from: b */
        private final int f11332b = 0;

        public b(int i, int i2) {
            this.f11331a = i;
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zza
        public final int a(Context context, String str) {
            return this.f11331a;
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zza
        public final int a(Context context, String str, boolean z) {
            return 0;
        }
    }

    private DynamiteModule(Context context) {
        Preconditions.a(context);
        this.n = context;
    }

    @KeepForSdk
    public static DynamiteModule a(Context context, VersionPolicy versionPolicy, String str) throws LoadingException {
        a aVar = f11324f.get();
        a aVar2 = new a(null);
        f11324f.set(aVar2);
        try {
            VersionPolicy.zzb a2 = versionPolicy.a(context, str, f11325g);
            int i2 = a2.f11327a;
            int i3 = a2.f11328b;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str).length());
            sb.append("Considering local module ");
            sb.append(str);
            sb.append(":");
            sb.append(i2);
            sb.append(" and remote module ");
            sb.append(str);
            sb.append(":");
            sb.append(i3);
            Log.i("DynamiteModule", sb.toString());
            if (a2.f11329c != 0 && ((a2.f11329c != -1 || a2.f11327a != 0) && (a2.f11329c != 1 || a2.f11328b != 0))) {
                if (a2.f11329c == -1) {
                    DynamiteModule c2 = c(context, str);
                    Cursor cursor = aVar2.f11330a;
                    if (cursor != null) {
                        cursor.close();
                    }
                    f11324f.set(aVar);
                    return c2;
                }
                if (a2.f11329c == 1) {
                    try {
                        DynamiteModule a3 = a(context, str, a2.f11328b);
                        Cursor cursor2 = aVar2.f11330a;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        f11324f.set(aVar);
                        return a3;
                    } catch (LoadingException e2) {
                        String valueOf = String.valueOf(e2.getMessage());
                        Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to load remote module: ".concat(valueOf) : new String("Failed to load remote module: "));
                        if (a2.f11327a != 0 && versionPolicy.a(context, str, new b(a2.f11327a, 0)).f11329c == -1) {
                            DynamiteModule c3 = c(context, str);
                            Cursor cursor3 = aVar2.f11330a;
                            if (cursor3 != null) {
                                cursor3.close();
                            }
                            f11324f.set(aVar);
                            return c3;
                        }
                        throw new LoadingException("Remote load failed. No local fallback found.", e2, null);
                    }
                }
                int i4 = a2.f11329c;
                StringBuilder sb2 = new StringBuilder(47);
                sb2.append("VersionPolicy returned invalid code:");
                sb2.append(i4);
                throw new LoadingException(sb2.toString(), (com.google.android.gms.dynamite.a) null);
            }
            int i5 = a2.f11327a;
            int i6 = a2.f11328b;
            StringBuilder sb3 = new StringBuilder(91);
            sb3.append("No acceptable module found. Local version is ");
            sb3.append(i5);
            sb3.append(" and remote version is ");
            sb3.append(i6);
            sb3.append(".");
            throw new LoadingException(sb3.toString(), (com.google.android.gms.dynamite.a) null);
        } catch (Throwable th) {
            Cursor cursor4 = aVar2.f11330a;
            if (cursor4 != null) {
                cursor4.close();
            }
            f11324f.set(aVar);
            throw th;
        }
    }

    private static int b(Context context, String str, boolean z) {
        zzi a2 = a(context);
        if (a2 == null) {
            return 0;
        }
        try {
            if (a2.l() >= 2) {
                return a2.a(ObjectWrapper.a(context), str, z);
            }
            Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
            return a2.b(ObjectWrapper.a(context), str, z);
        } catch (RemoteException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf) : new String("Failed to retrieve remote module version: "));
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int c(android.content.Context r8, java.lang.String r9, boolean r10) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            r0 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            if (r10 == 0) goto La
            java.lang.String r8 = "api_force_staging"
            goto Lc
        La:
            java.lang.String r8 = "api"
        Lc:
            int r10 = r8.length()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            int r10 = r10 + 42
            java.lang.String r2 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            int r2 = r2.length()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            int r10 = r10 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            r2.<init>(r10)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            java.lang.String r10 = "content://com.google.android.gms.chimera/"
            r2.append(r10)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            r2.append(r8)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            java.lang.String r8 = "/"
            r2.append(r8)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            r2.append(r9)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            java.lang.String r8 = r2.toString()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            android.net.Uri r2 = android.net.Uri.parse(r8)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            if (r8 == 0) goto L83
            boolean r9 = r8.moveToFirst()     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            if (r9 == 0) goto L83
            r9 = 0
            int r9 = r8.getInt(r9)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            if (r9 <= 0) goto L7d
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r10 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r10)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            r1 = 2
            java.lang.String r1 = r8.getString(r1)     // Catch: java.lang.Throwable -> L7a
            com.google.android.gms.dynamite.DynamiteModule.f11322d = r1     // Catch: java.lang.Throwable -> L7a
            java.lang.String r1 = "loaderVersion"
            int r1 = r8.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L7a
            if (r1 < 0) goto L67
            int r1 = r8.getInt(r1)     // Catch: java.lang.Throwable -> L7a
            com.google.android.gms.dynamite.DynamiteModule.f11323e = r1     // Catch: java.lang.Throwable -> L7a
        L67:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L7a
            java.lang.ThreadLocal<com.google.android.gms.dynamite.DynamiteModule$a> r10 = com.google.android.gms.dynamite.DynamiteModule.f11324f     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            java.lang.Object r10 = r10.get()     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            com.google.android.gms.dynamite.DynamiteModule$a r10 = (com.google.android.gms.dynamite.DynamiteModule.a) r10     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            if (r10 == 0) goto L7d
            android.database.Cursor r1 = r10.f11330a     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            if (r1 != 0) goto L7d
            r10.f11330a = r8     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            r8 = r0
            goto L7d
        L7a:
            r9 = move-exception
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L7a
            throw r9     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
        L7d:
            if (r8 == 0) goto L82
            r8.close()
        L82:
            return r9
        L83:
            java.lang.String r9 = "DynamiteModule"
            java.lang.String r10 = "Failed to retrieve remote module version."
            android.util.Log.w(r9, r10)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r9 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            java.lang.String r10 = "Failed to connect to dynamite module ContentResolver."
            r9.<init>(r10, r0)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            throw r9     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
        L92:
            r9 = move-exception
            r0 = r8
            r8 = r9
            goto Lae
        L96:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto L9f
        L9b:
            r8 = move-exception
            goto Lae
        L9d:
            r8 = move-exception
            r9 = r0
        L9f:
            boolean r10 = r8 instanceof com.google.android.gms.dynamite.DynamiteModule.LoadingException     // Catch: java.lang.Throwable -> Lac
            if (r10 == 0) goto La4
            throw r8     // Catch: java.lang.Throwable -> Lac
        La4:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r10 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch: java.lang.Throwable -> Lac
            java.lang.String r1 = "V2 version check failed"
            r10.<init>(r1, r8, r0)     // Catch: java.lang.Throwable -> Lac
            throw r10     // Catch: java.lang.Throwable -> Lac
        Lac:
            r8 = move-exception
            r0 = r9
        Lae:
            if (r0 == 0) goto Lb3
            r0.close()
        Lb3:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.c(android.content.Context, java.lang.String, boolean):int");
    }

    @KeepForSdk
    public static int b(Context context, String str) {
        return a(context, str, false);
    }

    private static DynamiteModule b(Context context, String str, int i2) throws LoadingException, RemoteException {
        zzk zzkVar;
        IObjectWrapper a2;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
        sb.append("Selected remote version of ");
        sb.append(str);
        sb.append(", version >= ");
        sb.append(i2);
        Log.i("DynamiteModule", sb.toString());
        synchronized (DynamiteModule.class) {
            zzkVar = f11321c;
        }
        if (zzkVar != null) {
            a aVar = f11324f.get();
            if (aVar != null && aVar.f11330a != null) {
                Context applicationContext = context.getApplicationContext();
                Cursor cursor = aVar.f11330a;
                ObjectWrapper.a((Object) null);
                if (b().booleanValue()) {
                    Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                    a2 = zzkVar.b(ObjectWrapper.a(applicationContext), str, i2, ObjectWrapper.a(cursor));
                } else {
                    Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                    a2 = zzkVar.a(ObjectWrapper.a(applicationContext), str, i2, ObjectWrapper.a(cursor));
                }
                Context context2 = (Context) ObjectWrapper.a(a2);
                if (context2 != null) {
                    return new DynamiteModule(context2);
                }
                throw new LoadingException("Failed to get module context", (com.google.android.gms.dynamite.a) null);
            }
            throw new LoadingException("No result cursor", (com.google.android.gms.dynamite.a) null);
        }
        throw new LoadingException("DynamiteLoaderV2 was not cached.", (com.google.android.gms.dynamite.a) null);
    }

    private static DynamiteModule c(Context context, String str) {
        String valueOf = String.valueOf(str);
        Log.i("DynamiteModule", valueOf.length() != 0 ? "Selected local version of ".concat(valueOf) : new String("Selected local version of "));
        return new DynamiteModule(context.getApplicationContext());
    }

    @KeepForSdk
    public static int a(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".ModuleDescriptor");
            Class<?> loadClass = classLoader.loadClass(sb.toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (!declaredField.get(null).equals(str)) {
                String valueOf = String.valueOf(declaredField.get(null));
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 51 + String.valueOf(str).length());
                sb2.append("Module descriptor id '");
                sb2.append(valueOf);
                sb2.append("' didn't match expected id '");
                sb2.append(str);
                sb2.append("'");
                Log.e("DynamiteModule", sb2.toString());
                return 0;
            }
            return declaredField2.getInt(null);
        } catch (ClassNotFoundException unused) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 45);
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            Log.w("DynamiteModule", sb3.toString());
            return 0;
        } catch (Exception e2) {
            String valueOf2 = String.valueOf(e2.getMessage());
            Log.e("DynamiteModule", valueOf2.length() != 0 ? "Failed to load module descriptor class: ".concat(valueOf2) : new String("Failed to load module descriptor class: "));
            return 0;
        }
    }

    private static Boolean b() {
        Boolean valueOf;
        synchronized (DynamiteModule.class) {
            valueOf = Boolean.valueOf(f11323e >= 2);
        }
        return valueOf;
    }

    public static int a(Context context, String str, boolean z) {
        Class<?> loadClass;
        Field declaredField;
        Boolean bool;
        try {
            synchronized (DynamiteModule.class) {
                Boolean bool2 = f11319a;
                if (bool2 == null) {
                    try {
                        loadClass = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName());
                        declaredField = loadClass.getDeclaredField("sClassLoader");
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e2) {
                        String valueOf = String.valueOf(e2);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 30);
                        sb.append("Failed to load module via V2: ");
                        sb.append(valueOf);
                        Log.w("DynamiteModule", sb.toString());
                        bool2 = Boolean.FALSE;
                    }
                    synchronized (loadClass) {
                        ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                        if (classLoader != null) {
                            if (classLoader == ClassLoader.getSystemClassLoader()) {
                                bool = Boolean.FALSE;
                            } else {
                                try {
                                    a(classLoader);
                                } catch (LoadingException unused) {
                                }
                                bool = Boolean.TRUE;
                            }
                        } else if ("com.google.android.gms".equals(context.getApplicationContext().getPackageName())) {
                            declaredField.set(null, ClassLoader.getSystemClassLoader());
                            bool = Boolean.FALSE;
                        } else {
                            try {
                                int c2 = c(context, str, z);
                                if (f11322d != null && !f11322d.isEmpty()) {
                                    h hVar = new h(f11322d, ClassLoader.getSystemClassLoader());
                                    a(hVar);
                                    declaredField.set(null, hVar);
                                    f11319a = Boolean.TRUE;
                                    return c2;
                                }
                                return c2;
                            } catch (LoadingException unused2) {
                                declaredField.set(null, ClassLoader.getSystemClassLoader());
                                bool = Boolean.FALSE;
                            }
                        }
                        bool2 = bool;
                        f11319a = bool2;
                    }
                }
                if (bool2.booleanValue()) {
                    try {
                        return c(context, str, z);
                    } catch (LoadingException e3) {
                        String valueOf2 = String.valueOf(e3.getMessage());
                        Log.w("DynamiteModule", valueOf2.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf2) : new String("Failed to retrieve remote module version: "));
                        return 0;
                    }
                }
                return b(context, str, z);
            }
        } catch (Throwable th) {
            CrashUtils.a(context, th);
            throw th;
        }
    }

    private static DynamiteModule a(Context context, String str, int i2) throws LoadingException {
        Boolean bool;
        IObjectWrapper a2;
        try {
            synchronized (DynamiteModule.class) {
                bool = f11319a;
            }
            if (bool != null) {
                if (bool.booleanValue()) {
                    return b(context, str, i2);
                }
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
                sb.append("Selected remote version of ");
                sb.append(str);
                sb.append(", version >= ");
                sb.append(i2);
                Log.i("DynamiteModule", sb.toString());
                zzi a3 = a(context);
                if (a3 != null) {
                    if (a3.l() >= 2) {
                        a2 = a3.b(ObjectWrapper.a(context), str, i2);
                    } else {
                        Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                        a2 = a3.a(ObjectWrapper.a(context), str, i2);
                    }
                    if (ObjectWrapper.a(a2) != null) {
                        return new DynamiteModule((Context) ObjectWrapper.a(a2));
                    }
                    throw new LoadingException("Failed to load remote module.", (com.google.android.gms.dynamite.a) null);
                }
                throw new LoadingException("Failed to create IDynamiteLoader.", (com.google.android.gms.dynamite.a) null);
            }
            throw new LoadingException("Failed to determine which loading route to use.", (com.google.android.gms.dynamite.a) null);
        } catch (RemoteException e2) {
            throw new LoadingException("Failed to load remote module.", e2, null);
        } catch (LoadingException e3) {
            throw e3;
        } catch (Throwable th) {
            CrashUtils.a(context, th);
            throw new LoadingException("Failed to load remote module.", th, null);
        }
    }

    private static zzi a(Context context) {
        zzi zzjVar;
        synchronized (DynamiteModule.class) {
            if (f11320b != null) {
                return f11320b;
            }
            if (GoogleApiAvailabilityLight.a().c(context) != 0) {
                return null;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzjVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    if (queryLocalInterface instanceof zzi) {
                        zzjVar = (zzi) queryLocalInterface;
                    } else {
                        zzjVar = new zzj(iBinder);
                    }
                }
                if (zzjVar != null) {
                    f11320b = zzjVar;
                    return zzjVar;
                }
            } catch (Exception e2) {
                String valueOf = String.valueOf(e2.getMessage());
                Log.e("DynamiteModule", valueOf.length() != 0 ? "Failed to load IDynamiteLoader from GmsCore: ".concat(valueOf) : new String("Failed to load IDynamiteLoader from GmsCore: "));
            }
            return null;
        }
    }

    @KeepForSdk
    public final Context a() {
        return this.n;
    }

    private static void a(ClassLoader classLoader) throws LoadingException {
        zzk zzlVar;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zzlVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof zzk) {
                    zzlVar = (zzk) queryLocalInterface;
                } else {
                    zzlVar = new zzl(iBinder);
                }
            }
            f11321c = zzlVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            throw new LoadingException("Failed to instantiate dynamite loader", e2, null);
        }
    }

    @KeepForSdk
    public final IBinder a(String str) throws LoadingException {
        try {
            return (IBinder) this.n.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
            String valueOf = String.valueOf(str);
            throw new LoadingException(valueOf.length() != 0 ? "Failed to instantiate module class: ".concat(valueOf) : new String("Failed to instantiate module class: "), e2, null);
        }
    }
}
