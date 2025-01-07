interface  Button {
    public void showButton();   
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

interface ButtonCreator {
    public Button createButton();
}

class WindowButtonCreator implements ButtonCreator {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}

class MacOsButtonCreator implements ButtonCreator {
    @Override
    public Button createButton() {
        return new MacOsButton();
    }
}

public class GUIExample {
    public static void main(String[] args) {
        ButtonCreator creator = new WindowButtonCreator();
        Button b = creator.createButton();
        b.showButton();
        creator = new MacOsButtonCreator();
        b = creator.createButton();
        b.showButton();
    }
}