package com.facebook.share;

import com.facebook.internal.CollectionMapper;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.SharePhoto;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareApi.java */
/* loaded from: classes.dex */
public class k implements CollectionMapper.ValueMapper {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ShareApi f382a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ShareApi shareApi) {
        this.f382a = shareApi;
    }

    @Override // com.facebook.internal.CollectionMapper.ValueMapper
    public void mapValue(Object obj, CollectionMapper.OnMapValueCompleteListener onMapValueCompleteListener) {
        if (obj instanceof ArrayList) {
            this.f382a.stageArrayList((ArrayList) obj, onMapValueCompleteListener);
            return;
        }
        if (obj instanceof ShareOpenGraphObject) {
            this.f382a.stageOpenGraphObject((ShareOpenGraphObject) obj, onMapValueCompleteListener);
        } else if (obj instanceof SharePhoto) {
            this.f382a.stagePhoto((SharePhoto) obj, onMapValueCompleteListener);
        } else {
            onMapValueCompleteListener.onComplete(obj);
        }
    }
}
