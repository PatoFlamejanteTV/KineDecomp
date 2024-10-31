package com.google.android.gms.internal.ads;

import com.facebook.stetho.server.http.HttpHeaders;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes2.dex */
public final class zzas extends zzai {
    private final zzau zzci;
    private final SSLSocketFactory zzcj;

    public zzas() {
        this(null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:20:0x008a. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d0 A[Catch: all -> 0x0125, TryCatch #1 {all -> 0x0125, blocks: (B:14:0x0068, B:15:0x0070, B:17:0x0076, B:19:0x0086, B:20:0x008a, B:21:0x008d, B:22:0x011f, B:23:0x0124, B:24:0x0091, B:25:0x009a, B:26:0x00a0, B:27:0x00a6, B:28:0x00ac, B:29:0x00b2, B:30:0x00bb, B:31:0x00c4, B:32:0x00c9, B:34:0x00d0, B:46:0x00ec, B:59:0x0117, B:60:0x011e), top: B:13:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0117 A[Catch: all -> 0x0125, TRY_ENTER, TryCatch #1 {all -> 0x0125, blocks: (B:14:0x0068, B:15:0x0070, B:17:0x0076, B:19:0x0086, B:20:0x008a, B:21:0x008d, B:22:0x011f, B:23:0x0124, B:24:0x0091, B:25:0x009a, B:26:0x00a0, B:27:0x00a6, B:28:0x00ac, B:29:0x00b2, B:30:0x00bb, B:31:0x00c4, B:32:0x00c9, B:34:0x00d0, B:46:0x00ec, B:59:0x0117, B:60:0x011e), top: B:13:0x0068 }] */
    @Override // com.google.android.gms.internal.ads.zzai
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.internal.ads.zzaq zza(com.google.android.gms.internal.ads.zzr<?> r7, java.util.Map<java.lang.String, java.lang.String> r8) throws java.io.IOException, com.google.android.gms.internal.ads.zza {
        /*
            Method dump skipped, instructions count: 324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzas.zza(com.google.android.gms.internal.ads.zzr, java.util.Map):com.google.android.gms.internal.ads.zzaq");
    }

    private zzas(zzau zzauVar) {
        this(null, null);
    }

    private zzas(zzau zzauVar, SSLSocketFactory sSLSocketFactory) {
        this.zzci = null;
        this.zzcj = null;
    }

    private static List<zzl> zza(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    arrayList.add(new zzl(entry.getKey(), it.next()));
                }
            }
        }
        return arrayList;
    }

    public static InputStream zza(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    private static void zza(HttpURLConnection httpURLConnection, zzr<?> zzrVar) throws IOException, zza {
        byte[] zzh = zzrVar.zzh();
        if (zzh != null) {
            httpURLConnection.setDoOutput(true);
            if (!httpURLConnection.getRequestProperties().containsKey(HttpHeaders.CONTENT_TYPE)) {
                httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "UTF-8".length() != 0 ? "application/x-www-form-urlencoded; charset=".concat("UTF-8") : new String("application/x-www-form-urlencoded; charset="));
            }
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(zzh);
            dataOutputStream.close();
        }
    }
}
