package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.ads.jj */
/* loaded from: classes2.dex */
public final class C0960jj {

    /* renamed from: a */
    private static boolean f12230a = false;

    /* renamed from: b */
    private static MessageDigest f12231b;

    /* renamed from: c */
    private static final Object f12232c = new Object();

    /* renamed from: d */
    private static final Object f12233d = new Object();

    /* renamed from: e */
    static CountDownLatch f12234e = new CountDownLatch(1);

    public static void a() {
        synchronized (f12233d) {
            if (!f12230a) {
                f12230a = true;
                new Thread(new RunnableC1002mj()).start();
            }
        }
    }

    private static MessageDigest b() {
        boolean z;
        MessageDigest messageDigest;
        a();
        try {
            z = f12234e.await(2L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            z = false;
        }
        if (z && (messageDigest = f12231b) != null) {
            return messageDigest;
        }
        return null;
    }

    public static String a(zzbl zzblVar, String str) throws GeneralSecurityException, UnsupportedEncodingException {
        byte[] a2;
        byte[] zzb = zzbuz.zzb(zzblVar);
        if (!((Boolean) zzwu.zzpz().zzd(zzaan.zzctq)).booleanValue()) {
            if (Oj.f11739a != null) {
                byte[] zzc = Oj.f11739a.zzc(zzb, str != null ? str.getBytes() : new byte[0]);
                zzbs zzbsVar = new zzbs();
                zzbsVar.zzhr = new byte[][]{zzc};
                zzbsVar.zzfy = 2;
                a2 = zzbuz.zzb(zzbsVar);
            } else {
                throw new GeneralSecurityException();
            }
        } else {
            Vector<byte[]> a3 = a(zzb, 255);
            if (a3 != null && a3.size() != 0) {
                zzbs zzbsVar2 = new zzbs();
                zzbsVar2.zzhr = new byte[a3.size()];
                Iterator<byte[]> it = a3.iterator();
                int i = 0;
                while (it.hasNext()) {
                    zzbsVar2.zzhr[i] = a(it.next(), str, false);
                    i++;
                }
                zzbsVar2.zzhm = a(zzb);
                a2 = zzbuz.zzb(zzbsVar2);
            } else {
                a2 = a(zzbuz.zzb(a(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM)), str, true);
            }
        }
        return zzbu.zza(a2, true);
    }

    private static Vector<byte[]> a(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        int length = ((bArr.length + 255) - 1) / 255;
        Vector<byte[]> vector = new Vector<>();
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 255;
            try {
                vector.add(Arrays.copyOfRange(bArr, i3, bArr.length - i3 > 255 ? i3 + 255 : bArr.length));
            } catch (IndexOutOfBoundsException unused) {
                return null;
            }
        }
        return vector;
    }

    private static zzbl a(long j) {
        zzbl zzblVar = new zzbl();
        zzblVar.zzeo = Long.valueOf(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
        return zzblVar;
    }

    private static byte[] a(byte[] bArr, String str, boolean z) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] array;
        int i = z ? 239 : 255;
        if (bArr.length > i) {
            bArr = zzbuz.zzb(a(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM));
        }
        if (bArr.length < i) {
            byte[] bArr2 = new byte[i - bArr.length];
            new SecureRandom().nextBytes(bArr2);
            array = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr).put(bArr2).array();
        } else {
            array = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr).array();
        }
        if (z) {
            array = ByteBuffer.allocate(256).put(a(array)).put(array).array();
        }
        byte[] bArr3 = new byte[256];
        for (InterfaceC1030oj interfaceC1030oj : new zzbz().zzqm) {
            interfaceC1030oj.a(array, bArr3);
        }
        if (str != null && str.length() > 0) {
            if (str.length() > 32) {
                str = str.substring(0, 32);
            }
            new zzbpk(str.getBytes("UTF-8")).zzq(bArr3);
        }
        return bArr3;
    }

    public static byte[] a(byte[] bArr) throws NoSuchAlgorithmException {
        byte[] digest;
        synchronized (f12232c) {
            MessageDigest b2 = b();
            if (b2 != null) {
                b2.reset();
                b2.update(bArr);
                digest = f12231b.digest();
            } else {
                throw new NoSuchAlgorithmException("Cannot compute hash");
            }
        }
        return digest;
    }
}
