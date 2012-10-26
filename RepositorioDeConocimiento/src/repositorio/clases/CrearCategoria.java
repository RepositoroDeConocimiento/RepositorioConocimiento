package repositorio.clases;


import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;

import com.nokia.mid.ui.orientation.Orientation;
import com.nokia.mid.ui.orientation.OrientationListener;

class CrearCategoria extends Form implements CommandListener, OrientationListener {

    private final Inicio midlet;
    private final Command atras2;
    private final Command salir;
    private final Command ok;
    private final Command aceptar;
    private final Command limpiar;
    private TextField nombre;
    private TextField descripcion;
    private Form gestionCate;
    private Form mostrarCate;
    Conexion c = new Conexion();
    public CrearCategoria(Inicio midlet) {
        super("");
        Orientation.addOrientationListener(this);
        StringItem helloText = new StringItem("          Crear categorias","");
        super.append(helloText);
        this.midlet = midlet;
        salir = new Command("Salir", Command.SCREEN, 1);
        atras2 = new Command("Atras", Command.BACK, 1);
        aceptar = new Command("Guardar", Command.SCREEN, 1);
        limpiar = new Command("Limpiar", Command.SCREEN, 1);
        ok = new Command("OK", Command.OK, 1);
        nombre= new TextField("Nombre:",null,50,TextField.ANY);
        descripcion= new TextField("Descripción:",null,300,TextField.ANY);
        append(nombre);
        append(descripcion);
        addCommand(salir);
        addCommand(limpiar);
        addCommand(atras2);
        addCommand(ok);
        addCommand(aceptar);
        setCommandListener(this);
        
    }

    public void commandAction(Command command, Displayable displayable) {
        if (command == salir) {
            midlet.notifyDestroyed();
        }
        else if (command == limpiar) {
//        	nombre.setString(null);
//        	descripcion.setString(null);
        	c.setRmsName("categorias");
        	c.open("categorias");
        	c.delete("categorias");
        	c.close();
        }
        else if (command == atras2) {
        	gestionCate = new GestionarCategorias(midlet);
              Display.getDisplay(midlet).setCurrent(gestionCate);
        }
        else if (command == ok) {
        	c.setRmsName("categorias");
        	c.open("categorias");
        	byte[] data = new byte[1];
        	String tot = nombre.getString() +" "+descripcion.getString();
        	data=tot.getBytes();
			c.set(data);
			nombre.setString(null);
			descripcion.setString(null);
			c.close();
        }
        else if (command == aceptar) {
        	gestionCate = new mostrarCategoria(midlet);
            Display.getDisplay(midlet).setCurrent(gestionCate);
        }
        
       
       
    }

    /**
     * Orientation is supported for Java Runtime 2.0.0 for Series 40
     * onwards. Called when display's orientation has changed.
     */
    public void displayOrientationChanged( int newDisplayOrientation ){
            /** Change MIDlet UI orientation */
            Orientation.setAppOrientation(newDisplayOrientation);
    }
}





