package repositorio.interfaces;

public interface IConexion {

		public void abrirConexion(String nombreTabla);

		public byte[] taerDatos();

		public void registrarDatos(byte[] datosGuardar);

		public void cerrarConexion();
}
