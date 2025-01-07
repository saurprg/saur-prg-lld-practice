package design.patterns.builder;
public class Pizza {
    private String dough, topping, flavour, cheeseType, additionalRequests;
    
    public Pizza(String dough, String topping, String flavour, String cheeseType, String additionalRequests) {
        this.dough = dough;
        this.additionalRequests =additionalRequests;
        this.cheeseType = cheeseType;
        this.flavour = flavour;
        this.topping = topping;
    }

    public Pizza() {}

    public static class PizzaBuilder{
        private String dough, topping, flavour, cheeseType, additionalRequests;
        public PizzaBuilder() {
        }

        public PizzaBuilder withDough(String dough) {
            this.dough=dough;
            return this;
        }

        public PizzaBuilder withTopping(String topping) {
            this.topping = topping;
            return this;
        }
    
        public PizzaBuilder withFlavour(String flavour) {
            this.flavour = flavour;
            return this;
        }

        public PizzaBuilder withCheeseType(String cheeseType) {
            this.cheeseType = cheeseType;
            return this;
        }
    
        public PizzaBuilder withAddtionalRequests(String additionalRequests) {
            this.additionalRequests = additionalRequests;
            return this;
        }

        public Pizza build() {
            return new Pizza(dough, topping, flavour, cheeseType, additionalRequests);
        }

    }

    @Override
    public String toString() {
        return "Pizza details " + dough + topping + flavour + cheeseType + additionalRequests;
    }
}

class Main {
    public static void main(String[] args) {
        Pizza pizza = new Pizza.PizzaBuilder()
            .withAddtionalRequests("give me pizza")
            .withCheeseType("paneer")
            .withTopping("chicken")
            .withDough("wheat")
            .build();
        System.out.println(pizza);
    }
}