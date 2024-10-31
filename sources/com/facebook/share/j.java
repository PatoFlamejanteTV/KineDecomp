package com.facebook.share;

import com.facebook.FacebookException;
import com.facebook.internal.CollectionMapper;
import com.facebook.internal.Mutable;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: ShareApi.java */
/* loaded from: classes.dex */
public class j implements CollectionMapper.Collection<Integer> {

    /* renamed from: a */
    final /* synthetic */ ArrayList f9604a;

    /* renamed from: b */
    final /* synthetic */ JSONArray f9605b;

    /* renamed from: c */
    final /* synthetic */ ShareApi f9606c;

    public j(ShareApi shareApi, ArrayList arrayList, JSONArray jSONArray) {
        this.f9606c = shareApi;
        this.f9604a = arrayList;
        this.f9605b = jSONArray;
    }

    @Override // com.facebook.internal.CollectionMapper.Collection
    /* renamed from: a */
    public Object get(Integer num) {
        return this.f9604a.get(num.intValue());
    }

    @Override // com.facebook.internal.CollectionMapper.Collection
    public Iterator<Integer> keyIterator() {
        return new i(this, new Mutable(0), this.f9604a.size());
    }

    @Override // com.facebook.internal.CollectionMapper.Collection
    /* renamed from: a */
    public void set(Integer num, Object obj, CollectionMapper.OnErrorListener onErrorListener) {
        try {
            this.f9605b.put(num.intValue(), obj);
        } catch (JSONException e2) {
            String localizedMessage = e2.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = "Error staging object.";
            }
            onErrorListener.onError(new FacebookException(localizedMessage));
        }
    }
}
