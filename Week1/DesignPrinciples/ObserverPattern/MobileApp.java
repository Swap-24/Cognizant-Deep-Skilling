
class MobileApp implements Observer {

    @Override
    public void update(double price) {
        System.out.println("Mobile Price: " + price);
    }
}
