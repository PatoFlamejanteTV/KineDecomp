package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.internal.firebase_messaging.zzc;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Properties;

/* loaded from: classes2.dex */
public final class O {
    private final P c(Context context, String str) throws zzaa {
        P d2;
        try {
            d2 = d(context, str);
        } catch (zzaa e2) {
            e = e2;
        }
        if (d2 != null) {
            a(context, str, d2);
            return d2;
        }
        e = null;
        try {
            P a2 = a(context.getSharedPreferences("com.google.android.gms.appid", 0), str);
            if (a2 != null) {
                a(context, str, a2, false);
                return a2;
            }
        } catch (zzaa e3) {
            e = e3;
        }
        if (e == null) {
            return null;
        }
        throw e;
    }

    private final P d(Context context, String str) throws zzaa {
        File e2 = e(context, str);
        if (!e2.exists()) {
            return null;
        }
        try {
            return a(e2);
        } catch (zzaa | IOException e3) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(e3);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 40);
                sb.append("Failed to read key from file, retrying: ");
                sb.append(valueOf);
                Log.d("FirebaseInstanceId", sb.toString());
            }
            try {
                return a(e2);
            } catch (IOException e4) {
                String valueOf2 = String.valueOf(e4);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 45);
                sb2.append("IID file exists, but failed to read from it: ");
                sb2.append(valueOf2);
                Log.w("FirebaseInstanceId", sb2.toString());
                throw new zzaa(e4);
            }
        }
    }

    private static File e(Context context, String str) {
        String sb;
        if (TextUtils.isEmpty(str)) {
            sb = "com.google.InstanceId.properties";
        } else {
            try {
                String encodeToString = Base64.encodeToString(str.getBytes("UTF-8"), 11);
                StringBuilder sb2 = new StringBuilder(String.valueOf(encodeToString).length() + 33);
                sb2.append("com.google.InstanceId_");
                sb2.append(encodeToString);
                sb2.append(".properties");
                sb = sb2.toString();
            } catch (UnsupportedEncodingException e2) {
                throw new AssertionError(e2);
            }
        }
        return new File(b(context), sb);
    }

    public final P a(Context context, String str) throws zzaa {
        P c2 = c(context, str);
        return c2 != null ? c2 : b(context, str);
    }

    public final P b(Context context, String str) {
        P p = new P(zza.a(), System.currentTimeMillis());
        P a2 = a(context, str, p, true);
        if (a2 != null && !a2.equals(p)) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "Loaded key after generating new one, using loaded one");
            }
            return a2;
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Generated new key");
        }
        a(context, str, p);
        return p;
    }

    public static void a(Context context) {
        for (File file : b(context).listFiles()) {
            if (file.getName().startsWith("com.google.InstanceId")) {
                file.delete();
            }
        }
    }

    private static KeyPair a(String str, String str2) throws zzaa {
        try {
            byte[] decode = Base64.decode(str, 8);
            byte[] decode2 = Base64.decode(str2, 8);
            try {
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                return new KeyPair(keyFactory.generatePublic(new X509EncodedKeySpec(decode)), keyFactory.generatePrivate(new PKCS8EncodedKeySpec(decode2)));
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e2) {
                String valueOf = String.valueOf(e2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 19);
                sb.append("Invalid key stored ");
                sb.append(valueOf);
                Log.w("FirebaseInstanceId", sb.toString());
                throw new zzaa(e2);
            }
        } catch (IllegalArgumentException e3) {
            throw new zzaa(e3);
        }
    }

    private static File b(Context context) {
        File noBackupFilesDir = ContextCompat.getNoBackupFilesDir(context);
        if (noBackupFilesDir != null && noBackupFilesDir.isDirectory()) {
            return noBackupFilesDir;
        }
        Log.w("FirebaseInstanceId", "noBackupFilesDir doesn't exist, using regular files directory instead");
        return context.getFilesDir();
    }

    private static long b(SharedPreferences sharedPreferences, String str) {
        String string = sharedPreferences.getString(C1620r.a(str, "cre"), null);
        if (string == null) {
            return 0L;
        }
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00ad A[Catch: all -> 0x00b1, Throwable -> 0x00b4, TRY_ENTER, TryCatch #9 {Throwable -> 0x00b4, all -> 0x00b1, blocks: (B:8:0x0041, B:18:0x005d, B:29:0x009b, B:39:0x00ad, B:40:0x00b0), top: B:7:0x0041 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[Catch: all -> 0x00b1, Throwable -> 0x00b4, SYNTHETIC, TRY_LEAVE, TryCatch #9 {Throwable -> 0x00b4, all -> 0x00b1, blocks: (B:8:0x0041, B:18:0x005d, B:29:0x009b, B:39:0x00ad, B:40:0x00b0), top: B:7:0x0041 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.google.firebase.iid.P a(android.content.Context r10, java.lang.String r11, com.google.firebase.iid.P r12, boolean r13) {
        /*
            r9 = this;
            r0 = 3
            java.lang.String r1 = "FirebaseInstanceId"
            boolean r2 = android.util.Log.isLoggable(r1, r0)
            if (r2 == 0) goto Le
            java.lang.String r2 = "Writing key to properties file"
            android.util.Log.d(r1, r2)
        Le:
            java.util.Properties r2 = new java.util.Properties
            r2.<init>()
            java.lang.String r3 = com.google.firebase.iid.P.a(r12)
            java.lang.String r4 = "pub"
            r2.setProperty(r4, r3)
            java.lang.String r3 = com.google.firebase.iid.P.b(r12)
            java.lang.String r4 = "pri"
            r2.setProperty(r4, r3)
            long r3 = com.google.firebase.iid.P.c(r12)
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "cre"
            r2.setProperty(r4, r3)
            java.io.File r10 = e(r10, r11)
            r11 = 0
            r10.createNewFile()     // Catch: java.io.IOException -> Lbe
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch: java.io.IOException -> Lbe
            java.lang.String r4 = "rw"
            r3.<init>(r10, r4)     // Catch: java.io.IOException -> Lbe
            java.nio.channels.FileChannel r10 = r3.getChannel()     // Catch: java.lang.Throwable -> Lb1 java.lang.Throwable -> Lb4
            r10.lock()     // Catch: java.lang.Throwable -> La2 java.lang.Throwable -> La5
            r4 = 0
            if (r13 == 0) goto L8f
            long r6 = r10.size()     // Catch: java.lang.Throwable -> La2 java.lang.Throwable -> La5
            int r13 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r13 <= 0) goto L8f
            r10.position(r4)     // Catch: com.google.firebase.iid.zzaa -> L64 java.io.IOException -> L66 java.lang.Throwable -> La2 java.lang.Throwable -> La5
            com.google.firebase.iid.P r12 = a(r10)     // Catch: com.google.firebase.iid.zzaa -> L64 java.io.IOException -> L66 java.lang.Throwable -> La2 java.lang.Throwable -> La5
            if (r10 == 0) goto L60
            a(r11, r10)     // Catch: java.lang.Throwable -> Lb1 java.lang.Throwable -> Lb4
        L60:
            a(r11, r3)     // Catch: java.io.IOException -> Lbe
            return r12
        L64:
            r13 = move-exception
            goto L67
        L66:
            r13 = move-exception
        L67:
            boolean r0 = android.util.Log.isLoggable(r1, r0)     // Catch: java.lang.Throwable -> La2 java.lang.Throwable -> La5
            if (r0 == 0) goto L8f
            java.lang.String r13 = java.lang.String.valueOf(r13)     // Catch: java.lang.Throwable -> La2 java.lang.Throwable -> La5
            java.lang.String r0 = java.lang.String.valueOf(r13)     // Catch: java.lang.Throwable -> La2 java.lang.Throwable -> La5
            int r0 = r0.length()     // Catch: java.lang.Throwable -> La2 java.lang.Throwable -> La5
            int r0 = r0 + 64
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La2 java.lang.Throwable -> La5
            r6.<init>(r0)     // Catch: java.lang.Throwable -> La2 java.lang.Throwable -> La5
            java.lang.String r0 = "Tried reading key pair before writing new one, but failed with: "
            r6.append(r0)     // Catch: java.lang.Throwable -> La2 java.lang.Throwable -> La5
            r6.append(r13)     // Catch: java.lang.Throwable -> La2 java.lang.Throwable -> La5
            java.lang.String r13 = r6.toString()     // Catch: java.lang.Throwable -> La2 java.lang.Throwable -> La5
            android.util.Log.d(r1, r13)     // Catch: java.lang.Throwable -> La2 java.lang.Throwable -> La5
        L8f:
            r10.position(r4)     // Catch: java.lang.Throwable -> La2 java.lang.Throwable -> La5
            java.io.OutputStream r13 = java.nio.channels.Channels.newOutputStream(r10)     // Catch: java.lang.Throwable -> La2 java.lang.Throwable -> La5
            r2.store(r13, r11)     // Catch: java.lang.Throwable -> La2 java.lang.Throwable -> La5
            if (r10 == 0) goto L9e
            a(r11, r10)     // Catch: java.lang.Throwable -> Lb1 java.lang.Throwable -> Lb4
        L9e:
            a(r11, r3)     // Catch: java.io.IOException -> Lbe
            return r12
        La2:
            r12 = move-exception
            r13 = r11
            goto Lab
        La5:
            r12 = move-exception
            throw r12     // Catch: java.lang.Throwable -> La7
        La7:
            r13 = move-exception
            r8 = r13
            r13 = r12
            r12 = r8
        Lab:
            if (r10 == 0) goto Lb0
            a(r13, r10)     // Catch: java.lang.Throwable -> Lb1 java.lang.Throwable -> Lb4
        Lb0:
            throw r12     // Catch: java.lang.Throwable -> Lb1 java.lang.Throwable -> Lb4
        Lb1:
            r10 = move-exception
            r12 = r11
            goto Lba
        Lb4:
            r10 = move-exception
            throw r10     // Catch: java.lang.Throwable -> Lb6
        Lb6:
            r12 = move-exception
            r8 = r12
            r12 = r10
            r10 = r8
        Lba:
            a(r12, r3)     // Catch: java.io.IOException -> Lbe
            throw r10     // Catch: java.io.IOException -> Lbe
        Lbe:
            r10 = move-exception
            java.lang.String r10 = java.lang.String.valueOf(r10)
            java.lang.String r12 = java.lang.String.valueOf(r10)
            int r12 = r12.length()
            int r12 = r12 + 21
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r12)
            java.lang.String r12 = "Failed to write key: "
            r13.append(r12)
            r13.append(r10)
            java.lang.String r10 = r13.toString()
            android.util.Log.w(r1, r10)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.O.a(android.content.Context, java.lang.String, com.google.firebase.iid.P, boolean):com.google.firebase.iid.P");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x002e A[Catch: all -> 0x0032, Throwable -> 0x0034, TRY_ENTER, TryCatch #3 {, blocks: (B:3:0x0006, B:8:0x001c, B:20:0x002e, B:21:0x0031), top: B:2:0x0006, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[Catch: all -> 0x0032, Throwable -> 0x0034, SYNTHETIC, TRY_LEAVE, TryCatch #3 {, blocks: (B:3:0x0006, B:8:0x001c, B:20:0x002e, B:21:0x0031), top: B:2:0x0006, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.google.firebase.iid.P a(java.io.File r10) throws com.google.firebase.iid.zzaa, java.io.IOException {
        /*
            r9 = this;
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r10)
            r10 = 0
            java.nio.channels.FileChannel r7 = r0.getChannel()     // Catch: java.lang.Throwable -> L32 java.lang.Throwable -> L34
            r2 = 0
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r6 = 1
            r1 = r7
            r1.lock(r2, r4, r6)     // Catch: java.lang.Throwable -> L23 java.lang.Throwable -> L26
            com.google.firebase.iid.P r1 = a(r7)     // Catch: java.lang.Throwable -> L23 java.lang.Throwable -> L26
            if (r7 == 0) goto L1f
            a(r10, r7)     // Catch: java.lang.Throwable -> L32 java.lang.Throwable -> L34
        L1f:
            a(r10, r0)
            return r1
        L23:
            r1 = move-exception
            r2 = r10
            goto L2c
        L26:
            r1 = move-exception
            throw r1     // Catch: java.lang.Throwable -> L28
        L28:
            r2 = move-exception
            r8 = r2
            r2 = r1
            r1 = r8
        L2c:
            if (r7 == 0) goto L31
            a(r2, r7)     // Catch: java.lang.Throwable -> L32 java.lang.Throwable -> L34
        L31:
            throw r1     // Catch: java.lang.Throwable -> L32 java.lang.Throwable -> L34
        L32:
            r1 = move-exception
            goto L36
        L34:
            r10 = move-exception
            throw r10     // Catch: java.lang.Throwable -> L32
        L36:
            a(r10, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.O.a(java.io.File):com.google.firebase.iid.P");
    }

    private static P a(FileChannel fileChannel) throws zzaa, IOException {
        Properties properties = new Properties();
        properties.load(Channels.newInputStream(fileChannel));
        String property = properties.getProperty("pub");
        String property2 = properties.getProperty("pri");
        if (property != null && property2 != null) {
            try {
                return new P(a(property, property2), Long.parseLong(properties.getProperty("cre")));
            } catch (NumberFormatException e2) {
                throw new zzaa(e2);
            }
        }
        throw new zzaa("Invalid properties file");
    }

    private static P a(SharedPreferences sharedPreferences, String str) throws zzaa {
        String string = sharedPreferences.getString(C1620r.a(str, "|P|"), null);
        String string2 = sharedPreferences.getString(C1620r.a(str, "|K|"), null);
        if (string == null || string2 == null) {
            return null;
        }
        return new P(a(string, string2), b(sharedPreferences, str));
    }

    private final void a(Context context, String str, P p) {
        String b2;
        String c2;
        long j;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        try {
            if (p.equals(a(sharedPreferences, str))) {
                return;
            }
        } catch (zzaa unused) {
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Writing key to shared preferences");
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        String a2 = C1620r.a(str, "|P|");
        b2 = p.b();
        edit.putString(a2, b2);
        String a3 = C1620r.a(str, "|K|");
        c2 = p.c();
        edit.putString(a3, c2);
        String a4 = C1620r.a(str, "cre");
        j = p.f17341b;
        edit.putString(a4, String.valueOf(j));
        edit.commit();
    }

    private static /* synthetic */ void a(Throwable th, FileChannel fileChannel) {
        if (th == null) {
            fileChannel.close();
            return;
        }
        try {
            fileChannel.close();
        } catch (Throwable th2) {
            zzc.zza(th, th2);
        }
    }

    private static /* synthetic */ void a(Throwable th, RandomAccessFile randomAccessFile) {
        if (th == null) {
            randomAccessFile.close();
            return;
        }
        try {
            randomAccessFile.close();
        } catch (Throwable th2) {
            zzc.zza(th, th2);
        }
    }

    private static /* synthetic */ void a(Throwable th, FileInputStream fileInputStream) {
        if (th == null) {
            fileInputStream.close();
            return;
        }
        try {
            fileInputStream.close();
        } catch (Throwable th2) {
            zzc.zza(th, th2);
        }
    }
}
