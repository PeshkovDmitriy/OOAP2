import java.util.Stack;

public class RemoteControl {
    Command[] onCommands;
    Command[] offCommands;

    Stack<Command> undoCommand;

    public RemoteControl() {
        this.onCommands = new Command[3];
        this.offCommands = new Command[3];

        Command noCommand = new NoCommand();
        for (int i = 0; i < 3; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }

        this.undoCommand = new Stack<>();
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
        undoCommand.push(onCommands[slot]);
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
        undoCommand.push(offCommands[slot]);
    }

    public void undoButtonWasPushed(int quantity) {

        for (int i = 0; i < quantity; i++) {

            undoCommand.pop().undo();
        }
    }



}