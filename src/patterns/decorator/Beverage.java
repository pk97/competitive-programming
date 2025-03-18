package patterns.decorator;

public abstract class Beverage {
      private String name;
    public abstract int cost();
    public String getDescription() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }
}

class Tea extends Beverage {

    Tea() {
        setName("Tea");
    }
    @Override
    public int cost() {
        return 10;
    }
}

class Coffee extends  Beverage {
    Coffee() {
       setName("Coffee");
    }

    @Override
    public int cost() {
        return 0;
    }
}

abstract class CondimentDecorator extends Beverage {
    Beverage beverage;
    public abstract String getDescription();
}

class Whip extends CondimentDecorator {
    Whip(Beverage beverage) {
        this.beverage = beverage;

    }
    @Override
    public int cost() {
        return beverage.cost() + 2;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "with Whip";
    }
}



class Soy extends CondimentDecorator {
    Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "with Whip";
    }
    @Override
    public int cost() {
        return beverage.cost() + 4;
    }

}



class Driver {
    public static void main(String[] args) {
        Beverage b1 = new Tea();
        System.out.println(b1.getDescription());
        b1 = new Soy(new Whip(b1));
        System.out.println(b1.getDescription()+ "cost"+ b1.cost());
    }
}