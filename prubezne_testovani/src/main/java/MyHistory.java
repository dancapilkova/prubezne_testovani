import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyHistory {

    String fileName;
    List<String> data;
    Set<String> index;
    public MyHistory(String fileName) {
        this.fileName = fileName;
        data = new ArrayList<>();
        index = new HashSet<>();
        // vytvori instanci pro soubor _fileName_
    }

    public void read() throws IOException {
        try {
            data = Files.readAllLines(Paths.get(fileName));
        }catch (IOException e){
            data = new ArrayList<String>();
        }
        // načte soubor fileName do paměti, skončí výjimkou pokud soubor nejde načíst
    }

    public void save() throws IOException {
        Files.writeString(Paths.get(fileName), this.toString());
        // zapíše obsah paměti do souboru, skončí výjimkou pokud soubor nejde uložit
        // pokud soubor již existuje, přepíše jej
    }

    public void addLine(String str) {
        if(!index.contains(str)){
            index.add(str);
            data.add(str);

        }
      /*  for(String l:data){
            if(str.equals(l)){
               return;
            } else{
                data.add(str);
            }
        }
        */

        // přidá řádek str do paměti pokud tam ještě není,
        // duplicitní řádky ignoruje.
    }

    public String toString() {
        String out = "";
        for(String line:data){
           // if(!out.equals(line)) {
                out += line + "\n";
           // } else {
                continue;
            }
      //  }
        // vrátí řetězec obsahující všechny řády
        return out;
    }
}
