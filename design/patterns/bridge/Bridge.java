package design.patterns.bridge;
/** 
 * 
 * It'll be inefficient to create Different types of remote for every device
 * TV can have Basic as well as Advanced Remote
 * Radio can have Basic as well as Advanced Remote
 * TVBasicRemote, RadioBasicRemote, TvAdvancecRemote, Ra.....
 * Adding new device makes if difficult and classes grow exponentially
 * Hence we can have device and remote as seperate entities and remote can have has relation with device.
 * i.e, remote is assositated with a specific type of device. Device will have all the operation handled and remote will provide and interface to call them to client
 * Check following example
*/
interface Device {
    int getVolume();
    int setVolume(int v);
}

class Tv implements Device {

    private int volume = 0;

    Tv() {
        this.volume = 20;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public int setVolume(int v) {
        this.volume = v;
        return v;
    }
    

}

class Radio implements Device {

    private int volume = 0;

    Radio() {
        this.volume = 20;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public int setVolume(int v) {
        this.volume = v;
        return v;
    }

}

interface RemoteControl {
    int volumeUp();
    int volumeDown();
}

class BasicsRemoteControl implements RemoteControl {

    protected Device device;

    BasicsRemoteControl(Device t){
        this.device = t;
    }

    @Override
    public int volumeUp() {
        this.device.setVolume(this.device.getVolume() + 1);
        return this.device.getVolume();
    }

    @Override
    public int volumeDown() {
        return this.device.getVolume() - 1;
    }
    
}

class AdvancedRemote extends BasicsRemoteControl {

    AdvancedRemote(Device device) {
        super(device);
    }

    public void mute() {
        System.out.println("Remote: mute");
        super.device.setVolume(0);
    }
}

public class Bridge {
    
}
