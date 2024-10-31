package c.d.b.d.b.b;

import android.util.Xml;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: KmXmlGenerator.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private c.d.b.d.b.a.b.a f3727a;

    /* renamed from: b, reason: collision with root package name */
    private String f3728b;

    public a(c.d.b.d.b.a.b.a aVar, String str) {
        this.f3727a = aVar;
        this.f3728b = str;
    }

    public String a() throws IOException {
        StringWriter stringWriter;
        FileOutputStream fileOutputStream;
        XmlSerializer newSerializer = Xml.newSerializer();
        String str = this.f3728b;
        if (str != null) {
            File file = new File(str);
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file);
            newSerializer.setOutput(fileOutputStream, "UTF-8");
            stringWriter = null;
        } else {
            StringWriter stringWriter2 = new StringWriter();
            newSerializer.setOutput(stringWriter2);
            stringWriter = stringWriter2;
            fileOutputStream = null;
        }
        newSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        newSerializer.startDocument("UTF-8", true);
        c.d.b.d.b.b.b.a aVar = new c.d.b.d.b.b.b.a(newSerializer);
        aVar.a(this.f3727a);
        aVar.d();
        newSerializer.endDocument();
        newSerializer.flush();
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
        if (stringWriter != null) {
            return stringWriter.toString();
        }
        return null;
    }
}
