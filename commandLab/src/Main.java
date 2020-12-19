public class Main {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        GarageDoor garageDoor = new GarageDoor();
        GarageDoorOpenCommand garageUp = new GarageDoorOpenCommand(garageDoor);
        GarageDoorCloseCommand garageDown = new GarageDoorCloseCommand(garageDoor);

        Light light = new Light();
        LightOnCommand lightOn = new LightOnCommand(light);
        LightOffCommand lightOff = new LightOffCommand(light);

        TV tv = new TV();
        TVOnCommand tvOn = new TVOnCommand(tv);
        TVOffCommand tvOff = new TVOffCommand(tv);

        remoteControl.setCommand(0, garageUp, garageDown);
        remoteControl.setCommand(1, lightOn, lightOff);
        remoteControl.setCommand(2, tvOn, tvOff);

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);

        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);

        remoteControl.onButtonWasPushed(2);
        remoteControl.offButtonWasPushed(2);

        System.out.println("Undo button was pressed");

        remoteControl.undoButtonWasPushed(6);
    }
}