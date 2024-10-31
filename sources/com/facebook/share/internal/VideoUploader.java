package com.facebook.share.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.internal.WorkQueue;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class VideoUploader {
    private static final String ERROR_BAD_SERVER_RESPONSE = "Unexpected error in server response";
    private static final String ERROR_UPLOAD = "Video upload failed";
    private static final int MAX_RETRIES_PER_PHASE = 2;
    private static final String PARAM_DESCRIPTION = "description";
    private static final String PARAM_END_OFFSET = "end_offset";
    private static final String PARAM_FILE_SIZE = "file_size";
    private static final String PARAM_REF = "ref";
    private static final String PARAM_SESSION_ID = "upload_session_id";
    private static final String PARAM_START_OFFSET = "start_offset";
    private static final String PARAM_TITLE = "title";
    private static final String PARAM_UPLOAD_PHASE = "upload_phase";
    private static final String PARAM_VALUE_UPLOAD_FINISH_PHASE = "finish";
    private static final String PARAM_VALUE_UPLOAD_START_PHASE = "start";
    private static final String PARAM_VALUE_UPLOAD_TRANSFER_PHASE = "transfer";
    private static final String PARAM_VIDEO_FILE_CHUNK = "video_file_chunk";
    private static final String PARAM_VIDEO_ID = "video_id";
    private static final int RETRY_DELAY_BACK_OFF_FACTOR = 3;
    private static final int RETRY_DELAY_UNIT_MS = 5000;
    private static final String TAG = "VideoUploader";
    private static final int UPLOAD_QUEUE_MAX_CONCURRENT = 8;
    private static AccessTokenTracker accessTokenTracker;
    private static Handler handler;
    private static boolean initialized;
    private static WorkQueue uploadQueue = new WorkQueue(8);
    private static Set<d> pendingUploads = new HashSet();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f9559a;

        /* renamed from: b, reason: collision with root package name */
        public final String f9560b;

        /* renamed from: c, reason: collision with root package name */
        public final String f9561c;

        /* renamed from: d, reason: collision with root package name */
        public final String f9562d;

        /* renamed from: e, reason: collision with root package name */
        public final String f9563e;

        /* renamed from: f, reason: collision with root package name */
        public final AccessToken f9564f;

        /* renamed from: g, reason: collision with root package name */
        public final FacebookCallback<Sharer.Result> f9565g;

        /* renamed from: h, reason: collision with root package name */
        public String f9566h;
        public String i;
        public InputStream j;
        public long k;
        public String l;
        public boolean m;
        public WorkQueue.WorkItem n;
        public Bundle o;

        /* synthetic */ d(ShareVideoContent shareVideoContent, String str, FacebookCallback facebookCallback, Q q) {
            this(shareVideoContent, str, facebookCallback);
        }

        private d(ShareVideoContent shareVideoContent, String str, FacebookCallback<Sharer.Result> facebookCallback) {
            this.l = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            this.f9564f = AccessToken.getCurrentAccessToken();
            this.f9559a = shareVideoContent.getVideo().getLocalUrl();
            this.f9560b = shareVideoContent.getContentTitle();
            this.f9561c = shareVideoContent.getContentDescription();
            this.f9562d = shareVideoContent.getRef();
            this.f9563e = str;
            this.f9565g = facebookCallback;
            this.o = shareVideoContent.getVideo().getParameters();
            if (!Utility.isNullOrEmpty(shareVideoContent.getPeopleIds())) {
                this.o.putString("tags", TextUtils.join(", ", shareVideoContent.getPeopleIds()));
            }
            if (!Utility.isNullOrEmpty(shareVideoContent.getPlaceId())) {
                this.o.putString("place", shareVideoContent.getPlaceId());
            }
            if (Utility.isNullOrEmpty(shareVideoContent.getRef())) {
                return;
            }
            this.o.putString(VideoUploader.PARAM_REF, shareVideoContent.getRef());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() throws FileNotFoundException {
            try {
                if (Utility.isFileUri(this.f9559a)) {
                    ParcelFileDescriptor open = ParcelFileDescriptor.open(new File(this.f9559a.getPath()), 268435456);
                    this.k = open.getStatSize();
                    this.j = new ParcelFileDescriptor.AutoCloseInputStream(open);
                } else {
                    if (Utility.isContentUri(this.f9559a)) {
                        this.k = Utility.getContentSize(this.f9559a);
                        this.j = FacebookSdk.getApplicationContext().getContentResolver().openInputStream(this.f9559a);
                        return;
                    }
                    throw new FacebookException("Uri must be a content:// or file:// uri");
                }
            } catch (FileNotFoundException e2) {
                Utility.closeQuietly(this.j);
                throw e2;
            }
        }
    }

    static /* synthetic */ Handler access$800() {
        return getHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void cancelAllRequests() {
        synchronized (VideoUploader.class) {
            Iterator<d> it = pendingUploads.iterator();
            while (it.hasNext()) {
                it.next().m = true;
            }
        }
    }

    private static synchronized void enqueueRequest(d dVar, Runnable runnable) {
        synchronized (VideoUploader.class) {
            dVar.n = uploadQueue.addActiveWorkItem(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void enqueueUploadChunk(d dVar, String str, String str2, int i) {
        enqueueRequest(dVar, new c(dVar, str, str2, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void enqueueUploadFinish(d dVar, int i) {
        enqueueRequest(dVar, new a(dVar, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void enqueueUploadStart(d dVar, int i) {
        enqueueRequest(dVar, new b(dVar, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] getChunk(d dVar, String str, String str2) throws IOException {
        int read;
        if (!Utility.areObjectsEqual(str, dVar.l)) {
            logError(null, "Error reading video chunk. Expected chunk '%s'. Requested chunk '%s'.", dVar.l, str);
            return null;
        }
        int parseLong = (int) (Long.parseLong(str2) - Long.parseLong(str));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[Math.min(8192, parseLong)];
        do {
            read = dVar.j.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
                parseLong -= read;
                if (parseLong == 0) {
                }
            }
            dVar.l = str2;
            return byteArrayOutputStream.toByteArray();
        } while (parseLong >= 0);
        logError(null, "Error reading video chunk. Expected buffer length - '%d'. Actual - '%d'.", Integer.valueOf(parseLong + read), Integer.valueOf(read));
        return null;
    }

    private static synchronized Handler getHandler() {
        Handler handler2;
        synchronized (VideoUploader.class) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler2 = handler;
        }
        return handler2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void issueResponse(d dVar, FacebookException facebookException, String str) {
        removePendingUpload(dVar);
        Utility.closeQuietly(dVar.j);
        FacebookCallback<Sharer.Result> facebookCallback = dVar.f9565g;
        if (facebookCallback != null) {
            if (facebookException != null) {
                ShareInternalUtility.invokeOnErrorCallback(facebookCallback, facebookException);
            } else if (dVar.m) {
                ShareInternalUtility.invokeOnCancelCallback(facebookCallback);
            } else {
                ShareInternalUtility.invokeOnSuccessCallback(facebookCallback, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void logError(Exception exc, String str, Object... objArr) {
        Log.e(TAG, String.format(Locale.ROOT, str, objArr), exc);
    }

    private static void registerAccessTokenTracker() {
        accessTokenTracker = new Q();
    }

    private static synchronized void removePendingUpload(d dVar) {
        synchronized (VideoUploader.class) {
            pendingUploads.remove(dVar);
        }
    }

    public static synchronized void uploadAsync(ShareVideoContent shareVideoContent, FacebookCallback<Sharer.Result> facebookCallback) throws FileNotFoundException {
        synchronized (VideoUploader.class) {
            uploadAsync(shareVideoContent, "me", facebookCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends e {

        /* renamed from: c, reason: collision with root package name */
        static final Set<Integer> f9554c = new HashSet<Integer>() { // from class: com.facebook.share.internal.VideoUploader$FinishUploadWorkItem$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                add(1363011);
            }
        };

        public a(d dVar, int i) {
            super(dVar, i);
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        protected void a(JSONObject jSONObject) throws JSONException {
            if (jSONObject.getBoolean(GraphResponse.SUCCESS_KEY)) {
                a(null, this.f9567a.i);
            } else {
                b(new FacebookException(VideoUploader.ERROR_BAD_SERVER_RESPONSE));
            }
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        public Bundle b() {
            Bundle bundle = new Bundle();
            Bundle bundle2 = this.f9567a.o;
            if (bundle2 != null) {
                bundle.putAll(bundle2);
            }
            bundle.putString(VideoUploader.PARAM_UPLOAD_PHASE, VideoUploader.PARAM_VALUE_UPLOAD_FINISH_PHASE);
            bundle.putString(VideoUploader.PARAM_SESSION_ID, this.f9567a.f9566h);
            Utility.putNonEmptyString(bundle, "title", this.f9567a.f9560b);
            Utility.putNonEmptyString(bundle, "description", this.f9567a.f9561c);
            Utility.putNonEmptyString(bundle, VideoUploader.PARAM_REF, this.f9567a.f9562d);
            return bundle;
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        protected Set<Integer> c() {
            return f9554c;
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        protected void a(int i) {
            VideoUploader.enqueueUploadFinish(this.f9567a, i);
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        protected void b(FacebookException facebookException) {
            VideoUploader.logError(facebookException, "Video '%s' failed to finish uploading", this.f9567a.i);
            a(facebookException);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends e {

        /* renamed from: c, reason: collision with root package name */
        static final Set<Integer> f9555c = new HashSet<Integer>() { // from class: com.facebook.share.internal.VideoUploader$StartUploadWorkItem$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                add(6000);
            }
        };

        public b(d dVar, int i) {
            super(dVar, i);
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        protected void a(JSONObject jSONObject) throws JSONException {
            this.f9567a.f9566h = jSONObject.getString(VideoUploader.PARAM_SESSION_ID);
            this.f9567a.i = jSONObject.getString(VideoUploader.PARAM_VIDEO_ID);
            VideoUploader.enqueueUploadChunk(this.f9567a, jSONObject.getString(VideoUploader.PARAM_START_OFFSET), jSONObject.getString(VideoUploader.PARAM_END_OFFSET), 0);
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        public Bundle b() {
            Bundle bundle = new Bundle();
            bundle.putString(VideoUploader.PARAM_UPLOAD_PHASE, VideoUploader.PARAM_VALUE_UPLOAD_START_PHASE);
            bundle.putLong(VideoUploader.PARAM_FILE_SIZE, this.f9567a.k);
            return bundle;
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        protected Set<Integer> c() {
            return f9555c;
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        protected void b(FacebookException facebookException) {
            VideoUploader.logError(facebookException, "Error starting video upload", new Object[0]);
            a(facebookException);
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        protected void a(int i) {
            VideoUploader.enqueueUploadStart(this.f9567a, i);
        }
    }

    public static synchronized void uploadAsync(ShareVideoContent shareVideoContent, String str, FacebookCallback<Sharer.Result> facebookCallback) throws FileNotFoundException {
        synchronized (VideoUploader.class) {
            if (!initialized) {
                registerAccessTokenTracker();
                initialized = true;
            }
            Validate.notNull(shareVideoContent, "videoContent");
            Validate.notNull(str, "graphNode");
            ShareVideo video = shareVideoContent.getVideo();
            Validate.notNull(video, "videoContent.video");
            Validate.notNull(video.getLocalUrl(), "videoContent.video.localUrl");
            d dVar = new d(shareVideoContent, str, facebookCallback, null);
            dVar.a();
            pendingUploads.add(dVar);
            enqueueUploadStart(dVar, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends e {

        /* renamed from: c, reason: collision with root package name */
        static final Set<Integer> f9556c = new HashSet<Integer>() { // from class: com.facebook.share.internal.VideoUploader$TransferChunkWorkItem$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                add(1363019);
                add(1363021);
                add(1363030);
                add(1363033);
                add(1363041);
            }
        };

        /* renamed from: d, reason: collision with root package name */
        private String f9557d;

        /* renamed from: e, reason: collision with root package name */
        private String f9558e;

        public c(d dVar, String str, String str2, int i) {
            super(dVar, i);
            this.f9557d = str;
            this.f9558e = str2;
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        protected void a(JSONObject jSONObject) throws JSONException {
            String string = jSONObject.getString(VideoUploader.PARAM_START_OFFSET);
            String string2 = jSONObject.getString(VideoUploader.PARAM_END_OFFSET);
            if (Utility.areObjectsEqual(string, string2)) {
                VideoUploader.enqueueUploadFinish(this.f9567a, 0);
            } else {
                VideoUploader.enqueueUploadChunk(this.f9567a, string, string2, 0);
            }
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        public Bundle b() throws IOException {
            Bundle bundle = new Bundle();
            bundle.putString(VideoUploader.PARAM_UPLOAD_PHASE, VideoUploader.PARAM_VALUE_UPLOAD_TRANSFER_PHASE);
            bundle.putString(VideoUploader.PARAM_SESSION_ID, this.f9567a.f9566h);
            bundle.putString(VideoUploader.PARAM_START_OFFSET, this.f9557d);
            byte[] chunk = VideoUploader.getChunk(this.f9567a, this.f9557d, this.f9558e);
            if (chunk != null) {
                bundle.putByteArray(VideoUploader.PARAM_VIDEO_FILE_CHUNK, chunk);
                return bundle;
            }
            throw new FacebookException("Error reading video");
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        protected Set<Integer> c() {
            return f9556c;
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        protected void a(int i) {
            VideoUploader.enqueueUploadChunk(this.f9567a, this.f9557d, this.f9558e, i);
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        protected void b(FacebookException facebookException) {
            VideoUploader.logError(facebookException, "Error uploading video '%s'", this.f9567a.i);
            a(facebookException);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        protected d f9567a;

        /* renamed from: b, reason: collision with root package name */
        protected int f9568b;

        protected e(d dVar, int i) {
            this.f9567a = dVar;
            this.f9568b = i;
        }

        private boolean b(int i) {
            if (this.f9568b >= 2 || !c().contains(Integer.valueOf(i))) {
                return false;
            }
            VideoUploader.access$800().postDelayed(new S(this), ((int) Math.pow(3.0d, this.f9568b)) * VideoUploader.RETRY_DELAY_UNIT_MS);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public abstract void a(int i);

        protected void a(Bundle bundle) {
            d dVar = this.f9567a;
            GraphResponse executeAndWait = new GraphRequest(dVar.f9564f, String.format(Locale.ROOT, "%s/videos", dVar.f9563e), bundle, HttpMethod.POST, null).executeAndWait();
            if (executeAndWait != null) {
                FacebookRequestError error = executeAndWait.getError();
                JSONObject jSONObject = executeAndWait.getJSONObject();
                if (error != null) {
                    if (b(error.getSubErrorCode())) {
                        return;
                    }
                    b(new FacebookGraphResponseException(executeAndWait, VideoUploader.ERROR_UPLOAD));
                    return;
                } else {
                    if (jSONObject != null) {
                        try {
                            a(jSONObject);
                            return;
                        } catch (JSONException e2) {
                            a(new FacebookException(VideoUploader.ERROR_BAD_SERVER_RESPONSE, e2));
                            return;
                        }
                    }
                    b(new FacebookException(VideoUploader.ERROR_BAD_SERVER_RESPONSE));
                    return;
                }
            }
            b(new FacebookException(VideoUploader.ERROR_BAD_SERVER_RESPONSE));
        }

        protected abstract void a(JSONObject jSONObject) throws JSONException;

        protected abstract Bundle b() throws Exception;

        protected abstract void b(FacebookException facebookException);

        protected abstract Set<Integer> c();

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f9567a.m) {
                try {
                    a(b());
                    return;
                } catch (FacebookException e2) {
                    a(e2);
                    return;
                } catch (Exception e3) {
                    a(new FacebookException(VideoUploader.ERROR_UPLOAD, e3));
                    return;
                }
            }
            a((FacebookException) null);
        }

        protected void a(FacebookException facebookException) {
            a(facebookException, null);
        }

        protected void a(FacebookException facebookException, String str) {
            VideoUploader.access$800().post(new T(this, facebookException, str));
        }
    }
}
