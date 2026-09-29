class Driver extends Entity {

    private int wdc;
    private boolean active;

    Driver(String name) {
        super(name);
        this.wdc = 0;
        this.active = false;
    }

    Driver(String name, int wdc, boolean active) {
        super(name);
        this.wdc = wdc;
        this.active = active;
    }

    int getWdc(){return wdc;}
    String getActive(){
        if(active){
            return "Still Active";
        }else {
            return "Not Active";
        }
    }

    @Override
    public String toString() {
        return "Driver: " + getName();
    }
}
