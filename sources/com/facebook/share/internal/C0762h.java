package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.internal.PlatformServiceClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LikeActionController.java */
/* renamed from: com.facebook.share.internal.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0762h implements PlatformServiceClient.CompletedListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LikeActionController f9572a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0762h(LikeActionController likeActionController) {
        this.f9572a = likeActionController;
    }

    @Override // com.facebook.internal.PlatformServiceClient.CompletedListener
    public void completed(Bundle bundle) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        if (bundle == null || !bundle.containsKey(ShareConstants.EXTRA_OBJECT_IS_LIKED)) {
            return;
        }
        boolean z = bundle.getBoolean(ShareConstants.EXTRA_OBJECT_IS_LIKED);
        if (!bundle.containsKey(ShareConstants.EXTRA_LIKE_COUNT_STRING_WITH_LIKE)) {
            str = this.f9572a.likeCountStringWithLike;
        } else {
            str = bundle.getString(ShareConstants.EXTRA_LIKE_COUNT_STRING_WITH_LIKE);
        }
        String str6 = str;
        if (!bundle.containsKey(ShareConstants.EXTRA_LIKE_COUNT_STRING_WITHOUT_LIKE)) {
            str2 = this.f9572a.likeCountStringWithoutLike;
        } else {
            str2 = bundle.getString(ShareConstants.EXTRA_LIKE_COUNT_STRING_WITHOUT_LIKE);
        }
        String str7 = str2;
        if (!bundle.containsKey(ShareConstants.EXTRA_SOCIAL_SENTENCE_WITH_LIKE)) {
            str3 = this.f9572a.socialSentenceWithLike;
        } else {
            str3 = bundle.getString(ShareConstants.EXTRA_SOCIAL_SENTENCE_WITH_LIKE);
        }
        String str8 = str3;
        if (!bundle.containsKey(ShareConstants.EXTRA_SOCIAL_SENTENCE_WITHOUT_LIKE)) {
            str4 = this.f9572a.socialSentenceWithoutLike;
        } else {
            str4 = bundle.getString(ShareConstants.EXTRA_SOCIAL_SENTENCE_WITHOUT_LIKE);
        }
        String str9 = str4;
        if (!bundle.containsKey(ShareConstants.EXTRA_UNLIKE_TOKEN)) {
            str5 = this.f9572a.unlikeToken;
        } else {
            str5 = bundle.getString(ShareConstants.EXTRA_UNLIKE_TOKEN);
        }
        this.f9572a.updateState(z, str6, str7, str8, str9, str5);
    }
}
