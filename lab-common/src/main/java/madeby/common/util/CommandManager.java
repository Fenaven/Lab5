package madeby.common.util;

import madeby.common.commands.AddCommand;
import madeby.common.commands.ClearCommand;
import madeby.common.commands.Command;
import madeby.common.commands.CommandResult;
import madeby.common.commands.ExecuteScriptCommand;
import madeby.common.commands.ExitCommand;
import madeby.common.commands.FilterStartsWithNameCommand;
import madeby.common.commands.HelpCommand;
import madeby.common.commands.InfoCommand;
import madeby.common.commands.InsertAtCommand;
import madeby.common.commands.NameHaventCommand;
import madeby.common.commands.PrintDescendingCommand;
import madeby.common.commands.RemoveByIdCommand;
import madeby.common.commands.RemoveFirstCommand;
import madeby.common.commands.RemoveLowerCommand;
import madeby.common.commands.SaveCommand;
import madeby.common.commands.ShowCommand;
import madeby.common.commands.SumOfDistanceTravelledCommand;
import madeby.common.commands.UpdateCommand;

import java.util.HashMap;

public class CommandManager {
    private final String path;
    private final CollectionManager collectionManager;
    private final InputManager inputManager;
    private final OutputManager outputManager;
    private final HashMap<String, Command> commands;

    public CommandManager(String path, InputManager inputManager, CollectionManager collectionManager, OutputManager outputManager) {
        this.collectionManager = collectionManager;
        this.inputManager = inputManager;
        this.path = path;
        this.outputManager = outputManager;
        this.commands = new HashMap<>();
        commands.put("help", new HelpCommand());
        commands.put("info", new InfoCommand(collectionManager));
        commands.put("show", new ShowCommand(collectionManager));
        commands.put("add", new AddCommand(collectionManager, inputManager, outputManager));
        commands.put("update", new UpdateCommand(collectionManager, inputManager, outputManager));
        commands.put("remove_by_id", new RemoveByIdCommand(collectionManager, inputManager, outputManager));
        commands.put("clear", new ClearCommand(collectionManager));
        commands.put("save", new SaveCommand(collectionManager, path));
        commands.put("execute_script", new ExecuteScriptCommand(inputManager));
        commands.put("exit", new ExitCommand());
        commands.put("insert_at", new InsertAtCommand(collectionManager, inputManager, outputManager));
        commands.put("remove_first", new RemoveFirstCommand(collectionManager));
        commands.put("remove_lower", new RemoveLowerCommand(collectionManager, inputManager, outputManager));
        commands.put("sum_of_distance_travelled", new SumOfDistanceTravelledCommand(collectionManager));
        commands.put("filter_starts_with_name", new FilterStartsWithNameCommand(collectionManager));
        commands.put("print_descending", new PrintDescendingCommand(collectionManager));
    }


    public CommandResult executeCommand(String name, String arg) {
        return commands.getOrDefault(name, new NameHaventCommand()).execute(arg);
    }


}
