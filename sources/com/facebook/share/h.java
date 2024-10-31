package com.facebook.share;

import com.facebook.FacebookException;
import com.facebook.internal.CollectionMapper;
import com.facebook.internal.Mutable;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareApi.java */
/* loaded from: classes.dex */
public class h implements CollectionMapper.Collection<Integer> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ArrayList f343a;
    final /* synthetic */ JSONArray b;
    final /* synthetic */ ShareApi c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ShareApi shareApi, ArrayList arrayList, JSONArray jSONArray) {
        this.c = shareApi;
        this.f343a = arrayList;
        this.b = jSONArray;
    }

    @Override // com.facebook.internal.CollectionMapper.Collection
    public Iterator<Integer> keyIterator() {
        return new i(this, new Mutable(0), this.f343a.size());
    }

    @Override // com.facebook.internal.CollectionMapper.Collection
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Object get(Integer num) {
        return this.f343a.get(num.intValue());
    }

    @Override // com.facebook.internal.CollectionMapper.Collection
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void set(Integer num, Object obj, CollectionMapper.OnErrorListener onErrorListener) {
        try {
            this.b.put(num.intValue(), obj);
        } catch (JSONException e) {
            String localizedMessage = e.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = "Error staging object.";
            }
            onErrorListener.onError(new FacebookException(localizedMessage));
        }
    }
}
