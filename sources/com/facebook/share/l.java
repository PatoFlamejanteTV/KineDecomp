package com.facebook.share;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.CollectionMapper;
import com.facebook.internal.Utility;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareApi.java */
/* loaded from: classes.dex */
public class l implements CollectionMapper.Collection<String> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bundle f383a;
    final /* synthetic */ ShareApi b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ShareApi shareApi, Bundle bundle) {
        this.b = shareApi;
        this.f383a = bundle;
    }

    @Override // com.facebook.internal.CollectionMapper.Collection
    public Iterator<String> keyIterator() {
        return this.f383a.keySet().iterator();
    }

    @Override // com.facebook.internal.CollectionMapper.Collection
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Object get(String str) {
        return this.f383a.get(str);
    }

    @Override // com.facebook.internal.CollectionMapper.Collection
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void set(String str, Object obj, CollectionMapper.OnErrorListener onErrorListener) {
        if (!Utility.putJSONValueInBundle(this.f383a, str, obj)) {
            onErrorListener.onError(new FacebookException("Unexpected value: " + obj.toString()));
        }
    }
}
