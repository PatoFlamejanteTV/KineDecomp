package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
public class zzdl {
    private static final String TAG = "zzdl";
    protected Context zzsp;
    private ExecutorService zzsq;
    private DexClassLoader zzsr;
    private zzcw zzss;
    private byte[] zzst;
    private boolean zzsw;
    private zzco zzsz;
    private Map<Pair<String, String>, zzes> zztc;
    private volatile AdvertisingIdClient zzsu = null;
    private volatile boolean zzrp = false;
    private Future zzsv = null;
    private volatile zzbl zzsx = null;
    private Future zzsy = null;
    private boolean zzta = false;
    private boolean zztb = false;
    private boolean zztd = false;
    private boolean zzte = true;
    private boolean zztf = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (!"android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                    zzdl.this.zzte = false;
                    return;
                }
                return;
            }
            zzdl.this.zzte = true;
        }

        /* synthetic */ a(zzdl zzdlVar, Kj kj) {
            this();
        }
    }

    private zzdl(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.zzsw = applicationContext != null;
        this.zzsp = this.zzsw ? applicationContext : context;
        this.zztc = new HashMap();
    }

    public static zzdl zza(Context context, String str, String str2, boolean z) {
        zzdl zzdlVar = new zzdl(context);
        try {
            zzdlVar.zzsq = Executors.newCachedThreadPool(new Kj());
            zzdlVar.zzrp = z;
            if (z) {
                zzdlVar.zzsv = zzdlVar.zzsq.submit(new Lj(zzdlVar));
            }
            zzdlVar.zzsq.execute(new Nj(zzdlVar));
            try {
                GoogleApiAvailabilityLight a2 = GoogleApiAvailabilityLight.a();
                zzdlVar.zzta = a2.b(zzdlVar.zzsp) > 0;
                zzdlVar.zztb = a2.c(zzdlVar.zzsp) == 0;
            } catch (Throwable unused) {
            }
            zzdlVar.zza(0, true);
            if (zzds.isMainThread() && ((Boolean) zzwu.zzpz().zzd(zzaan.zzctr)).booleanValue()) {
                throw new IllegalStateException("Task Context initialization must not be called from the UI thread.");
            }
            zzdlVar.zzss = new zzcw(null);
            try {
                zzdlVar.zzst = zzdlVar.zzss.zzl(str);
                try {
                    try {
                        try {
                            try {
                                File cacheDir = zzdlVar.zzsp.getCacheDir();
                                if (cacheDir == null && (cacheDir = zzdlVar.zzsp.getDir("dex", 0)) == null) {
                                    throw new zzdi();
                                }
                                File file = new File(String.format("%s/%s.jar", cacheDir, "1529567361524"));
                                if (!file.exists()) {
                                    byte[] zza = zzdlVar.zzss.zza(zzdlVar.zzst, str2);
                                    file.createNewFile();
                                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                                    fileOutputStream.write(zza, 0, zza.length);
                                    fileOutputStream.close();
                                }
                                zzdlVar.zzb(cacheDir, "1529567361524");
                                try {
                                    zzdlVar.zzsr = new DexClassLoader(file.getAbsolutePath(), cacheDir.getAbsolutePath(), null, zzdlVar.zzsp.getClassLoader());
                                    zzb(file);
                                    zzdlVar.zza(cacheDir, "1529567361524");
                                    zzm(String.format("%s/%s.dex", cacheDir, "1529567361524"));
                                    if (!zzdlVar.zztf) {
                                        IntentFilter intentFilter = new IntentFilter();
                                        intentFilter.addAction("android.intent.action.USER_PRESENT");
                                        intentFilter.addAction("android.intent.action.SCREEN_OFF");
                                        zzdlVar.zzsp.registerReceiver(new a(zzdlVar, null), intentFilter);
                                        zzdlVar.zztf = true;
                                    }
                                    zzdlVar.zzsz = new zzco(zzdlVar);
                                    zzdlVar.zztd = true;
                                } catch (Throwable th) {
                                    zzb(file);
                                    zzdlVar.zza(cacheDir, "1529567361524");
                                    zzm(String.format("%s/%s.dex", cacheDir, "1529567361524"));
                                    throw th;
                                }
                            } catch (NullPointerException e2) {
                                throw new zzdi(e2);
                            }
                        } catch (zzcx e3) {
                            throw new zzdi(e3);
                        }
                    } catch (IOException e4) {
                        throw new zzdi(e4);
                    }
                } catch (FileNotFoundException e5) {
                    throw new zzdi(e5);
                }
            } catch (zzcx e6) {
                throw new zzdi(e6);
            }
        } catch (zzdi unused2) {
        }
        return zzdlVar;
    }

    public final void zzam() {
        try {
            if (this.zzsu == null && this.zzsw) {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.zzsp);
                advertisingIdClient.start();
                this.zzsu = advertisingIdClient;
            }
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException unused) {
            this.zzsu = null;
        }
    }

    private final zzbl zzan() {
        try {
            return zzbjd.zzk(this.zzsp, this.zzsp.getPackageName(), Integer.toString(this.zzsp.getPackageManager().getPackageInfo(this.zzsp.getPackageName(), 0).versionCode));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void zzb(File file) {
        if (!file.exists()) {
            Log.d(TAG, String.format("File %s not found. No need for deletion", file.getAbsolutePath()));
        } else {
            file.delete();
        }
    }

    private static void zzm(String str) {
        zzb(new File(str));
    }

    public final Context getContext() {
        return this.zzsp;
    }

    public final boolean isInitialized() {
        return this.zztd;
    }

    public final ExecutorService zzac() {
        return this.zzsq;
    }

    public final DexClassLoader zzad() {
        return this.zzsr;
    }

    public final zzcw zzae() {
        return this.zzss;
    }

    public final byte[] zzaf() {
        return this.zzst;
    }

    public final boolean zzag() {
        return this.zzta;
    }

    public final zzco zzah() {
        return this.zzsz;
    }

    public final boolean zzai() {
        return this.zztb;
    }

    public final boolean zzaj() {
        return this.zzte;
    }

    public final zzbl zzak() {
        return this.zzsx;
    }

    public final Future zzal() {
        return this.zzsy;
    }

    public final AdvertisingIdClient zzao() {
        if (!this.zzrp) {
            return null;
        }
        if (this.zzsu != null) {
            return this.zzsu;
        }
        Future future = this.zzsv;
        if (future != null) {
            try {
                future.get(2000L, TimeUnit.MILLISECONDS);
                this.zzsv = null;
            } catch (InterruptedException | ExecutionException unused) {
            } catch (TimeoutException unused2) {
                this.zzsv.cancel(true);
            }
        }
        return this.zzsu;
    }

    public final int zzy() {
        if (this.zzsz != null) {
            return zzco.zzy();
        }
        return Integer.MIN_VALUE;
    }

    private final boolean zzb(File file, String str) {
        FileInputStream fileInputStream;
        File file2 = new File(String.format("%s/%s.tmp", file, str));
        if (!file2.exists()) {
            return false;
        }
        File file3 = new File(String.format("%s/%s.dex", file, str));
        if (file3.exists()) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            long length = file2.length();
            if (length <= 0) {
                zzb(file2);
                return false;
            }
            byte[] bArr = new byte[(int) length];
            fileInputStream = new FileInputStream(file2);
            try {
                try {
                    if (fileInputStream.read(bArr) <= 0) {
                        Log.d(TAG, "Cannot read the cache data.");
                        zzb(file2);
                        try {
                            fileInputStream.close();
                        } catch (IOException unused) {
                        }
                        return false;
                    }
                    zzbp zzbpVar = new zzbp();
                    zzbuz.zza(zzbpVar, bArr);
                    zzbp zzbpVar2 = zzbpVar;
                    if (str.equals(new String(zzbpVar2.zzhn)) && Arrays.equals(zzbpVar2.zzhm, C0960jj.a(zzbpVar2.data)) && Arrays.equals(zzbpVar2.zzho, Build.VERSION.SDK.getBytes())) {
                        byte[] zza = this.zzss.zza(this.zzst, new String(zzbpVar2.data));
                        file3.createNewFile();
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file3);
                        try {
                            fileOutputStream2.write(zza, 0, zza.length);
                            try {
                                fileInputStream.close();
                            } catch (IOException unused2) {
                            }
                            try {
                                fileOutputStream2.close();
                            } catch (IOException unused3) {
                            }
                            return true;
                        } catch (zzcx | IOException | NoSuchAlgorithmException unused4) {
                            fileOutputStream = fileOutputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused5) {
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused6) {
                                }
                            }
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused7) {
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                    throw th;
                                } catch (IOException unused8) {
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    }
                    zzb(file2);
                    try {
                        fileInputStream.close();
                    } catch (IOException unused9) {
                    }
                    return false;
                } catch (zzcx | IOException | NoSuchAlgorithmException unused10) {
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (zzcx | IOException | NoSuchAlgorithmException unused11) {
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public final zzbl zzb(int i, boolean z) {
        if (i > 0 && z) {
            try {
                Thread.sleep(i * 1000);
            } catch (InterruptedException unused) {
            }
        }
        return zzan();
    }

    private final void zza(File file, String str) {
        FileInputStream fileInputStream;
        File file2 = new File(String.format("%s/%s.tmp", file, str));
        if (file2.exists()) {
            return;
        }
        File file3 = new File(String.format("%s/%s.dex", file, str));
        if (!file3.exists()) {
            return;
        }
        long length = file3.length();
        if (length <= 0) {
            return;
        }
        byte[] bArr = new byte[(int) length];
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file3);
            try {
                try {
                    if (fileInputStream.read(bArr) <= 0) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused) {
                        }
                        zzb(file3);
                        return;
                    }
                    zzbp zzbpVar = new zzbp();
                    zzbpVar.zzho = Build.VERSION.SDK.getBytes();
                    zzbpVar.zzhn = str.getBytes();
                    byte[] bytes = this.zzss.zzb(this.zzst, bArr).getBytes();
                    zzbpVar.data = bytes;
                    zzbpVar.zzhm = C0960jj.a(bytes);
                    file2.createNewFile();
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                    try {
                        byte[] zzb = zzbuz.zzb(zzbpVar);
                        fileOutputStream2.write(zzb, 0, zzb.length);
                        fileOutputStream2.close();
                        try {
                            fileInputStream.close();
                        } catch (IOException unused2) {
                        }
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused3) {
                        }
                        zzb(file3);
                    } catch (zzcx | IOException | NoSuchAlgorithmException unused4) {
                        fileOutputStream = fileOutputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused5) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused6) {
                            }
                        }
                        zzb(file3);
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused7) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused8) {
                            }
                        }
                        zzb(file3);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (zzcx | IOException | NoSuchAlgorithmException unused9) {
            }
        } catch (zzcx | IOException | NoSuchAlgorithmException unused10) {
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public final boolean zza(String str, String str2, Class<?>... clsArr) {
        if (this.zztc.containsKey(new Pair(str, str2))) {
            return false;
        }
        this.zztc.put(new Pair<>(str, str2), new zzes(this, str, str2, clsArr));
        return true;
    }

    public final Method zza(String str, String str2) {
        zzes zzesVar = this.zztc.get(new Pair(str, str2));
        if (zzesVar == null) {
            return null;
        }
        return zzesVar.zzax();
    }

    public final void zza(int i, boolean z) {
        if (this.zztb) {
            Future<?> submit = this.zzsq.submit(new Mj(this, i, z));
            if (i == 0) {
                this.zzsy = submit;
            }
        }
    }

    public static boolean zza(int i, zzbl zzblVar) {
        Long l;
        String str;
        if (i >= 4) {
            return false;
        }
        if (zzblVar == null) {
            return true;
        }
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzctu)).booleanValue() && ((str = zzblVar.zzdq) == null || str.equals("0000000000000000000000000000000000000000000000000000000000000000"))) {
            return true;
        }
        if (!((Boolean) zzwu.zzpz().zzd(zzaan.zzctv)).booleanValue()) {
            return false;
        }
        zzbq zzbqVar = zzblVar.zzgj;
        return zzbqVar == null || (l = zzbqVar.zzhh) == null || l.longValue() == -2;
    }
}
