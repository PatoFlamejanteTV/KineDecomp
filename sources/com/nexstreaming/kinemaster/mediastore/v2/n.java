package com.nexstreaming.kinemaster.mediastore.v2;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.AsyncTask;
import android.util.Log;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.v2.RemoteMediaInfo;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RemoteMediaInfo.java */
/* loaded from: classes.dex */
public final class n extends AsyncTask<Void, Void, Task.TaskError> {

    /* renamed from: a, reason: collision with root package name */
    RemoteMediaInfo f3567a;
    boolean b = false;
    final /* synthetic */ String c;
    final /* synthetic */ Map d;
    final /* synthetic */ ResultTask e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(String str, Map map, ResultTask resultTask) {
        this.c = str;
        this.d = map;
        this.e = resultTask;
    }

    boolean a(ByteBuffer byteBuffer) {
        if (byteBuffer.limit() > 7) {
            if (byteBuffer.get(0) == 0 && byteBuffer.get(1) == 0 && byteBuffer.get(2) == 0 && byteBuffer.get(3) == 1 && (byteBuffer.get(4) & 31) == 7) {
                this.f3567a.d = byteBuffer.get(5);
                this.f3567a.e = byteBuffer.get(7);
                this.b = true;
                return true;
            }
            if (byteBuffer.get(0) == 0 && byteBuffer.get(1) == 0 && byteBuffer.get(2) == 1 && (byteBuffer.get(3) & 31) == 7) {
                this.f3567a.d = byteBuffer.get(4);
                this.f3567a.e = byteBuffer.get(6);
                this.b = true;
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Task.TaskError doInBackground(Void... voidArr) {
        RemoteMediaInfo.ErrorCode errorCode;
        Field field;
        Object obj;
        String name;
        String valueOf;
        this.f3567a = new RemoteMediaInfo();
        RemoteMediaInfo.ErrorCode errorCode2 = null;
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            Log.i("RemoteMediaInfo", "[MediaExtractor] setting data - IN : " + String.valueOf(this.c));
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            concurrentHashMap.putAll(this.d);
            mediaExtractor.setDataSource(this.c, concurrentHashMap);
            Log.i("RemoteMediaInfo", "[MediaExtractor] setting data - OUT");
            Log.i("RemoteMediaInfo", "getRemoteMediaInfo : trackCount=" + mediaExtractor.getTrackCount());
            if (mediaExtractor.getTrackCount() >= 1) {
                this.f3567a.d = -1;
                this.f3567a.e = -1;
                this.b = false;
                int i = 0;
                while (i < mediaExtractor.getTrackCount()) {
                    try {
                        MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
                        String string = trackFormat.getString("mime");
                        Log.i("RemoteMediaInfo", "getRemoteMediaInfo : track=" + i + " mime=" + string);
                        mediaExtractor.selectTrack(i);
                        if (string.startsWith("video/")) {
                            String[] strArr = {"csd-0", "raw-codec-specific-data"};
                            int length = strArr.length;
                            int i2 = 0;
                            while (true) {
                                if (i2 >= length) {
                                    break;
                                }
                                ByteBuffer byteBuffer = trackFormat.getByteBuffer(strArr[i2]);
                                if (byteBuffer == null || !a(byteBuffer)) {
                                    i2++;
                                } else {
                                    Log.i("RemoteMediaInfo", "getRemoteMediaInfo : found known field : " + strArr);
                                    break;
                                }
                            }
                            if (!this.b) {
                                Log.i("RemoteMediaInfo", "getRemoteMediaInfo : no known field found");
                                try {
                                    field = trackFormat.getClass().getDeclaredField("mMap");
                                } catch (NoSuchFieldException e) {
                                    Log.i("RemoteMediaInfo", "getRemoteMediaInfo : field error", e);
                                    field = null;
                                }
                                if (field != null) {
                                    field.setAccessible(true);
                                    try {
                                        obj = field.get(trackFormat);
                                    } catch (IllegalAccessException e2) {
                                        Log.i("RemoteMediaInfo", "getRemoteMediaInfo : access error", e2);
                                        obj = null;
                                    } catch (IllegalArgumentException e3) {
                                        Log.i("RemoteMediaInfo", "getRemoteMediaInfo : argument error", e3);
                                        obj = null;
                                    }
                                    if (obj != null && (obj instanceof Map)) {
                                        Map map = (Map) obj;
                                        StringBuilder sb = new StringBuilder();
                                        Log.i("RemoteMediaInfo", "getRemoteMediaInfo : got map (size=" + map.size() + ")");
                                        for (Map.Entry entry : map.entrySet()) {
                                            String valueOf2 = String.valueOf(entry.getKey());
                                            Object value = entry.getValue();
                                            if (value == null) {
                                                name = "Null";
                                            } else {
                                                name = value.getClass().getName();
                                            }
                                            if (value instanceof ByteBuffer) {
                                                ByteBuffer byteBuffer2 = (ByteBuffer) value;
                                                sb.setLength(0);
                                                int limit = byteBuffer2.limit();
                                                int min = Math.min(limit, 32);
                                                sb.append('[');
                                                sb.append(' ');
                                                for (int i3 = 0; i3 < min; i3++) {
                                                    byte b = byteBuffer2.get(i3);
                                                    sb.append(Character.forDigit((b >> 4) & 15, 16));
                                                    sb.append(Character.forDigit(b & 15, 16));
                                                    sb.append(' ');
                                                }
                                                if (min < limit) {
                                                    sb.append("...");
                                                }
                                                sb.append(']');
                                                valueOf = sb.toString();
                                            } else {
                                                valueOf = String.valueOf(value);
                                            }
                                            Log.i("RemoteMediaInfo", "getRemoteMediaInfo :        " + valueOf2 + "=(" + name + ")" + valueOf);
                                        }
                                        Iterator it = map.entrySet().iterator();
                                        while (true) {
                                            if (!it.hasNext()) {
                                                break;
                                            }
                                            Map.Entry entry2 = (Map.Entry) it.next();
                                            String valueOf3 = String.valueOf(entry2.getKey());
                                            Object value2 = entry2.getValue();
                                            if (value2 instanceof ByteBuffer) {
                                                ByteBuffer byteBuffer3 = (ByteBuffer) value2;
                                                Log.i("RemoteMediaInfo", "getRemoteMediaInfo : found bytebuffer : " + valueOf3 + " (limit=" + byteBuffer3.limit() + ")");
                                                if (a(byteBuffer3)) {
                                                    Log.i("RemoteMediaInfo", "getRemoteMediaInfo : found valid unknown bytebuffer");
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            long sampleTime = mediaExtractor.getSampleTime();
                            mediaExtractor.advance();
                            int i4 = 0;
                            long j = 0;
                            while (i4 < 10) {
                                long sampleTime2 = mediaExtractor.getSampleTime();
                                mediaExtractor.advance();
                                i4++;
                                j = (sampleTime2 - sampleTime) + j;
                                sampleTime = sampleTime2;
                            }
                            this.f3567a.b = trackFormat.getInteger("width");
                            this.f3567a.c = trackFormat.getInteger("height");
                            this.f3567a.f = trackFormat.getLong("durationUs") / 1000;
                            this.f3567a.f3556a = (int) (1000000.0d / (j / 10.0d));
                            this.f3567a.g = trackFormat.getString("mime");
                            errorCode = errorCode2;
                        } else if (string.startsWith("audio/")) {
                            this.f3567a.h = trackFormat.getString("mime");
                            errorCode = errorCode2;
                        } else {
                            errorCode = RemoteMediaInfo.ErrorCode.BAD_MIME_TYPE;
                        }
                        i++;
                        errorCode2 = errorCode;
                    } catch (Exception e4) {
                        Log.i("RemoteMediaInfo", "[MediaExtractor] error getTrackFormat", e4);
                        return ResultTask.makeTaskError(e4);
                    }
                }
                return errorCode2;
            }
            return RemoteMediaInfo.ErrorCode.NO_TRACKS;
        } catch (Exception e5) {
            Log.i("RemoteMediaInfo", "[MediaExtractor] error setting data source", e5);
            return ResultTask.makeTaskError(e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Task.TaskError taskError) {
        if (taskError != null) {
            this.e.sendFailure(taskError);
        } else {
            this.e.sendResult(this.f3567a);
        }
        super.onPostExecute(taskError);
    }
}
