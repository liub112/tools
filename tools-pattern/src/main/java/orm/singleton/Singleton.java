package orm.singleton;

public class Singleton {

    private Singleton() {}

    public static final Singleton newInstance(){
        return SingletonHandler.INSTANCE;
    }

    private static class SingletonHandler{
        private static final  Singleton INSTANCE =  new Singleton();
    }

    public void doSomething(){
        System.out.println("I'm a Singleton class");
    }

}
