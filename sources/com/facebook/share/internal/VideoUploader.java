package com.facebook.share.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
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

    static /* synthetic */ Handler access$800() {
        return getHandler();
    }

    public static synchronized void uploadAsync(ShareVideoContent shareVideoContent, FacebookCallback<Sharer.Result> facebookCallback) throws FileNotFoundException {
        synchronized (VideoUploader.class) {
            uploadAsync(shareVideoContent, "me", facebookCallback);
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
    public static synchronized void cancelAllRequests() {
        synchronized (VideoUploader.class) {
            Iterator<d> it = pendingUploads.iterator();
            while (it.hasNext()) {
                it.next().m = true;
            }
        }
    }

    private static synchronized void removePendingUpload(d dVar) {
        synchronized (VideoUploader.class) {
            pendingUploads.remove(dVar);
        }
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
        if (dVar.g != null) {
            if (facebookException != null) {
                ShareInternalUtility.invokeOnErrorCallback(dVar.g, facebookException);
            } else if (dVar.m) {
                ShareInternalUtility.invokeOnCancelCallback(dVar.g);
            } else {
                ShareInternalUtility.invokeOnSuccessCallback(dVar.g, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void enqueueUploadStart(d dVar, int i) {
        enqueueRequest(dVar, new b(dVar, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void enqueueUploadChunk(d dVar, String str, String str2, int i) {
        enqueueRequest(dVar, new c(dVar, str, str2, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void enqueueUploadFinish(d dVar, int i) {
        enqueueRequest(dVar, new a(dVar, i));
    }

    private static synchronized void enqueueRequest(d dVar, Runnable runnable) {
        synchronized (VideoUploader.class) {
            dVar.n = uploadQueue.addActiveWorkItem(runnable);
        }
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
        byte[] bArr = new byte[Math.min(Utility.DEFAULT_STREAM_BUFFER_SIZE, parseLong)];
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

    private static void registerAccessTokenTracker() {
        accessTokenTracker = new ae();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void logError(Exception exc, String str, Object... objArr) {
        Log.e(TAG, String.format(Locale.ROOT, str, objArr), exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f355a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;
        public final AccessToken f;
        public final FacebookCallback<Sharer.Result> g;
        public String h;
        public String i;
        public InputStream j;
        public long k;
        public String l;
        public boolean m;
        public WorkQueue.WorkItem n;
        public Bundle o;

        /* synthetic */ d(ShareVideoContent shareVideoContent, String str, FacebookCallback facebookCallback, ae aeVar) {
            this(shareVideoContent, str, facebookCallback);
        }

        private d(ShareVideoContent shareVideoContent, String str, FacebookCallback<Sharer.Result> facebookCallback) {
            this.l = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            this.f = AccessToken.getCurrentAccessToken();
            this.f355a = shareVideoContent.getVideo().getLocalUrl();
            this.b = shareVideoContent.getContentTitle();
            this.c = shareVideoContent.getContentDescription();
            this.d = shareVideoContent.getRef();
            this.e = str;
            this.g = facebookCallback;
            this.o = shareVideoContent.getVideo().getParameters();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() throws FileNotFoundException {
            try {
                if (Utility.isFileUri(this.f355a)) {
                    ParcelFileDescriptor open = ParcelFileDescriptor.open(new File(this.f355a.getPath()), 268435456);
                    this.k = open.getStatSize();
                    this.j = new ParcelFileDescriptor.AutoCloseInputStream(open);
                } else {
                    if (Utility.isContentUri(this.f355a)) {
                        this.k = Utility.getContentSize(this.f355a);
                        this.j = FacebookSdk.getApplicationContext().getContentResolver().openInputStream(this.f355a);
                        return;
                    }
                    throw new FacebookException("Uri must be a content:// or file:// uri");
                }
            } catch (FileNotFoundException e) {
                Utility.closeQuietly(this.j);
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends e {

        /* renamed from: a, reason: collision with root package name */
        static final Set<Integer> f353a = new HashSet<Integer>() { // from class: com.facebook.share.internal.VideoUploader$StartUploadWorkItem$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                add(6000);
            }
        };

        public b(d dVar, int i) {
            super(dVar, i);
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putString(VideoUploader.PARAM_UPLOAD_PHASE, VideoUploader.PARAM_VALUE_UPLOAD_START_PHASE);
            bundle.putLong(VideoUploader.PARAM_FILE_SIZE, this.b.k);
            return bundle;
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        protected void a(JSONObject jSONObject) throws JSONException {
            this.b.h = jSONObject.getString(VideoUploader.PARAM_SESSION_ID);
            this.b.i = jSONObject.getString(VideoUploader.PARAM_VIDEO_ID);
            VideoUploader.enqueueUploadChunk(this.b, jSONObject.getString(VideoUploader.PARAM_START_OFFSET), jSONObject.getString(VideoUploader.PARAM_END_OFFSET), 0);
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        protected void a(FacebookException facebookException) {
            VideoUploader.logError(facebookException, "Error starting video upload", new Object[0]);
            b(facebookException);
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        protected Set<Integer> b() {
            return f353a;
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        protected void a(int i) {
            VideoUploader.enqueueUploadStart(this.b, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends e {

        /* renamed from: a, reason: collision with root package name */
        static final Set<Integer> f354a = new HashSet<Integer>() { // from class: com.facebook.share.internal.VideoUploader$TransferChunkWorkItem$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                add(1363019);
                add(1363021);
                add(1363030);
                add(1363033);
                add(1363041);
            }
        };
        private String d;
        private String e;

        public c(d dVar, String str, String str2, int i) {
            super(dVar, i);
            this.d = str;
            this.e = str2;
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        public Bundle a() throws IOException {
            Bundle bundle = new Bundle();
            bundle.putString(VideoUploader.PARAM_UPLOAD_PHASE, VideoUploader.PARAM_VALUE_UPLOAD_TRANSFER_PHASE);
            bundle.putString(VideoUploader.PARAM_SESSION_ID, this.b.h);
            bundle.putString(VideoUploader.PARAM_START_OFFSET, this.d);
            byte[] chunk = VideoUploader.getChunk(this.b, this.d, this.e);
            if (chunk != null) {
                bundle.putByteArray(VideoUploader.PARAM_VIDEO_FILE_CHUNK, chunk);
                return bundle;
            }
            throw new FacebookException("Error reading video");
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        protected void a(JSONObject jSONObject) throws JSONException {
            String string = jSONObject.getString(VideoUploader.PARAM_START_OFFSET);
            String string2 = jSONObject.getString(VideoUploader.PARAM_END_OFFSET);
            if (Utility.areObjectsEqual(string, string2)) {
                VideoUploader.enqueueUploadFinish(this.b, 0);
            } else {
                VideoUploader.enqueueUploadChunk(this.b, string, string2, 0);
            }
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        protected void a(FacebookException facebookException) {
            VideoUploader.logError(facebookException, "Error uploading video '%s'", this.b.i);
            b(facebookException);
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        protected Set<Integer> b() {
            return f354a;
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        protected void a(int i) {
            VideoUploader.enqueueUploadChunk(this.b, this.d, this.e, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends e {

        /* renamed from: a, reason: collision with root package name */
        static final Set<Integer> f352a = new HashSet<Integer>() { // from class: com.facebook.share.internal.VideoUploader$FinishUploadWorkItem$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                add(1363011);
            }
        };

        public a(d dVar, int i) {
            super(dVar, i);
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        public Bundle a() {
            Bundle bundle = new Bundle();
            if (this.b.o != null) {
                bundle.putAll(this.b.o);
            }
            bundle.putString(VideoUploader.PARAM_UPLOAD_PHASE, VideoUploader.PARAM_VALUE_UPLOAD_FINISH_PHASE);
            bundle.putString(VideoUploader.PARAM_SESSION_ID, this.b.h);
            Utility.putNonEmptyString(bundle, "title", this.b.b);
            Utility.putNonEmptyString(bundle, "description", this.b.c);
            Utility.putNonEmptyString(bundle, VideoUploader.PARAM_REF, this.b.d);
            return bundle;
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        protected void a(JSONObject jSONObject) throws JSONException {
            if (jSONObject.getBoolean(GraphResponse.SUCCESS_KEY)) {
                a(null, this.b.i);
            } else {
                a(new FacebookException(VideoUploader.ERROR_BAD_SERVER_RESPONSE));
            }
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        protected void a(FacebookException facebookException) {
            VideoUploader.logError(facebookException, "Video '%s' failed to finish uploading", this.b.i);
            b(facebookException);
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        protected Set<Integer> b() {
            return f352a;
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        protected void a(int i) {
            VideoUploader.enqueueUploadFinish(this.b, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class e implements Runnable {
        protected d b;
        protected int c;

        protected abstract Bundle a() throws Exception;

        /* JADX INFO: Access modifiers changed from: protected */
        public abstract void a(int i);

        protected abstract void a(FacebookException facebookException);

        protected abstract void a(JSONObject jSONObject) throws JSONException;

        protected abstract Set<Integer> b();

        protected e(d dVar, int i) {
            this.b = dVar;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.b.m) {
                try {
                    a(a());
                    return;
                } catch (FacebookException e) {
                    b(e);
                    return;
                } catch (Exception e2) {
                    b(new FacebookException(VideoUploader.ERROR_UPLOAD, e2));
                    return;
                }
            }
            b((FacebookException) null);
        }

        protected void a(Bundle bundle) {
            GraphResponse executeAndWait = new GraphRequest(this.b.f, String.format(Locale.ROOT, "%s/videos", this.b.e), bundle, HttpMethod.POST, null).executeAndWait();
            if (executeAndWait != null) {
                FacebookRequestError error = executeAndWait.getError();
                JSONObject jSONObject = executeAndWait.getJSONObject();
                if (error != null) {
                    if (!b(error.getSubErrorCode())) {
                        a(new FacebookGraphResponseException(executeAndWait, VideoUploader.ERROR_UPLOAD));
                        return;
                    }
                    return;
                } else {
                    if (jSONObject != null) {
                        try {
                            a(jSONObject);
                            return;
                        } catch (JSONException e) {
                            b(new FacebookException(VideoUploader.ERROR_BAD_SERVER_RESPONSE, e));
                            return;
                        }
                    }
                    a(new FacebookException(VideoUploader.ERROR_BAD_SERVER_RESPONSE));
                    return;
                }
            }
            a(new FacebookException(VideoUploader.ERROR_BAD_SERVER_RESPONSE));
        }

        private boolean b(int i) {
            if (this.c >= 2 || !b().contains(Integer.valueOf(i))) {
                return false;
            }
            VideoUploader.access$800().postDelayed(new af(this), ((int) Math.pow(3.0d, this.c)) * VideoUploader.RETRY_DELAY_UNIT_MS);
            return true;
        }

        protected void b(FacebookException facebookException) {
            a(facebookException, null);
        }

        protected void a(FacebookException facebookException, String str) {
            VideoUploader.access$800().post(new ag(this, facebookException, str));
        }
    }
}
