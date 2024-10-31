package com.facebook.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.WorkQueue;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class ImageDownloader {
    private static final int CACHE_READ_QUEUE_MAX_CONCURRENT = 2;
    private static final int DOWNLOAD_QUEUE_MAX_CONCURRENT = 8;
    private static Handler handler;
    private static WorkQueue downloadQueue = new WorkQueue(8);
    private static WorkQueue cacheReadQueue = new WorkQueue(2);
    private static final Map<d, c> pendingRequests = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private Context f9287a;

        /* renamed from: b, reason: collision with root package name */
        private d f9288b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f9289c;

        a(Context context, d dVar, boolean z) {
            this.f9287a = context;
            this.f9288b = dVar;
            this.f9289c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageDownloader.readFromCache(this.f9288b, this.f9287a, this.f9289c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private Context f9290a;

        /* renamed from: b, reason: collision with root package name */
        private d f9291b;

        b(Context context, d dVar) {
            this.f9290a = context;
            this.f9291b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageDownloader.download(this.f9291b, this.f9290a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        WorkQueue.WorkItem f9292a;

        /* renamed from: b, reason: collision with root package name */
        ImageRequest f9293b;

        /* renamed from: c, reason: collision with root package name */
        boolean f9294c;

        private c() {
        }

        /* synthetic */ c(u uVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        Uri f9295a;

        /* renamed from: b, reason: collision with root package name */
        Object f9296b;

        d(Uri uri, Object obj) {
            this.f9295a = uri;
            this.f9296b = obj;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return dVar.f9295a == this.f9295a && dVar.f9296b == this.f9296b;
        }

        public int hashCode() {
            return ((1073 + this.f9295a.hashCode()) * 37) + this.f9296b.hashCode();
        }
    }

    public static boolean cancelRequest(ImageRequest imageRequest) {
        boolean z;
        d dVar = new d(imageRequest.getImageUri(), imageRequest.getCallerTag());
        synchronized (pendingRequests) {
            c cVar = pendingRequests.get(dVar);
            z = true;
            if (cVar == null) {
                z = false;
            } else if (cVar.f9292a.cancel()) {
                pendingRequests.remove(dVar);
            } else {
                cVar.f9294c = true;
            }
        }
        return z;
    }

    public static void clearCache(Context context) {
        w.a(context);
        C.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r5v3, types: [com.facebook.FacebookException] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void download(com.facebook.internal.ImageDownloader.d r9, android.content.Context r10) {
        /*
            r0 = 0
            r1 = 0
            r2 = 1
            java.net.URL r3 = new java.net.URL     // Catch: java.lang.Throwable -> La7 java.io.IOException -> Lb0
            android.net.Uri r4 = r9.f9295a     // Catch: java.lang.Throwable -> La7 java.io.IOException -> Lb0
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> La7 java.io.IOException -> Lb0
            r3.<init>(r4)     // Catch: java.lang.Throwable -> La7 java.io.IOException -> Lb0
            java.net.URLConnection r3 = r3.openConnection()     // Catch: java.lang.Throwable -> La7 java.io.IOException -> Lb0
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch: java.lang.Throwable -> La7 java.io.IOException -> Lb0
            r3.setInstanceFollowRedirects(r1)     // Catch: java.lang.Throwable -> La2 java.io.IOException -> La4
            int r4 = r3.getResponseCode()     // Catch: java.lang.Throwable -> La2 java.io.IOException -> La4
            r5 = 200(0xc8, float:2.8E-43)
            if (r4 == r5) goto L93
            r10 = 301(0x12d, float:4.22E-43)
            if (r4 == r10) goto L60
            r10 = 302(0x12e, float:4.23E-43)
            if (r4 == r10) goto L60
            java.io.InputStream r10 = r3.getErrorStream()     // Catch: java.lang.Throwable -> La2 java.io.IOException -> La4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5e
            r4.<init>()     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5e
            if (r10 == 0) goto L4a
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5e
            r5.<init>(r10)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5e
            r6 = 128(0x80, float:1.8E-43)
            char[] r6 = new char[r6]     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5e
        L3b:
            int r7 = r6.length     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5e
            int r7 = r5.read(r6, r1, r7)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5e
            if (r7 <= 0) goto L46
            r4.append(r6, r1, r7)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5e
            goto L3b
        L46:
            com.facebook.internal.Utility.closeQuietly(r5)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5e
            goto L4f
        L4a:
            java.lang.String r5 = "Unexpected error while downloading an image."
            r4.append(r5)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5e
        L4f:
            com.facebook.FacebookException r5 = new com.facebook.FacebookException     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5e
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5e
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5e
            r4 = r0
            r0 = r5
            goto L9b
        L5b:
            r9 = move-exception
            r0 = r10
            goto La9
        L5e:
            r4 = move-exception
            goto Lb3
        L60:
            java.lang.String r10 = "location"
            java.lang.String r10 = r3.getHeaderField(r10)     // Catch: java.io.IOException -> L8f java.lang.Throwable -> La2
            boolean r2 = com.facebook.internal.Utility.isNullOrEmpty(r10)     // Catch: java.io.IOException -> L8f java.lang.Throwable -> La2
            if (r2 != 0) goto L8b
            android.net.Uri r10 = android.net.Uri.parse(r10)     // Catch: java.io.IOException -> L8f java.lang.Throwable -> La2
            android.net.Uri r2 = r9.f9295a     // Catch: java.io.IOException -> L8f java.lang.Throwable -> La2
            com.facebook.internal.C.a(r2, r10)     // Catch: java.io.IOException -> L8f java.lang.Throwable -> La2
            com.facebook.internal.ImageDownloader$c r2 = removePendingRequest(r9)     // Catch: java.io.IOException -> L8f java.lang.Throwable -> La2
            if (r2 == 0) goto L8b
            boolean r4 = r2.f9294c     // Catch: java.io.IOException -> L8f java.lang.Throwable -> La2
            if (r4 != 0) goto L8b
            com.facebook.internal.ImageRequest r2 = r2.f9293b     // Catch: java.io.IOException -> L8f java.lang.Throwable -> La2
            com.facebook.internal.ImageDownloader$d r4 = new com.facebook.internal.ImageDownloader$d     // Catch: java.io.IOException -> L8f java.lang.Throwable -> La2
            java.lang.Object r5 = r9.f9296b     // Catch: java.io.IOException -> L8f java.lang.Throwable -> La2
            r4.<init>(r10, r5)     // Catch: java.io.IOException -> L8f java.lang.Throwable -> La2
            enqueueCacheRead(r2, r4, r1)     // Catch: java.io.IOException -> L8f java.lang.Throwable -> La2
        L8b:
            r10 = r0
            r4 = r10
            r2 = 0
            goto L9b
        L8f:
            r4 = move-exception
            r10 = r0
            r2 = 0
            goto Lb3
        L93:
            java.io.InputStream r10 = com.facebook.internal.w.a(r10, r3)     // Catch: java.lang.Throwable -> La2 java.io.IOException -> La4
            android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeStream(r10)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5e
        L9b:
            com.facebook.internal.Utility.closeQuietly(r10)
            com.facebook.internal.Utility.disconnectQuietly(r3)
            goto Lbc
        La2:
            r9 = move-exception
            goto La9
        La4:
            r4 = move-exception
            r10 = r0
            goto Lb3
        La7:
            r9 = move-exception
            r3 = r0
        La9:
            com.facebook.internal.Utility.closeQuietly(r0)
            com.facebook.internal.Utility.disconnectQuietly(r3)
            throw r9
        Lb0:
            r4 = move-exception
            r10 = r0
            r3 = r10
        Lb3:
            com.facebook.internal.Utility.closeQuietly(r10)
            com.facebook.internal.Utility.disconnectQuietly(r3)
            r8 = r4
            r4 = r0
            r0 = r8
        Lbc:
            if (r2 == 0) goto Lc1
            issueResponse(r9, r0, r4, r1)
        Lc1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.ImageDownloader.download(com.facebook.internal.ImageDownloader$d, android.content.Context):void");
    }

    public static void downloadAsync(ImageRequest imageRequest) {
        if (imageRequest == null) {
            return;
        }
        d dVar = new d(imageRequest.getImageUri(), imageRequest.getCallerTag());
        synchronized (pendingRequests) {
            c cVar = pendingRequests.get(dVar);
            if (cVar != null) {
                cVar.f9293b = imageRequest;
                cVar.f9294c = false;
                cVar.f9292a.moveToFront();
            } else {
                enqueueCacheRead(imageRequest, dVar, imageRequest.isCachedRedirectAllowed());
            }
        }
    }

    private static void enqueueCacheRead(ImageRequest imageRequest, d dVar, boolean z) {
        enqueueRequest(imageRequest, dVar, cacheReadQueue, new a(imageRequest.getContext(), dVar, z));
    }

    private static void enqueueDownload(ImageRequest imageRequest, d dVar) {
        enqueueRequest(imageRequest, dVar, downloadQueue, new b(imageRequest.getContext(), dVar));
    }

    private static void enqueueRequest(ImageRequest imageRequest, d dVar, WorkQueue workQueue, Runnable runnable) {
        synchronized (pendingRequests) {
            c cVar = new c(null);
            cVar.f9293b = imageRequest;
            pendingRequests.put(dVar, cVar);
            cVar.f9292a = workQueue.addActiveWorkItem(runnable);
        }
    }

    private static synchronized Handler getHandler() {
        Handler handler2;
        synchronized (ImageDownloader.class) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler2 = handler;
        }
        return handler2;
    }

    private static void issueResponse(d dVar, Exception exc, Bitmap bitmap, boolean z) {
        ImageRequest imageRequest;
        ImageRequest.Callback callback;
        c removePendingRequest = removePendingRequest(dVar);
        if (removePendingRequest == null || removePendingRequest.f9294c || (callback = (imageRequest = removePendingRequest.f9293b).getCallback()) == null) {
            return;
        }
        getHandler().post(new u(imageRequest, exc, z, bitmap, callback));
    }

    public static void prioritizeRequest(ImageRequest imageRequest) {
        d dVar = new d(imageRequest.getImageUri(), imageRequest.getCallerTag());
        synchronized (pendingRequests) {
            c cVar = pendingRequests.get(dVar);
            if (cVar != null) {
                cVar.f9292a.moveToFront();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void readFromCache(d dVar, Context context, boolean z) {
        InputStream inputStream;
        Uri a2;
        boolean z2 = false;
        if (!z || (a2 = C.a(dVar.f9295a)) == null) {
            inputStream = null;
        } else {
            inputStream = w.a(a2, context);
            if (inputStream != null) {
                z2 = true;
            }
        }
        if (!z2) {
            inputStream = w.a(dVar.f9295a, context);
        }
        if (inputStream != null) {
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
            Utility.closeQuietly(inputStream);
            issueResponse(dVar, null, decodeStream, z2);
        } else {
            c removePendingRequest = removePendingRequest(dVar);
            if (removePendingRequest == null || removePendingRequest.f9294c) {
                return;
            }
            enqueueDownload(removePendingRequest.f9293b, dVar);
        }
    }

    private static c removePendingRequest(d dVar) {
        c remove;
        synchronized (pendingRequests) {
            remove = pendingRequests.remove(dVar);
        }
        return remove;
    }
}
