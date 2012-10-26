package repositorio.clases;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;

/**
 * File based storage using JSR-75.
 */
public class Conexion implements IConexion {

    private String rootDir;
    private String rmsName;
    FileConnection fc;

    public Conexion() {
    	
        rootDir = System.getProperty("fileconn.dir.private");
    }

    public void open(String rmsName) {
        try {
            fc = (FileConnection) Connector.open(rootDir + rmsName);
            if (!fc.exists()) {
                fc.create();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte[] get() {
        byte[] data = null;
        try {
            InputStream is = fc.openInputStream();

            int len = (int) fc.fileSize();
            data = new byte[len];
            int readBytes = is.read(data);
            if (readBytes != len) {
                System.out.println("read size mismatch");
            }

            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public void set(byte[] data) {
        try {
            OutputStream os = fc.openOutputStream();
            os.write(data);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            fc.close();
        } catch (IOException e) {
            //e.printStackTrace();
        } catch (NullPointerException e) {
            //e.printStackTrace();
        }
    }

    public void delete(String rmsName) {
        try {
            FileConnection file = (FileConnection) Connector.open(rootDir + rmsName);
            if (file.exists()) {
                file.delete();
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	/**
	 * @return the rmsName
	 */
	public String getRmsName() {
		return rmsName;
	}

	/**
	 * @param rmsName the rmsName to set
	 */
	public void setRmsName(String rmsName) {
		this.rmsName = rmsName;
	}
}
