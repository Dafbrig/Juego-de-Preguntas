package Conecction;
//Documento Conexion de la data base
import Helpers.Capturar;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.FileInputStream;

public class Conection {
    static Firestore db;
    public static void conecction() {
        try{
        FileInputStream serviceAccount =new FileInputStream("juego-7.json");
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp.initializeApp(options);
        
        db=FirestoreClient.getFirestore();
        }catch(Exception e){
            Capturar.MostrarMensaje("Problemas con la conexion:"+e.getMessage());
        }
    }

    public static Firestore getInstance() {
        return db;
    }
}
