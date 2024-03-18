import java.util.ArrayList;

public class Box<T extends Fruit> {

    private ArrayList<T> fruits;

    private String fruitKind = "none";

    public String getFruitKind(){
        return fruitKind;
    }


    public void setFruitKind(String fruitKind){
        this.fruitKind = fruitKind;
    }

    public float getWeight(){
        if (fruits == null){
            return 0;
        }
        float weight = 0;
        for(T fruit: fruits){
            weight = weight + fruit.getWeight();
        }
        return weight;
    }

    public void putFruit(T fruit){
        if (fruits == null){
            fruits = new ArrayList<T>();
            fruits.add(fruit);
            setFruitKind(fruit.getClass().toString());
        }
        else{
            if(fruit.getClass().toString().equals(fruitKind)){
                fruits.add(fruit);
            }

        }
    }
    public boolean compare(Box<Fruit> box){
        if (this.getWeight() == box.getWeight()){
            return true;
        }
        else{
            return false;
        }

    }
    public void putFruits(Box<Fruit> box){
        if (this.getFruitKind().equals(box.getFruitKind())){
            for(Fruit fruit: this.fruits){
                box.putFruit(fruit);
            }
            fruits = null;

        }
    }

}
