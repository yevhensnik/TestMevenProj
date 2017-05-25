package compresor;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;
import org.apache.commons.compress.utils.IOUtils;

public class Compressor
{
    public static void createTarGZ(String inputPath, String outPut) throws FileNotFoundException, IOException
    {
	OutputStream fOut = null;
	BufferedOutputStream bOut = null;
	GzipCompressorOutputStream gzOut = null;
	TarArchiveOutputStream tOut = null;
	try
	{
	    fOut = new FileOutputStream(new File(outPut));
	    bOut = new BufferedOutputStream(fOut);
	    gzOut = new GzipCompressorOutputStream(bOut);
	    tOut = new TarArchiveOutputStream(gzOut);
	    tOut.setBigNumberMode(TarArchiveOutputStream.BIGNUMBER_STAR);
	    tOut.setLongFileMode(TarArchiveOutputStream.LONGFILE_GNU);
	    
	    addFileToTarGz(tOut, inputPath, "");
	} finally
	{
	    tOut.finish();
	    tOut.close();
	    gzOut.close();
	    bOut.close();
	    fOut.close();
	}
    }

    private static void addFileToTarGz(TarArchiveOutputStream tOut, String path, String base) throws IOException
    {
	File f = new File(path);
	String entryName = base + f.getName();
	TarArchiveEntry tarEntry = new TarArchiveEntry(f, entryName);
	tOut.putArchiveEntry(tarEntry);

	if (f.isFile())
	{
	    IOUtils.copy(new FileInputStream(f), tOut);
	    tOut.closeArchiveEntry();
	} else
	{
	    tOut.closeArchiveEntry();
	    File[] children = f.listFiles();
	    if (children != null)
	    {
		for (File child : children)
		{
		    addFileToTarGz(tOut, child.getAbsolutePath(), entryName + "/");
		}
	    }
	}
    }
}
