package com.nexstreaming.kinemaster.mediastore;

import com.nexstreaming.kinemaster.mediastore.item.MediaItemType;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;
import java.util.Arrays;

/* loaded from: classes.dex */
public class QueryParams {

    /* renamed from: a */
    private MediaItemType[] f20872a;

    /* renamed from: b */
    private SortBy f20873b;

    /* renamed from: c */
    private SortOrder f20874c;

    /* renamed from: d */
    private MediaStoreItemId f20875d;

    /* loaded from: classes.dex */
    public enum SortBy {
        DATE,
        SIZE,
        DISPLAY_NAME
    }

    /* loaded from: classes.dex */
    public enum SortOrder {
        ASC,
        DESC
    }

    public QueryParams(QueryParams queryParams) {
        this();
        if (queryParams != null) {
            this.f20875d = queryParams.f20875d;
            this.f20873b = queryParams.f20873b;
            this.f20874c = queryParams.f20874c;
            MediaItemType[] mediaItemTypeArr = queryParams.f20872a;
            this.f20872a = (MediaItemType[]) Arrays.copyOf(mediaItemTypeArr, mediaItemTypeArr.length);
        }
    }

    public void a(MediaStoreItemId mediaStoreItemId) {
        this.f20875d = mediaStoreItemId;
    }

    public MediaItemType[] b() {
        return this.f20872a;
    }

    public SortBy c() {
        return this.f20873b;
    }

    public SortOrder d() {
        return this.f20874c;
    }

    public MediaStoreItemId a() {
        return this.f20875d;
    }

    public boolean a(MediaItemType mediaItemType) {
        for (MediaItemType mediaItemType2 : this.f20872a) {
            if (mediaItemType2 == mediaItemType) {
                return true;
            }
        }
        return false;
    }

    public QueryParams() {
        this.f20872a = new MediaItemType[0];
        this.f20873b = SortBy.DATE;
        this.f20874c = SortOrder.DESC;
    }

    public QueryParams(MediaItemType... mediaItemTypeArr) {
        this.f20872a = mediaItemTypeArr;
        this.f20873b = SortBy.DATE;
        this.f20874c = SortOrder.DESC;
    }
}
