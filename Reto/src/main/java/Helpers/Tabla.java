package Helpers;

import Class.Juego;
import java.awt.BorderLayout;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Tabla extends JFrame{
    private String [] nom={"Nombre","Documento","Puntos","Estado","Max-Ronda"};
    private String [][] datos;
    public Tabla(LinkedList<Juego> Juegos){
        datos=new String [Juegos.size()][5];
        final int ronda=0;
        for(int i=0;i<Juegos.size();i++){
             datos[i][0]=Juegos.get(i).getJugador().getName();
             datos[i][1]=Integer.toString(Juegos.get(i).getJugador().getDocument());
             datos[i][2]=Integer.toString(Juegos.get(i).getAcumulado());
             datos[i][3]=Juegos.get(i).getEstado();
             datos[i][4]=Integer.toString(Juegos.get(i).getRonda());
        };
        setTitle("Histórico");
        setBounds(300,300,400,200);
        JTable tablaHistory=new JTable(datos,nom);
        add(new JScrollPane(tablaHistory),BorderLayout.CENTER);
    }
}
