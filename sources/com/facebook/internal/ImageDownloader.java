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

    public static void downloadAsync(ImageRequest imageRequest) {
        if (imageRequest != null) {
            d dVar = new d(imageRequest.getImageUri(), imageRequest.getCallerTag());
            synchronized (pendingRequests) {
                c cVar = pendingRequests.get(dVar);
                if (cVar != null) {
                    cVar.b = imageRequest;
                    cVar.c = false;
                    cVar.f275a.moveToFront();
                } else {
                    enqueueCacheRead(imageRequest, dVar, imageRequest.isCachedRedirectAllowed());
                }
            }
        }
    }

    public static boolean cancelRequest(ImageRequest imageRequest) {
        boolean z;
        d dVar = new d(imageRequest.getImageUri(), imageRequest.getCallerTag());
        synchronized (pendingRequests) {
            c cVar = pendingRequests.get(dVar);
            if (cVar == null) {
                z = false;
            } else if (cVar.f275a.cancel()) {
                pendingRequests.remove(dVar);
                z = true;
            } else {
                cVar.c = true;
                z = true;
            }
        }
        return z;
    }

    public static void prioritizeRequest(ImageRequest imageRequest) {
        d dVar = new d(imageRequest.getImageUri(), imageRequest.getCallerTag());
        synchronized (pendingRequests) {
            c cVar = pendingRequests.get(dVar);
            if (cVar != null) {
                cVar.f275a.moveToFront();
            }
        }
    }

    public static void clearCache(Context context) {
        v.b(context);
        ab.b();
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
            cVar.b = imageRequest;
            pendingRequests.put(dVar, cVar);
            cVar.f275a = workQueue.addActiveWorkItem(runnable);
        }
    }

    private static void issueResponse(d dVar, Exception exc, Bitmap bitmap, boolean z) {
        ImageRequest imageRequest;
        ImageRequest.Callback callback;
        c removePendingRequest = removePendingRequest(dVar);
        if (removePendingRequest != null && !removePendingRequest.c && (callback = (imageRequest = removePendingRequest.b).getCallback()) != null) {
            getHandler().post(new t(imageRequest, exc, z, bitmap, callback));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void readFromCache(d dVar, Context context, boolean z) {
        boolean z2;
        InputStream inputStream;
        Uri a2;
        if (!z || (a2 = ab.a(dVar.f276a)) == null) {
            z2 = false;
            inputStream = null;
        } else {
            InputStream a3 = v.a(a2, context);
            inputStream = a3;
            z2 = a3 != null;
        }
        if (!z2) {
            inputStream = v.a(dVar.f276a, context);
        }
        if (inputStream != null) {
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
            Utility.closeQuietly(inputStream);
            issueResponse(dVar, null, decodeStream, z2);
        } else {
            c removePendingRequest = removePendingRequest(dVar);
            if (removePendingRequest != null && !removePendingRequest.c) {
                enqueueDownload(removePendingRequest.b, dVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x001c. Please report as an issue. */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x00a1: MOVE (r3 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:45:0x00a1 */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void download(com.facebook.internal.ImageDownloader.d r11, android.content.Context r12) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.ImageDownloader.download(com.facebook.internal.ImageDownloader$d, android.content.Context):void");
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

    private static c removePendingRequest(d dVar) {
        c remove;
        synchronized (pendingRequests) {
            remove = pendingRequests.remove(dVar);
        }
        return remove;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        Uri f276a;
        Object b;

        d(Uri uri, Object obj) {
            this.f276a = uri;
            this.b = obj;
        }

        public int hashCode() {
            return ((this.f276a.hashCode() + 1073) * 37) + this.b.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return dVar.f276a == this.f276a && dVar.b == this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        WorkQueue.WorkItem f275a;
        ImageRequest b;
        boolean c;

        private c() {
        }

        /* synthetic */ c(t tVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private Context f273a;
        private d b;
        private boolean c;

        a(Context context, d dVar, boolean z) {
            this.f273a = context;
            this.b = dVar;
            this.c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageDownloader.readFromCache(this.b, this.f273a, this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private Context f274a;
        private d b;

        b(Context context, d dVar) {
            this.f274a = context;
            this.b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageDownloader.download(this.b, this.f274a);
        }
    }
}
