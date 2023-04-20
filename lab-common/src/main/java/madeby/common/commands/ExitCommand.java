package madeby.common.commands;

public class ExitCommand extends Command {
    @Override
    public CommandResult execute(String arg) {
        return new CommandResult("good bye", true);
    }
}
