package com.nexstreaming.kinemaster.mediastore.v2;

import java.util.Arrays;

/* loaded from: classes.dex */
public class QueryParams {

    /* renamed from: a, reason: collision with root package name */
    private MediaItemType[] f3555a;
    private SortBy b;
    private SortOrder c;
    private MSID d;

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
            this.d = queryParams.d;
            this.b = queryParams.b;
            this.c = queryParams.c;
            this.f3555a = (MediaItemType[]) Arrays.copyOf(queryParams.f3555a, queryParams.f3555a.length);
        }
    }

    public QueryParams() {
        this.f3555a = new MediaItemType[0];
        this.b = SortBy.DATE;
        this.c = SortOrder.DESC;
    }

    public QueryParams(MediaItemType... mediaItemTypeArr) {
        this.f3555a = mediaItemTypeArr;
        this.b = SortBy.DATE;
        this.c = SortOrder.DESC;
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(this.b));
        sb.append(';');
        sb.append(String.valueOf(this.c));
        sb.append(';');
        for (MediaItemType mediaItemType : this.f3555a) {
            sb.append('[');
            sb.append(String.valueOf(mediaItemType));
            sb.append(']');
        }
        sb.append(';');
        sb.append(';');
        sb.append(String.valueOf(this.d));
        return sb.toString();
    }

    public MediaItemType[] b() {
        return this.f3555a;
    }

    public SortBy c() {
        return this.b;
    }

    public SortOrder d() {
        return this.c;
    }

    public void a(MSID msid) {
        this.d = msid;
    }

    public MSID e() {
        return this.d;
    }

    public boolean a(MediaItemType mediaItemType) {
        for (MediaItemType mediaItemType2 : this.f3555a) {
            if (mediaItemType2 == mediaItemType) {
                return true;
            }
        }
        return false;
    }
}
