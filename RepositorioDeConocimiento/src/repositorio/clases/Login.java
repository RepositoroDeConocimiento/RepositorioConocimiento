package repositorio.clases;


import com.nokia.mid.ui.orientation.Orientation;
import com.nokia.mid.ui.orientation.OrientationListener;
import javax.microedition.lcdui.*;

class Login extends Form   implements CommandListener, OrientationListener, ItemStateListener {
	private Display display;
    private final Inicio midlet;
    private final Command exitCommand;
    private final Command atrasCommand;
    private final Command atrasCommand2;
    private ChoiceGroup ListaUser;
    private Command ok;
    private Command aceptar;
    private TextField password;
    private Alert alerta;
    private Form vistaAdmin;
    private Form vistaUser;
    private Form menuPrincipal;
    public Login(Inicio midlet) {
        super("");
      //Cogemos el display
    	
        Orientation.addOrientationListener(this);

        StringItem titulo = new StringItem("                     Login" ,"");
        super.append(titulo);
        this.midlet = midlet;
        display=Display.getDisplay(midlet);
        exitCommand = new Command("Salir", Command.SCREEN, 1);
        atrasCommand = new Command("AtrasBack", Command.BACK, 1);
        atrasCommand2 = new Command("Atras", Command.SCREEN, 1);
        aceptar = new Command("Aceptar", Command.SCREEN, 1);
        ok = new Command("ok", Command.OK, 1);
        password= new TextField("Contraseña","",10,TextField.PASSWORD);
        ListaUser= new ChoiceGroup("Seleccione:",ChoiceGroup.EXCLUSIVE);
		ListaUser.append("Administrador",null);
		ListaUser.append("Usuario",null);
		
        append(ListaUser);
        addCommand(exitCommand);
        addCommand(atrasCommand2);
        addCommand(atrasCommand);
        append(password);
        addCommand(ok);
        addCommand(aceptar);
        setCommandListener(this);
        setItemStateListener(this);
        
    }

    public void commandAction(Command command, Displayable displayable) {
        if (command == exitCommand) {
            midlet.notifyDestroyed();
        }else  if (command == atrasCommand) {
        	 menuPrincipal = new MenuPrincipal(midlet);
             Display.getDisplay(midlet).setCurrent(menuPrincipal);
           } else  if (command == atrasCommand2) {
        	   menuPrincipal = new MenuPrincipal(midlet);
               Display.getDisplay(midlet).setCurrent(menuPrincipal);
        } else  if (command == ok) {
        	// Segun el item seleccionado en el ChoiceGroup agregamos el texto
            switch(ListaUser.getSelectedIndex()){
                case 0:
                   if(password.getString().equals("") || password==null){
                	   alerta=new Alert("Error","Necesita proporcionar una contraseña para este tipo de usurario",null, AlertType.ERROR);	
                   	display.setCurrent(alerta);
                   }
                   else{
                	   if(password.getString().equals("admin")){
                		   vistaAdmin = new VistaAdmin(midlet);
                           Display.getDisplay(midlet).setCurrent(vistaAdmin);
                	   }
                	   else{
                		   alerta=new Alert("Error","Contraseña incorrecta",null, AlertType.ERROR);	
                          	display.setCurrent(alerta);
                       }
                   }
                    break;
                case 1:
                	 if(password.getString().equals("") || password==null){
                		 vistaUser = new VistaUser(midlet);
                         Display.getDisplay(midlet).setCurrent(vistaUser);
                     	
                     }
                     else{
                  	   alerta=new Alert("Error","No necesita contraseña para este tipo de usuario",null, AlertType.ERROR);	
                        	display.setCurrent(alerta);
                     }
                    break;
     
            }
        } else  if (command == aceptar) {
        	// Segun el item seleccionado en el ChoiceGroup agregamos el texto
            switch(ListaUser.getSelectedIndex()){
                case 0:
                   if(password.getString().equals("") || password==null){
                	   alerta=new Alert("Error","Necesita proporcionar una contraseña para este tipo de usurario",null, AlertType.ERROR);	
                   	display.setCurrent(alerta);
                   }
                   else{
                	   if(password.getString().equals("admin")){
                		   vistaAdmin = new VistaAdmin(midlet);
                           Display.getDisplay(midlet).setCurrent(vistaAdmin);
                	   }
                	   else{
                		   alerta=new Alert("Error","Contraseña incorrecta",null, AlertType.ERROR);	
                          	display.setCurrent(alerta);
                       }
                   }
                    break;
                case 1:
                	 if(password.getString().equals("") || password==null){
                		 vistaUser = new VistaUser(midlet);
                         Display.getDisplay(midlet).setCurrent(vistaUser);
                     }
                     else{
                  	   alerta=new Alert("Error","No necesita contraseña para este tipo de usuario",null, AlertType.ERROR);	
                        	display.setCurrent(alerta);
                     }
                    break;
            }
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

	public void itemStateChanged(Item arg0) {
		// TODO Auto-generated method stub
		
	}
}
