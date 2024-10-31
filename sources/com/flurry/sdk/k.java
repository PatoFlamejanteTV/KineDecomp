package com.flurry.sdk;

/* loaded from: classes.dex */
public class k extends bc {
    String b;
    String c;
    String d;
    byte[] e;
    s f;
    private static final String i = k.class.getSimpleName();

    /* renamed from: a, reason: collision with root package name */
    static int f486a = 15000;

    public k(String str, String str2, String str3, byte[] bArr, s sVar) {
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = bArr;
        this.f = sVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0090  */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Thread] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v5 */
    @Override // com.flurry.sdk.bc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a() {
        /*
            r6 = this;
            r2 = 0
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            long r0 = r0.getId()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "DataSender Sending Executor Thread, id = "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.String r0 = r0.toString()
            r1.setName(r0)
            org.apache.http.entity.ByteArrayEntity r0 = new org.apache.http.entity.ByteArrayEntity     // Catch: java.lang.Exception -> L79 java.lang.Throwable -> L8d
            byte[] r1 = r6.e     // Catch: java.lang.Exception -> L79 java.lang.Throwable -> L8d
            r0.<init>(r1)     // Catch: java.lang.Exception -> L79 java.lang.Throwable -> L8d
            java.lang.String r1 = "application/octet-stream"
            r0.setContentType(r1)     // Catch: java.lang.Exception -> L79 java.lang.Throwable -> L8d
            org.apache.http.client.methods.HttpPost r3 = new org.apache.http.client.methods.HttpPost     // Catch: java.lang.Exception -> L79 java.lang.Throwable -> L8d
            java.lang.String r1 = r6.b     // Catch: java.lang.Exception -> L79 java.lang.Throwable -> L8d
            r3.<init>(r1)     // Catch: java.lang.Exception -> L79 java.lang.Throwable -> L8d
            r3.setEntity(r0)     // Catch: java.lang.Exception -> L79 java.lang.Throwable -> L8d
            org.apache.http.params.BasicHttpParams r0 = new org.apache.http.params.BasicHttpParams     // Catch: java.lang.Exception -> L79 java.lang.Throwable -> L8d
            r0.<init>()     // Catch: java.lang.Exception -> L79 java.lang.Throwable -> L8d
            r1 = 10000(0x2710, float:1.4013E-41)
            org.apache.http.params.HttpConnectionParams.setConnectionTimeout(r0, r1)     // Catch: java.lang.Exception -> L79 java.lang.Throwable -> L8d
            int r1 = com.flurry.sdk.k.f486a     // Catch: java.lang.Exception -> L79 java.lang.Throwable -> L8d
            org.apache.http.params.HttpConnectionParams.setSoTimeout(r0, r1)     // Catch: java.lang.Exception -> L79 java.lang.Throwable -> L8d
            org.apache.http.params.HttpParams r1 = r3.getParams()     // Catch: java.lang.Exception -> L79 java.lang.Throwable -> L8d
            java.lang.String r4 = "http.protocol.expect-continue"
            r5 = 0
            r1.setBooleanParameter(r4, r5)     // Catch: java.lang.Exception -> L79 java.lang.Throwable -> L8d
            org.apache.http.client.HttpClient r1 = com.flurry.sdk.ar.a(r0)     // Catch: java.lang.Exception -> L79 java.lang.Throwable -> L8d
            org.apache.http.HttpResponse r2 = r1.execute(r3)     // Catch: java.lang.Throwable -> Lae java.lang.Exception -> Lb1
            if (r1 == 0) goto L67
            org.apache.http.conn.ClientConnectionManager r0 = r1.getConnectionManager()
            r0.shutdown()
        L67:
            if (r2 == 0) goto L6f
            org.apache.http.StatusLine r0 = r2.getStatusLine()
            if (r0 != 0) goto L98
        L6f:
            com.flurry.sdk.s r0 = r6.f
            java.lang.String r1 = r6.c
            java.lang.String r2 = r6.d
            r0.a(r1, r2)
        L78:
            return
        L79:
            r0 = move-exception
            r1 = r2
        L7b:
            r3 = 6
            java.lang.String r4 = com.flurry.sdk.k.i     // Catch: java.lang.Throwable -> Lae
            java.lang.String r5 = "Exception: "
            com.flurry.sdk.as.a(r3, r4, r5, r0)     // Catch: java.lang.Throwable -> Lae
            if (r1 == 0) goto L67
            org.apache.http.conn.ClientConnectionManager r0 = r1.getConnectionManager()
            r0.shutdown()
            goto L67
        L8d:
            r0 = move-exception
        L8e:
            if (r2 == 0) goto L97
            org.apache.http.conn.ClientConnectionManager r1 = r2.getConnectionManager()
            r1.shutdown()
        L97:
            throw r0
        L98:
            org.apache.http.StatusLine r0 = r2.getStatusLine()
            int r1 = r0.getStatusCode()
            java.lang.String r0 = r0.getReasonPhrase()
            com.flurry.sdk.s r2 = r6.f
            java.lang.String r3 = r6.c
            java.lang.String r4 = r6.d
            r2.a(r1, r0, r3, r4)
            goto L78
        Lae:
            r0 = move-exception
            r2 = r1
            goto L8e
        Lb1:
            r0 = move-exception
            goto L7b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.k.a():void");
    }
}
