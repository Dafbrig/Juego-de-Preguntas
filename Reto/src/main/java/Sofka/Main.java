package Sofka;

import Class.Juego;
import Class.Jugador;
import Class.Ronda;
import Conecction.Conection;
import Helpers.Capturar;
import Helpers.Data;
import Helpers.Tabla;
import java.util.LinkedList;
import javax.swing.JFrame;

public class Main {
    public static void main(String args[]) {
            int select;
            Juego juego;
            Conection.conecction();
            LinkedList<Ronda> ListRondas=Data.getRondas();
            Capturar.MostrarMensaje("Bievenido");
            do{
            select= Capturar.CapturarEntero("Ingrese un numero:\n "
            + "1 Iniciar Juego\n "
            + "2 Ver historico\n "
            + "0 Salir");
             
                if(select==1){
                    Jugador jugador = new Jugador();
                    juego=new Juego(jugador);
                    juego.setRondas(ListRondas);
                    juego.iniciar();
                    Data.Guardar(juego,Conection.getInstance());
                }else{
                    if(select==2){
                         int opc= Capturar.CapturarEntero("Esta opción cerrara el juego:\n " + "¿Desea continuar?\n" + "1 Si\n "+ "0 No");
                         if(opc==1){
                            Data.getJuego();
                            select=0;
                            Tabla tabla=new Tabla(Data.getJuego());
                            tabla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            tabla.setVisible(true);
                            tabla.toFront();
                            tabla.setAlwaysOnTop(true);
                            tabla.requestFocus();
                         }
                    }
                }
            }while(select!=0);
    }
}
