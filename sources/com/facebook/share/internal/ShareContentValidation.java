package com.facebook.share.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareMessengerActionButton;
import com.facebook.share.model.ShareMessengerGenericTemplateContent;
import com.facebook.share.model.ShareMessengerMediaTemplateContent;
import com.facebook.share.model.ShareMessengerOpenGraphMusicTemplateContent;
import com.facebook.share.model.ShareMessengerURLActionButton;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.ShareOpenGraphValueContainer;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class ShareContentValidation {
    private static c ApiValidator;
    private static c DefaultValidator;
    private static c StoryValidator;
    private static c WebShareValidator;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends c {
        private a() {
            super();
        }

        @Override // com.facebook.share.internal.ShareContentValidation.c
        public void a(SharePhoto sharePhoto) {
            ShareContentValidation.validatePhotoForApi(sharePhoto, this);
        }

        @Override // com.facebook.share.internal.ShareContentValidation.c
        public void a(ShareVideoContent shareVideoContent) {
            if (Utility.isNullOrEmpty(shareVideoContent.getPlaceId())) {
                if (Utility.isNullOrEmpty(shareVideoContent.getPeopleIds())) {
                    if (!Utility.isNullOrEmpty(shareVideoContent.getRef())) {
                        throw new FacebookException("Cannot share video content with referrer URL using the share api");
                    }
                    return;
                }
                throw new FacebookException("Cannot share video content with people IDs using the share api");
            }
            throw new FacebookException("Cannot share video content with place IDs using the share api");
        }

        @Override // com.facebook.share.internal.ShareContentValidation.c
        public void a(ShareMediaContent shareMediaContent) {
            throw new FacebookException("Cannot share ShareMediaContent using the share api");
        }

        @Override // com.facebook.share.internal.ShareContentValidation.c
        public void a(ShareLinkContent shareLinkContent) {
            if (!Utility.isNullOrEmpty(shareLinkContent.getQuote())) {
                throw new FacebookException("Cannot share link content with quote using the share api");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends c {
        private b() {
            super();
        }

        @Override // com.facebook.share.internal.ShareContentValidation.c
        public void a(ShareStoryContent shareStoryContent) {
            ShareContentValidation.validateStoryContent(shareStoryContent, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private boolean f9550a;

        private c() {
            this.f9550a = false;
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

        public void a(ShareMediaContent shareMediaContent) {
            ShareContentValidation.validateMediaContent(shareMediaContent, this);
        }

        public void a(ShareCameraEffectContent shareCameraEffectContent) {
            ShareContentValidation.validateCameraEffectContent(shareCameraEffectContent, this);
        }

        public void a(ShareOpenGraphContent shareOpenGraphContent) {
            this.f9550a = true;
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

        public void a(ShareMedia shareMedia) {
            ShareContentValidation.validateMedium(shareMedia, this);
        }

        public void a(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) {
            ShareContentValidation.validateMessengerOpenGraphMusicTemplate(shareMessengerOpenGraphMusicTemplateContent);
        }

        public void a(ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent) {
            ShareContentValidation.validateShareMessengerGenericTemplateContent(shareMessengerGenericTemplateContent);
        }

        public void a(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) {
            ShareContentValidation.validateShareMessengerMediaTemplateContent(shareMessengerMediaTemplateContent);
        }

        public void a(ShareStoryContent shareStoryContent) {
            ShareContentValidation.validateStoryContent(shareStoryContent, this);
        }

        public boolean a() {
            return this.f9550a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d extends c {
        private d() {
            super();
        }

        @Override // com.facebook.share.internal.ShareContentValidation.c
        public void a(ShareVideoContent shareVideoContent) {
            throw new FacebookException("Cannot share ShareVideoContent via web sharing dialogs");
        }

        @Override // com.facebook.share.internal.ShareContentValidation.c
        public void a(ShareMediaContent shareMediaContent) {
            throw new FacebookException("Cannot share ShareMediaContent via web sharing dialogs");
        }

        @Override // com.facebook.share.internal.ShareContentValidation.c
        public void a(SharePhoto sharePhoto) {
            ShareContentValidation.validatePhotoForWebDialog(sharePhoto, this);
        }
    }

    private static c getApiValidator() {
        if (ApiValidator == null) {
            ApiValidator = new a();
        }
        return ApiValidator;
    }

    private static c getDefaultValidator() {
        if (DefaultValidator == null) {
            DefaultValidator = new c();
        }
        return DefaultValidator;
    }

    private static c getStoryValidator() {
        if (StoryValidator == null) {
            StoryValidator = new b();
        }
        return StoryValidator;
    }

    private static c getWebShareValidator() {
        if (WebShareValidator == null) {
            WebShareValidator = new d();
        }
        return WebShareValidator;
    }

    private static void validate(ShareContent shareContent, c cVar) throws FacebookException {
        if (shareContent != null) {
            if (shareContent instanceof ShareLinkContent) {
                cVar.a((ShareLinkContent) shareContent);
                return;
            }
            if (shareContent instanceof SharePhotoContent) {
                cVar.a((SharePhotoContent) shareContent);
                return;
            }
            if (shareContent instanceof ShareVideoContent) {
                cVar.a((ShareVideoContent) shareContent);
                return;
            }
            if (shareContent instanceof ShareOpenGraphContent) {
                cVar.a((ShareOpenGraphContent) shareContent);
                return;
            }
            if (shareContent instanceof ShareMediaContent) {
                cVar.a((ShareMediaContent) shareContent);
                return;
            }
            if (shareContent instanceof ShareCameraEffectContent) {
                cVar.a((ShareCameraEffectContent) shareContent);
                return;
            }
            if (shareContent instanceof ShareMessengerOpenGraphMusicTemplateContent) {
                cVar.a((ShareMessengerOpenGraphMusicTemplateContent) shareContent);
                return;
            }
            if (shareContent instanceof ShareMessengerMediaTemplateContent) {
                cVar.a((ShareMessengerMediaTemplateContent) shareContent);
                return;
            } else if (shareContent instanceof ShareMessengerGenericTemplateContent) {
                cVar.a((ShareMessengerGenericTemplateContent) shareContent);
                return;
            } else {
                if (shareContent instanceof ShareStoryContent) {
                    cVar.a((ShareStoryContent) shareContent);
                    return;
                }
                return;
            }
        }
        throw new FacebookException("Must provide non-null content to share");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validateCameraEffectContent(ShareCameraEffectContent shareCameraEffectContent, c cVar) {
        if (Utility.isNullOrEmpty(shareCameraEffectContent.getEffectId())) {
            throw new FacebookException("Must specify a non-empty effectId");
        }
    }

    public static void validateForApiShare(ShareContent shareContent) {
        validate(shareContent, getApiValidator());
    }

    public static void validateForMessage(ShareContent shareContent) {
        validate(shareContent, getDefaultValidator());
    }

    public static void validateForNativeShare(ShareContent shareContent) {
        validate(shareContent, getDefaultValidator());
    }

    public static void validateForStoryShare(ShareContent shareContent) {
        validate(shareContent, getStoryValidator());
    }

    public static void validateForWebShare(ShareContent shareContent) {
        validate(shareContent, getWebShareValidator());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validateLinkContent(ShareLinkContent shareLinkContent, c cVar) {
        Uri imageUrl = shareLinkContent.getImageUrl();
        if (imageUrl != null && !Utility.isWebUri(imageUrl)) {
            throw new FacebookException("Image Url must be an http:// or https:// url");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validateMediaContent(ShareMediaContent shareMediaContent, c cVar) {
        List<ShareMedia> media = shareMediaContent.getMedia();
        if (media != null && !media.isEmpty()) {
            if (media.size() <= 6) {
                Iterator<ShareMedia> it = media.iterator();
                while (it.hasNext()) {
                    cVar.a(it.next());
                }
                return;
            }
            throw new FacebookException(String.format(Locale.ROOT, "Cannot add more than %d media.", 6));
        }
        throw new FacebookException("Must specify at least one medium in ShareMediaContent.");
    }

    public static void validateMedium(ShareMedia shareMedia, c cVar) {
        if (shareMedia instanceof SharePhoto) {
            cVar.a((SharePhoto) shareMedia);
        } else {
            if (shareMedia instanceof ShareVideo) {
                cVar.a((ShareVideo) shareMedia);
                return;
            }
            throw new FacebookException(String.format(Locale.ROOT, "Invalid media type: %s", shareMedia.getClass().getSimpleName()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validateMessengerOpenGraphMusicTemplate(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) {
        if (!Utility.isNullOrEmpty(shareMessengerOpenGraphMusicTemplateContent.getPageId())) {
            if (shareMessengerOpenGraphMusicTemplateContent.getUrl() != null) {
                validateShareMessengerActionButton(shareMessengerOpenGraphMusicTemplateContent.getButton());
                return;
            }
            throw new FacebookException("Must specify url for ShareMessengerOpenGraphMusicTemplateContent");
        }
        throw new FacebookException("Must specify Page Id for ShareMessengerOpenGraphMusicTemplateContent");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validateOpenGraphAction(ShareOpenGraphAction shareOpenGraphAction, c cVar) {
        if (shareOpenGraphAction != null) {
            if (!Utility.isNullOrEmpty(shareOpenGraphAction.getActionType())) {
                cVar.a(shareOpenGraphAction, false);
                return;
            }
            throw new FacebookException("ShareOpenGraphAction must have a non-empty actionType");
        }
        throw new FacebookException("Must specify a non-null ShareOpenGraphAction");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validateOpenGraphContent(ShareOpenGraphContent shareOpenGraphContent, c cVar) {
        cVar.a(shareOpenGraphContent.getAction());
        String previewPropertyName = shareOpenGraphContent.getPreviewPropertyName();
        if (!Utility.isNullOrEmpty(previewPropertyName)) {
            if (shareOpenGraphContent.getAction().get(previewPropertyName) != null) {
                return;
            }
            throw new FacebookException("Property \"" + previewPropertyName + "\" was not found on the action. The name of the preview property must match the name of an action property.");
        }
        throw new FacebookException("Must specify a previewPropertyName.");
    }

    private static void validateOpenGraphKey(String str, boolean z) {
        if (z) {
            String[] split = str.split(":");
            if (split.length >= 2) {
                for (String str2 : split) {
                    if (str2.isEmpty()) {
                        throw new FacebookException("Invalid key found in Open Graph dictionary: %s", str);
                    }
                }
                return;
            }
            throw new FacebookException("Open Graph keys must be namespaced: %s", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validateOpenGraphObject(ShareOpenGraphObject shareOpenGraphObject, c cVar) {
        if (shareOpenGraphObject != null) {
            cVar.a(shareOpenGraphObject, true);
            return;
        }
        throw new FacebookException("Cannot share a null ShareOpenGraphObject");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validateOpenGraphValueContainer(ShareOpenGraphValueContainer shareOpenGraphValueContainer, c cVar, boolean z) {
        for (String str : shareOpenGraphValueContainer.keySet()) {
            validateOpenGraphKey(str, z);
            Object obj = shareOpenGraphValueContainer.get(str);
            if (obj instanceof List) {
                for (Object obj2 : (List) obj) {
                    if (obj2 != null) {
                        validateOpenGraphValueContainerObject(obj2, cVar);
                    } else {
                        throw new FacebookException("Cannot put null objects in Lists in ShareOpenGraphObjects and ShareOpenGraphActions");
                    }
                }
            } else {
                validateOpenGraphValueContainerObject(obj, cVar);
            }
        }
    }

    private static void validateOpenGraphValueContainerObject(Object obj, c cVar) {
        if (obj instanceof ShareOpenGraphObject) {
            cVar.a((ShareOpenGraphObject) obj);
        } else if (obj instanceof SharePhoto) {
            cVar.a((SharePhoto) obj);
        }
    }

    private static void validatePhoto(SharePhoto sharePhoto) {
        if (sharePhoto != null) {
            Bitmap bitmap = sharePhoto.getBitmap();
            Uri imageUrl = sharePhoto.getImageUrl();
            if (bitmap == null && imageUrl == null) {
                throw new FacebookException("SharePhoto does not have a Bitmap or ImageUrl specified");
            }
            return;
        }
        throw new FacebookException("Cannot share a null SharePhoto");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validatePhotoContent(SharePhotoContent sharePhotoContent, c cVar) {
        List<SharePhoto> photos = sharePhotoContent.getPhotos();
        if (photos != null && !photos.isEmpty()) {
            if (photos.size() <= 6) {
                Iterator<SharePhoto> it = photos.iterator();
                while (it.hasNext()) {
                    cVar.a(it.next());
                }
                return;
            }
            throw new FacebookException(String.format(Locale.ROOT, "Cannot add more than %d photos.", 6));
        }
        throw new FacebookException("Must specify at least one Photo in SharePhotoContent.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validatePhotoForApi(SharePhoto sharePhoto, c cVar) {
        validatePhoto(sharePhoto);
        Bitmap bitmap = sharePhoto.getBitmap();
        Uri imageUrl = sharePhoto.getImageUrl();
        if (bitmap == null && Utility.isWebUri(imageUrl) && !cVar.a()) {
            throw new FacebookException("Cannot set the ImageUrl of a SharePhoto to the Uri of an image on the web when sharing SharePhotoContent");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validatePhotoForNativeDialog(SharePhoto sharePhoto, c cVar) {
        validatePhotoForApi(sharePhoto, cVar);
        if (sharePhoto.getBitmap() == null && Utility.isWebUri(sharePhoto.getImageUrl())) {
            return;
        }
        Validate.hasContentProvider(FacebookSdk.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validatePhotoForWebDialog(SharePhoto sharePhoto, c cVar) {
        validatePhoto(sharePhoto);
    }

    private static void validateShareMessengerActionButton(ShareMessengerActionButton shareMessengerActionButton) {
        if (shareMessengerActionButton == null) {
            return;
        }
        if (!Utility.isNullOrEmpty(shareMessengerActionButton.getTitle())) {
            if (shareMessengerActionButton instanceof ShareMessengerURLActionButton) {
                validateShareMessengerURLActionButton((ShareMessengerURLActionButton) shareMessengerActionButton);
                return;
            }
            return;
        }
        throw new FacebookException("Must specify title for ShareMessengerActionButton");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validateShareMessengerGenericTemplateContent(ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent) {
        if (!Utility.isNullOrEmpty(shareMessengerGenericTemplateContent.getPageId())) {
            if (shareMessengerGenericTemplateContent.getGenericTemplateElement() != null) {
                if (!Utility.isNullOrEmpty(shareMessengerGenericTemplateContent.getGenericTemplateElement().getTitle())) {
                    validateShareMessengerActionButton(shareMessengerGenericTemplateContent.getGenericTemplateElement().getButton());
                    return;
                }
                throw new FacebookException("Must specify title for ShareMessengerGenericTemplateElement");
            }
            throw new FacebookException("Must specify element for ShareMessengerGenericTemplateContent");
        }
        throw new FacebookException("Must specify Page Id for ShareMessengerGenericTemplateContent");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validateShareMessengerMediaTemplateContent(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) {
        if (!Utility.isNullOrEmpty(shareMessengerMediaTemplateContent.getPageId())) {
            if (shareMessengerMediaTemplateContent.getMediaUrl() == null && Utility.isNullOrEmpty(shareMessengerMediaTemplateContent.getAttachmentId())) {
                throw new FacebookException("Must specify either attachmentId or mediaURL for ShareMessengerMediaTemplateContent");
            }
            validateShareMessengerActionButton(shareMessengerMediaTemplateContent.getButton());
            return;
        }
        throw new FacebookException("Must specify Page Id for ShareMessengerMediaTemplateContent");
    }

    private static void validateShareMessengerURLActionButton(ShareMessengerURLActionButton shareMessengerURLActionButton) {
        if (shareMessengerURLActionButton.getUrl() == null) {
            throw new FacebookException("Must specify url for ShareMessengerURLActionButton");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validateStoryContent(ShareStoryContent shareStoryContent, c cVar) {
        if (shareStoryContent != null && (shareStoryContent.getBackgroundAsset() != null || shareStoryContent.getStickerAsset() != null)) {
            if (shareStoryContent.getBackgroundAsset() != null) {
                cVar.a(shareStoryContent.getBackgroundAsset());
            }
            if (shareStoryContent.getStickerAsset() != null) {
                cVar.a(shareStoryContent.getStickerAsset());
                return;
            }
            return;
        }
        throw new FacebookException("Must pass the Facebook app a background asset, a sticker asset, or both");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validateVideo(ShareVideo shareVideo, c cVar) {
        if (shareVideo != null) {
            Uri localUrl = shareVideo.getLocalUrl();
            if (localUrl != null) {
                if (!Utility.isContentUri(localUrl) && !Utility.isFileUri(localUrl)) {
                    throw new FacebookException("ShareVideo must reference a video that is on the device");
                }
                return;
            }
            throw new FacebookException("ShareVideo does not have a LocalUrl specified");
        }
        throw new FacebookException("Cannot share a null ShareVideo");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validateVideoContent(ShareVideoContent shareVideoContent, c cVar) {
        cVar.a(shareVideoContent.getVideo());
        SharePhoto previewPhoto = shareVideoContent.getPreviewPhoto();
        if (previewPhoto != null) {
            cVar.a(previewPhoto);
        }
    }
}
