package repositorio.clases;

public interface IConexion {

	public void open(String rmsName);

	public byte[] get();

	public void set(byte[] data);

	public void close();
}
