package com.qq.e.ads.contentad;

import android.view.View;
import java.util.List;

/* loaded from: classes3.dex */
public interface ContentData extends ContentAdData {
    ContentType getContentType();

    String getElapseTime();

    String getFrom();

    List<String> getImages();

    String getLabel();

    int getPlayCount();

    long getPostTime();

    long getPv();

    int getRuntime();

    String getTitle();

    int getcommentNum();

    boolean isBigPic();

    void onClick(View view);

    void onExpouse(View view);
}
