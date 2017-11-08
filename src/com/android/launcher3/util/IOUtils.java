// 
// Decompiled by Procyon v0.5.30
// 

package com.android.launcher3.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtils
{
    public static long copy(final InputStream inputStream, final OutputStream outputStream) throws IOException {
        final byte[] array = new byte[4096];
        long n = 0L;
        while (true) {
            final int read = inputStream.read(array);
            if (read == -1) {
                break;
            }
            outputStream.write(array, 0, read);
            n += read;
        }
        return n;
    }
    
    public static byte[] toByteArray(final File p0) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(p0);
            byte[] bytes = toByteArray(fileInputStream);
            fileInputStream.close();
            return bytes;
        }
        catch (IOException e) {
            return new byte[0];
        }
    }
    
    public static byte[] toByteArray(final InputStream inputStream) throws IOException {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copy(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
