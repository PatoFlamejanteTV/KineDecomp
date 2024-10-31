package com.google.firebase.remoteconfig;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.XmlResourceParser;
import android.os.AsyncTask;
import android.support.v7.widget.ActivityChooserView;
import android.util.Log;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.config.zzal;
import com.google.android.gms.internal.config.zzam;
import com.google.android.gms.internal.config.zzan;
import com.google.android.gms.internal.config.zzao;
import com.google.android.gms.internal.config.zzap;
import com.google.android.gms.internal.config.zzaq;
import com.google.android.gms.internal.config.zzar;
import com.google.android.gms.internal.config.zzas;
import com.google.android.gms.internal.config.zzat;
import com.google.android.gms.internal.config.zzau;
import com.google.android.gms.internal.config.zzav;
import com.google.android.gms.internal.config.zzaw;
import com.google.android.gms.internal.config.zzay;
import com.google.android.gms.internal.config.zze;
import com.google.android.gms.internal.config.zzj;
import com.google.android.gms.internal.config.zzk;
import com.google.android.gms.internal.config.zzv;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApp;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes2.dex */
public class FirebaseRemoteConfig {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f18068a = new byte[0];

    /* renamed from: b, reason: collision with root package name */
    private static FirebaseRemoteConfig f18069b;

    /* renamed from: c, reason: collision with root package name */
    private zzan f18070c;

    /* renamed from: d, reason: collision with root package name */
    private zzan f18071d;

    /* renamed from: e, reason: collision with root package name */
    private zzan f18072e;

    /* renamed from: f, reason: collision with root package name */
    private zzaq f18073f;

    /* renamed from: g, reason: collision with root package name */
    private final Context f18074g;

    /* renamed from: h, reason: collision with root package name */
    private final FirebaseApp f18075h;
    private final ReadWriteLock i = new ReentrantReadWriteLock(true);

    private FirebaseRemoteConfig(Context context, zzan zzanVar, zzan zzanVar2, zzan zzanVar3, zzaq zzaqVar) {
        this.f18074g = context;
        this.f18073f = zzaqVar == null ? new zzaq() : zzaqVar;
        this.f18073f.zzc(b(this.f18074g));
        this.f18070c = zzanVar;
        this.f18071d = zzanVar2;
        this.f18072e = zzanVar3;
        this.f18075h = FirebaseApp.a(this.f18074g);
    }

    @ShowFirstParty
    private static FirebaseRemoteConfig a(Context context) {
        FirebaseRemoteConfig firebaseRemoteConfig;
        zzan a2;
        zzan a3;
        zzaq zzaqVar;
        synchronized (FirebaseRemoteConfig.class) {
            if (f18069b == null) {
                zzav c2 = c(context);
                zzaq zzaqVar2 = null;
                zzan zzanVar = null;
                if (c2 == null) {
                    if (Log.isLoggable("FirebaseRemoteConfig", 3)) {
                        Log.d("FirebaseRemoteConfig", "No persisted config was found. Initializing from scratch.");
                    }
                    a2 = null;
                    a3 = null;
                    zzaqVar = null;
                } else {
                    if (Log.isLoggable("FirebaseRemoteConfig", 3)) {
                        Log.d("FirebaseRemoteConfig", "Initializing from persisted config.");
                    }
                    zzan a4 = a(c2.zzbp);
                    a2 = a(c2.zzbq);
                    a3 = a(c2.zzbr);
                    zzat zzatVar = c2.zzbs;
                    if (zzatVar != null) {
                        zzaqVar2 = new zzaq();
                        zzaqVar2.zzf(zzatVar.zzbj);
                        zzaqVar2.zza(zzatVar.zzbk);
                    }
                    if (zzaqVar2 != null) {
                        zzaw[] zzawVarArr = c2.zzbt;
                        HashMap hashMap = new HashMap();
                        if (zzawVarArr != null) {
                            for (zzaw zzawVar : zzawVarArr) {
                                hashMap.put(zzawVar.zzbn, new zzal(zzawVar.resourceId, zzawVar.zzbv));
                            }
                        }
                        zzaqVar2.zza(hashMap);
                    }
                    zzaqVar = zzaqVar2;
                    zzanVar = a4;
                }
                f18069b = new FirebaseRemoteConfig(context, zzanVar, a2, a3, zzaqVar);
            }
            firebaseRemoteConfig = f18069b;
        }
        return firebaseRemoteConfig;
    }

    private final long b(Context context) {
        try {
            return Wrappers.a(this.f18074g).b(context.getPackageName(), 0).lastUpdateTime;
        } catch (PackageManager.NameNotFoundException unused) {
            String packageName = context.getPackageName();
            StringBuilder sb = new StringBuilder(String.valueOf(packageName).length() + 25);
            sb.append("Package [");
            sb.append(packageName);
            sb.append("] was not found!");
            Log.e("FirebaseRemoteConfig", sb.toString());
            return 0L;
        }
    }

    public static FirebaseRemoteConfig c() {
        return a(FirebaseApp.c().b());
    }

    private final void d() {
        this.i.readLock().lock();
        try {
            AsyncTask.SERIAL_EXECUTOR.execute(new zzam(this.f18074g, this.f18070c, this.f18071d, this.f18072e, this.f18073f));
        } finally {
            this.i.readLock().unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r9v4 */
    private static zzav c(Context context) {
        FileInputStream fileInputStream;
        try {
            if (context == 0) {
                return null;
            }
            try {
                fileInputStream = context.openFileInput("persisted_config");
            } catch (FileNotFoundException e2) {
                e = e2;
                fileInputStream = null;
            } catch (IOException e3) {
                e = e3;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                context = 0;
                if (context != 0) {
                    try {
                        context.close();
                    } catch (IOException e4) {
                        Log.e("FirebaseRemoteConfig", "Failed to close persisted config file.", e4);
                    }
                }
                throw th;
            }
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                zzay zza = zzay.zza(byteArray, 0, byteArray.length);
                zzav zzavVar = new zzav();
                zzavVar.zza(zza);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e5) {
                        Log.e("FirebaseRemoteConfig", "Failed to close persisted config file.", e5);
                    }
                }
                return zzavVar;
            } catch (FileNotFoundException e6) {
                e = e6;
                if (Log.isLoggable("FirebaseRemoteConfig", 3)) {
                    Log.d("FirebaseRemoteConfig", "Persisted config file was not found.", e);
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e7) {
                        Log.e("FirebaseRemoteConfig", "Failed to close persisted config file.", e7);
                    }
                }
                return null;
            } catch (IOException e8) {
                e = e8;
                Log.e("FirebaseRemoteConfig", "Cannot initialize from persisted config.", e);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e9) {
                        Log.e("FirebaseRemoteConfig", "Failed to close persisted config file.", e9);
                    }
                }
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public long b(String str) {
        return b(str, "configns:firebase");
    }

    public long b(String str, String str2) {
        if (str2 == null) {
            return 0L;
        }
        this.i.readLock().lock();
        try {
            if (this.f18071d != null && this.f18071d.zzb(str, str2)) {
                try {
                    return Long.valueOf(new String(this.f18071d.zzc(str, str2), zzap.UTF_8)).longValue();
                } catch (NumberFormatException unused) {
                }
            }
            if (this.f18072e != null && this.f18072e.zzb(str, str2)) {
                try {
                    return Long.valueOf(new String(this.f18072e.zzc(str, str2), zzap.UTF_8)).longValue();
                } catch (NumberFormatException unused2) {
                }
            }
            return 0L;
        } finally {
            this.i.readLock().unlock();
        }
    }

    public FirebaseRemoteConfigInfo b() {
        zzao zzaoVar = new zzao();
        this.i.readLock().lock();
        try {
            zzaoVar.zzb(this.f18070c == null ? -1L : this.f18070c.getTimestamp());
            zzaoVar.zzf(this.f18073f.getLastFetchStatus());
            zzaoVar.setConfigSettings(new FirebaseRemoteConfigSettings.Builder().a(this.f18073f.isDeveloperModeEnabled()).a());
            return zzaoVar;
        } finally {
            this.i.readLock().unlock();
        }
    }

    public String c(String str) {
        return c(str, "configns:firebase");
    }

    public String c(String str, String str2) {
        if (str2 == null) {
            return "";
        }
        this.i.readLock().lock();
        try {
            if (this.f18071d == null || !this.f18071d.zzb(str, str2)) {
                return (this.f18072e == null || !this.f18072e.zzb(str, str2)) ? "" : new String(this.f18072e.zzc(str, str2), zzap.UTF_8);
            }
            return new String(this.f18071d.zzc(str, str2), zzap.UTF_8);
        } finally {
            this.i.readLock().unlock();
        }
    }

    private static zzan a(zzar zzarVar) {
        if (zzarVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (zzau zzauVar : zzarVar.zzbe) {
            String str = zzauVar.zzbn;
            HashMap hashMap2 = new HashMap();
            for (zzas zzasVar : zzauVar.zzbo) {
                hashMap2.put(zzasVar.zzbh, zzasVar.zzbi);
            }
            hashMap.put(str, hashMap2);
        }
        byte[][] bArr = zzarVar.zzbf;
        ArrayList arrayList = new ArrayList();
        for (byte[] bArr2 : bArr) {
            arrayList.add(bArr2);
        }
        return new zzan(hashMap, zzarVar.timestamp, arrayList);
    }

    public boolean a() {
        this.i.writeLock().lock();
        try {
            if (this.f18070c == null) {
                return false;
            }
            if (this.f18071d != null && this.f18070c.getTimestamp() <= this.f18071d.getTimestamp()) {
                return false;
            }
            long timestamp = this.f18070c.getTimestamp();
            this.f18071d = this.f18070c;
            this.f18071d.setTimestamp(System.currentTimeMillis());
            this.f18070c = new zzan(null, timestamp, null);
            d();
            this.i.writeLock().unlock();
            return true;
        } finally {
            this.i.writeLock().unlock();
        }
    }

    public void a(int i) {
        a(i, "configns:firebase");
    }

    public void a(int i, String str) {
        if (str == null) {
            if (Log.isLoggable("FirebaseRemoteConfig", 3)) {
                Log.d("FirebaseRemoteConfig", "namespace cannot be null for setDefaults.");
                return;
            }
            return;
        }
        this.i.readLock().lock();
        try {
            if (this.f18073f != null && this.f18073f.zzs() != null && this.f18073f.zzs().get(str) != null) {
                zzal zzalVar = this.f18073f.zzs().get(str);
                if (i == zzalVar.getResourceId() && this.f18073f.zzt() == zzalVar.zzp()) {
                    if (Log.isLoggable("FirebaseRemoteConfig", 3)) {
                        Log.d("FirebaseRemoteConfig", "Skipped setting defaults from resource file as this resource file was already applied.");
                    }
                    return;
                }
            }
            this.i.readLock().unlock();
            HashMap hashMap = new HashMap();
            try {
                XmlResourceParser xml = this.f18074g.getResources().getXml(i);
                String str2 = null;
                String str3 = null;
                String str4 = null;
                for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                    if (eventType == 2) {
                        str2 = xml.getName();
                    } else if (eventType == 3) {
                        if ("entry".equals(xml.getName()) && str3 != null && str4 != null) {
                            hashMap.put(str3, str4);
                            str3 = null;
                            str4 = null;
                        }
                        str2 = null;
                    } else if (eventType == 4) {
                        if ("key".equals(str2)) {
                            str3 = xml.getText();
                        } else if ("value".equals(str2)) {
                            str4 = xml.getText();
                        }
                    }
                }
                this.f18073f.zza(str, new zzal(i, this.f18073f.zzt()));
                a(hashMap, str, false);
            } catch (Exception e2) {
                Log.e("FirebaseRemoteConfig", "Caught exception while parsing XML resource. Skipping setDefaults.", e2);
            }
        } finally {
            this.i.readLock().unlock();
        }
    }

    private final void a(Map<String, Object> map, String str, boolean z) {
        if (str == null) {
            return;
        }
        boolean z2 = map == null || map.isEmpty();
        HashMap hashMap = new HashMap();
        if (!z2) {
            for (String str2 : map.keySet()) {
                Object obj = map.get(str2);
                if (obj instanceof String) {
                    hashMap.put(str2, ((String) obj).getBytes(zzap.UTF_8));
                } else if (obj instanceof Long) {
                    hashMap.put(str2, ((Long) obj).toString().getBytes(zzap.UTF_8));
                } else if (obj instanceof Integer) {
                    hashMap.put(str2, ((Integer) obj).toString().getBytes(zzap.UTF_8));
                } else if (obj instanceof Double) {
                    hashMap.put(str2, ((Double) obj).toString().getBytes(zzap.UTF_8));
                } else if (obj instanceof Float) {
                    hashMap.put(str2, ((Float) obj).toString().getBytes(zzap.UTF_8));
                } else if (obj instanceof byte[]) {
                    hashMap.put(str2, (byte[]) obj);
                } else if (obj instanceof Boolean) {
                    hashMap.put(str2, ((Boolean) obj).toString().getBytes(zzap.UTF_8));
                } else {
                    throw new IllegalArgumentException("The type of a default value needs to beone of String, Long, Double, Boolean, or byte[].");
                }
            }
        }
        this.i.writeLock().lock();
        try {
            if (z2) {
                if (this.f18072e != null && this.f18072e.zzb(str)) {
                    this.f18072e.zza(null, str);
                    this.f18072e.setTimestamp(System.currentTimeMillis());
                }
                return;
            }
            if (this.f18072e == null) {
                this.f18072e = new zzan(new HashMap(), System.currentTimeMillis(), null);
            }
            this.f18072e.zza(hashMap, str);
            this.f18072e.setTimestamp(System.currentTimeMillis());
            if (z) {
                this.f18073f.zzd(str);
            }
            d();
        } finally {
            this.i.writeLock().unlock();
        }
    }

    public void a(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        this.i.writeLock().lock();
        try {
            boolean isDeveloperModeEnabled = this.f18073f.isDeveloperModeEnabled();
            boolean a2 = firebaseRemoteConfigSettings == null ? false : firebaseRemoteConfigSettings.a();
            this.f18073f.zza(a2);
            if (isDeveloperModeEnabled != a2) {
                d();
            }
        } finally {
            this.i.writeLock().unlock();
        }
    }

    public boolean a(String str) {
        return a(str, "configns:firebase");
    }

    public boolean a(String str, String str2) {
        if (str2 == null) {
            return false;
        }
        this.i.readLock().lock();
        try {
            if (this.f18071d != null && this.f18071d.zzb(str, str2)) {
                String str3 = new String(this.f18071d.zzc(str, str2), zzap.UTF_8);
                if (zzap.zzm.matcher(str3).matches()) {
                    return true;
                }
                if (zzap.zzn.matcher(str3).matches()) {
                    return false;
                }
            }
            if (this.f18072e != null && this.f18072e.zzb(str, str2)) {
                String str4 = new String(this.f18072e.zzc(str, str2), zzap.UTF_8);
                if (zzap.zzm.matcher(str4).matches()) {
                    return true;
                }
                if (zzap.zzn.matcher(str4).matches()) {
                    return false;
                }
            }
            return false;
        } finally {
            this.i.readLock().unlock();
        }
    }

    public Task<Void> a(long j) {
        return a(j, new zzv(this.f18074g));
    }

    private final Task<Void> a(long j, zzv zzvVar) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.i.readLock().lock();
        try {
            zzj zzjVar = new zzj();
            zzjVar.zza(j);
            if (this.f18075h != null) {
                zzjVar.zza(this.f18075h.e().b());
            }
            if (this.f18073f.isDeveloperModeEnabled()) {
                zzjVar.zza("_rcn_developer", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            }
            zzjVar.zza(10300);
            zzan zzanVar = this.f18071d;
            int i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            if (zzanVar != null && this.f18071d.getTimestamp() != -1) {
                long convert = TimeUnit.SECONDS.convert(System.currentTimeMillis() - this.f18071d.getTimestamp(), TimeUnit.MILLISECONDS);
                zzjVar.zzc(convert < 2147483647L ? (int) convert : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            }
            if (this.f18070c != null && this.f18070c.getTimestamp() != -1) {
                long convert2 = TimeUnit.SECONDS.convert(System.currentTimeMillis() - this.f18070c.getTimestamp(), TimeUnit.MILLISECONDS);
                if (convert2 < 2147483647L) {
                    i = (int) convert2;
                }
                zzjVar.zzb(i);
            }
            zze.zzf.zza(zzvVar.asGoogleApiClient(), zzjVar.zzg()).a(new a(this, taskCompletionSource));
            this.i.readLock().unlock();
            return taskCompletionSource.a();
        } catch (Throwable th) {
            this.i.readLock().unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(TaskCompletionSource<Void> taskCompletionSource, zzk zzkVar) {
        if (zzkVar != null && zzkVar.getStatus() != null) {
            int statusCode = zzkVar.getStatus().getStatusCode();
            this.i.writeLock().lock();
            try {
                if (statusCode != -6508) {
                    if (statusCode != 6507) {
                        if (statusCode != -6506) {
                            if (statusCode != -6505) {
                                switch (statusCode) {
                                    case 6500:
                                    case 6501:
                                    case 6503:
                                    case 6504:
                                        a(taskCompletionSource, zzkVar.getStatus());
                                        break;
                                    case 6502:
                                        break;
                                    default:
                                        if (zzkVar.getStatus().Q()) {
                                            StringBuilder sb = new StringBuilder(45);
                                            sb.append("Unknown (successful) status code: ");
                                            sb.append(statusCode);
                                            Log.w("FirebaseRemoteConfig", sb.toString());
                                        }
                                        a(taskCompletionSource, zzkVar.getStatus());
                                        break;
                                }
                            } else {
                                Map<String, Set<String>> zzi = zzkVar.zzi();
                                HashMap hashMap = new HashMap();
                                for (String str : zzi.keySet()) {
                                    HashMap hashMap2 = new HashMap();
                                    for (String str2 : zzi.get(str)) {
                                        hashMap2.put(str2, zzkVar.zza(str2, null, str));
                                    }
                                    hashMap.put(str, hashMap2);
                                }
                                this.f18070c = new zzan(hashMap, System.currentTimeMillis(), zzkVar.zzh());
                                this.f18073f.zzf(-1);
                                taskCompletionSource.a((TaskCompletionSource<Void>) null);
                                d();
                            }
                            this.i.writeLock().unlock();
                            return;
                        }
                    }
                    this.f18073f.zzf(2);
                    taskCompletionSource.a(new FirebaseRemoteConfigFetchThrottledException(zzkVar.getThrottleEndTimeMillis()));
                    d();
                    this.i.writeLock().unlock();
                    return;
                }
                this.f18073f.zzf(-1);
                if (this.f18070c != null && !this.f18070c.zzr()) {
                    Map<String, Set<String>> zzi2 = zzkVar.zzi();
                    HashMap hashMap3 = new HashMap();
                    for (String str3 : zzi2.keySet()) {
                        HashMap hashMap4 = new HashMap();
                        for (String str4 : zzi2.get(str3)) {
                            hashMap4.put(str4, zzkVar.zza(str4, null, str3));
                        }
                        hashMap3.put(str3, hashMap4);
                    }
                    this.f18070c = new zzan(hashMap3, this.f18070c.getTimestamp(), zzkVar.zzh());
                }
                taskCompletionSource.a((TaskCompletionSource<Void>) null);
                d();
                this.i.writeLock().unlock();
                return;
            } catch (Throwable th) {
                this.i.writeLock().unlock();
                throw th;
            }
        }
        a(taskCompletionSource, (Status) null);
    }

    private final void a(TaskCompletionSource<Void> taskCompletionSource, Status status) {
        if (status == null) {
            Log.w("FirebaseRemoteConfig", "Received null IPC status for failure.");
        } else {
            int statusCode = status.getStatusCode();
            String O = status.O();
            StringBuilder sb = new StringBuilder(String.valueOf(O).length() + 25);
            sb.append("IPC failure: ");
            sb.append(statusCode);
            sb.append(":");
            sb.append(O);
            Log.w("FirebaseRemoteConfig", sb.toString());
        }
        this.i.writeLock().lock();
        try {
            this.f18073f.zzf(1);
            taskCompletionSource.a(new FirebaseRemoteConfigFetchException());
            d();
        } finally {
            this.i.writeLock().unlock();
        }
    }
}
