package com.facebook.share;

import com.facebook.FacebookException;
import com.facebook.internal.CollectionMapper;
import com.facebook.share.model.ShareOpenGraphObject;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareApi.java */
/* loaded from: classes.dex */
public class n implements CollectionMapper.Collection<String> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ShareOpenGraphObject f9613a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ JSONObject f9614b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ShareApi f9615c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ShareApi shareApi, ShareOpenGraphObject shareOpenGraphObject, JSONObject jSONObject) {
        this.f9615c = shareApi;
        this.f9613a = shareOpenGraphObject;
        this.f9614b = jSONObject;
    }

    @Override // com.facebook.internal.CollectionMapper.Collection
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Object get(String str) {
        return this.f9613a.get(str);
    }

    @Override // com.facebook.internal.CollectionMapper.Collection
    public Iterator<String> keyIterator() {
        return this.f9613a.keySet().iterator();
    }

    @Override // com.facebook.internal.CollectionMapper.Collection
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void set(String str, Object obj, CollectionMapper.OnErrorListener onErrorListener) {
        try {
            this.f9614b.put(str, obj);
        } catch (JSONException e2) {
            String localizedMessage = e2.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = "Error staging object.";
            }
            onErrorListener.onError(new FacebookException(localizedMessage));
        }
    }
}
