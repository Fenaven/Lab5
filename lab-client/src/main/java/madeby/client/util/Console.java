package madeby.client.util;

import com.google.gson.JsonSyntaxException;
import madeby.common.Exception.DontCorrectJsonException;
import madeby.common.commands.CommandResult;
import madeby.common.data.data_class.Vehicles;
import madeby.common.util.CollectionManager;
import madeby.common.util.CommandManager;
import madeby.common.util.InputManager;
import madeby.common.util.OutputManager;
import madeby.common.util.ParserToNameAndArg;
import madeby.common.util.XmlUtils;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Objects;

public class Console {

    private final String path;
    private final OutputManager outputManager;
    private final CollectionManager collectionManager;
    private final InputManager inputManager;
    private final CommandManager commandManager;

    public Console(String path, OutputManager outputManager, CollectionManager collectionManager, InputManager inputManager, CommandManager commandManager) {
        this.path = path;
        this.outputManager = outputManager;
        this.collectionManager = collectionManager;
        this.inputManager = inputManager;
        this.commandManager = commandManager;
    }

    public void start() throws IllegalArgumentException, JsonSyntaxException, IOException, DontCorrectJsonException, JAXBException {

        XmlUtils xmlUtils = new XmlUtils();
        Vehicles vehicles = xmlUtils.deserialize(path);
        collectionManager.initData(vehicles);
        startCommandCycle();
    }

    private String readNextCommand() {
        outputManager.print(">>>");
        return inputManager.nextLine();
    }

    private void startCommandCycle() {
        CommandResult commandResult;
        do {
            String input = readNextCommand();
            ParserToNameAndArg parserToNameAndArg = new ParserToNameAndArg(input);
            commandResult = commandManager.executeCommand(parserToNameAndArg.getName(), parserToNameAndArg.getArg());
            outputManager.println(commandResult.getResult());
        } while (!Objects.requireNonNull(commandResult).isExit());
    }
}
