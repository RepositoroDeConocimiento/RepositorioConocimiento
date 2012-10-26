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

class VistaAdmin extends Form implements CommandListener, OrientationListener {

    private final Inicio midlet;
    private final Command categorias;
    private final Command temas;
    private final Command consultar;
    private final Command atras;
    private final Command atras2;
    private final Command salir;
    private ImageItem imagen;
    private Form categoria;
    private Form login;
    public VistaAdmin(Inicio midlet) {
        super("");

        Orientation.addOrientationListener(this);

        StringItem helloText = new StringItem("Repositorio de conocimiento","");
        super.append(helloText);
        StringItem titulo = new StringItem("Bienvenido:","Administrador");
        super.append(titulo);
        StringItem menu = new StringItem("     Seleccione una opción","");
        super.append(menu);
        this.midlet = midlet;
        salir = new Command("Salir", Command.SCREEN, 1);
        atras = new Command("Atras", Command.SCREEN, 1);
        atras2 = new Command("Atras", Command.BACK, 1);
        categorias = new Command("Categorias", Command.SCREEN, 1);
        consultar = new Command("Consultar", Command.SCREEN, 1);
        temas = new Command("Temas", Command.SCREEN, 1);
        try {
    	    imagen= new ImageItem("", Image.createImage("/img/admin.png"), ImageItem.LAYOUT_CENTER, "Logo de Java");
    	    
    	    append(imagen); 
    	} catch (java.io.IOException e) {
    	    append("No se pudo cargar la imagen por: "+e); 
    	}
        addCommand(salir);
        addCommand(atras);
        addCommand(atras2);
        addCommand(consultar);
        addCommand(temas);
        addCommand(categorias);
    
        setCommandListener(this);
    }

    public void commandAction(Command command, Displayable displayable) {
        if (command == salir) {
            midlet.notifyDestroyed();
        }else  if (command == categorias) {
        	categoria = new GestionarCategorias(midlet);
              Display.getDisplay(midlet).setCurrent(categoria);
        }
        else if (command == atras) {
        	login = new Login(midlet);
              Display.getDisplay(midlet).setCurrent(login);
        }
        else if (command == atras2) {
        	login = new Login(midlet);
              Display.getDisplay(midlet).setCurrent(login);
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

