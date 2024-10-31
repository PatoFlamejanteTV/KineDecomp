package com.facebook;

import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.facebook.GraphRequestBatch;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.InternalSettings;
import com.facebook.internal.Logger;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.share.internal.OpenGraphJSONUtility;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.model.ShareOpenGraphObject;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.keyczar.Keyczar;

/* loaded from: classes.dex */
public class GraphRequest {
    private static final String ACCEPT_LANGUAGE_HEADER = "Accept-Language";
    private static final String ACCESS_TOKEN_PARAM = "access_token";
    private static final String ATTACHED_FILES_PARAM = "attached_files";
    private static final String ATTACHMENT_FILENAME_PREFIX = "file";
    private static final String BATCH_APP_ID_PARAM = "batch_app_id";
    private static final String BATCH_BODY_PARAM = "body";
    private static final String BATCH_ENTRY_DEPENDS_ON_PARAM = "depends_on";
    private static final String BATCH_ENTRY_NAME_PARAM = "name";
    private static final String BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM = "omit_response_on_success";
    private static final String BATCH_METHOD_PARAM = "method";
    private static final String BATCH_PARAM = "batch";
    private static final String BATCH_RELATIVE_URL_PARAM = "relative_url";
    private static final String CAPTION_PARAM = "caption";
    private static final String CONTENT_ENCODING_HEADER = "Content-Encoding";
    private static final String CONTENT_TYPE_HEADER = "Content-Type";
    private static final String DEBUG_KEY = "__debug__";
    private static final String DEBUG_MESSAGES_KEY = "messages";
    private static final String DEBUG_MESSAGE_KEY = "message";
    private static final String DEBUG_MESSAGE_LINK_KEY = "link";
    private static final String DEBUG_MESSAGE_TYPE_KEY = "type";
    private static final String DEBUG_PARAM = "debug";
    private static final String DEBUG_SEVERITY_INFO = "info";
    private static final String DEBUG_SEVERITY_WARNING = "warning";
    public static final String FIELDS_PARAM = "fields";
    private static final String FORMAT_JSON = "json";
    private static final String FORMAT_PARAM = "format";
    private static final String GRAPH_PATH_FORMAT = "%s/%s";
    private static final String ISO_8601_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ssZ";
    public static final int MAXIMUM_BATCH_SIZE = 50;
    private static final String ME = "me";
    private static final String MIME_BOUNDARY = "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f";
    private static final String MY_FRIENDS = "me/friends";
    private static final String MY_PHOTOS = "me/photos";
    private static final String PICTURE_PARAM = "picture";
    private static final String SDK_ANDROID = "android";
    private static final String SDK_PARAM = "sdk";
    private static final String SEARCH = "search";
    private static final String USER_AGENT_BASE = "FBAndroidSDK";
    private static final String USER_AGENT_HEADER = "User-Agent";
    private static final String VIDEOS_SUFFIX = "/videos";
    private static String defaultBatchApplicationId;
    private static volatile String userAgent;
    private AccessToken accessToken;
    private String batchEntryDependsOn;
    private String batchEntryName;
    private boolean batchEntryOmitResultOnSuccess;
    private Callback callback;
    private JSONObject graphObject;
    private String graphPath;
    private HttpMethod httpMethod;
    private String overriddenURL;
    private Bundle parameters;
    private boolean skipClientToken;
    private Object tag;
    private String version;
    public static final String TAG = GraphRequest.class.getSimpleName();
    private static Pattern versionPattern = Pattern.compile("^/?v\\d+\\.\\d+/(.*)");

    /* loaded from: classes.dex */
    public interface Callback {
        void onCompleted(GraphResponse graphResponse);
    }

    /* loaded from: classes.dex */
    public interface GraphJSONArrayCallback {
        void onCompleted(JSONArray jSONArray, GraphResponse graphResponse);
    }

    /* loaded from: classes.dex */
    public interface GraphJSONObjectCallback {
        void onCompleted(JSONObject jSONObject, GraphResponse graphResponse);
    }

    /* loaded from: classes.dex */
    public interface OnProgressCallback extends Callback {
        void onProgress(long j, long j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface b {
        void a(String str, String str2) throws IOException;
    }

    public GraphRequest() {
        this(null, null, null, null, null);
    }

    public GraphRequest(AccessToken accessToken, String str) {
        this(accessToken, str, null, null, null);
    }

    public GraphRequest(AccessToken accessToken, String str, Bundle bundle, HttpMethod httpMethod) {
        this(accessToken, str, bundle, httpMethod, null);
    }

    public GraphRequest(AccessToken accessToken, String str, Bundle bundle, HttpMethod httpMethod, Callback callback) {
        this(accessToken, str, bundle, httpMethod, callback, null);
    }

    public GraphRequest(AccessToken accessToken, String str, Bundle bundle, HttpMethod httpMethod, Callback callback, String str2) {
        this.batchEntryOmitResultOnSuccess = true;
        this.skipClientToken = false;
        this.accessToken = accessToken;
        this.graphPath = str;
        this.version = str2;
        setCallback(callback);
        setHttpMethod(httpMethod);
        if (bundle != null) {
            this.parameters = new Bundle(bundle);
        } else {
            this.parameters = new Bundle();
        }
        if (this.version == null) {
            this.version = ServerProtocol.getAPIVersion();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GraphRequest(AccessToken accessToken, URL url) {
        this.batchEntryOmitResultOnSuccess = true;
        this.skipClientToken = false;
        this.accessToken = accessToken;
        this.overriddenURL = url.toString();
        setHttpMethod(HttpMethod.GET);
        this.parameters = new Bundle();
    }

    public static GraphRequest newDeleteObjectRequest(AccessToken accessToken, String str, Callback callback) {
        return new GraphRequest(accessToken, str, null, HttpMethod.DELETE, callback);
    }

    public static GraphRequest newMeRequest(AccessToken accessToken, GraphJSONObjectCallback graphJSONObjectCallback) {
        return new GraphRequest(accessToken, ME, null, null, new p(graphJSONObjectCallback));
    }

    public static GraphRequest newPostRequest(AccessToken accessToken, String str, JSONObject jSONObject, Callback callback) {
        GraphRequest graphRequest = new GraphRequest(accessToken, str, null, HttpMethod.POST, callback);
        graphRequest.setGraphObject(jSONObject);
        return graphRequest;
    }

    public static GraphRequest newMyFriendsRequest(AccessToken accessToken, GraphJSONArrayCallback graphJSONArrayCallback) {
        return new GraphRequest(accessToken, MY_FRIENDS, null, null, new q(graphJSONArrayCallback));
    }

    public static GraphRequest newGraphPathRequest(AccessToken accessToken, String str, Callback callback) {
        return new GraphRequest(accessToken, str, null, null, callback);
    }

    public static GraphRequest newPlacesSearchRequest(AccessToken accessToken, Location location, int i, int i2, String str, GraphJSONArrayCallback graphJSONArrayCallback) {
        if (location == null && Utility.isNullOrEmpty(str)) {
            throw new FacebookException("Either location or searchText must be specified.");
        }
        Bundle bundle = new Bundle(5);
        bundle.putString(DEBUG_MESSAGE_TYPE_KEY, "place");
        bundle.putInt("limit", i2);
        if (location != null) {
            bundle.putString("center", String.format(Locale.US, "%f,%f", Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude())));
            bundle.putInt("distance", i);
        }
        if (!Utility.isNullOrEmpty(str)) {
            bundle.putString("q", str);
        }
        return new GraphRequest(accessToken, SEARCH, bundle, HttpMethod.GET, new s(graphJSONArrayCallback));
    }

    public static GraphRequest newUploadPhotoRequest(AccessToken accessToken, String str, Bitmap bitmap, String str2, Bundle bundle, Callback callback) {
        String defaultPhotoPathIfNull = getDefaultPhotoPathIfNull(str);
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putParcelable("picture", bitmap);
        if (str2 != null && !str2.isEmpty()) {
            bundle2.putString("caption", str2);
        }
        return new GraphRequest(accessToken, defaultPhotoPathIfNull, bundle2, HttpMethod.POST, callback);
    }

    public static GraphRequest newUploadPhotoRequest(AccessToken accessToken, String str, File file, String str2, Bundle bundle, Callback callback) throws FileNotFoundException {
        String defaultPhotoPathIfNull = getDefaultPhotoPathIfNull(str);
        ParcelFileDescriptor open = ParcelFileDescriptor.open(file, 268435456);
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putParcelable("picture", open);
        if (str2 != null && !str2.isEmpty()) {
            bundle2.putString("caption", str2);
        }
        return new GraphRequest(accessToken, defaultPhotoPathIfNull, bundle2, HttpMethod.POST, callback);
    }

    public static GraphRequest newUploadPhotoRequest(AccessToken accessToken, String str, Uri uri, String str2, Bundle bundle, Callback callback) throws FileNotFoundException {
        String defaultPhotoPathIfNull = getDefaultPhotoPathIfNull(str);
        if (Utility.isFileUri(uri)) {
            return newUploadPhotoRequest(accessToken, defaultPhotoPathIfNull, new File(uri.getPath()), str2, bundle, callback);
        }
        if (!Utility.isContentUri(uri)) {
            throw new FacebookException("The photo Uri must be either a file:// or content:// Uri");
        }
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putParcelable("picture", uri);
        return new GraphRequest(accessToken, defaultPhotoPathIfNull, bundle2, HttpMethod.POST, callback);
    }

    public static GraphRequest newCustomAudienceThirdPartyIdRequest(AccessToken accessToken, Context context, String str, Callback callback) {
        String androidAdvertiserId;
        String applicationId = (str != null || accessToken == null) ? str : accessToken.getApplicationId();
        if (applicationId == null) {
            applicationId = Utility.getMetadataApplicationId(context);
        }
        if (applicationId == null) {
            throw new FacebookException("Facebook App ID cannot be determined");
        }
        String str2 = applicationId + "/custom_audience_third_party_id";
        AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(context);
        Bundle bundle = new Bundle();
        if (accessToken == null) {
            if (attributionIdentifiers.getAttributionId() != null) {
                androidAdvertiserId = attributionIdentifiers.getAttributionId();
            } else {
                androidAdvertiserId = attributionIdentifiers.getAndroidAdvertiserId();
            }
            if (attributionIdentifiers.getAttributionId() != null) {
                bundle.putString("udid", androidAdvertiserId);
            }
        }
        if (FacebookSdk.getLimitEventAndDataUsage(context) || attributionIdentifiers.isTrackingLimited()) {
            bundle.putString("limit_event_usage", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
        return new GraphRequest(accessToken, str2, bundle, HttpMethod.GET, callback);
    }

    public static GraphRequest newCustomAudienceThirdPartyIdRequest(AccessToken accessToken, Context context, Callback callback) {
        return newCustomAudienceThirdPartyIdRequest(accessToken, context, null, callback);
    }

    public final JSONObject getGraphObject() {
        return this.graphObject;
    }

    public final void setGraphObject(JSONObject jSONObject) {
        this.graphObject = jSONObject;
    }

    public final String getGraphPath() {
        return this.graphPath;
    }

    public final void setGraphPath(String str) {
        this.graphPath = str;
    }

    public final HttpMethod getHttpMethod() {
        return this.httpMethod;
    }

    public final void setHttpMethod(HttpMethod httpMethod) {
        if (this.overriddenURL != null && httpMethod != HttpMethod.GET) {
            throw new FacebookException("Can't change HTTP method on request with overridden URL.");
        }
        if (httpMethod == null) {
            httpMethod = HttpMethod.GET;
        }
        this.httpMethod = httpMethod;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public final void setSkipClientToken(boolean z) {
        this.skipClientToken = z;
    }

    public final Bundle getParameters() {
        return this.parameters;
    }

    public final void setParameters(Bundle bundle) {
        this.parameters = bundle;
    }

    public final AccessToken getAccessToken() {
        return this.accessToken;
    }

    public final void setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    public final String getBatchEntryName() {
        return this.batchEntryName;
    }

    public final void setBatchEntryName(String str) {
        this.batchEntryName = str;
    }

    public final String getBatchEntryDependsOn() {
        return this.batchEntryDependsOn;
    }

    public final void setBatchEntryDependsOn(String str) {
        this.batchEntryDependsOn = str;
    }

    public final boolean getBatchEntryOmitResultOnSuccess() {
        return this.batchEntryOmitResultOnSuccess;
    }

    public final void setBatchEntryOmitResultOnSuccess(boolean z) {
        this.batchEntryOmitResultOnSuccess = z;
    }

    public static final String getDefaultBatchApplicationId() {
        return defaultBatchApplicationId;
    }

    public static final void setDefaultBatchApplicationId(String str) {
        defaultBatchApplicationId = str;
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public final void setCallback(Callback callback) {
        if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_INFO) || FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            this.callback = new t(this, callback);
        } else {
            this.callback = callback;
        }
    }

    public final void setTag(Object obj) {
        this.tag = obj;
    }

    public final Object getTag() {
        return this.tag;
    }

    public final GraphResponse executeAndWait() {
        return executeAndWait(this);
    }

    public final GraphRequestAsyncTask executeAsync() {
        return executeBatchAsync(this);
    }

    public static HttpURLConnection toHttpConnection(GraphRequest... graphRequestArr) {
        return toHttpConnection(Arrays.asList(graphRequestArr));
    }

    public static HttpURLConnection toHttpConnection(Collection<GraphRequest> collection) {
        Validate.notEmptyAndContainsNoNulls(collection, "requests");
        return toHttpConnection(new GraphRequestBatch(collection));
    }

    public static HttpURLConnection toHttpConnection(GraphRequestBatch graphRequestBatch) {
        URL url;
        validateFieldsParamForGetRequests(graphRequestBatch);
        try {
            if (graphRequestBatch.size() == 1) {
                url = new URL(graphRequestBatch.get(0).getUrlForSingleRequest());
            } else {
                url = new URL(ServerProtocol.getGraphUrlBase());
            }
            try {
                HttpURLConnection createConnection = createConnection(url);
                serializeToUrlConnection(graphRequestBatch, createConnection);
                return createConnection;
            } catch (IOException e) {
                throw new FacebookException("could not construct request body", e);
            } catch (JSONException e2) {
                throw new FacebookException("could not construct request body", e2);
            }
        } catch (MalformedURLException e3) {
            throw new FacebookException("could not construct URL for request", e3);
        }
    }

    public static GraphResponse executeAndWait(GraphRequest graphRequest) {
        List<GraphResponse> executeBatchAndWait = executeBatchAndWait(graphRequest);
        if (executeBatchAndWait == null || executeBatchAndWait.size() != 1) {
            throw new FacebookException("invalid state: expected a single response");
        }
        return executeBatchAndWait.get(0);
    }

    public static List<GraphResponse> executeBatchAndWait(GraphRequest... graphRequestArr) {
        Validate.notNull(graphRequestArr, "requests");
        return executeBatchAndWait(Arrays.asList(graphRequestArr));
    }

    public static List<GraphResponse> executeBatchAndWait(Collection<GraphRequest> collection) {
        return executeBatchAndWait(new GraphRequestBatch(collection));
    }

    public static List<GraphResponse> executeBatchAndWait(GraphRequestBatch graphRequestBatch) {
        Validate.notEmptyAndContainsNoNulls(graphRequestBatch, "requests");
        try {
            return executeConnectionAndWait(toHttpConnection(graphRequestBatch), graphRequestBatch);
        } catch (Exception e) {
            List<GraphResponse> constructErrorResponses = GraphResponse.constructErrorResponses(graphRequestBatch.getRequests(), null, new FacebookException(e));
            runCallbacks(graphRequestBatch, constructErrorResponses);
            return constructErrorResponses;
        }
    }

    public static GraphRequestAsyncTask executeBatchAsync(GraphRequest... graphRequestArr) {
        Validate.notNull(graphRequestArr, "requests");
        return executeBatchAsync(Arrays.asList(graphRequestArr));
    }

    public static GraphRequestAsyncTask executeBatchAsync(Collection<GraphRequest> collection) {
        return executeBatchAsync(new GraphRequestBatch(collection));
    }

    public static GraphRequestAsyncTask executeBatchAsync(GraphRequestBatch graphRequestBatch) {
        Validate.notEmptyAndContainsNoNulls(graphRequestBatch, "requests");
        GraphRequestAsyncTask graphRequestAsyncTask = new GraphRequestAsyncTask(graphRequestBatch);
        graphRequestAsyncTask.executeOnExecutor(FacebookSdk.getExecutor(), null);
        return graphRequestAsyncTask;
    }

    public static List<GraphResponse> executeConnectionAndWait(HttpURLConnection httpURLConnection, Collection<GraphRequest> collection) {
        return executeConnectionAndWait(httpURLConnection, new GraphRequestBatch(collection));
    }

    public static List<GraphResponse> executeConnectionAndWait(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        List<GraphResponse> fromHttpConnection = GraphResponse.fromHttpConnection(httpURLConnection, graphRequestBatch);
        Utility.disconnectQuietly(httpURLConnection);
        int size = graphRequestBatch.size();
        if (size != fromHttpConnection.size()) {
            throw new FacebookException(String.format(Locale.US, "Received %d responses while expecting %d", Integer.valueOf(fromHttpConnection.size()), Integer.valueOf(size)));
        }
        runCallbacks(graphRequestBatch, fromHttpConnection);
        d.a().d();
        return fromHttpConnection;
    }

    public static GraphRequestAsyncTask executeConnectionAsync(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        return executeConnectionAsync(null, httpURLConnection, graphRequestBatch);
    }

    public static GraphRequestAsyncTask executeConnectionAsync(Handler handler, HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        Validate.notNull(httpURLConnection, "connection");
        GraphRequestAsyncTask graphRequestAsyncTask = new GraphRequestAsyncTask(httpURLConnection, graphRequestBatch);
        graphRequestBatch.setCallbackHandler(handler);
        graphRequestAsyncTask.executeOnExecutor(FacebookSdk.getExecutor(), null);
        return graphRequestAsyncTask;
    }

    public String toString() {
        return "{Request:  accessToken: " + (this.accessToken == null ? "null" : this.accessToken) + ", graphPath: " + this.graphPath + ", graphObject: " + this.graphObject + ", httpMethod: " + this.httpMethod + ", parameters: " + this.parameters + "}";
    }

    static void runCallbacks(GraphRequestBatch graphRequestBatch, List<GraphResponse> list) {
        int size = graphRequestBatch.size();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            GraphRequest graphRequest = graphRequestBatch.get(i);
            if (graphRequest.callback != null) {
                arrayList.add(new Pair(graphRequest.callback, list.get(i)));
            }
        }
        if (arrayList.size() > 0) {
            u uVar = new u(arrayList, graphRequestBatch);
            Handler callbackHandler = graphRequestBatch.getCallbackHandler();
            if (callbackHandler == null) {
                uVar.run();
            } else {
                callbackHandler.post(uVar);
            }
        }
    }

    private static String getDefaultPhotoPathIfNull(String str) {
        return str == null ? "me/photos" : str;
    }

    private static HttpURLConnection createConnection(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestProperty(USER_AGENT_HEADER, getUserAgent());
        httpURLConnection.setRequestProperty(ACCEPT_LANGUAGE_HEADER, Locale.getDefault().toString());
        httpURLConnection.setChunkedStreamingMode(0);
        return httpURLConnection;
    }

    private void addCommonParameters() {
        if (this.accessToken != null) {
            if (!this.parameters.containsKey("access_token")) {
                String token = this.accessToken.getToken();
                Logger.registerAccessToken(token);
                this.parameters.putString("access_token", token);
            }
        } else if (!this.skipClientToken && !this.parameters.containsKey("access_token")) {
            String applicationId = FacebookSdk.getApplicationId();
            String clientToken = FacebookSdk.getClientToken();
            if (!Utility.isNullOrEmpty(applicationId) && !Utility.isNullOrEmpty(clientToken)) {
                this.parameters.putString("access_token", applicationId + "|" + clientToken);
            } else {
                Log.d(TAG, "Warning: Request without access token missing application ID or client token.");
            }
        }
        this.parameters.putString("sdk", SDK_ANDROID);
        this.parameters.putString(FORMAT_PARAM, FORMAT_JSON);
        if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_INFO)) {
            this.parameters.putString(DEBUG_PARAM, DEBUG_SEVERITY_INFO);
        } else if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            this.parameters.putString(DEBUG_PARAM, DEBUG_SEVERITY_WARNING);
        }
    }

    private String appendParametersToBaseUrl(String str) {
        Uri.Builder encodedPath = new Uri.Builder().encodedPath(str);
        for (String str2 : this.parameters.keySet()) {
            Object obj = this.parameters.get(str2);
            if (obj == null) {
                obj = "";
            }
            if (!isSupportedParameterType(obj)) {
                if (this.httpMethod == HttpMethod.GET) {
                    throw new IllegalArgumentException(String.format(Locale.US, "Unsupported parameter type for GET request: %s", obj.getClass().getSimpleName()));
                }
            } else {
                encodedPath.appendQueryParameter(str2, parameterToString(obj).toString());
            }
        }
        return encodedPath.toString();
    }

    final String getUrlForBatchedRequest() {
        if (this.overriddenURL != null) {
            throw new FacebookException("Can't override URL for a batch request");
        }
        String graphPathWithVersion = getGraphPathWithVersion();
        addCommonParameters();
        return appendParametersToBaseUrl(graphPathWithVersion);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String getUrlForSingleRequest() {
        String graphUrlBase;
        if (this.overriddenURL != null) {
            return this.overriddenURL.toString();
        }
        if (getHttpMethod() == HttpMethod.POST && this.graphPath != null && this.graphPath.endsWith(VIDEOS_SUFFIX)) {
            graphUrlBase = ServerProtocol.getGraphVideoUrlBase();
        } else {
            graphUrlBase = ServerProtocol.getGraphUrlBase();
        }
        String format = String.format(GRAPH_PATH_FORMAT, graphUrlBase, getGraphPathWithVersion());
        addCommonParameters();
        return appendParametersToBaseUrl(format);
    }

    private String getGraphPathWithVersion() {
        return versionPattern.matcher(this.graphPath).matches() ? this.graphPath : String.format(GRAPH_PATH_FORMAT, this.version, this.graphPath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final GraphRequest f235a;
        private final Object b;

        public a(GraphRequest graphRequest, Object obj) {
            this.f235a = graphRequest;
            this.b = obj;
        }

        public GraphRequest a() {
            return this.f235a;
        }

        public Object b() {
            return this.b;
        }
    }

    private void serializeToBatch(JSONArray jSONArray, Map<String, a> map) throws JSONException, IOException {
        JSONObject jSONObject = new JSONObject();
        if (this.batchEntryName != null) {
            jSONObject.put("name", this.batchEntryName);
            jSONObject.put(BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM, this.batchEntryOmitResultOnSuccess);
        }
        if (this.batchEntryDependsOn != null) {
            jSONObject.put(BATCH_ENTRY_DEPENDS_ON_PARAM, this.batchEntryDependsOn);
        }
        String urlForBatchedRequest = getUrlForBatchedRequest();
        jSONObject.put(BATCH_RELATIVE_URL_PARAM, urlForBatchedRequest);
        jSONObject.put(BATCH_METHOD_PARAM, this.httpMethod);
        if (this.accessToken != null) {
            Logger.registerAccessToken(this.accessToken.getToken());
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.parameters.keySet().iterator();
        while (it.hasNext()) {
            Object obj = this.parameters.get(it.next());
            if (isSupportedAttachmentType(obj)) {
                String format = String.format(Locale.ROOT, "%s%d", ATTACHMENT_FILENAME_PREFIX, Integer.valueOf(map.size()));
                arrayList.add(format);
                map.put(format, new a(this, obj));
            }
        }
        if (!arrayList.isEmpty()) {
            jSONObject.put(ATTACHED_FILES_PARAM, TextUtils.join(",", arrayList));
        }
        if (this.graphObject != null) {
            ArrayList arrayList2 = new ArrayList();
            processGraphObject(this.graphObject, urlForBatchedRequest, new v(this, arrayList2));
            jSONObject.put(BATCH_BODY_PARAM, TextUtils.join("&", arrayList2));
        }
        jSONArray.put(jSONObject);
    }

    private static boolean hasOnProgressCallbacks(GraphRequestBatch graphRequestBatch) {
        Iterator<GraphRequestBatch.Callback> it = graphRequestBatch.getCallbacks().iterator();
        while (it.hasNext()) {
            if (it.next() instanceof GraphRequestBatch.OnProgressCallback) {
                return true;
            }
        }
        Iterator<GraphRequest> it2 = graphRequestBatch.iterator();
        while (it2.hasNext()) {
            if (it2.next().getCallback() instanceof OnProgressCallback) {
                return true;
            }
        }
        return false;
    }

    private static void setConnectionContentType(HttpURLConnection httpURLConnection, boolean z) {
        if (z) {
            httpURLConnection.setRequestProperty(CONTENT_TYPE_HEADER, "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty(CONTENT_ENCODING_HEADER, "gzip");
        } else {
            httpURLConnection.setRequestProperty(CONTENT_TYPE_HEADER, getMimeContentType());
        }
    }

    private static boolean isGzipCompressible(GraphRequestBatch graphRequestBatch) {
        Iterator<GraphRequest> it = graphRequestBatch.iterator();
        while (it.hasNext()) {
            GraphRequest next = it.next();
            Iterator<String> it2 = next.parameters.keySet().iterator();
            while (it2.hasNext()) {
                if (isSupportedAttachmentType(next.parameters.get(it2.next()))) {
                    return false;
                }
            }
        }
        return true;
    }

    static final boolean shouldWarnOnMissingFieldsParam(GraphRequest graphRequest) {
        String version = graphRequest.getVersion();
        if (Utility.isNullOrEmpty(version)) {
            return true;
        }
        if (version.startsWith("v")) {
            version = version.substring(1);
        }
        String[] split = version.split("\\.");
        return (split.length >= 2 && Integer.parseInt(split[0]) > 2) || (Integer.parseInt(split[0]) >= 2 && Integer.parseInt(split[1]) >= 4);
    }

    static final void validateFieldsParamForGetRequests(GraphRequestBatch graphRequestBatch) {
        Iterator<GraphRequest> it = graphRequestBatch.iterator();
        while (it.hasNext()) {
            GraphRequest next = it.next();
            if (HttpMethod.GET.equals(next.getHttpMethod()) && shouldWarnOnMissingFieldsParam(next)) {
                Bundle parameters = next.getParameters();
                if (!parameters.containsKey(FIELDS_PARAM) || Utility.isNullOrEmpty(parameters.getString(FIELDS_PARAM))) {
                    Logger.log(LoggingBehavior.DEVELOPER_ERRORS, 5, "Request", "starting with Graph API v2.4, GET requests for /%s should contain an explicit \"fields\" parameter.", next.getGraphPath());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static final void serializeToUrlConnection(com.facebook.GraphRequestBatch r13, java.net.HttpURLConnection r14) throws java.io.IOException, org.json.JSONException {
        /*
            r4 = 0
            r6 = 0
            r1 = 1
            com.facebook.internal.Logger r12 = new com.facebook.internal.Logger
            com.facebook.LoggingBehavior r0 = com.facebook.LoggingBehavior.REQUESTS
            java.lang.String r2 = "Request"
            r12.<init>(r0, r2)
            int r2 = r13.size()
            boolean r5 = isGzipCompressible(r13)
            if (r2 != r1) goto L75
            com.facebook.GraphRequest r0 = r13.get(r6)
            com.facebook.HttpMethod r0 = r0.httpMethod
        L1c:
            java.lang.String r3 = r0.name()
            r14.setRequestMethod(r3)
            setConnectionContentType(r14, r5)
            java.net.URL r3 = r14.getURL()
            java.lang.String r7 = "Request:\n"
            r12.append(r7)
            java.lang.String r7 = "Id"
            java.lang.String r8 = r13.getId()
            r12.appendKeyValue(r7, r8)
            java.lang.String r7 = "URL"
            r12.appendKeyValue(r7, r3)
            java.lang.String r7 = "Method"
            java.lang.String r8 = r14.getRequestMethod()
            r12.appendKeyValue(r7, r8)
            java.lang.String r7 = "User-Agent"
            java.lang.String r8 = "User-Agent"
            java.lang.String r8 = r14.getRequestProperty(r8)
            r12.appendKeyValue(r7, r8)
            java.lang.String r7 = "Content-Type"
            java.lang.String r8 = "Content-Type"
            java.lang.String r8 = r14.getRequestProperty(r8)
            r12.appendKeyValue(r7, r8)
            int r7 = r13.getTimeout()
            r14.setConnectTimeout(r7)
            int r7 = r13.getTimeout()
            r14.setReadTimeout(r7)
            com.facebook.HttpMethod r7 = com.facebook.HttpMethod.POST
            if (r0 != r7) goto L78
            r0 = r1
        L6f:
            if (r0 != 0) goto L7a
            r12.log()
        L74:
            return
        L75:
            com.facebook.HttpMethod r0 = com.facebook.HttpMethod.POST
            goto L1c
        L78:
            r0 = r6
            goto L6f
        L7a:
            r14.setDoOutput(r1)
            java.io.BufferedOutputStream r7 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> Lc0
            java.io.OutputStream r0 = r14.getOutputStream()     // Catch: java.lang.Throwable -> Lc0
            r7.<init>(r0)     // Catch: java.lang.Throwable -> Lc0
            if (r5 == 0) goto L8e
            java.util.zip.GZIPOutputStream r0 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> Lc8
            r0.<init>(r7)     // Catch: java.lang.Throwable -> Lc8
            r7 = r0
        L8e:
            boolean r0 = hasOnProgressCallbacks(r13)     // Catch: java.lang.Throwable -> Lc8
            if (r0 == 0) goto Lcd
            com.facebook.ae r4 = new com.facebook.ae     // Catch: java.lang.Throwable -> Lc8
            android.os.Handler r0 = r13.getCallbackHandler()     // Catch: java.lang.Throwable -> Lc8
            r4.<init>(r0)     // Catch: java.lang.Throwable -> Lc8
            r1 = 0
            r0 = r13
            processRequest(r0, r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> Lc8
            int r0 = r4.a()     // Catch: java.lang.Throwable -> Lc8
            java.util.Map r9 = r4.b()     // Catch: java.lang.Throwable -> Lc8
            com.facebook.af r6 = new com.facebook.af     // Catch: java.lang.Throwable -> Lc8
            long r10 = (long) r0     // Catch: java.lang.Throwable -> Lc8
            r8 = r13
            r6.<init>(r7, r8, r9, r10)     // Catch: java.lang.Throwable -> Lc8
            r4 = r6
        Lb2:
            r0 = r13
            r1 = r12
            processRequest(r0, r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> Lca
            if (r4 == 0) goto Lbc
            r4.close()
        Lbc:
            r12.log()
            goto L74
        Lc0:
            r0 = move-exception
            r7 = r4
        Lc2:
            if (r7 == 0) goto Lc7
            r7.close()
        Lc7:
            throw r0
        Lc8:
            r0 = move-exception
            goto Lc2
        Lca:
            r0 = move-exception
            r7 = r4
            goto Lc2
        Lcd:
            r4 = r7
            goto Lb2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphRequest.serializeToUrlConnection(com.facebook.GraphRequestBatch, java.net.HttpURLConnection):void");
    }

    private static void processRequest(GraphRequestBatch graphRequestBatch, Logger logger, int i, URL url, OutputStream outputStream, boolean z) throws IOException, JSONException {
        c cVar = new c(outputStream, logger, z);
        if (i == 1) {
            GraphRequest graphRequest = graphRequestBatch.get(0);
            HashMap hashMap = new HashMap();
            for (String str : graphRequest.parameters.keySet()) {
                Object obj = graphRequest.parameters.get(str);
                if (isSupportedAttachmentType(obj)) {
                    hashMap.put(str, new a(graphRequest, obj));
                }
            }
            if (logger != null) {
                logger.append("  Parameters:\n");
            }
            serializeParameters(graphRequest.parameters, cVar, graphRequest);
            if (logger != null) {
                logger.append("  Attachments:\n");
            }
            serializeAttachments(hashMap, cVar);
            if (graphRequest.graphObject != null) {
                processGraphObject(graphRequest.graphObject, url.getPath(), cVar);
                return;
            }
            return;
        }
        String batchAppId = getBatchAppId(graphRequestBatch);
        if (Utility.isNullOrEmpty(batchAppId)) {
            throw new FacebookException("App ID was not specified at the request or Settings.");
        }
        cVar.a(BATCH_APP_ID_PARAM, batchAppId);
        HashMap hashMap2 = new HashMap();
        serializeRequestsAsJSON(cVar, graphRequestBatch, hashMap2);
        if (logger != null) {
            logger.append("  Attachments:\n");
        }
        serializeAttachments(hashMap2, cVar);
    }

    private static boolean isMeRequest(String str) {
        Matcher matcher = versionPattern.matcher(str);
        if (matcher.matches()) {
            str = matcher.group(1);
        }
        return str.startsWith("me/") || str.startsWith("/me/");
    }

    private static void processGraphObject(JSONObject jSONObject, String str, b bVar) throws IOException {
        boolean z;
        if (isMeRequest(str)) {
            int indexOf = str.indexOf(":");
            int indexOf2 = str.indexOf("?");
            z = indexOf > 3 && (indexOf2 == -1 || indexOf < indexOf2);
        } else {
            z = false;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            processGraphObjectProperty(next, jSONObject.opt(next), bVar, z && next.equalsIgnoreCase("image"));
        }
    }

    public static GraphRequest createOpenGraphObject(ShareOpenGraphObject shareOpenGraphObject) throws FacebookException {
        String string = shareOpenGraphObject.getString(DEBUG_MESSAGE_TYPE_KEY);
        String string2 = string == null ? shareOpenGraphObject.getString("og:type") : string;
        if (string2 == null) {
            throw new FacebookException("Open graph object type cannot be null");
        }
        try {
            JSONObject jSONObject = (JSONObject) OpenGraphJSONUtility.toJSONValue(shareOpenGraphObject, new w());
            Bundle bundle = new Bundle();
            bundle.putString("object", jSONObject.toString());
            return new GraphRequest(AccessToken.getCurrentAccessToken(), String.format(Locale.ROOT, GRAPH_PATH_FORMAT, ME, "objects/" + string2), bundle, HttpMethod.POST);
        } catch (JSONException e) {
            throw new FacebookException(e.getMessage());
        }
    }

    private static void processGraphObjectProperty(String str, Object obj, b bVar, boolean z) throws IOException {
        Class<?> cls = obj.getClass();
        if (JSONObject.class.isAssignableFrom(cls)) {
            JSONObject jSONObject = (JSONObject) obj;
            if (z) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    processGraphObjectProperty(String.format("%s[%s]", str, next), jSONObject.opt(next), bVar, z);
                }
                return;
            }
            if (jSONObject.has(ShareConstants.WEB_DIALOG_PARAM_ID)) {
                processGraphObjectProperty(str, jSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_ID), bVar, z);
                return;
            } else if (jSONObject.has("url")) {
                processGraphObjectProperty(str, jSONObject.optString("url"), bVar, z);
                return;
            } else {
                if (jSONObject.has(NativeProtocol.OPEN_GRAPH_CREATE_OBJECT_KEY)) {
                    processGraphObjectProperty(str, jSONObject.toString(), bVar, z);
                    return;
                }
                return;
            }
        }
        if (JSONArray.class.isAssignableFrom(cls)) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                processGraphObjectProperty(String.format(Locale.ROOT, "%s[%d]", str, Integer.valueOf(i)), jSONArray.opt(i), bVar, z);
            }
            return;
        }
        if (String.class.isAssignableFrom(cls) || Number.class.isAssignableFrom(cls) || Boolean.class.isAssignableFrom(cls)) {
            bVar.a(str, obj.toString());
        } else if (Date.class.isAssignableFrom(cls)) {
            bVar.a(str, new SimpleDateFormat(ISO_8601_FORMAT_STRING, Locale.US).format((Date) obj));
        }
    }

    private static void serializeParameters(Bundle bundle, c cVar, GraphRequest graphRequest) throws IOException {
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (isSupportedParameterType(obj)) {
                cVar.a(str, obj, graphRequest);
            }
        }
    }

    private static void serializeAttachments(Map<String, a> map, c cVar) throws IOException {
        for (String str : map.keySet()) {
            a aVar = map.get(str);
            if (isSupportedAttachmentType(aVar.b())) {
                cVar.a(str, aVar.b(), aVar.a());
            }
        }
    }

    private static void serializeRequestsAsJSON(c cVar, Collection<GraphRequest> collection, Map<String, a> map) throws JSONException, IOException {
        JSONArray jSONArray = new JSONArray();
        Iterator<GraphRequest> it = collection.iterator();
        while (it.hasNext()) {
            it.next().serializeToBatch(jSONArray, map);
        }
        cVar.a(BATCH_PARAM, jSONArray, collection);
    }

    private static String getMimeContentType() {
        return String.format("multipart/form-data; boundary=%s", MIME_BOUNDARY);
    }

    private static String getUserAgent() {
        if (userAgent == null) {
            userAgent = String.format("%s.%s", USER_AGENT_BASE, "4.7.0");
            String customUserAgent = InternalSettings.getCustomUserAgent();
            if (!Utility.isNullOrEmpty(customUserAgent)) {
                userAgent = String.format(Locale.ROOT, GRAPH_PATH_FORMAT, userAgent, customUserAgent);
            }
        }
        return userAgent;
    }

    private static String getBatchAppId(GraphRequestBatch graphRequestBatch) {
        String applicationId;
        if (!Utility.isNullOrEmpty(graphRequestBatch.getBatchApplicationId())) {
            return graphRequestBatch.getBatchApplicationId();
        }
        Iterator<GraphRequest> it = graphRequestBatch.iterator();
        while (it.hasNext()) {
            AccessToken accessToken = it.next().accessToken;
            if (accessToken != null && (applicationId = accessToken.getApplicationId()) != null) {
                return applicationId;
            }
        }
        if (!Utility.isNullOrEmpty(defaultBatchApplicationId)) {
            return defaultBatchApplicationId;
        }
        return FacebookSdk.getApplicationId();
    }

    private static boolean isSupportedAttachmentType(Object obj) {
        return (obj instanceof Bitmap) || (obj instanceof byte[]) || (obj instanceof Uri) || (obj instanceof ParcelFileDescriptor) || (obj instanceof ParcelableResourceWithMimeType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isSupportedParameterType(Object obj) {
        return (obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Number) || (obj instanceof Date);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String parameterToString(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if ((obj instanceof Boolean) || (obj instanceof Number)) {
            return obj.toString();
        }
        if (obj instanceof Date) {
            return new SimpleDateFormat(ISO_8601_FORMAT_STRING, Locale.US).format(obj);
        }
        throw new IllegalArgumentException("Unsupported parameter type.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c implements b {

        /* renamed from: a, reason: collision with root package name */
        private final OutputStream f236a;
        private final Logger b;
        private boolean c = true;
        private boolean d;

        public c(OutputStream outputStream, Logger logger, boolean z) {
            this.d = false;
            this.f236a = outputStream;
            this.b = logger;
            this.d = z;
        }

        public void a(String str, Object obj, GraphRequest graphRequest) throws IOException {
            if (this.f236a instanceof ah) {
                ((ah) this.f236a).a(graphRequest);
            }
            if (GraphRequest.isSupportedParameterType(obj)) {
                a(str, GraphRequest.parameterToString(obj));
                return;
            }
            if (obj instanceof Bitmap) {
                a(str, (Bitmap) obj);
                return;
            }
            if (obj instanceof byte[]) {
                a(str, (byte[]) obj);
                return;
            }
            if (obj instanceof Uri) {
                a(str, (Uri) obj, (String) null);
                return;
            }
            if (obj instanceof ParcelFileDescriptor) {
                a(str, (ParcelFileDescriptor) obj, (String) null);
                return;
            }
            if (obj instanceof ParcelableResourceWithMimeType) {
                ParcelableResourceWithMimeType parcelableResourceWithMimeType = (ParcelableResourceWithMimeType) obj;
                Parcelable resource = parcelableResourceWithMimeType.getResource();
                String mimeType = parcelableResourceWithMimeType.getMimeType();
                if (resource instanceof ParcelFileDescriptor) {
                    a(str, (ParcelFileDescriptor) resource, mimeType);
                    return;
                } else {
                    if (resource instanceof Uri) {
                        a(str, (Uri) resource, mimeType);
                        return;
                    }
                    throw b();
                }
            }
            throw b();
        }

        private RuntimeException b() {
            return new IllegalArgumentException("value is not a supported type.");
        }

        public void a(String str, JSONArray jSONArray, Collection<GraphRequest> collection) throws IOException, JSONException {
            if (!(this.f236a instanceof ah)) {
                a(str, jSONArray.toString());
                return;
            }
            ah ahVar = (ah) this.f236a;
            a(str, (String) null, (String) null);
            a("[", new Object[0]);
            int i = 0;
            for (GraphRequest graphRequest : collection) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                ahVar.a(graphRequest);
                if (i > 0) {
                    a(",%s", jSONObject.toString());
                } else {
                    a("%s", jSONObject.toString());
                }
                i++;
            }
            a("]", new Object[0]);
            if (this.b != null) {
                this.b.appendKeyValue("    " + str, jSONArray.toString());
            }
        }

        @Override // com.facebook.GraphRequest.b
        public void a(String str, String str2) throws IOException {
            a(str, (String) null, (String) null);
            b("%s", str2);
            a();
            if (this.b != null) {
                this.b.appendKeyValue("    " + str, str2);
            }
        }

        public void a(String str, Bitmap bitmap) throws IOException {
            a(str, str, "image/png");
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, this.f236a);
            b("", new Object[0]);
            a();
            if (this.b != null) {
                this.b.appendKeyValue("    " + str, "<Image>");
            }
        }

        public void a(String str, byte[] bArr) throws IOException {
            a(str, str, "content/unknown");
            this.f236a.write(bArr);
            b("", new Object[0]);
            a();
            if (this.b != null) {
                this.b.appendKeyValue("    " + str, String.format(Locale.ROOT, "<Data: %d>", Integer.valueOf(bArr.length)));
            }
        }

        public void a(String str, Uri uri, String str2) throws IOException {
            int copyAndCloseInputStream;
            if (str2 == null) {
                str2 = "content/unknown";
            }
            a(str, str, str2);
            InputStream openInputStream = FacebookSdk.getApplicationContext().getContentResolver().openInputStream(uri);
            if (this.f236a instanceof ae) {
                ((ae) this.f236a).a(Utility.getContentSize(uri));
                copyAndCloseInputStream = 0;
            } else {
                copyAndCloseInputStream = Utility.copyAndCloseInputStream(openInputStream, this.f236a) + 0;
            }
            b("", new Object[0]);
            a();
            if (this.b != null) {
                this.b.appendKeyValue("    " + str, String.format(Locale.ROOT, "<Data: %d>", Integer.valueOf(copyAndCloseInputStream)));
            }
        }

        public void a(String str, ParcelFileDescriptor parcelFileDescriptor, String str2) throws IOException {
            int copyAndCloseInputStream;
            if (str2 == null) {
                str2 = "content/unknown";
            }
            a(str, str, str2);
            if (this.f236a instanceof ae) {
                ((ae) this.f236a).a(parcelFileDescriptor.getStatSize());
                copyAndCloseInputStream = 0;
            } else {
                copyAndCloseInputStream = Utility.copyAndCloseInputStream(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor), this.f236a) + 0;
            }
            b("", new Object[0]);
            a();
            if (this.b != null) {
                this.b.appendKeyValue("    " + str, String.format(Locale.ROOT, "<Data: %d>", Integer.valueOf(copyAndCloseInputStream)));
            }
        }

        public void a() throws IOException {
            if (!this.d) {
                b("--%s", GraphRequest.MIME_BOUNDARY);
            } else {
                this.f236a.write("&".getBytes());
            }
        }

        public void a(String str, String str2, String str3) throws IOException {
            if (!this.d) {
                a("Content-Disposition: form-data; name=\"%s\"", str);
                if (str2 != null) {
                    a("; filename=\"%s\"", str2);
                }
                b("", new Object[0]);
                if (str3 != null) {
                    b("%s: %s", GraphRequest.CONTENT_TYPE_HEADER, str3);
                }
                b("", new Object[0]);
                return;
            }
            this.f236a.write(String.format("%s=", str).getBytes());
        }

        public void a(String str, Object... objArr) throws IOException {
            if (!this.d) {
                if (this.c) {
                    this.f236a.write("--".getBytes());
                    this.f236a.write(GraphRequest.MIME_BOUNDARY.getBytes());
                    this.f236a.write("\r\n".getBytes());
                    this.c = false;
                }
                this.f236a.write(String.format(str, objArr).getBytes());
                return;
            }
            this.f236a.write(URLEncoder.encode(String.format(Locale.US, str, objArr), Keyczar.DEFAULT_ENCODING).getBytes());
        }

        public void b(String str, Object... objArr) throws IOException {
            a(str, objArr);
            if (!this.d) {
                a("\r\n", new Object[0]);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class ParcelableResourceWithMimeType<RESOURCE extends Parcelable> implements Parcelable {
        public static final Parcelable.Creator<ParcelableResourceWithMimeType> CREATOR = new x();
        private final String mimeType;
        private final RESOURCE resource;

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ ParcelableResourceWithMimeType(Parcel parcel, p pVar) {
            this(parcel);
        }

        public String getMimeType() {
            return this.mimeType;
        }

        public RESOURCE getResource() {
            return this.resource;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.mimeType);
            parcel.writeParcelable(this.resource, i);
        }

        public ParcelableResourceWithMimeType(RESOURCE resource, String str) {
            this.mimeType = str;
            this.resource = resource;
        }

        private ParcelableResourceWithMimeType(Parcel parcel) {
            this.mimeType = parcel.readString();
            this.resource = (RESOURCE) parcel.readParcelable(FacebookSdk.getApplicationContext().getClassLoader());
        }
    }
}
