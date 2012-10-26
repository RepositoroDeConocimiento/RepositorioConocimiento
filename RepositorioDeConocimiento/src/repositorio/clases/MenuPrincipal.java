package repositorio.clases;


import com.nokia.mid.ui.orientation.Orientation;
import com.nokia.mid.ui.orientation.OrientationListener;
import javax.microedition.lcdui.*;

class MenuPrincipal extends Form   implements CommandListener, OrientationListener {

    private final Inicio midlet;
    private final Command exitCommand;
    private final Command ayudaCommand;
    private final Command ingresarCommand;
    private Form ayuda;
    private Form login;
    private ImageItem imagen;
    public MenuPrincipal(Inicio midlet) {
        super("");

        Orientation.addOrientationListener(this);

        StringItem helloText = new StringItem("Repositorio de conocimiento", "");
        super.append(helloText);
        this.midlet = midlet;
        exitCommand = new Command("Salir", Command.SCREEN, 1);
        ayudaCommand = new Command("Ayuda", Command.SCREEN, 1);
        ingresarCommand = new Command("Ingresar", Command.SCREEN, 1);
        try {
    	    imagen= new ImageItem("", Image.createImage("/img/java.png"), ImageItem.LAYOUT_CENTER, "Logo de Java");
    	    
    	    append(imagen); 
    	} catch (java.io.IOException e) {
    	    append("No se pudo cargar la imagen por: "+e); 
    	}
        addCommand(exitCommand);
        addCommand(ayudaCommand);
        addCommand(ingresarCommand);
        setCommandListener(this);
    }

    public void commandAction(Command command, Displayable displayable) {
        if (command == exitCommand) {
            midlet.notifyDestroyed();
        } else  if (command == ayudaCommand) {
        	 ayuda = new Ayuda(midlet, "Ayuda");
            Display.getDisplay(midlet).setCurrent(ayuda);
        } else  if (command == ingresarCommand) {
//        	 login = new Login(midlet);
//             Display.getDisplay(midlet).setCurrent(login);
        	CrearCategoria c = new CrearCategoria(midlet);
            Display.getDisplay(midlet).setCurrent(c);
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
