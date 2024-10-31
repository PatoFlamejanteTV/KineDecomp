package com.nexstreaming.app.general.tracelog;

import java.util.Locale;

/* loaded from: classes2.dex */
public class NotifyAppResponse {
    public Notice[] notices;
    public int result;

    /* loaded from: classes2.dex */
    public static class Notice {
        public int idx;
        public String notice;
        public String type;

        public NoticeType getType() {
            String trim = this.type.toLowerCase(Locale.US).trim();
            if (trim.equalsIgnoreCase("txt")) {
                return NoticeType.Text;
            }
            if (trim.equalsIgnoreCase("html")) {
                return NoticeType.HTML;
            }
            if (trim.equalsIgnoreCase("url")) {
                return NoticeType.URL;
            }
            return NoticeType.Unknown;
        }
    }

    /* loaded from: classes2.dex */
    public enum NoticeType {
        Text,
        HTML,
        URL,
        Unknown
    }
}
