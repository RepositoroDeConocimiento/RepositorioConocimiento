package repositorio.clases;

import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.MIDlet;

public class Inicio
        extends MIDlet {

    public Inicio() {
    }

    public void startApp() {
        Displayable current = Display.getDisplay(this).getCurrent();
        
        if (current == null) {
            MenuPrincipal helloScreen = new MenuPrincipal(this);
            Display.getDisplay(this).setCurrent(helloScreen);
        }
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }
}