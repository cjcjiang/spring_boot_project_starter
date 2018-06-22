package com.jiang.springbootserverstarter.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.compress.utils.IOUtils;

/**
 * 解压压缩包的工具类。
 * 
 * @author Yuming Jiang
 * @since 0.0.1-SNAPSHOT
 */
public class UnZipUtil {
	
    /** 
     * 解压tar.gz文件。
     * 
     * @param inputFileDir 要解压的tar.gz文件所在目录 。
     * 
     * @param outputDir 解压到的某个指定的目录下。
     * 
     * @throws IOException
     * 
     * @author Yuming Jiang
     * @since 0.0.1-SNAPSHOT
     */
    public static void unTarGz(String inputDir,String outputDir) throws IOException{
    	String temp_input = "C:\\Users\\Lenovo\\Desktop\\temp.tar.gz";
    	String temp_output = "C:\\Users\\Lenovo\\Desktop";
    	try(InputStream fi = Files.newInputStream(Paths.get(temp_input));
	        InputStream bi = new BufferedInputStream(fi);
	        InputStream gzi = new GzipCompressorInputStream(bi);
	        ArchiveInputStream i = new TarArchiveInputStream(gzi);){
    		File targetDir = new File(temp_output);
            ArchiveEntry entry = null;
            while ((entry = i.getNextEntry()) != null) {
                if (!i.canReadEntryData(entry)) {
                    // log something?
                    continue;
                }
                File f = new File(targetDir, entry.getName());
                if (entry.isDirectory()) {
                    if (!f.isDirectory() && !f.mkdirs()) {
                        throw new IOException("failed to create directory " + f);
                    }
                } else {
                    File parent = f.getParentFile();
                    if (!parent.isDirectory() && !parent.mkdirs()) {
                        throw new IOException("failed to create directory " + parent);
                    }
                    try(OutputStream o = Files.newOutputStream(f.toPath());){
                    	IOUtils.copy(i, o);
                    }
                }
            }
    	}
    }

}
