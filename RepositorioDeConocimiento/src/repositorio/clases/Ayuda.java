package repositorio.clases;


import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;

import com.nokia.mid.ui.orientation.Orientation;
import com.nokia.mid.ui.orientation.OrientationListener;

class Ayuda extends Form implements CommandListener, OrientationListener {

    private final Inicio midlet;
    private final Command exitCommand;
    private final Command atrasCommand;
    private final Command atrasCommand2;
  //  private final TextEditor txt1;
   // private ImageItem imagen;
   // private TextBox txt;
    public Ayuda(Inicio midlet, String string) {
        super("");

        Orientation.addOrientationListener(this);

        StringItem helloText = new StringItem("", string);
        super.append(helloText);
        this.midlet = midlet;
        exitCommand = new Command("Salir", Command.SCREEN, 1);
        atrasCommand = new Command("AtrasBack", Command.BACK, 1);
        atrasCommand2 = new Command("Atras", Command.SCREEN, 1);
//        txt =new TextBox("Estado","", 400, TextField.ANY);
//        try {
//    	    //Creamos el item del Form
//    	    imagen= new ImageItem("", Image.createImage("/img/login.png"), ImageItem.LAYOUT_CENTER, "Logo de Java");
//    	    
//    	    append(imagen); 
//    	} catch (java.io.IOException e) {
//    	    append(" Ha habido un problema al leer el fichero logo.gif\nMotivo:"+e); 
//    	}
         
        addCommand(exitCommand);
        addCommand(atrasCommand);
        addCommand(atrasCommand2);
    
        setCommandListener(this);
    }

    public void commandAction(Command command, Displayable displayable) {
        if (command == exitCommand) {
            midlet.notifyDestroyed();
        }
        if (command == atrasCommand) {
            midlet.notifyDestroyed();
        }
        if (command == atrasCommand2) {
            midlet.notifyDestroyed();
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
