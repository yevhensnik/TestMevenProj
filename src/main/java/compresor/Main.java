package compresor;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main
{

    public static void main(String[] args) throws FileNotFoundException, IOException
    {
	Compressor compressor = new Compressor();
	
	compressor.createTarGZ("/home/bogdan/Documents/intouch/elasticbackup", "/media/bogdan/22327004326FDAF5/COMPRESSORTEST/zippedElastic.tar.gz");

    }

}
