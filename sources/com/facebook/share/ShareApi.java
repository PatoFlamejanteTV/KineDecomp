package com.facebook.share;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.internal.CollectionMapper;
import com.facebook.internal.Mutable;
import com.facebook.internal.Utility;
import com.facebook.places.model.PlaceFields;
import com.facebook.share.Sharer;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.internal.ShareContentValidation;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.internal.VideoUploader;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class ShareApi {
    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final String DEFAULT_GRAPH_NODE = "me";
    private static final String GRAPH_PATH_FORMAT = "%s/%s";
    private static final String PHOTOS_EDGE = "photos";
    private static final String TAG = "ShareApi";
    private String graphNode = DEFAULT_GRAPH_NODE;
    private String message;
    private final ShareContent shareContent;

    public ShareApi(ShareContent shareContent) {
        this.shareContent = shareContent;
    }

    private void addCommonParameters(Bundle bundle, ShareContent shareContent) {
        List<String> peopleIds = shareContent.getPeopleIds();
        if (!Utility.isNullOrEmpty(peopleIds)) {
            bundle.putString("tags", TextUtils.join(", ", peopleIds));
        }
        if (!Utility.isNullOrEmpty(shareContent.getPlaceId())) {
            bundle.putString("place", shareContent.getPlaceId());
        }
        if (!Utility.isNullOrEmpty(shareContent.getPageId())) {
            bundle.putString(PlaceFields.PAGE, shareContent.getPageId());
        }
        if (Utility.isNullOrEmpty(shareContent.getRef())) {
            return;
        }
        bundle.putString("ref", shareContent.getRef());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getGraphPath(String str) {
        try {
            return String.format(Locale.ROOT, GRAPH_PATH_FORMAT, URLEncoder.encode(getGraphNode(), "UTF-8"), str);
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    private Bundle getSharePhotoCommonParameters(SharePhoto sharePhoto, SharePhotoContent sharePhotoContent) throws JSONException {
        Bundle parameters = sharePhoto.getParameters();
        if (!parameters.containsKey("place") && !Utility.isNullOrEmpty(sharePhotoContent.getPlaceId())) {
            parameters.putString("place", sharePhotoContent.getPlaceId());
        }
        if (!parameters.containsKey("tags") && !Utility.isNullOrEmpty(sharePhotoContent.getPeopleIds())) {
            List<String> peopleIds = sharePhotoContent.getPeopleIds();
            if (!Utility.isNullOrEmpty(peopleIds)) {
                JSONArray jSONArray = new JSONArray();
                for (String str : peopleIds) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("tag_uid", str);
                    jSONArray.put(jSONObject);
                }
                parameters.putString("tags", jSONArray.toString());
            }
        }
        if (!parameters.containsKey("ref") && !Utility.isNullOrEmpty(sharePhotoContent.getRef())) {
            parameters.putString("ref", sharePhotoContent.getRef());
        }
        return parameters;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleImagesOnAction(Bundle bundle) {
        String string = bundle.getString(MessengerShareContentUtility.MEDIA_IMAGE);
        if (string != null) {
            try {
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            putImageInBundleWithArrayFormat(bundle, i, optJSONObject);
                        } else {
                            bundle.putString(String.format(Locale.ROOT, "image[%d][url]", Integer.valueOf(i)), jSONArray.getString(i));
                        }
                    }
                    bundle.remove(MessengerShareContentUtility.MEDIA_IMAGE);
                } catch (JSONException unused) {
                    putImageInBundleWithArrayFormat(bundle, 0, new JSONObject(string));
                    bundle.remove(MessengerShareContentUtility.MEDIA_IMAGE);
                }
            } catch (JSONException unused2) {
            }
        }
    }

    private static void putImageInBundleWithArrayFormat(Bundle bundle, int i, JSONObject jSONObject) throws JSONException {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            bundle.putString(String.format(Locale.ROOT, "image[%d][%s]", Integer.valueOf(i), next), jSONObject.get(next).toString());
        }
    }

    public static void share(ShareContent shareContent, FacebookCallback<Sharer.Result> facebookCallback) {
        new ShareApi(shareContent).share(facebookCallback);
    }

    private void shareLinkContent(ShareLinkContent shareLinkContent, FacebookCallback<Sharer.Result> facebookCallback) {
        h hVar = new h(this, facebookCallback);
        Bundle bundle = new Bundle();
        addCommonParameters(bundle, shareLinkContent);
        bundle.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, getMessage());
        bundle.putString("link", Utility.getUriString(shareLinkContent.getContentUrl()));
        bundle.putString("picture", Utility.getUriString(shareLinkContent.getImageUrl()));
        bundle.putString("name", shareLinkContent.getContentTitle());
        bundle.putString("description", shareLinkContent.getContentDescription());
        bundle.putString("ref", shareLinkContent.getRef());
        new GraphRequest(AccessToken.getCurrentAccessToken(), getGraphPath("feed"), bundle, HttpMethod.POST, hVar).executeAsync();
    }

    private void shareOpenGraphContent(ShareOpenGraphContent shareOpenGraphContent, FacebookCallback<Sharer.Result> facebookCallback) {
        e eVar = new e(this, facebookCallback);
        ShareOpenGraphAction action = shareOpenGraphContent.getAction();
        Bundle bundle = action.getBundle();
        addCommonParameters(bundle, shareOpenGraphContent);
        if (!Utility.isNullOrEmpty(getMessage())) {
            bundle.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, getMessage());
        }
        stageOpenGraphAction(bundle, new f(this, bundle, action, eVar, facebookCallback));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v9, types: [T, java.lang.Integer] */
    private void sharePhotoContent(SharePhotoContent sharePhotoContent, FacebookCallback<Sharer.Result> facebookCallback) {
        ArrayList arrayList;
        Mutable mutable = new Mutable(0);
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        ArrayList arrayList2 = new ArrayList();
        g gVar = new g(this, new ArrayList(), new ArrayList(), mutable, facebookCallback);
        try {
            for (SharePhoto sharePhoto : sharePhotoContent.getPhotos()) {
                try {
                    Bundle sharePhotoCommonParameters = getSharePhotoCommonParameters(sharePhoto, sharePhotoContent);
                    Bitmap bitmap = sharePhoto.getBitmap();
                    Uri imageUrl = sharePhoto.getImageUrl();
                    String caption = sharePhoto.getCaption();
                    if (caption == null) {
                        caption = getMessage();
                    }
                    String str = caption;
                    if (bitmap != null) {
                        arrayList = arrayList2;
                        arrayList.add(GraphRequest.newUploadPhotoRequest(currentAccessToken, getGraphPath("photos"), bitmap, str, sharePhotoCommonParameters, gVar));
                    } else {
                        arrayList = arrayList2;
                        if (imageUrl != null) {
                            arrayList.add(GraphRequest.newUploadPhotoRequest(currentAccessToken, getGraphPath("photos"), imageUrl, str, sharePhotoCommonParameters, gVar));
                        }
                    }
                    arrayList2 = arrayList;
                } catch (JSONException e2) {
                    ShareInternalUtility.invokeCallbackWithException(facebookCallback, e2);
                    return;
                }
            }
            ArrayList arrayList3 = arrayList2;
            mutable.value = Integer.valueOf(((Integer) mutable.value).intValue() + arrayList3.size());
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                ((GraphRequest) it.next()).executeAsync();
            }
        } catch (FileNotFoundException e3) {
            ShareInternalUtility.invokeCallbackWithException(facebookCallback, e3);
        }
    }

    private void shareVideoContent(ShareVideoContent shareVideoContent, FacebookCallback<Sharer.Result> facebookCallback) {
        try {
            VideoUploader.uploadAsync(shareVideoContent, getGraphNode(), facebookCallback);
        } catch (FileNotFoundException e2) {
            ShareInternalUtility.invokeCallbackWithException(facebookCallback, e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stageArrayList(ArrayList arrayList, CollectionMapper.OnMapValueCompleteListener onMapValueCompleteListener) {
        JSONArray jSONArray = new JSONArray();
        stageCollectionValues(new j(this, arrayList, jSONArray), new k(this, onMapValueCompleteListener, jSONArray));
    }

    private <T> void stageCollectionValues(CollectionMapper.Collection<T> collection, CollectionMapper.OnMapperCompleteListener onMapperCompleteListener) {
        CollectionMapper.iterate(collection, new l(this), onMapperCompleteListener);
    }

    private void stageOpenGraphAction(Bundle bundle, CollectionMapper.OnMapperCompleteListener onMapperCompleteListener) {
        stageCollectionValues(new m(this, bundle), onMapperCompleteListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stageOpenGraphObject(ShareOpenGraphObject shareOpenGraphObject, CollectionMapper.OnMapValueCompleteListener onMapValueCompleteListener) {
        String string = shareOpenGraphObject.getString("type");
        if (string == null) {
            string = shareOpenGraphObject.getString("og:type");
        }
        String str = string;
        if (str == null) {
            onMapValueCompleteListener.onError(new FacebookException("Open Graph objects must contain a type value."));
        } else {
            JSONObject jSONObject = new JSONObject();
            stageCollectionValues(new n(this, shareOpenGraphObject, jSONObject), new c(this, jSONObject, str, new b(this, onMapValueCompleteListener), onMapValueCompleteListener));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stagePhoto(SharePhoto sharePhoto, CollectionMapper.OnMapValueCompleteListener onMapValueCompleteListener) {
        Bitmap bitmap = sharePhoto.getBitmap();
        Uri imageUrl = sharePhoto.getImageUrl();
        if (bitmap == null && imageUrl == null) {
            onMapValueCompleteListener.onError(new FacebookException("Photos must have an imageURL or bitmap."));
            return;
        }
        d dVar = new d(this, onMapValueCompleteListener, sharePhoto);
        if (bitmap != null) {
            ShareInternalUtility.newUploadStagingResourceWithImageRequest(AccessToken.getCurrentAccessToken(), bitmap, dVar).executeAsync();
            return;
        }
        try {
            ShareInternalUtility.newUploadStagingResourceWithImageRequest(AccessToken.getCurrentAccessToken(), imageUrl, dVar).executeAsync();
        } catch (FileNotFoundException e2) {
            String localizedMessage = e2.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = "Error staging photo.";
            }
            onMapValueCompleteListener.onError(new FacebookException(localizedMessage));
        }
    }

    public boolean canShare() {
        if (getShareContent() == null) {
            return false;
        }
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if (!AccessToken.isCurrentAccessTokenActive()) {
            return false;
        }
        Set<String> permissions = currentAccessToken.getPermissions();
        if (permissions != null && permissions.contains("publish_actions")) {
            return true;
        }
        Log.w(TAG, "The publish_actions permissions are missing, the share will fail unless this app was authorized to publish in another installation.");
        return true;
    }

    public String getGraphNode() {
        return this.graphNode;
    }

    public String getMessage() {
        return this.message;
    }

    public ShareContent getShareContent() {
        return this.shareContent;
    }

    public void setGraphNode(String str) {
        this.graphNode = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void share(FacebookCallback<Sharer.Result> facebookCallback) {
        if (!canShare()) {
            ShareInternalUtility.invokeCallbackWithError(facebookCallback, "Insufficient permissions for sharing content via Api.");
            return;
        }
        ShareContent shareContent = getShareContent();
        try {
            ShareContentValidation.validateForApiShare(shareContent);
            if (shareContent instanceof ShareLinkContent) {
                shareLinkContent((ShareLinkContent) shareContent, facebookCallback);
                return;
            }
            if (shareContent instanceof SharePhotoContent) {
                sharePhotoContent((SharePhotoContent) shareContent, facebookCallback);
            } else if (shareContent instanceof ShareVideoContent) {
                shareVideoContent((ShareVideoContent) shareContent, facebookCallback);
            } else if (shareContent instanceof ShareOpenGraphContent) {
                shareOpenGraphContent((ShareOpenGraphContent) shareContent, facebookCallback);
            }
        } catch (FacebookException e2) {
            ShareInternalUtility.invokeCallbackWithException(facebookCallback, e2);
        }
    }
}
