package magnas.sr03.model;

public class Structure {
    /*
    "structId" : 48,
    "dateFermeture" : null,
    "dateOuverture" : "1974-01-01",
    "gestRech$f" : "N",
    "structureUt$f" : "O",
    "titre" : null,
    "titreAn" : null,
    "trombi$f" : "O"
     */
    String structId;
    String dateFermeture;
    String dateOuverture;
    String gestRech$f;
    String titre;
    String titreAn;
    String trombi$f;

    public String getStructId() {
        return structId;
    }

    public String getDateFermeture() {
        return dateFermeture;
    }

    public String getDateOuverture() {
        return dateOuverture;
    }

    public String getGestRech$f() {
        return gestRech$f;
    }

    public String getTitre() {
        return titre;
    }

    public String getTrombi$f() {
        return trombi$f;
    }

    public String getTitreAn() {
        return titreAn;
    }
}
