package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.proguard.ap;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.zip.Deflater;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: UMSLUtils.java */
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a */
    public static int f26347a;

    /* renamed from: b */
    private static final byte[] f26348b = {10, 1, 11, 5, 4, ap.m, 7, 9, 23, 3, 1, 6, 8, 12, ap.k, 91};

    /* renamed from: c */
    private static Object f26349c = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UMSLUtils.java */
    /* renamed from: com.umeng.commonsdk.stateless.f$1 */
    /* loaded from: classes3.dex */
    public static class AnonymousClass1 implements Comparator<File> {
        AnonymousClass1() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            long lastModified = file.lastModified() - file2.lastModified();
            if (lastModified > 0) {
                return 1;
            }
            return lastModified == 0 ? 0 : -1;
        }
    }

    /* compiled from: UMSLUtils.java */
    /* renamed from: com.umeng.commonsdk.stateless.f$2 */
    /* loaded from: classes3.dex */
    public static class AnonymousClass2 implements Comparator<File> {
        AnonymousClass2() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            if (file == null || file2 == null || file.lastModified() >= file2.lastModified()) {
                return (file == null || file2 == null || file.lastModified() != file2.lastModified()) ? 1 : 0;
            }
            return -1;
        }
    }

    public static boolean a(long j, long j2) {
        return j > j2;
    }

    public static boolean a(Context context, String str, String str2, byte[] bArr) {
        boolean z;
        FileOutputStream fileOutputStream;
        if (context == null) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                synchronized (f26349c) {
                    try {
                        ULog.i("walle", "[stateless] begin write envelope, thread is " + Thread.currentThread());
                        File file = new File(context.getFilesDir() + "/" + a.f26307e);
                        if (!file.isDirectory()) {
                            file.mkdir();
                        }
                        File file2 = new File(file.getPath() + "/" + str);
                        if (!file2.isDirectory()) {
                            file2.mkdir();
                        }
                        File file3 = new File(file2.getPath() + "/" + str2);
                        if (!file3.exists()) {
                            file3.createNewFile();
                        }
                        fileOutputStream = new FileOutputStream(file3);
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        fileOutputStream.write(bArr);
                        fileOutputStream.close();
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream2 = fileOutputStream;
                        z = false;
                        while (true) {
                            try {
                                break;
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        }
                        throw th;
                    }
                    try {
                        ULog.i("walle", "[stateless] end write envelope, thread id " + Thread.currentThread());
                        return true;
                    } catch (Throwable th4) {
                        th = th4;
                        z = true;
                        while (true) {
                            break;
                            break;
                        }
                        throw th;
                    }
                }
                try {
                    break;
                    throw th;
                } catch (IOException e2) {
                    e = e2;
                    ULog.i("walle", "[stateless] write envelope, e is " + e.getMessage());
                    UMCrashManager.reportCrash(context, e);
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused) {
                        }
                    }
                    ULog.i("walle", "[stateless] end write envelope, thread id " + Thread.currentThread());
                    return z;
                } catch (Throwable th5) {
                    th = th5;
                    ULog.i("walle", "[stateless] write envelope, e is " + th.getMessage());
                    UMCrashManager.reportCrash(context, th);
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused2) {
                        }
                    }
                    ULog.i("walle", "[stateless] end write envelope, thread id " + Thread.currentThread());
                    return z;
                }
            } catch (IOException e3) {
                e = e3;
                z = false;
            } catch (Throwable th6) {
                th = th6;
                z = false;
            }
        } catch (Throwable th7) {
            if (0 != 0) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused3) {
                }
            }
            ULog.i("walle", "[stateless] end write envelope, thread id " + Thread.currentThread());
            throw th7;
        }
    }

    public static byte[] b(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String c(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            stringBuffer.append(String.format("%02X", Byte.valueOf(b2)));
        }
        return stringBuffer.toString().toLowerCase(Locale.US);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] a(java.lang.String r13) throws java.io.IOException {
        /*
            java.lang.Object r0 = com.umeng.commonsdk.stateless.f.f26349c
            monitor-enter(r0)
            java.lang.String r1 = "walle"
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> Lb3
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb3
            r4.<init>()     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r5 = "[stateless] begin read envelope, thread is "
            r4.append(r5)     // Catch: java.lang.Throwable -> Lb3
            java.lang.Thread r5 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> Lb3
            r4.append(r5)     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> Lb3
            r5 = 0
            r3[r5] = r4     // Catch: java.lang.Throwable -> Lb3
            com.umeng.commonsdk.statistics.common.ULog.i(r1, r3)     // Catch: java.lang.Throwable -> Lb3
            r1 = 0
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L89
            java.lang.String r4 = "r"
            r3.<init>(r13, r4)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L89
            java.nio.channels.FileChannel r13 = r3.getChannel()     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L89
            java.nio.channels.FileChannel$MapMode r7 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch: java.io.IOException -> L82 java.lang.Throwable -> Lac
            r8 = 0
            long r10 = r13.size()     // Catch: java.io.IOException -> L82 java.lang.Throwable -> Lac
            r6 = r13
            java.nio.MappedByteBuffer r1 = r6.map(r7, r8, r10)     // Catch: java.io.IOException -> L82 java.lang.Throwable -> Lac
            java.nio.MappedByteBuffer r1 = r1.load()     // Catch: java.io.IOException -> L82 java.lang.Throwable -> Lac
            java.io.PrintStream r3 = java.lang.System.out     // Catch: java.io.IOException -> L82 java.lang.Throwable -> Lac
            boolean r4 = r1.isLoaded()     // Catch: java.io.IOException -> L82 java.lang.Throwable -> Lac
            r3.println(r4)     // Catch: java.io.IOException -> L82 java.lang.Throwable -> Lac
            long r3 = r13.size()     // Catch: java.io.IOException -> L82 java.lang.Throwable -> Lac
            int r4 = (int) r3     // Catch: java.io.IOException -> L82 java.lang.Throwable -> Lac
            byte[] r3 = new byte[r4]     // Catch: java.io.IOException -> L82 java.lang.Throwable -> Lac
            int r4 = r1.remaining()     // Catch: java.io.IOException -> L82 java.lang.Throwable -> Lac
            if (r4 <= 0) goto L5d
            int r4 = r1.remaining()     // Catch: java.io.IOException -> L82 java.lang.Throwable -> Lac
            r1.get(r3, r5, r4)     // Catch: java.io.IOException -> L82 java.lang.Throwable -> Lac
        L5d:
            java.lang.String r1 = "walle"
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch: java.io.IOException -> L82 java.lang.Throwable -> Lac
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L82 java.lang.Throwable -> Lac
            r6.<init>()     // Catch: java.io.IOException -> L82 java.lang.Throwable -> Lac
            java.lang.String r7 = "[stateless] end read envelope, thread id "
            r6.append(r7)     // Catch: java.io.IOException -> L82 java.lang.Throwable -> Lac
            java.lang.Thread r7 = java.lang.Thread.currentThread()     // Catch: java.io.IOException -> L82 java.lang.Throwable -> Lac
            r6.append(r7)     // Catch: java.io.IOException -> L82 java.lang.Throwable -> Lac
            java.lang.String r6 = r6.toString()     // Catch: java.io.IOException -> L82 java.lang.Throwable -> Lac
            r4[r5] = r6     // Catch: java.io.IOException -> L82 java.lang.Throwable -> Lac
            com.umeng.commonsdk.statistics.common.ULog.i(r1, r4)     // Catch: java.io.IOException -> L82 java.lang.Throwable -> Lac
            if (r13 == 0) goto L80
            r13.close()     // Catch: java.io.IOException -> L80 java.lang.Throwable -> Lb3
        L80:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb3
            return r3
        L82:
            r1 = move-exception
            goto L8d
        L84:
            r13 = move-exception
            r12 = r1
            r1 = r13
            r13 = r12
            goto Lad
        L89:
            r13 = move-exception
            r12 = r1
            r1 = r13
            r13 = r12
        L8d:
            java.lang.String r3 = "walle"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> Lac
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lac
            r4.<init>()     // Catch: java.lang.Throwable -> Lac
            java.lang.String r6 = "[stateless] write envelope, e is "
            r4.append(r6)     // Catch: java.lang.Throwable -> Lac
            java.lang.String r6 = r1.getMessage()     // Catch: java.lang.Throwable -> Lac
            r4.append(r6)     // Catch: java.lang.Throwable -> Lac
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> Lac
            r2[r5] = r4     // Catch: java.lang.Throwable -> Lac
            com.umeng.commonsdk.statistics.common.ULog.i(r3, r2)     // Catch: java.lang.Throwable -> Lac
            throw r1     // Catch: java.lang.Throwable -> Lac
        Lac:
            r1 = move-exception
        Lad:
            if (r13 == 0) goto Lb2
            r13.close()     // Catch: java.io.IOException -> Lb2 java.lang.Throwable -> Lb3
        Lb2:
            throw r1     // Catch: java.lang.Throwable -> Lb3
        Lb3:
            r13 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb3
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.f.a(java.lang.String):byte[]");
    }

    public static File a(Context context) {
        File[] listFiles;
        File[] listFiles2;
        File file = null;
        try {
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
        synchronized (f26349c) {
            try {
                ULog.i("walle", "get last envelope begin, thread is " + Thread.currentThread());
                if (context != null && context.getApplicationContext() != null) {
                    String str = context.getApplicationContext().getFilesDir() + "/" + a.f26307e;
                    if (!TextUtils.isEmpty(str)) {
                        File file2 = new File(str);
                        if (file2.isDirectory() && (listFiles = file2.listFiles()) != null && listFiles.length > 0) {
                            File file3 = null;
                            for (File file4 : listFiles) {
                                try {
                                    if (file4 != null && file4.isDirectory() && (listFiles2 = file4.listFiles()) != null && listFiles2.length > 0) {
                                        Arrays.sort(listFiles2, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.f.1
                                            AnonymousClass1() {
                                            }

                                            @Override // java.util.Comparator
                                            /* renamed from: a */
                                            public int compare(File file5, File file22) {
                                                long lastModified = file5.lastModified() - file22.lastModified();
                                                if (lastModified > 0) {
                                                    return 1;
                                                }
                                                return lastModified == 0 ? 0 : -1;
                                            }
                                        });
                                        File file5 = listFiles2[0];
                                        if (file5 != null && (file3 == null || file3.lastModified() > file5.lastModified())) {
                                            file3 = file5;
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    file = file3;
                                    throw th;
                                }
                            }
                            file = file3;
                        }
                    }
                }
                ULog.i("walle", "get last envelope end, thread is " + Thread.currentThread());
                return file;
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    public static void a(Context context, String str, int i) {
        try {
            if (str == null) {
                ULog.i("AmapLBS", "[lbs-build] fileDir not exist, thread is " + Thread.currentThread());
                return;
            }
            File file = new File(str);
            if (!file.isDirectory()) {
                ULog.i("AmapLBS", "[lbs-build] fileDir not exist, thread is " + Thread.currentThread());
                return;
            }
            synchronized (f26349c) {
                File[] listFiles = file.listFiles();
                ULog.i("AmapLBS", "[lbs-build] delete file begin " + listFiles.length + ", thread is " + Thread.currentThread());
                if (listFiles != null && listFiles.length >= i) {
                    ULog.i("AmapLBS", "[lbs-build] file size >= max");
                    ArrayList arrayList = new ArrayList();
                    for (File file2 : listFiles) {
                        if (file2 != null) {
                            arrayList.add(file2);
                        }
                    }
                    if (arrayList.size() >= i) {
                        Collections.sort(arrayList, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.f.2
                            AnonymousClass2() {
                            }

                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(File file3, File file22) {
                                if (file3 == null || file22 == null || file3.lastModified() >= file22.lastModified()) {
                                    return (file3 == null || file22 == null || file3.lastModified() != file22.lastModified()) ? 1 : 0;
                                }
                                return -1;
                            }
                        });
                        if (ULog.DEBUG) {
                            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                ULog.i("AmapLBS", "[lbs-build] overrun native file is " + ((File) arrayList.get(i2)).getPath());
                            }
                        }
                        for (int i3 = 0; i3 <= arrayList.size() - i; i3++) {
                            if (arrayList.get(i3) != null) {
                                ULog.i("AmapLBS", "[lbs-build] overrun remove file is " + ((File) arrayList.get(i3)).getPath());
                                try {
                                    ((File) arrayList.get(i3)).delete();
                                    arrayList.remove(i3);
                                } catch (Exception unused) {
                                }
                            }
                        }
                    }
                } else {
                    ULog.i("AmapLBS", "[lbs-build] file size < max");
                }
                ULog.i("AmapLBS", "[lbs-build] delete file end " + listFiles.length + ", thread is " + Thread.currentThread());
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    public static byte[] a(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[8192];
        f26347a = 0;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            while (!deflater.finished()) {
                try {
                    int deflate = deflater.deflate(bArr2);
                    f26347a += deflate;
                    byteArrayOutputStream.write(bArr2, 0, deflate);
                } catch (Throwable th) {
                    th = th;
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            }
            deflater.end();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        cipher.init(1, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(f26348b));
        return cipher.doFinal(bArr);
    }
}
