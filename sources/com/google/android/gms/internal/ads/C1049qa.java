package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/* JADX INFO: Access modifiers changed from: package-private */
@zzark
/* renamed from: com.google.android.gms.internal.ads.qa, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1049qa {

    /* renamed from: a, reason: collision with root package name */
    final zzwb f12444a;

    /* renamed from: b, reason: collision with root package name */
    final String f12445b;

    /* renamed from: c, reason: collision with root package name */
    final int f12446c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1049qa(C1021oa c1021oa) {
        this(c1021oa.d(), c1021oa.a(), c1021oa.b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static C1049qa a(String str) throws IOException {
        String[] split = str.split("\u0000");
        if (split.length == 3) {
            Parcel obtain = Parcel.obtain();
            try {
                try {
                    String str2 = new String(Base64.decode(split[0], 0), "UTF-8");
                    int parseInt = Integer.parseInt(split[1]);
                    byte[] decode = Base64.decode(split[2], 0);
                    obtain.unmarshall(decode, 0, decode.length);
                    obtain.setDataPosition(0);
                    return new C1049qa(zzwb.CREATOR.createFromParcel(obtain), str2, parseInt);
                } catch (SafeParcelReader.ParseException | IllegalArgumentException | IllegalStateException e2) {
                    com.google.android.gms.ads.internal.zzbv.i().zza(e2, "QueueSeed.decode");
                    throw new IOException("Malformed QueueSeed encoding.", e2);
                }
            } finally {
                obtain.recycle();
            }
        }
        throw new IOException("Incorrect field count for QueueSeed.");
    }

    @VisibleForTesting
    private C1049qa(zzwb zzwbVar, String str, int i) {
        this.f12444a = zzwbVar;
        this.f12445b = str;
        this.f12446c = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String a() {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                String encodeToString = Base64.encodeToString(this.f12445b.getBytes("UTF-8"), 0);
                String num = Integer.toString(this.f12446c);
                this.f12444a.writeToParcel(obtain, 0);
                String encodeToString2 = Base64.encodeToString(obtain.marshall(), 0);
                StringBuilder sb = new StringBuilder(String.valueOf(encodeToString).length() + 2 + String.valueOf(num).length() + String.valueOf(encodeToString2).length());
                sb.append(encodeToString);
                sb.append("\u0000");
                sb.append(num);
                sb.append("\u0000");
                sb.append(encodeToString2);
                return sb.toString();
            } catch (UnsupportedEncodingException unused) {
                zzbbd.e("QueueSeed encode failed because UTF-8 is not available.");
                obtain.recycle();
                return "";
            }
        } finally {
            obtain.recycle();
        }
    }
}
