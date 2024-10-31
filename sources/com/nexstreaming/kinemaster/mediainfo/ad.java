package com.nexstreaming.kinemaster.mediainfo;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import com.nexstreaming.app.general.util.FileType;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexvideoeditor.NexEditor;
import com.nextreaming.nexvideoeditor.NexVisualClipChecker;
import java.io.File;
import java.io.IOException;

/* compiled from: MediaInfoDialog.java */
/* loaded from: classes.dex */
public class ad {
    public static void a(Context context, String str, MediaStoreItem mediaStoreItem) {
        if (str == null && mediaStoreItem == null) {
            a(context, (File) null);
            return;
        }
        if ((mediaStoreItem != null) & (str == null)) {
            a(context, mediaStoreItem);
            return;
        }
        if ((mediaStoreItem == null) & (str != null)) {
            a(context, new File(str));
        } else {
            a(context, new File(str));
        }
    }

    public static String a(File file) {
        NexVisualClipChecker d;
        MediaStoreItem.MediaSupportType mediaSupportType;
        ExifInterface exifInterface;
        StringBuilder sb = new StringBuilder();
        if (file == null) {
            sb.append("Null Path");
        } else {
            sb.append("Name: ");
            sb.append(file.getName());
            sb.append('\n');
            sb.append("Path: ");
            sb.append(file.getAbsolutePath());
            sb.append('\n');
            if (!file.exists()) {
                sb.append("(File does not exist)\n");
            } else {
                FileType fromFile = FileType.fromFile(file);
                if (fromFile != null && fromFile.isImage()) {
                    sb.append("Type: IMAGE (").append(fromFile.name()).append(")\n");
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(file.getAbsolutePath(), options);
                    sb.append("Size: ");
                    sb.append(options.outWidth);
                    sb.append('x');
                    sb.append(options.outHeight);
                    sb.append('\n');
                    sb.append("MIME: ");
                    sb.append(options.outMimeType == null ? "?" : options.outMimeType);
                    sb.append('\n');
                    try {
                        exifInterface = new ExifInterface(file.getAbsolutePath());
                    } catch (IOException e) {
                        exifInterface = null;
                    }
                    if (exifInterface != null) {
                        sb.append("EXIF: \n");
                        for (String str : new String[]{"FNumber", "DateTime", "ExposureTime", "Flash", "FocalLength", "GPSAltitude", "GPSAltitudeRef", "GPSDateStamp", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "GPSProcessingMethod", "GPSTimeStamp", "ImageLength", "ImageWidth", "ISOSpeedRatings", "Make", "Model", "Orientation", "WhiteBalance"}) {
                            String attribute = exifInterface.getAttribute(str);
                            if (attribute != null) {
                                sb.append("   ");
                                sb.append(str);
                                sb.append('=');
                                sb.append(attribute);
                                sb.append('\n');
                            }
                        }
                    }
                } else if (fromFile != null && fromFile.isAudio()) {
                    sb.append("Type: AUDIO (").append(fromFile.name()).append(")\n");
                    MediaInfo a2 = MediaInfo.a(file);
                    if (a2 == null) {
                        sb.append("(Media info not available)\n");
                    } else {
                        sb.append("File size: ");
                        sb.append(a2.i());
                        sb.append('\n');
                        sb.append("Duration: ");
                        sb.append(a2.y());
                        sb.append('\n');
                        sb.append("Audio Duration: ");
                        sb.append(a2.z());
                        sb.append('\n');
                        sb.append("Has audio: ");
                        sb.append(a2.r() ? "yes" : "no");
                        sb.append('\n');
                        sb.append("Has video: ");
                        sb.append(a2.s() ? "yes" : "no");
                        sb.append('\n');
                        sb.append("Excluded: ");
                        sb.append(a2.o() ? "yes" : "no");
                        sb.append('\n');
                        CodecType K = a2.K();
                        sb.append("Audio Codec: ");
                        sb.append(K == null ? "?" : K.f3481a);
                        sb.append('\n');
                    }
                } else if (fromFile != null && fromFile.isVideo()) {
                    sb.append("Type: VIDEO (").append(fromFile.name()).append(")\n");
                    MediaInfo a3 = MediaInfo.a(file);
                    if (a3 == null) {
                        sb.append("(Media info not available)\n");
                    } else {
                        sb.append("File size: ");
                        sb.append(a3.i());
                        sb.append('\n');
                        sb.append("Duration: ");
                        sb.append(a3.y());
                        sb.append('\n');
                        sb.append("Audio Duration: ");
                        sb.append(a3.z());
                        sb.append('\n');
                        sb.append("Video Duration: ");
                        sb.append(a3.A());
                        sb.append('\n');
                        sb.append("FPS: ");
                        sb.append(a3.B());
                        sb.append('\n');
                        sb.append("Seek point count: ");
                        sb.append(a3.j());
                        sb.append('\n');
                        sb.append("H264 Level: ");
                        sb.append(a3.E());
                        sb.append('\n');
                        sb.append("H264 Profile: ");
                        sb.append(a3.D());
                        sb.append('\n');
                        sb.append("Size: ");
                        sb.append(a3.u());
                        sb.append('x');
                        sb.append(a3.v());
                        sb.append('\n');
                        sb.append("Has audio: ");
                        sb.append(a3.r() ? "yes" : "no");
                        sb.append('\n');
                        sb.append("Has video: ");
                        sb.append(a3.s() ? "yes" : "no");
                        sb.append('\n');
                        sb.append("Excluded: ");
                        sb.append(a3.o() ? "yes" : "no");
                        sb.append('\n');
                        sb.append("Support Type: " + a3.n() + "\n");
                        CodecType K2 = a3.K();
                        sb.append("Audio Codec: ");
                        sb.append(K2 == null ? "?" : K2.f3481a);
                        sb.append('\n');
                        CodecType J = a3.J();
                        sb.append("Video Codec: ");
                        sb.append(J == null ? "?" : J.f3481a);
                        sb.append('\n');
                        NexEditor a4 = EditorGlobal.a();
                        if (a4 != null && (d = a4.d()) != null) {
                            int a5 = d.a(a3.D(), a3.E(), a3.u(), a3.v(), a3.B(), a3.F(), a3.H(), a3.I());
                            switch (a5) {
                                case 0:
                                    mediaSupportType = MediaStoreItem.MediaSupportType.Supported;
                                    break;
                                case 1:
                                    mediaSupportType = MediaStoreItem.MediaSupportType.NeedTranscodeRes;
                                    break;
                                case 2:
                                    mediaSupportType = MediaStoreItem.MediaSupportType.NeedTranscodeFPS;
                                    break;
                                case 3:
                                    mediaSupportType = MediaStoreItem.MediaSupportType.NotSupported_VideoProfile;
                                    break;
                                case 4:
                                    mediaSupportType = MediaStoreItem.MediaSupportType.NotSupported_ResolutionTooHigh;
                                    break;
                                default:
                                    mediaSupportType = MediaStoreItem.MediaSupportType.Unknown;
                                    break;
                            }
                            sb.append("VCC Support Type: " + mediaSupportType.name() + " (" + a5 + ")\n");
                        }
                    }
                } else if (fromFile != null) {
                    sb.append("Type: UNKNOWN (" + fromFile.name() + ")\n");
                } else {
                    sb.append("Type: UNKNOWN\n");
                }
            }
        }
        return sb.toString();
    }

    public static void a(Context context, File file) {
        String a2 = a(file);
        TextView textView = new TextView(context);
        textView.setText(a2);
        textView.setTextIsSelectable(true);
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setScrollBarStyle(16777216);
        new AlertDialog.Builder(context).setView(textView).setTitle("Diagnostic Information").setCancelable(true).setPositiveButton("OK", new af()).setNeutralButton("Copy to Clipboard", new ae(context, a2)).show();
    }

    public static void a(Context context, MediaStoreItem mediaStoreItem) {
        TextView textView = new TextView(context);
        StringBuilder sb = new StringBuilder();
        if (mediaStoreItem != null) {
            sb.append("Name: ");
            sb.append(mediaStoreItem.a(context));
            sb.append('\n');
            sb.append("File size: ");
            sb.append(mediaStoreItem.i());
            sb.append('\n');
            sb.append("Date: ");
            sb.append(mediaStoreItem.f());
            sb.append('\n');
        }
        String sb2 = sb.toString();
        textView.setText(sb2);
        textView.setTextIsSelectable(true);
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setScrollBarStyle(16777216);
        new AlertDialog.Builder(context).setView(textView).setTitle("Diagnostic Information").setCancelable(true).setPositiveButton("OK", new ah()).setNeutralButton("Copy to Clipboard", new ag(context, sb2)).show();
    }
}
