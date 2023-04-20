package madeby.common.commands;

public class NameHaventCommand extends Command {
    @Override
    public CommandResult execute(String arg) {
        return new CommandResult("try use help");
    }
}
