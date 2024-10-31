package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.internal.PlatformServiceClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LikeActionController.java */
/* loaded from: classes.dex */
public class b implements PlatformServiceClient.CompletedListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LikeActionController f361a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(LikeActionController likeActionController) {
        this.f361a = likeActionController;
    }

    @Override // com.facebook.internal.PlatformServiceClient.CompletedListener
    public void completed(Bundle bundle) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        if (bundle != null && bundle.containsKey(ShareConstants.EXTRA_OBJECT_IS_LIKED)) {
            boolean z = bundle.getBoolean(ShareConstants.EXTRA_OBJECT_IS_LIKED);
            if (!bundle.containsKey(ShareConstants.EXTRA_LIKE_COUNT_STRING_WITH_LIKE)) {
                str = this.f361a.likeCountStringWithLike;
            } else {
                str = bundle.getString(ShareConstants.EXTRA_LIKE_COUNT_STRING_WITH_LIKE);
            }
            if (!bundle.containsKey(ShareConstants.EXTRA_LIKE_COUNT_STRING_WITHOUT_LIKE)) {
                str2 = this.f361a.likeCountStringWithoutLike;
            } else {
                str2 = bundle.getString(ShareConstants.EXTRA_LIKE_COUNT_STRING_WITHOUT_LIKE);
            }
            if (!bundle.containsKey(ShareConstants.EXTRA_SOCIAL_SENTENCE_WITH_LIKE)) {
                str3 = this.f361a.socialSentenceWithLike;
            } else {
                str3 = bundle.getString(ShareConstants.EXTRA_SOCIAL_SENTENCE_WITH_LIKE);
            }
            if (!bundle.containsKey(ShareConstants.EXTRA_SOCIAL_SENTENCE_WITHOUT_LIKE)) {
                str4 = this.f361a.socialSentenceWithoutLike;
            } else {
                str4 = bundle.getString(ShareConstants.EXTRA_SOCIAL_SENTENCE_WITHOUT_LIKE);
            }
            if (!bundle.containsKey(ShareConstants.EXTRA_UNLIKE_TOKEN)) {
                str5 = this.f361a.unlikeToken;
            } else {
                str5 = bundle.getString(ShareConstants.EXTRA_UNLIKE_TOKEN);
            }
            this.f361a.updateState(z, str, str2, str3, str4, str5);
        }
    }
}
