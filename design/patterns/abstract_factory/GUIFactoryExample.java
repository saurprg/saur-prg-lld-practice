package design.patterns.abstract_factory;

interface  Button {
    public void showButton();   
}

interface  CheckBox {
    public void showCheckBox();   
}

class WindowsCheckBox implements CheckBox {
    @Override
    public void showCheckBox() {
        System.out.println("Windows checkbox");       
    }
}

class MacOsCheckBox implements CheckBox {
    @Override
    public void showCheckBox() {
        System.out.println("MacOs checkbox");       
    }
}

class WindowsButton implements Button {
    WindowsButton() {
        System.err.println("Created Windows button");
    }

    @Override
    public void showButton() {
        System.out.println("Windows Button");
    }
}

class MacOsButton implements Button {
    MacOsButton() {
        System.err.println("Created MacOs button");
    }

    @Override
    public void showButton() {
        System.out.println("MacOs Button");
    }
}

interface GUIFactory {
    public Button createButton();
    public CheckBox createCheckBox();
}

class MacOsGUIFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacOsCheckBox();
    }
}

class WindowsGUIFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckBox();
    }
}


public class GUIFactoryExample {

    public static void main(String[] args) {
        GUIFactory factory = new MacOsGUIFactory();
        Button b = factory.createButton();
        CheckBox c = factory.createCheckBox();
        b.showButton();
        c.showCheckBox();
        factory = new WindowsGUIFactory();
        b = factory.createButton();
        c= factory.createCheckBox();
        b.showButton();
        c.showCheckBox();
    }

}