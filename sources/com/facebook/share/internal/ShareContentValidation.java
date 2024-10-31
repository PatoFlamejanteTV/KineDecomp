package com.facebook.share.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.ShareOpenGraphValueContainer;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class ShareContentValidation {
    private static b ApiValidator;
    private static b DefaultValidator;
    private static b WebShareValidator;

    public static void validateForMessage(ShareContent shareContent) {
        validate(shareContent, getDefaultValidator());
    }

    public static void validateForNativeShare(ShareContent shareContent) {
        validate(shareContent, getDefaultValidator());
    }

    public static void validateForWebShare(ShareContent shareContent) {
        validate(shareContent, getWebShareValidator());
    }

    public static void validateForApiShare(ShareContent shareContent) {
        validate(shareContent, getApiValidator());
    }

    private static b getDefaultValidator() {
        if (DefaultValidator == null) {
            DefaultValidator = new b();
        }
        return DefaultValidator;
    }

    private static b getApiValidator() {
        if (ApiValidator == null) {
            ApiValidator = new a();
        }
        return ApiValidator;
    }

    private static b getWebShareValidator() {
        if (WebShareValidator == null) {
            WebShareValidator = new c();
        }
        return WebShareValidator;
    }

    private static void validate(ShareContent shareContent, b bVar) throws FacebookException {
        if (shareContent == null) {
            throw new FacebookException("Must provide non-null content to share");
        }
        if (shareContent instanceof ShareLinkContent) {
            bVar.a((ShareLinkContent) shareContent);
            return;
        }
        if (shareContent instanceof SharePhotoContent) {
            bVar.a((SharePhotoContent) shareContent);
        } else if (shareContent instanceof ShareVideoContent) {
            bVar.a((ShareVideoContent) shareContent);
        } else if (shareContent instanceof ShareOpenGraphContent) {
            bVar.a((ShareOpenGraphContent) shareContent);
        }
    }

    public static void validateLinkContent(ShareLinkContent shareLinkContent, b bVar) {
        Uri imageUrl = shareLinkContent.getImageUrl();
        if (imageUrl != null && !Utility.isWebUri(imageUrl)) {
            throw new FacebookException("Image Url must be an http:// or https:// url");
        }
    }

    public static void validatePhotoContent(SharePhotoContent sharePhotoContent, b bVar) {
        List<SharePhoto> photos = sharePhotoContent.getPhotos();
        if (photos == null || photos.isEmpty()) {
            throw new FacebookException("Must specify at least one Photo in SharePhotoContent.");
        }
        if (photos.size() > 6) {
            throw new FacebookException(String.format(Locale.ROOT, "Cannot add more than %d photos.", 6));
        }
        Iterator<SharePhoto> it = photos.iterator();
        while (it.hasNext()) {
            bVar.a(it.next());
        }
    }

    public static void validatePhotoForApi(SharePhoto sharePhoto, b bVar) {
        if (sharePhoto == null) {
            throw new FacebookException("Cannot share a null SharePhoto");
        }
        Bitmap bitmap = sharePhoto.getBitmap();
        Uri imageUrl = sharePhoto.getImageUrl();
        if (bitmap == null) {
            if (imageUrl == null) {
                throw new FacebookException("SharePhoto does not have a Bitmap or ImageUrl specified");
            }
            if (Utility.isWebUri(imageUrl) && !bVar.a()) {
                throw new FacebookException("Cannot set the ImageUrl of a SharePhoto to the Uri of an image on the web when sharing SharePhotoContent");
            }
        }
    }

    public static void validatePhotoForNativeDialog(SharePhoto sharePhoto, b bVar) {
        validatePhotoForApi(sharePhoto, bVar);
        if (sharePhoto.getBitmap() != null || !Utility.isWebUri(sharePhoto.getImageUrl())) {
            Validate.hasContentProvider(FacebookSdk.getApplicationContext());
        }
    }

    public static void validatePhotoForWebDialog(SharePhoto sharePhoto, b bVar) {
        if (sharePhoto == null) {
            throw new FacebookException("Cannot share a null SharePhoto");
        }
        Uri imageUrl = sharePhoto.getImageUrl();
        if (imageUrl == null || !Utility.isWebUri(imageUrl)) {
            throw new FacebookException("SharePhoto must have a non-null imageUrl set to the Uri of an image on the web");
        }
    }

    public static void validateVideoContent(ShareVideoContent shareVideoContent, b bVar) {
        bVar.a(shareVideoContent.getVideo());
        SharePhoto previewPhoto = shareVideoContent.getPreviewPhoto();
        if (previewPhoto != null) {
            bVar.a(previewPhoto);
        }
    }

    public static void validateVideo(ShareVideo shareVideo, b bVar) {
        if (shareVideo == null) {
            throw new FacebookException("Cannot share a null ShareVideo");
        }
        Uri localUrl = shareVideo.getLocalUrl();
        if (localUrl == null) {
            throw new FacebookException("ShareVideo does not have a LocalUrl specified");
        }
        if (!Utility.isContentUri(localUrl) && !Utility.isFileUri(localUrl)) {
            throw new FacebookException("ShareVideo must reference a video that is on the device");
        }
    }

    public static void validateOpenGraphContent(ShareOpenGraphContent shareOpenGraphContent, b bVar) {
        bVar.a(shareOpenGraphContent.getAction());
        String previewPropertyName = shareOpenGraphContent.getPreviewPropertyName();
        if (Utility.isNullOrEmpty(previewPropertyName)) {
            throw new FacebookException("Must specify a previewPropertyName.");
        }
        if (shareOpenGraphContent.getAction().get(previewPropertyName) == null) {
            throw new FacebookException("Property \"" + previewPropertyName + "\" was not found on the action. The name of the preview property must match the name of an action property.");
        }
    }

    public static void validateOpenGraphAction(ShareOpenGraphAction shareOpenGraphAction, b bVar) {
        if (shareOpenGraphAction == null) {
            throw new FacebookException("Must specify a non-null ShareOpenGraphAction");
        }
        if (Utility.isNullOrEmpty(shareOpenGraphAction.getActionType())) {
            throw new FacebookException("ShareOpenGraphAction must have a non-empty actionType");
        }
        bVar.a(shareOpenGraphAction, false);
    }

    public static void validateOpenGraphObject(ShareOpenGraphObject shareOpenGraphObject, b bVar) {
        if (shareOpenGraphObject == null) {
            throw new FacebookException("Cannot share a null ShareOpenGraphObject");
        }
        bVar.a(shareOpenGraphObject, true);
    }

    public static void validateOpenGraphValueContainer(ShareOpenGraphValueContainer shareOpenGraphValueContainer, b bVar, boolean z) {
        for (String str : shareOpenGraphValueContainer.keySet()) {
            validateOpenGraphKey(str, z);
            Object obj = shareOpenGraphValueContainer.get(str);
            if (obj instanceof List) {
                for (Object obj2 : (List) obj) {
                    if (obj2 == null) {
                        throw new FacebookException("Cannot put null objects in Lists in ShareOpenGraphObjects and ShareOpenGraphActions");
                    }
                    validateOpenGraphValueContainerObject(obj2, bVar);
                }
            } else {
                validateOpenGraphValueContainerObject(obj, bVar);
            }
        }
    }

    private static void validateOpenGraphKey(String str, boolean z) {
        if (z) {
            String[] split = str.split(":");
            if (split.length < 2) {
                throw new FacebookException("Open Graph keys must be namespaced: %s", str);
            }
            for (String str2 : split) {
                if (str2.isEmpty()) {
                    throw new FacebookException("Invalid key found in Open Graph dictionary: %s", str);
                }
            }
        }
    }

    private static void validateOpenGraphValueContainerObject(Object obj, b bVar) {
        if (obj instanceof ShareOpenGraphObject) {
            bVar.a((ShareOpenGraphObject) obj);
        } else if (obj instanceof SharePhoto) {
            bVar.a((SharePhoto) obj);
        }
    }

    /* loaded from: classes.dex */
    public static class c extends b {
        private c() {
            super();
        }

        /* synthetic */ c(v vVar) {
            this();
        }

        @Override // com.facebook.share.internal.ShareContentValidation.b
        public void a(SharePhotoContent sharePhotoContent) {
            throw new FacebookException("Cannot share SharePhotoContent via web sharing dialogs");
        }

        @Override // com.facebook.share.internal.ShareContentValidation.b
        public void a(ShareVideoContent shareVideoContent) {
            throw new FacebookException("Cannot share ShareVideoContent via web sharing dialogs");
        }

        @Override // com.facebook.share.internal.ShareContentValidation.b
        public void a(SharePhoto sharePhoto) {
            ShareContentValidation.validatePhotoForWebDialog(sharePhoto, this);
        }
    }

    /* loaded from: classes.dex */
    public static class a extends b {
        private a() {
            super();
        }

        /* synthetic */ a(v vVar) {
            this();
        }

        @Override // com.facebook.share.internal.ShareContentValidation.b
        public void a(SharePhoto sharePhoto) {
            ShareContentValidation.validatePhotoForApi(sharePhoto, this);
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a */
        private boolean f351a;

        private b() {
            this.f351a = false;
        }

        /* synthetic */ b(v vVar) {
            this();
        }

        public void a(ShareLinkContent shareLinkContent) {
            ShareContentValidation.validateLinkContent(shareLinkContent, this);
        }

        public void a(SharePhotoContent sharePhotoContent) {
            ShareContentValidation.validatePhotoContent(sharePhotoContent, this);
        }

        public void a(ShareVideoContent shareVideoContent) {
            ShareContentValidation.validateVideoContent(shareVideoContent, this);
        }

        public void a(ShareOpenGraphContent shareOpenGraphContent) {
            this.f351a = true;
            ShareContentValidation.validateOpenGraphContent(shareOpenGraphContent, this);
        }

        public void a(ShareOpenGraphAction shareOpenGraphAction) {
            ShareContentValidation.validateOpenGraphAction(shareOpenGraphAction, this);
        }

        public void a(ShareOpenGraphObject shareOpenGraphObject) {
            ShareContentValidation.validateOpenGraphObject(shareOpenGraphObject, this);
        }

        public void a(ShareOpenGraphValueContainer shareOpenGraphValueContainer, boolean z) {
            ShareContentValidation.validateOpenGraphValueContainer(shareOpenGraphValueContainer, this, z);
        }

        public void a(SharePhoto sharePhoto) {
            ShareContentValidation.validatePhotoForNativeDialog(sharePhoto, this);
        }

        public void a(ShareVideo shareVideo) {
            ShareContentValidation.validateVideo(shareVideo, this);
        }

        public boolean a() {
            return this.f351a;
        }
    }
}
