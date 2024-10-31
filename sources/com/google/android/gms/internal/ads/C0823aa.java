package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectTimeoutException;

/* renamed from: com.google.android.gms.internal.ads.aa, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0823aa extends zzai {

    /* renamed from: a, reason: collision with root package name */
    private final zzar f12048a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0823aa(zzar zzarVar) {
        this.f12048a = zzarVar;
    }

    @Override // com.google.android.gms.internal.ads.zzai
    public final zzaq zza(zzr<?> zzrVar, Map<String, String> map) throws IOException, zza {
        try {
            HttpResponse zzb = this.f12048a.zzb(zzrVar, map);
            int statusCode = zzb.getStatusLine().getStatusCode();
            Header[] allHeaders = zzb.getAllHeaders();
            ArrayList arrayList = new ArrayList(allHeaders.length);
            for (Header header : allHeaders) {
                arrayList.add(new zzl(header.getName(), header.getValue()));
            }
            if (zzb.getEntity() == null) {
                return new zzaq(statusCode, arrayList);
            }
            long contentLength = zzb.getEntity().getContentLength();
            if (((int) contentLength) == contentLength) {
                return new zzaq(statusCode, arrayList, (int) zzb.getEntity().getContentLength(), zzb.getEntity().getContent());
            }
            StringBuilder sb = new StringBuilder(40);
            sb.append("Response too large: ");
            sb.append(contentLength);
            throw new IOException(sb.toString());
        } catch (ConnectTimeoutException e2) {
            throw new SocketTimeoutException(e2.getMessage());
        }
    }
}
