package com.nexstreaming.kinemaster.mediainfo;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import com.nexstreaming.app.general.util.FileType;
import com.nexstreaming.kinemaster.mediastore.MediaSupportType;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexvideoeditor.NexEditor;
import com.nextreaming.nexvideoeditor.NexVisualClipChecker;
import java.io.File;
import java.io.IOException;

/* compiled from: MediaInfoDialog.java */
/* loaded from: classes.dex */
public class J {
    public static void a(Context context, String str, com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        if (str == null && cVar == null) {
            a(context, (File) null);
            return;
        }
        if ((str == null) && (cVar != null)) {
            a(context, cVar);
            return;
        }
        if ((str != null) & (cVar == null)) {
            a(context, new File(str));
        } else {
            a(context, new File(str));
        }
    }

    public static String a(File file) {
        NexVisualClipChecker i;
        MediaSupportType mediaSupportType;
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
                    sb.append("Type: IMAGE (");
                    sb.append(fromFile.name());
                    sb.append(")\n");
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(file.getAbsolutePath(), options);
                    sb.append("Size: ");
                    sb.append(options.outWidth);
                    sb.append('x');
                    sb.append(options.outHeight);
                    sb.append('\n');
                    sb.append("MIME: ");
                    String str = options.outMimeType;
                    if (str == null) {
                        str = "?";
                    }
                    sb.append(str);
                    sb.append('\n');
                    try {
                        exifInterface = new ExifInterface(file.getAbsolutePath());
                    } catch (IOException unused) {
                        exifInterface = null;
                    }
                    if (exifInterface != null) {
                        sb.append("EXIF: \n");
                        for (String str2 : new String[]{"FNumber", "DateTime", "ExposureTime", "Flash", "FocalLength", "GPSAltitude", "GPSAltitudeRef", "GPSDateStamp", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "GPSProcessingMethod", "GPSTimeStamp", "ImageLength", "ImageWidth", "ISOSpeedRatings", "Make", "Model", "Orientation", "WhiteBalance"}) {
                            String attribute = exifInterface.getAttribute(str2);
                            if (attribute != null) {
                                sb.append("   ");
                                sb.append(str2);
                                sb.append('=');
                                sb.append(attribute);
                                sb.append('\n');
                            }
                        }
                    }
                } else {
                    if (fromFile != null && fromFile.isAudio()) {
                        sb.append("Type: AUDIO (");
                        sb.append(fromFile.name());
                        sb.append(")\n");
                        MediaInfo a2 = MediaInfo.a(file);
                        if (a2 == null) {
                            sb.append("(Media info not available)\n");
                        } else {
                            sb.append("File size: ");
                            sb.append(a2.u());
                            sb.append('\n');
                            sb.append("Duration: ");
                            sb.append(a2.r());
                            sb.append('\n');
                            sb.append("Audio Duration: ");
                            sb.append(a2.o());
                            sb.append('\n');
                            sb.append("Has audio: ");
                            sb.append(a2.S() ? "yes" : "no");
                            sb.append('\n');
                            sb.append("Has video: ");
                            sb.append(a2.U() ? "yes" : "no");
                            sb.append('\n');
                            sb.append("Excluded: ");
                            sb.append(a2.W() ? "yes" : "no");
                            sb.append('\n');
                            CodecType n = a2.n();
                            sb.append("Audio Codec: ");
                            sb.append(n != null ? n.Oc : "?");
                            sb.append('\n');
                        }
                    } else if (fromFile != null && fromFile.isVideo()) {
                        sb.append("Type: VIDEO (");
                        sb.append(fromFile.name());
                        sb.append(")\n");
                        MediaInfo a3 = MediaInfo.a(file);
                        if (a3 == null) {
                            sb.append("(Media info not available)\n");
                        } else {
                            sb.append("File size: ");
                            sb.append(a3.u());
                            sb.append('\n');
                            sb.append("Duration: ");
                            sb.append(a3.r());
                            sb.append('\n');
                            sb.append("Audio Duration: ");
                            sb.append(a3.o());
                            sb.append('\n');
                            sb.append("Video Duration: ");
                            sb.append(a3.K());
                            sb.append('\n');
                            sb.append("FPS: ");
                            sb.append(a3.t());
                            sb.append('\n');
                            sb.append("Seek point count: ");
                            sb.append(a3.E());
                            sb.append('\n');
                            sb.append("H264 Level: ");
                            sb.append(a3.M());
                            sb.append('\n');
                            sb.append("H264 Profile: ");
                            sb.append(a3.N());
                            sb.append('\n');
                            sb.append("Size: ");
                            sb.append(a3.D());
                            sb.append('x');
                            sb.append(a3.C());
                            sb.append('\n');
                            sb.append("Has audio: ");
                            sb.append(a3.S() ? "yes" : "no");
                            sb.append('\n');
                            sb.append("Has video: ");
                            sb.append(a3.U() ? "yes" : "no");
                            sb.append('\n');
                            sb.append("Excluded: ");
                            sb.append(a3.W() ? "yes" : "no");
                            sb.append('\n');
                            sb.append("Support Type: " + a3.y() + "\n");
                            CodecType n2 = a3.n();
                            sb.append("Audio Codec: ");
                            sb.append(n2 == null ? "?" : n2.Oc);
                            sb.append('\n');
                            CodecType J = a3.J();
                            sb.append("Video Codec: ");
                            sb.append(J != null ? J.Oc : "?");
                            sb.append('\n');
                            NexEditor i2 = EditorGlobal.i();
                            if (i2 != null && (i = i2.i()) != null) {
                                int a4 = i.a(a3.N(), a3.M(), a3.D(), a3.C(), a3.t(), a3.I(), a3.q(), a3.m(), a3.L(), a3.p(), a3.J(), a3.O());
                                if (a4 == 0) {
                                    mediaSupportType = MediaSupportType.Supported;
                                } else if (a4 == 1) {
                                    mediaSupportType = MediaSupportType.NeedTranscodeRes;
                                } else if (a4 == 2) {
                                    mediaSupportType = MediaSupportType.NeedTranscodeFPS;
                                } else if (a4 == 3) {
                                    mediaSupportType = MediaSupportType.NotSupported_VideoProfile;
                                } else if (a4 == 4) {
                                    mediaSupportType = MediaSupportType.NotSupported_ResolutionTooHigh;
                                } else if (a4 != 8) {
                                    mediaSupportType = MediaSupportType.Unknown;
                                } else {
                                    mediaSupportType = MediaSupportType.NeedTranscodeAVSync;
                                }
                                sb.append("VCC Support Type: " + mediaSupportType.name() + " (" + a4 + ")\n");
                            }
                        }
                    } else if (fromFile != null) {
                        sb.append("Type: UNKNOWN (" + fromFile.name() + ")\n");
                    } else {
                        sb.append("Type: UNKNOWN\n");
                    }
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
        new AlertDialog.Builder(context).setView(textView).setTitle("Diagnostic Information").setCancelable(true).setPositiveButton("OK", new G()).setNeutralButton("Copy to Clipboard", new F(context, a2)).show();
    }

    public static void a(Context context, com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        TextView textView = new TextView(context);
        StringBuilder sb = new StringBuilder();
        if (cVar != null) {
            sb.append("Name: ");
            sb.append(cVar.c());
            sb.append('\n');
            sb.append("File size: ");
            sb.append(cVar.a());
            sb.append('\n');
            sb.append("Date: ");
            sb.append(cVar.d());
            sb.append('\n');
        }
        String sb2 = sb.toString();
        textView.setText(sb2);
        textView.setTextIsSelectable(true);
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setScrollBarStyle(16777216);
        new AlertDialog.Builder(context).setView(textView).setTitle("Diagnostic Information").setCancelable(true).setPositiveButton("OK", new I()).setNeutralButton("Copy to Clipboard", new H(context, sb2)).show();
    }
}
