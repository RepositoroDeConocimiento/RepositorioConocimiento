package repositorio.clases;


import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.ImageItem;
import javax.microedition.lcdui.StringItem;

import com.nokia.mid.ui.orientation.Orientation;
import com.nokia.mid.ui.orientation.OrientationListener;

class GestionarCategorias extends Form implements CommandListener, OrientationListener {

    private final Inicio midlet;
    private final Command crearCategoria;
    private final Command eliminarCategoria;
    private final Command modificarCategoria;
    private final Command atras;
    private final Command atras2;
    private final Command salir;
    private final Command temas;
    private final Command consultar;
    private ImageItem imagen;
    private Form crearCate;
    private Form vistaAdmin;
    public GestionarCategorias(Inicio midlet) {
        super("");

        Orientation.addOrientationListener(this);

        StringItem helloText = new StringItem("     Gestionar categorias","");
        super.append(helloText);
        StringItem titulo = new StringItem("      Seleccione una opción","");
        super.append(titulo);
        this.midlet = midlet;
        salir = new Command("Salir", Command.SCREEN, 1);
        atras = new Command("Atras", Command.SCREEN, 1);
        atras2 = new Command("Atras", Command.BACK, 1);
        crearCategoria = new Command("Crear categoria", Command.SCREEN, 1);
        eliminarCategoria = new Command("Eliminar categoria", Command.SCREEN, 1);
        modificarCategoria = new Command("Modificar categoria", Command.SCREEN, 1);
        consultar = new Command("Consultar", Command.SCREEN, 1);
        temas = new Command("Temas", Command.SCREEN, 1);
        try {
    	    imagen= new ImageItem("", Image.createImage("/img/gestion_unidades.jpg"), ImageItem.LAYOUT_CENTER, "Logo de Java");
    	    
    	    append(imagen); 
    	} catch (java.io.IOException e) {
    	    append("No se pudo cargar la imagen por: "+e); 
    	}
        addCommand(salir);
        addCommand(atras);
        addCommand(atras2);
        addCommand(crearCategoria);
        addCommand(eliminarCategoria);
        addCommand(modificarCategoria);
        addCommand(consultar);
        addCommand(temas);
    
        setCommandListener(this);
    }

    public void commandAction(Command command, Displayable displayable) {
        if (command == salir) {
            midlet.notifyDestroyed();
        }
        if (command == crearCategoria) {
        	 crearCate = new CrearCategoria(midlet);
             Display.getDisplay(midlet).setCurrent(crearCate);
         }
        else if (command == atras) {
        	vistaAdmin = new VistaAdmin(midlet);
              Display.getDisplay(midlet).setCurrent(vistaAdmin);
        }
        else if (command == atras2) {
        	vistaAdmin = new VistaAdmin(midlet);
              Display.getDisplay(midlet).setCurrent(vistaAdmin);
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


