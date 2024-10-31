package com.adobe.creativesdk.foundation.internal.cache;

import android.os.Handler;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.internal.utils.w;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.apache.commons.io.filefilter.TrueFileFilter;

/* compiled from: AdobeCommonCacheInstance.java */
/* loaded from: classes.dex */
public class o {
    private String i;
    private p k;
    private String l;
    private String m;
    private AdobeCommonCachePolicies p;
    private double q;
    private double r;
    private int s;
    private int t;
    private int u;
    private boolean v;
    private final ExecutorService w;
    private ScheduledFuture<?> z;
    private final int n = 3;
    private final int o = 10;
    private final boolean x = true;
    private final ScheduledExecutorService y = Executors.newSingleThreadScheduledExecutor();
    private boolean j = true;

    /* renamed from: h */
    private long f4988h = 0;

    /* renamed from: f */
    private final Comparator<Map.Entry<String, Long>> f4986f = new h(this);

    /* renamed from: e */
    private final Comparator<Map.Entry<String, Long>> f4985e = new i(this);

    /* renamed from: g */
    private final Comparator<Date> f4987g = new j(this);

    /* renamed from: b */
    private final Map<String, Long> f4982b = new ConcurrentHashMap();

    /* renamed from: c */
    private final Map<String, Long> f4983c = new ConcurrentHashMap();

    /* renamed from: d */
    private final Map<String, Long> f4984d = new ConcurrentHashMap();

    /* renamed from: a */
    private final ReentrantReadWriteLock f4981a = new ReentrantReadWriteLock();

    public o(ExecutorService executorService) {
        this.w = executorService;
    }

    public int h() {
        return (int) (this.r * 0.85d);
    }

    private void i() {
        String str = this.l;
        if (str == null || str.isEmpty()) {
            b("Cannot create the disk cache metadata.  Non-existent disk cache.");
        }
        try {
            this.f4981a.readLock().lock();
            this.v = true;
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, o.class.getName(), "Got Read lock in initDiskCacheMetadata.Current lock count " + this.f4981a.getReadLockCount());
            File file = new File(this.l);
            if (!file.exists() && !file.mkdirs()) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, o.class.getName(), "Error creating disk cache. Folder creation not successful");
            }
            try {
                for (File file2 : (List) org.apache.commons.io.b.a(file, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE)) {
                    if (!file2.isDirectory() && !file2.isHidden()) {
                        a(file2, file2.getAbsolutePath().substring(file2.getAbsolutePath().indexOf(this.m) + this.m.length() + 1));
                    }
                }
            } catch (RuntimeException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, o.class.getName(), "Error initializing disk cache", e2);
            }
        } finally {
            this.v = false;
            this.f4981a.readLock().unlock();
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, o.class.getName(), "Read lock released in initDiskCacheMetadata.Holding " + this.f4981a.getReadLockCount());
        }
    }

    private void j() {
        try {
            this.f4981a.readLock().lock();
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, o.class.getName(), "Got Read lock in printDiskCacheMetadata.Current lock count " + this.f4981a.getReadLockCount());
            b("============================================");
            b("Disk Cache Size:" + this.f4988h);
            b("Disk Cache Location: " + this.l);
            if (this.p == AdobeCommonCachePolicies.AdobeCommonCacheEvictionLSF) {
                List<Map.Entry<String, Long>> a2 = a(this.f4984d, this.f4985e);
                b("============================================");
                b("Eviction Policy: Large Size First");
                b("Sorted Object Size Dictionary");
                for (Map.Entry<String, Long> entry : a2) {
                    b(entry.getKey() + " : " + entry.getValue() + "bytes");
                }
            }
            if (this.p == AdobeCommonCachePolicies.AdobeCommonCacheEvictionLRU) {
                List<Map.Entry<String, Long>> a3 = a(this.f4983c, this.f4985e);
                b("============================================");
                b("Eviction Policy: Least Recently Used");
                b("Sorted Access Times Dictionary");
                for (Map.Entry<String, Long> entry2 : a3) {
                    b(entry2.getKey() + " : " + DateFormat.getInstance().format(new Date(entry2.getValue().longValue())));
                }
            }
            b("");
        } finally {
            this.f4981a.readLock().unlock();
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, o.class.getName(), "Read lock released in printDiskCacheMetadata.Holding " + this.f4981a.getReadLockCount());
        }
    }

    private void k() {
        ScheduledFuture<?> scheduledFuture = this.z;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.z = this.y.scheduleAtFixedRate(new l(this), 0L, 60000L, TimeUnit.MILLISECONDS);
    }

    public void l() {
        ScheduledFuture<?> scheduledFuture = this.z;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.z = null;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        e();
    }

    public void d() {
        AdobeCommonCacheEvictionType adobeCommonCacheEvictionType;
        Integer valueOf;
        if (this.f4988h > f()) {
            adobeCommonCacheEvictionType = AdobeCommonCacheEvictionType.AdobeCommonCacheCriticalEviction;
            valueOf = Integer.valueOf(f());
        } else {
            adobeCommonCacheEvictionType = AdobeCommonCacheEvictionType.AdobeCommonCacheNormalEviction;
            valueOf = Integer.valueOf(h());
        }
        b(String.format("%s eviction: %d > %d", adobeCommonCacheEvictionType.toString(), Long.valueOf(this.f4988h), valueOf));
        if (g.f4963a[this.p.ordinal()] != 1) {
            b(adobeCommonCacheEvictionType);
        } else {
            a(adobeCommonCacheEvictionType);
        }
        this.f4988h = g();
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(this.f4988h);
        objArr[1] = valueOf;
        objArr[2] = this.f4988h > ((long) valueOf.intValue()) ? "UNORDERED" : "in order";
        b(String.format("After eviction: %d - %d are %s", objArr));
    }

    private void e() {
        this.k.evictAll();
    }

    private int f() {
        return (int) (this.r * 0.95d);
    }

    private long g() {
        Iterator<Map.Entry<String, Long>> it = this.f4984d.entrySet().iterator();
        long j = 0;
        while (it.hasNext()) {
            j += it.next().getValue().longValue();
        }
        return j;
    }

    public void c() {
        double d2;
        double d3;
        b("=====================================================");
        b("Cache Stats:");
        b("");
        int i = this.s;
        int i2 = this.t;
        int i3 = this.u;
        int i4 = i + i2 + i3;
        double d4 = 0.0d;
        if (i4 != 0) {
            double d5 = i;
            Double.isNaN(d5);
            double d6 = i4;
            Double.isNaN(d6);
            d4 = (d5 * 100.0d) / d6;
            double d7 = i2;
            Double.isNaN(d7);
            Double.isNaN(d6);
            d2 = (d7 * 100.0d) / d6;
            double d8 = i3;
            Double.isNaN(d8);
            Double.isNaN(d6);
            d3 = (d8 * 100.0d) / d6;
        } else {
            d2 = 0.0d;
            d3 = 0.0d;
        }
        b(String.format("%s %6.2f%% %6d", "Memory cache hit rate:", Double.valueOf(d4), Integer.valueOf(this.s)));
        b(String.format("%s %6.2f%% %6d", "Disk cache hit rate:", Double.valueOf(d2), Integer.valueOf(this.t)));
        b(String.format("%s %6.2f%% %6d", "Cache miss rate:", Double.valueOf(d3), Integer.valueOf(this.u)));
        b(String.format("%s %6.2f%% %6d", "Total:", Double.valueOf(d4 + d2 + d3), Integer.valueOf(i4)));
        b("");
        b("");
        double d9 = this.f4988h;
        Double.isNaN(d9);
        b(String.format("Disk Cache Usage: %6.2f%% %d bytes", Double.valueOf((d9 * 100.0d) / this.r), Long.valueOf(this.f4988h)));
        b("");
        b("=====================================================");
        b("");
    }

    private void e(String str, String str2) {
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, o.class.getName(), "Disk cache eviction for key:" + str + ".Type: " + str2);
    }

    public String b() {
        return this.i;
    }

    public void b(String str) {
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, o.class.getName(), str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.io.ObjectInputStream] */
    private <T> T b(String str, String str2, EnumSet<AdobeCommonCacheOptions> enumSet) {
        FileInputStream fileInputStream;
        Object obj;
        Level level;
        String name;
        String message;
        Date date = new Date();
        FileInputStream fileInputStream2 = null;
        if (!this.j) {
            return null;
        }
        try {
            this.f4981a.readLock().lock();
            Level level2 = Level.INFO;
            String name2 = o.class.getName();
            ?? r6 = "Got Read lock in getObjectFromDiskWithGUID.Current lock count " + this.f4981a.getReadLockCount();
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(level2, name2, (String) r6);
            File file = new File(c(str), str2);
            try {
                if (!file.exists()) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, o.class.getName(), "Disk Miss for key " + str2);
                    return null;
                }
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        r6 = new ObjectInputStream(fileInputStream);
                    } catch (IOException e2) {
                        e = e2;
                        r6 = 0;
                        obj = null;
                    } catch (ClassNotFoundException e3) {
                        e = e3;
                        r6 = 0;
                        obj = null;
                    } catch (Throwable th) {
                        th = th;
                        r6 = 0;
                    }
                } catch (IOException e4) {
                    e = e4;
                    r6 = 0;
                    obj = null;
                } catch (ClassNotFoundException e5) {
                    e = e5;
                    r6 = 0;
                    obj = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                    r6 = 0;
                }
                try {
                    try {
                        obj = r6.readObject();
                        a(str, str2, new Date().getTime() - date.getTime());
                        a(file, d(str, str2));
                    } catch (IOException e6) {
                        e = e6;
                        obj = null;
                    } catch (ClassNotFoundException e7) {
                        e = e7;
                        obj = null;
                    }
                    try {
                        if (enumSet.contains(AdobeCommonCacheOptions.AdobeCommonCacheKeepInMemoryCache) && this.q > 0.0d) {
                            this.k.put(d(str, str2), obj);
                        }
                    } catch (IOException e8) {
                        e = e8;
                        fileInputStream2 = fileInputStream;
                        r6 = r6;
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, o.class.getName(), "Unable to read map from cache", e);
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e9) {
                                e = e9;
                                level = Level.ERROR;
                                name = o.class.getName();
                                message = e.getMessage();
                                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(level, name, message, e);
                                return (T) obj;
                            }
                        }
                        if (r6 != 0) {
                            r6.close();
                        }
                        return (T) obj;
                    } catch (ClassNotFoundException e10) {
                        e = e10;
                        fileInputStream2 = fileInputStream;
                        r6 = r6;
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, o.class.getName(), "Unable to read map from cache", e);
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e11) {
                                e = e11;
                                level = Level.ERROR;
                                name = o.class.getName();
                                message = e.getMessage();
                                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(level, name, message, e);
                                return (T) obj;
                            }
                        }
                        if (r6 != 0) {
                            r6.close();
                        }
                        return (T) obj;
                    }
                    try {
                        fileInputStream.close();
                        r6.close();
                    } catch (IOException e12) {
                        e = e12;
                        level = Level.ERROR;
                        name = o.class.getName();
                        message = e.getMessage();
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(level, name, message, e);
                        return (T) obj;
                    }
                    return (T) obj;
                } catch (Throwable th3) {
                    th = th3;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e13) {
                            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, o.class.getName(), e13.getMessage(), e13);
                            throw th;
                        }
                    }
                    if (r6 != 0) {
                        r6.close();
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                fileInputStream = fileInputStream2;
            }
        } finally {
            this.f4981a.readLock().unlock();
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, o.class.getName(), "Read lock released in getObjectFromDiskWithGUID.Holding " + this.f4981a.getReadLockCount());
        }
    }

    public void a() {
        e();
        if (this.z != null) {
            l();
        }
        try {
            try {
                this.f4981a.writeLock().lock();
                org.apache.commons.io.b.b(new File(this.l));
                b("Cache with cache name " + this.m + " deleted from location " + this.l);
            } catch (IOException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, o.class.getName(), "Error deleting cache directory", e2);
                b("Unable to delete cache " + this.m + " from location " + this.l);
            }
        } finally {
            this.f4981a.writeLock().unlock();
        }
    }

    private void d(String str) {
        long longValue = this.f4984d.containsKey(str) ? this.f4984d.get(str).longValue() : 0L;
        long longValue2 = this.f4982b.containsKey(str) ? this.f4982b.get(str).longValue() : 0L;
        long longValue3 = this.f4983c.containsKey(str) ? this.f4983c.get(str).longValue() : 0L;
        if (this.f4984d.get(str) != null) {
            this.f4988h -= this.f4984d.get(str).longValue();
        }
        if (longValue != 0) {
            this.f4983c.remove(str);
        }
        if (longValue2 != 0) {
            this.f4982b.remove(str);
        }
        if (longValue3 != 0) {
            this.f4984d.remove(str);
        }
        if (longValue != 0 && longValue2 != 0 && longValue3 != 0) {
            b(String.format("( %d ): Deleted metadata from %s: (AT: %s) (CT: %s) (Sz: %d)", Long.valueOf(this.f4988h), str, Long.valueOf(longValue3), Long.valueOf(longValue2), Long.valueOf(longValue)));
        }
        if (this.f4988h >= h() || this.z == null) {
            return;
        }
        b("===== Sync stop timer at " + SimpleDateFormat.getInstance().format(new Date()));
        b(String.format("Stopping eviction timer: %d < %d", Long.valueOf(this.f4988h), Integer.valueOf(h())));
        l();
    }

    public void a(String str, String str2, String str3, int i, double d2, AdobeCommonCachePolicies adobeCommonCachePolicies, boolean z) {
        String str4;
        if (str2 == null) {
            b("Cannot configure a cache without an adobeID");
            return;
        }
        this.m = str;
        this.i = str2;
        this.p = adobeCommonCachePolicies;
        this.k = new p(i);
        String str5 = str + str2;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            try {
                messageDigest.update(str5.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeCommonCache::configureCache", "ConfigureCache failed because of encoding exception", e2);
            }
            String a2 = w.a(messageDigest.digest());
            if (z) {
                str4 = a2 + '7';
            } else {
                str4 = a2 + '8';
            }
            this.l = str3 + File.separator + str4 + File.separator + this.m;
            this.q = i <= 200 ? i : 200.0d;
            this.r = d2 <= 2.68435456E8d ? d2 : 2.68435456E8d;
            e();
        } catch (NoSuchAlgorithmException e3) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.WARN, o.class.getName(), "MD5 Hash not available. Using unencrypted string", e3);
        }
        i();
        if (this.f4988h > h()) {
            d();
        }
        j();
    }

    public void c(String str, String str2) {
        if (this.v) {
            return;
        }
        File file = null;
        if (str2 != null) {
            this.k.remove(d(str, str2));
            file = new File(c(str), str2);
        } else {
            e();
        }
        try {
            this.f4981a.writeLock().lock();
            if (file != null && file.exists()) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, o.class.getName(), "Removing " + str2 + " from disk cache");
                if (!file.delete()) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, o.class.getName(), "Cannot delete file " + file.getAbsolutePath());
                }
                d(d(str, str2));
            }
        } finally {
            this.f4981a.writeLock().unlock();
        }
    }

    public String d(String str, String str2) {
        if (str2 == null) {
            return str;
        }
        return str + File.separator + str2;
    }

    public File c(String str) {
        File file = new File(this.l, str);
        if (!file.exists() && !file.mkdirs()) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, o.class.getName(), "Folder creation not successful for path " + file.getAbsolutePath());
        }
        return file;
    }

    public void a(Object obj, String str, String str2, EnumSet<AdobeCommonCacheOptions> enumSet) {
        if (this.v) {
            return;
        }
        if (enumSet.contains(AdobeCommonCacheOptions.AdobeCommonCacheKeepInMemoryCache) && this.q > 0.0d) {
            this.k.put(d(str, str2), obj);
        }
        if (!enumSet.contains(AdobeCommonCacheOptions.AdobeCommonCacheKeepOnDiskCache) || this.r <= 0.0d) {
            return;
        }
        a((o) obj, str, str2);
    }

    private <T> void b(String str, String str2, EnumSet<AdobeCommonCacheOptions> enumSet, e<T> eVar, Handler handler) {
        Date date = new Date();
        if (this.j) {
            this.w.execute(new k(this, str, str2, eVar, handler, date, enumSet));
        } else {
            a(eVar, handler);
        }
    }

    public boolean a(String str, String str2) {
        if (this.k.get(d(str, str2)) != null) {
            return true;
        }
        String str3 = this.l + File.separator + d(str, str2);
        try {
            this.f4981a.readLock().lock();
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, o.class.getName(), "Got Read lock in containsItemWithGUID.Current lock count " + this.f4981a.getReadLockCount());
            return new File(str3).exists();
        } finally {
            this.f4981a.readLock().unlock();
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, o.class.getName(), "Released read lock in containsItemWithGUID.Current lock count " + this.f4981a.getReadLockCount());
        }
    }

    private void b(AdobeCommonCacheEvictionType adobeCommonCacheEvictionType) {
        Integer valueOf = Integer.valueOf(adobeCommonCacheEvictionType == AdobeCommonCacheEvictionType.AdobeCommonCacheCriticalEviction ? 10 : 3);
        Integer valueOf2 = Integer.valueOf(this.f4983c.size());
        List<Map.Entry<String, Long>> a2 = a(this.f4983c, this.f4986f);
        try {
            this.f4981a.writeLock().lock();
            for (int i = 0; i < valueOf.intValue() && i < valueOf2.intValue(); i++) {
                String key = a2.get(i).getKey();
                File file = new File(this.l, key);
                if (file.exists()) {
                    boolean delete = file.delete();
                    e(key, "LRU");
                    if (!delete) {
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, o.class.getName(), "Could not remove cached file in disk" + file.getAbsolutePath());
                    }
                } else {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, o.class.getName(), "File doesn't exist in disk: " + file.getAbsolutePath());
                }
                d(key);
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, o.class.getName(), "Removing file in cache : " + file.getAbsolutePath());
            }
        } finally {
            this.f4981a.writeLock().unlock();
        }
    }

    public void a(String str) {
        if (this.v) {
            return;
        }
        try {
            this.f4981a.writeLock().lock();
            File c2 = c(str);
            e();
            if (c2.exists() && c2.isDirectory()) {
                for (File file : (List) org.apache.commons.io.b.a(c2, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE)) {
                    String name = file.getName();
                    if (!file.isDirectory() && !name.equalsIgnoreCase("modified-data")) {
                        d(d(str, name));
                    }
                }
                try {
                    org.apache.commons.io.b.b(c2);
                } catch (IOException e2) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, o.class.getName(), "Error deleting directory from cache", e2);
                }
            }
        } finally {
            this.f4981a.writeLock().unlock();
        }
    }

    private void b(String str, String str2, long j) {
        this.s++;
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, o.class.getName(), "Mem cache hit for key:" + str2 + " with guid " + str + " and latency " + j);
    }

    public Date b(String str, String str2) {
        File file = new File(c(str), str2);
        if (file.exists()) {
            return new Date(file.lastModified());
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> void a(String str, String str2, EnumSet<AdobeCommonCacheOptions> enumSet, e<T> eVar, Handler handler) {
        if (str != null && str2 != null) {
            Date date = new Date();
            Object obj = this.k.get(d(str, str2));
            if (obj != null) {
                b(str, str2, new Date().getTime() - date.getTime());
                a((e<Handler>) eVar, handler, (Handler) obj, AdobeCommonCacheHitLocation.AdobeCommonCacheHitLocationMemory);
                return;
            } else {
                b(str, str2, enumSet, eVar, handler);
                return;
            }
        }
        a((e<Handler>) eVar, handler, (Handler) null, AdobeCommonCacheHitLocation.AdobeCommonCacheHitLocationMemory);
    }

    public <T> T a(String str, String str2, EnumSet<AdobeCommonCacheOptions> enumSet) {
        if (str == null || str2 == null) {
            return null;
        }
        T t = (T) this.k.get(d(str, str2));
        return t == null ? (T) b(str, str2, enumSet) : t;
    }

    private void a(AdobeCommonCacheEvictionType adobeCommonCacheEvictionType) {
        Integer valueOf = Integer.valueOf(adobeCommonCacheEvictionType == AdobeCommonCacheEvictionType.AdobeCommonCacheCriticalEviction ? 10 : 3);
        Integer valueOf2 = Integer.valueOf(this.f4984d.size());
        List<Map.Entry<String, Long>> a2 = a(this.f4984d, this.f4985e);
        try {
            this.f4981a.writeLock().lock();
            for (int i = 0; i < valueOf.intValue() && i < valueOf2.intValue(); i++) {
                String key = a2.get(i).getKey();
                try {
                    File file = new File(this.l + key);
                    if (file.exists()) {
                        org.apache.commons.io.b.b(file);
                        e(key, "LSF");
                    }
                    d(key);
                } catch (IOException e2) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, o.class.getName(), "Could not remove cached file", e2);
                }
            }
        } finally {
            this.f4981a.writeLock().unlock();
        }
    }

    private List<Map.Entry<String, Long>> a(Map<String, Long> map, Comparator<Map.Entry<String, Long>> comparator) {
        ArrayList arrayList = new ArrayList(map.entrySet());
        Collections.sort(arrayList, comparator);
        return arrayList;
    }

    public void a(File file, String str) {
        long lastModified = file.lastModified();
        long lastModified2 = file.lastModified();
        long length = file.length();
        if (!this.f4984d.containsKey(str)) {
            this.f4988h += length;
        }
        this.f4983c.put(str, Long.valueOf(lastModified2));
        this.f4982b.put(str, Long.valueOf(lastModified));
        this.f4984d.put(str, Long.valueOf(length));
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:0x0285, code lost:            if (r9.z == null) goto L263;     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0309, code lost:            k();     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0307, code lost:            if (r9.z == null) goto L263;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private <T> void a(T r10, java.lang.String r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 782
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.internal.cache.o.a(java.lang.Object, java.lang.String, java.lang.String):void");
    }

    public void a(String str, String str2, long j) {
        this.t++;
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, o.class.getName(), "Disk cache hit for key:" + str2 + " with guid " + str + " and latency " + j);
    }

    public void a(e eVar, Handler handler) {
        this.u++;
        m mVar = new m(this, eVar);
        if (handler != null) {
            handler.post(mVar);
        } else {
            new Thread(mVar).start();
        }
    }

    public <T> void a(e<T> eVar, Handler handler, T t, AdobeCommonCacheHitLocation adobeCommonCacheHitLocation) {
        if (handler != null) {
            handler.post(new n(this, eVar, t, adobeCommonCacheHitLocation));
        } else {
            new Thread(new f(this, eVar, t, adobeCommonCacheHitLocation)).start();
        }
    }

    public void a(boolean z) {
        this.v = z;
        this.j = !z;
    }
}
