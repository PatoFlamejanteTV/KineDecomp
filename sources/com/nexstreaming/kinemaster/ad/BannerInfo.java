package com.nexstreaming.kinemaster.ad;

/* loaded from: classes.dex */
public class BannerInfo {
    public static final int LOTTIE = 2;
    public static final int NORMAL = 0;
    public static final int SPRITE = 1;
    private int columns;
    private int count;
    private int delay;
    private int duration;
    private String hashCode;
    private int height;
    private String id;
    private int repeat;
    private int rows;
    private int type;
    private String url;
    private int width;

    BannerInfo() {
    }

    public int getColumns() {
        return this.columns;
    }

    public int getCount() {
        return this.count;
    }

    public int getDelay() {
        return this.delay;
    }

    public int getDuration() {
        return this.duration;
    }

    public String getHashCode() {
        return this.hashCode;
    }

    public int getHeight() {
        return this.height;
    }

    public String getId() {
        return this.id;
    }

    public int getRepeat() {
        return this.repeat;
    }

    public int getRows() {
        return this.rows;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public int getWidth() {
        return this.width;
    }

    public String toString() {
        return "{ type: " + this.type + ", width: " + this.width + ", height: " + this.height + ", columns: " + this.columns + ", rows: " + this.rows + ", duration: " + this.duration + ", delay: " + this.delay + ", repeat: " + this.repeat + ", url: " + this.url + ", hashCode: " + this.hashCode + " }";
    }
}
