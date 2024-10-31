package com.google.android.gms.internal;

import android.util.Base64OutputStream;
import com.google.android.gms.internal.zzbp;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

/* loaded from: classes.dex */
public class zzbm {
    private final int zzsq;
    private final zzbl zzss = new zzbo();
    private final int zzsp = 6;
    private final int zzsr = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        ByteArrayOutputStream f1687a = new ByteArrayOutputStream(4096);
        Base64OutputStream b = new Base64OutputStream(this.f1687a, 10);

        public void a(byte[] bArr) throws IOException {
            this.b.write(bArr);
        }

        public String toString() {
            String str;
            try {
                this.b.close();
            } catch (IOException e) {
                com.google.android.gms.ads.internal.util.client.zzb.b("HashManager: Unable to convert to Base64.", e);
            }
            try {
                this.f1687a.close();
                str = this.f1687a.toString();
            } catch (IOException e2) {
                com.google.android.gms.ads.internal.util.client.zzb.b("HashManager: Unable to convert to Base64.", e2);
                str = "";
            } finally {
                this.f1687a = null;
                this.b = null;
            }
            return str;
        }
    }

    public zzbm(int i) {
        this.zzsq = i;
    }

    private String zzA(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return "";
        }
        a zzcz = zzcz();
        Arrays.sort(split, new y(this));
        for (int i = 0; i < split.length && i < this.zzsq; i++) {
            if (split[i].trim().length() != 0) {
                try {
                    zzcz.a(this.zzss.zzz(split[i]));
                } catch (IOException e) {
                    com.google.android.gms.ads.internal.util.client.zzb.b("Error while writing hash to byteStream", e);
                }
            }
        }
        return zzcz.toString();
    }

    String zzB(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return "";
        }
        a zzcz = zzcz();
        PriorityQueue priorityQueue = new PriorityQueue(this.zzsq, new z(this));
        for (String str2 : split) {
            String[] zzD = zzbn.zzD(str2);
            if (zzD.length >= this.zzsp) {
                zzbp.zza(zzD, this.zzsq, this.zzsp, (PriorityQueue<zzbp.zza>) priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                zzcz.a(this.zzss.zzz(((zzbp.zza) it.next()).zzsx));
            } catch (IOException e) {
                com.google.android.gms.ads.internal.util.client.zzb.b("Error while writing hash to byteStream", e);
            }
        }
        return zzcz.toString();
    }

    public String zza(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next().toLowerCase(Locale.US));
            stringBuffer.append('\n');
        }
        switch (this.zzsr) {
            case 0:
                return zzB(stringBuffer.toString());
            case 1:
                return zzA(stringBuffer.toString());
            default:
                return "";
        }
    }

    a zzcz() {
        return new a();
    }
}
