package Class;

import Helpers.Capturar;
import Helpers.Mapper;
import java.util.HashMap;

public class Jugador extends Mapper{
    String Name="";
    int Document=0;
    
    public Jugador(String Name,int Document) {
       this.Name=Name;
       this.Document=Document;
    }
    public Jugador() {
       this.Name= Capturar.CapturarString("Ingrese su nombre");
       this.Document= Capturar.CapturarEntero("Ingrese su Documento");
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getDocument() {
        return Document;
    }

    public void setDocument(int Document) {
        this.Document = Document;
    }

    @Override
    public HashMap toMap() {
        HashMap<String, Object> Jugador= new HashMap<>();
        Jugador.put("Name", this.Name);
        Jugador.put("Document", this.Document);
        return Jugador;
    }
}
