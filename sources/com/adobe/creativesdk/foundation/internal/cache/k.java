package com.adobe.creativesdk.foundation.internal.cache;

import android.os.Handler;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.EnumSet;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeCommonCacheInstance.java */
/* loaded from: classes.dex */
public class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f4967a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f4968b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ e f4969c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Handler f4970d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Date f4971e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ EnumSet f4972f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ o f4973g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(o oVar, String str, String str2, e eVar, Handler handler, Date date, EnumSet enumSet) {
        this.f4973g = oVar;
        this.f4967a = str;
        this.f4968b = str2;
        this.f4969c = eVar;
        this.f4970d = handler;
        this.f4971e = date;
        this.f4972f = enumSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v10, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.io.ObjectInputStream] */
    @Override // java.lang.Runnable
    public void run() {
        ReentrantReadWriteLock reentrantReadWriteLock;
        ReentrantReadWriteLock reentrantReadWriteLock2;
        ReentrantReadWriteLock reentrantReadWriteLock3;
        ReentrantReadWriteLock reentrantReadWriteLock4;
        File c2;
        FileInputStream fileInputStream;
        Level level;
        String name;
        String message;
        String d2;
        double d3;
        p pVar;
        String d4;
        try {
            reentrantReadWriteLock3 = this.f4973g.f4981a;
            reentrantReadWriteLock3.readLock().lock();
            Level level2 = Level.INFO;
            String name2 = o.class.getName();
            ?? sb = new StringBuilder();
            sb.append("Got Read lock in getObjectFromDiskWithGUID.Current lock count ");
            reentrantReadWriteLock4 = this.f4973g.f4981a;
            ?? readLockCount = reentrantReadWriteLock4.getReadLockCount();
            sb.append(readLockCount);
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(level2, name2, sb.toString());
            c2 = this.f4973g.c(this.f4967a);
            File file = new File(c2, this.f4968b);
            if (!file.exists()) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, o.class.getName(), "Disk Miss for key " + this.f4968b);
                this.f4973g.a(this.f4969c, this.f4970d);
                return;
            }
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        readLockCount = new ObjectInputStream(fileInputStream);
                        try {
                            Object readObject = readLockCount.readObject();
                            this.f4973g.a(this.f4967a, this.f4968b, new Date().getTime() - this.f4971e.getTime());
                            o oVar = this.f4973g;
                            d2 = this.f4973g.d(this.f4967a, this.f4968b);
                            oVar.a(file, d2);
                            this.f4973g.a((e<Handler>) this.f4969c, this.f4970d, (Handler) readObject, AdobeCommonCacheHitLocation.AdobeCommonCacheHitLocationDisk);
                            if (this.f4972f.contains(AdobeCommonCacheOptions.AdobeCommonCacheKeepInMemoryCache)) {
                                d3 = this.f4973g.q;
                                if (d3 > 0.0d) {
                                    pVar = this.f4973g.k;
                                    d4 = this.f4973g.d(this.f4967a, this.f4968b);
                                    pVar.put(d4, readObject);
                                }
                            }
                        } catch (IOException e2) {
                            e = e2;
                            fileInputStream2 = fileInputStream;
                            readLockCount = readLockCount;
                            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, o.class.getName(), "Unable to read map from cache", e);
                            this.f4973g.a(this.f4969c, this.f4970d);
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e3) {
                                    e = e3;
                                    level = Level.ERROR;
                                    name = o.class.getName();
                                    message = e.getMessage();
                                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(level, name, message, e);
                                }
                            }
                            if (readLockCount != 0) {
                                readLockCount.close();
                            }
                        } catch (ClassNotFoundException e4) {
                            e = e4;
                            fileInputStream2 = fileInputStream;
                            readLockCount = readLockCount;
                            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, o.class.getName(), "Unable to read map from cache", e);
                            this.f4973g.a(this.f4969c, this.f4970d);
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e5) {
                                    e = e5;
                                    level = Level.ERROR;
                                    name = o.class.getName();
                                    message = e.getMessage();
                                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(level, name, message, e);
                                }
                            }
                            if (readLockCount != 0) {
                                readLockCount.close();
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e6) {
                                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, o.class.getName(), e6.getMessage(), e6);
                                    throw th;
                                }
                            }
                            if (readLockCount != 0) {
                                readLockCount.close();
                            }
                            throw th;
                        }
                    } catch (IOException e7) {
                        e = e7;
                        readLockCount = 0;
                    } catch (ClassNotFoundException e8) {
                        e = e8;
                        readLockCount = 0;
                    } catch (Throwable th2) {
                        th = th2;
                        readLockCount = 0;
                    }
                } catch (IOException e9) {
                    e = e9;
                    readLockCount = 0;
                } catch (ClassNotFoundException e10) {
                    e = e10;
                    readLockCount = 0;
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = null;
                    readLockCount = 0;
                }
                try {
                    fileInputStream.close();
                    readLockCount.close();
                } catch (IOException e11) {
                    e = e11;
                    level = Level.ERROR;
                    name = o.class.getName();
                    message = e.getMessage();
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(level, name, message, e);
                }
            } catch (Throwable th4) {
                th = th4;
                fileInputStream = fileInputStream2;
            }
        } finally {
            reentrantReadWriteLock = this.f4973g.f4981a;
            reentrantReadWriteLock.readLock().unlock();
            Level level3 = Level.INFO;
            String name3 = o.class.getName();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Read lock released in getObjectFromDiskWithGUID.Holding ");
            reentrantReadWriteLock2 = this.f4973g.f4981a;
            sb2.append(reentrantReadWriteLock2.getReadLockCount());
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(level3, name3, sb2.toString());
        }
    }
}
