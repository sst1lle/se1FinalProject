import Categorieen.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KostenCategorie {
    private final List<CategorieKosten> categorieen;

    public KostenCategorie(){
        categorieen = new ArrayList<>();
    }

    public void voegCategorieToe(CategorieKosten... nieuweCategorieen) {
        Collections.addAll(categorieen, nieuweCategorieen);
    }

    public void toonCategorieKosten(CategorieKosten...categorieen){
        for (CategorieKosten kost : categorieen){
            System.out.println(kost);
        }
    }

}
