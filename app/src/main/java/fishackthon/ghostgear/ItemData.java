package fishackthon.ghostgear;

/**
 * Created by arturolopez on 4/23/16.
 */
public class ItemData {
    String text;
    Integer imageId;
    String animalStatus;

    public ItemData(String text){
        this.text = text;
    }
    public ItemData(String text, Integer imageId){
        this.text = text;
        this.imageId = imageId;
    }

    public ItemData(String text, Integer imageId, String animalStatus){
        this.text = text;
        this.imageId = imageId;
        this.animalStatus = animalStatus;
    }

    public String getText(){
        return text;
    }
    public int getImageId(){
        return  imageId;
    }
    public String getAnimalStatus() {return animalStatus;}
}
