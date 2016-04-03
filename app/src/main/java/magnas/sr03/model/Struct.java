package magnas.sr03.model;

/**
 * Created by Gregory on 18/03/2016.
 */
public class Struct {
    /*
    {
  "structNomId" : 50,
  "auteurMaj" : "GERRY",
  "creDate" : "2014-01-14",
  "finValidite" : null,
  "harpComposante" : "SCAC",
  "modifDate" : null,
  "sigle" : null,
  "structureAbr" : "AC",
  "structureLibelle" : "Agence comptable",
  "structureLibelleAngl" : null,
  "structure" : {
    //SEE Structure
  }
}
     */
    int structNomId;
    String auteurMaj;
    String creDate;
    String finValidite;
    String harpComposante;
    String modifDate;
    String sigle;
    String structureAbr;
    String structureLibelle;
    String structureLibelleAngl;
    Structure structure;

    public Struct(int id) {
        structNomId = id;
        structureLibelle = "choisissez une sous structure";
    }

    public int getStructNomId() {
        return structNomId;
    }

    public String getAuteurMaj() {
        return auteurMaj;
    }

    public String getCreDate() {
        return creDate;
    }

    public String getFinValidite() {
        return finValidite;
    }

    public String getHarpComposante() {
        return harpComposante;
    }

    public String getModifDate() {
        return modifDate;
    }

    public String getSigle() {
        return sigle;
    }

    public String getStructureAbr() {
        return structureAbr;
    }

    public String getStructureLibelle() {
        return structureLibelle;
    }

    public String getStructureLibelleAngl() {
        return structureLibelleAngl;
    }

    public Structure getStructure() {
        return structure;
    }

    @Override
    public String toString() {
        return structureLibelle;
    }
}
