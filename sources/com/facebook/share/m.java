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
public class m implements CollectionMapper.Collection<String> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ShareOpenGraphObject f384a;
    final /* synthetic */ JSONObject b;
    final /* synthetic */ ShareApi c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ShareApi shareApi, ShareOpenGraphObject shareOpenGraphObject, JSONObject jSONObject) {
        this.c = shareApi;
        this.f384a = shareOpenGraphObject;
        this.b = jSONObject;
    }

    @Override // com.facebook.internal.CollectionMapper.Collection
    public Iterator<String> keyIterator() {
        return this.f384a.keySet().iterator();
    }

    @Override // com.facebook.internal.CollectionMapper.Collection
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Object get(String str) {
        return this.f384a.get(str);
    }

    @Override // com.facebook.internal.CollectionMapper.Collection
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void set(String str, Object obj, CollectionMapper.OnErrorListener onErrorListener) {
        try {
            this.b.put(str, obj);
        } catch (JSONException e) {
            String localizedMessage = e.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = "Error staging object.";
            }
            onErrorListener.onError(new FacebookException(localizedMessage));
        }
    }
}
