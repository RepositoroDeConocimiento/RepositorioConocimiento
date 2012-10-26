package repositorio.clases;


import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;

import com.nokia.mid.ui.orientation.Orientation;
import com.nokia.mid.ui.orientation.OrientationListener;

class ConsultarCategoria extends Form implements CommandListener, OrientationListener {

    private final Inicio midlet;
    private final Command atras;
    private final Command atras2;
    private final Command salir;
    private final Command temas;
    private final Command categorias;
    private final Command consultar;
    private final Command ok;
    private final Command aceptar;
    private final Command cancelar;
    private TextField nombre;
    private Form gestionCate;
    private List listCategorias;
    private Command a;
    private Command b;
    public ConsultarCategoria(Inicio midlet) {
        super("");

        Orientation.addOrientationListener(this);

        StringItem helloText = new StringItem("          Crear categorias","");
        super.append(helloText);
        this.midlet = midlet;
        salir = new Command("Salir", Command.SCREEN, 1);
        atras = new Command("Atras", Command.SCREEN, 1);
        atras2 = new Command("Atras", Command.BACK, 1);
        consultar = new Command("Consultar", Command.SCREEN, 1);
        temas = new Command("Temas", Command.SCREEN, 1);
        categorias = new Command("Categorias", Command.SCREEN, 1);
        cancelar = new Command("Cancelar", Command.CANCEL, 1);
        aceptar = new Command("Aceptar", Command.SCREEN, 1);
        ok = new Command("OK", Command.OK, 1);
        a = new Command("a", Command.ITEM, 1);
        b = new Command("b", Command.ITEM, 1);
        nombre= new TextField("Nombre:","",50,TextField.ANY);
        String[] arg2 = {"hola1", "hola2"};
		listCategorias= new List("Lista categorias", List.EXCLUSIVE, arg2, null);
        listCategorias.addCommand(a);
        listCategorias.addCommand(b);
        append(nombre);
        addCommand(salir);
        addCommand(atras);
        addCommand(atras2);
        addCommand(consultar);
        addCommand(temas);
        addCommand(categorias);
        addCommand(ok);
        addCommand(cancelar);
        addCommand(aceptar);
        
        setCommandListener(this);
    }

    public void commandAction(Command command, Displayable displayable) {
        if (command == salir) {
            midlet.notifyDestroyed();
        }
        else if (command == atras) {
        	gestionCate = new GestionarCategorias(midlet);
              Display.getDisplay(midlet).setCurrent(gestionCate);
        }
        else if (command == atras2) {
        	gestionCate = new GestionarCategorias(midlet);
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


